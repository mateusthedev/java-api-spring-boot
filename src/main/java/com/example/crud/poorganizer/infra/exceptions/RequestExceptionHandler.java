package com.example.crud.poorganizer.infra.exceptions;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//Classe para tratar excessões

@RestControllerAdvice //classe para tratar excessões "Erros" nomeamos ela dessa forma, toda vez que ocorrer erros será direcionado para cá
public class RequestExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity threat404(){
        return ResponseEntity.badRequest().body("Dado não localizado 404");
    }
}
