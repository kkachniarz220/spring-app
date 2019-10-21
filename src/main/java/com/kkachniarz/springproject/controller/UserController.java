package com.kkachniarz.springproject.controller;

import com.kkachniarz.springproject.models.User;
import com.kkachniarz.springproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = {"http://localhost:4200" , "http://172.17.0.43:4200"})
@RestController
@RequestMapping(path = "/user")
public class UserController {


    @Autowired
    private UserRepository userRepository;

    @PostMapping(path = "/add")
    public ResponseEntity addNewUser(@RequestBody User user) {
        userRepository.save(user);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

    @GetMapping(path = "/list")
    public @ResponseBody
    Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping(path = "/{userId}")
    public ResponseEntity getUser(@PathVariable() Integer userId) {
        try {
            Optional<User> foundUser = userRepository.findById(userId);
            System.out.println(foundUser);
            return ResponseEntity.of(foundUser);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

    }

    @PostMapping(path = "/edit/{userId}")
    public ResponseEntity editUser(@PathVariable() Integer userId, @RequestBody User user) {
        try {
            Optional<User> foundUser = userRepository.findById(userId);
            foundUser.get().setName(user.getName());
            foundUser.get().setEmail(user.getEmail());
            userRepository.save(foundUser.get());
            return new ResponseEntity(HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(path = "/delete")
    public ResponseEntity deleteUser(@RequestParam("userId") Integer userId) {
        try {
            userRepository.deleteById(userId);
            return new ResponseEntity(HttpStatus.ACCEPTED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
}
