package com.acem.demo.controller;

import com.acem.demo.model.Student;
import com.acem.demo.repository.StudentRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("course")
public class CourseController {

    private final CourseRepository courseRepository;

    public CourseController(StudentRepository studentRepository) {
        this.courseRepository = courseRepository;
    }


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Response course() {
        return courseService.getAll();
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response course(@PathVariable("id") Long id) {
        return courseService.getById(id);
    }

    @DeleteMapping(path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public Response delete(@PathVariable("id") Long id){
        return courseService.delete(id);
    }
}
