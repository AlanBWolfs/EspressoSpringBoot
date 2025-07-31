package org.generation.ch55Spring.repository;

import org.generation.ch55Spring.model.Favoritos;
import org.generation.ch55Spring.model.FavoritosId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoritosRepository extends JpaRepository<Favoritos, FavoritosId> {
}
