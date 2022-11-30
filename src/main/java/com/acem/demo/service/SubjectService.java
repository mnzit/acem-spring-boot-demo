package com.acem.demo.service;

import com.acem.demo.entity.Subject;
import com.acem.demo.response.Response;

public interface SubjectService {
    Response getAll();

    Response getById(Long id);

    Response save(Subject subject);

    Response update(Subject subject);

    Response delete(Long id);
}
