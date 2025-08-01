package org.generation.ch55Spring.service;

import org.generation.ch55Spring.model.Subsubcategoria;

import java.util.List;
import java.util.Optional;

public interface SubsubcategoriaService {
    List<Subsubcategoria> findAll();
    Optional<Subsubcategoria> findById(Long id);
    Subsubcategoria save(Subsubcategoria subsubcategoria);
    Subsubcategoria update(Long id, Subsubcategoria subsubcategoria);
    void delete(Long id);
}
