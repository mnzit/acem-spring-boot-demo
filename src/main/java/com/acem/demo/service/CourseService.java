package com.acem.demo.service;

import com.acem.demo.model.Course;
import com.acem.demo.response.Response;

public interface CourseService {
    Response getAll();

    Response getById(Long id);

    Response save(Course subject);

    Response update(Course subject);

    Response delete(Long id);
}