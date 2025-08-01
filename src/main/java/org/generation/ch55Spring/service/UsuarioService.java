package org.generation.ch55Spring.service;

import org.generation.ch55Spring.dto.UsuarioRegistroDTO;
import org.generation.ch55Spring.model.Usuarios;

import java.util.List;

public interface UsuarioService {

    Usuarios registrarUsuario(UsuarioRegistroDTO dto);

    Usuarios getUserById(Long id);

    List<Usuarios> getAllUsers();

    Usuarios validarUsuarioLogin(String correo, String contrasena);
}
