package com.springboot.JournalApp.controller;


import com.springboot.JournalApp.entity.User;
import com.springboot.JournalApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping
    public void createUser(@RequestBody User user){
         userService.saveEntry(user);
    }
    @PutMapping("/{userName}")
    public ResponseEntity<?> updateUser(@RequestBody User user, @PathVariable String userName) {
        User userInDb = userService.findByUserName(userName);
        if (userInDb != null) {
            userInDb.setUserName(user.getUserName());
            userInDb.setPassword(user.getPassword());
            userService.saveEntry(userInDb);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

