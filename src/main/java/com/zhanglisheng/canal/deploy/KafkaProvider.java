package com.zhanglisheng.canal.deploy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: zhanglisheng
 * @create: 2021-01-11 15:03
 */
@Component
public class KafkaProvider {
    @Autowired
    private KafkaTemplate kafkaTemplate;


    public void send(){
        kafkaTemplate.send("canaltopic","msg");
    }
}