package com.librairie.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/api/user/")
public class UserController {
    @GetMapping(value = "/test", produces = "application/json")
    public Map<String, String> test() {
        return Collections.singletonMap("data", "the test is ok");
    }
}
