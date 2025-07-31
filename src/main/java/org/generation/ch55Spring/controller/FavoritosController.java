package org.generation.ch55Spring.controller;

import lombok.RequiredArgsConstructor;
import org.generation.ch55Spring.model.Favoritos;
import org.generation.ch55Spring.service.FavoritosService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/favoritos")
@RequiredArgsConstructor
public class FavoritosController {
    private final FavoritosService favoritosService;

    @PostMapping
    public Favoritos save(@RequestBody Favoritos favorito) {
        return favoritosService.save(favorito);
    }

    @GetMapping
    public List<Favoritos> findAll() {
        return favoritosService.findAll();
    }

    @GetMapping("/{id}")
    public Favoritos findById(@PathVariable Long id) {
        return favoritosService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        favoritosService.deleteById(id);
    }

    @PutMapping("/{id}")
    public Favoritos update(@PathVariable Long id, @RequestBody Favoritos favorito) {
        return favoritosService.update(id, favorito);
    }
}