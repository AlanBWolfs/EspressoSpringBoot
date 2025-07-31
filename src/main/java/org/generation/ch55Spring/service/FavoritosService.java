package org.generation.ch55Spring.service;

import org.generation.ch55Spring.model.Favoritos;
import java.util.List;

public interface FavoritosService {
    Favoritos save(Favoritos favorito);
    List<Favoritos> findAll();
    Favoritos findById(Long id);
    void deleteById(Long id);
    Favoritos update(Long id, Favoritos favorito);
}