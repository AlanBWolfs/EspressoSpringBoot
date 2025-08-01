// src/main/java/org/generation/ch55Spring/service/RolesAsignadosServiceImpl.java
package org.generation.ch55Spring.service;

import org.generation.ch55Spring.model.RolesAsignados;
import org.generation.ch55Spring.model.RolesAsignadosId;
import org.generation.ch55Spring.repository.RolesAsignadosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolesAsignadosServiceImpl implements RolesAsignadosService {

    @Autowired
    private RolesAsignadosRepository rolesAsignadosRepository;

    @Override
    public RolesAsignados save(RolesAsignados rolesAsignados) {
        return rolesAsignadosRepository.save(rolesAsignados);
    }

    @Override
    public List<RolesAsignados> findAll() {
        return rolesAsignadosRepository.findAll();
    }

    @Override
    public RolesAsignados findById(Long id) {
        Optional<RolesAsignados> result = rolesAsignadosRepository.findById(id);
        return result.orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        rolesAsignadosRepository.deleteById(id);
    }

    @Override
    public RolesAsignados update(Long id, RolesAsignados rolesAsignados) {
        return null;
    }

    @Override
    public RolesAsignados findById(RolesAsignadosId id) {
        return null;
    }
}