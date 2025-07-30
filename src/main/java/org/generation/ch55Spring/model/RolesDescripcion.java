package org.generation.ch55Spring.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "roles_descripcion")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RolesDescripcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rol", nullable = false, unique = true)
    private Long idRol;  // camelCase en Java, columna sigue siendo id_rol

    @Column(name = "rol", nullable = false, length = 50)
    private String rol;
}
