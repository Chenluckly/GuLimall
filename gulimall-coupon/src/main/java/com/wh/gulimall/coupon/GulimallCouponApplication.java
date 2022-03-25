package com.wh.gulimall.coupon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


/**
 * 如何使用Nacos作为配置中心统一管理配置
 *
 *  1.引入依赖
 *    <dependency>
 *             <groupId>org.springframework.cloud</groupId>
 *             <artifactId>spring-cloud-starter-bootstrap</artifactId>
 *             <version>3.1.1</version>
 *    </dependency>
 *    2.创建bootrap.propeties文件：
 *      spring.application.name=服务名称
 *      spring.cloud.nacos.config.server-addr=127.0.0.1:8848（Nacos地址）
 *    2.在方法主类上添加@RefreshScope注解，使用@Value获取属性值
 *    3.在Nacos中添加配置文件
 *       1.文件Id为 eg：Loading nacos data, dataId: 'gulimall-coupon.properties'  dataid后的名称
 *       2.什莫配置文件后缀就选什么类型
 *    4.优先使用Nacos的配置属性，这样便可以动态刷新配置
 *
 *2、细节
 *    1）、命名空间：配置隔离；
 *        默认：public(保留空间)；默认新增的所有配置都在public空间。
 *        1、开发，测试，生产：利用命名空间来做环境隔离。
 *          注意：在bootstrap.properties；配置上，需要使用哪个命名空间下的配置，
 *           spring.cloud.nacos.config.namespace=9de62e44-cd2a-4a82-bf5c-95878bd5e871（Nacos命名空间Id）
 *        2、每一个微服务之间互相隔离配置，每一个微服务都创建自己的命名空间，只加载自己命名空间下的所有配置
 *
 *    2）、配置集：所有的配置的集合
 *
 *    3）、配置集ID：类似文件名。
 *        Data ID：类似文件名
 *
 *    4）、配置分组：
 *        默认所有的配置集都属于：DEFAULT_GROUP；
 *      1111，618，1212
 *
 *  项目中的使用：每个微服务创建自己的命名空间，使用配置分组区分环境，dev，test，prod
 *
 *  3、同时加载多个配置集
 *  1)、微服务任何配置信息，任何配置文件都可以放在配置中心中
 *  2）、只需要在bootstrap.properties说明加载配置中心中哪些配置文件即可
 *  3）、@Value，@ConfigurationProperties。。。
 *  以前SpringBoot任何方法从配置文件中获取值，都能使用。
 *  配置中心有的优先使用配置中心中的，
 *
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
public class GulimallCouponApplication {

    public static void main(String[] args) {
        SpringApplication.run(GulimallCouponApplication.class, args);
    }

}
