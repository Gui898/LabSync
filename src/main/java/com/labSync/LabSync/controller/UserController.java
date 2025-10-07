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
        userService.addUser(user);
        return user;
    }

    @Override
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable long id) {
        userService.delete(id);
        return true;
    }

    @Override
    @PutMapping("/{id}")
    public User put(@PathVariable long id, @RequestBody User user) {
        user.setIdUser(id);
        userService.updateUser(user);
        return user;
    }

    @Override
    @PatchMapping("/{id}")
    public User patch(@PathVariable long id, @RequestBody User user) {
        user.setIdUser(id);
        userService.updateUser(user);
        return user;
    }

    @Override
    @GetMapping("/{id}")
    public User getById(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @Override
    @GetMapping
    public List<User> getAll() {
        return userService.getAllUsers();
    }
}
