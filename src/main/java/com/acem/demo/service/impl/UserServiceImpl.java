package com.acem.demo.service.impl;


import com.acem.demo.builder.ResponseBuilder;
import com.acem.demo.constant.ResponseMessageConstant;
import com.acem.demo.entity.Role;
import com.acem.demo.entity.User;
import com.acem.demo.repository.UserRepository;
import com.acem.demo.request.UserSaveRequest;
import com.acem.demo.request.mapper.UserMapperUtil;
import com.acem.demo.response.Response;
import com.acem.demo.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapperUtil userMapperUtil;

    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, UserMapperUtil userMapperUtil, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userMapperUtil = userMapperUtil;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Response getAll() {
        List<User> users = userRepository.findAll();
        Response responseBody = null;
        if (!users.isEmpty()) {
            responseBody = ResponseBuilder.success(ResponseMessageConstant.Student.ALL, users);
        } else {
            responseBody = ResponseBuilder.notFound(ResponseMessageConstant.Student.NOT_FOUND);
        }
        return responseBody;
    }

    @Override
    public Response save(UserSaveRequest request) {
        User user = userMapperUtil.mapStudent(request);

        String password = user.getPassword();
        String encodedPassword = passwordEncoder.encode(password);
        user.setPassword(encodedPassword);
        user.setRole(new Role(request.getRoleId()));
        user.setStatus(true);
        user = userRepository.save(user);
        Response responseBody = null;
        try {
            responseBody = ResponseBuilder.success(ResponseMessageConstant.Student.SAVED);
        } catch (Exception exception) {
            responseBody = ResponseBuilder.notFound(ResponseMessageConstant.Student.NOT_SAVED);
        }
        return responseBody;
    }
}