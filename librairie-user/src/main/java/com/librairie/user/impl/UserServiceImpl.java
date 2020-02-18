package com.librairie.user.impl;

import com.librairie.user.dto.LoginDto;
import com.librairie.user.dto.SignInDto;
import com.librairie.user.exceptions.EmailExistsException;
import com.librairie.user.exceptions.UsernameExistsException;
import com.librairie.user.model.User;
import com.librairie.user.repositories.UserRepository;
import com.librairie.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public Optional<User> findbyUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User signIn(SignInDto signInDto) throws EmailExistsException, UsernameExistsException {
        if (emailExist(signInDto.getEmail()))
            throw new EmailExistsException("L'email existe déjà !!!");
        else if (usernameExist(signInDto.getUsername()))
            throw new UsernameExistsException("Le nom d'utilisateur est déjà pris");
        else {
            User user = new User();
            user.setUsername(signInDto.getUsername());
            user.setEmail(signInDto.getEmail());
            user.setPassword(signInDto.getPassword());
            return userRepository.save(user);
        }
    }

    @Override
    public User login(LoginDto loginDto) {
        return userRepository.findByUsernameAndPassword(loginDto.getUsername(), loginDto.getPassword()).orElse(null);
    }

    public boolean emailExist(String email) {
        return userRepository.findByEmail(email).isPresent();
    }

    public boolean usernameExist(String username) {
        return userRepository.findByEmail(username).isPresent();
    }
}
