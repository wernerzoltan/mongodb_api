package com.example.mongoapi;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.MongoClient;

import org.bson.Document;

public class Connector {

    final int port_num = 27017;
    String auth_user = "", auth_pwd = "", 
    host_name = "",
    db_name = "teszt", db_col_name = "students", encoded_pwd = "";

    public List<Document> mongoConnector() {
        
        try{
            encoded_pwd = URLEncoder.encode(auth_pwd, "UTF-8");
        } catch (UnsupportedEncodingException ex) {
            System.out.println(ex);
        } 

        MongoClientURI url = new MongoClientURI(host_name);
        MongoClient mongoClient = new MongoClient(url);
        MongoDatabase mongoDatabase = mongoClient.getDatabase(db_name);
        MongoCollection<Document> mongoCollection = mongoDatabase.getCollection(db_col_name);

        List<Document> documents = mongoCollection.find().into(new ArrayList<>());

        for(Document document : documents) {
            System.out.println(document);
        }

        return documents;

    }

}