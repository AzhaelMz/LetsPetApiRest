package com.c19_21_m_java_react.LetsPet.controller;

import com.c19_21_m_java_react.LetsPet.domain.users.RegisterUser;
import com.c19_21_m_java_react.LetsPet.domain.users.User;
import com.c19_21_m_java_react.LetsPet.domain.users.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("register")
    public ResponseEntity<User> registerUser(@RequestBody @Valid RegisterUser registerUser, UriComponentsBuilder uriComponentsBuilder){
        User user = new User(registerUser);
        user.setPassword(passwordEncoder.encode(registerUser.password()));
        userRepository.save(user);

        URI loginUrl = URI.create("http://localhost/login"); //cambiar para producción.
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(loginUrl);
        return new ResponseEntity<>(headers, HttpStatus.FOUND);
    }
}
