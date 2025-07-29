package org.generation.ch55Spring.controller;

import lombok.AllArgsConstructor;
import org.generation.ch55Spring.dto.DirectionsRequest;
import org.generation.ch55Spring.model.Usuarios;
import org.generation.ch55Spring.service.UsersService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//http://localhost:8080/api/usuarios/
@RestController
@RequestMapping(path="/api/usuarios")
@AllArgsConstructor
public class UsersController {
    private final UsersService usersService;
    @GetMapping// http://localhost:8080/api/users/
    public List<Usuarios> getAllUsers(){
        return usersService.getAllUsers();
    }

    @GetMapping(path="{userId}") // http://localhost:8080/api/users/1
    public Usuarios getUserById(@PathVariable("userId")Long id){
        return usersService.getUserById(id);
    }

    @PostMapping
    public Usuarios addUser(@RequestBody Usuarios user){
        return usersService.addUser(user);
    }

    @DeleteMapping(path = "{userId}") // http://localhost:8080/api/users/1
    public Usuarios deleteUserById(@PathVariable("userId")Long id){
        return usersService.deleteUserById(id);
    }

    @PutMapping(path = "{userId}")
    public Usuarios updateUserById(@PathVariable("userId")Long id,@RequestBody Usuarios user){
        return usersService.updateUserById(id,user);
    }

    //peticion para agregar direccion
    @PostMapping(path = "{userId}/add-direction")//http://localhost:8080/api/users/userId/add-direction
    public Usuarios addUserDirection(@PathVariable("userId")Long id, @RequestBody DirectionsRequest directionsRequest){
        return usersService.addDirectionUser(id, directionsRequest);
    }

    @PostMapping(path = "login") //http://localhost:8080/api/users/login
    public boolean loginUser(@RequestBody Usuarios user){
        return usersService.validateUser(user);
    }
}