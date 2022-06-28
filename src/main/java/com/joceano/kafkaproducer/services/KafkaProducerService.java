package com.joceano.kafkaproducer.services;

import com.joceano.kafkaproducer.models.Pedido;
import com.joceano.kafkaproducer.config.properties.TopicProperties;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

    private final TopicProperties topicProperties;
    private final KafkaTemplate<String, Object> kafkaTemplate;

    public KafkaProducerService(TopicProperties topicProperties, KafkaTemplate<String, Object> kafkaTemplate) {
        this.topicProperties = topicProperties;
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(Pedido pedido){
        kafkaTemplate.send(this.topicProperties.getTopicName(), pedido);
    }

}
