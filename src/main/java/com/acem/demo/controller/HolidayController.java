package com.acem.demo.controller;

import com.acem.demo.builder.ResponseBuilder;
import com.acem.demo.constant.ResponseMessageConstant;
import com.acem.demo.request.SubjectSaveRequest;
import com.acem.demo.request.mapper.SubjectMapperUtil;
import com.acem.demo.response.Response;
import com.acem.demo.service.HolidayService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/holidays/")
public class HolidayController {

    private final HolidayService holidayService;


    public HolidayController(HolidayService holidayService) {
        this.holidayService = holidayService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> save(@Validated @RequestBody SubjectSaveRequest subjectSaveRequest){
        Response responseBody = holidayService.saveAll();

        if(responseBody.getSuccess()){
            return new ResponseEntity<>(ResponseBuilder.success(ResponseMessageConstant.Holiday.SAVED), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(ResponseBuilder.failure(ResponseMessageConstant.Holiday.NOT_SAVED),HttpStatus.NOT_MODIFIED);
        }
    }
}
