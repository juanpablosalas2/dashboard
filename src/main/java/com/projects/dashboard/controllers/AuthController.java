package com.projects.dashboard.controllers;

import com.projects.dashboard.models.Users;
import com.projects.dashboard.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @PostMapping(value = "api/login")
    public void  login(Users users){
        userService.verifyCredentials(users);
    }
}
