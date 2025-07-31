package org.generation.ch55Spring.controller;

import lombok.RequiredArgsConstructor;
import org.generation.ch55Spring.model.RolesDescripcion;
import org.generation.ch55Spring.service.RolesDescripcionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles-descripcion/id")
@RequiredArgsConstructor
public class RolesDescripcionController {
    private final RolesDescripcionService rolesDescripcionService;

    @PostMapping
    public RolesDescripcion save(@RequestBody RolesDescripcion rolesDescripcion) {
        return rolesDescripcionService.save(rolesDescripcion);
    }

    @GetMapping
    public List<RolesDescripcion> findAll() {
        return rolesDescripcionService.findAll();
    }

    @GetMapping("/{id}")
    public RolesDescripcion findById(@PathVariable Long id) {
        return rolesDescripcionService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        rolesDescripcionService.deleteById(id);
    }

    @PutMapping("/{id}")
    public RolesDescripcion update(@PathVariable Long id, @RequestBody RolesDescripcion rolesDescripcion) {
        return rolesDescripcionService.update(id, rolesDescripcion);
    }
}