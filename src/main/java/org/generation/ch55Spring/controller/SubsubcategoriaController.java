package org.generation.ch55Spring.controller;

import lombok.RequiredArgsConstructor;
import org.generation.ch55Spring.model.Subsubcategoria;
import org.generation.ch55Spring.service.SubsubcategoriaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subsubcategorias")
@RequiredArgsConstructor
public class SubsubcategoriaController {

    private final SubsubcategoriaService subsubcategoriaService;

    @GetMapping
    public List<Subsubcategoria> getAll() {
        return subsubcategoriaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Subsubcategoria> getById(@PathVariable Long id) {
        return subsubcategoriaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Subsubcategoria create(@RequestBody Subsubcategoria subsubcategoria) {
        return subsubcategoriaService.save(subsubcategoria);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Subsubcategoria> update(@PathVariable Long id, @RequestBody Subsubcategoria subsubcategoria) {
        try {
            return ResponseEntity.ok(subsubcategoriaService.update(id, subsubcategoria));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        subsubcategoriaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
