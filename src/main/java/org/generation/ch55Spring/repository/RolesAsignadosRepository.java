package org.generation.ch55Spring.repository;

import org.generation.ch55Spring.model.RolesAsignados;
import org.generation.ch55Spring.model.RolesAsignadosId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RolesAsignadosRepository extends JpaRepository<RolesAsignados, RolesAsignadosId> {
}
