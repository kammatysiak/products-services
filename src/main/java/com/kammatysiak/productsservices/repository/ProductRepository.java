package com.kammatysiak.productsservices.repository;

import com.kammatysiak.productsservices.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

    boolean existsByName(String name);
}
