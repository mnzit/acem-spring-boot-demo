package com.acem.demo.service;

import com.acem.demo.request.AttendanceRequest;
import com.acem.demo.response.Response;

import java.util.List;

public interface AttendanceService {

    Response saveAll(List<AttendanceRequest> request);
}