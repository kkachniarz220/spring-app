package com.kkachniarz.springproject.controller;

import com.kkachniarz.springproject.models.User;
import com.kkachniarz.springproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class TestRestAPI {


    @Autowired
    UserRepository userRepository;

    @RequestMapping("/header")
    public String requestHeader(@RequestHeader("number") Long number) {
        return "Your number in header: " + number;
    }

    @RequestMapping("/param")
    public String requestParam(@RequestParam("name") String name) {
        return "Your name is: " + name;
    }

    @RequestMapping("/url/{surname}")
    public String requestUrl(@PathVariable("surname") String surname) {
        return "Your surname is: " + surname;
    }

    @PostMapping(value = "/body")
    public HttpStatus requestBody(@RequestBody User user) {
        userRepository.save(user);
        return HttpStatus.OK;
    }
}
