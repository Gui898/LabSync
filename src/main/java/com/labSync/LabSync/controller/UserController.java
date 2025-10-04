package com.labSync.LabSync.controller;

import com.labSync.LabSync.models.User;
import com.labSync.LabSync.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class UserController implements ProtocolMethods<User>{

    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Override
    @PostMapping
    public User post(@RequestBody User user) {
        return userService.addUser(user);
    }

    @Override
    public boolean delete(User user) {
        return true;
    }

    @Override
    public User put(User entity) {
        return null;
    }

    @Override
    public User patch(User entity) {
        return null;
    }

    @Override
    public User getById(int id) {
        return null;
    }

    @Override
    public List<User> getAll() {
        return List.of();
    }
}
