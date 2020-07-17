package com.example.demo.configuration;


import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Configuration
public class UserConfig {



    public List<UUID> tokens(){
        return new ArrayList<>();
    }
}
