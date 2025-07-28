package org.generation.ch55Spring.service;

import org.generation.ch55Spring.model.Products;

import java.util.List;

public interface ProductsService {
    //esto es la firma del metodo, la primera parte es el valor de retorno,
    //segunda parte el nombre del metodo, y tercera parametros.
    List<Products> getAllProducts();
    Products getProductById(Long id);
    Products deleteProductById(Long id);
    Products addProduct(Products product);
    Products updateProductById(Long id, Products productUpdated);

}