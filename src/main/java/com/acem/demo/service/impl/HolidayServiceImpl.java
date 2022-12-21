package com.acem.demo.service.impl;

import com.acem.demo.builder.ResponseBuilder;
import com.acem.demo.constant.ResponseMessageConstant;
import com.acem.demo.entity.Holiday;
import com.acem.demo.repository.HolidayRepository;
import com.acem.demo.response.Response;
import com.acem.demo.service.HolidayService;
import com.acem.demo.utils.holiday.HolidayScrapper;
import org.joda.time.DateTime;

import java.time.LocalDate;
import java.util.List;

public class HolidayServiceImpl implements HolidayService {

    private final HolidayRepository holidayRepository;

    public HolidayServiceImpl(HolidayRepository holidayRepository) {
        this.holidayRepository = holidayRepository;
    }

    @Override
    public Response getAll() {
        List<Holiday> holidays = holidayRepository.findAll();
        Response responseBody = null;
        if (!holidays.isEmpty()) {
            responseBody = ResponseBuilder.success(ResponseMessageConstant.Holiday.ALL, holidays);
        } else {
            responseBody = ResponseBuilder.notFound(ResponseMessageConstant.Holiday.NOT_FOUND);
        }
        return responseBody;
    }

    @Override
    public Response getById(Long id) {
        return null;
    }

    @Override
    public Response saveAll() {
        DateTime dateTime = new DateTime();
        List<Holiday> holidayList = new HolidayScrapper().scrap(dateTime.getYear());
        holidayRepository.saveAll(holidayList);
        Response responseBody = null;
        try {
            responseBody = ResponseBuilder.success(ResponseMessageConstant.Holiday.SAVED, holidayList);
        } catch (Exception exception) {
            responseBody = ResponseBuilder.notFound(ResponseMessageConstant.Holiday.NOT_SAVED);
        }
        return responseBody;
    }
}
