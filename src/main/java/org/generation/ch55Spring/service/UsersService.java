package org.generation.ch55Spring.service;

import org.generation.ch55Spring.dto.DirectionsRequest;
import org.generation.ch55Spring.model.Usuarios;

import java.util.List;

public interface UsersService {
    List<Usuarios> getAllUsers();

    Usuarios getUserById(Long id);

    Usuarios addUser(Usuarios usuario);

    Usuarios deleteUserById(Long id);

    Usuarios updateUserById(Long id, Usuarios userUpdated);

    Usuarios addDirectionUser(Long id, DirectionsRequest directionsRequest);

    boolean validateUser(Usuarios usuario);
}
