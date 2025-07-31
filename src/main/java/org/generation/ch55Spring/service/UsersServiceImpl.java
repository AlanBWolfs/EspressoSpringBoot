package org.generation.ch55Spring.service;

import lombok.RequiredArgsConstructor;
import org.generation.ch55Spring.dto.DirectionsRequest;
import org.generation.ch55Spring.model.Directions;
import org.generation.ch55Spring.model.Usuarios;
import org.generation.ch55Spring.repository.DirectionsRepository;
import org.generation.ch55Spring.repository.UsuariosRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements UsersService {

    private final UsuariosRepository usuariosRepository;
    private final DirectionsRepository directionsRepository;

    @Override
    public List<Usuarios> getAllUsers() {
        return usuariosRepository.findAll();
    }

    @Override
    public Usuarios getUserById(Long id) {
        return usuariosRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    @Override
    public Usuarios addUser(Usuarios usuario) {
        return usuariosRepository.save(usuario);
    }

    @Override
    public Usuarios deleteUserById(Long id) {
        Usuarios usuario = getUserById(id);
        usuariosRepository.delete(usuario);
        return usuario;
    }

    @Override
    public Usuarios updateUserById(Long id, Usuarios userUpdated) {
        Usuarios usuario = getUserById(id);

        usuario.setCorreoElectronico(userUpdated.getCorreoElectronico());
        usuario.setNombreUsuario(userUpdated.getNombreUsuario());
        usuario.setNumeroTelefonico(userUpdated.getNumeroTelefonico());
        usuario.setContrasena(userUpdated.getContrasena());
        usuario.setRol(userUpdated.getRol());
        // Otros campos que tengas que actualizar

        return usuariosRepository.save(usuario);
    }

    @Override
    public Usuarios addDirectionUser(Long idUsuario, DirectionsRequest directionsRequest) {
        Usuarios usuario = usuariosRepository.findById(idUsuario)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Directions nuevaDireccion = new Directions();
        nuevaDireccion.setStreet(directionsRequest.getStreet());
        nuevaDireccion.setSuburb(directionsRequest.getSuburb());
        nuevaDireccion.setZipCode(directionsRequest.getZipCode());
        nuevaDireccion.setCountry(directionsRequest.getCountry());

        // Asignar usuario a la dirección
        nuevaDireccion.setUsuario(usuario);

        // Guardar la dirección
        directionsRepository.save(nuevaDireccion);

        // Agregar la dirección a la lista de direcciones del usuario (asegúrate que directions esté inicializada)
        usuario.getDirections().add(nuevaDireccion);

        // Guardar usuario actualizado (opcional si usas cascade)
        usuariosRepository.save(usuario);

        return usuario;
    }

    @Override
    public boolean validateUser(Usuarios usuario) {
        return usuariosRepository.findByCorreoElectronico(usuario.getCorreoElectronico())
                .map(u -> u.getContrasena().equals(usuario.getContrasena()))
                .orElse(false);
    }
}
