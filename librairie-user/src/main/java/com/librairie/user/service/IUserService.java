package com.librairie.user.service;

import com.librairie.user.dto.LoginDto;
import com.librairie.user.dto.SignInDto;
import com.librairie.user.exceptions.EmailExistsException;
import com.librairie.user.exceptions.UsernameExistsException;
import com.librairie.user.model.User;

import java.util.Optional;

public interface IUserService {
    Optional<User> findbyUsername(String username);

    Optional<User> findByEmail(String email);

    User signIn(SignInDto signInDto) throws EmailExistsException, UsernameExistsException;

    User login(LoginDto loginDto);

    boolean emailExist(String email);

    boolean usernameExist(String username);

}
