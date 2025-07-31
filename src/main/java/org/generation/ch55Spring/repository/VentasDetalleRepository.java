package org.generation.ch55Spring.repository;

import org.generation.ch55Spring.model.VentasDetalle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VentasDetalleRepository extends JpaRepository<VentasDetalle, Long> {
    List<VentasDetalle> findByIdUsuario(Long idUsuario);
    List<VentasDetalle> findByIdTransaccion(Long idTransaccion);
}
