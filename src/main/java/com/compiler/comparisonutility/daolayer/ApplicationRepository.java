package com.compiler.comparisonutility.daolayer;

import com.compiler.comparisonutility.utils.JsonUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by vishal on 24/11/20.
 */
public class ApplicationRepository {

   MongoTemplate mongoTemplate;

   private static String INSTITUTION_ID = "institutionId";

   public ApplicationRepository(MongoTemplate mongoTemplate){
      this.mongoTemplate = mongoTemplate;
   }

   public String findOne(Criteria criteria, String collectionName){
      String result = "";
      Query query = new Query();
      query.addCriteria(criteria);
      query.fields().exclude(INSTITUTION_ID);

      try {

         Object document = mongoTemplate.findOne(query, Object.class, collectionName);
         result = JsonUtils.ObjectToString(document);

      } catch (JsonProcessingException e) {
         e.printStackTrace();
      }
      return result;
   }

   public List<String> find(Criteria criteria, String collectionName){
      List<String> result = new LinkedList<>();

      Query query = new Query();
      query.addCriteria(criteria);
      query.fields().exclude(INSTITUTION_ID);

      try {

         Object documentList = mongoTemplate.find(query, Object.class, collectionName);

         if(documentList instanceof List){

            for(Object object : (List)documentList){
               result.add(JsonUtils.ObjectToString(object));
            }
         }

      } catch (JsonProcessingException e) {
         e.printStackTrace();
      }
      return result;
   }
}
