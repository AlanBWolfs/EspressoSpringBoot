package org.generation.ch55Spring.controller;


import lombok.AllArgsConstructor;
import org.generation.ch55Spring.model.Productos;
import org.generation.ch55Spring.service.ProductosService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/api/productos")// http://localhost:8080/api/productos
//lombok
@AllArgsConstructor
public class ProductosController {
    //inyeccion de dependencias
    private ProductosService productosService;

    // peticion get
    @GetMapping //url a la que se hace la peticion http://localhost:8080/api/products
    public List<Productos> getAllProducts(){
        return this.productosService.getAllProducts();
    }

    //peticion get para obtener producto por id
    @GetMapping(path = "{productId}") // http://localhost:8080/api/products/id  http://localhost:8080/api/products/2
    public Productos getProductById(@PathVariable("productId")Long id){
        return this.productosService.getProductById(id);
    }

    //peticion post @RequestBody indica que la peticion tiene un body con informacion
    @PostMapping //url a la que se hace la peticion http://localhost:8080/api/products , solo que aqui el metodo a usar POST
    public Productos addProduct(@RequestBody Productos products){
        return this.productosService.addProduct(products);
    }

    // peticion Delete
    @DeleteMapping(path = "{productId}")// http://localhost:8080/api/products/id  http://localhost:8080/api/products/2 pero con peticion tipo delete
    public Productos deleteProductById(@PathVariable("productId")Long id){
        return this.productosService.deleteProductById(id);
    }

    //peticion put
    @PutMapping(path = "{productId}")// http://localhost:8080/api/products/id  http://localhost:8080/api/products/2 peticion put y un body
    public Productos updateProductById(@PathVariable("productId")Long id, @RequestBody Productos productUpdated){
        return this.productosService.updateProductById(id, productUpdated);
    }

}