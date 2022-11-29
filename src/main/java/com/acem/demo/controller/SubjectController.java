package com.acem.demo.controller;

import com.acem.demo.model.Subject;
import com.acem.demo.response.Response;
import com.acem.demo.service.SubjectService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/subjects")
public class SubjectController {

    private final SubjectService subjectService;

    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Response subjects() {
        return subjectService.getAll();
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response subject(@PathVariable("id") Long id) {
        return subjectService.getById(id);
    }

    @DeleteMapping(path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public Response delete(@PathVariable("id") Long id){
        return subjectService.delete(id);
    }

}
