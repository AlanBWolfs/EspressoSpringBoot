package org.generation.ch55Spring.controller;

import lombok.RequiredArgsConstructor;
import org.generation.ch55Spring.model.VentasDetalle;
import org.generation.ch55Spring.service.VentasDetalleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ventas-detalle") // http://localhost:8080/api/ventas-detalle
@RequiredArgsConstructor
public class VentasDetalleController {

    private final VentasDetalleService ventasDetalleService;

    // 🔹 Obtener todos los detalles
    @GetMapping
    public List<VentasDetalle> getAllDetalles() {
        return ventasDetalleService.getAllDetalles();
    }

    // 🔹 Obtener un detalle por ID
    @GetMapping("/{id}")
    public VentasDetalle getDetalleById(@PathVariable Long id) {
        return ventasDetalleService.getDetalleById(id);
    }

    // 🔹 Obtener detalles por ID de usuario
    @GetMapping("/usuario/{idUsuario}")
    public List<VentasDetalle> getDetallesByUsuario(@PathVariable Long idUsuario) {
        return ventasDetalleService.getDetallesByUsuario(idUsuario);
    }

    // 🔹 Obtener detalles por ID de transacción
    @GetMapping("/transaccion/{idTransaccion}")
    public List<VentasDetalle> getDetallesByTransaccion(@PathVariable Long idTransaccion) {
        return ventasDetalleService.getDetallesByTransaccion(idTransaccion);
    }

    // 🔹 Crear un nuevo detalle de venta
    @PostMapping
    public VentasDetalle createDetalle(@RequestBody VentasDetalle detalle) {
        return ventasDetalleService.saveDetalle(detalle);
    }

    // 🔹 Actualizar un detalle de venta
    @PutMapping("/{id}")
    public VentasDetalle updateDetalle(@PathVariable Long id, @RequestBody VentasDetalle detalle) {
        detalle.setIdDetalle(id);
        return ventasDetalleService.saveDetalle(detalle);
    }

    // 🔹 Eliminar un detalle de venta
    @DeleteMapping("/{id}")
    public void deleteDetalle(@PathVariable Long id) {
        ventasDetalleService.deleteDetalle(id);
    }
}
