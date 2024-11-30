package com.rihejiu.nustarlib.utils.web;

import com.alibaba.fastjson2.JSONObject;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

public class UnirestHttp implements NuStarHTTP{
    public UnirestHttp() {
        getResponse("http://47.103.131.3:7943/myauth/web/connect");
    }
    @Override
    public String postResponse(JSONObject jsonObject, String url) {
        HttpResponse<String> response = Unirest.post(url)
                .header("User-Agent", "Apifox/1.0.0 (https://apifox.com)")
                .header("Content-Type", "application/json")
                .body(jsonObject)
                .asString();
        return response.getBody();
    }
    @Override
    public String getResponse(String url) {
        HttpResponse<String> response = Unirest.get(url)
                .header("User-Agent", "Apifox/1.0.0 (https://apifox.com)")
                .asString();
        return response.getBody();
    }
}
