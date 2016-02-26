package com.smart.shop.base.utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/**
 * 日期/时间工具类
 * <p/>
 * 提供有关日期/时间的常用静态操作方法
 */
public class DateTimeUtils {

    /**
     * 日期格式:数据库日期格式(yyyyMMdd)
     */
    public static SimpleDateFormat FORMAT_DATE_DB = new SimpleDateFormat(
            "yyyyMMdd");

    /**
     * 日期格式:时间格式(HHmmss)
     */
    public static SimpleDateFormat FORMAT_TIME = new SimpleDateFormat(
            "HHmmss");

    /**
     * 日期格式:小时分钟格式(HHmm)
     */
    public static SimpleDateFormat FORMAT_HOUR_MINUTE = new SimpleDateFormat(
            "HHmm");

    /**
     * 日期格式：页面时间格式(HH:mm:ss)
     */
    public static SimpleDateFormat FORMAT_TIME_PAGE = new SimpleDateFormat(
            "HH:mm:ss");

    /**
     * 日期格式:页面日期格式(yyyy-MM-dd)
     */
    public static SimpleDateFormat FORMAT_DATE_PAGE = new SimpleDateFormat(
            "yyyy-MM-dd");

    /**
     * 日期格式:银行日期时间格式(yyyyMMddHHmmss)
     */
    public static SimpleDateFormat FORMAT_DATETIME_BACKEND = new SimpleDateFormat(
            "yyyyMMddHHmmss");

    /**
     * 日期格式:本地日期明码格式(yyyy年MM月dd HH:mm:ss)
     */
    public static SimpleDateFormat FORMAT_LOCAL = new SimpleDateFormat(
            "yyyy年MM月dd HH:mm:ss");

    /**
     * 日期格式:本地日期明码格式(yyyy-MM-dd HH:mm:ss)
     */
    public static SimpleDateFormat FORMAT_FULL_DATETIME = new SimpleDateFormat(
            "yyyy-MM-dd HH:mm:ss");

    /**
     * 日期格式:完整日期/时间格式
     */
    public static SimpleDateFormat EXAC_DATE_TIME_FORMAT = new SimpleDateFormat(
            "yyyy-MM-dd HH:mm:ss,S");

    /**
     * 日期格式:(yyyy)
     */
    public static SimpleDateFormat FORMAT_DATE_YEAR = new SimpleDateFormat(
            "yyyy");

    public static long dateSecond = 24 * 60 * 60 * 1000;


    /**
     * 验证日期字符串是否为[yyyy-MM-dd]格式
     *
     * @param dateStr 日期字符串
     * @return 日期字符串是[yyyy-MM-dd]格式返回<code>true</code>；否则返回<code>false</code>
     */
    public static boolean isPageDateStr(String dateStr) {
        try {
            FORMAT_DATE_PAGE.parse(dateStr);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }

    /**
     * 验证日期字符串是否为[yyyyMMdd]格式
     *
     * @param dateStr 日期字符串
     * @return 日期字符串是[yyyyMMdd]格式返回<code>true</code>；否则返回<code>false</code>
     */
    public static boolean isDBDateStr(String dateStr) {
        try {
            FORMAT_DATE_DB.parse(dateStr);
        } catch (ParseException e) {
            return false;
        }

        return true;
    }

    /**
     * 取得当前年字符串; 格式:yyyy
     *
     * @return 格式[yyyy]的当前年字符串
     */
    public static String getCurrentYearStr() {
        return FORMAT_DATE_YEAR.format(new Date());
    }

    /**
     * Date -> String(yyyyMMdd)
     *
     * @param date <code>Date</code> 对象
     * @return [yyyyMMdd]格式的日期字符串
     */
    public static String formatDbDate(Date date) {
        if (date == null) {
            return "";
        }

        return FORMAT_DATE_DB.format(date);
    }

    /**
     * String[yyyy-MM-dd HH:mm:ss]-> String[yyyyMMdd]
     *
     * @param fullTime [yyyy-MM-dd HH:mm:ss]格式日期字符串
     * @return [yyyyMMdd]格式日期字符串
     */
    public static String convertDbDateByFullTime(String fullTime) {
        Date fullDate = parseFullDateTime(fullTime);
        return formatDbDate(fullDate);
    }

    /**
     * String(yyyyMMdd) -> Date
     *
     * @param strDate [yyyyMMdd]格式日期字符串
     * @return 解析成功返回<code>Date</code> 对象，否则抛出<code>RuntimeException</code>异常
     */
    public static Date parseDbDate(String strDate) {
        if (strDate == null) {
            return null;
        }

        try {
            return FORMAT_DATE_DB.parse(strDate);
        } catch (ParseException e) {
            throw new RuntimeException("将字符串" + strDate + "解析为"
                    + FORMAT_DATE_DB.toPattern() + "格式的日期时发生异常:", e);
        }
    }

    /**
     * String(yyyy-MM-dd) -> Date
     *
     * @param strDate [yyyy-MM-dd]格式日期字符串
     * @return 解析成功返回<code>Date</code> 对象，否则抛出<code>RuntimeException</code>异常
     */
    public static Date parsePageDate(String strDate) {
        if (strDate == null) {
            return null;
        }

        try {
            return FORMAT_DATE_PAGE.parse(strDate);
        } catch (ParseException e) {
            throw new RuntimeException("将字符串" + strDate + "解析为"
                    + FORMAT_DATE_DB.toPattern() + "格式的日期时发生异常:", e);
        }
    }

    /**
     * String(yyyyMMddHHmmss) -> Date
     *
     * @param dateTime 时间字符串(yyyyMMddHHmmss)
     * @return 解析成功返回<code>Date</code> 对象，否则抛出<code>RuntimeException</code>异常
     */
    public static Date parseBackendDateTime(String dateTime) {
        if (dateTime == null) {
            return null;
        }

        try {
            return FORMAT_DATETIME_BACKEND.parse(dateTime);
        } catch (ParseException e) {
            throw new RuntimeException("将字符串" + dateTime + "解析为"
                    + FORMAT_DATETIME_BACKEND.toPattern() + "格式的日期时发生异常:", e);
        }
    }

    /**
     * String(yyyy-MM-dd HH:mm:ss) -> Date
     *
     * @param dateTime 时间字符串(yyyy-MM-dd HH:mm:ss)
     * @return 解析成功返回<code>Date</code> 对象，否则抛出<code>RuntimeException</code>异常
     */
    public static Date parseFullDateTime(String dateTime) {
        if (dateTime == null) {
            return null;
        }

        try {
            return FORMAT_FULL_DATETIME.parse(dateTime);
        } catch (ParseException e) {
            throw new RuntimeException("将字符串" + dateTime + "解析为"
                    + FORMAT_FULL_DATETIME.toPattern() + "格式的日期时发生异常:", e);
        }
    }

    /**
     * String(yyyy-MM-dd HH:mm:ss,S) -> Date
     *
     * @param dateTime 时间字符串(yyyy-MM-dd HH:mm:ss,S)
     * @return 解析成功返回<code>Date</code> 对象，否则抛出<code>RuntimeException</code>异常
     */
    public static Date parseExacDateTime(String dateTime) {
        if (dateTime == null) {
            return null;
        }

        try {
            return EXAC_DATE_TIME_FORMAT.parse(dateTime);
        } catch (ParseException e) {
            throw new RuntimeException("将字符串" + dateTime + "解析为"
                    + FORMAT_FULL_DATETIME.toPattern() + "格式的日期时发生异常:", e);
        }
    }

    /**
     * Date -> String(yyyy-MM-dd)
     *
     * @param date <code>Date</code> 对象
     * @return [yyyy-MM-dd]格式日期字符串
     */
    public static String formatPageDate(Date date) {
        if (date == null) {
            return "";
        }

        return FORMAT_DATE_PAGE.format(date);
    }

    /**
     * Date -> String(yyyy-MM-dd HH:mm:ss)
     *
     * @param date <code>Date</code> 对象
     * @return [yyyy-MM-dd HH:mm:ss]格式日期字符串
     */
    public static String formatFullDate(Date date) {
        if (date == null) {
            return "";
        }

        return FORMAT_FULL_DATETIME.format(date);
    }

    /**
     * Date -> String(yyyyMMddHHmmss)
     *
     * @param date <code>Date</code> 对象
     * @return [yyyyMMddHHmmss]格式日期字符串
     */
    public static String formatFull2Date(Date date) {
        if (date == null) {
            return "";
        }

        return FORMAT_DATETIME_BACKEND.format(date);
    }

    /**
     * String(yyyy-MM-dd)-> String(yyyyMMdd)
     *
     * @param pageDate [yyyy-MM-dd]格式日期字符串
     * @return [yyyyMMdd]格式日期字符串
     */
    public static String convertDate4Page2DB(String pageDate) {
        if (pageDate == null) {
            return "";
        }
        if (pageDate.length() != 10) {
            return pageDate;
        }
        return pageDate.replaceAll("-", "");
    }

    /**
     * String(yyyyMMdd)->String(yyyy-MM-dd)
     *
     * @param dbDate [yyyyMMdd]格式日期字符串
     * @return [yyyy-MM-dd]格式日期字符串
     */
    public static String convertDate4DB2Page(String dbDate) {
        if (dbDate == null) {
            return "";
        }
        if (dbDate.length() != 8) {
            return dbDate;
        } else {
            return dbDate.substring(0, 4) + "-" + dbDate.substring(4, 6) + "-"
                    + dbDate.substring(6, 8);
        }
    }

    /**
     * String(HHmmss) -> String(HH:mm:ss)
     *
     * @param dbDate [HHmmss]格式时间字符串
     * @return [HH:mm:ss]格式时间字符串
     */
    public static String convertTime4DB2Page(String dbDate) {
        if (dbDate == null) {
            return "";
        }
        if (dbDate.length() != 6) {
            return dbDate;
        } else {
            return dbDate.substring(0, 2) + ":" + dbDate.substring(2, 4) + ":"
                    + dbDate.substring(4, 6);
        }
    }

    /**
     * String(HH:mm:ss) -> String(HHmmss)
     *
     * @param pageTime [HH:mm:ss]格式时间字符串
     * @return [HHmmss]格式时间字符串
     */
    public static String convertTime4Page2DB(String pageTime) {
        if (pageTime == null) {
            return "";
        }
        if (pageTime.length() != 8) {
            return pageTime;
        }
        return pageTime.replaceAll(":", "");
    }

    /**
     * String(HHmmss) -> String(HH:mm:ss)
     *
     * @param dbTime [HHmmss]格式时间字符串
     * @return [HH:mm:ss]格式时间字符串
     * @throws ParseException ParseException
     */
    public static String dbTimeToPageTime(String dbTime) throws ParseException {
        if (dbTime == null) {
            return "";
        }
        return FORMAT_TIME_PAGE.format(FORMAT_TIME.parse(dbTime));
    }

    /**
     * 把日期，时间转化为格式：yyyy-MM-dd HH:mm:ss
     *
     * @param date 日期，格式：yyyyMMdd
     * @param time 时间，格式：HHmmss
     * @return 格式[yyyy-MM-dd HH:mm:ss]的日期+时间
     */
    public static String getDateTime(String date, String time) {
        StringBuffer sb = new StringBuffer();
        sb.append(convertDate4DB2Page(date));
        sb.append(" ");

        try {
            sb.append(dbTimeToPageTime(time));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return sb.toString();
    }

    /**
     * 把当前时间转化为格式[yyyy-MM-dd HH:mm:ss]的字符串
     *
     * @return 格式[yyyy-MM-dd HH:mm:ss]的字符串
     */
    public static String getDateTime() {
        return FORMAT_FULL_DATETIME.format(new Date());
    }

    /**
     * 把当前时间转化为格式[yyyyMMdd]的字符串
     *
     * @return 格式[yyyyMMdd]的字符串
     */
    public static String getCurrentFullDate() {
        return FORMAT_DATE_DB.format(new Date());
    }

    /**
     * 把当前时间转化为格式[yyyy-MM-dd HH:mm:ss,S]的字符串
     *
     * @return 格式[yyyy-MM-dd HH:mm:ss,S]的字符串
     */
    public static String getCurrentExacDateTime() {
        return EXAC_DATE_TIME_FORMAT.format(new Date());
    }

    /**
     * 把当前时间转化为格式[yyyy-MM-dd]的字符串
     *
     * @return 格式[yyyy-MM-dd]的字符串
     */
    public static String getCurrentPageDate() {
        return FORMAT_DATE_PAGE.format(new Date());
    }

    /**
     * 取得当前时间字符串; 时间格式:HHmmss
     *
     * @return 格式[HHmmss]的字符串
     */
    public static String getCurrentTime() {
        return FORMAT_TIME.format(new Date());
    }

    /**
     * 取得当前时间字符串; 时间格式(yyyyMMddHHmmss)
     *
     * @return 格式[yyyyMMddHHmmss]的字符串
     */
    public static String getCurrentTimeForBACKEND() {
        Date date = new Date();
        return FORMAT_DATETIME_BACKEND.format(date);
    }

    /**
     * 解析时间字符串;
     *
     * @param time 格式[HHmmss]的时间字符串
     * @return 解析成功返回<code>Date</code> 对象，否则抛出<code>RuntimeException</code>异常
     */
    public static Date parseTime(String time) {
        try {
            return FORMAT_TIME.parse(time);
        } catch (ParseException e) {
            throw new RuntimeException("将字符串" + time + "按照"
                    + FORMAT_TIME.toPattern() + "格式进行解析时发生异常:", e);
        }
    }

    /**
     * Date -->> yyyy年MM月dd HH:mm:ss
     *
     * @param date <code>Date</code> 对象
     * @return [yyyy年MM月dd HH:mm:ss]格式字符串
     */
    public static String formatLocalDate(Date date) {
        return FORMAT_LOCAL.format(date);
    }

    /**
     * HH:mm:ss ->> HHmmss
     *
     * @param pageTime [HH:mm:ss]格式字符串
     * @return [HHmmss]格式字符串
     */
    public static String pageTimeToDbTime(String pageTime) {
        return pageTime.replaceAll(":", "");
    }

    /**
     * 将日期转换为指定格式
     *
     * @param date    <code>Date</code> 对象
     * @param pattern 日期格式
     * @return 指定格式的字符串
     */
    public static String formateDate2Str(Date date, String pattern) {
        SimpleDateFormat s = new SimpleDateFormat(pattern);
        return s.format(date);
    }

    /**
     * 将日期中的2007-1-1转化为20070101格式
     *
     * @param datestr [yyyy-MM-dd]格式字符串
     * @return 剔除了日期分隔符的日期字符串
     */
    public static String dateStringFormat(String datestr) {
        if (datestr == null || datestr.equals(""))
            return null;
        String[] str1 = datestr.split("-");
        if (str1.length == 3) {
            if (str1[1].length() == 1) {
                str1[1] = "0" + str1[1];
            }
            if (str1[2].length() == 1) {
                str1[2] = "0" + str1[2];
            }
        } else
            return datestr;
        datestr = str1[0] + str1[1] + str1[2];
        return datestr;
    }

    /**
     * 天数偏移
     *
     * @param date   [yyyyMMdd]格式日期
     * @param dayNum 偏移天数
     * @return 加上偏移天数后的[yyyyMMdd]格式日期字符串
     */
    public static String getDateTimeForword(String date, int dayNum) {
        if (date == null) {
            return "";
        }
        Date tempdate;
        if (date.indexOf("-") == -1) {
            try {
                tempdate = FORMAT_DATE_DB.parse(date);
            } catch (ParseException e) {
                throw new RuntimeException("将字符串" + date + "解析为"
                        + FORMAT_DATE_PAGE.toPattern() + "格式的日期时发生异常:", e);
            }
        } else {
            try {
                tempdate = FORMAT_DATE_PAGE.parse(date);
            } catch (ParseException e) {
                throw new RuntimeException("将字符串" + date + "解析为"
                        + FORMAT_DATE_PAGE.toPattern() + "格式的日期时发生异常:", e);
            }
        }
        tempdate = getDataTimeForwordDay(tempdate, dayNum);
        return FORMAT_DATE_DB.format(tempdate);
    }

    /**
     * 天数偏移
     *
     * @param date   指定日期
     * @param dayNum 偏移天数
     * @return 加上偏移天数后的日期
     */
    public static Date getDataTimeForwordDay(Date date, int dayNum) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, dayNum);
        return cal.getTime();
    }

    /**
     * 月数偏移
     *
     * @param date     指定日期
     * @param monthNum 偏移月数
     * @return 加上偏移月数后的日期
     */
    public static Date getDataTimeForwordMonth(Date date, int monthNum) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, monthNum);
        return cal.getTime();
    }

    /**
     * 年数偏移
     *
     * @param date    指定日期
     * @param yearNum 偏移年数
     * @return 加上偏移年数后的日期
     */
    public static Date getDataTimeForwordYear(Date date, int yearNum) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.YEAR, yearNum);
        return cal.getTime();
    }

    /**
     * 月数偏移 -> [yyyyMMdd]
     *
     * @param date     指定日期
     * @param monthNum 偏移月数
     * @return 加上偏移月数后的[yyyyMMdd]格式的日期
     */
    public static String getDataTimeForwordMonthStr(Date date, int monthNum) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, monthNum);

        return FORMAT_DATE_DB.format(cal.getTime());
    }

    /**
     * 小时偏移
     *
     * @param date    指定日期
     * @param timeNum 偏移小时数
     * @return 加上偏移小时数后的日期
     */
    public static Date getDataTimeOffset(Date date, int timeNum) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.HOUR, timeNum);
        return cal.getTime();
    }

    /**
     * 取得指定格式的当前时间字符串
     *
     * @param pattern 格式
     * @return 指定格式的当前时间字符串
     */
    public static String getTime(String pattern) {
        return new SimpleDateFormat(pattern).format(new Date());
    }

    /**
     * 取得指定时间的偏移时间
     *
     * @param transferTime 原始时间（yyyy-MM-dd HH:ss:mm）
     * @param calendarType 偏移单位（Calendar的常量）
     * @param amount       偏移量
     * @return [yyyy-MM-dd HH:mm:ss]格式时间字符串
     */
    public static String getExcursionTime(
            String transferTime,
            int calendarType, int amount) {
        Date parseFullDateTime = parseFullDateTime(transferTime);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(parseFullDateTime);
        calendar.add(calendarType, amount);
        return FORMAT_FULL_DATETIME.format(calendar.getTime());
    }

    /**
     * 取得指定格式的当前时间偏移一定量后的时间
     *
     * @param calendarType 偏移单位（Calendar的常量）
     * @param amount       偏移量
     * @param pattern      日期格式
     * @return 指定格式的时间字符串
     */
    public static String getExcursionTime(
            int calendarType, int amount,
            String pattern) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(calendarType, amount);
        return new SimpleDateFormat(pattern).format(calendar.getTime());
    }

    /**
     * 取得当前小时和分钟构成的长整型数,例如(12:30 = 1230)
     *
     * @return 当前小时和分钟构成的长整型数, 例如(12:30 = 1230)
     */
    public static Long getCurrentHourMinute() {
        return Long.parseLong(FORMAT_HOUR_MINUTE.format(new Date()));
    }

    /**
     * 求两个日期的天数之差
     *
     * @param beginTime 开始时间
     * @param endTime   结束时间
     * @return 两个日期的天数之差
     */
    public static int getOddDateNum(String beginTime, String endTime) {
        Date dateBegin = parseFullDateTime(beginTime);
        Date dateEnd = parseFullDateTime(endTime);
        return (int) ((dateEnd.getTime() - dateBegin.getTime()) / (dateSecond));
    }

    /**
     * 取系统时间零点
     *
     * @return 当前时间所在天的零点时间
     */
    public static Date getCurrentZeroTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    /**
     * 计算格林威治时间（包含时差计算）
     *
     * @return 长整数表示的时间
     */
    public static long unixTime() {
        java.util.Calendar cal1 = new GregorianCalendar(1970, 0, 1, 0, 0, 0);
        java.util.Calendar cal = java.util.Calendar
                .getInstance(java.util.Locale.CHINA);
        int zoneOffset = cal.get(java.util.Calendar.ZONE_OFFSET);
        int dstOffset = cal.get(java.util.Calendar.DST_OFFSET);
        cal.add(java.util.Calendar.MILLISECOND, -(zoneOffset + dstOffset));
        long now = cal1.getTimeInMillis() / 1000;
        long now1 = cal.getTimeInMillis() / 1000;
        return now1 - now;
    }

    /**
     * 当前时区时间
     *
     * @return 当前时区时间
     */
    public static Date getCurrentLocaleTime() {
        java.util.Calendar cal = java.util.Calendar
                .getInstance(java.util.Locale.CHINA);
        int zoneOffset = cal.get(java.util.Calendar.ZONE_OFFSET);
        int dstOffset = cal.get(java.util.Calendar.DST_OFFSET);
        cal.add(java.util.Calendar.MILLISECOND, -(zoneOffset + dstOffset));
        return cal.getTime();
    }

    /**
     * 取当前月份第一天日期 (yyyy-MM-dd)
     *
     * @return Date 当前月份第一天日期
     */
    public static Date getCurrentMothFirstDayByDate() {
        Date nowTime = new Date(System.currentTimeMillis());// 取系统时间
        Date fistDay = null;
        try {
            SimpleDateFormat sformat = new SimpleDateFormat("yyyy-MM-01");
            String today = sformat.format(nowTime);
            fistDay = parsePageDate(today);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return fistDay;
    }

    /**
     * 取当前月份第一天日期 (yyyy-MM-dd)
     *
     * @return [yyyy-MM-dd]格式的当前月份第一天日期字符串
     */
    public static String getCurrentMothFirstDayByString() {
        Date nowTime = new Date(System.currentTimeMillis());// 取系统时间
        String today = null;
        try {
            SimpleDateFormat sformat = new SimpleDateFormat("yyyy-MM-01");
            today = sformat.format(nowTime);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return today;
    }

    /**
     * 将字符串按照指定的格式转换为日期类型
     *
     * @param date       一定格式字符串表示的日期
     * @param dateFormat 字符串格式
     * @return 解析成功返回<code>Date</code>对象，解析失败则抛出<code>Exception</code>
     * @throws Exception 通用异常
     */
    public static Date parseDateByString(String date, String dateFormat)
            throws Exception {
        try {
            return new SimpleDateFormat(dateFormat).parse(date);
        } catch (ParseException e) {
            throw new Exception("解析字符串【" + date + "】为【" + dateFormat
                    + "】格式的日期对象时发生异常：", e);
        }
    }

    /**
     * 对传入的日期按指定格式转换成字符串
     *
     * @param date   指定日期
     * @param format 日期格式
     * @return 按指定格式对日期进行格式化后的字符串
     * @throws Exception 通用异常
     */
    public static String parseStringByDate(Date date, String format)
            throws Exception {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            return sdf.format(date);
        } catch (Exception e) {
            throw new Exception("解析字符串【" + date + "】为【" + format
                    + "】格式的日期对象时发生异常：", e);
        }

    }

    /**
     * 将毫秒数转化为日期格式
     *
     * @param time 毫秒表示的日期
     * @return <code>Date</code>对象
     */
    public static Date parse(Long time) {
        if (time == null) {
            return null;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(time);
        return cal.getTime();
    }

    /**
     * 将日期字符串按照指定的格式转换成新的日期字符串
     *
     * @param oldDate   原日期格式的日期字符串
     * @param oldFormat 原日期格式
     * @param newFormat 新日期格式
     * @return 新日期格式的日期字符串
     * @throws Exception 通用异常
     */
    public static String parseNewTimeString(
            String oldDate, String oldFormat,
            String newFormat) throws Exception {
        if (StringUtils.isEmpty(oldDate)) {
            return null;
        }
        Date date = parseDateByString(oldDate, oldFormat);
        return parseStringByDate(date, newFormat);
    }
    public static final String PATTERN_STANDARD = "yyyy-MM-dd HH:mm:ss";

	public static final String PATTERN_DATE = "yyyy-MM-dd";
	
	public static final String FM_DATE_AND_TIME = "yyyy-MM-dd HH:mm:ss";

	public final static String FM_PATTERN_CN_MD_HM = "MM月dd日 HH:mm";

	public final static String FM_PATTERN_CN_MD_NO = "MM月dd日";

	public final static String FM_PATTERN_CN_YMD_HM = "yyyy年MM月dd日 HH:mm";

	public final static String FM_PATTERN_CN_YMD_NO = "yyyy年MM月dd日";

	public final static String FM_PATTERN_CN_YM_NO = "yyyy年MM月";

	public final static String FM_PATTERN_EN_MD_HM = "MM-dd HH:mm";

	public final static String FM_PATTERN_EN_MD_NO = "MM-dd";

	public final static String FM_PATTERN_EN_YMD_HM = "yyyy/MM/dd HH:mm";

	public final static String FM_PATTERN_EN_YMD_NO = "yyyy/MM/dd";

	public final static String FM_PATTERN_EN_YM_NO = "yyyy/MM";

	public final static String[] WeekCn = { "星期日", "星期一", "星期二", "星期三", "星期四",
			"星期五", "星期六" };

	public final static String[] WeekEn = { "Sunday", "Monday", "Tuesday",
			"Wednsday", "Thursday", "Friday", "Saturday" };

	public final static String[] MonthCn = { "一", "二", "三", "四", "五", "六", "七",
			"八", "九", "十", "十一", "十二" };

	public final static String[] NumberCnS = { "〇", "一", "二", "三", "四", "五",
			"六", "七", "八", "九", "十" };

	public final static String[] NumberCnF = { "零", "壹", "贰", "叁", "肆", "伍",
			"陆", "柒", "捌", "玖", "拾" };

	public final static String[] MonthEn = { "January", "February", "March",
			"April", "May", "June", "July", "August", "September", "October",
			"November", "December" };
	
    /**
     * The UTC time zone  (often referred to as GMT).
     */
    public static final TimeZone UTC_TIME_ZONE = TimeZone.getTimeZone("GMT");
    /**
     * Number of milliseconds in a standard second.
     * @since 2.1
     */
    public static final long MILLIS_PER_SECOND = 1000;
    /**
     * Number of milliseconds in a standard minute.
     * @since 2.1
     */
    public static final long MILLIS_PER_MINUTE = 60 * MILLIS_PER_SECOND;
    /**
     * Number of milliseconds in a standard hour.
     * @since 2.1
     */
    public static final long MILLIS_PER_HOUR = 60 * MILLIS_PER_MINUTE;
    /**
     * Number of milliseconds in a standard day.
     * @since 2.1
     */
    public static final long MILLIS_PER_DAY = 24 * MILLIS_PER_HOUR;

    /**
     * This is half a month, so this represents whether a date is in the top
     * or bottom half of the month.
     */
    public final static int SEMI_MONTH = 1001;

    private static final int[][] fields = {
            {Calendar.MILLISECOND},
            {Calendar.SECOND},
            {Calendar.MINUTE},
            {Calendar.HOUR_OF_DAY, Calendar.HOUR},
            {Calendar.DATE, Calendar.DAY_OF_MONTH, Calendar.AM_PM 
                /* Calendar.DAY_OF_YEAR, Calendar.DAY_OF_WEEK, Calendar.DAY_OF_WEEK_IN_MONTH */
            },
            {Calendar.MONTH, DateTimeUtils.SEMI_MONTH},
            {Calendar.YEAR},
            {Calendar.ERA}};

	/**
	 * 当前日期，时间转换为长整型
	 * 作用用来生成随机数
	 *
	 * @return 长整型数字
	 */
	public static long getNowDateTimeToLong() {
		Calendar cal = Calendar.getInstance();
		return cal.getTimeInMillis();
	}
    /**
     * A week range, starting on Sunday.
     */
    public final static int RANGE_WEEK_SUNDAY = 1;

    /**
     * A week range, starting on Monday.
     */
    public final static int RANGE_WEEK_MONDAY = 2;

    /**
     * A week range, starting on the day focused.
     */
    public final static int RANGE_WEEK_RELATIVE = 3;

    /**
     * A week range, centered around the day focused.
     */
    public final static int RANGE_WEEK_CENTER = 4;

    /**
     * A month range, the week starting on Sunday.
     */
    public final static int RANGE_MONTH_SUNDAY = 5;

    /**
     * A month range, the week starting on Monday.
     */
    public final static int RANGE_MONTH_MONDAY = 6;

    /**
     * Constant marker for truncating 
     */
    private final static int MODIFY_TRUNCATE = 0;

    /**
     * Constant marker for rounding
     */
    private final static int MODIFY_ROUND = 1;

    /**
     * Constant marker for ceiling
     */
    private final static int MODIFY_CEILING= 2;


    //-----------------------------------------------------------------------
    /**
     * <p>Checks if two date objects are on the same day ignoring time.</p>
     *
     * <p>28 Mar 2002 13:45 and 28 Mar 2002 06:01 would return true.
     * 28 Mar 2002 13:45 and 12 Mar 2002 13:45 would return false.
     * </p>
     * 
     * @param date1  the first date, not altered, not null
     * @param date2  the second date, not altered, not null
     * @return true if they represent the same day
     * @throws IllegalArgumentException if either date is <code>null</code>
     * @since 2.1
     */
    public static boolean isSameDay(Date date1, Date date2) {
        if (date1 == null || date2 == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
        return isSameDay(cal1, cal2);
    }

    /**
     * <p>Checks if two calendar objects are on the same day ignoring time.</p>
     *
     * <p>28 Mar 2002 13:45 and 28 Mar 2002 06:01 would return true.
     * 28 Mar 2002 13:45 and 12 Mar 2002 13:45 would return false.
     * </p>
     * 
     * @param cal1  the first calendar, not altered, not null
     * @param cal2  the second calendar, not altered, not null
     * @return true if they represent the same day
     * @throws IllegalArgumentException if either calendar is <code>null</code>
     * @since 2.1
     */
    public static boolean isSameDay(Calendar cal1, Calendar cal2) {
        if (cal1 == null || cal2 == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        return (cal1.get(Calendar.ERA) == cal2.get(Calendar.ERA) &&
                cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) &&
                cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR));
    }

    //-----------------------------------------------------------------------
    /**
     * <p>Checks if two date objects represent the same instant in time.</p>
     *
     * <p>This method compares the long millisecond time of the two objects.</p>
     * 
     * @param date1  the first date, not altered, not null
     * @param date2  the second date, not altered, not null
     * @return true if they represent the same millisecond instant
     * @throws IllegalArgumentException if either date is <code>null</code>
     * @since 2.1
     */
    public static boolean isSameInstant(Date date1, Date date2) {
        if (date1 == null || date2 == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        return date1.getTime() == date2.getTime();
    }

    /**
     * <p>Checks if two calendar objects represent the same instant in time.</p>
     *
     * <p>This method compares the long millisecond time of the two objects.</p>
     * 
     * @param cal1  the first calendar, not altered, not null
     * @param cal2  the second calendar, not altered, not null
     * @return true if they represent the same millisecond instant
     * @throws IllegalArgumentException if either date is <code>null</code>
     * @since 2.1
     */
    public static boolean isSameInstant(Calendar cal1, Calendar cal2) {
        if (cal1 == null || cal2 == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        return cal1.getTime().getTime() == cal2.getTime().getTime();
    }

    //-----------------------------------------------------------------------
    /**
     * <p>Checks if two calendar objects represent the same local time.</p>
     *
     * <p>This method compares the values of the fields of the two objects.
     * In addition, both calendars must be the same of the same type.</p>
     * 
     * @param cal1  the first calendar, not altered, not null
     * @param cal2  the second calendar, not altered, not null
     * @return true if they represent the same millisecond instant
     * @throws IllegalArgumentException if either date is <code>null</code>
     * @since 2.1
     */
    public static boolean isSameLocalTime(Calendar cal1, Calendar cal2) {
        if (cal1 == null || cal2 == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        return (cal1.get(Calendar.MILLISECOND) == cal2.get(Calendar.MILLISECOND) &&
                cal1.get(Calendar.SECOND) == cal2.get(Calendar.SECOND) &&
                cal1.get(Calendar.MINUTE) == cal2.get(Calendar.MINUTE) &&
                cal1.get(Calendar.HOUR) == cal2.get(Calendar.HOUR) &&
                cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR) &&
                cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) &&
                cal1.get(Calendar.ERA) == cal2.get(Calendar.ERA) &&
                cal1.getClass() == cal2.getClass());
    }


    /**
     * Reformat the timezone in a date string.
     *
     * @param str The input string
     * @param signIdx The index position of the sign characters
     * @return The reformatted string
     */
    @SuppressWarnings("unused")
	private static String reformatTimezone(String str, int signIdx) {
        String str2 = str;
        if (signIdx >= 0 &&
            signIdx + 5 < str.length() &&
            Character.isDigit(str.charAt(signIdx + 1)) &&
            Character.isDigit(str.charAt(signIdx + 2)) &&
            str.charAt(signIdx + 3) == ':' &&
            Character.isDigit(str.charAt(signIdx + 4)) &&
            Character.isDigit(str.charAt(signIdx + 5))) {
            str2 = str.substring(0, signIdx + 3) + str.substring(signIdx + 4);
        }
        return str2;
    }

    //-----------------------------------------------------------------------
    /**
     * Adds a number of years to a date returning a new object.
     * The original date object is unchanged.
     *
     * @param date  the date, not null
     * @param amount  the amount to add, may be negative
     * @return the new date object with the amount added
     * @throws IllegalArgumentException if the date is null
     */
    public static Date addYears(Date date, int amount) {
        return add(date, Calendar.YEAR, amount);
    }

    //-----------------------------------------------------------------------
    /**
     * Adds a number of months to a date returning a new object.
     * The original date object is unchanged.
     *
     * @param date  the date, not null
     * @param amount  the amount to add, may be negative
     * @return the new date object with the amount added
     * @throws IllegalArgumentException if the date is null
     */
    public static Date addMonths(Date date, int amount) {
        return add(date, Calendar.MONTH, amount);
    }

    //-----------------------------------------------------------------------
    /**
     * Adds a number of weeks to a date returning a new object.
     * The original date object is unchanged.
     *
     * @param date  the date, not null
     * @param amount  the amount to add, may be negative
     * @return the new date object with the amount added
     * @throws IllegalArgumentException if the date is null
     */
    public static Date addWeeks(Date date, int amount) {
        return add(date, Calendar.WEEK_OF_YEAR, amount);
    }

    //-----------------------------------------------------------------------
    /**
     * Adds a number of days to a date returning a new object.
     * The original date object is unchanged.
     *
     * @param date  the date, not null
     * @param amount  the amount to add, may be negative
     * @return the new date object with the amount added
     * @throws IllegalArgumentException if the date is null
     */
    public static Date addDays(Date date, int amount) {
        return add(date, Calendar.DAY_OF_MONTH, amount);
    }

    //-----------------------------------------------------------------------
    /**
     * Adds a number of hours to a date returning a new object.
     * The original date object is unchanged.
     *
     * @param date  the date, not null
     * @param amount  the amount to add, may be negative
     * @return the new date object with the amount added
     * @throws IllegalArgumentException if the date is null
     */
    public static Date addHours(Date date, int amount) {
        return add(date, Calendar.HOUR_OF_DAY, amount);
    }

    //-----------------------------------------------------------------------
    /**
     * Adds a number of minutes to a date returning a new object.
     * The original date object is unchanged.
     *
     * @param date  the date, not null
     * @param amount  the amount to add, may be negative
     * @return the new date object with the amount added
     * @throws IllegalArgumentException if the date is null
     */
    public static Date addMinutes(Date date, int amount) {
        return add(date, Calendar.MINUTE, amount);
    }

    //-----------------------------------------------------------------------
    /**
     * Adds a number of seconds to a date returning a new object.
     * The original date object is unchanged.
     *
     * @param date  the date, not null
     * @param amount  the amount to add, may be negative
     * @return the new date object with the amount added
     * @throws IllegalArgumentException if the date is null
     */
    public static Date addSeconds(Date date, int amount) {
        return add(date, Calendar.SECOND, amount);
    }

    //-----------------------------------------------------------------------
    /**
     * Adds a number of milliseconds to a date returning a new object.
     * The original date object is unchanged.
     *
     * @param date  the date, not null
     * @param amount  the amount to add, may be negative
     * @return the new date object with the amount added
     * @throws IllegalArgumentException if the date is null
     */
    public static Date addMilliseconds(Date date, int amount) {
        return add(date, Calendar.MILLISECOND, amount);
    }

    //-----------------------------------------------------------------------
    /**
     * Adds to a date returning a new object.
     * The original date object is unchanged.
     *
     * @param date  the date, not null
     * @param calendarField  the calendar field to add to
     * @param amount  the amount to add, may be negative
     * @return the new date object with the amount added
     * @throws IllegalArgumentException if the date is null
     * @deprecated Will become privately scoped in 3.0
     */
    @Deprecated
	public static Date add(Date date, int calendarField, int amount) {
        if (date == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(calendarField, amount);
        return c.getTime();
    }
    
    //-----------------------------------------------------------------------
    /**
     * Sets the years field to a date returning a new object.
     * The original date object is unchanged.
     *
     * @param date  the date, not null
     * @param amount the amount to set
     * @return a new Date object set with the specified value
     * @throws IllegalArgumentException if the date is null
     * @since 2.4
     */
    public static Date setYears(Date date, int amount) {
        return set(date, Calendar.YEAR, amount);
    }

    //-----------------------------------------------------------------------
    /**
     * Sets the months field to a date returning a new object.
     * The original date object is unchanged.
     *
     * @param date  the date, not null
     * @param amount the amount to set
     * @return a new Date object set with the specified value
     * @throws IllegalArgumentException if the date is null
     * @since 2.4
     */
    public static Date setMonths(Date date, int amount) {
        return set(date, Calendar.MONTH, amount);
    }

    //-----------------------------------------------------------------------
    /**
     * Sets the day of month field to a date returning a new object.
     * The original date object is unchanged.
     *
     * @param date  the date, not null
     * @param amount the amount to set
     * @return a new Date object set with the specified value
     * @throws IllegalArgumentException if the date is null
     * @since 2.4
     */
    public static Date setDays(Date date, int amount) {
        return set(date, Calendar.DAY_OF_MONTH, amount);
    }

    //-----------------------------------------------------------------------
    /**
     * Sets the hours field to a date returning a new object.  Hours range 
     * from  0-23.
     * The original date object is unchanged.
     *
     * @param date  the date, not null
     * @param amount the amount to set
     * @return a new Date object set with the specified value
     * @throws IllegalArgumentException if the date is null
     * @since 2.4
     */
    public static Date setHours(Date date, int amount) {
        return set(date, Calendar.HOUR_OF_DAY, amount);
    }

    //-----------------------------------------------------------------------
    /**
     * Sets the minute field to a date returning a new object.
     * The original date object is unchanged.
     *
     * @param date  the date, not null
     * @param amount the amount to set
     * @return a new Date object set with the specified value
     * @throws IllegalArgumentException if the date is null
     * @since 2.4
     */
    public static Date setMinutes(Date date, int amount) {
        return set(date, Calendar.MINUTE, amount);
    }
    
    //-----------------------------------------------------------------------
    /**
     * Sets the seconds field to a date returning a new object.
     * The original date object is unchanged.
     *
     * @param date  the date, not null
     * @param amount the amount to set
     * @return a new Date object set with the specified value
     * @throws IllegalArgumentException if the date is null
     * @since 2.4
     */
    public static Date setSeconds(Date date, int amount) {
        return set(date, Calendar.SECOND, amount);
    }

    //-----------------------------------------------------------------------
    /**
     * Sets the miliseconds field to a date returning a new object.
     * The original date object is unchanged.
     *
     * @param date  the date, not null
     * @param amount the amount to set
     * @return a new Date object set with the specified value
     * @throws IllegalArgumentException if the date is null
     * @since 2.4
     */
    public static Date setMilliseconds(Date date, int amount) {
        return set(date, Calendar.MILLISECOND, amount);
    } 
    
    //-----------------------------------------------------------------------
    /**
     * Sets the specified field to a date returning a new object.  
     * This does not use a lenient calendar.
     * The original date object is unchanged.
     *
     * @param date  the date, not null
     * @param calendarField  the calendar field to set the amount to
     * @param amount the amount to set
     * @return a new Date object set with the specified value
     * @throws IllegalArgumentException if the date is null
     * @since 2.4
     */
    private static Date set(Date date, int calendarField, int amount) {
        if (date == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        // getInstance() returns a new object, so this method is thread safe.
        Calendar c = Calendar.getInstance();
        c.setLenient(false);
        c.setTime(date);
        c.set(calendarField, amount);
        return c.getTime();
    }   
    
    //-----------------------------------------------------------------------
    /**
     * <p>Round this date, leaving the field specified as the most
     * significant field.</p>
     *
     * <p>For example, if you had the datetime of 28 Mar 2002
     * 13:45:01.231, if this was passed with HOUR, it would return
     * 28 Mar 2002 14:00:00.000. If this was passed with MONTH, it
     * would return 1 April 2002 0:00:00.000.</p>
     * 
     * <p>For a date in a timezone that handles the change to daylight
     * saving time, rounding to Calendar.HOUR_OF_DAY will behave as follows.
     * Suppose daylight saving time begins at 02:00 on March 30. Rounding a 
     * date that crosses this time would produce the following values:
     * <ul>
     * <li>March 30, 2003 01:10 rounds to March 30, 2003 01:00</li>
     * <li>March 30, 2003 01:40 rounds to March 30, 2003 03:00</li>
     * <li>March 30, 2003 02:10 rounds to March 30, 2003 03:00</li>
     * <li>March 30, 2003 02:40 rounds to March 30, 2003 04:00</li>
     * </ul>
     * </p>
     * 
     * @param date  the date to work with
     * @param field  the field from <code>Calendar</code>
     *  or <code>SEMI_MONTH</code>
     * @return the rounded date
     * @throws IllegalArgumentException if the date is <code>null</code>
     * @throws ArithmeticException if the year is over 280 million
     */
    public static Date round(Date date, int field) {
        if (date == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        Calendar gval = Calendar.getInstance();
        gval.setTime(date);
        modify(gval, field, MODIFY_ROUND);
        return gval.getTime();
    }

    /**
     * <p>Round this date, leaving the field specified as the most
     * significant field.</p>
     *
     * <p>For example, if you had the datetime of 28 Mar 2002
     * 13:45:01.231, if this was passed with HOUR, it would return
     * 28 Mar 2002 14:00:00.000. If this was passed with MONTH, it
     * would return 1 April 2002 0:00:00.000.</p>
     * 
     * <p>For a date in a timezone that handles the change to daylight
     * saving time, rounding to Calendar.HOUR_OF_DAY will behave as follows.
     * Suppose daylight saving time begins at 02:00 on March 30. Rounding a 
     * date that crosses this time would produce the following values:
     * <ul>
     * <li>March 30, 2003 01:10 rounds to March 30, 2003 01:00</li>
     * <li>March 30, 2003 01:40 rounds to March 30, 2003 03:00</li>
     * <li>March 30, 2003 02:10 rounds to March 30, 2003 03:00</li>
     * <li>March 30, 2003 02:40 rounds to March 30, 2003 04:00</li>
     * </ul>
     * </p>
     * 
     * @param date  the date to work with
     * @param field  the field from <code>Calendar</code>
     *  or <code>SEMI_MONTH</code>
     * @return the rounded date (a different object)
     * @throws IllegalArgumentException if the date is <code>null</code>
     * @throws ArithmeticException if the year is over 280 million
     */
    public static Calendar round(Calendar date, int field) {
        if (date == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        Calendar rounded = (Calendar) date.clone();
        modify(rounded, field, MODIFY_ROUND);
        return rounded;
    }

    /**
     * <p>Round this date, leaving the field specified as the most
     * significant field.</p>
     *
     * <p>For example, if you had the datetime of 28 Mar 2002
     * 13:45:01.231, if this was passed with HOUR, it would return
     * 28 Mar 2002 14:00:00.000. If this was passed with MONTH, it
     * would return 1 April 2002 0:00:00.000.</p>
     * 
     * <p>For a date in a timezone that handles the change to daylight
     * saving time, rounding to Calendar.HOUR_OF_DAY will behave as follows.
     * Suppose daylight saving time begins at 02:00 on March 30. Rounding a 
     * date that crosses this time would produce the following values:
     * <ul>
     * <li>March 30, 2003 01:10 rounds to March 30, 2003 01:00</li>
     * <li>March 30, 2003 01:40 rounds to March 30, 2003 03:00</li>
     * <li>March 30, 2003 02:10 rounds to March 30, 2003 03:00</li>
     * <li>March 30, 2003 02:40 rounds to March 30, 2003 04:00</li>
     * </ul>
     * </p>
     * 
     * @param date  the date to work with, either Date or Calendar
     * @param field  the field from <code>Calendar</code>
     *  or <code>SEMI_MONTH</code>
     * @return the rounded date
     * @throws IllegalArgumentException if the date is <code>null</code>
     * @throws ClassCastException if the object type is not a <code>Date</code>
     *  or <code>Calendar</code>
     * @throws ArithmeticException if the year is over 280 million
     */
    public static Date round(Object date, int field) {
        if (date == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        if (date instanceof Date) {
            return round((Date) date, field);
        } else if (date instanceof Calendar) {
            return round((Calendar) date, field).getTime();
        } else {
            throw new ClassCastException("Could not round " + date);
        }
    }

    //-----------------------------------------------------------------------
    /**
     * <p>Truncate this date, leaving the field specified as the most
     * significant field.</p>
     *
     * <p>For example, if you had the datetime of 28 Mar 2002
     * 13:45:01.231, if you passed with HOUR, it would return 28 Mar
     * 2002 13:00:00.000.  If this was passed with MONTH, it would
     * return 1 Mar 2002 0:00:00.000.</p>
     * 
     * @param date  the date to work with
     * @param field  the field from <code>Calendar</code>
     *  or <code>SEMI_MONTH</code>
     * @return the rounded date
     * @throws IllegalArgumentException if the date is <code>null</code>
     * @throws ArithmeticException if the year is over 280 million
     */
    public static Date truncate(Date date, int field) {
        if (date == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        Calendar gval = Calendar.getInstance();
        gval.setTime(date);
        modify(gval, field, MODIFY_TRUNCATE);
        return gval.getTime();
    }

    /**
     * <p>Truncate this date, leaving the field specified as the most
     * significant field.</p>
     *
     * <p>For example, if you had the datetime of 28 Mar 2002
     * 13:45:01.231, if you passed with HOUR, it would return 28 Mar
     * 2002 13:00:00.000.  If this was passed with MONTH, it would
     * return 1 Mar 2002 0:00:00.000.</p>
     * 
     * @param date  the date to work with
     * @param field  the field from <code>Calendar</code>
     *  or <code>SEMI_MONTH</code>
     * @return the rounded date (a different object)
     * @throws IllegalArgumentException if the date is <code>null</code>
     * @throws ArithmeticException if the year is over 280 million
     */
    public static Calendar truncate(Calendar date, int field) {
        if (date == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        Calendar truncated = (Calendar) date.clone();
        modify(truncated, field, MODIFY_TRUNCATE);
        return truncated;
    }

    /**
     * <p>Truncate this date, leaving the field specified as the most
     * significant field.</p>
     *
     * <p>For example, if you had the datetime of 28 Mar 2002
     * 13:45:01.231, if you passed with HOUR, it would return 28 Mar
     * 2002 13:00:00.000.  If this was passed with MONTH, it would
     * return 1 Mar 2002 0:00:00.000.</p>
     * 
     * @param date  the date to work with, either <code>Date</code>
     *  or <code>Calendar</code>
     * @param field  the field from <code>Calendar</code>
     *  or <code>SEMI_MONTH</code>
     * @return the rounded date
     * @throws IllegalArgumentException if the date
     *  is <code>null</code>
     * @throws ClassCastException if the object type is not a
     *  <code>Date</code> or <code>Calendar</code>
     * @throws ArithmeticException if the year is over 280 million
     */
    public static Date truncate(Object date, int field) {
        if (date == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        if (date instanceof Date) {
            return truncate((Date) date, field);
        } else if (date instanceof Calendar) {
            return truncate((Calendar) date, field).getTime();
        } else {
            throw new ClassCastException("Could not truncate " + date);
        }
    }
    
  //-----------------------------------------------------------------------
    /**
     * <p>Ceil this date, leaving the field specified as the most
     * significant field.</p>
     *
     * <p>For example, if you had the datetime of 28 Mar 2002
     * 13:45:01.231, if you passed with HOUR, it would return 28 Mar
     * 2002 13:00:00.000.  If this was passed with MONTH, it would
     * return 1 Mar 2002 0:00:00.000.</p>
     * 
     * @param date  the date to work with
     * @param field  the field from <code>Calendar</code>
     *  or <code>SEMI_MONTH</code>
     * @return the rounded date
     * @throws IllegalArgumentException if the date is <code>null</code>
     * @throws ArithmeticException if the year is over 280 million
     * @since 2.5
     */
    public static Date ceiling(Date date, int field) {
        if (date == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        Calendar gval = Calendar.getInstance();
        gval.setTime(date);
        modify(gval, field, MODIFY_CEILING);
        return gval.getTime();
    }

    /**
     * <p>Ceil this date, leaving the field specified as the most
     * significant field.</p>
     *
     * <p>For example, if you had the datetime of 28 Mar 2002
     * 13:45:01.231, if you passed with HOUR, it would return 28 Mar
     * 2002 13:00:00.000.  If this was passed with MONTH, it would
     * return 1 Mar 2002 0:00:00.000.</p>
     * 
     * @param date  the date to work with
     * @param field  the field from <code>Calendar</code>
     *  or <code>SEMI_MONTH</code>
     * @return the rounded date (a different object)
     * @throws IllegalArgumentException if the date is <code>null</code>
     * @throws ArithmeticException if the year is over 280 million
     * @since 2.5
     */
    public static Calendar ceiling(Calendar date, int field) {
        if (date == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        Calendar ceiled = (Calendar) date.clone();
        modify(ceiled, field, MODIFY_CEILING);
        return ceiled;
    }

    /**
     * <p>Ceil this date, leaving the field specified as the most
     * significant field.</p>
     *
     * <p>For example, if you had the datetime of 28 Mar 2002
     * 13:45:01.231, if you passed with HOUR, it would return 28 Mar
     * 2002 13:00:00.000.  If this was passed with MONTH, it would
     * return 1 Mar 2002 0:00:00.000.</p>
     * 
     * @param date  the date to work with, either <code>Date</code>
     *  or <code>Calendar</code>
     * @param field  the field from <code>Calendar</code>
     *  or <code>SEMI_MONTH</code>
     * @return the rounded date
     * @throws IllegalArgumentException if the date
     *  is <code>null</code>
     * @throws ClassCastException if the object type is not a
     *  <code>Date</code> or <code>Calendar</code>
     * @throws ArithmeticException if the year is over 280 million
     * @since 2.5
     */
    public static Date ceiling(Object date, int field) {
        if (date == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        if (date instanceof Date) {
            return ceiling((Date) date, field);
        } else if (date instanceof Calendar) {
            return ceiling((Calendar) date, field).getTime();
        } else {
            throw new ClassCastException("Could not find ceiling of for type: " + date.getClass());
        }
    }

    //-----------------------------------------------------------------------
    /**
     * <p>Internal calculation method.</p>
     * 
     * @param val  the calendar
     * @param field  the field constant
     * @param modType  type to truncate, round or ceiling
     * @throws ArithmeticException if the year is over 280 million
     */
    private static void modify(Calendar val, int field, int modType) {
        if (val.get(Calendar.YEAR) > 280000000) {
            throw new ArithmeticException("Calendar value too large for accurate calculations");
        }
        
        if (field == Calendar.MILLISECOND) {
            return;
        }

        // ----------------- Fix for LANG-59 ---------------------- START ---------------
        // see http://issues.apache.org/jira/browse/LANG-59
        //
        // Manually truncate milliseconds, seconds and minutes, rather than using
        // Calendar methods.

        Date date = val.getTime();
        long time = date.getTime();
        boolean done = false;

        // truncate milliseconds
        int millisecs = val.get(Calendar.MILLISECOND);
        if (MODIFY_TRUNCATE == modType || millisecs < 500) {
            time = time - millisecs;
        }
        if (field == Calendar.SECOND) {
            done = true;
        }

        // truncate seconds
        int seconds = val.get(Calendar.SECOND);
        if (!done && (MODIFY_TRUNCATE == modType || seconds < 30)) {
            time = time - (seconds * 1000L);
        }
        if (field == Calendar.MINUTE) {
            done = true;
        }

        // truncate minutes
        int minutes = val.get(Calendar.MINUTE);
        if (!done && (MODIFY_TRUNCATE == modType || minutes < 30)) {
            time = time - (minutes * 60000L);
        }

        // reset time
        if (date.getTime() != time) {
            date.setTime(time);
            val.setTime(date);
        }
        // ----------------- Fix for LANG-59 ----------------------- END ----------------

        boolean roundUp = false;
        for (int i = 0; i < fields.length; i++) {
            for (int j = 0; j < fields[i].length; j++) {
                if (fields[i][j] == field) {
                    //This is our field... we stop looping
                    if (modType == MODIFY_CEILING || (modType == MODIFY_ROUND && roundUp)) {
                        if (field == DateTimeUtils.SEMI_MONTH) {
                            //This is a special case that's hard to generalize
                            //If the date is 1, we round up to 16, otherwise
                            //  we subtract 15 days and add 1 month
                            if (val.get(Calendar.DATE) == 1) {
                                val.add(Calendar.DATE, 15);
                            } else {
                                val.add(Calendar.DATE, -15);
                                val.add(Calendar.MONTH, 1);
                            }
// ----------------- Fix for LANG-440 ---------------------- START ---------------
                        } else if (field == Calendar.AM_PM) {
                            // This is a special case
                            // If the time is 0, we round up to 12, otherwise
                            //  we subtract 12 hours and add 1 day
                            if (val.get(Calendar.HOUR_OF_DAY) == 0) {
                                val.add(Calendar.HOUR_OF_DAY, 12);
                            } else {
                                val.add(Calendar.HOUR_OF_DAY, -12);
                                val.add(Calendar.DATE, 1);
                            }
// ----------------- Fix for LANG-440 ---------------------- END ---------------
                        } else {
                            //We need at add one to this field since the
                            //  last number causes us to round up
                            val.add(fields[i][0], 1);
                        }
                    }
                    return;
                }
            }
            //We have various fields that are not easy roundings
            int offset = 0;
            boolean offsetSet = false;
            //These are special types of fields that require different rounding rules
            switch (field) {
                case DateTimeUtils.SEMI_MONTH:
                    if (fields[i][0] == Calendar.DATE) {
                        //If we're going to drop the DATE field's value,
                        //  we want to do this our own way.
                        //We need to subtrace 1 since the date has a minimum of 1
                        offset = val.get(Calendar.DATE) - 1;
                        //If we're above 15 days adjustment, that means we're in the
                        //  bottom half of the month and should stay accordingly.
                        if (offset >= 15) {
                            offset -= 15;
                        }
                        //Record whether we're in the top or bottom half of that range
                        roundUp = offset > 7;
                        offsetSet = true;
                    }
                    break;
                case Calendar.AM_PM:
                    if (fields[i][0] == Calendar.HOUR_OF_DAY) {
                        //If we're going to drop the HOUR field's value,
                        //  we want to do this our own way.
                        offset = val.get(Calendar.HOUR_OF_DAY);
                        if (offset >= 12) {
                            offset -= 12;
                        }
                        roundUp = offset >= 6;
                        offsetSet = true;
                    }
                    break;
            }
            if (!offsetSet) {
                int min = val.getActualMinimum(fields[i][0]);
                int max = val.getActualMaximum(fields[i][0]);
                //Calculate the offset from the minimum allowed value
                offset = val.get(fields[i][0]) - min;
                //Set roundUp if this is more than half way between the minimum and maximum
                roundUp = offset > ((max - min) / 2);
            }
            //We need to remove this field
            if (offset != 0) {
                val.set(fields[i][0], val.get(fields[i][0]) - offset);
            }
        }
        throw new IllegalArgumentException("The field " + field + " is not supported");

    }


    
    /**
     * <p>Returns the number of milliseconds within the 
     * fragment. All datefields greater than the fragment will be ignored.</p>
     * 
     * <p>Asking the milliseconds of any date will only return the number of milliseconds
     * of the current second (resulting in a number between 0 and 999). This 
     * method will retrieve the number of milliseconds for any fragment. 
     * For example, if you want to calculate the number of milliseconds past today, 
     * your fragment is Calendar.DATE or Calendar.DAY_OF_YEAR. The result will
     * be all milliseconds of the past hour(s), minutes(s) and second(s).</p>
     * 
     * <p>Valid fragments are: Calendar.YEAR, Calendar.MONTH, both 
     * Calendar.DAY_OF_YEAR and Calendar.DATE, Calendar.HOUR_OF_DAY, 
     * Calendar.MINUTE, Calendar.SECOND and Calendar.MILLISECOND
     * A fragment less than or equal to a SECOND field will return 0.</p> 
     * 
     * <p>
     * <ul>
     *  <li>January 1, 2008 7:15:10.538 with Calendar.SECOND as fragment will return 538</li>
     *  <li>January 6, 2008 7:15:10.538 with Calendar.SECOND as fragment will return 538</li>
     *  <li>January 6, 2008 7:15:10.538 with Calendar.MINUTE as fragment will return 10538 (10*1000 + 538)</li>
     *  <li>January 16, 2008 7:15:10.538 with Calendar.MILLISECOND as fragment will return 0
     *   (a millisecond cannot be split in milliseconds)</li>
     * </ul>
     * </p>
     * 
     * @param date the date to work with, not null
     * @param fragment the Calendar field part of date to calculate 
     * @return number of milliseconds within the fragment of date
     * @throws IllegalArgumentException if the date is <code>null</code> or
     * fragment is not supported
     * @since 2.4
     */
    public static long getFragmentInMilliseconds(Date date, int fragment) {
        return getFragment(date, fragment, Calendar.MILLISECOND);    
    }
    
    /**
     * <p>Returns the number of seconds within the 
     * fragment. All datefields greater than the fragment will be ignored.</p> 
     * 
     * <p>Asking the seconds of any date will only return the number of seconds
     * of the current minute (resulting in a number between 0 and 59). This 
     * method will retrieve the number of seconds for any fragment. 
     * For example, if you want to calculate the number of seconds past today, 
     * your fragment is Calendar.DATE or Calendar.DAY_OF_YEAR. The result will
     * be all seconds of the past hour(s) and minutes(s).</p> 
     * 
     * <p>Valid fragments are: Calendar.YEAR, Calendar.MONTH, both 
     * Calendar.DAY_OF_YEAR and Calendar.DATE, Calendar.HOUR_OF_DAY, 
     * Calendar.MINUTE, Calendar.SECOND and Calendar.MILLISECOND
     * A fragment less than or equal to a SECOND field will return 0.</p> 
     * 
     * <p>
     * <ul>
     *  <li>January 1, 2008 7:15:10.538 with Calendar.MINUTE as fragment will return 10
     *   (equivalent to deprecated date.getSeconds())</li>
     *  <li>January 6, 2008 7:15:10.538 with Calendar.MINUTE as fragment will return 10
     *   (equivalent to deprecated date.getSeconds())</li>
     *  <li>January 6, 2008 7:15:10.538 with Calendar.DAY_OF_YEAR as fragment will return 26110
     *   (7*3600 + 15*60 + 10)</li>
     *  <li>January 16, 2008 7:15:10.538 with Calendar.MILLISECOND as fragment will return 0
     *   (a millisecond cannot be split in seconds)</li>
     * </ul>
     * </p>
     * 
     * @param date the date to work with, not null
     * @param fragment the Calendar field part of date to calculate 
     * @return number of seconds within the fragment of date
     * @throws IllegalArgumentException if the date is <code>null</code> or
     * fragment is not supported
     * @since 2.4
     */
    public static long getFragmentInSeconds(Date date, int fragment) {
        return getFragment(date, fragment, Calendar.SECOND);
    }
    
    /**
     * <p>Returns the number of minutes within the 
     * fragment. All datefields greater than the fragment will be ignored.</p> 
     * 
     * <p>Asking the minutes of any date will only return the number of minutes
     * of the current hour (resulting in a number between 0 and 59). This 
     * method will retrieve the number of minutes for any fragment. 
     * For example, if you want to calculate the number of minutes past this month, 
     * your fragment is Calendar.MONTH. The result will be all minutes of the 
     * past day(s) and hour(s).</p> 
     * 
     * <p>Valid fragments are: Calendar.YEAR, Calendar.MONTH, both 
     * Calendar.DAY_OF_YEAR and Calendar.DATE, Calendar.HOUR_OF_DAY, 
     * Calendar.MINUTE, Calendar.SECOND and Calendar.MILLISECOND
     * A fragment less than or equal to a MINUTE field will return 0.</p> 
     * 
     * <p>
     * <ul>
     *  <li>January 1, 2008 7:15:10.538 with Calendar.HOUR_OF_DAY as fragment will return 15
     *   (equivalent to deprecated date.getMinutes())</li>
     *  <li>January 6, 2008 7:15:10.538 with Calendar.HOUR_OF_DAY as fragment will return 15
     *   (equivalent to deprecated date.getMinutes())</li>
     *  <li>January 1, 2008 7:15:10.538 with Calendar.MONTH as fragment will return 15</li>
     *  <li>January 6, 2008 7:15:10.538 with Calendar.MONTH as fragment will return 435 (7*60 + 15)</li>
     *  <li>January 16, 2008 7:15:10.538 with Calendar.MILLISECOND as fragment will return 0
     *   (a millisecond cannot be split in minutes)</li>
     * </ul>
     * </p>
     * 
     * @param date the date to work with, not null
     * @param fragment the Calendar field part of date to calculate 
     * @return number of minutes within the fragment of date
     * @throws IllegalArgumentException if the date is <code>null</code> or 
     * fragment is not supported
     * @since 2.4
     */
    public static long getFragmentInMinutes(Date date, int fragment) {
        return getFragment(date, fragment, Calendar.MINUTE);
    }
    
    /**
     * <p>Returns the number of hours within the 
     * fragment. All datefields greater than the fragment will be ignored.</p> 
     * 
     * <p>Asking the hours of any date will only return the number of hours
     * of the current day (resulting in a number between 0 and 23). This 
     * method will retrieve the number of hours for any fragment. 
     * For example, if you want to calculate the number of hours past this month, 
     * your fragment is Calendar.MONTH. The result will be all hours of the 
     * past day(s).</p> 
     * 
     * <p>Valid fragments are: Calendar.YEAR, Calendar.MONTH, both 
     * Calendar.DAY_OF_YEAR and Calendar.DATE, Calendar.HOUR_OF_DAY, 
     * Calendar.MINUTE, Calendar.SECOND and Calendar.MILLISECOND
     * A fragment less than or equal to a HOUR field will return 0.</p> 
     * 
     * <p>
     * <ul>
     *  <li>January 1, 2008 7:15:10.538 with Calendar.DAY_OF_YEAR as fragment will return 7
     *   (equivalent to deprecated date.getHours())</li>
     *  <li>January 6, 2008 7:15:10.538 with Calendar.DAY_OF_YEAR as fragment will return 7
     *   (equivalent to deprecated date.getHours())</li>
     *  <li>January 1, 2008 7:15:10.538 with Calendar.MONTH as fragment will return 7</li>
     *  <li>January 6, 2008 7:15:10.538 with Calendar.MONTH as fragment will return 127 (5*24 + 7)</li>
     *  <li>January 16, 2008 7:15:10.538 with Calendar.MILLISECOND as fragment will return 0
     *   (a millisecond cannot be split in hours)</li>
     * </ul>
     * </p>
     * 
     * @param date the date to work with, not null
     * @param fragment the Calendar field part of date to calculate 
     * @return number of hours within the fragment of date
     * @throws IllegalArgumentException if the date is <code>null</code> or 
     * fragment is not supported
     * @since 2.4
     */
    public static long getFragmentInHours(Date date, int fragment) {
        return getFragment(date, fragment, Calendar.HOUR_OF_DAY);
    }
    
    /**
     * <p>Returns the number of days within the 
     * fragment. All datefields greater than the fragment will be ignored.</p> 
     * 
     * <p>Asking the days of any date will only return the number of days
     * of the current month (resulting in a number between 1 and 31). This 
     * method will retrieve the number of days for any fragment. 
     * For example, if you want to calculate the number of days past this year, 
     * your fragment is Calendar.YEAR. The result will be all days of the 
     * past month(s).</p> 
     * 
     * <p>Valid fragments are: Calendar.YEAR, Calendar.MONTH, both 
     * Calendar.DAY_OF_YEAR and Calendar.DATE, Calendar.HOUR_OF_DAY, 
     * Calendar.MINUTE, Calendar.SECOND and Calendar.MILLISECOND
     * A fragment less than or equal to a DAY field will return 0.</p> 
     *  
     * <p>
     * <ul>
     *  <li>January 28, 2008 with Calendar.MONTH as fragment will return 28
     *   (equivalent to deprecated date.getDay())</li>
     *  <li>February 28, 2008 with Calendar.MONTH as fragment will return 28
     *   (equivalent to deprecated date.getDay())</li>
     *  <li>January 28, 2008 with Calendar.YEAR as fragment will return 28</li>
     *  <li>February 28, 2008 with Calendar.YEAR as fragment will return 59</li>
     *  <li>January 28, 2008 with Calendar.MILLISECOND as fragment will return 0
     *   (a millisecond cannot be split in days)</li>
     * </ul>
     * </p>
     * 
     * @param date the date to work with, not null
     * @param fragment the Calendar field part of date to calculate 
     * @return number of days  within the fragment of date
     * @throws IllegalArgumentException if the date is <code>null</code> or 
     * fragment is not supported
     * @since 2.4
     */
    public static long getFragmentInDays(Date date, int fragment) {
        return getFragment(date, fragment, Calendar.DAY_OF_YEAR);
    }

    /**
     * <p>Returns the number of milliseconds within the 
     * fragment. All datefields greater than the fragment will be ignored.</p> 
     * 
     * <p>Asking the milliseconds of any date will only return the number of milliseconds
     * of the current second (resulting in a number between 0 and 999). This 
     * method will retrieve the number of milliseconds for any fragment. 
     * For example, if you want to calculate the number of seconds past today, 
     * your fragment is Calendar.DATE or Calendar.DAY_OF_YEAR. The result will
     * be all seconds of the past hour(s), minutes(s) and second(s).</p> 
     * 
     * <p>Valid fragments are: Calendar.YEAR, Calendar.MONTH, both 
     * Calendar.DAY_OF_YEAR and Calendar.DATE, Calendar.HOUR_OF_DAY, 
     * Calendar.MINUTE, Calendar.SECOND and Calendar.MILLISECOND
     * A fragment less than or equal to a MILLISECOND field will return 0.</p> 
     * 
     * <p>
     * <ul>
     *  <li>January 1, 2008 7:15:10.538 with Calendar.SECOND as fragment will return 538
     *   (equivalent to calendar.get(Calendar.MILLISECOND))</li>
     *  <li>January 6, 2008 7:15:10.538 with Calendar.SECOND as fragment will return 538
     *   (equivalent to calendar.get(Calendar.MILLISECOND))</li>
     *  <li>January 6, 2008 7:15:10.538 with Calendar.MINUTE as fragment will return 10538
     *   (10*1000 + 538)</li>
     *  <li>January 16, 2008 7:15:10.538 with Calendar.MILLISECOND as fragment will return 0
     *   (a millisecond cannot be split in milliseconds)</li>
     * </ul>
     * </p>
     * 
     * @param calendar the calendar to work with, not null
     * @param fragment the Calendar field part of calendar to calculate 
     * @return number of milliseconds within the fragment of date
     * @throws IllegalArgumentException if the date is <code>null</code> or 
     * fragment is not supported
     * @since 2.4
     */
  public static long getFragmentInMilliseconds(Calendar calendar, int fragment) {
    return getFragment(calendar, fragment, Calendar.MILLISECOND);
  }
    /**
     * <p>Returns the number of seconds within the 
     * fragment. All datefields greater than the fragment will be ignored.</p> 
     * 
     * <p>Asking the seconds of any date will only return the number of seconds
     * of the current minute (resulting in a number between 0 and 59). This 
     * method will retrieve the number of seconds for any fragment. 
     * For example, if you want to calculate the number of seconds past today, 
     * your fragment is Calendar.DATE or Calendar.DAY_OF_YEAR. The result will
     * be all seconds of the past hour(s) and minutes(s).</p> 
     * 
     * <p>Valid fragments are: Calendar.YEAR, Calendar.MONTH, both 
     * Calendar.DAY_OF_YEAR and Calendar.DATE, Calendar.HOUR_OF_DAY, 
     * Calendar.MINUTE, Calendar.SECOND and Calendar.MILLISECOND
     * A fragment less than or equal to a SECOND field will return 0.</p> 
     * 
     * <p>
     * <ul>
     *  <li>January 1, 2008 7:15:10.538 with Calendar.MINUTE as fragment will return 10
     *   (equivalent to calendar.get(Calendar.SECOND))</li>
     *  <li>January 6, 2008 7:15:10.538 with Calendar.MINUTE as fragment will return 10
     *   (equivalent to calendar.get(Calendar.SECOND))</li>
     *  <li>January 6, 2008 7:15:10.538 with Calendar.DAY_OF_YEAR as fragment will return 26110
     *   (7*3600 + 15*60 + 10)</li>
     *  <li>January 16, 2008 7:15:10.538 with Calendar.MILLISECOND as fragment will return 0
     *   (a millisecond cannot be split in seconds)</li>
     * </ul>
     * </p>
     * 
     * @param calendar the calendar to work with, not null
     * @param fragment the Calendar field part of calendar to calculate 
     * @return number of seconds within the fragment of date
     * @throws IllegalArgumentException if the date is <code>null</code> or 
     * fragment is not supported
     * @since 2.4
     */
    public static long getFragmentInSeconds(Calendar calendar, int fragment) {
        return getFragment(calendar, fragment, Calendar.SECOND);
    }
    
    /**
     * <p>Returns the number of minutes within the 
     * fragment. All datefields greater than the fragment will be ignored.</p> 
     * 
     * <p>Asking the minutes of any date will only return the number of minutes
     * of the current hour (resulting in a number between 0 and 59). This 
     * method will retrieve the number of minutes for any fragment. 
     * For example, if you want to calculate the number of minutes past this month, 
     * your fragment is Calendar.MONTH. The result will be all minutes of the 
     * past day(s) and hour(s).</p> 
     * 
     * <p>Valid fragments are: Calendar.YEAR, Calendar.MONTH, both 
     * Calendar.DAY_OF_YEAR and Calendar.DATE, Calendar.HOUR_OF_DAY, 
     * Calendar.MINUTE, Calendar.SECOND and Calendar.MILLISECOND
     * A fragment less than or equal to a MINUTE field will return 0.</p> 
     * 
     * <p>
     * <ul>
     *  <li>January 1, 2008 7:15:10.538 with Calendar.HOUR_OF_DAY as fragment will return 15
     *   (equivalent to calendar.get(Calendar.MINUTES))</li>
     *  <li>January 6, 2008 7:15:10.538 with Calendar.HOUR_OF_DAY as fragment will return 15
     *   (equivalent to calendar.get(Calendar.MINUTES))</li>
     *  <li>January 1, 2008 7:15:10.538 with Calendar.MONTH as fragment will return 15</li>
     *  <li>January 6, 2008 7:15:10.538 with Calendar.MONTH as fragment will return 435 (7*60 + 15)</li>
     *  <li>January 16, 2008 7:15:10.538 with Calendar.MILLISECOND as fragment will return 0
     *   (a millisecond cannot be split in minutes)</li>
     * </ul>
     * </p>
     * 
     * @param calendar the calendar to work with, not null
     * @param fragment the Calendar field part of calendar to calculate 
     * @return number of minutes within the fragment of date
     * @throws IllegalArgumentException if the date is <code>null</code> or 
     * fragment is not supported
     * @since 2.4
     */
    public static long getFragmentInMinutes(Calendar calendar, int fragment) {
        return getFragment(calendar, fragment, Calendar.MINUTE);
    }
    
    /**
     * <p>Returns the number of hours within the 
     * fragment. All datefields greater than the fragment will be ignored.</p> 
     * 
     * <p>Asking the hours of any date will only return the number of hours
     * of the current day (resulting in a number between 0 and 23). This 
     * method will retrieve the number of hours for any fragment. 
     * For example, if you want to calculate the number of hours past this month, 
     * your fragment is Calendar.MONTH. The result will be all hours of the 
     * past day(s).</p> 
     * 
     * <p>Valid fragments are: Calendar.YEAR, Calendar.MONTH, both 
     * Calendar.DAY_OF_YEAR and Calendar.DATE, Calendar.HOUR_OF_DAY, 
     * Calendar.MINUTE, Calendar.SECOND and Calendar.MILLISECOND
     * A fragment less than or equal to a HOUR field will return 0.</p> 
     *  
     * <p>
     * <ul>
     *  <li>January 1, 2008 7:15:10.538 with Calendar.DAY_OF_YEAR as fragment will return 7
     *   (equivalent to calendar.get(Calendar.HOUR_OF_DAY))</li>
     *  <li>January 6, 2008 7:15:10.538 with Calendar.DAY_OF_YEAR as fragment will return 7
     *   (equivalent to calendar.get(Calendar.HOUR_OF_DAY))</li>
     *  <li>January 1, 2008 7:15:10.538 with Calendar.MONTH as fragment will return 7</li>
     *  <li>January 6, 2008 7:15:10.538 with Calendar.MONTH as fragment will return 127 (5*24 + 7)</li>
     *  <li>January 16, 2008 7:15:10.538 with Calendar.MILLISECOND as fragment will return 0
     *   (a millisecond cannot be split in hours)</li>
     * </ul>
     * </p>
     *  
     * @param calendar the calendar to work with, not null
     * @param fragment the Calendar field part of calendar to calculate 
     * @return number of hours within the fragment of date
     * @throws IllegalArgumentException if the date is <code>null</code> or 
     * fragment is not supported
     * @since 2.4
     */
    public static long getFragmentInHours(Calendar calendar, int fragment) {
        return getFragment(calendar, fragment, Calendar.HOUR_OF_DAY);
    }
    
    /**
     * <p>Returns the number of days within the 
     * fragment. All datefields greater than the fragment will be ignored.</p> 
     * 
     * <p>Asking the days of any date will only return the number of days
     * of the current month (resulting in a number between 1 and 31). This 
     * method will retrieve the number of days for any fragment. 
     * For example, if you want to calculate the number of days past this year, 
     * your fragment is Calendar.YEAR. The result will be all days of the 
     * past month(s).</p> 
     * 
     * <p>Valid fragments are: Calendar.YEAR, Calendar.MONTH, both 
     * Calendar.DAY_OF_YEAR and Calendar.DATE, Calendar.HOUR_OF_DAY, 
     * Calendar.MINUTE, Calendar.SECOND and Calendar.MILLISECOND
     * A fragment less than or equal to a DAY field will return 0.</p> 
     * 
     * <p>
     * <ul>
     *  <li>January 28, 2008 with Calendar.MONTH as fragment will return 28
     *   (equivalent to calendar.get(Calendar.DAY_OF_MONTH))</li>
     *  <li>February 28, 2008 with Calendar.MONTH as fragment will return 28
     *   (equivalent to calendar.get(Calendar.DAY_OF_MONTH))</li>
     *  <li>January 28, 2008 with Calendar.YEAR as fragment will return 28
     *   (equivalent to calendar.get(Calendar.DAY_OF_YEAR))</li>
     *  <li>February 28, 2008 with Calendar.YEAR as fragment will return 59
     *   (equivalent to calendar.get(Calendar.DAY_OF_YEAR))</li>
     *  <li>January 28, 2008 with Calendar.MILLISECOND as fragment will return 0
     *   (a millisecond cannot be split in days)</li>
     * </ul>
     * </p>
     * 
     * @param calendar the calendar to work with, not null
     * @param fragment the Calendar field part of calendar to calculate 
     * @return number of days within the fragment of date
     * @throws IllegalArgumentException if the date is <code>null</code> or 
     * fragment is not supported
     * @since 2.4
     */
    public static long getFragmentInDays(Calendar calendar, int fragment) {
        return getFragment(calendar, fragment, Calendar.DAY_OF_YEAR);
    }
    
    /**
     * Date-version for fragment-calculation in any unit
     * 
     * @param date the date to work with, not null
     * @param fragment the Calendar field part of date to calculate 
     * @param unit Calendar field defining the unit
     * @return number of units within the fragment of the date
     * @throws IllegalArgumentException if the date is <code>null</code> or 
     * fragment is not supported
     * @since 2.4
     */
    private static long getFragment(Date date, int fragment, int unit) {
        if(date == null) {
            throw  new IllegalArgumentException("The date must not be null");
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return getFragment(calendar, fragment, unit);
    }

    /**
     * Calendar-version for fragment-calculation in any unit
     * 
     * @param calendar the calendar to work with, not null
     * @param fragment the Calendar field part of calendar to calculate 
     * @param unit Calendar field defining the unit
     * @return number of units within the fragment of the calendar
     * @throws IllegalArgumentException if the date is <code>null</code> or 
     * fragment is not supported
     * @since 2.4
     */
    private static long getFragment(Calendar calendar, int fragment, int unit) {
        if(calendar == null) {
            throw  new IllegalArgumentException("The date must not be null"); 
        }
        long millisPerUnit = getMillisPerUnit(unit);
        long result = 0;
        
        // Fragments bigger than a day require a breakdown to days
        switch (fragment) {
            case Calendar.YEAR:
                result += (calendar.get(Calendar.DAY_OF_YEAR) * MILLIS_PER_DAY) / millisPerUnit;
                break;
            case Calendar.MONTH:
                result += (calendar.get(Calendar.DAY_OF_MONTH) * MILLIS_PER_DAY) / millisPerUnit;
                break;
        }

        switch (fragment) {
            // Number of days already calculated for these cases
            case Calendar.YEAR:
            case Calendar.MONTH:
            
            // The rest of the valid cases
            case Calendar.DAY_OF_YEAR:
            case Calendar.DATE:
                result += (calendar.get(Calendar.HOUR_OF_DAY) * MILLIS_PER_HOUR) / millisPerUnit;
                //$FALL-THROUGH$
            case Calendar.HOUR_OF_DAY:
                result += (calendar.get(Calendar.MINUTE) * MILLIS_PER_MINUTE) / millisPerUnit;
                //$FALL-THROUGH$
            case Calendar.MINUTE:
                result += (calendar.get(Calendar.SECOND) * MILLIS_PER_SECOND) / millisPerUnit;
                //$FALL-THROUGH$
            case Calendar.SECOND:
                result += (calendar.get(Calendar.MILLISECOND) * 1) / millisPerUnit;
                break;
            case Calendar.MILLISECOND: 
                break;//never useful
            default: 
                throw new IllegalArgumentException("The fragment " + fragment + " is not supported");
        }
        return result;
    }
    
    /**
     * Returns the number of millis of a datefield, if this is a constant value
     * 
     * @param unit A Calendar field which is a valid unit for a fragment
     * @return number of millis
     * @throws IllegalArgumentException if date can't be represented in millisenconds
     * @since 2.4 
     */
    private static long getMillisPerUnit(int unit) {
        long result = Long.MAX_VALUE;
        switch (unit) {
            case Calendar.DAY_OF_YEAR:
            case Calendar.DATE:
                result = MILLIS_PER_DAY;
                break;
            case Calendar.HOUR_OF_DAY:
                result = MILLIS_PER_HOUR;
                break;
            case Calendar.MINUTE:
                result = MILLIS_PER_MINUTE;
                break;
            case Calendar.SECOND:
                result = MILLIS_PER_SECOND;
                break;
            case Calendar.MILLISECOND:
                result = 1;
                break;
            default: throw new IllegalArgumentException("The unit " + unit + " cannot be represented is milleseconds");
        }
        return result;
    }

    /**
     * timestamp转化为时间
     * @param timestamp
     * @param pattern
     * @return
     */
    public static String timestamp2String(Timestamp timestamp, String pattern) {
		if (timestamp == null) {
			throw new java.lang.IllegalArgumentException("timestamp null illegal");
		}
		if (pattern == null || pattern.equals("")) {
			pattern = PATTERN_STANDARD;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(new Date(timestamp.getTime()));
	}
    /**
     * 日期转化为字符串
     * @param date
     * @param pattern
     * @return
     */
	public static String date2String(java.util.Date date, String pattern) {
		if (date == null) {
			throw new java.lang.IllegalArgumentException("timestamp null illegal");
		}
		if (pattern == null || pattern.equals("")) {
			pattern = PATTERN_STANDARD;
			;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(date);
	}

	public static Timestamp currentTimestamp() {
		return new Timestamp(new Date().getTime());
	}
	/**
	 * 当前时间转化为字符串
	 * @param pattern
	 * @return
	 */
	public static String currentTimestamp2String(String pattern) {
		return timestamp2String(currentTimestamp(), pattern);
	}
	/**
	 * 字符串转化时间
	 * @param strDateTime
	 * @param pattern
	 * @return
	 */
	public static Timestamp string2Timestamp(String strDateTime, String pattern) {
		if (strDateTime == null || strDateTime.equals("")) {
			throw new java.lang.IllegalArgumentException("Date Time Null Illegal");
		}
		if (pattern == null || pattern.equals("")) {
			pattern = PATTERN_STANDARD;
		}

		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		Date date = null;
		try {
			date = sdf.parse(strDateTime);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
		return new Timestamp(date.getTime());
	}
	/**
	 * 时间转化为日期
	 * @param strDate
	 * @param pattern
	 * @return
	 */
	public static Date string2Date(String strDate, String pattern) {
		if (strDate == null || strDate.equals("")) {
			throw new RuntimeException("str date null");
		}
		if (pattern == null || pattern.equals("")) {
			pattern = DateTimeUtils.PATTERN_DATE;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		Date date = null;

		try {
			date = sdf.parse(strDate);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
		return date;
	}

	public static String stringToYear(String strDest) {
		if (strDest == null || strDest.equals("")) {
			throw new java.lang.IllegalArgumentException("str dest null");
		}

		Date date = string2Date(strDest, DateTimeUtils.PATTERN_DATE);
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return String.valueOf(c.get(Calendar.YEAR));
	}

	public static String stringToMonth(String strDest) {
		if (strDest == null || strDest.equals("")) {
			throw new java.lang.IllegalArgumentException("str dest null");
		}

		Date date = string2Date(strDest, DateTimeUtils.PATTERN_DATE);
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		// return String.valueOf(c.get(Calendar.MONTH));
		int month = c.get(Calendar.MONTH);
		month = month + 1;
		if (month < 10) {
			return "0" + month;
		}
		return String.valueOf(month);
	}

	public static String stringToDay(String strDest) {
		if (strDest == null || strDest.equals("")) {
			throw new java.lang.IllegalArgumentException("str dest null");
		}

		Date date = string2Date(strDest, DateTimeUtils.PATTERN_DATE);
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		// return String.valueOf(c.get(Calendar.DAY_OF_MONTH));
		int day = c.get(Calendar.DAY_OF_MONTH);
		if (day < 10) {
			return "0" + day;
		}
		return "" + day;
	}

	public static Date getFirstDayOfMonth(Calendar c) {
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH);
		int day = 1;
		c.set(year, month, day, 0, 0, 0);
		return c.getTime();
	}

	public static Date getLastDayOfMonth(Calendar c) {
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH) + 1;
		int day = 1;
		if (month > 11) {
			month = 0;
			year = year + 1;
		}
		c.set(year, month, day - 1, 0, 0, 0);
		return c.getTime();
	}


	public static boolean compareDate(Date firstDate, Date secondDate) {
		if (firstDate == null || secondDate == null) {
			throw new java.lang.RuntimeException();
		}

		String strFirstDate = date2String(firstDate, "yyyy-MM-dd");
		String strSecondDate = date2String(secondDate, "yyyy-MM-dd");
		if (strFirstDate.equals(strSecondDate)) {
			return true;
		}
		return false;
	}
	
	public static Date getStartTimeOfDate(Date currentDate) {
		String strDateTime = date2String(currentDate,"yyyy-MM-dd") + " 00:00:00";
		return string2Date(strDateTime,"yyyy-MM-dd hh:mm:ss");
	}
	
	public static Date getEndTimeOfDate(Date currentDate) {
		String strDateTime = date2String(currentDate,"yyyy-MM-dd") + " 59:59:59";
		return string2Date(strDateTime,"yyyy-MM-dd hh:mm:ss");
	}
	
	public static Date add(int field,Date date,int value) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		
		int fieldNewValue = (c.get(field) + value);
		c.set(field, fieldNewValue);
		return c.getTime();
	}
 
	public static int get(int field,Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(field);
	}
	
	public static boolean isEqualField(int field, Date d1, Date d2) {
		Calendar c1 = Calendar.getInstance();
		c1.setTime(d1);
		
		Calendar c2 = Calendar.getInstance();
		c2.setTime(d2);
		return c1.get(field) == c2.get(field);
	}
	private StringBuffer buffer = new StringBuffer();
	private static String ZERO = "0";
	private static DateTimeUtils date;
	public static SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
	public static SimpleDateFormat format1 = new SimpleDateFormat(
			"yyyyMMdd HH:mm:ss");

	public String getNowString() {
		Calendar calendar = getCalendar();
		buffer.delete(0, buffer.capacity());
		buffer.append(getYear(calendar));

		if (getMonth(calendar) < 10) {
			buffer.append(ZERO);
		}
		buffer.append(getMonth(calendar));

		if (getDate(calendar) < 10) {
			buffer.append(ZERO);
		}
		buffer.append(getDate(calendar));
		if (getHour(calendar) < 10) {
			buffer.append(ZERO);
		}
		buffer.append(getHour(calendar));
		if (getMinute(calendar) < 10) {
			buffer.append(ZERO);
		}
		buffer.append(getMinute(calendar));
		if (getSecond(calendar) < 10) {
			buffer.append(ZERO);
		}
		buffer.append(getSecond(calendar));
		return buffer.toString();
	}

	private static int getDateField(Date date,int field) {
		Calendar c = getCalendar();
		c.setTime(date);
		return c.get(field);
	}
	public static int getYearsBetweenDate(Date begin,Date end){
		int bYear=getDateField(begin,Calendar.YEAR);
		int eYear=getDateField(end,Calendar.YEAR);
		return eYear-bYear;
	}
	
	public static int getMonthsBetweenDate(Date begin,Date end){
		int bMonth=getDateField(begin,Calendar.MONTH);
		int eMonth=getDateField(end,Calendar.MONTH);
		return eMonth-bMonth;
	}
	public static int getWeeksBetweenDate(Date begin,Date end){
		int bWeek=getDateField(begin,Calendar.WEEK_OF_YEAR);
		int eWeek=getDateField(end,Calendar.WEEK_OF_YEAR);
		return eWeek-bWeek;
	}
	public static int getDaysBetweenDate(Date begin,Date end){
		int bDay=getDateField(begin,Calendar.DAY_OF_YEAR);
		int eDay=getDateField(end,Calendar.DAY_OF_YEAR);
		return eDay-bDay;
	}

	/**
	 * 获取date年后的amount年的第一天的开始时间
	 * 
	 * @param amount
	 *            可正、可负
	 * @return
	 */
	public static Date getSpecficYearStart(Date date,int amount) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.YEAR, amount);
		cal.set(Calendar.DAY_OF_YEAR, 1);
		return getStartDate(cal.getTime());
	}

	/**
	 * 获取date年后的amount年的最后一天的终止时间
	 * 
	 * @param amount
	 *            可正、可负
	 * @return
	 */
	public static Date getSpecficYearEnd(Date date,int amount) {
		Date temp = getStartDate(getSpecficYearStart(date,amount + 1));
		Calendar cal = Calendar.getInstance();
		cal.setTime(temp);
		cal.add(Calendar.DAY_OF_YEAR, -1);
		return getFinallyDate(cal.getTime());
	}

	/**
	 * 获取date月后的amount月的第一天的开始时间
	 * 
	 * @param amount
	 *            可正、可负
	 * @return
	 */
	public static Date getSpecficMonthStart(Date date,int amount) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, amount);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		return getStartDate(cal.getTime());
	}

	/**
	 * 获取当前自然月后的amount月的最后一天的终止时间
	 * 
	 * @param amount
	 *            可正、可负
	 * @return
	 */
	public static Date getSpecficMonthEnd(Date date,int amount) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(getSpecficMonthStart(date,amount + 1));
		cal.add(Calendar.DAY_OF_YEAR, -1);
		return getFinallyDate(cal.getTime());
	}

	/**
	 * 获取date周后的第amount周的开始时间（这里星期一为一周的开始）
	 * 
	 * @param amount
	 *            可正、可负
	 * @return
	 */
	public static Date getSpecficWeekStart(Date date,int amount) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.setFirstDayOfWeek(Calendar.MONDAY); /* 设置一周的第一天为星期一 */
		cal.add(Calendar.WEEK_OF_MONTH, amount);
		cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		return getStartDate(cal.getTime());
	}

	/**
	 * 获取date周后的第amount周的最后时间（这里星期日为一周的最后一天）
	 * 
	 * @param amount
	 *            可正、可负
	 * @return
	 */
	public static Date getSpecficWeekEnd(Date date,int amount) {
		Calendar cal = Calendar.getInstance();
		cal.setFirstDayOfWeek(Calendar.MONDAY); /* 设置一周的第一天为星期一 */
		cal.add(Calendar.WEEK_OF_MONTH, amount);
		cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		return getFinallyDate(cal.getTime());
	}
	
	public static Date getSpecficDateStart(Date date,int amount){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DAY_OF_YEAR, amount);
		return getStartDate(cal.getTime());
	}

	/**
	 * 得到指定日期的一天的的最后时刻23:59:59
	 * 
	 * @param date
	 * @return
	 */
	public static Date getFinallyDate(Date date) {
		String temp = format.format(date);
		temp += " 23:59:59";

		try {
			return format1.parse(temp);
		} catch (ParseException e) {
			return null;
		}
	}

	/**
	 * 得到指定日期的一天的开始时刻00:00:00
	 * 
	 * @param date
	 * @return
	 */
	public static Date getStartDate(Date date) {
		String temp = format.format(date);
		temp += " 00:00:00";

		try {
			return format1.parse(temp);
		} catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * 
	 * @param date 指定比较日期
	 * @param compareDate 
	 * @return
	 */
	public static boolean isInDate(Date date,Date compareDate){
		if(compareDate.after(getStartDate(date))&&compareDate.before(getFinallyDate(date))){
			return true;
		}else{
			return false;
		}
	}

	private int getYear(Calendar calendar) {
		return calendar.get(Calendar.YEAR);
	}

	private int getMonth(Calendar calendar) {
		return calendar.get(Calendar.MONDAY) + 1;
	}

	private int getDate(Calendar calendar) {
		return calendar.get(Calendar.DATE);
	}

	private int getHour(Calendar calendar) {
		return calendar.get(Calendar.HOUR_OF_DAY);
	}

	private int getMinute(Calendar calendar) {
		return calendar.get(Calendar.MINUTE);
	}

	private int getSecond(Calendar calendar) {
		return calendar.get(Calendar.SECOND);
	}

	private static Calendar getCalendar() {
		return Calendar.getInstance();
	}

	public static DateTimeUtils getDateInstance() {
		if (date == null) {
			date = new DateTimeUtils();
		}
		return date;
	}
	
	
	/**
	 * 获取当前年份
	 * @return
	 */
	public static int getCurrentYear(){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		return calendar.get(Calendar.YEAR);
	}
	/**
	 * 获取当前月份
	 * @return
	 */
	public static int getCurrentMonth(){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		return calendar.get(Calendar.MONTH)+1;
	}
	/**
	 * 获取当前日期
	 * @return
	 */
	public static int getCurrentDay(){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		return calendar.get(Calendar.DAY_OF_MONTH);
	}
	/**
	 * 获取当前年月
	 * @return
	 */
	public static String getTimeStamp(){
		return DateTimeUtils.date2String(new Date(), "yyMMdd");
	}
	
	/**
	 * 判断是否润年
	 * 
	 * @param piYear
	 * @return
	 */
	public static boolean isLeapYear(int piYear) {
		boolean b = ((piYear % 4) == 0) && ((piYear % 100) != 0) || ((piYear % 400) == 0);
		return (b);
	}
	
	/**
	 * 获取两个年限直接有多少个闰年
	 * 
	 * @param year1
	 * @param year2
	 * @return
	 */
	public static int getCount(int year1, int year2) {
		int rncount = 0;
		for (int i = year1; i < year2; i++) {
			if (isLeapYear(i)) {
				rncount++;
			}
		}
		return rncount;
	}
	
	/**
	 * 计算当前日期是第几季度
	 * 
	 * @param date
	 * @return
	 */
	public static int getTheSeasonQuater(java.util.Date date) {
		int i = 0;
		int j = 0;
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		i = c.get(Calendar.MONTH) + 1;
		j = (i / 3) + 1;
		if (j > 4) {
			j = 4;
		}
		return j;
	}

	
	public static void main(String[] args){
		String str1 = "2011-01-01";
		String str2 = "1988-09-09";
		Date date1 = DateTimeUtils.string2Date(str1, "yyyy-MM-dd");
		Date date2 = DateTimeUtils.string2Date(str2, "yyyy-MM-dd");
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		c1.setTime(date1);
		c2.setTime(date2);
		c2.add(Calendar.YEAR, 4);
		if (c2.before(c1)) {
			System.out.println("illegal");
		}else {
			System.out.println("ok");
		}
		
	}
	// 得到当前年

	public static String getThisYear() {
		String dateString = "";

		java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat(
				"yyyy");
		java.util.Date currentTime_1 = new java.util.Date();
		dateString = formatter.format(currentTime_1);

		return dateString;
	}

	// 得到当前月

	public static String getThisMonth() {

		String dateString = "";

		java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat(
				"MM");
		java.util.Date currentTime_1 = new java.util.Date();
		dateString = formatter.format(currentTime_1);

		return dateString;
	}
	/**
	 * 根据生日得到年龄
	 */
	public static Integer getAge(String year) {
		Calendar c = Calendar.getInstance();
		if (year == null) {
			return 20;
		}
		year = year.substring(0, 4);
		Integer age = c.get(Calendar.YEAR) - Integer.parseInt(year);
		return age;
	}
	/**
	 * 根据年龄取得对于的出生时间
	 */
	public static String getBirthday(String age) {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.YEAR, -Integer.parseInt(age));
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return format.format(c.getTime());
	}
	// 得到当前季度
	public static String getThisQuarter() {

		String quarter = "";
		String month = getThisMonth();

		if (month.equals("01") || month.equals("02") || month.equals("03")) {
			quarter = "第一季度";

		} else if (month.equals("04") || month.equals("05")
				|| month.equals("06")) {
			quarter = "第二季度";

		} else if (month.equals("07") || month.equals("08")
				|| month.equals("09")) {
			quarter = "第三季度";

		} else {
			quarter = "第四季度";

		}

		return quarter;
	}
	/**
	 * 得到以当前时间为基数的序列号，方法为同步安全的
	 * 
	 * @return
	 */
	public synchronized static Long getSerialNum() {
		Long result = new Long(DateTimeUtils.date2String(new Date(), "yyyyMMddHHmmssS"));
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// logger.error(e);
			throw new RuntimeException(e);
		}
		return result;
	}
	
	/**
	 * 取得当前日期
	 *
	 * @return 当前日期
	 */
	public static java.sql.Date getNowDate() {
		Calendar cal = Calendar.getInstance();
		return new java.sql.Date(cal.getTimeInMillis());
	}
	
	/**
	 * 获取两个时间的差值秒
	 * @param d1
	 * @param d2
	 * @return
	 */
	public static Integer getSecondBetweenDate(Date d1,Date d2){
		Long second=(d2.getTime()-d1.getTime())/1000;
		return second.intValue();
	}
}
