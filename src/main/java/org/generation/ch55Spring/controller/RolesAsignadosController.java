package org.generation.ch55Spring.controller;

import lombok.RequiredArgsConstructor;
import org.generation.ch55Spring.model.RolesAsignados;
import org.generation.ch55Spring.service.RolesAsignadosService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles-asignados/id")
@RequiredArgsConstructor
public class RolesAsignadosController {
    private final RolesAsignadosService rolesAsignadosService;

    @PostMapping
    public RolesAsignados save(@RequestBody RolesAsignados rolesAsignados) {
        return rolesAsignadosService.save(rolesAsignados);
    }

    @GetMapping
    public List<RolesAsignados> findAll() {
        return rolesAsignadosService.findAll();
    }

    @GetMapping("/{id}")
    public RolesAsignados findById(@PathVariable Long id) {
        return rolesAsignadosService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        rolesAsignadosService.deleteById(id);
    }

    @PutMapping("/{id}")
    public RolesAsignados update(@PathVariable Long id, @RequestBody RolesAsignados rolesAsignados) {
        return rolesAsignadosService.update(id, rolesAsignados);
    }
}