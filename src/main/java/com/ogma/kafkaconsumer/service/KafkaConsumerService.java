package com.ogma.kafkaconsumer.service;

import com.ogma.kafkaconsumer.model.FixMsgModel;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "testTopic", groupId = "foo")
    public void listen(String msg) {
        System.out.println("Received msg - " + msg);
    }

    @KafkaListener(topics = "msgTopic", containerFactory = "fixMsgKafkaListenerContainerFactory")
    public void fixMsgListen(FixMsgModel fixMsgModel) {
        System.out.println("Received msg - " + fixMsgModel.toString() + "-" + Long.toString(new Date().getTime()));
    }


}
