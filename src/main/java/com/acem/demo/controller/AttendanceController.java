package com.acem.demo.controller;

import com.acem.demo.repository.AttendanceRepository;
import com.acem.demo.request.AttendanceRequest;
import com.acem.demo.response.Response;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("attendance")
public class AttendanceController {

    private final AttendanceRepository attendanceRepository;

    public AttendanceController(AttendanceRepository attendanceRepository) {
        this.attendanceRepository = attendanceRepository;
    }

    public Response attendance(@Validated @RequestBody List<AttendanceRequest> request){
            return null;
    }

    /*
    30

    {
    "ABSENT": 0,
    "PRESENT": 10,
    "SICK": 1,
    "LEAVE": 1,
    "OPEN": 12
    }

     */

//    public Response searchAttendance(Long id, Date from, Date to){
//
//    }



}
