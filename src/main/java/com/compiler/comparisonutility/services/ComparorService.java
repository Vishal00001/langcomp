package com.compiler.comparisonutility.services;

import com.compiler.comparisonutility.constants.CollectionNames;
import com.compiler.comparisonutility.daolayer.ApplicationRepository;
import com.compiler.comparisonutility.utils.FileUtils;
import com.compiler.comparisonutility.utils.JsonUtils;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;

import java.io.IOException;

/**
 * Created by vishal on 23/11/20.
 */
public class ComparorService {

    private MongoTemplate source, destination;
    private String instIdSource, instIdDestination;

    public ComparorService(MongoTemplate source, MongoTemplate destination, String instIdSource, String instIdDestination){

        this.source = source;
        this.destination = destination;
        this.instIdSource = instIdSource;
        this.instIdDestination = instIdDestination;
    }

    public void compareSingleDocument() {

        try {

            for (String collName : CollectionNames.singleDocCollections) {
                String sourceString = getData(this.source, instIdSource, collName);
                String desString = getData(this.destination, instIdDestination, collName);
                Boolean isEqual = JsonUtils.jsonEquals(sourceString, desString);

                if(isEqual){
                    FileUtils.fileWriter(collName+" successfully screened and passed.\n");
                }else{
                    FileUtils.fileWriter(collName+" failed while screening\n");
                }
            }
        } catch (IOException e) {
            System.err.print(e.getStackTrace());
        }
    }

    private String getData(MongoTemplate mongoTemplate, String institutionId, String collectionsName){

        ApplicationRepository mongo = new ApplicationRepository(mongoTemplate);
        Criteria criteria = Criteria.where("_id").is(institutionId);
        return mongo.findOne(criteria, collectionsName);
    }

}
