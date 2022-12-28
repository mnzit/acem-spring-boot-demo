package com.acem.demo.config;

import com.acem.demo.dto.HolidayMap;
import com.acem.demo.entity.Holiday;
import com.acem.demo.repository.HolidayRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.crypto.spec.SecretKeySpec;
import java.util.List;
@EnableScheduling
@Configuration
public class AppConfig {

    private HolidayRepository holidayRepository;

    public AppConfig(HolidayRepository holidayRepository) {
        this.holidayRepository = holidayRepository;
    }


    @Bean
    public HolidayMap holidays() {
        List<Holiday> holidayList = holidayRepository.findAll();

        HolidayMap holidayMap =  new HolidayMap();
        holidayMap.setHolidayMap(holidayList);

        return holidayMap;
    }


    @Bean
    public SecretKeySpec secretKey(){
        SecretKeySpec secretKey = new SecretKeySpec("123456789123456789123456789asdfg".getBytes(), "HmacSHA256");
        return secretKey;
    }


//    @Scheduled(fixedDelay = 1000)
//    public void scheduleFixedDelayTask() {
//        System.out.println(
//                "Fixed delay task - " + System.currentTimeMillis() / 1000);
//    }

}
