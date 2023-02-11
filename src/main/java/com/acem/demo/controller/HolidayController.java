package com.acem.demo.controller;

import com.acem.demo.response.Response;
import com.acem.demo.service.HolidayService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("holidays")
public class HolidayController {

    private final HolidayService holidayService;
    public HolidayController(HolidayService holidayService) {
        this.holidayService = holidayService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Response saveAll(){
        return holidayService.saveAll();
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Response holidays() {
        return holidayService.getAll();
    }
}
