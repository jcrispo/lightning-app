package com.dtn.app.utility;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

public class JsonUtility {

    private JsonUtility() {}

    /**
     * Takes a JSON String and returns a {@code List<Map<String, Object>>}
     *
     * @param json JSON String
     * @return JSON Map List
     */
    public static List<Map<String, Object>> fromJsonToListOfMap(String json) {
        Gson gson = new Gson();
        Type type = new TypeToken<List<Map<String, Object>>>(){}.getType();
        return gson.fromJson(json, type);
    }

    /**
     * Takes a JSON String and returns a {@code Map<String, Object>}
     *
     * @param json JSON String
     * @return JSON Map
     */
    public static Map<String, Object> fromJsonToMap(String json) {
        Gson gson = new Gson();
        Type type = new TypeToken<Map<String, Object>>(){}.getType();
        return gson.fromJson(json, type);
    }

    /**
     * Takes a Java Object and returns a JSON String representation
     *
     * @param obj THE object to turn into JSON
     * @return a JSON String
     */
    public static String toJson(Object obj) {
        Gson gson = new Gson();
        return gson.toJson(obj);
    }
}
