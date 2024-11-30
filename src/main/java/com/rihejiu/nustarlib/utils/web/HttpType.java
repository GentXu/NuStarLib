package com.rihejiu.nustarlib.utils.web;


public enum HttpType {
    OKHTTP,
    UNIREST;

    public static HttpType getHttpType(String type)
    {
        if (type.equalsIgnoreCase("okhttp"))
        {
            return OKHTTP;
        }
        else if (type.equalsIgnoreCase("unirest"))
        {
            return UNIREST;
        }
        else
        {
            return null;
        }
    }
}
