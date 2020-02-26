package com.librairie.batch.test;

import com.librairie.batch.constants.MyConstants;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class Test {

    public final JavaMailSender emailSender;

    public Test(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }

    public void test() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(MyConstants.FRIEND_EMAIL);
        message.setSubject("Test Simple Email");
        message.setText("Hello, Im testing Simple Email");
        // Send Message!
        this.emailSender.send(message);
    }
}
