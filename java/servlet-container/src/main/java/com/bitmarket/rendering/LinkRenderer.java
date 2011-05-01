package com.bitmarket.rendering;

public class LinkRenderer {
    private LinkRenderer(){}

    public static String render(String title, String url) {
        return String.format("<a href='%s'>%s</a>", url, title);
    }
}

