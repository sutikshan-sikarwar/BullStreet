package com.sutikshan.bullstreet.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping
    public String home(){
        return "Hello!.... Welcome to the BullStreet";
    }

    @GetMapping("/api")
    public String secure(){
        return "this API is secured!...";
    }
}
