package com.dtn.app.utility;

import java.util.Map;

public class MapUtility {

    private MapUtility() {}

    public static Integer getMapIntegerValue(Map<String, Object> data, String key) {
        Float val = getMapFloatValue(data, key);
        return val == null ? null : val.intValue();
    }

    public static Long getMapLongValue(Map<String, Object> data, String key) {
        Double val = getMapDoubleValue(data, key);
        return val == null ? null : val.longValue();
    }

    public static Float getMapFloatValue(Map<String, Object> data, String key) {
        if (data == null || data.isEmpty() || data.get(key) == null) return null;

        return Float.valueOf(data.get(key).toString());
    }

    public static Double getMapDoubleValue(Map<String, Object> data, String key) {
        if (data == null || data.isEmpty() || data.get(key) == null) return null;

        return Double.valueOf(data.get(key).toString());
    }

    public static String getMapStringValue(Map<String, Object> data, String key) {
        if (data == null || data.isEmpty() || data.get(key) == null) return null;

        return data.get(key).toString();
    }
}
