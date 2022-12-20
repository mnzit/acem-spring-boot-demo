package com.acem.demo.service;


import com.acem.demo.entity.User;
import com.acem.demo.response.Response;

public interface StudentService {

    Response getAll();

    Response getById(Long id);

    Response getByEmailAddress(String emailAddress);

    Response save(User user);

    Response update(User user);

    Response delete(Long id);

}
