package com.example.crud.poorganizer.controllers;

import com.example.crud.poorganizer.domain.project.Project;
import com.example.crud.poorganizer.domain.project.ProjectRepository;
import com.example.crud.poorganizer.domain.project.RequestProject;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController //Nomeamos essa classe como um controller
@RequestMapping("/project") //Dizemos que todas as requests /product serão para esse controller

public class ProjectController {
    @Autowired //Direciona as ações feitas em .domain.ProductRepository para essa classe.
    private ProjectRepository repository;

    @GetMapping// Recebe requisições GET
    public ResponseEntity getAllProjects(){
        var allProjects = repository.findAllBySituationTrue();
        return ResponseEntity.ok(allProjects);
    }

    @GetMapping("/{id}")
    @Transactional
    public ResponseEntity getProjectbyId(@PathVariable String id){
        var projects = repository.findById(id);
        return ResponseEntity.ok(projects);
    }

    @PostMapping//Recebe as requisições POST
    public ResponseEntity createProject(@RequestBody @Valid RequestProject data){ //Recebe os valores dos atributos do Record Requestproduct em "data"
        Project newProject = new Project(data);
        repository.save(newProject);
        return ResponseEntity.ok().build();//usamos build para finalizar o método. Sinalizando que está completo.
    }

    @PutMapping//Recebe a requisição PUT
    @Transactional //Usamos para que ele execute a função PUT na ordem correta.
    public ResponseEntity updateProduct(@RequestBody @Valid RequestProject data){
        try {
            //Precisamos passar como Optional primeiro para identificar se não há Ids inválidas e setamos o id
            Optional<Project> optionalProduct = repository.findById(data.id());
            //Depois usamos o método do construtor e selecinamos que será alterado pela id.
            Project project = optionalProduct.get();
            project.setName(data.name());
            project.getCreatorUserId();
            project.setSituation(data.situation());

            return ResponseEntity.ok().build();

        } catch (Exception a){
            //chamamos a declaração realizado na infra para tratar exceções.
            throw new EntityNotFoundException();
        }

    }

    @DeleteMapping("/{id}")//Recebe requisiçõe DELETE passando o ID na rota
    @Transactional
    public ResponseEntity deleteProduct(@PathVariable String id){ //PathVariable JPA seta a variavel da rota
        try {
            Optional<Project> optionalProduct = repository.findById(id);
            Project project = optionalProduct.get();

            return ResponseEntity.ok("Sucesso");
        } catch (Exception a){
            return ResponseEntity.ok("Erro");
        }

    }
}
