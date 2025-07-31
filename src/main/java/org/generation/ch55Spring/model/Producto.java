package org.generation.ch55Spring.model;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Entity
@Table(name = "productos")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Long idProducto;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "descripcion", columnDefinition = "TEXT")
    private String descripcion;

    @Column(name = "precio", precision = 10, scale = 2)
    private BigDecimal precio;

    @Column(name = "imagen", columnDefinition = "TEXT")
    private String imagen;

    @Column(name = "en_menu")
    private Boolean enMenu = true;

    @Column(name = "categoria", nullable = false, length = 100)
    private String categoria;

    @Column(name = "subcategoria", nullable = false, length = 100)
    private String subcategoria;

    @Column(name = "tipo", nullable = false, length = 50)
    private String tipo;


    // Cada producto pertenece a una sub-subcategoría
    @ManyToOne
    @JoinColumn(name = "id_subsubcategoria", nullable = true)
    private Subsubcategoria subsubcategoria;
}
