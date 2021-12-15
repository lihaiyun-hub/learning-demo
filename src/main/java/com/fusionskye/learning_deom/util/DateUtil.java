package com.fusionskye.learning_deom.util;

import java.util.*;

/**
 * @author Lowi
 * @date 2018/6/5 0005
 */
public class DateUtil {

    private static final String[] HOLIDAY = {"2021-01-01", "2021-01-02", "2021-01-03", "2021-02-11", "2021-02-12", "2021-02-13",
            "2021-02-14", "2021-02-15", "2021-02-16", "2021-02-17", "2021-04-03", "2021-04-04",
            "2021-04-05", "2021-05-01", "2021-05-02", "2021-05-03", "2021-05-04", "2021-05-05",
            "2021-06-12", "2021-06-13", "2021-06-14", "2021-09-19", "2021-09-20", "2021-09-21",
            "2021-10-01", "2021-10-02", "2021-10-03", "2021-10-04", "2021-10-05", "2021-10-06",
            "2021-10-07"};
    private static final String[] CHANGE_AS_WORKDAY = {"2021-02-07", "2021-02-20", "2021-04-25", "2021-05-08", "2021-09-18", "2021-09-26", "2021-10-09"};


    /**
     * @param calendar 传入需要验证的日期
     * @return return Date    返回类型  返回null是节假日，返回 calendar.getTime()不是节假日
     */
    public static Date checkHoliday(Calendar calendar, List<Calendar> holidayList, List<Calendar> changeAsWorkDayList) throws Exception {
        //判断日期是否是周六周日
        if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY ||
                calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
            //判断日期是否是调休
            for (Calendar ca : changeAsWorkDayList) {
                if (ca.get(Calendar.MONTH) == calendar.get(Calendar.MONTH) &&
                        ca.get(Calendar.DAY_OF_MONTH) == calendar.get(Calendar.DAY_OF_MONTH) &&
                        ca.get(Calendar.YEAR) == calendar.get(Calendar.YEAR)) {
                    return null;
                }
            }
            return calendar.getTime();

        }
        //判断日期是否是节假日
        for (Calendar ca : holidayList) {
            if (ca.get(Calendar.MONTH) == calendar.get(Calendar.MONTH) &&
                    ca.get(Calendar.DAY_OF_MONTH) == calendar.get(Calendar.DAY_OF_MONTH) &&
                    ca.get(Calendar.YEAR) == calendar.get(Calendar.YEAR)) {
                return calendar.getTime();
            }
        }
        return null;
    }

    /**
     * 初始化法定节假日列表
     *
     * @param date
     * @return
     */
    public static List<Calendar> initHolidayList(List<String> date) {
        List<Calendar> holidayList = new ArrayList<Calendar>();
        for (String string : date) {

            String[] da = string.split("-");

            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.YEAR, Integer.parseInt(da[0]));
            /**
             * 月份比正常小1,0代表一月
             */
            calendar.set(Calendar.MONTH, Integer.parseInt(da[1]) - 1);
            calendar.set(Calendar.DAY_OF_MONTH, Integer.valueOf(da[2]));
            holidayList.add(calendar);

        }
        return holidayList;
    }

    /**
     * 初始化调休日列表
     *
     * @param date
     * @return
     */
    public static List<Calendar> initChangeAsWorkDayList(List<String> date) {
        List<Calendar> changeAsWorkDayList = new ArrayList<Calendar>();
        for (String string : date) {
            String[] da = string.split("-");
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.YEAR, Integer.parseInt(da[0]));
            /**
             * 月份比正常小1,0代表一月
             */
            calendar.set(Calendar.MONTH, Integer.parseInt(da[1]) - 1);
            calendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(da[2]));
            changeAsWorkDayList.add(calendar);
        }
        return changeAsWorkDayList;
    }

    //获取每月的工作日去除法定节假日加上调休
    public static int getDays4EachMonth(String date) {
        //要计算的日期
        String date2Calculate = date;
        //获取Calendar类的对象
        Calendar calendar = Calendar.getInstance();
        //初始化Calendar对象
        String[] split = date2Calculate.split("-");
        calendar.set(Calendar.YEAR, Integer.parseInt(split[0]));
        calendar.set(Calendar.MONTH, Integer.parseInt(split[1]) - 1);
        calendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(split[2]));
        //获取每个月的总天数
        int daysEachMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        List<Calendar> workDayList = initChangeAsWorkDayList(Arrays.asList(CHANGE_AS_WORKDAY));
        List<Calendar> holidayList = initHolidayList(Arrays.asList(HOLIDAY));
        List<Date> holiday = new ArrayList<>();
        for (int i = 1; i <= daysEachMonth; i++) {
            calendar.set(Calendar.DAY_OF_MONTH, i);

            try {
                Date temp = checkHoliday(calendar, holidayList, workDayList);
                if (null != temp) {
                    holiday.add(temp);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return daysEachMonth - holiday.size();
    }

    public static void main(String[] args) throws Exception {
       /* String date = "";
        int daysForYear = 0;
        for (int i = 1; i <= 12; i++) {

            if (i < 10) {
                date = "2021-0" + i + "-01";
            } else {
                date = "2021-" + i + "-01";
            }
            int days4EachMonth = getDays4EachMonth(date);
            daysForYear += days4EachMonth;
            System.out.println(i + "月的工作日有" + days4EachMonth + "天");
        }
        System.out.println("2021年总共有" + daysForYear + "天工作日");*/
        getDays4EachMonth("2021-04-01");
    }
}