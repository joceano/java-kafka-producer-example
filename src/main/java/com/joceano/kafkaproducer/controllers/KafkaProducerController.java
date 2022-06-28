package com.joceano.kafkaproducer.controllers;

import com.joceano.kafkaproducer.models.Pedido;
import com.joceano.kafkaproducer.models.Response;
import com.joceano.kafkaproducer.models.factories.ResponseFactory;
import com.joceano.kafkaproducer.services.KafkaProducerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaProducerController {

    private final KafkaProducerService kafkaProducerService;

    public KafkaProducerController(KafkaProducerService kafkaProducerService) {
        this.kafkaProducerService = kafkaProducerService;
    }

    @PostMapping(value = "/send")
    public ResponseEntity<Response> send(@RequestBody Pedido pedido) {
        try {
            kafkaProducerService.send(pedido);
            return ResponseEntity.status(HttpStatus.OK).body(ResponseFactory.responseOk());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResponseFactory.responseBadRequest());
        }
    }
}
