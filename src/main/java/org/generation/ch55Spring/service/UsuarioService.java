package org.generation.ch55Spring.service;

import org.generation.ch55Spring.dto.UsuarioRegistroDTO;
import org.generation.ch55Spring.model.Usuarios;

import java.util.List;

public interface UsuarioService {

    List<Usuarios> getAllUsers();

    Usuarios getUserById(Long id);

    Usuarios addUser(Usuarios usuario);

    Usuarios deleteUserById(Long id);

    Usuarios updateUserById(Long id, Usuarios userUpdated);

    Usuarios addDirectionUser(Long id, Object directionsRequest); // Puedes definir mejor el tipo después

    boolean validateUser(Usuarios usuario);

    Usuarios registrarUsuario(UsuarioRegistroDTO dto);

    // Método para login: validar correo y contraseña
    Usuarios validarUsuarioLogin(String correoElectronico, String password);

}
