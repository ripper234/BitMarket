package com.bitmarket.resources;

public class ResourceManager {
    private ResourceManager() {
    }

    public final static String RESOURCE_PATH = "com/bitmarket/resources";

    public static String getResource(String relativePath) {
        return RESOURCE_PATH + "/" + relativePath;
    }
}
