package com.kkachniarz.springproject.controller;

import com.kkachniarz.springproject.models.User;
import com.kkachniarz.springproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping(path = "/add")
    public String addNewUser(@RequestParam String name, @RequestParam String email) {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        userRepository.save(user);
        return "OK";
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(path = "/list")
    public @ResponseBody Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping(path="/{id}")
    public ResponseEntity getUser(@PathVariable() Integer id) {
        System.out.println(id);
        try {
            Optional<User> foundUser =  userRepository.findById(id);
            System.out.println(foundUser);
            return ResponseEntity.of(foundUser);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

    }
}
