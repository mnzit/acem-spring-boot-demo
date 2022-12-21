package com.acem.demo.service;


import com.acem.demo.entity.User;
import com.acem.demo.request.UserSaveRequest;
import com.acem.demo.response.Response;

public interface UserService {

    Response getAll();

    Response save(UserSaveRequest request);

}
