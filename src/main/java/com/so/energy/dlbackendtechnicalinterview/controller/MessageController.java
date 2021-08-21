package com.so.energy.dlbackendtechnicalinterview.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    @GetMapping("/messages")
    public String getMessage(){
        return "Hello from Spring Boot";
    }


}
