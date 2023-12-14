package com.example.crud.poorganizer.domain.project;

import jakarta.persistence.*;
import lombok.*;

//Domain são representação das tabelas no banco de dados.

@Table(name = "product") //Digo que a tabela relacionada no meu banco de dados se chama "product".
@Entity(name = "product") //Nomeio a minha entidade, no caso esse JAVACLASS.
@Getter //"Biblioteca Lombok" - Ao definir essa opção não é necessário fazer a geração da opção Getter em todas os atributos;
@Setter //"Biblioteca Lombok" - Ao definir essa opção não é necessário fazer a geração da opção Setter em todas os atributos;
@AllArgsConstructor //"Biblioteca Lombok" - Já cria o método construtos para todos os atributos.
@NoArgsConstructor // "Biblioteca Lombok" - Diz que não receberemos nenhum argumento passado pelo contrutor para nosso objeto.
@EqualsAndHashCode(of = "id") //Biblioteca Lombok definimos a primary key do banco.

public class Project {
    //Dizemos como as novas instancias serão geradas nesse caso uuid para id.
    @Id @GeneratedValue(strategy = GenerationType.UUID)

    private String id;
    private String name;

    private String creatorUserId;

    private Integer situation;

    //Setter que pega o valor pelo método construtor "RequestProduct"
    // e passa o valor para os atributos.
    public Project(RequestProject requestProject){
        this.name = requestProject.name();
        this.creatorUserId = requestProject.creatorUserId();
        this.situation = requestProject.situation();
    }
}