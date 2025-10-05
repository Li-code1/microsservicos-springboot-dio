package com.seuprojeto.storefront.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "warehouse", url = "http://localhost:8081")
public interface ProductClient {
    @PutMapping("/products/{id}/decrease")
    ResponseEntity<?> decreaseStock(@PathVariable("id") Long id, @RequestParam("amount") int amount);
}
