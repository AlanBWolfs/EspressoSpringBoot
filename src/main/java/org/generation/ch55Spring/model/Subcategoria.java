package org.generation.ch55Spring.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "subcategorias")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Subcategoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String nombre;

    // Cada subcategoría pertenece a una categoría
    @ManyToOne
    @JoinColumn(name = "id_categoria", nullable = false)
    private Categoria categoria;

    // Una subcategoría tiene muchas sub-subcategorías
    @OneToMany(mappedBy = "subcategoria", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Subsubcategoria> subsubcategorias;
}
