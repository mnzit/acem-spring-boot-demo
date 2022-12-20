package com.acem.demo.service.impl;

import com.acem.demo.builder.ResponseBuilder;
import com.acem.demo.constant.ResponseMessageConstant;
import com.acem.demo.entity.Attendance;
import com.acem.demo.repository.AttendanceRepository;
import com.acem.demo.request.AttendanceRequest;
import com.acem.demo.response.Response;
import com.acem.demo.service.AttendanceService;
import com.acem.demo.utils.HolidayUtil;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AttendanceServiceImpl implements AttendanceService {


    private final AttendanceRepository attendanceRepository;
    private final HolidayUtil holidayUtil;

    public AttendanceServiceImpl(AttendanceRepository attendanceRepository, HolidayUtil holidayUtil) {
        this.attendanceRepository = attendanceRepository;
        this.holidayUtil = holidayUtil;
    }

    @Override
    public Response saveAll(List<AttendanceRequest> request) {
        try{
            if(!holidayUtil.isHoliday()) {
                List<Attendance> attendances = request
                        .stream()
                        .map(attendanceRequest -> new Attendance(attendanceRequest.getId(), attendanceRequest.getState()))
                        .collect(Collectors.toList());

                attendanceRepository.saveAll(attendances);
                return ResponseBuilder.success(ResponseMessageConstant.Attendance.SAVED);
            }else{
                return ResponseBuilder.failure(ResponseMessageConstant.Attendance.NOT_SAVED);
            }

        }catch (Exception exception){
            System.out.println("Exception: "+ exception.getMessage());
            return ResponseBuilder.failure(ResponseMessageConstant.Attendance.NOT_SAVED);
        }
    }


}
