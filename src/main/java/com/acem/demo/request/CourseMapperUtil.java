package com.acem.demo.request;

import com.acem.demo.model.Course;
import com.acem.demo.request.CourseSaveRequest;

import com.acem.demo.utils.ModalMapperUtil;

public class CourseMapperUtil {

    public static Course mapCourse(CourseSaveRequest courseSaveRequest) {
        return ModalMapperUtil.map(courseSaveRequest, Course.class);
    }

//    public static Student mapStudent(StudentUpdateRequest studentUpdateRequest) {
//        return ModalMapperUtil.map(studentUpdateRequest, Student.class);
//    }
}
