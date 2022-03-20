package com.elenamukhina.springboot.springboot_CRUD_App.service;

import com.elenamukhina.springboot.springboot_CRUD_App.entity.User;

import java.util.List;

public interface UserService {

    List<User> getUsers();
    void saveUser(User user);
    User getUser(int id);
    void deleteUser(int id);
}
