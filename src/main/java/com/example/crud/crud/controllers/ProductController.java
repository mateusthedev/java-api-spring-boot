package com.example.crud.crud.controllers;

import com.example.crud.crud.domain.product.Product;
import com.example.crud.crud.domain.product.ProductRepository;
import com.example.crud.crud.domain.product.RequestProduct;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController //Nomeamos essa classe como um controller
@RequestMapping("/product") //Dizemos que todas as requests /product serão para esse controller

public class ProductController {
    @Autowired //Direciona as ações feitas em .domain.ProductRepository para essa classe.
    private ProductRepository repository;

    @GetMapping// Recebe requisições GET
    public ResponseEntity getAllProducts(){
        var allProducts = repository.findAllBySituationTrue();
        return ResponseEntity.ok(allProducts);
    }

    @PostMapping//Recebe as requisições POST
    public ResponseEntity createProduct(@RequestBody @Valid RequestProduct data){ //Recebe os valores dos atributos do Record Requestproduct em "data"
        Product newProduct = new Product(data);
        repository.save(newProduct);
        return ResponseEntity.ok().build();//usamos build para finalizar o método. Sinalizando que está completo.
    }

    @PutMapping//Recebe a requisição PUT
    @Transactional //Usamos para que ele execute a função PUT na ordem correta.
    public ResponseEntity updateProduct(@RequestBody @Valid RequestProduct data){
        try {
            //Precisamos passar como Optional primeiro para identificar se não há Ids inválidas e setamos o id
            Optional<Product> optionalProduct = repository.findById(data.id());
            //Depois usamos o método do construtor e selecinamos que será alterado pela id.
            Product product = optionalProduct.get();
            product.setName(data.name());
            product.setPrice_in_cents(data.price_in_cents());
            product.setStock(data.stock());
            product.setSituation(data.situation());

            return ResponseEntity.ok().body("Sucesso");
        }catch (Exception a){
            return ResponseEntity.badRequest().body("Erro");
        }

    }

    @DeleteMapping("/{id}")//Recebe requisiçõe DELETE passando o ID na rota
    @Transactional
    public ResponseEntity deleteProduct(@PathVariable String id){ //PathVariable JPA seta a variavel da rota
        try {
            Optional<Product> optionalProduct = repository.findById(id);
            Product product = optionalProduct.get();
            product.setSituation(false);

            return ResponseEntity.ok("Sucesso");
        } catch (Exception a){
            return ResponseEntity.ok("Erro!");
        }

    }
}
