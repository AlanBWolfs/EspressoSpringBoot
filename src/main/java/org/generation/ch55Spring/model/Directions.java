package org.generation.ch55Spring.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="directions")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Directions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_direccion")
    private Long idDireccion;

    @Column(nullable = false)
    private String street;

    @Column(nullable = false)
    private String suburb;

    @Column(name="zip_code", nullable = false)
    private String zipCode;

    @Column(nullable = false)
    private String country;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_usuario", nullable = false)
    @JsonIgnore
    private Usuarios usuario;

}
