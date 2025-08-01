package org.generation.ch55Spring.controller;

import lombok.RequiredArgsConstructor;
import org.generation.ch55Spring.model.RolesAsignados;
import org.generation.ch55Spring.model.RolesAsignadosId;
import org.generation.ch55Spring.service.RolesAsignadosService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles-asignados")
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

    // Por ejemplo, recibir id compuesto con query params ?usuarioId=1&rolId=2
    @GetMapping("/id")
    public RolesAsignados findById(@RequestParam Long usuarioId, @RequestParam Long rolId) {
        RolesAsignadosId id = new RolesAsignadosId(usuarioId, rolId);
        return rolesAsignadosService.findById(id);
    }

    @DeleteMapping("/id")
    public void deleteById(@RequestParam Long usuarioId, @RequestParam Long rolId) {
        RolesAsignadosId id = new RolesAsignadosId(usuarioId, rolId);
        rolesAsignadosService.deleteById(id);
    }

    @PutMapping("/id")
    public RolesAsignados update(@RequestParam Long usuarioId, @RequestParam Long rolId, @RequestBody RolesAsignados rolesAsignados) {
        RolesAsignadosId id = new RolesAsignadosId(usuarioId, rolId);
        return rolesAsignadosService.update(id, rolesAsignados);
    }
}
