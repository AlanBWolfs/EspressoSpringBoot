package org.generation.ch55Spring.service;

import lombok.AllArgsConstructor;
import org.generation.ch55Spring.dto.DirectionsRequest;
import org.generation.ch55Spring.model.Directions;
import org.generation.ch55Spring.model.Usuarios;
import org.generation.ch55Spring.repository.DirectionsRepository;
import org.generation.ch55Spring.repository.UsuariosRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UsersServiceImpl implements UsersService {

    private final UsuariosRepository usersRepository;
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
        // Encriptar password antes de guardar
        String hashedPassword = passwordEncoder.encode(usuario.getContrasena());
        usuario.setContrasena(hashedPassword);
        return usersRepository.save(usuario);
    }

    @Override
    public Usuarios deleteUserById(Long id) {
        Optional<Usuarios> optionalUser = usersRepository.findById(id);
        if (optionalUser.isEmpty()) {
            throw new IllegalArgumentException("El usuario con el id " + id + " no existe");
        }
        usersRepository.deleteById(id);
        return optionalUser.get();
    }

    @Override
    public Usuarios updateUserById(Long id, Usuarios userUpdated) {
        Usuarios usuario = usersRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("El usuario con el id " + id + " no existe"));

        if (userUpdated.getCorreoElectronico() != null) usuario.setCorreoElectronico(userUpdated.getCorreoElectronico());
        if (userUpdated.getNombreUsuario() != null) usuario.setNombreUsuario(userUpdated.getNombreUsuario());
        if (userUpdated.getContrasena() != null) {
            String hashedPassword = passwordEncoder.encode(userUpdated.getContrasena());
            usuario.setContrasena(hashedPassword);
        }
        return usersRepository.save(usuario);
    }

    @Override
    public Usuarios addDirectionUser(Long id, DirectionsRequest directionsRequest) {
        Usuarios usuario = usersRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("El usuario con el id " + id + " no existe"));

        Directions direction = new Directions();

        if (directionsRequest.getStreet() != null) direction.setStreet(directionsRequest.getStreet());
        if (directionsRequest.getSuburb() != null) direction.setSuburb(directionsRequest.getSuburb());
        if (directionsRequest.getCountry() != null) direction.setCountry(directionsRequest.getCountry());
        if (directionsRequest.getZipCode() != null) direction.setZipCode(directionsRequest.getZipCode());

        // Asigna el usuario al objeto dirección
        direction.setUsuario(usuario);

        directionsRepository.save(direction);

        if (usuario.getDirections() == null) {
            usuario.setDirections(new java.util.ArrayList<>());
        }

        usuario.getDirections().add(direction);
        return usersRepository.save(usuario);
    }

    @Override
    public boolean validateUser(Usuarios usuario) {
        Optional<Usuarios> optionalUser = usersRepository.findByCorreoElectronico(usuario.getCorreoElectronico());

        if (optionalUser.isEmpty()) {
            throw new IllegalArgumentException("El correo o contraseña son incorrectos");
        }

        return passwordEncoder.matches(usuario.getContrasena(), optionalUser.get().getContrasena());
    }
}
