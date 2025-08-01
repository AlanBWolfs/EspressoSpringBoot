package org.generation.ch55Spring.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "usuarios")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 👈 Autoincremental
    @Column(name = "id_usuario")
    private Long idUsuario;

    @Column(name = "correo_electronico", nullable = false, unique = true, length = 100)
    private String correoElectronico;

    @Column(name = "nombre_usuario", nullable = false, length = 50)
    private String nombreUsuario;

    @Column(name = "numero_telefonico", length = 10)
    private String numeroTelefonico;

    @Column(name = "contrasena", nullable = false, length = 60) // bcrypt = 60 chars
    private String contrasena;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_rol", nullable = false)
    private RolesDescripcion rol;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = false)
    private List<Transacciones> transacciones = new ArrayList<>();

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Directions> directions = new ArrayList<>();
}
