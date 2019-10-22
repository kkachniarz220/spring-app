package com.kkachniarz.springproject.services;

import com.kkachniarz.springproject.models.User;
import com.kkachniarz.springproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Iterable<User> getUserList() {
        return userRepository.findAll();
    }

    public ResponseEntity addNewUser(User user) {
        try {
            userRepository.save(user);
            return new ResponseEntity(HttpStatus.ACCEPTED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity getUserById(Integer userId) {
        try {
            Optional<User> foundUser = userRepository.findById(userId);
            return ResponseEntity.of(foundUser);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity editUserDetails(Integer userId, User newUserDetails) {
        try {
            Optional<User> foundUser = userRepository.findById(userId);
            foundUser.get().setName(newUserDetails.getName());
            foundUser.get().setEmail(newUserDetails.getEmail());
            userRepository.save(foundUser.get());

            return new ResponseEntity(HttpStatus.ACCEPTED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity deleteUser(Integer userId) {
        try {
            userRepository.deleteById(userId);
            return new ResponseEntity(HttpStatus.ACCEPTED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
}
