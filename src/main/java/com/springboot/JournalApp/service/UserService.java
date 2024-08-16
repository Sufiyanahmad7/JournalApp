package com.springboot.JournalApp.service;

import com.springboot.JournalApp.entity.User;
import com.springboot.JournalApp.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public void saveNewUser(User user) {
//        try {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Arrays.asList("USER"));
        userRepository.save(user);
//        }catch (DataIntegrityViolationException e) {
//            throw new RuntimeException("Username already exists");
//        }catch (Exception e){
//            System.err.println("Error saving user: " + e.getMessage());
//            throw new RuntimeException("Error saving user: " + e.getMessage());
////            e.printStackTrace();
//        }

    }

    public void saveAdmin(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Arrays.asList("USER", "ADMIN"));
        userRepository.save(user);
    }
 public void saveUser(User user){
        userRepository.save(user);
 }
    public List<User> getAll() {
        return userRepository.findAll();
    }
// Optional = it can contain data or may not
    public Optional<User> findById(ObjectId id) {
        return userRepository.findById(id);
    }

    public void deleteById(ObjectId id){
        userRepository.deleteById(id);
    }

    public User findByUserName(String userName){
       return userRepository.findByUserName(userName);
    }
}