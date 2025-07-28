package org.generation.ch55Spring.service;

import lombok.AllArgsConstructor;
import org.generation.ch55Spring.dto.DirectionsRequest;
import org.generation.ch55Spring.model.Directions;
import org.generation.ch55Spring.model.Users;
import org.generation.ch55Spring.repository.DirectionsRepository;
import org.generation.ch55Spring.repository.UsersRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UsersServiceImpl implements UsersService {
    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;
    private final DirectionsRepository directionsRepository;

    @Override
    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }

    @Override
    public Users getUserById(Long id) {
        return usersRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("El usuario con el id " + id + " no existe")
        );
    }

    @Override
    public Users addUser(Users user) {
        String hashedPassword = this.passwordEncoder.encode(user.getPassword());
        user.setPassword(hashedPassword);
        return usersRepository.save(user);
    }

    @Override
    public Users deleteUserById(Long id) {
        Optional<Users> optionalUser = usersRepository.findById(id);
        if(optionalUser.isEmpty()) throw new IllegalArgumentException("El usuario con el id " + id + " no existe");
        usersRepository.deleteById(id);
        return optionalUser.get();
    }

    @Override
    public Users updateUserById(Long id, Users userUpdated) {
        Optional<Users> optionalUser =  usersRepository.findById(id);
        if(optionalUser.isEmpty()) throw new IllegalArgumentException("El usuario con el id " + id + " no existe");
        Users user = optionalUser.get();
        if(userUpdated.getEmail() != null) user.setEmail(userUpdated.getEmail());
        if(userUpdated.getName() != null) user.setName(userUpdated.getName());
        if(userUpdated.getLastName() != null) user.setLastName(userUpdated.getLastName());
        if(userUpdated.getPassword() != null) user.setPassword(passwordEncoder.encode(userUpdated.getPassword()));
        return usersRepository.save(user);
    }

    @Override
    public Users addDirectionUser(Long id, DirectionsRequest directionsRequest) {
        Users user = usersRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("El usuario con el id " + id + " no existe")
        );
        Directions direction = new Directions();
        if(directionsRequest.getStreet() != null) direction.setStreet(directionsRequest.getStreet());
        if(directionsRequest.getSuburb() != null) direction.setSuburb(directionsRequest.getSuburb());
        if(directionsRequest.getCountry() != null) direction.setCountry(directionsRequest.getCountry());
        if(directionsRequest.getZipCode() != null) direction.setZipCode(directionsRequest.getZipCode());
        direction.setUser(user);
        directionsRepository.save(direction);
        user.getDirections().add(direction);
        return usersRepository.save(user);
    }

    @Override
    public boolean validateUser(Users user) {
        Optional<Users> optionalUser = usersRepository.findByEmail(user.getEmail());
        if (optionalUser.isEmpty()) throw new IllegalArgumentException("El correo o contraseña son incorrectos");
        return passwordEncoder.matches(user.getPassword(),optionalUser.get().getPassword());
    }
}