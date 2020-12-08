package com.compiler.comparisonutility.constants;


import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by ssg408 on 19/9/18.
 */
public enum Institute {

    DEFAULT("00", "00", "DEFAULT"),
    SBFC("4075", "4021", "SBFC"),
    JVFS("4084", "4025", "JVFS"),
    FVSG("4080", "4033","FVSG" ),
    SARVJAN("4132", "", "SARV"),
    AVFS("4141","4066","AVFS"),
    CNTM("4155","4155", "CNTM"),
    EFLC("4097","4035", "EFLC"),
    TMFL("4139","4061", "TMFL"),
    ABFL("4032", "3995", "ABFL"),
    ABMU("4149", "4054", "ABMU"),
    NITS("4156","4072","NITS"),
    HDFC("4010","3989","HDFC"),
    SELFIN("4157","4157","SELFIN"),
    PFPL("4175","4070","PFPL"),
    AMBT("4160","4161","AMBT"),  //Change the prod institutionId once recieved
    FBL("4144","4140","FBL");   //Change the prod institutionId once recieved

    private final String lowerEnvrment;
    private final String production;
    private final String name;

    static final private Map<String,String > ID_MAP = new HashMap<>();

    static {
        for(Institute institute :  Institute.values()){
            ID_MAP.put(institute.lowerEnvrment,institute.name);
            ID_MAP.put(institute.production,institute.name);
        }
    }

    Institute(final String lowerEnvrment, final String production, final String name) {
        this.lowerEnvrment = lowerEnvrment;
        this.production = production;
        this.name = name;
    }

    /**
     * method to return enum constants, face values
     *
     * @return
     */
    public String toLowerEnvId() {return lowerEnvrment;}

    public String toProductionId() {
        return production;
    }

    public static boolean isInstitute(String institutionId, Institute institute){
        if(StringUtils.equalsIgnoreCase(institutionId, institute.lowerEnvrment)
                || StringUtils.equalsIgnoreCase(institutionId, institute.production)){
            return true;
        }
        return false;
    }

    public static String instituteName(String institutionId) {
        return ID_MAP.get(institutionId);
    }

    public static Institute fromStringValue(String value){

        for(Institute inst : values()){
            if(inst.name.equalsIgnoreCase(value)){
                return inst;
            }
        }
        return null;
    }


    public static String getLowerEnvironmentId(String institutionName){
        if(StringUtils.isNotEmpty(institutionName)){
            for(Institute inst : values()){
                if(inst.name.equalsIgnoreCase(institutionName)){
                    return inst.toLowerEnvId();
                }
            }
        }
        return null;
    }

    public static String getProductionId(String institutionName){
        if(StringUtils.isNotEmpty(institutionName)){
            for(Institute inst : values()){
                if(inst.name.equalsIgnoreCase(institutionName)){
                    return inst.toProductionId();
                }
            }
        }
        return null;
    }
}
