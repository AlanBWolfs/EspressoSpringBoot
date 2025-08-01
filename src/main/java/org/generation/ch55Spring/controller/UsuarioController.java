package org.generation.ch55Spring.controller;

import org.generation.ch55Spring.dto.LoginRequest;
import org.generation.ch55Spring.dto.UsuarioRegistroDTO;
import org.generation.ch55Spring.model.Usuarios;
import org.generation.ch55Spring.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    // ==========================
    // Registro de usuario
    // ==========================
    @PostMapping("/registro")
    public ResponseEntity<?> registrarUsuario(@RequestBody UsuarioRegistroDTO dto) {
        try {
            // Validar si ya existe el correo
            Usuarios usuarioExistente = usuarioService.getAllUsers().stream()
                    .filter(u -> u.getCorreoElectronico().equals(dto.getCorreoElectronico()))
                    .findFirst()
                    .orElse(null);

            if (usuarioExistente != null) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("El correo ya está registrado.");
            }

            Usuarios nuevoUsuario = usuarioService.registrarUsuario(dto);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevoUsuario);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al registrar usuario: " + e.getMessage());
        }
    }

    // ==========================
    // Login de usuario
    // ==========================
    @PostMapping("/login")
    public ResponseEntity<?> loginUsuario(@RequestBody LoginRequest loginRequest) {
        Usuarios usuarioValido = usuarioService.validarUsuarioLogin(
                loginRequest.getCorreoElectronico(),
                loginRequest.getContrasena()
        );

        if (usuarioValido != null) {
            return ResponseEntity.ok(usuarioValido);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("Correo o contraseña incorrectos.");
        }
    }

    // ==========================
    // Listar todos los usuarios
    // ==========================
    @GetMapping
    public ResponseEntity<?> listarUsuarios() {
        return ResponseEntity.ok(usuarioService.getAllUsers());
    }

    // ==========================
    // Obtener usuario por ID
    // ==========================
    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerUsuarioPorId(@PathVariable Long id) {
        Usuarios usuario = usuarioService.getUserById(id);
        if (usuario != null) {
            return ResponseEntity.ok(usuario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
