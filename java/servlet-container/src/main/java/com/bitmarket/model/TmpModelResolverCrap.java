package com.bitmarket.model;

import org.springframework.web.servlet.ModelAndView;

/**
 * Created by IntelliJ IDEA.
 * User: rgross
 * Date: 4/30/11
 * Time: 2:54 PM
 */
@Deprecated
public class TmpModelResolverCrap {
    private static Object model;
    public static void saveModel(Object model) {
        TmpModelResolverCrap.model = model;
    }
    public static Object readModel() {
        return model;
    }
}
