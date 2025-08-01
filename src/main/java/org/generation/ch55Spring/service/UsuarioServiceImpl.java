package org.generation.ch55Spring.service;

import lombok.RequiredArgsConstructor;
import org.generation.ch55Spring.dto.UsuarioRegistroDTO;
import org.generation.ch55Spring.model.RolesDescripcion;
import org.generation.ch55Spring.model.Usuarios;
import org.generation.ch55Spring.repository.RolesDescripcionRepository;
import org.generation.ch55Spring.repository.UsuariosRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
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
        // Por seguridad, siempre hashea la contraseña
        usuario.setContrasena(passwordEncoder.encode(usuario.getContrasena()));
        return usuariosRepository.save(usuario);
    }

    @Override
    public Usuarios deleteUserById(Long id) {
        Optional<Usuarios> userOpt = usuariosRepository.findById(id);
        if(userOpt.isPresent()) {
            usuariosRepository.deleteById(id);
            return userOpt.get();
        }
        return null;
    }

    @Override
    public Usuarios updateUserById(Long id, Usuarios userUpdated) {
        return usuariosRepository.findById(id).map(user -> {
            user.setNombreUsuario(userUpdated.getNombreUsuario());
            user.setCorreoElectronico(userUpdated.getCorreoElectronico());
            user.setNumeroTelefonico(userUpdated.getNumeroTelefonico());
            if(userUpdated.getContrasena() != null && !userUpdated.getContrasena().isEmpty()){
                user.setContrasena(passwordEncoder.encode(userUpdated.getContrasena()));
            }
            user.setRol(userUpdated.getRol());
            return usuariosRepository.save(user);
        }).orElse(null);
    }

    @Override
    public Usuarios addDirectionUser(Long id, Object directionsRequest) {
        // Implementa según estructura directionsRequest y relación
        return null;
    }

    @Override
    public boolean validateUser(Usuarios usuario) {
        // Puedes definir aquí reglas personalizadas o dejar vacío
        return true;
    }

    @Override
    public Usuarios registrarUsuario(UsuarioRegistroDTO dto) {
        // Verificar si ya existe correo
        if (usuariosRepository.existsByCorreoElectronico(dto.getCorreoElectronico())) {
            throw new RuntimeException("El correo electrónico ya está registrado");
        }

        Usuarios nuevoUsuario = new Usuarios();
        nuevoUsuario.setNombreUsuario(dto.getNombreUsuario());
        nuevoUsuario.setCorreoElectronico(dto.getCorreoElectronico());
        nuevoUsuario.setNumeroTelefonico(dto.getNumeroTelefonico());

        // Hashear la contraseña
        nuevoUsuario.setContrasena(passwordEncoder.encode(dto.getContrasena()));

        // Asignar rol, buscar por idRol, si no existe lanzar excepción o asignar rol por defecto
        RolesDescripcion rol = rolesDescripcionRepository.findById(dto.getIdRol())
                .orElseThrow(() -> new RuntimeException("Rol no encontrado"));
        nuevoUsuario.setRol(rol);

        return usuariosRepository.save(nuevoUsuario);
    }

    @Override
    public Usuarios validarUsuarioLogin(String correo, String password) {
        Optional<Usuarios> userOpt = usuariosRepository.findByCorreoElectronico(correo);
        if(userOpt.isPresent()) {
            Usuarios usuario = userOpt.get();
            // Comparar contraseña ingresada con la almacenada (hasheada)
            if(passwordEncoder.matches(password, usuario.getContrasena())) {
                return usuario;
            }
        }
        return null; // Usuario no encontrado o contraseña incorrecta
    }
}
