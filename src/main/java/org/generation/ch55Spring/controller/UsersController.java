package org.generation.ch55Spring.controller;

import lombok.AllArgsConstructor;
import org.apache.catalina.User;
import org.generation.ch55Spring.dto.DirectionsRequest;
import org.generation.ch55Spring.model.Users;
import org.generation.ch55Spring.service.UsersService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//http://localhost:8080/api/users
@RestController
@RequestMapping(path="/api/users")
@AllArgsConstructor
public class UsersController {
    private final UsersService usersService;
    @GetMapping// http://localhost:8080/api/users/
    public List<Users> getAllUsers(){
        return usersService.getAllUsers();
    }

    @GetMapping(path="{userId}") // http://localhost:8080/api/users/1
    public Users getUserById(@PathVariable("userId")Long id){
        return usersService.getUserById(id);
    }

    @PostMapping
    public Users addUser(@RequestBody Users user){
        return usersService.addUser(user);
    }

    @DeleteMapping(path = "{userId}") // http://localhost:8080/api/users/1
    public Users deleteUserById(@PathVariable("userId")Long id){
        return usersService.deleteUserById(id);
    }

    @PutMapping(path = "{userId}")
    public Users updateUserById(@PathVariable("userId")Long id,@RequestBody Users user){
        return usersService.updateUserById(id,user);
    }

    //peticion para agregar direccion
    @PostMapping(path = "{userId}/add-direction")//http://localhost:8080/api/users/userId/add-direction
    public Users addUserDirection(@PathVariable("userId")Long id, @RequestBody DirectionsRequest directionsRequest){
        return usersService.addDirectionUser(id, directionsRequest);
    }

    @PostMapping(path = "login") //http://localhost:8080/api/users/login
    public boolean loginUser(@RequestBody Users user){
        return usersService.validateUser(user);
    }
}