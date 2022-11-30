package com.acem.demo.controller;

import com.acem.demo.request.CourseSaveRequest;
import com.acem.demo.request.CourseUpdateRequest;
import com.acem.demo.response.Response;
import com.acem.demo.service.CourseService;
import com.acem.demo.utils.CourseMapperUtil;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;



@RestController
@RequestMapping("/courses")

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

    @PostMapping(path = "/save")
    public Response save(@RequestBody @Valid CourseSaveRequest courseSaveRequest)
    {

        return courseService.save((CourseMapperUtil.mapCourse(courseSaveRequest)));
    }

    @PutMapping (path = "/update")
    public Response update(@RequestBody @Valid CourseUpdateRequest courseUpdateRequest)
    {
        return courseService.update((CourseMapperUtil.mapCourse(courseUpdateRequest)));
    }



}
