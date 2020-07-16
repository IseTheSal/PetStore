package com.example.demo.controller;

import com.example.demo.domain.User;
import com.example.demo.service.UserService;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Data
@RestController
@RequestMapping(path = "/user")
public class UserController {

    private final UserService userService;

    @PostMapping(path = "/createWithArray")
    public ResponseEntity<User> createWithArray(@RequestBody User user) {
        return new ResponseEntity<>(userService.createWithArray(user));
    }

    @PostMapping(path = "/createWithList")
    public ResponseEntity<User> createWithList(@RequestBody User user) {
        return new ResponseEntity<>(userService.createWithList(user));
    }

    @GetMapping(path = "/getByUsername")
    public ResponseEntity<User> getByUsername(@RequestParam String username) {
        return new ResponseEntity<>(userService.getUserByUsername(username), HttpStatus.OK);
    }

    @GetMapping(path = "/login")
    public ResponseEntity<User> login(@RequestParam String username, @RequestParam String password) {
        User user = userService.login(username, password);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }


    @DeleteMapping(path = "/deleteByUsername")
    public ResponseEntity<User> deleteByUsername(@RequestParam String username) {
        return new ResponseEntity<>(userService.deleteByUsername(username));
    }

}
