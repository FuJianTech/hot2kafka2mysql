package com.hzy.kafkatool.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hzy.kafkatool.entity.HotMessage;
import com.hzy.kafkatool.mapper.MessageMapper;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

/**
 * @author: arnold_nie
 * @date: 2020/8/18 21:07
 * FileName: SimpleListener
 * Description:
 */
@Component
public class SimpleListener {

    @Autowired
    private MessageMapper msgService;

    private Gson gson = new GsonBuilder().create();

    @KafkaListener(topics = {"DOUYIN_HOT"})
    public void listen1(ConsumerRecord<String, HotMessage> record, Acknowledgment ack) {
        System.out.println(record.value());
        HotMessage msg = gson.fromJson(String.valueOf(record.value()), HotMessage.class);
        //JSONObject jsonObject=JSONObject.parseObject(record.value());
        //HotMessage msg = JSONObject.toJavaObject(jsonObject,HotMessage.class);
        System.out.println(msg);
        msgService.insert(msg);
        //msgService.install(msg);
        ack.acknowledge();
    }

    @KafkaListener(topics = {"BAIDU_HOT"})
    public void listen2(ConsumerRecord<String, HotMessage> record, Acknowledgment ack) {
        System.out.println(record.value());
        HotMessage msg = gson.fromJson(String.valueOf(record.value()), HotMessage.class);
        //JSONObject jsonObject=JSONObject.parseObject(record.value());
        //HotMessage msg = JSONObject.toJavaObject(jsonObject,HotMessage.class);
        System.out.println(msg);
        msgService.insert(msg);
        //msgService.install(msg);
        ack.acknowledge();
    }
    @KafkaListener(topics = "${spring.kafka.producer.myTopic1}")
    public void myListen1(ConsumerRecord<String, HotMessage> record, Acknowledgment ack) {
        System.out.println(record.value());
        HotMessage msg = gson.fromJson(String.valueOf(record.value()), HotMessage.class);
        //JSONObject jsonObject=JSONObject.parseObject(record.value());
        //HotMessage msg = JSONObject.toJavaObject(jsonObject,HotMessage.class);
        System.out.println(msg);
        msgService.insert(msg);
        //msgService.install(msg);
        ack.acknowledge();
    }
    @KafkaListener(topics = "${spring.kafka.producer.myTopic2}")
    public void myListen2(ConsumerRecord<String, HotMessage> record, Acknowledgment ack) {
        System.out.println(record.value());
        HotMessage msg = gson.fromJson(String.valueOf(record.value()), HotMessage.class);
        //JSONObject jsonObject=JSONObject.parseObject(record.value());
        //HotMessage msg = JSONObject.toJavaObject(jsonObject,HotMessage.class);
        System.out.println(msg);
        msgService.insert(msg);
        //msgService.install(msg);
        ack.acknowledge();
    }
    @KafkaListener(topics = "${spring.kafka.producer.myTopic3}")
    public void myListen3(ConsumerRecord<String, HotMessage> record, Acknowledgment ack) {
        System.out.println(record.value());
        HotMessage msg = gson.fromJson(String.valueOf(record.value()), HotMessage.class);
        //JSONObject jsonObject=JSONObject.parseObject(record.value());
        //HotMessage msg = JSONObject.toJavaObject(jsonObject,HotMessage.class);
        System.out.println(msg);
        msgService.insert(msg);
        //msgService.install(msg);
        ack.acknowledge();
    }
    @KafkaListener(topics = "${spring.kafka.producer.myTopic4}")
    public void myListen4(ConsumerRecord<String, HotMessage> record, Acknowledgment ack) {
        System.out.println(record.value());
        HotMessage msg = gson.fromJson(String.valueOf(record.value()), HotMessage.class);
        //JSONObject jsonObject=JSONObject.parseObject(record.value());
        //HotMessage msg = JSONObject.toJavaObject(jsonObject,HotMessage.class);
        System.out.println(msg);
        msgService.insert(msg);
        //msgService.install(msg);
        ack.acknowledge();
    }
}
