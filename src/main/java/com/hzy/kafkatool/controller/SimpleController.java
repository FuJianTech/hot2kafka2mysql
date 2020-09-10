package com.hzy.kafkatool.controller;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author: arnold_nie
 * @date: 2020/8/18 21:08
 * FileName: SimpleController
 * Description:
 */
@RestController
public class SimpleController {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @GetMapping("/send/{messge}")
    public String send(@PathVariable String messge) {
        kafkaTemplate.send("topic1", "topci1:" + messge);
        kafkaTemplate.send("topic2", "topci2:" + messge);
        return messge;
    }

    /**
     * 发送消息三种策略
     * 轮询策略（默认），随机策略，和按键保存策略（带 key 发送，计算这个 key 的 hashCode 值，按照 hashCode 的值对不同消息进行存储。）
     * @param topic
     * @param msg
     * @return
     * 如果需要顺序发送消息到 kafka（类似队列），则使用按键保存策略，发送数据时都指定相同的键
     */
    @GetMapping("/send2/{topic}/{msg}")
    public String send2(@PathVariable("topic") String topic, @PathVariable("msg") String msg) {
    /*    //发送带有时间戳的消息
        kafkaTemplate.send(topic, 0, System.currentTimeMillis(), "0", msg);

        //使用ProducerRecord发送消息
        ProducerRecord record = new ProducerRecord(topic, msg);
        kafkaTemplate.send(record);*/

        //使用Message发送消息
        Map map = new HashMap();
        map.put(KafkaHeaders.TOPIC, topic);
        map.put(KafkaHeaders.PARTITION_ID, 0);
        map.put( KafkaHeaders.MESSAGE_KEY, UUID.randomUUID().toString());
        GenericMessage message = new GenericMessage(msg,new MessageHeaders(map));
        kafkaTemplate.send(message);
        return msg;
    }


}
