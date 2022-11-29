package com.acem.demo.mapper;

import com.acem.demo.model.Course;
import com.acem.demo.response.CourseResponse;
import com.acem.demo.response.SubjectResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CourseMapper {

    public CourseResponse map(Course course){
        CourseResponse.CourseResponseBuilder courseResponseBuilder = CourseResponse
                .builder()
                .name(course.getName())
                .description(course.getDescription());

        if (!course.getCourseSubjects().isEmpty()) {

            List<SubjectResponse> subjectResponses = course
                .getCourseSubjects()
                .stream()
                .map(courseSubject ->
                    SubjectResponse
                        .builder()
                        .code(courseSubject.getSubject().getCode())
                        .name(courseSubject.getSubject().getName())
                        .build()
                    ).collect(Collectors.toList());

            courseResponseBuilder.subjects(subjectResponses);
        }

        CourseResponse courseResponse = courseResponseBuilder.build();
        return courseResponse;
    }
}
