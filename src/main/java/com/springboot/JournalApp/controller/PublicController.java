package com.springboot.JournalApp.controller;

import com.springboot.JournalApp.entity.User;
import com.springboot.JournalApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public")
public class PublicController {


    @Autowired
    private UserService userService;

    @GetMapping("/health-check")
    public String healthCheck() {
        return "ok";

    }
        @PostMapping("/create-user")
        public ResponseEntity<String> createUser(@RequestBody User user) {
            try {
                userService.saveNewEntry(user);
                return new ResponseEntity<>("User registered successfully", HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>("Error: " + e.getMessage(), HttpStatus.BAD_REQUEST);
            }
//        public void createUser(@RequestBody User user){
//
//            userService.saveNewEntry(user);
    }
}
