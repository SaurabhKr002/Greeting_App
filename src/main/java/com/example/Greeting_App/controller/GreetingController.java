package com.example.Greeting_App.controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    @GetMapping
    public Map<String, String> getGreeting() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Hello, this is a GET response!");
        return response;
    }

    @PostMapping
    public Map<String, String> postGreeting() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Hello, this is a POST response!");
        return response;
    }

    @PutMapping
    public Map<String, String> putGreeting() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Hello, this is a PUT response!");
        return response;
    }

    @DeleteMapping
    public Map<String, String> deleteGreeting() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Hello, this is a DELETE response!");
        return response;
    }
}
