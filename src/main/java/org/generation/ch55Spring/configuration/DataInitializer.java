package org.generation.ch55Spring.configuration;

import lombok.RequiredArgsConstructor;
import org.generation.ch55Spring.model.RolesDescripcion;
import org.generation.ch55Spring.repository.RolesDescripcionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class DataInitializer {

    private final RolesDescripcionRepository rolesRepository;

    @Bean
    public CommandLineRunner initRoles() {
        return args -> {
            // Busca por nombre en lugar de ID
            rolesRepository.findByRol("ADMIN")
                    .orElseGet(() -> rolesRepository.save(new RolesDescripcion(null, "ADMIN")));

            rolesRepository.findByRol("USUARIO")
                    .orElseGet(() -> rolesRepository.save(new RolesDescripcion(null, "USUARIO")));
        };
    }
}
