package com.joceano.kafkaproducer.services;

import com.joceano.kafkaproducer.config.properties.KafkaProperties;
import com.joceano.kafkaproducer.models.Pedido;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducerService.class);

    private final KafkaProperties kafkaProperties;
    private final KafkaTemplate<String, Object> kafkaTemplate;

    public KafkaProducerService(KafkaProperties kafkaProperties, KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaProperties = kafkaProperties;
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(Pedido pedido){
        kafkaTemplate.send(this.kafkaProperties.getTopic(), pedido);
        LOGGER.info("Pedido enviado: {}", pedido);
    }

}
