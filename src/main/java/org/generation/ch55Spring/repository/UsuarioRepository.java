package org.generation.ch55Spring.repository;

import org.generation.ch55Spring.model.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuarios, Long> {
    Usuarios findByCorreoElectronico(String correoElectronico);


}
