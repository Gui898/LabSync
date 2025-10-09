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
    public ResponseEntity<String> post(@RequestBody User user) {
        userService.addUser(user);
        return ResponseEntity.ok("Usuário cadastrado com sucesso!");
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable long id) {
        userService.delete(id);
        return ResponseEntity.ok("Usuário deletado com sucesso!");
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<String> put(@PathVariable long id, @RequestBody User user) {
        user.setIdUser(id);
        userService.updateUser(user);
        return ResponseEntity.ok("Usuário atualizado com sucesso!");
    }

    @Override
    @PatchMapping("/{id}")
    public ResponseEntity<String> patch(@PathVariable long id, @RequestBody User user) {
        user.setIdUser(id);
        userService.updateUser(user);
        return ResponseEntity.ok("Usuário atualizado com sucesso!");
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
