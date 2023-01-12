package com.acem.demo.service;

import com.acem.demo.entity.Attendance;
import com.acem.demo.request.AttendanceRequest;
import com.acem.demo.response.AttendanceResponse;
import com.acem.demo.response.IdResponse;
import com.acem.demo.response.Response;
import com.acem.demo.response.UserListResponse;

import java.util.List;

public interface AttendanceService {

    Response saveAll(List<AttendanceRequest> request);

    List<IdResponse> getAllStudents();

    Response update(Attendance attendance);

    Response getIdByEmail(String email);

    List<AttendanceResponse> getAttendanceOfStudent(Long studentId);

    List<AttendanceResponse> getAttendanceOfStudentOfByMonth(Long studentId, int month);

    List<AttendanceResponse> getAttendanceOfStudentOfCurrentMonth(Long studentId);

    List<AttendanceResponse> getAttendanceOfStudentOfLastMonth(Long studentId);

}