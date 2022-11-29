package com.acem.demo.controller;
import com.acem.demo.model.Attendance;
import com.acem.demo.repository.AttendanceRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Attendance> students() {
        return attendanceRepository.findAll();
    }
}
