package org.generation.ch55Spring.service;

import org.generation.ch55Spring.model.Productos;

import java.util.List;

public interface ProductosService {
    //esto es la firma del metodo, la primera parte es el valor de retorno,
    //segunda parte el nombre del metodo, y tercera parametros.
    List<Productos> getAllProducts();
    Productos getProductById(Long id);
    Productos deleteProductById(Long id);
    Productos addProduct(Productos product);
    Productos updateProductById(Long id, Productos productUpdated);

}