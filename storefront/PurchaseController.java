package com.seuprojeto.storefront.controller;

import com.seuprojeto.storefront.client.ProductClient;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/purchase")
@RequiredArgsConstructor
public class PurchaseController {

    private final ProductClient productClient;
    private final RabbitTemplate rabbitTemplate;

    @PostMapping
    public ResponseEntity<?> purchase(@RequestParam Long productId, @RequestParam int amount) {
        if (amount <= 0) return ResponseEntity.badRequest().body("Quantidade inválida");

        ResponseEntity<?> response = productClient.decreaseStock(productId, amount);

        if (response.getStatusCode().is2xxSuccessful()) {
            rabbitTemplate.convertAndSend("purchase.exchange", "purchase.routingkey", "Produto " + productId + " comprado");
        }

        return response;
    }
}
