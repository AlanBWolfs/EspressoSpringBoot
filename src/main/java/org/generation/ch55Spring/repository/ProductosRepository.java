package org.generation.ch55Spring.repository;

import org.generation.ch55Spring.model.Productos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductosRepository extends JpaRepository<Productos,Long> {
}