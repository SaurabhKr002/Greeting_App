package com.example.Greeting_App.service;

import com.example.Greeting_App.model.Greeting;
import com.example.Greeting_App.repository.GreetingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GreetingService {
    private final GreetingRepository greetingRepository;
    public GreetingService(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    public String getGreetingMessage() {
        return "Hello World";
    }
    public String getGreetingMessage(String firstName, String lastName) {
        if (firstName != null && lastName != null) {
            return "Hello, " + firstName + " " + lastName + "!";
        } else if (firstName != null) {
            return "Hello, " + firstName + "!";
        } else if (lastName != null) {
            return "Hello, " + lastName + "!";
        } else {
            return "Hello World";
        }
    }
    public String getGreetingById(Long id) {
        return greetingRepository.findById(id)
                .map(Greeting::getMessage)
                .orElse("Greeting not found");
    }
    public void saveGreetingMessage(String message) {
        greetingRepository.save(new Greeting(message));
    }
    public List<String> getAllGreetings() {
        return greetingRepository.findAll().stream()
                .map(Greeting::getMessage)
                .toList();
    }
    public String updateGreetingMessage(Long id, String newMessage) {
        return greetingRepository.findById(id)
                .map(greeting -> {
                    greeting.setMessage(newMessage);
                    greetingRepository.save(greeting);
                    return "Greeting updated successfully";
                })
                .orElse("Greeting not found");
    }
    public String deleteGreetingById(Long id) {
        if (greetingRepository.existsById(id)) {
            greetingRepository.deleteById(id);
            return "Greeting deleted successfully";
        } else {
            return "Greeting not found";
        }
    }
}