package com.example.crud.crud.domain.product;

import org.springframework.data.jpa.repository.JpaRepository;

    public interface ProductRepository extends JpaRepository<Product, String> {

    }

