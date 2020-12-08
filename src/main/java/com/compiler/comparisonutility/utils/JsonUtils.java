package com.compiler.comparisonutility.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Map;

/**
 * Created by vishal on 24/11/20.
 */
public class JsonUtils {

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
