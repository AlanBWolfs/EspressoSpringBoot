package org.generation.ch55Spring.dto;

import lombok.Data;

@Data
public class UsuarioRegistroDTO {
    private String nombre;             // Nombre completo
    private String correoElectronico;  // Correo
    private String contrasena;         // Contraseña
    private String numeroTelefonico;   // Teléfono (opcional)
}
