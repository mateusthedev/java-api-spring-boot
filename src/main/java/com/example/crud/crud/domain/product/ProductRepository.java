package com.example.crud.crud.domain.product;

import org.springframework.data.jpa.repository.JpaRepository;

// esse código define um repositório JPA para a entidade Product.
// Esse repositório fornece métodos para realizar operações de CRUD (Create, Read, Update, Delete)
// em objetos Product em um banco de dados.

    public interface ProductRepository extends JpaRepository<Product, String> {

    }

