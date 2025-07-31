package org.generation.ch55Spring.repository;

import org.generation.ch55Spring.model.Carrito;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CarritoRepository extends JpaRepository<Carrito, Long> {
    List<Carrito> findByUsuarioIdUsuario(Long idUsuario);
    Optional<Carrito> findByUsuarioIdUsuarioAndProductoIdProducto(Long idUsuario, Long idProducto);
}
