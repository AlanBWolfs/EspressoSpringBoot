package org.generation.ch55Spring.service;

import lombok.AllArgsConstructor;
import org.generation.ch55Spring.dto.DirectionsRequest;
import org.generation.ch55Spring.dto.UsuarioRegistroDTO;
import org.generation.ch55Spring.model.Usuarios;
import org.generation.ch55Spring.model.RolesDescripcion;
import org.generation.ch55Spring.repository.UsuariosRepository;
import org.generation.ch55Spring.repository.RolesDescripcionRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuariosRepository usuariosRepository;
    private final RolesDescripcionRepository rolesDescripcionRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public List<Usuarios> getAllUsers() {
        return usuariosRepository.findAll();
    }

    @Override
    public Usuarios getUserById(Long id) {
        return usuariosRepository.findById(id).orElse(null);
    }

    @Override
    public Usuarios addUser(Usuarios usuario) {
        return usuariosRepository.save(usuario);
    }

    @Override
    public Usuarios deleteUserById(Long id) {
        Optional<Usuarios> usuarioOpt = usuariosRepository.findById(id);
        if (usuarioOpt.isPresent()) {
            usuariosRepository.delete(usuarioOpt.get());
            return usuarioOpt.get();
        }
        return null;
    }

    @Override
    public Usuarios updateUserById(Long id, Usuarios userUpdated) {
        return usuariosRepository.findById(id)
                .map(usuario -> {
                    usuario.setNombreUsuario(userUpdated.getNombreUsuario());
                    usuario.setCorreoElectronico(userUpdated.getCorreoElectronico());
                    usuario.setNumeroTelefonico(userUpdated.getNumeroTelefonico());
                    usuario.setContrasena(userUpdated.getContrasena());
                    usuario.setRol(userUpdated.getRol());
                    return usuariosRepository.save(usuario);
                })
                .orElse(null);
    }

    @Override
    public Usuarios addDirectionUser(Long id, DirectionsRequest directionsRequest) {
        return null; // pendiente implementación
    }

    @Override
    public boolean validateUser(Usuarios usuario) {
        return false; // pendiente implementación
    }

    @Override
    public Usuarios registrarUsuario(UsuarioRegistroDTO dto) {
        if (usuariosRepository.existsByCorreoElectronico(dto.getCorreoElectronico())) {
            throw new RuntimeException("El correo ya está registrado");
        }

        RolesDescripcion rol = rolesDescripcionRepository.findById(dto.getIdRol())
                .orElseThrow(() -> new RuntimeException("Rol no encontrado"));

        Usuarios nuevoUsuario = new Usuarios();
        nuevoUsuario.setNombreUsuario(dto.getNombreUsuario());
        nuevoUsuario.setCorreoElectronico(dto.getCorreoElectronico());
        nuevoUsuario.setNumeroTelefonico(dto.getNumeroTelefonico());
        nuevoUsuario.setContrasena(passwordEncoder.encode(dto.getContrasena()));
        nuevoUsuario.setRol(rol);

        return usuariosRepository.save(nuevoUsuario);
    }
}
