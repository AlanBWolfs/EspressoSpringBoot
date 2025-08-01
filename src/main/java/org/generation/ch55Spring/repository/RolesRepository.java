package org.generation.ch55Spring.repository;

import org.generation.ch55Spring.model.RolesDescripcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesRepository extends JpaRepository<RolesDescripcion, Long> {
}
