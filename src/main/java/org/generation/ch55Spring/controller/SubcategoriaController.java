package org.generation.ch55Spring.controller;

import lombok.RequiredArgsConstructor;
import org.generation.ch55Spring.model.Subcategoria;
import org.generation.ch55Spring.service.SubcategoriaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subcategorias")
@RequiredArgsConstructor
public class SubcategoriaController {

    private final SubcategoriaService subcategoriaService;

    @GetMapping
    public List<Subcategoria> getAll() {
        return subcategoriaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Subcategoria> getById(@PathVariable Long id) {
        return subcategoriaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Subcategoria create(@RequestBody Subcategoria subcategoria) {
        return subcategoriaService.save(subcategoria);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Subcategoria> update(@PathVariable Long id, @RequestBody Subcategoria subcategoria) {
        try {
            return ResponseEntity.ok(subcategoriaService.update(id, subcategoria));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        subcategoriaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
