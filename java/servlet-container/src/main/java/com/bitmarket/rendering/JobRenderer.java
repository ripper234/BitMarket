package com.bitmarket.rendering;

public class JobRenderer {
    private JobRenderer(){}

    public static String render(long id, String anchor) {
        return LinkRenderer.render(anchor, linkify(id, "../"));
    }
    public static String linkify(long id, String prefix) {
        return prefix + "jobs/showJob.do?jobId=" + id;
    }
}
