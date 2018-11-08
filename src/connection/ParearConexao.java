package connection;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class ParearConexao {
    private static MongoClient mongo;
    private static MongoCollection<Document> collection;
    
    public static MongoDatabase conectar(){
        mongo = new MongoClient("localhost",27017);
        return mongo.getDatabase("aps_bd");
    }
    
    public static void fechar(){
        mongo.close();
    }
}
