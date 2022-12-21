package com.acem.demo.controller;

import com.acem.demo.builder.ResponseBuilder;
import com.acem.demo.entity.User;
import com.acem.demo.repository.UserRepository;
import com.acem.demo.request.AuthRequest;
import com.acem.demo.response.Response;
import com.acem.demo.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("users")
public class AuthController {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public AuthController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Response login(@RequestBody @Validated AuthRequest request) {

        Optional<User> optionalUser = userRepository.findByEmail(request.getEmail());

        if(optionalUser.isPresent()){
            User user = optionalUser.get();
            String password = request.getPassword();
            String encodedPassword = user.getPassword();

            boolean isPasswordMatched = passwordEncoder.matches(password,encodedPassword);

            if(isPasswordMatched){
                return ResponseBuilder.success("Login successful");
            }else{
                return ResponseBuilder.failure("Email/Password is incorrect");
            }
        }else{
            return ResponseBuilder.failure("Email/Password is incorrect");
        }
    }
}
