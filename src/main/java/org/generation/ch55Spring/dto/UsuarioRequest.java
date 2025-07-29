package org.generation.ch55Spring.dto;

import org.generation.ch55Spring.model.Transacciones;

import java.util.List;

public class UsuarioRequest {
    private Long idUsuario;
    private String nombre;
    private String correoElectronico;
    private List<Transacciones.TransaccionDTO> transacciones;

    // Getters y setters
}
