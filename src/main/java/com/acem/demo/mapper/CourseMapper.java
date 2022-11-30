package com.acem.demo.mapper;

import com.acem.demo.entity.Course;
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

        if (!course.getSubjects().isEmpty()) {

            List<SubjectResponse> subjectResponses = course
                .getSubjects()
                .stream()
                .map(subject ->
                    SubjectResponse
                        .builder()
                        .code(subject.getCode())
                        .name(subject.getName())
                        .build()
                    ).collect(Collectors.toList());

            courseResponseBuilder.subjects(subjectResponses);
        }

        CourseResponse courseResponse = courseResponseBuilder.build();
        return courseResponse;
    }
}
