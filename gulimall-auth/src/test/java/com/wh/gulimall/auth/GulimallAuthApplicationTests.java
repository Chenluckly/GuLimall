package com.wh.gulimall.auth;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wh.common.utils.HttpUtils;
import com.wh.gulimall.auth.vo.SocialUser;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

class GulimallAuthApplicationTests {

    public static void main(String[] args) throws Exception {

        String Access_token="1d23abbd3b7a6b5a3ea8c2777653bb6e";
        Map<String,String> query = new HashMap<>();
        query.put("access_token",Access_token);
        HttpResponse response = HttpUtils.doGet("https://gitee.com", "/api/v5/user", "get", new HashMap<String, String>(), query);
        String json = EntityUtils.toString(response.getEntity());
        JSONObject jsonObject = JSON.parseObject(json);
        String id = jsonObject.getString("id");
        System.out.println(id);

    }




}
