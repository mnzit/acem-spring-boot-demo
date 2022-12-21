package com.acem.demo.service;

import com.acem.demo.entity.Holiday;
import com.acem.demo.response.Response;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HolidayService {
    Response getAll();

    Response getById(Long id);

    Response saveAll();

}
