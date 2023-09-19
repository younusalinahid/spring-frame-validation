package org.javatechie.controller;

import org.javatechie.dto.UserRequest;
import org.javatechie.entity.User;
import org.javatechie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/signup")
    public ResponseEntity<User> saveUser(@RequestBody UserRequest userRequest) {
        return new ResponseEntity<>(service.saveUser(userRequest),HttpStatus.CREATED);
    }

    @GetMapping("/fetchAll")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(service.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable int id) {
        return ResponseEntity.ok(service.getUser(id));
    }

}
