package org.generation.ch55Spring.service;

import lombok.RequiredArgsConstructor;
import org.generation.ch55Spring.model.VentasDetalle;
import org.generation.ch55Spring.repository.VentasDetalleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VentasDetalleServiceImpl implements VentasDetalleService {

    private final VentasDetalleRepository ventasDetalleRepository;

    @Override
    public List<VentasDetalle> getAllDetalles() {
        return ventasDetalleRepository.findAll();
    }

    @Override
    public VentasDetalle getDetalleById(Long id) {
        return ventasDetalleRepository.findById(id).orElse(null);
    }

    @Override
    public List<VentasDetalle> getDetallesByUsuario(Long idUsuario) {
        return ventasDetalleRepository.findByIdUsuario(idUsuario);
    }

    @Override
    public List<VentasDetalle> getDetallesByTransaccion(Long idTransaccion) {
        return ventasDetalleRepository.findByIdTransaccion(idTransaccion);
    }

    @Override
    public VentasDetalle saveDetalle(VentasDetalle detalle) {
        return ventasDetalleRepository.save(detalle);
    }

    @Override
    public void deleteDetalle(Long id) {
        ventasDetalleRepository.deleteById(id);
    }
}
