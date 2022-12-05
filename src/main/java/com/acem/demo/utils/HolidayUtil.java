package com.acem.demo.utils;

import com.acem.demo.entity.Holiday;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

@Component
public class HolidayUtil {

    private Map<Date, Holiday> dateHolidayMap;

    public HolidayUtil(Map<Date, Holiday> dateHolidayMap) {
        this.dateHolidayMap = dateHolidayMap;
    }

    public Boolean isHoliday(){
        Date today = new Date();
        // Check today's day of week

        Holiday holiday = dateHolidayMap.get(today);

        return holiday != null;
    }
}
