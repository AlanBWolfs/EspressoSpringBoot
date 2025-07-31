package org.generation.ch55Spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.generation.ch55Spring.model.Usuarios;
import java.util.Optional;

public interface UsuariosRepository extends JpaRepository<Usuarios, Long> {
    Optional<Usuarios> findByCorreoElectronico(String correoElectronico);
    boolean existsByCorreoElectronico(String correoElectronico);
}
