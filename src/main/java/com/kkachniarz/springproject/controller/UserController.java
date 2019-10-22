package com.kkachniarz.springproject.controller;

import com.kkachniarz.springproject.models.User;
import com.kkachniarz.springproject.repository.UserRepository;
import com.kkachniarz.springproject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "http://172.17.0.43:4200")
@RestController
@RequestMapping(path = "/user")
public class UserController {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;


    @PostMapping(path = "/add")
    public ResponseEntity addNewUser(@RequestBody User user) {
        return userService.addNewUser(user);
    }

    @GetMapping(path = "/list")
    public @ResponseBody Iterable<User> getAllUsers() {
        return userService.getUserList();
    }

    @GetMapping(path = "/{userId}")
    public ResponseEntity getUser(@PathVariable() Integer userId) {
        return userService.getUserById(userId);
    }

    @PostMapping(path = "/edit/{userId}")
    public ResponseEntity editUser(@PathVariable() Integer userId, @RequestBody User user) {
        return userService.editUserDetails(userId, user);
    }

    @DeleteMapping(path = "/delete")
    public ResponseEntity deleteUser(@RequestParam("userId") Integer userId) {
        return userService.deleteUser(userId);
    }
}
