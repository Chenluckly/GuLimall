package com.wh.gulimall.member;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;



/**
 * 1.想要远程调用别的服务
 *    1.1.引入open-feign依赖
 * 2.编写一个接口，靠苏spring cloud这个接口需要调用远程服务
 *    2.1 声明接口的每一个方法都是调用远程服务的那个请求
 * 3.开启远程调用功能
 */
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.wh.gulimall.member.feign")
@SpringBootApplication
public class GulimallMemberApplication {

    public static void main(String[] args) {
        SpringApplication.run(GulimallMemberApplication.class, args);
    }

}