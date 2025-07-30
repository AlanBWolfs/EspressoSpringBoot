package org.generation.ch55Spring.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "roles_asignados",
        indexes = @Index(name = "fk_idrol", columnList = "id_rol"))
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RolesAsignados {

    @EmbeddedId
    private RolesAsignadosId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idUsuario")
    @JoinColumn(name = "id_usuario", nullable = false,
            foreignKey = @ForeignKey(name = "roles_asignados_ibfk_1"))
    private Users usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idRol")
    @JoinColumn(name = "id_rol", nullable = false,
            foreignKey = @ForeignKey(name = "fk_idrol"))
    private RolesDescripcion rol;
}