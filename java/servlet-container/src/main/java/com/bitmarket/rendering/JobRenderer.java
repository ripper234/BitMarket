package com.bitmarket.rendering;

public class JobRenderer {
    private JobRenderer(){}

    public static String linkify(long id, String prefix) {
        return prefix + "jobs/showJob.do";
    }
}
