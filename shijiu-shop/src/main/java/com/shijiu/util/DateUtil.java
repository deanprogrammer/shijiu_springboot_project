package com.shijiu.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.SimpleFormatter;

public class DateUtil {

    public static void main(String[] args) throws ParseException {
//        Date date = new Date();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String str = "2023-12-01";
        Date date = sdf.parse(str);

        Date startQuarter = getStartQuarter(date);
        Date lastQuarter = getLastQuarter(date);

        System.out.println(sdf.format(startQuarter));
        System.out.println(sdf.format(lastQuarter));
    }


    /**
     * 获取当前日期上一季度 开始时间
     *
     * @return
     */
    public static Date getStartQuarter(Date date) {
        Calendar startCalendar = Calendar.getInstance();
        startCalendar.setTime(date);
        startCalendar.set(Calendar.MONTH, ((int) startCalendar.get(Calendar.MONTH) / 3 - 1) * 3);
        startCalendar.set(Calendar.DAY_OF_MONTH, 1);
        setMinTime(startCalendar);
        return startCalendar.getTime();
    }
    /**
     * 获取当前日期上一季度 结束时间
     * @return
     */
    public static Date getLastQuarter(Date date) {


        Calendar endCalendar = Calendar.getInstance();
        endCalendar.setTime(date);
        int month = endCalendar.get(Calendar.MONTH);
        endCalendar.set(Calendar.MONTH, (month/ 3 - 1) * 3 + 3);
        endCalendar.set(Calendar.DATE, 1);
        return new Date(endCalendar.getTime().getTime() - 24 * 60 * 60 *1000);

    }

    /**
     * 最小时间
     *
     * @param calendar
     */
    private static void setMinTime(Calendar calendar) {
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
    }

    /**
     * 最大时间
     *
     * @param calendar
     */
    private static void setMaxTime(Calendar calendar) {
        calendar.set(Calendar.HOUR_OF_DAY, calendar.getActualMaximum(Calendar.HOUR_OF_DAY));
        calendar.set(Calendar.MINUTE, calendar.getActualMaximum(Calendar.MINUTE));
        calendar.set(Calendar.SECOND, calendar.getActualMaximum(Calendar.SECOND));
        calendar.set(Calendar.MILLISECOND, calendar.getActualMaximum(Calendar.MILLISECOND));
    }
}
