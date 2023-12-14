package com.example.crud.poorganizer.domain.project;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// esse código define um repositório JPA para a entidade Product.
// Esse repositório fornece métodos para realizar operações de CRUD (Create, Read, Update, Delete)
// em objetos Product em um banco de dados.

    public interface ProjectRepository extends JpaRepository<Project, String> {
        List<Project> findAllBySituationTrue();
         //Conseguimos fazer implementações defalt com Jpa
        //Ao descrever findAllbySituationTrue ele busca por padrão baseado no atributo Situation
        //Não sendo necessário realizar mais nenhuma busca no método.
    }

