package com.bglobal.linkage.support;

public class RandomUUID {
    public static String generate() {
        return java.util.UUID.randomUUID().toString().replace("-", "");
    }
}
