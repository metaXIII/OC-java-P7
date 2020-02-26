package com.librairie.batch.controller;

import com.librairie.batch.test.Test;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api/batch/")
public class SendEmail {

    private final Test test;

    public SendEmail(Test test) {
        this.test = test;
    }


    @ResponseBody
    @GetMapping("sendEmail")
    public String sendSimpleEmail() {
        test.test();
        return "aze";
    }
}
