package org.generation.ch55Spring.repository;

import org.generation.ch55Spring.model.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Usuarios, Long> {
    Optional<Usuarios> findByEmail(String email);
}