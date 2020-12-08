package com.compiler.comparisonutility.controllers;

import com.compiler.comparisonutility.daolayer.MongoDBTemplate;
import com.compiler.comparisonutility.services.ComparorService;
import com.compiler.comparisonutility.utils.Analysers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by vishal on 27/11/20.
 */
public class ServiceController {

    private static String action;

    @Autowired
    public ComparorService comparorService;

    private MongoTemplate sourceTemp, desTemp;

    public ServiceController(String action){

        System.out.print("Service controller initialization done!\n");
        MongoDBTemplate mongoDBTemplate = new MongoDBTemplate(Analysers.source, Analysers.destination);
        mongoDBTemplate.connect();
        sourceTemp = mongoDBTemplate.getSourceTemplate();
        desTemp = mongoDBTemplate.getDestinationTemplate();
        this.action = action;
    }

    public void execute(){

        try{

            switch (this.action){

                case "compare":{
                    ComparorService comparorService = new ComparorService(sourceTemp, desTemp, Analysers.instiSource, Analysers.instiDestination);
                    comparorService.compareSingleDocument();
                }

            }

        }catch(Exception e){
            System.err.print(e.getStackTrace());
        }

    }
}
