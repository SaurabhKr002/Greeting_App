package com.example.Greeting_App.controller;

import com.example.Greeting_App.service.GreetingService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    private final GreetingService greetingService;

    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }
    @GetMapping("/{id}")
    public Map<String, String> getGreetingById(@PathVariable Long id) {
        Map<String, String> response = new HashMap<>();
        response.put("message", greetingService.getGreetingById(id));
        return response;
    }
    @GetMapping("/all")
    public List<String> getAllGreetings() {
        return greetingService.getAllGreetings();
    }

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

    @GetMapping
    public Map<String, String> getGreeting(@RequestParam(required = false) String firstName,
                                           @RequestParam(required = false) String lastName) {
        Map<String, String> response = new HashMap<>();
        response.put("message", greetingService.getGreetingMessage(firstName, lastName));
        return response;
    }

    @PostMapping
    public Map<String, String> postGreeting(@RequestParam(required = false) String firstName,
                                            @RequestParam(required = false) String lastName) {
        Map<String, String> response = new HashMap<>();
        response.put("message", greetingService.getGreetingMessage(firstName, lastName));
        return response;
    }

    @PutMapping
    public Map<String, String> putGreeting(@RequestParam(required = false) String firstName,
                                           @RequestParam(required = false) String lastName) {
        Map<String, String> response = new HashMap<>();
        response.put("message", greetingService.getGreetingMessage(firstName, lastName));
        return response;
    }

    @DeleteMapping
    public Map<String, String> deleteGreeting(@RequestParam(required = false) String firstName,
                                              @RequestParam(required = false) String lastName) {
        Map<String, String> response = new HashMap<>();
        response.put("message", greetingService.getGreetingMessage(firstName, lastName));
        return response;
    }


}