package com.zhanglisheng.canal.deploy;

import com.alibaba.fastjson.JSON;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: zhanglisheng
 * @create: 2021-01-11 15:03
 */
@Component
public class KafkaConsumer {

    // 消费监听
    @KafkaListener(topics = {"canaltopic"})
    public void onMessage1(ConsumerRecord<?, ?> record){
        // 消费的哪个topic、partition的消息,打印出消息内容
        System.out.println("简单消费："+record.topic()+"-"+record.partition()+"-"+record.value());

        CanalBean canalBean = JSON.parseObject(record.value().toString(),CanalBean.class);
        System.out.println(canalBean.getTable());

    }
}