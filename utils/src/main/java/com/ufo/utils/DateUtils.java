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


    public static String date2SimpleString(Date date) {
        long different = new Date().getTime() - date.getTime();

        long secondsInMilli = 1000;
        long minutesInMilli = secondsInMilli * 60;
        long hoursInMilli = minutesInMilli * 60;
        long daysInMilli = hoursInMilli * 24;

        long elapsedDays = different / daysInMilli;

        if (elapsedDays == 0) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("a hh:mm");
            return dateFormat.format(date);
        } else if (elapsedDays > 0 && elapsedDays <= 1) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("a hh:mm");
            return String.format("昨天 %s", dateFormat.format(date));
        } else if (elapsedDays > 1 && elapsedDays <= 7) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("E a hh:mm");
            return dateFormat.format(date);
        } else {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日 a hh:mm");
            return dateFormat.format(date);
        }

    }

    public static boolean inTimeDiff(Date startDate, Date endDate, int minute) {
        long different = endDate.getTime() - startDate.getTime();

        long secondsInMilli = 1000;
        long minutesInMilli = secondsInMilli * 60;
        long hoursInMilli = minutesInMilli * 60;
        long daysInMilli = hoursInMilli * 24;


        long elapsedDays = different / daysInMilli;
        different = different % daysInMilli;

        if (elapsedDays > 0) {
            return true;
        }

        long elapsedHours = different / hoursInMilli;
        different = different % hoursInMilli;

        if (elapsedHours > 0) {
            return true;
        }

        long elapsedMinutes = different / minutesInMilli;

        if (elapsedMinutes >= minute) {
            return true;
        }

        return false;
    }


}
