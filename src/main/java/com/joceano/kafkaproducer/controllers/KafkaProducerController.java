package com.joceano.kafkaproducer.controllers;

import com.joceano.kafkaproducer.models.Pedido;
import com.joceano.kafkaproducer.services.KafkaProducerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaProducerController {

    private final KafkaProducerService kafkaProducerService;

    public KafkaProducerController(KafkaProducerService kafkaProducerService) {
        this.kafkaProducerService = kafkaProducerService;
    }

    @GetMapping(value = "/send")
    public void send(){

        var pedido = new Pedido();
        pedido.setId(1L);
        pedido.setDescricao("Pedido número 1");

        kafkaProducerService.send(pedido);
    }
}
