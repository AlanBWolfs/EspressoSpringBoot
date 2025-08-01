package org.generation.ch55Spring.service;

import org.generation.ch55Spring.model.RolesDescripcion;
import java.util.List;

public interface RolesDescripcionService {
    RolesDescripcion save(RolesDescripcion rolesDescripcion);
    List<RolesDescripcion> findAll();
    RolesDescripcion findById(Long id);
    void deleteById(Long id);
    RolesDescripcion update(Long id, RolesDescripcion rolesDescripcion);
}