package com.bitmarket.model;

import java.util.HashMap;
import java.util.Map;

/**
 */
@Deprecated
public class TmpStaticModel {
    private final static Map<String, Object> modelMap = new HashMap<String, Object>();
    public static void saveModel(String key, Object model) {
        modelMap.put(key, model);
    }
    public static <T> T readModel(String key) {
        return (T)modelMap.get(key);
    }

    public static void saveModel(Map<String, Object> model) {
        for (Map.Entry<String, Object> entry : model.entrySet()) {
            modelMap.put(entry.getKey(), entry.getValue());
        }
    }
}
