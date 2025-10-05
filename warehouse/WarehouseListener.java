package com.seuprojeto.warehouse.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class WarehouseListener {

    @RabbitListener(queues = "purchase.queue")
    public void handlePurchaseEvent(String message) {
        System.out.println("Evento recebido no Warehouse: " + message);
    }
}
