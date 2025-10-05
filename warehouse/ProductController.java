package com.seuprojeto.warehouse.controller;

import com.seuprojeto.warehouse.model.Product;
import com.seuprojeto.warehouse.repository.ProductRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductRepository repository;

    @GetMapping
    public List<Product> getAll() {
        return repository.findAll();
    }

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody @Valid Product product) {
        Product saved = repository.save(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @PutMapping("/{id}/decrease")
    public ResponseEntity<?> decreaseStock(@PathVariable Long id, @RequestParam int amount) {
        if (amount <= 0) return ResponseEntity.badRequest().body("Quantidade inválida");

        return repository.findById(id)
                .map(product -> {
                    if (product.getQuantity() < amount)
                        return ResponseEntity.badRequest().body("Estoque insuficiente");

                    product.setQuantity(product.getQuantity() - amount);
                    repository.save(product);
                    return ResponseEntity.ok(product);
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
