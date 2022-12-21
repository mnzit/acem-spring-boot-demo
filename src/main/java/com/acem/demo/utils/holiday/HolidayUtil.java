package com.acem.demo.utils.holiday;

import com.acem.demo.constant.HolidayConstants;
import com.acem.demo.entity.Holiday;
import org.joda.time.DateTime;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
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
        DateTime dateTime = new DateTime();
        Integer dayOfWeekInteger = dateTime.getDayOfWeek();

        if (dayOfWeekInteger == 6) {
            return true;
        }

        Holiday holiday = dateHolidayMap.get(today);
        return holiday != null;
    }

    public static List<Holiday> findPublicHolidays(String year){
        HolidayScrapper scrapper = new HolidayScrapper();

        return scrapper.scrap(year);
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
