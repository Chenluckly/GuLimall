package com.wh.gulimall.order;

import com.wh.gulimall.order.entity.RefundInfoEntity;
import com.wh.gulimall.order.entity.bbb;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
class GulimallOrderApplicationTests {

    @Autowired
    AmqpAdmin amqpAdmin;

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Test
    public void sendMessage(){
        bbb bbb = new bbb();
        bbb.setAge(123);
        bbb.setEmail("2583661719@qq.com");
        bbb.setName("强子");
        rabbitTemplate.convertAndSend("java-Ecchange","hello.java",bbb);
    }

    @Test
    public void creatExchange(){
        DirectExchange directExchange = new DirectExchange("java-Ecchange",true,false);
        amqpAdmin.declareExchange(directExchange);
        log.info("交换机创建成功");
    }

    @Test
    public void creatQueue(){
        Queue queue = new Queue("java-Queue",true,false,false);
        amqpAdmin.declareQueue(queue);
        log.info("队列创建成功");


    }

    @Test
    public void creatBinding(){
        Binding binding = new Binding("java-Queue",Binding.DestinationType.QUEUE,"java-Ecchange","hello.java",null);
        amqpAdmin.declareBinding(binding);
        log.info("绑定创建成功");


    }

}
