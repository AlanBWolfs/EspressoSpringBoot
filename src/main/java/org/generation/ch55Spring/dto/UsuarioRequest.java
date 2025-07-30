package org.generation.ch55Spring.dto;

import java.util.List;

public class UsuarioRequest {
    private Long idUsuario;
    private String nombre;
    private String correoElectronico;
    private List<TransaccionDTO> transacciones;

    public UsuarioRequest() {}

    public UsuarioRequest(Long idUsuario, String nombre, String correoElectronico, List<TransaccionDTO> transacciones) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.correoElectronico = correoElectronico;
        this.transacciones = transacciones;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public List<TransaccionDTO> getTransacciones() {
        return transacciones;
    }

    public void setTransacciones(List<TransaccionDTO> transacciones) {
        this.transacciones = transacciones;
    }
}
