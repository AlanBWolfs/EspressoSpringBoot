package org.generation.ch55Spring.repository;

import org.generation.ch55Spring.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

    // Buscar productos por id de la subsubcategoria
    List<Producto> findBySubsubcategoriaId(Long subsubcategoriaId);

    // Opcional: si quisieras buscar por nombre parecido
    List<Producto> findByNombreContainingIgnoreCase(String nombre);
}
