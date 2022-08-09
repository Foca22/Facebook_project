package com.project.facebook.service;

import com.project.facebook.model.users.Users;

import java.util.List;

public interface UsersService {

    Users registerUser(Users registerUser);

    Users getUser(Integer Id);

    List<Users> getAllUsers();
}
