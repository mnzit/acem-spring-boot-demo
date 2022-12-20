package com.acem.demo.request.mapper;


import com.acem.demo.entity.User;
import com.acem.demo.request.StudentSaveRequest;
import com.acem.demo.request.StudentUpdateRequest;
import com.acem.demo.utils.ModelMapperUtil;

public class StudentMapperUtil {

    public static User mapStudent(StudentSaveRequest studentSaveRequest) {
        return ModelMapperUtil.map(studentSaveRequest, User.class);
    }

    public static User mapStudent(StudentUpdateRequest studentUpdateRequest) {
        return ModelMapperUtil.map(studentUpdateRequest, User.class);
    }
}
