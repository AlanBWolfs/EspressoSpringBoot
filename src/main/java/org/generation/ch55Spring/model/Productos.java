package org.generation.ch55Spring.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "productos")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Productos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto", nullable = false, unique = true)
    private Long idProducto;

    @Column(name = "tipo", nullable = false, length = 50)
    private String tipo;

    @Column(name = "categoria", nullable = false, length = 50)
    private String categoria;

    @Column(name = "subcategoria", nullable = false, length = 50)
    private String subcategoria;

    @Column(name = "producto_nombre", nullable = false, length = 100)
    private String productoNombre;

    @Column(name = "descripcion", nullable = false, columnDefinition = "TEXT")
    private String descripcion;

    @Column(name = "precio", nullable = false, precision = 10, scale = 2)
    private BigDecimal precio;

    @Column(name = "imagen", columnDefinition = "TEXT")
    private String imagen;

    @Column(name = "en_menu")
    private Boolean enMenu = true;

}