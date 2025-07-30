package org.generation.ch55Spring.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "roles_descripcion")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RolesDescripcion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rol", nullable = false, unique = true)
    private Long id_rol;

    @Column(name = "rol", nullable = false, length = 50)
    private String rol;
}