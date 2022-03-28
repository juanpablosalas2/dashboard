package com.projects.dashboard.controllers;

import com.projects.dashboard.repository.UsersRepository;
import com.projects.dashboard.models.Users;
import com.projects.dashboard.services.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService service;


    @GetMapping(value = "api/usuarios")
    public List<Users> getUsers(){
        return service.getUsers();
    }

    @DeleteMapping(value = "api/usuarios/{id}")
    public void deleteUser(@PathVariable Long id){
        service.deleteUsers(id);
    }


    @PostMapping(value = "api/usuarios")
    public void registerUser(@RequestBody Users users){
        service.registerUsers(users);
    }


}
