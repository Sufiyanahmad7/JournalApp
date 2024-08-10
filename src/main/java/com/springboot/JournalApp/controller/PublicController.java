package com.springboot.JournalApp.controller;

import com.springboot.JournalApp.entity.User;
import com.springboot.JournalApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
        public void createUser(@RequestBody User user){
            userService.saveNewEntry(user);
    }
}
