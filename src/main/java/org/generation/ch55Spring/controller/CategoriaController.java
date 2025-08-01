package org.generation.ch55Spring.controller;

import lombok.RequiredArgsConstructor;
import org.generation.ch55Spring.model.Categoria;
import org.generation.ch55Spring.service.CategoriaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categorias")
@RequiredArgsConstructor
public class CategoriaController {

    private final CategoriaService categoriaService;

    @GetMapping
    public List<Categoria> getAll() {
        return categoriaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> getById(@PathVariable Long id) {
        return categoriaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Categoria create(@RequestBody Categoria categoria) {
        return categoriaService.save(categoria);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categoria> update(@PathVariable Long id, @RequestBody Categoria categoria) {
        try {
            return ResponseEntity.ok(categoriaService.update(id, categoria));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        categoriaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
