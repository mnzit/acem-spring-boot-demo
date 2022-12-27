package com.acem.demo.utils.holiday;

import com.acem.demo.constant.HolidayConstants;
import com.acem.demo.dto.HolidayMap;
import com.acem.demo.entity.Holiday;
import org.joda.time.DateTime;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class HolidayUtil {

    private HolidayMap holidayMap;

    public HolidayUtil(HolidayMap holidayMap) {
        this.holidayMap = holidayMap;
    }

    public Boolean isHoliday(){
        Date today = new Date();
        // Check today's day of week
        DateTime dateTime = new DateTime();
        Integer dayOfWeekInteger = dateTime.getDayOfWeek();

        if (dayOfWeekInteger == 6) {
            return true;
        }

        Holiday holiday = holidayMap.getHolidayMap().get(today);
        return holiday != null;
    }

    public static Date toDate(String date){
        Date date1 = null;
        try{
            date1 = new SimpleDateFormat(HolidayConstants.DATE_FORMAT).parse(date);
            // System.out.println(date1);
        }catch (ParseException ex){
            System.out.println("ParseException occurred." + ex.getMessage());
        }
        return date1;
    }


}
