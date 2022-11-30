package com.acem.demo.utils;

import com.acem.demo.entity.Course;
import com.acem.demo.request.CourseSaveRequest;
import com.acem.demo.request.CourseUpdateRequest;

public class CourseMapperUtil {

    public static Course mapCourse(CourseSaveRequest courseSaveRequest) {
        return ModelMapperUtil.map(courseSaveRequest, Course.class);
    }

    public static Course mapCourse(CourseUpdateRequest courseUpdateRequest) {
        return ModelMapperUtil.map(courseUpdateRequest, Course.class);
    }
}
