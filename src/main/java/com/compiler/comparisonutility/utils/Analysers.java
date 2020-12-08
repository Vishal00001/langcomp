package com.compiler.comparisonutility.utils;

import com.compiler.comparisonutility.constants.Institute;
import com.compiler.comparisonutility.constants.Keywords;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by vishal on 26/11/20.
 */
public class Analysers {

    public static String source;
    public static String destination;
    public static String action;
    public static String clientName;
    public static String instiSource;
    public static String instiDestination;
    private static String PRODUCTION = "prod";

    public static void lexicalAnalyser(){

        boolean validity = true;

        if(!Keywords.literals.contains(source)){
            System.out.println("Illegal argument: "+source);
            validity = false;
        }
        if(!Keywords.literals.contains(destination)){
            System.out.println("Illegal argument: "+destination);
            validity = false;
        }
        if(!Keywords.literals.contains(action)){
            System.out.println("Illegal argument: "+action);
            validity = false;
        }

        if(!validity){
            System.out.print("Lexicals analysis failed!\n");
            System.exit(0);
        }else{
            System.out.print("Lexicals analysis completed!\n");
        }
    }

    public static void argsAnalyser(String[] args){

        try{

            source = args[0];
            destination = args[1];
            clientName = args[2];
            action = args[3];
            System.out.print("Analysed Arguments\n");

        }catch(ArrayIndexOutOfBoundsException e){
            System.out.print("Arguments analysis failed!\n");
            System.out.println("Illegal Expressions \n It should be in <source-env> <destination-env> <client-name> <action-name> format.");
            System.exit(0);
        }
    }

    public static void institutionIdAnalyser(){

        if(StringUtils.equalsIgnoreCase(source, PRODUCTION)){
            instiSource = Institute.getProductionId(clientName);
        }else{
            instiSource = Institute.getLowerEnvironmentId(clientName);
        }

        if(StringUtils.equalsIgnoreCase(destination, PRODUCTION)){
            instiDestination = Institute.getProductionId(clientName);
        }else{
            instiDestination = Institute.getLowerEnvironmentId(clientName);
        }
        System.out.print("Institution analysis completed!\n");
    }
}
