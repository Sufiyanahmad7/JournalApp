package com.springboot.JournalApp.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class EmailServiceTests {

    @Autowired
    private EmailService emailService;


    @Test
    void testSendMail() {
        emailService.sendEmail("",
                "Testing java mail sender",
                "siuuuuuuuuuuuu");
    }
}
