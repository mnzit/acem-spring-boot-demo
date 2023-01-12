package com.acem.demo.config;

import com.acem.demo.dto.HolidayMap;
import com.acem.demo.entity.Holiday;
import com.acem.demo.repository.HolidayRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class HolidayConfig {

    private final HolidayRepository holidayRepository;

    public HolidayConfig(HolidayRepository holidayRepository) {
        this.holidayRepository = holidayRepository;
    }

    @Bean
    public HolidayMap holidays() {
        List<Holiday> holidayList = holidayRepository.findAll();

        HolidayMap holidayMap =  new HolidayMap();
        holidayMap.setHolidayMap(holidayList);

        return holidayMap;
    }
}
