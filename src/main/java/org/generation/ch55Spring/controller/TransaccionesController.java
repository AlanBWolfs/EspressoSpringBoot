package org.generation.ch55Spring.controller;

import lombok.RequiredArgsConstructor;
import org.generation.ch55Spring.model.Transacciones;
import org.generation.ch55Spring.service.TransaccionesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transacciones/id")
@RequiredArgsConstructor
public class TransaccionesController {
    private final TransaccionesService transaccionesService;

    @PostMapping
    public Transacciones save(@RequestBody Transacciones transaccion) {
        return transaccionesService.save(transaccion);
    }

    @GetMapping
    public List<Transacciones> findAll() {
        return transaccionesService.findAll();
    }

    @GetMapping("/{id}")
    public Transacciones findById(@PathVariable Long id) {
        return transaccionesService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        transaccionesService.deleteById(id);
    }

    @PutMapping("/{id}")
    public Transacciones update(@PathVariable Long id, @RequestBody Transacciones transaccion) {
        return transaccionesService.update(id, transaccion);
    }
}