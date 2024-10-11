package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

// Define the QueryForm class
class QueryForm {
    private String email;
    private String query;

    // Getter and setter for email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Getter and setter for query
    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }
}

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class MyController {

    // Store form submissions in memory
    private List<QueryForm> formSubmissions = new ArrayList<>();
    @GetMapping("/")
    public String sayyHello() {
        return "Hello, This is my Home page";
    }

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, This is my first API";
    }

    // Handle POST request for form submission
    @PostMapping("/submit-form")
    public String submitForm(@RequestBody QueryForm form) {
        formSubmissions.add(form);  // Add form data to the list
        System.out.println("Received submission: " + form.getEmail() + ", " + form.getQuery());
        return "Form submitted successfully!";
    }

    // Get all submissions
    @GetMapping("/submissions")
    public List<QueryForm> getSubmissions() {
        return formSubmissions;
    }
}
