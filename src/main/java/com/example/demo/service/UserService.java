package com.example.demo.service;


import com.example.demo.domain.User;
import com.example.demo.repository.UserRepository;
import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Data
@Service
public class UserService {

    private final UserRepository userRepository;

    public HttpStatus createWithArray(User user) {
        userRepository.save(user);
        return HttpStatus.CREATED;
    }

    public HttpStatus createWithList(User user) {
        userRepository.save(user);
        return HttpStatus.CREATED;
    }

//    public HttpStatus create(User user, boolean check) {
//        if (check) {
//            userRepository.save(user);
//            return HttpStatus.CREATED;
//        } else return HttpStatus.NOT_FOUND;
//    }

}
