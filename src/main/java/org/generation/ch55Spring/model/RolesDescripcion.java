package org.generation.ch55Spring.model;

import jakarta.persistence.*;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "roles_descripcion")
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class RolesDescripcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rol", nullable = false, unique = true)
    private Long idRol;

    @Column(name = "rol", nullable = false, length = 50)
    private String rol;

    // No es necesario ningún método manual para setIdRol ni getIdRol
}
