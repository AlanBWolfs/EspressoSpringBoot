package org.generation.ch55Spring.service;

import org.generation.ch55Spring.model.RolesDescripcion;
import org.generation.ch55Spring.repository.RolesDescripcionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolesDescripcionServiceImpl implements RolesDescripcionService {

    @Autowired
    private RolesDescripcionRepository rolesDescripcionRepository;

    @Override
    public RolesDescripcion save(RolesDescripcion rolesDescripcion) {
        return rolesDescripcionRepository.save(rolesDescripcion);
    }

    @Override
    public List<RolesDescripcion> findAll() {
        return rolesDescripcionRepository.findAll();
    }

    @Override
    public RolesDescripcion findById(Long id) {
        Optional<RolesDescripcion> result = rolesDescripcionRepository.findById(id);
        return result.orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        rolesDescripcionRepository.deleteById(id);
    }

    @Override
    public RolesDescripcion update(Long id, RolesDescripcion rolesDescripcion) {
        if (rolesDescripcionRepository.existsById(id)) {
            // Cambiar setId por setIdRol según el nombre de tu propiedad en RolesDescripcion
            rolesDescripcion.setIdRol(id);
            return rolesDescripcionRepository.save(rolesDescripcion);
        }
        return null;
    }


}