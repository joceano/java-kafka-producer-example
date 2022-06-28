package com.joceano.kafkaproducer.models.factories;

import com.joceano.kafkaproducer.models.Response;

public class ResponseFactory {

    private ResponseFactory() {
    }

    public static Response responseOk() {
        return new Response("Pedido enviado com sucesso para a fila.");
    }

    public static Response responseBadRequest() {
        return new Response("Não foi possível enviar o pedido para a fila.");
    }
}
