package org.generation.ch55Spring.service;

import org.generation.ch55Spring.model.VentasDetalle;
import java.util.List;

public interface VentasDetalleService {
    List<VentasDetalle> getAllDetalles();
    VentasDetalle getDetalleById(Long id);
    List<VentasDetalle> getDetallesByUsuario(Long idUsuario);
    List<VentasDetalle> getDetallesByTransaccion(Long idTransaccion);
    VentasDetalle saveDetalle(VentasDetalle detalle);
    void deleteDetalle(Long id);
}
