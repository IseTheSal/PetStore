package com.example.demo.controller;


import lombok.Data;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Data
@RestController
@RequestMapping(path = "/store")
public class OrderController {

   // @PostMapping(path = "/order")

}

