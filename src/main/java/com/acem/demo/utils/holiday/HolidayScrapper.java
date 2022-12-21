package com.acem.demo.utils.holiday;


import com.acem.demo.constant.HolidayConstants;
import com.acem.demo.entity.Holiday;
import com.acem.demo.utils.holiday.HolidayUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.*;

public class HolidayScrapper{

    public List<Holiday> scrap(String year) {
        List<Holiday> holidayList = new ArrayList<>();
        Document doc = getDoc(buildURL(year));
        Elements tableElements = doc.select(HolidayConstants.TABLE);
        int i=0;
        String temp1, temp2;

        for(Element row: tableElements){
            //map first two element of the row.
            temp1 = row.select("td").get(0).text() + " " + year;
            temp2 = row.select("td").get(2).text() + " " + year;
            Date date = HolidayUtil.toDate(temp1);

            Holiday tempHoliday= Holiday
                    .builder()
                    .title(temp2)
                    .date(date)
                    .build();

            holidayList.add(tempHoliday);
        }
        return holidayList;
    }

    public Document getDoc(String url) {
        Document doc = null;
        try {
            doc = Jsoup.connect(url).get();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return doc;
    }

    public String buildURL(String year){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(HolidayConstants.URL);
        try{
            Long.parseLong(year);
            stringBuilder.append(year);
        }catch (NumberFormatException ex){
            System.out.println("NumberFormatException occurred. " + ex.getMessage());
        }
        stringBuilder.append("-dates/");

        return stringBuilder.toString();
    }
}
