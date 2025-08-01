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
    public RolesAsignados findById(RolesAsignadosId id) {
        Optional<RolesAsignados> result = rolesAsignadosRepository.findById(id);
        return result.orElse(null);
    }

    @Override
    public void deleteById(RolesAsignadosId id) {
        rolesAsignadosRepository.deleteById(id);
    }

    @Override
    public RolesAsignados update(RolesAsignadosId id, RolesAsignados rolesAsignados) {
        Optional<RolesAsignados> existing = rolesAsignadosRepository.findById(id);
        if (existing.isPresent()) {
            RolesAsignados toUpdate = existing.get();
            // Aquí actualiza campos de toUpdate con los valores de rolesAsignados que desees
            // Ejemplo (ajusta según atributos reales):
            // toUpdate.setCampo1(rolesAsignados.getCampo1());
            // toUpdate.setCampo2(rolesAsignados.getCampo2());
            // ...
            return rolesAsignadosRepository.save(toUpdate);
        }
        return null; // O lanza excepción si prefieres
    }
}
