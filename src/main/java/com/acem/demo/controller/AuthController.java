package com.acem.demo.controller;

import com.acem.demo.aspect.annotation.ExecutionTime;
import com.acem.demo.aspect.annotation.InvokedMethodLog;
import com.acem.demo.builder.ResponseBuilder;
import com.acem.demo.constant.SecurityConstant;
import com.acem.demo.entity.User;
import com.acem.demo.repository.UserRepository;
import com.acem.demo.request.AuthRequest;
import com.acem.demo.response.Response;
import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Slf4j
@RestController
public class AuthController {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private SecretKeySpec secretKeySpec;

    public AuthController(UserRepository userRepository, PasswordEncoder passwordEncoder, SecretKeySpec secretKeySpec) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.secretKeySpec = secretKeySpec;
    }

    @InvokedMethodLog
    @ExecutionTime
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping("auth")
    public ResponseEntity<Response> login(@RequestBody @Validated AuthRequest request) {
        Optional<User> optionalUser = userRepository.findByEmail(request.getEmail());

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            String password = request.getPassword();
            System.out.println("Request Password: "+ password);
            String encodedPassword = user.getPassword();
            System.out.println("Encoded Password: "+ encodedPassword);

            boolean isPasswordMatched = passwordEncoder.matches(password, encodedPassword);

            if (isPasswordMatched) {
                Date issueDate = new Date();
                Date expireDate = new Date(issueDate.getTime() + 1000 * 1000 * 60);
                Map<String, String> claimsMap = new HashMap<>();
                log.info("token issued: "+issueDate);
                log.info("token expiry: "+expireDate);
                claimsMap.put("email", user.getEmail());

                String token = Jwts
                        .builder()
                        .setClaims(claimsMap)
                        .setIssuedAt(issueDate)
                        .setExpiration(expireDate)
                        .signWith(secretKeySpec)
                        .compact();

                Response response = ResponseBuilder.success("Login successful");


                return ResponseEntity
                        .status(response.getStatusCode())
                        .header(HttpHeaders.AUTHORIZATION, SecurityConstant.BEARER + " " + token)
                        .body(response);

            } else {
                Response response = ResponseBuilder.failure("Email/Password is incorrect");
                return ResponseEntity
                        .status(response.getStatusCode())
                        .body(response);

            }
        } else {
            Response response = ResponseBuilder.failure("Email/Password is incorrect");
            return ResponseEntity
                    .status(response.getStatusCode())
                    .body(response);
        }
    }

    private static byte[] generateRandomBytes(final int size) {
        SecureRandom secureRandom = new SecureRandom();
        final byte[] key = new byte[size];
        secureRandom.nextBytes(key);
        return key;
    }
}
