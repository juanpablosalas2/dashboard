package com.projects.dashboard.services;

import com.projects.dashboard.models.Users;

import java.util.List;

public interface UserService {

    List<Users> getUsers();

    void deleteUsers(Long id);

    void  registerUsers(Users users);

    boolean verifyCredentials(Users users);
}
