package com.springboot.JournalApp.service;

import com.springboot.JournalApp.repository.UserRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceTests {

    @Autowired
    private UserRepository userRepository;


    @Disabled
    @Test
    public void testFindByUserName(){
        assertNotNull(userRepository.findByUserName("max"));

    }
    @ParameterizedTest
    @ValueSource(strings = {
            "max",
            "sam",
            "rony",
            "leo"
    })
    public void testFindByUserName(String name){
        assertNotNull(userRepository.findByUserName(name), "failed for : " + name);

    }
}
