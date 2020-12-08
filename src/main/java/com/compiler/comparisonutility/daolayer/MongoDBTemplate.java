package com.compiler.comparisonutility.daolayer;


import com.mongodb.DB;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDbFactory;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.WriteResultChecking;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by vishal on 23/11/20.
 */
public class MongoDBTemplate {

    private static Map<String, String> mongoUrls = new HashMap();
    private String source, destination;
    private static String DB_NAME = "gonogo_sme";
    private MongoTemplate sourceMongoTemplate, destinationMongoTemplate;


    {
        mongoUrls.put("dev","mongodb://localhost:27017/gonogo_sme?waitqueuemultiple=10&w=1&maxpoolsize=50&safe=true");
        mongoUrls.put("sit","mongodb://gngsmerw_sit:gngsmerw272@sitmodb01.serviceurl.in/gonogo_sme?waitqueuemultiple=10&w=1&maxpoolsize=50&safe=true");
        mongoUrls.put("uat","mongodb://gngsmerw_uat:gngsmerw272@uatmodb01.softcell.in,uatmodb02.softcell.in,uatmodb03.softcell.in/gonogo_sme?waitqueuemultiple=10&w=1&maxpoolsize=50&safe=true");
        mongoUrls.put("preprod","mongodb://sme_wr:leviosa@ssgpreprodmd.serviceurl.in/gonogo_sme?waitqueuemultiple=10&w=1&maxpoolsize=50&safe=true");
        mongoUrls.put("prod","mongodb://sme_wr:leviosa@gonogo_sme/mongomumprod12.serviceurl.in:27017,mongomumprod13.serviceurl.in:27017,mongomumprod14.serviceurl.in:27017/gonogo_sme?waitqueuemultiple=10&w=1&maxpoolsize=50&safe=true");
    }

    public MongoDBTemplate(String source, String destination){
        System.out.print("Mongo template initialization started!\n");
        this.source = source;
        this.destination = destination;
    }

    public void connect(){
        try {
            System.out.print("Connecting database...\n");
            this.sourceMongoTemplate = mongoTemplate(MongoDBTemplate.mongoUrls.get(source));
            this.destinationMongoTemplate = mongoTemplate(MongoDBTemplate.mongoUrls.get(destination));
            System.out.print("Database connected!\n");
        } catch (Exception e) {
            System.out.print("Database connectivity failed!\n");
            System.err.print(e.getStackTrace());
        }
    }

    public MongoTemplate mongoTemplate(String uri) throws Exception {

        MongoClient mongoClient = MongoClients.create(uri);

       // MongoDbFactory mongoDbFactory = new SimpleMongoClientDbFactory(mongoClient);

        MongoTemplate mongoTemplate = new MongoTemplate(mongoClient, DB_NAME);

        mongoTemplate.setWriteResultChecking(WriteResultChecking.EXCEPTION);

        return mongoTemplate;
    }

    public MongoTemplate getSourceTemplate(){
        return this.sourceMongoTemplate;
    }

    public MongoTemplate getDestinationTemplate(){
        return this.destinationMongoTemplate;
    }

}
