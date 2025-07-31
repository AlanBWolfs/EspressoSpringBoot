package org.generation.ch55Spring.service;

import org.generation.ch55Spring.model.Categoria;

import java.util.List;
import java.util.Optional;

public interface CategoriaService {
    List<Categoria> findAll();
    Optional<Categoria> findById(Long id);
    Categoria save(Categoria categoria);
    Categoria update(Long id, Categoria categoria);  // 👈 agregamos update
    void delete(Long id);
}
