package org.generation.ch55Spring.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.generation.ch55Spring.model.Directions;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="usuarios")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Usuarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario", nullable = false, unique = true)
    private Long idUsuario;

    @Column(name = "correo_electronico", nullable = false, unique = true, length = 100)
    private String correoElectronico;

    @Column(name = "nombre_usuario", nullable = false, length = 50)
    private String nombreUsuario;

    @Column(name = "numero_telefonico", length = 10)
    private String numeroTelefonico;

    @Column(name = "contrasena", nullable = false, length = 30)
    private String contrasena;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_rol")
    private roles_descripcion rol;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = false)
    private List<Transacciones> transacciones = new ArrayList<>();

    // Uncomment and fix the directions relationship if needed
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Directions> directions = new ArrayList<>();

    // Custom getters/setters for service compatibility
    public String getEmail() {
        return this.correoElectronico;
    }
    public void setEmail(String email) {
        this.correoElectronico = email;
    }

    public String getName() {
        return this.nombreUsuario;
    }
    public void setName(String name) {
        this.nombreUsuario = name;
    }

    public String getPassword() {
        return this.contrasena;
    }
    public void setPassword(String password) {
        this.contrasena = password;
    }

    public List<Directions> getDirections() {
        return this.directions;
    }
    public void setDirections(List<Directions> directions) {
        this.directions = directions;
    }

    // Add getLastName/setLastName if needed, or map accordingly
    public String getLastName() {
        return null; // or map to a field if you have one
    }
    public void setLastName(String lastName) {
        // implement if you have a last name field
    }
}