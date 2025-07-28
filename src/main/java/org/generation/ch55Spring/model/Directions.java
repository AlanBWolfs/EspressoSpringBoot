package org.generation.ch55Spring.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="directions")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Directions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id", nullable = false, unique = true)
    private Long id;
    @Column(nullable = false)
    private String street;
    @Column(nullable = false)
    private String suburb;
    @Column(name="zip_code",nullable = false)
    private String zipCode;
    @Column(nullable = false)
    private String country;

    //segunda parte de la relacion
    @ManyToOne
    //llave foranea
    @JoinColumn(name="user_id", nullable = false)
    //evitar ciclio infinito
    @JsonIgnore
    private Users user;

}