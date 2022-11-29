package com.acem.demo.service.impl;


import com.acem.demo.builder.ResponseBuilder;
import com.acem.demo.constant.ResponseMessageConstant;
import com.acem.demo.model.Attendance;
import com.acem.demo.repository.AttendanceRepository;
import com.acem.demo.response.Response;
import com.acem.demo.service.AttendanceService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class AttendanceServiceImpl implements AttendanceService {

    private final AttendanceRepository attendanceRepository;

    public AttendanceServiceImpl(AttendanceRepository attendanceRepository) {
        this.attendanceRepository = attendanceRepository;
    }

    Response responseBody = null;

    @Override
    public Response getAll() {
        List<Attendance> attendances = attendanceRepository.findAll();

        if (!attendances.isEmpty()) {
            responseBody = ResponseBuilder.success(ResponseMessageConstant.Attendance.ALL, attendances);
        } else {
            responseBody = ResponseBuilder.notFound(ResponseMessageConstant.Attendance.NOT_FOUND);
        }
        return responseBody;
    }

    @Override
    public Response getById(Long id) {
        Optional<Attendance> optionalAttendance = attendanceRepository.findById(id);
        if (optionalAttendance.isPresent()) {
            Attendance attendance = optionalAttendance.get();
            responseBody = ResponseBuilder.success(ResponseMessageConstant.Attendance.ONE, attendance);
        } else {
            responseBody = ResponseBuilder.notFound(ResponseMessageConstant.Attendance.NOT_FOUND);
        }
        return responseBody;
    }

    @Override
    // findByName must be declared somewhere Return must be iterable or list
    public Response getByName(String name) {
        Optional<Attendance> optionalAttendance = attendanceRepository.findByName(name);
        if (optionalAttendance.isPresent()) {
            Attendance attendance = optionalAttendance.get();
            responseBody = ResponseBuilder.success(ResponseMessageConstant.Attendance.ONE, attendance);

        } else {
            responseBody = ResponseBuilder.notFound(ResponseMessageConstant.Attendance.NOT_FOUND);
        }
        return responseBody;
    }

    @Override
    public Response getByBatchId(String batchId) {
        Optional<Attendance> optionalAttendance = attendanceRepository.findByBatchId(batchId);
        if (optionalAttendance.isPresent()) {
            Attendance attendance = optionalAttendance.get();
            responseBody = ResponseBuilder.success(ResponseMessageConstant.Attendance.ONE, attendance);

        } else {
            responseBody = ResponseBuilder.notFound(ResponseMessageConstant.Attendance.NOT_FOUND);
        }
        return responseBody;
    }

    @Override
    public Response getByCourseId(String courseId) {
        Optional<Attendance> optionalAttendance = attendanceRepository.findByCourseId(courseId);
        if (optionalAttendance.isPresent()) {
            Attendance attendance = optionalAttendance.get();
            responseBody = ResponseBuilder.success(ResponseMessageConstant.Attendance.ONE, attendance);

        } else {
            responseBody = ResponseBuilder.notFound(ResponseMessageConstant.Attendance.NOT_FOUND);
        }
        return responseBody;
    }

    @Override  //looks like the findByData method is not present on the JPL need to declare it
    public Response getByData(String data) {
        Optional<Attendance> optionalAttendance = attendanceRepository.findByData(data);
        if (optionalAttendance.isPresent()) {
            Attendance attendance = optionalAttendance.get();
            responseBody = ResponseBuilder.success(ResponseMessageConstant.Attendance.ONE, attendance);

        } else {
            responseBody = ResponseBuilder.notFound(ResponseMessageConstant.Attendance.NOT_FOUND);
        }
        return responseBody;
    }

    @Override
    public Response save(Attendance attendance) {
        Attendance savedAttendance = attendanceRepository.save(attendance);
        if(attendance.equals(savedAttendance)){
            responseBody = ResponseBuilder.success(ResponseMessageConstant.Attendance.SAVED, attendance);
        }
        else {
            responseBody = ResponseBuilder.notFound(ResponseMessageConstant.Attendance.NOT_SAVED);
        }
        return responseBody;
    }

    @Override
    public Response update(Attendance attendance) {
        Optional<Attendance> optionalAttendance = attendanceRepository.findById(attendance.getId());
        if (optionalAttendance.isPresent()) {
            attendanceRepository.save(attendance);
            responseBody = ResponseBuilder.success(ResponseMessageConstant.Attendance.UPDATED, attendance);
        } else {
            responseBody = ResponseBuilder.notFound(ResponseMessageConstant.Attendance.NOT_UPDATED);
        }
        return responseBody;
    }

    @Override
    public Response delete(Long id) {
        Optional<Attendance> optionalAttendance = attendanceRepository.findById(id);
        Attendance attendance = optionalAttendance.get();
        if(attendance.getId().equals(id)){
            attendanceRepository.deleteById(id);
            responseBody = ResponseBuilder.success(ResponseMessageConstant.Attendance.DELETED, attendance);
        }else {
            responseBody = ResponseBuilder.notFound(ResponseMessageConstant.Attendance.NOT_DELETED);
        }
        return responseBody;
    }


}