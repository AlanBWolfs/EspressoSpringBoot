package org.generation.ch55Spring.repository;

import org.generation.ch55Spring.model.RolesAsignadosId;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesAsignadosIdRepository extends JpaRepository <RolesAsignadosId, Long> {
}
