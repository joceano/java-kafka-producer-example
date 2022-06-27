package com.joceano.kafkaproducer.services;

import com.joceano.kafkaproducer.models.Pedido;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

    @Value("${topic.name.producer}")
    private String topicName;

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public KafkaProducerService(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(Pedido pedido){
        kafkaTemplate.send(topicName, pedido);
    }

}
