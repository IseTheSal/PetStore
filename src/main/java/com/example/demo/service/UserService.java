package com.example.demo.service;


import com.example.demo.domain.User;
import com.example.demo.repository.UserRepository;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Data
@Service
public class UserService {

    private final UserRepository userRepository;
    private final List<UUID> list;

    public HttpStatus createWithArray(User user) {
        userRepository.save(user);
        return HttpStatus.CREATED;
    }

    public void saveUUID(UUID uuid) {
        list.add(uuid);
    }

    public HttpStatus createWithList(User user) {
        userRepository.save(user);
        return HttpStatus.CREATED;
    }

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    //TODO
    // Put user


    public HttpStatus deleteByUsername(String username) {
        userRepository.deleteByUsername(username);
        return HttpStatus.OK;
    }

    public User login(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);
    }

    public Optional<User> findUserById(Integer id) {
        return userRepository.findById(id);
    }

    //TODO
    // public void logout() {}


//TODO
//    public HttpStatus create(User user, boolean check) {
//        if (check) {
//            userRepository.save(user);
//            return HttpStatus.CREATED;
//        } else return HttpStatus.NOT_FOUND;
//    }


}
