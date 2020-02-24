package com.librairie.user.impl;

import com.librairie.user.dto.SignInDto;
import com.librairie.user.exceptions.EmailExistsException;
import com.librairie.user.exceptions.UsernameExistsException;
import com.librairie.user.model.User;
import com.librairie.user.repositories.UserRepository;
import com.librairie.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements IUserService, UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Optional<User> findbyUsername(String username) {
        return userRepository.findByUsername(username);
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
            user.setPassword(passwordEncoder.encode(signInDto.getPassword()));
            return userRepository.save(user);
        }
    }

    public boolean emailExist(String email) {
        return userRepository.findByEmail(email).isPresent();
    }

    public boolean usernameExist(String username) {
        return userRepository.findByEmail(username).isPresent();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Il n'existe pas d'utilisateurs avec le nom d'utilisateur " + username));
    }
}
