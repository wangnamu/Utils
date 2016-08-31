package com.ufo.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by tjpld on 16/8/30.
 */
public final class DateUtils {

    public static String date2string(Date date, String format) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(date);
    }

    public static Date string2date(String date, String format) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.parse(date);
    }


    public static long date2long(Date date) {
        return date.getTime() / 1000;
    }

    public static Date long2date(long time) {
        return new Date(time * 1000);
    }

    public static String diff(Date startDate, Date endDate) {

        long different = endDate.getTime() - startDate.getTime();


        long secondsInMilli = 1000;
        long minutesInMilli = secondsInMilli * 60;
        long hoursInMilli = minutesInMilli * 60;
        long daysInMilli = hoursInMilli * 24;

        long elapsedDays = different / daysInMilli;
        different = different % daysInMilli;

        long elapsedHours = different / hoursInMilli;
        different = different % hoursInMilli;

        long elapsedMinutes = different / minutesInMilli;
        different = different % minutesInMilli;

        long elapsedSeconds = different / secondsInMilli;


        if (elapsedDays > 0) {
            return elapsedDays + "天";
        }
        if (elapsedHours > 0) {
            return elapsedHours + "小时";
        }
        if (elapsedMinutes > 0) {
            return elapsedMinutes + "分钟";
        }

        return elapsedSeconds + "秒";
    }


}
