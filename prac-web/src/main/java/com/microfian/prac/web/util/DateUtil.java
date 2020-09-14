package com.microFian.prac.web.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    /**
     * 默认日期格式
     */
    public static String DEFAULT_FORMAT = "yyyy-MM-dd";

    /**
     * @param args
     * @throws ParseException format() 对日期进行格式化处理
     *                        parse() 将日期设置为date类型
     */
    public static void main(String[] args) throws ParseException {
        // TODO Auto-generated method stub
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d1 = sdf.parse("2016-09-08 10:10:10");
        Date d2 = sdf.parse("2016-09-26 22:00:00");
        Date d3 = sdf.parse(sdf.format(new Date()));//获得当前时间
        System.out.println(daysBetween(d1, d2));
        System.out.println(daysBetween(d2, d3));
        System.out.println(daysBetween("2016-09-08 10:10:10", "2016-09-29 00:00:00"));
        System.out.println(daysBetween("2016-09-08 10:10:10", d3));
    }

    /**
     * 计算两个日期之间相差的天数
     *
     * @param smdate 较小的时间
     * @param bdate  较大的时间
     * @return 相差天数
     * @throws ParseException calendar 对日期进行时间操作
     *                        getTimeInMillis() 获取日期的毫秒显示形式
     */
    public static int daysBetween(Date smdate, Date bdate) throws ParseException {
        Calendar cal = Calendar.getInstance();
        cal.setTime(smdate);
        long time1 = cal.getTimeInMillis();
        cal.setTime(bdate);
        long time2 = cal.getTimeInMillis();
        long between_days = (time2 - time1) / (1000 * 3600 * 24);
        return Integer.parseInt(String.valueOf(between_days));
    }

    /**
     * 字符串日期格式的计算
     */
    public static int daysBetween(String smdate, String bdate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.setTime(sdf.parse(smdate));
        long time1 = cal.getTimeInMillis();
        cal.setTime(sdf.parse(bdate));
        long time2 = cal.getTimeInMillis();
        long between_days = (time2 - time1) / (1000 * 3600 * 24);
        return Integer.parseInt(String.valueOf(between_days));
    }

    /**
     * 字符串日期格式和date日期格式的计算
     */
    public static int daysBetween(String smdate, Date bdate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.setTime(sdf.parse(smdate));
        long time1 = cal.getTimeInMillis();
        cal.setTime(bdate);
        long time2 = cal.getTimeInMillis();
        long between_days = (time2 - time1) / (1000 * 3600 * 24);
        return Integer.parseInt(String.valueOf(between_days));
    }



    public static String getNextDate(String sDate, int iDate,int iCal, String sStr){
        String sNextDate = "";
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat(sStr);
        Date date = null;
        try {
            date = formatter.parse(sDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        calendar.setTime(date);
        calendar.add(iCal, iDate);
        sNextDate = formatter.format(calendar.getTime());
        return sNextDate ;
    }


    /**
     * 格式化日期
     * @param date 日期对象
     * @return String 日期字符串
     */
    public static String formatDate(Date date){
        SimpleDateFormat f = new SimpleDateFormat(DEFAULT_FORMAT);
        String sDate = f.format(date);
        return sDate;
    }

    /**
     * 获取当年的第一天
     * @return
     */
    public static Date getCurrYearFirst(){
        Calendar currCal=Calendar.getInstance();
        int currentYear = currCal.get(Calendar.YEAR);
        return getYearFirst(currentYear);
    }

    /**
     * 获取当年的最后一天
     * @return
     */
    public static Date getCurrYearLast(){
        Calendar currCal=Calendar.getInstance();
        int currentYear = currCal.get(Calendar.YEAR);
        return getYearLast(currentYear);
    }

    /**
     * 获取某年第一天日期
     * @param year 年份
     * @return Date
     */
    public static Date getYearFirst(int year){
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, year);
        Date currYearFirst = calendar.getTime();
        return currYearFirst;
    }

    /**
     * 获取某年最后一天日期
     * @param year 年份
     * @return Date
     */
    public static Date getYearLast(int year){
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, year);
        calendar.roll(Calendar.DAY_OF_YEAR, -1);
        Date currYearLast = calendar.getTime();

        return currYearLast;
    }


}
