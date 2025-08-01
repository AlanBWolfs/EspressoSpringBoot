package org.generation.ch55Spring.service;

import org.generation.ch55Spring.model.Subcategoria;

import java.util.List;
import java.util.Optional;

public interface SubcategoriaService {
    List<Subcategoria> findAll();
    Optional<Subcategoria> findById(Long id);
    Subcategoria save(Subcategoria subcategoria);
    Subcategoria update(Long id, Subcategoria subcategoria);  // 👈 agregado
    void delete(Long id);
}
