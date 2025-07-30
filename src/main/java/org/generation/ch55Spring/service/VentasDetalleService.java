package org.generation.ch55Spring.service;

import org.generation.ch55Spring.model.VentasDetalle;
import org.generation.ch55Spring.repository.VentasDetalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class VentasDetalleService {

    @Autowired
    private VentasDetalleRepository repository;

    public List<VentasDetalle> getAll() {
        return repository.findAll();
    }

    public Optional<VentasDetalle> getById(Long id) {
        return repository.findById(id);
    }

    public VentasDetalle save(VentasDetalle detalle) {
        calcularCamposFinancieros(detalle);
        return repository.save(detalle);
    }

    public Optional<VentasDetalle> update(Long id, VentasDetalle detalleActualizado) {
        return repository.findById(id).map(existing -> {
            detalleActualizado.setIdDetalle(id);
            calcularCamposFinancieros(detalleActualizado);
            return repository.save(detalleActualizado);
        });
    }

    public boolean delete(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    private void calcularCamposFinancieros(VentasDetalle detalle) {
        BigDecimal subtotal = detalle.getPrecioUnitario().multiply(BigDecimal.valueOf(detalle.getCantidad()));
        BigDecimal total = subtotal.subtract(detalle.getDescuento());
        detalle.setSubtotal(subtotal);
        detalle.setTotalAPagar(total);
        // Puedes agregar más cálculos aquí si lo deseas
    }
}