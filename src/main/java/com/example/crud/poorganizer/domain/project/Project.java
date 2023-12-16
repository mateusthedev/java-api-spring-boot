package com.example.crud.poorganizer.domain.project;

import jakarta.persistence.*;
import lombok.*;


@Table(name = "projects") //Digo que a tabela relacionada no meu banco de dados se chama "product".
@Entity(name = "projects") //Nomeio a minha entidade, no caso esse JAVACLASS.
@Data
@AllArgsConstructor //"Biblioteca Lombok" - Já cria o método construtos para todos os atributos.
@NoArgsConstructor // "Biblioteca Lombok" - Diz que não receberemos nenhum argumento passado pelo contrutor para nosso objeto.
@EqualsAndHashCode(of = "id") //Biblioteca Lombok definimos a primary key do banco.

public class Project {

    @Id @GeneratedValue(strategy = GenerationType.UUID)

    private String id;
    private String name;

    @Column(name = "creatoruserid")
    private String creatorUserId;

    private Integer situation;

    public Project(RequestProject requestProject){
        this.name = requestProject.name();
        this.creatorUserId = requestProject.creatorUserId();
        this.situation = requestProject.situation();
    }
}
