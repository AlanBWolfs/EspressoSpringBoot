package org.generation.ch55Spring.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "favoritos",
        indexes = @Index(name = "id_product", columnList = "id_producto"))
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Favoritos {

    @EmbeddedId
    private FavoritosId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idUsuario")
    @JoinColumn(name = "id_usuario", nullable = false,
            foreignKey = @ForeignKey(name = "favoritos_ibfk_1"))
    private Users usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idProducto")
    @JoinColumn(name = "id_producto", nullable = false,
            foreignKey = @ForeignKey(name = "favoritos_ibfk_2"))
    private Products producto;
}