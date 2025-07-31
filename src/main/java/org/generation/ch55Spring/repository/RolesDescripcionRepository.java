package org.generation.ch55Spring.repository;

import org.generation.ch55Spring.model.RolesDescripcion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RolesDescripcionRepository extends JpaRepository<RolesDescripcion, Long> {
    // Busca un rol por su nombre (ej: "ADMIN" o "USUARIO")
    Optional<RolesDescripcion> findByRol(String rol);
}
