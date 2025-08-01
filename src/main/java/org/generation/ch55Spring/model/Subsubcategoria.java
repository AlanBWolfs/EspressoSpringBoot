package org.generation.ch55Spring.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "subsubcategorias")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Subsubcategoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String nombre;

    // Cada sub-subcategoría pertenece a una subcategoría
    @ManyToOne
    @JoinColumn(name = "id_subcategoria", nullable = false)
    private Subcategoria subcategoria;

    // Una sub-subcategoría tiene muchos productos
    @OneToMany(mappedBy = "subsubcategoria", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Producto> productos;
}
