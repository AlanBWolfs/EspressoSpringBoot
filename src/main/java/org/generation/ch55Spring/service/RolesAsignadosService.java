package org.generation.ch55Spring.service;

import org.generation.ch55Spring.model.RolesAsignados;
import org.generation.ch55Spring.model.RolesAsignadosId;

import java.util.List;

public interface RolesAsignadosService {
    RolesAsignados save(RolesAsignados rolesAsignados);
    List<RolesAsignados> findAll();
    RolesAsignados findById(Long id);
    void deleteById(Long id);
    RolesAsignados update(Long id, RolesAsignados rolesAsignados);

    RolesAsignados findById(RolesAsignadosId id);
}