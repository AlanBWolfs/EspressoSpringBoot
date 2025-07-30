package org.generation.ch55Spring.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "carrito")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Carrito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_carrito", nullable = false)
    private Long idCarrito;

    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;

    //! Relaciones

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario", nullable = false,
            foreignKey = @ForeignKey(name = "fk_carrito_detalle_usuarios1"))
    private Users usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_producto", nullable = false,
            foreignKey = @ForeignKey(name = "carrito_detalle_ibfk_2"))
    private Products producto;


}