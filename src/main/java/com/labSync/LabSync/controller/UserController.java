package com.labSync.LabSync.controller;

import com.labSync.LabSync.models.User;
import com.labSync.LabSync.service.UserService;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<User> post(@RequestBody User user) {
        User added = userService.addUser(user);
        return ResponseEntity.status(201).body(added);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<User> put(@PathVariable long id, @RequestBody User user) {
        user.setIdUser(id);
        User edited = userService.updateUser(user);
        return ResponseEntity.ok(edited);
    }

    @Override
    @PatchMapping("/{id}")
    public ResponseEntity<User> patch(@PathVariable long id, @RequestBody User user) {
        user.setIdUser(id);
        User edited = userService.updateUser(user);
        return ResponseEntity.ok(edited);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<User>  getById(@PathVariable int id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @Override
    @GetMapping
    public ResponseEntity<List<User>> getAll() {
        return ResponseEntity.ok(userService.getAllUsers());
    }
}
