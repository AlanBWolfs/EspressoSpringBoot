package org.generation.ch55Spring.controller;

import lombok.AllArgsConstructor;
import org.generation.ch55Spring.dto.DirectionsRequest;
import org.generation.ch55Spring.model.Usuarios;
import org.generation.ch55Spring.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// http://localhost:8080/api/usuarios/
@RestController
@RequestMapping(path = "/api/usuarios")
@AllArgsConstructor
public class UsersController {

    private final UsuarioService usersService;

    // GET todos los usuarios
    @GetMapping
    public List<Usuarios> getAllUsers() {
        return usersService.getAllUsers();
    }

    // GET usuario por ID
    @GetMapping(path = "/{userId}")
    public Usuarios getUserById(@PathVariable("userId") Long id) {
        return usersService.getUserById(id);
    }

    // POST crear usuario con validación de correo
    @PostMapping
    public ResponseEntity<?> addUser(@RequestBody Usuarios user) {
        boolean existeCorreo = usersService.validateUser(user);
        if (existeCorreo) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("El correo electrónico ya está registrado.");
        }

        Usuarios nuevoUsuario = usersService.addUser(user);
        return new ResponseEntity<>(nuevoUsuario, HttpStatus.CREATED);
    }

    // DELETE eliminar usuario
    @DeleteMapping(path = "/{userId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUserById(@PathVariable("userId") Long id) {
        usersService.deleteUserById(id);
    }

    // PUT actualizar usuario
    @PutMapping(path = "/{userId}")
    public Usuarios updateUserById(@PathVariable("userId") Long id, @RequestBody Usuarios user) {
        return usersService.updateUserById(id, user);
    }

    // POST agregar dirección a un usuario
    @PostMapping(path = "/{userId}/add-direction")
    public Usuarios addUserDirection(@PathVariable("userId") Long id, @RequestBody DirectionsRequest directionsRequest) {
        return usersService.addDirectionUser(id, directionsRequest);
    }

    // POST login usuario
    @PostMapping(path = "/login")
    public ResponseEntity<String> loginUser(@RequestBody Usuarios user) {
        boolean valid = usersService.validateUser(user);
        if (valid) {
            return ResponseEntity.ok("Login exitoso");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Correo o contraseña incorrectos");
        }
    }
}
