package com.shijiu.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Test {

    public static void main(String[] args) {
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Calendar c = Calendar.getInstance();
//        c.setTime(new Date());
//        c.add(Calendar.YEAR, -1);
//        Date y = c.getTime();
//        String year = format.format(y);
//        System.out.println("过去一年："+year);

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.set(c.get(Calendar.YEAR)-1 ,0, 1);//开始时间日期
        String yearStart = format.format(c.getTime());
        System.out.println(yearStart);
        Calendar ca = Calendar.getInstance();
        ca.set(ca.get(Calendar.YEAR)-1 ,11, ca.getActualMaximum(Calendar.DAY_OF_MONTH));//结束日期
        String yearEnd = format.format(ca.getTime());
        System.out.println(yearEnd);

        System.out.println(format(getNextYearPreDay() ,"yyyy-MM-dd"));
    }

    public static Date getNextYearPreDay() {
        Calendar ca = Calendar.getInstance();//得到一个Calendar的实例
        ca.setTime(new Date());   //设置时间为当前时间
        ca.add(Calendar.YEAR, +1); //年份+1
        // ca.add(Calendar.MONTH, -1); // 月份-1
        ca.add(Calendar.DATE, -1); // 日期-1
        return ca.getTime();
    }

    public static String format(Date date, String pattern) {
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.format(date);
    }
}
