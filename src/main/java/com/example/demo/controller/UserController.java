package com.example.demo.controller;

import com.example.demo.domain.User;
import com.example.demo.service.UserService;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
