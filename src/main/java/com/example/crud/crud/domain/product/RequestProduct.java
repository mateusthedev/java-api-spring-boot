package com.example.crud.crud.domain.product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

//Usamos como uma DTO "Data transfer Object"
//Basicamento server para salvar e enviar os valores do atributo para outras classe.
public record RequestProduct(
        String id,
        String name,
        Integer price_in_cents,
        Integer stock,
        Boolean situation
        ){

}
