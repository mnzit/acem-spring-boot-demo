package com.acem.demo.controller;

import com.acem.demo.request.AttendanceRequest;
import com.acem.demo.request.AttendanceUpdateRequest;
import com.acem.demo.response.Response;
import com.acem.demo.service.AttendanceService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("attendance")
public class AttendanceController {

    private final AttendanceService attendanceService;

    public AttendanceController(AttendanceService attendanceService) {
        this.attendanceService = attendanceService;
    }
    @PostMapping
    public ResponseEntity<Response> attendance( @Validated @RequestBody List<AttendanceRequest> request) {

        Response response = attendanceService.saveAll(request);
        return ResponseEntity.ok().body(response);
    }

    public ResponseEntity<Response> update(@Validated @RequestBody AttendanceUpdateRequest request){
        return ResponseEntity.ok().body(null);
    }
}
