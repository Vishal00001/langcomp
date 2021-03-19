package com.utility.comparisonutility.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by vishal on 25/02/21.
 */
public class JsonUtils {

    private static org.slf4j.Logger logger = LoggerFactory.getLogger(JsonUtils.class);

    private static ObjectMapper mapper = new ObjectMapper();

    /**
     * This method compares the two different strings and returns true when matched.
     * @param string1
     * @param string2
     * @return boolean
     */
    public static boolean jsonEquals(String string1, String string2) throws IOException {

        if(string1.isEmpty() || string2.isEmpty())
            return false;

        ObjectMapper mapper = new ObjectMapper();

        return mapper.readTree(string1).equals(mapper.readTree(string2));
    }

    public static byte[] ObjectToJsonBytes(Object object) throws IOException {
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        return mapper.writeValueAsBytes(object);
    }

    public static <T> T StringToObject(String jsonString, Class<?> type) throws IOException {
        return (T)mapper.readValue(jsonString, type);

    }


    public static HashMap<String,String> ListToMap(List<String> list){



        Map<String,Object> temp = null;
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<Map<String, Object>> type = new TypeReference<Map<String, Object>>() {};

        Map<String,String> mp = new HashMap<>();

        for(String s : list){
            temp = JsonUtils.stringToMap(s);
            Object key = temp.get("dropDownType");
            mp.put((String) key,s);
        }




        return (HashMap<String, String>) mp;
    }

    public static Map<String,Object> stringToMap(String string) {
        TypeReference<HashMap<String, Object>> type = new TypeReference<HashMap<String, Object>>() {};
        Map<String,Object> map = null;
        try {

            map = mapper.readValue(string, type);
            return map;
        }catch (JsonProcessingException e) {
            logger.error("Exception occurred while conveting to Map: {}", e.getStackTrace());
            map.put("HAS_EXCEPTION", e.getStackTrace());
        }

        return map;

    }



    public static String ObjectToString(Object object) throws JsonProcessingException {
        return mapper.writeValueAsString(object);
    }

    public static <T> T MapToObject(Map<String, Object> map, Class<?> type) throws IOException {
        // convert map to JSON string
        String json = mapper.writeValueAsString(map);
        return StringToObject(json, type);
    }

    public static <T> T MapToObjectList(Map<String, Object> map, Class<?> type) throws IOException {
        // convert map to JSON string
        String json = mapper.writeValueAsString(map);

        return StringToObject(json, type);
    }
}
