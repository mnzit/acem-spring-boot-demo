package com.acem.demo.service.impl;

import com.acem.demo.builder.ResponseBuilder;
import com.acem.demo.constant.ResponseMessageConstant;
import com.acem.demo.entity.Attendance;
import com.acem.demo.entity.User;
import com.acem.demo.repository.AttendanceRepository;
import com.acem.demo.repository.UserRepository;
import com.acem.demo.request.AttendanceRequest;
import com.acem.demo.response.AttendanceResponse;
import com.acem.demo.response.IdResponse;
import com.acem.demo.response.Response;
import com.acem.demo.service.AttendanceService;
import com.acem.demo.utils.holiday.HolidayUtil;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AttendanceServiceImpl implements AttendanceService {
    private final AttendanceRepository attendanceRepository;
    private final HolidayUtil holidayUtil;
    private final UserRepository userRepository;
    public AttendanceServiceImpl(AttendanceRepository attendanceRepository, HolidayUtil holidayUtil, UserRepository userRepository) {
        this.attendanceRepository = attendanceRepository;
        this.holidayUtil = holidayUtil;
        this.userRepository = userRepository;
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

    @Override
    public List<IdResponse> getAllStudents() {
        List<Long> userIdList = attendanceRepository.findAllStudentIDs();
        List<IdResponse> idResponseList = new ArrayList<>();
        for (Long id : userIdList) {
            User user = userRepository.getUserByIdIs(id);
            IdResponse idResponse = new IdResponse();
            idResponse.setEmail(user.getEmail());
            idResponse.setId(user.getId());
            idResponseList.add(idResponse);
        }
        return idResponseList;
    }

    @Override
    public Response update(Attendance attendance) {
        Optional<Attendance> optionalAttendance = attendanceRepository.findById(attendance.getId());
        Response responseBody;
        if (optionalAttendance.isPresent()) {
            attendanceRepository.save(attendance);
            responseBody = ResponseBuilder.success(ResponseMessageConstant.Attendance.UPDATED, attendance);
        } else {
            responseBody = ResponseBuilder.notFound(ResponseMessageConstant.Attendance.NOT_UPDATED);
        }
        return responseBody;
    }

    @Override
    public Response getIdByEmail(String email) {
        Long id = attendanceRepository.findIdByEmail(email);
        Response responseBody;
        if (id!=null){
            responseBody = ResponseBuilder.successIdResponse("ID found from Email Successfully", id);
        } else {
            responseBody = ResponseBuilder.notFound(ResponseMessageConstant.Attendance.NOT_UPDATED);
        }
        return responseBody;
    }

    @Override
    public List<AttendanceResponse> getAttendanceOfStudent(Long studentId) {
        AttendanceResponse attendanceResponse = new AttendanceResponse();

        List<Attendance> attendanceList = attendanceRepository.findAttendanceByStudent(studentId);
        List<AttendanceResponse> attendanceResponseList = new ArrayList<>();
        for(Attendance attendance : attendanceList){
            attendanceResponse.setCreatedDate(attendance.getCreatedDate());
            attendanceResponse.setState(attendance.getState().name());
            attendanceResponseList.add(attendanceResponse);
        }
        return attendanceResponseList;
    }

    public List<AttendanceResponse> getAttendanceOfStudentOfByMonth(Long studentId, int month){
        List<Attendance> attendanceList = attendanceRepository.findAttendanceByStudent(studentId);
        AttendanceResponse attendanceResponse = new AttendanceResponse();
        List<AttendanceResponse> attendanceResponseList = new ArrayList<>();

        Calendar calendar = Calendar.getInstance();
        for(Attendance attendance : attendanceList){
            calendar.setTime(attendance.getCreatedDate());
            int attendanceMonth = calendar.get(Calendar.MONTH);
            //january is 0, december is 11
            if(attendanceMonth+1==month){
                attendanceResponse.setCreatedDate(attendance.getCreatedDate());
                attendanceResponse.setState(attendance.getState().name());
                attendanceResponseList.add(attendanceResponse);
            }
        }
        return attendanceResponseList;
    }

    public List<AttendanceResponse> getAttendanceOfStudentOfCurrentMonth(Long studentId){
        int month = LocalDate.now().getMonthValue();
        return getAttendanceOfStudentOfByMonth(studentId, month);
    }

    public List<AttendanceResponse> getAttendanceOfStudentOfLastMonth(Long studentId){
        int month = LocalDate.now().getMonthValue();
        return getAttendanceOfStudentOfByMonth(studentId, month-1);
    }
}
