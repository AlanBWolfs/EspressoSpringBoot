package org.generation.ch55Spring.service;

import org.generation.ch55Spring.model.RolesAsignados;
import org.generation.ch55Spring.model.RolesAsignadosId;

import java.util.List;

public interface RolesAsignadosService {
    RolesAsignados save(RolesAsignados rolesAsignados);
    List<RolesAsignados> findAll();
    RolesAsignados findById(RolesAsignadosId id);
    void deleteById(RolesAsignadosId id);
    RolesAsignados update(RolesAsignadosId id, RolesAsignados rolesAsignados);
}
