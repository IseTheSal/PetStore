package com.example.demo.controller;

import com.example.demo.domain.User;
import com.example.demo.service.UserService;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Data
@RestController
@RequestMapping(path = "/user")
public class UserController {

    private final UserService userService;
    private final List<UUID> uuidList;

    @PostMapping(path = "/createWithArray")
    public ResponseEntity<User> createWithArray(@Valid @RequestBody User user) {
        return new ResponseEntity<>(userService.createWithArray(user));
    }

    @PostMapping(path = "/createWithList")
    public ResponseEntity<User> createWithList(@Valid @RequestBody User user) {
        return new ResponseEntity<>(userService.createWithList(user));
    }

    @GetMapping(path = "/getByUsername")
    public ResponseEntity<User> getByUsername(@Valid @RequestParam String username) {
        return new ResponseEntity<>(userService.getUserByUsername(username), HttpStatus.OK);
    }

    @GetMapping(path = "/login")
    public ResponseEntity<UUID> login(@Valid @RequestParam String username, @Valid @RequestParam String password) {
        User user = userService.login(username, password);
        if (user != null) {
            UUID uuid = UUID.fromString(password);
            userService.saveUUID(uuid);
            return new ResponseEntity<>(uuid, HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping(path = "/deleteByUsername")
    public ResponseEntity<User> deleteByUsername(@Valid @RequestParam String username) {
        return new ResponseEntity<>(userService.deleteByUsername(username));
    }

}
