package com.rihejiu.nustarlib.utils.web;

import com.alibaba.fastjson2.JSONObject;
import okhttp3.*;

import java.io.IOException;

public class OkHttp implements NuStarHTTP{
    private final OkHttpClient okHttpClient = new OkHttpClient();
    public OkHttp(){
        getResponse("http://47.103.131.3:7943/myauth/web/connect");
    }
    @Override
    public String postResponse(JSONObject jsonObject, String url) {
        MediaType mediaType = MediaType.parse("application/json; charset=utf-8");
        RequestBody body = RequestBody.create(jsonObject.toJSONString(), mediaType);
        Request request = new Request.Builder()
                .url(url)
                .header("User-Agent", "Apifox/1.0.0 (https://apifox.com)")
                .header("Content-Type", "application/json")
                .post(body)
                .build();
        try (Response response = okHttpClient.newCall(request).execute()) {
            if (response.isSuccessful()) {
                return response.body().string();  // 返回响应体内容
            } else {
                throw new IOException("Unexpected code " + response);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public String getResponse(String url) {
        MediaType mediaType = MediaType.parse("text/plain");
        RequestBody body = RequestBody.create("", mediaType);
        Request request = new Request.Builder()
                .url(url)
                .method("GET", null)
                .addHeader("User-Agent", "Apifox/1.0.0 (https://apifox.com)")
                .build();
        try (Response response = okHttpClient.newCall(request).execute()) {
            if (response.isSuccessful()) {
                return response.body().string();  // 返回响应体内容
            } else {
                throw new IOException("Unexpected code " + response);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
