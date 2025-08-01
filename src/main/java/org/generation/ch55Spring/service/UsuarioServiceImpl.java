package org.generation.ch55Spring.service;

import org.generation.ch55Spring.dto.UsuarioRegistroDTO;
import org.generation.ch55Spring.model.Usuarios;
import org.generation.ch55Spring.model.RolesDescripcion;
import org.generation.ch55Spring.repository.UsuarioRepository;
import org.generation.ch55Spring.repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RolesRepository rolesRepository;

    @Override
    public Usuarios registrarUsuario(UsuarioRegistroDTO dto) {
        Usuarios usuario = new Usuarios();
        usuario.setNombreUsuario(dto.getNombre());
        usuario.setCorreoElectronico(dto.getCorreoElectronico());

        // Guardar la contraseña tal cual (sin hash) - solo para desarrollo
        usuario.setContrasena(dto.getContrasena());

        usuario.setNumeroTelefonico(dto.getNumeroTelefonico());

        // Asignar rol cliente por defecto (ej: id 2)
        RolesDescripcion rolCliente = rolesRepository.findById(2L)
                .orElseThrow(() -> new RuntimeException("Rol cliente no encontrado"));
        usuario.setRol(rolCliente);

        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuarios getUserById(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    @Override
    public List<Usuarios> getAllUsers() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuarios validarUsuarioLogin(String correo, String contrasena) {
        Usuarios usuario = usuarioRepository.findByCorreoElectronico(correo);
        if (usuario != null) {
            // Comparación simple sin hash - solo para desarrollo, NO usar en producción
            if (contrasena.equals(usuario.getContrasena())) {
                return usuario;
            }
        }
        return null;
    }
}
