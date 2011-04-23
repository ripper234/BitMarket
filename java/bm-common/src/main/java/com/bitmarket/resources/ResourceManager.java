package com.mashlife.resources;

public class ResourceManager {
    private ResourceManager() {
    }

    public final static String RESOURCE_PATH = "com/mashlife/resources";

    public static String getResource(String relativePath) {
        return RESOURCE_PATH + "/" + relativePath;
    }
}
