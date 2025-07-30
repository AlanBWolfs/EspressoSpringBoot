package org.generation.ch55Spring.controller;

import org.generation.ch55Spring.model.VentasDetalle;
import org.generation.ch55Spring.repository.VentasDetalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ventas-detalle")
public class VentasDetalleController {

    @Autowired
    private VentasDetalleRepository ventasDetalleRepository;

    // Obtener todos los registros
    @GetMapping
    public List<VentasDetalle> getAllDetalles() {
        return ventasDetalleRepository.findAll();
    }

    // Obtener un registro por ID
    @GetMapping("/{id}")
    public ResponseEntity<VentasDetalle> getDetalleById(@PathVariable Long id) {
        return ventasDetalleRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Crear un nuevo registro
    @PostMapping
    public VentasDetalle createDetalle(@RequestBody VentasDetalle detalle) {
        return ventasDetalleRepository.save(detalle);
    }

    // Actualizar un registro existente
    @PutMapping("/{id}")
    public ResponseEntity<VentasDetalle> updateDetalle(@PathVariable Long id, @RequestBody VentasDetalle detalleActualizado) {
        return ventasDetalleRepository.findById(id)
                .map(detalle -> {
                    detalleActualizado.setIdDetalle(id);
                    return ResponseEntity.ok(ventasDetalleRepository.save(detalleActualizado));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Eliminar un registro
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDetalle(@PathVariable Long id) {
        if (ventasDetalleRepository.existsById(id)) {
            ventasDetalleRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

