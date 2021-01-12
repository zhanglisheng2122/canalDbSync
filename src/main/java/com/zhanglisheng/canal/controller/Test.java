package com.zhanglisheng.canal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: zhanglisheng
 * @create: 2021-01-11 17:22
 */
@RestController
public class Test {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @RequestMapping("send")
    public void send(){
        kafkaTemplate.send("canaltopic","xxx");
    }
}