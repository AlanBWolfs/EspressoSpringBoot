package org.generation.ch55Spring.service;

import org.generation.ch55Spring.model.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoService {
    List<Producto> findAll();
    Optional<Producto> findById(Long id);
    Producto save(Producto producto);
    Producto update(Long id, Producto producto);
    void delete(Long id);
    List<Producto> findBySubsubcategoriaId(Long subsubcategoriaId);
}
