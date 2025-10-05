package com.seuprojeto.warehouse.repository;

import com.seuprojeto.warehouse.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {}
