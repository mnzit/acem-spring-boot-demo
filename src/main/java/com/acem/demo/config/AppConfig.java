package com.acem.demo.config;

import com.acem.demo.dto.HolidayMap;
import com.acem.demo.entity.Holiday;
import com.acem.demo.repository.HolidayRepository;
import com.acem.demo.service.impl.EmailServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import javax.crypto.spec.SecretKeySpec;
import java.util.List;

@Configuration
@EnableScheduling
public class AppConfig {

    private HolidayRepository holidayRepository;
    private EmailServiceImpl emailService;

    public AppConfig(HolidayRepository holidayRepository, EmailServiceImpl emailService) {
        this.holidayRepository = holidayRepository;
        this.emailService = emailService;
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


    @Scheduled(cron = "0 * * ? * *") //every minute
//    @Scheduled(cron = "0 0 12 1 * ?") //Every month on the 1st, at noon
    public void scheduleHolidayEntityUpdate() {
        System.out.println("Scheduled Task (Every Month) : Holiday entity updated");
        emailService.sendSimpleMessage("byroxkdk71@gmail.com","attendance","attendance");
    }


}
