package com.acem.demo.dto;

import com.acem.demo.entity.Holiday;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class HolidayMap {

    private Map<Date, Holiday> holidayMap = new HashMap<>();

    public void setHolidayMap(List<Holiday> holidays){
        for(Holiday holiday: holidays){
            this.holidayMap.put(holiday.getDate(), holiday);
        }
    }
}
