package com.hzy.kafkatool.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.kafka.support.ProducerListener;
import org.springframework.stereotype.Component;

/**
 * @author: arnold_nie
 * @date: 2020/8/19 11:11
 * FileName: KafkaSendMsgHandler
 * Description: 发送消息结果
 */
@Component
@Slf4j
public class KafkaSendMsgResult implements ProducerListener {

    @Override
    public void onSuccess(ProducerRecord producerRecord, RecordMetadata recordMetadata) {
        log.info("Message send success : {}, 消息信息: {}", producerRecord.toString(), recordMetadata);
    }

    @Override
    public void onError(ProducerRecord producerRecord, Exception exception) {
        log.info("Message send error : {}, 堆栈信息: {}" , producerRecord.toString(), exception.getStackTrace());
    }

}
