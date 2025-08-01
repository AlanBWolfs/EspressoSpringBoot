package org.generation.ch55Spring.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "categorias")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private Long idCategoria;

    @Column(nullable = false, length = 50)
    private String nombre;

    // Una categoría tiene muchas subcategorías
    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Subcategoria> subcategorias;
}
