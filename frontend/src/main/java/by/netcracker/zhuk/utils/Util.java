package by.netcracker.zhuk.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Util {

    public static final String NOT_ALLOCATED = "Not allocated";
    public static final String WAITING_FOR_PRACTICE = "Waiting for practice";
    public static final String ON_PRACTICE = "On practice";
    public static final String AFTER_PRACTICE = "Practice ended";

    public static String compareDate(String startDate, String finishDate) {
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setTimeZone(TimeZone.getDefault());
        Date current = new Date();
        Date start = null;
        Date finish = null;
        try {
            start = sdf.parse(startDate);
            finish = sdf.parse(finishDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (current.before(start) && current.before(finish)){
            return WAITING_FOR_PRACTICE;
        } else if (current.after(start) && current.before(finish)){
            return ON_PRACTICE;
        } else if (current.after(start) && current.after(finish)){
            return AFTER_PRACTICE;
        }

        return NOT_ALLOCATED;
    }

    public static String checkStatusPractice(String dateTo, int quantity){
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Date current = new Date();
        Date finishDate = null;
        try {
            finishDate = sdf.parse(dateTo);
        }catch (ParseException e) {
            e.printStackTrace();
        }
        if(quantity > 0 || !current.after(finishDate)){
            return "Available";
        }
        else{
            return "Not available";
        }
    }
}
