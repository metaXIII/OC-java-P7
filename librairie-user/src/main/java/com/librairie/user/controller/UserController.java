package com.librairie.user.controller;

import com.librairie.user.dto.LoginDto;
import com.librairie.user.dto.SignInDto;
import com.librairie.user.exceptions.BadLogInformationException;
import com.librairie.user.exceptions.EmailExistsException;
import com.librairie.user.exceptions.UsernameExistsException;
import com.librairie.user.model.User;
import com.librairie.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/api/user/")
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping(value = "/test", produces = "application/json")
    public Map<String, String> test() {
        return Collections.singletonMap("data", "the test is ok");
    }

    @PostMapping(value = "/signIn")
    public ResponseEntity signIn(@RequestBody SignInDto signInDto) throws EmailExistsException,
            UsernameExistsException {
        User user = userService.signIn(signInDto);
        if (user == null)
            System.out.println("une erreur est survenue");
        //ok
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping(value = "/login")
    public ResponseEntity login(@RequestBody LoginDto loginDto) throws BadLogInformationException {
        User user = userService.login(loginDto);
        if (user == null)
            throw new BadLogInformationException("Les informations de connexion ne sont pas correctes");
        return new ResponseEntity(Collections.singletonMap("data", user), HttpStatus.CREATED);
    }


}
