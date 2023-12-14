package com.example.crud.poorganizer.domain.project;

//Usamos como uma DTO "Data transfer Object"
//Basicamento server para salvar e enviar os valores do atributo para outras classe.
public record RequestProject(
        String id,
        String name,
        String creatorUserId,
        Integer situation
        ){

}
