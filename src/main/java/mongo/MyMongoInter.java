package mongo;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public interface MyMongoInter {
    public MongoClient connectToMongoFromURL(String url);

    public MongoDatabase getMongoDatebase(String mongoClient, String nameDatabase);

    public MongoCollection<Document> getCollection(String mongoClient, String nameDatabase, String Collection);
}
