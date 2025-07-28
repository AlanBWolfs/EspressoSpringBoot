package org.generation.ch55Spring.service;

import org.generation.ch55Spring.model.Products;
import org.generation.ch55Spring.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductsServiceImpl implements ProductsService {
    //inyeccion de dependencias en constructor
    private final ProductsRepository productsRepository;

    @Autowired
    public ProductsServiceImpl(ProductsRepository productsRepository){
        this.productsRepository = productsRepository;
    }

    @Override
    public List<Products> getAllProducts() {
        return productsRepository.findAll();
    }

    @Override
    public Products getProductById(Long id) {
        return productsRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("El producto con el id " + id + " no existe")
        );
    }

    @Override
    public Products deleteProductById(Long id) {
        //1. creamos una variable temporal para guardar el producto eliminado
        Products tmp = null;
        //2. usamos early return para evaluar si no existe el producto
        // en caso de que no exista termina la ejecucion de la funcion en ese momento
        if(!productsRepository.existsById(id)) return tmp;
        // si el producto existe, guardamos el producto en la variable temporal
        tmp = productsRepository.findById(id).get();
        //eliminamos el producto
        productsRepository.deleteById(id);
        //retornamos el producto eliminado
        return tmp;
    }

    @Override
    public Products addProduct(Products product) {
        return productsRepository.save(product);
    }

    @Override
    public Products updateProductById(Long id, Products productUpdated) {
        //1. creando un objeto opcional de tipo producto.
        Optional<Products> optionalProduct = productsRepository.findById(id);
        //early return
        if(optionalProduct.isEmpty()) throw new IllegalArgumentException("El producto con el id " + id + " no existe");
        Products originalProduct = optionalProduct.get();
        if(productUpdated.getName() != null) originalProduct.setName(productUpdated.getName());
        if(productUpdated.getDescription() != null) originalProduct.setDescription(productUpdated.getDescription());
        if(productUpdated.getQuantity() != null) originalProduct.setQuantity(productUpdated.getQuantity());
        if(productUpdated.getPrice() != null) originalProduct.setPrice(productUpdated.getPrice());
        return productsRepository.save(originalProduct);
    }
}