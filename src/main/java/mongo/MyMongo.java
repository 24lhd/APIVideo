package mongo;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class MyMongo extends MongoClient implements MyMongoInter {


    @Override
    public MongoClient connectToMongoFromURL(String url) {
//        MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
        MongoClient mongoClient = new MongoClient(new MongoClientURI(url));
        return mongoClient;
    }

    @Override
    public MongoDatabase getMongoDatebase(String mongoClient, String nameDatabase) {
        return connectToMongoFromURL(mongoClient).getDatabase(nameDatabase);
    }

    @Override
    public MongoCollection<Document> getCollection(String mongoClient, String nameDatabase, String collection) {
        return getMongoDatebase(mongoClient, nameDatabase).getCollection(collection);
    }


}
