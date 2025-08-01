package org.generation.ch55Spring.dto;

public class UsuarioRegistroDTO {

    private String nombreUsuario;
    private String correoElectronico;
    private String numeroTelefonico;
    private String contrasena;
    private Long idRol;

    // Constructor vacío (necesario para frameworks como Spring)
    public UsuarioRegistroDTO() {
    }

    // Constructor con parámetros
    public UsuarioRegistroDTO(String nombreUsuario, String correoElectronico,
                              String numeroTelefonico, String contrasena, Long idRol) {
        this.nombreUsuario = nombreUsuario;
        this.correoElectronico = correoElectronico;
        this.numeroTelefonico = numeroTelefonico;
        this.contrasena = contrasena;
        this.idRol = idRol;
    }

    // Getters y Setters
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getNumeroTelefonico() {
        return numeroTelefonico;
    }

    public void setNumeroTelefonico(String numeroTelefonico) {
        this.numeroTelefonico = numeroTelefonico;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Long getIdRol() {
        return idRol;
    }

    public void setIdRol(Long idRol) {
        this.idRol = idRol;
    }
}
