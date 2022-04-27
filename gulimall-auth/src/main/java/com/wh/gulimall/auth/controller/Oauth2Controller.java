package com.wh.gulimall.auth.controller;

import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.JSON;
import com.wh.common.utils.R;
import com.wh.gulimall.auth.feign.MemberFeignService;
import com.wh.common.vo.MemberRespVo;
import com.wh.gulimall.auth.vo.SocialUser;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * 处理社交登录请求
 * @author yaoxinjia
 */
@Slf4j
@Controller
public class Oauth2Controller {
    @Autowired
    private MemberFeignService memberFeignService;

    @GetMapping("/oauth2/weibo/success")
    public String weibo(@RequestParam("code") String code,HttpSession session) throws Exception {
        Map<String, String> header = new HashMap<>();
        Map<String, String> query = new HashMap<>();

        String url = "https://api.weibo.com/oauth2/access_token?client_id=1672537800&client_secret=6f7f8d10cf800ea1fb8586d8fe48b379&grant_type=authorization_code&redirect_uri=http://auth.gulimall.com/oauth2/weibo/success&code=" +code;
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost httpPost = new HttpPost(url);
        HttpResponse response = httpClient.execute(httpPost);

//        Map<String, String> map = new HashMap<>();
//        map.put("client_id", "1672537800");
//        map.put("grant_type", "authorization_code");
//        map.put("client_secret", "6f7f8d10cf800ea1fb8586d8fe48b379");
//        map.put("redirect_uri", "http://auth.gulimall.com/oauth2/weibo/success");
//        map.put("code", code);

//        HttpResponse response = HttpUtils.doPost("https://api.weibo.com", "/oauth2/access_token", "post", header, query, map);
        if (response.getStatusLine().getStatusCode() == 200) {
            String json = EntityUtils.toString(response.getEntity());
            SocialUser socialUser = JSON.parseObject(json, SocialUser.class);

            //知道当前是哪个社交用户登录成功
            //1、当前用户如果是第一次进网站，就自动注册进来（为当前社交用户生成一个会员信息账号,以后这个社交账号就对应指定的会员）
            //登录或者注册这个社交用户
            R r = memberFeignService.oauth2Login(socialUser);
            if (r.getCode()==0){
                MemberRespVo data = r.getData("data",new TypeReference<MemberRespVo>() {});
                log.info("登录成功，用户信息：" + data);
                //TODO 1、默认发的令牌 session=dadas,作用域只是当前域，（解决子域与父域session共享问题）
                //TODO 2、使用json的序列化方式来序列化对象数据到redis中
                session.setAttribute("loginUser",data);
                //2、登录成功就跳回首页
                return "redirect:http://gulimall.com";
            } else {
                return "redirect:http://auth.gulimall.com/login.html";
            }

        } else {

            return "redirect:http://auth.gulimall.com/login.html";
        }
    }
}


