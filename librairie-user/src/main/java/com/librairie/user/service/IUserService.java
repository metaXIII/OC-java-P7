package com.librairie.user.service;

import com.librairie.user.dto.SignInDto;
import com.librairie.user.exceptions.EmailExistsException;
import com.librairie.user.exceptions.UsernameExistsException;
import com.librairie.user.model.User;

import java.util.Optional;

public interface IUserService {
    Optional<User> findbyUsername(String username);

    User signIn(SignInDto signInDto) throws EmailExistsException, UsernameExistsException;

    boolean emailExist(String email);

    boolean usernameExist(String username);

    Optional<User> findById(long id);
}
