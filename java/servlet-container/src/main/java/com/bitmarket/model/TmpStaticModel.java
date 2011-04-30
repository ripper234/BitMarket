package com.bitmarket.model;

import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: rgross
 * Date: 4/30/11
 * Time: 2:54 PM
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
}
