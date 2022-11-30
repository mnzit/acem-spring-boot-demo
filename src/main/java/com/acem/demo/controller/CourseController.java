package com.acem.demo.controller;

import com.acem.demo.response.Response;
import com.acem.demo.service.CourseService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

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
}
