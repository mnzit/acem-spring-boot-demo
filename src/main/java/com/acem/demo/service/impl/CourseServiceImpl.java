package com.acem.demo.service.impl;

import com.acem.demo.builder.ResponseBuilder;
import com.acem.demo.constant.ResponseMessageConstant;
import com.acem.demo.model.Course;
import com.acem.demo.repository.CourseRepository;
import com.acem.demo.response.Response;
import com.acem.demo.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    Response responseBody = null;
    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public Response getAll() {
        List<Course> course = courseRepository.findAll();
        if (!course.isEmpty()) {
            responseBody = ResponseBuilder.success(ResponseMessageConstant.Course.ALL, course);
        } else {
            responseBody = ResponseBuilder.notFound(ResponseMessageConstant.Course.NOT_FOUND);
        }
        return responseBody;
    }

    @Override
    public Response getById(Long id) {
        Optional<Course> optionalCourse = courseRepository.findById(id);
        if (optionalCourse.isPresent()) {
            Course course = optionalCourse.get();
            responseBody = ResponseBuilder.success(ResponseMessageConstant.Course.ONE, course);
        } else {
            responseBody = ResponseBuilder.notFound(ResponseMessageConstant.Course.NOT_FOUND);
        }
        return responseBody;
    }

    @Override
    public Response save(Course course) {
        Course savedCourse = courseRepository.save(course);
        if(course.equals(savedCourse)){
            responseBody = ResponseBuilder.success(ResponseMessageConstant.Student.SAVED, course);
        }
        else {
            responseBody = ResponseBuilder.notFound(ResponseMessageConstant.Student.NOT_SAVED);
        }
        return responseBody;
    }


    @Override
    public Response update(Course course) {
        Optional<Course> optionalCourse = courseRepository.findById(course.getId());
        if (optionalCourse.isPresent()) {
            courseRepository.save(course);
            responseBody = ResponseBuilder.success(ResponseMessageConstant.Course.UPDATED, course);
        } else {
            responseBody = ResponseBuilder.notFound(ResponseMessageConstant.Course.NOT_UPDATED);
        }
        return responseBody;
    }

    @Override
    public Response delete(Long id) {
        Optional<Course> optionalCourse = courseRepository.findById(id);
        Course course = optionalCourse.get();
        if(course.getId().equals(id)){
            courseRepository.deleteById(id);
            responseBody = ResponseBuilder.success(ResponseMessageConstant.Course.DELETED, course);
        }else {
            responseBody = ResponseBuilder.notFound(ResponseMessageConstant.Course.NOT_DELETED);
        }
        return responseBody;
    }
}