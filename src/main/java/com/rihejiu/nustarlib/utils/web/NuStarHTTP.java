package com.rihejiu.nustarlib.utils.web;

import com.alibaba.fastjson2.JSONObject;

public interface NuStarHTTP {
    String postResponse(JSONObject jsonObject, String url);
    String getResponse(String url);
}
