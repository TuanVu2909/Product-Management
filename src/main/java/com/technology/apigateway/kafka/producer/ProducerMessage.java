package com.technology.apigateway.kafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProducerMessage {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendLog(String smsJsonData) {
        log.info(String.format("#### -> Producing message logs APIGATEWAY ->"));
        this.kafkaTemplate.send("API_LOGS", smsJsonData);
    }

}