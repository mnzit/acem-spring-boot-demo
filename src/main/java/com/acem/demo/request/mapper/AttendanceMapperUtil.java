package com.acem.demo.request.mapper;

import com.acem.demo.entity.Attendance;
import com.acem.demo.request.AttendanceRequest;
import com.acem.demo.request.AttendanceUpdateRequest;
import com.acem.demo.utils.ModelMapperUtil;

public class AttendanceMapperUtil {
    public static Attendance map(AttendanceRequest attendanceRequest) {
        return ModelMapperUtil.map(attendanceRequest, Attendance.class);
    }

    public static Attendance map(AttendanceUpdateRequest attendanceUpdateRequest) {
        return ModelMapperUtil.map(attendanceUpdateRequest, Attendance.class);
    }
}
