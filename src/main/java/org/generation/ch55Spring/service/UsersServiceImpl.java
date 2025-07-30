package org.generation.ch55Spring.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.generation.ch55Spring.dto.DirectionsRequest;
import org.generation.ch55Spring.model.Directions;
import org.generation.ch55Spring.model.Usuarios;
import org.generation.ch55Spring.repository.DirectionsRepository;
import org.generation.ch55Spring.repository.UsersRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Getter
@Setter
public class UsersServiceImpl implements UsersService {
    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;
    private final DirectionsRepository directionsRepository;

    @Override
    public List<Usuarios> getAllUsers() {
        return usersRepository.findAll();
    }

    @Override
    public Usuarios getUserById(Long id) {
        return usersRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("El usuario con el id " + id + " no existe"));
    }

    @Override
    public Usuarios addUser(Usuarios usuario) {
        String hashedPassword = this.passwordEncoder.encode(usuario.getPassword());
        usuario.setPassword(hashedPassword);
        return usersRepository.save(usuario);
    }

    @Override
    public Usuarios deleteUserById(Long id) {
        Optional<Usuarios> optionalUser = usersRepository.findById(id);
        if(optionalUser.isEmpty()) throw new IllegalArgumentException("El usuario con el id " + id + " no existe");
        usersRepository.deleteById(id);
        return optionalUser.get();
    }

    @Override
    public Usuarios updateUserById(Long id, Usuarios userUpdated) {
        Optional<Usuarios> optionalUser = usersRepository.findById(id);
        if(optionalUser.isEmpty()) throw new IllegalArgumentException("El usuario con el id " + id + " no existe");
        Usuarios usuario = optionalUser.get();
        if(userUpdated.getEmail() != null) usuario.setEmail(userUpdated.getEmail());
        if(userUpdated.getName() != null) usuario.setName(userUpdated.getName());
        if(userUpdated.getLastName() != null) usuario.setLastName(userUpdated.getLastName());
        if(userUpdated.getPassword() != null) usuario.setPassword(passwordEncoder.encode(userUpdated.getPassword()));
        return usersRepository.save(usuario);
    }

    @Override
    public Usuarios addDirectionUser(Long id, DirectionsRequest directionsRequest) {
        Usuarios usuario = usersRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("El usuario con el id " + id + " no existe"));
        Directions direction = new Directions();
        if(directionsRequest.getStreet() != null) direction.setStreet(directionsRequest.getStreet());
        if(directionsRequest.getSuburb() != null) direction.setSuburb(directionsRequest.getSuburb());
        if(directionsRequest.getCountry() != null) direction.setCountry(directionsRequest.getCountry());
        if(directionsRequest.getZipCode() != null) direction.setZipCode(directionsRequest.getZipCode());
        direction.setUser(usuario);
        directionsRepository.save(direction);
        usuario.getDirections().add(direction);
        return usersRepository.save(usuario);
    }

    @Override
    public boolean validateUser(Usuarios usuario) {
        Optional<Usuarios> optionalUser = usersRepository.findByEmail(usuario.getEmail());
        if (optionalUser.isEmpty()) throw new IllegalArgumentException("El correo o contraseña son incorrectos");
        return passwordEncoder.matches(usuario.getPassword(), optionalUser.get().getPassword());
    }
}