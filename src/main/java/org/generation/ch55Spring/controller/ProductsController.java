package org.generation.ch55Spring.controller;


import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.generation.ch55Spring.model.Products;
import org.generation.ch55Spring.service.ProductsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/api/products")// http://localhost:8080/api/products
//lombok
@AllArgsConstructor
public class ProductsController {
    //inyeccion de dependencias
    private ProductsService productsService;

    // peticion get
    @GetMapping //url a la que se hace la peticion http://localhost:8080/api/products
    public List<Products> getAllProducts(){
        return this.productsService.getAllProducts();
    }

    //peticion get para obtener producto por id
    @GetMapping(path = "{productId}") // http://localhost:8080/api/products/id  http://localhost:8080/api/products/2
    public Products getProductById(@PathVariable("productId")Long id){
        return this.productsService.getProductById(id);
    }

    //peticion post @RequestBody indica que la peticion tiene un body con informacion
    @PostMapping //url a la que se hace la peticion http://localhost:8080/api/products , solo que aqui el metodo a usar POST
    public Products addProduct(@RequestBody Products products){
        return this.productsService.addProduct(products);
    }

    // peticion Delete
    @DeleteMapping(path = "{productId}")// http://localhost:8080/api/products/id  http://localhost:8080/api/products/2 pero con peticion tipo delete
    public Products deleteProductById(@PathVariable("productId")Long id){
        return this.productsService.deleteProductById(id);
    }

    //peticion put
    @PutMapping(path = "{productId}")// http://localhost:8080/api/products/id  http://localhost:8080/api/products/2 peticion put y un body
    public Products updateProductById(@PathVariable("productId")Long id, @RequestBody Products productUpdated){
        return this.productsService.updateProductById(id, productUpdated);
    }

}