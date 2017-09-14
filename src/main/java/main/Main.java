package main;

import com.google.gson.Gson;
import com.mongodb.client.MongoCollection;
import item.ItemCategory;
import item.ItemVideo;
import mongo.MyMongo;
import obj.Config;
import org.bson.BsonDocument;
import org.bson.BsonString;
import org.bson.Document;
import parser.*;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/*
   Date date = new Date();
 Calendar cal = Calendar.getInstance();
 cal.setTime(date);
 int year = cal.get(Calendar.YEAR);
 int month = cal.get(Calendar.MONTH);
 int day = cal.get(Calendar.DAY_OF_MONTH);
 int hour = cal.get(Calendar.HOUR);
 int minute = cal.get(Calendar.MINUTE);
 System.out.println(year);
 System.out.println(month);
 System.out.println(day);
 System.out.println(hour);
 System.out.println(minute);
 */
public class Main {
    public static final String URL_MONGO = "mongodb://24duong:Haiduong24@ds053184.mlab.com:53184/videos";
    public static final String DB_NAME = "videos";
    public static final String COLL_CATE = "categorys";
    public static final String COLL_VIDEO = "videos";
    static Gson gson = new Gson();

    /*
    - xóa dữ liệu category trước rồi thêm vào để cập nhật lại khi update bản code mới
    - đặt lịch chạy lấy dữ liệu video và đẩy lên database
    - lấy dữ liệu video kiểm tra xem link video đó đẫ có trên server chưa, có rồi thì thôi còn chưa có thì thêm vào database
     */
    public static void main(String[] args) {

        MyMongo myMongo = new MyMongo();
        // quản lý bảng video
        MongoCollection<Document> documentMongoCollection = myMongo.getCollection(URL_MONGO, DB_NAME, COLL_VIDEO);
        // quản lý bảng categorys
        MongoCollection<Document> collectionCategory = myMongo.getCollection(URL_MONGO, DB_NAME, COLL_CATE);

        collectionCategory.deleteMany(new BsonDocument()); // xóa hết dữ liệu bảng categorys
        // chèn dữ liệu vào bảng category
        for (ItemCategory itemCategory : Config.getListCategorys()) {
            collectionCategory.insertOne(Document.parse(gson.toJson(itemCategory)));
        }

        // khởi tạo đối tượng hẹn lịch chạy lấy dữ liệu video
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        scheduler.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("Chạy");
                runPutVnExpress(documentMongoCollection);
                runPutDanTri(documentMongoCollection);
                runPut14h(documentMongoCollection);
                runPutVietnamnet(documentMongoCollection);
                runPutNewZing(documentMongoCollection);
            }
        }, 0, 5, TimeUnit.MINUTES);
    }

    private static void runPutNewZing(MongoCollection<Document> documentMongoCollection) {
        for (ItemVideo itemVideo : new ParserNewZing().getListVideos()) {
            putItemVideoWhenNotExists(itemVideo, documentMongoCollection);
        }
    }

    private static void runPutVietnamnet(MongoCollection<Document> documentMongoCollection) {
        for (ItemVideo itemVideo : new ParserVietnamnet().getListVideos()) {
            putItemVideoWhenNotExists(itemVideo, documentMongoCollection);
        }
    }

    private static void runPut14h(MongoCollection<Document> documentMongoCollection) {
        for (ItemVideo itemVideo : new Parser24h().getListVideos()) {
            putItemVideoWhenNotExists(itemVideo, documentMongoCollection);
        }
    }


    private static void runPutDanTri(MongoCollection<Document> documentMongoCollection) {
        for (ItemVideo itemVideo : new ParserDanTri().getListVideos()) {
            putItemVideoWhenNotExists(itemVideo, documentMongoCollection);
        }
    }

    private static void runPutVnExpress(MongoCollection<Document> documentMongoCollection) {
        for (ItemVideo itemVideo : new ParserVnExpress().getListVideos()) {
            putItemVideoWhenNotExists(itemVideo, documentMongoCollection);
        }
    }

    /*
        chèn video vào database khi kiểm tra nó không tồn tại trên server
    */
    private static void putItemVideoWhenNotExists(ItemVideo itemVideo, MongoCollection<Document> documentMongoCollection) {
        boolean isExist = documentMongoCollection.find(new BsonDocument().append("idVideo",
                new BsonString(itemVideo.getIdVideo() + ""))).iterator().hasNext();
        if (isExist == false && itemVideo.getIdVideo().isEmpty() == false && itemVideo.getLinkVideo().isEmpty() == false) {
            documentMongoCollection.insertOne(Document.parse(gson.toJson(itemVideo)));
        }
    }
}
