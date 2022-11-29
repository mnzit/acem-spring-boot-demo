package com.acem.demo.controller;

import com.acem.demo.model.Student;
import com.acem.demo.repository.CourseRepository;
import com.acem.demo.repository.StudentRepository;
import com.acem.demo.request.CourseMapperUtil;
import com.acem.demo.request.CourseSaveRequest;
import com.acem.demo.response.Response;
import com.acem.demo.service.CourseService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("course")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
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

    @PostMapping(path = "save")
    public Response save(@RequestBody @Valid CourseSaveRequest courseSaveRequest)
    {
        return courseService.save((CourseMapperUtil.mapCourse(courseSaveRequest)));
    }



}
