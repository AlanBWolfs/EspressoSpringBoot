package org.generation.ch55Spring.service;

import org.generation.ch55Spring.dto.DirectionsRequest;
import org.generation.ch55Spring.model.Users;

import java.util.List;

public interface UsersService {
    List<Users> getAllUsers();

    Users getUserById(Long id);

    Users addUser(Users user);

    Users deleteUserById(Long id);

    Users updateUserById(Long id, Users userUpdated);

    Users addDirectionUser(Long id, DirectionsRequest directionsRequest);

    boolean validateUser(Users user);
}