package com.moon.infrastructure.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

public class DateUtil
{
	/**
	 * 默认的日期格式
	 */
	public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";

	public static final String FMT_DATE_YYYY = "yyyy";
	public static final String FMT_DATE_YYYYMMDD = "yyyy-MM-dd";
	public static final String FMT_DATE_YYYYMMDD_HHMMSS = "yyyy-MM-dd HH:mm:ss";
	public static final String FMT_DATE_YYYYMMDDTHHMMSS_SSSXXX = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX";
	public static final String FMT_DATE_YYYYMMDD_HHMMSS_SSS = "yyyy-MM-dd HH:mm:ss.SSS";
	public static final String FMT_DATE_HHMMSS = "HH:mm:ss";
	public static final String FMT_DATE_HHMM = "HH:mm";
	public static final String FMT_DATE_SPECIAL = "yyyyMMdd";
	public static final String FMT_DATE_MMDD = "MM-dd";
	public static final String FMT_DATE_YYYYMMDDHHMM = "yyyy-MM-dd HH:mm";
	public static final String FMT_DATE_MMDD_HHMM = "MM-dd HH:mm";
	public static final String FMT_DATE_MMMDDD = "MM月dd日";
	public static final String FMT_DATE_YYYYMMDDHHMM_NEW = "yyyyMMddHHmm";
	public static final String FMT_DATE_YYYY年M月D日 = "yyyy年M月d日";
	public static final String FMT_DATE_YYYY年MM月DD日 = "yyyy年MM月dd日";
	public static final String FMT_DATE_YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
	public static final String FMT_DATE_YYYY年MM月DD日HH时MM分 = "yyyy年MM月dd日HH时mm分";
	public static final String FMT_DATE_YYYYMMDDHH = "yyyyMMddHH";
	public static final String FMT_DATE_YYYYMM = "yyyyMM";
	public static final String FMT_DATE_YYYYMMDDHH_MM_SS = "yyyyMMddHH:mm:ss";
	public static final String FMT_DATE_YYYYMMDD_POINT = "yyyy.MM.dd";
	public static final String FMT_DATE_MMDDHHmm = "M月d日HH:mm";
	public static final String FMT_DATE_YYYYMMDDHHMMSS_NEW = "yyyyMMddHHmmss";

	/**
	 * 5min的毫秒数
	 */
	public final static int _5_MIN_MILLIS = 5 * 60 * 1000;

	/**
	 * 1小时的毫秒数
	 */
	public final static int _1_HOUR_MILLIS = 60 * 60 * 1000;

	/**
	 * 24小时的毫秒数
	 */
	public final static int _24_HOUR_MILLIS = 24 * 60 * 60 * 1000;

	/**
	 * 24小时的分钟数
	 */
	public final static int _24_HOUR_MINUTES = 24 * 60;

	/**
	 * 按自定义日期格式格式化日期
	 * 
	 * @param target
	 * @param format
	 * @return 格式化后的日期字符串，如果传入的日期对象为NULL，返回空字符串
	 */
	public static String formatDate(Date target, String format)
	{
		if (target == null)
		{
			return "";
		}
		return new SimpleDateFormat(format).format(target);
	}

	/**
	 * 按默认日期格式 格式化日期
	 * 
	 * @param target
	 * @return 格式化后的日期字符串，如果传入的日期对象为NULL，返回空字符串
	 */
	public static String formatDate(Date target)
	{
		return formatDate(target, DEFAULT_DATE_FORMAT);
	}

	/**
	 * 将Timestamp对象格式化
	 * @param time
	 * @param format
	 * @return  格式化后的日期字符串，如果传入的Timestamp对象为NULL，返回空字符串
	 */
	public static String formatTimestamp(Timestamp time, String format)
	{
		if (time == null)
		{
			return "";
		}
		return new SimpleDateFormat(format).format(time);
	}

	/**
	 * 将字符串格式化为日期对象
	 * @param date
	 * @param format
	 * @return 如果date为空或格式不标准，返回NULL，否则返回对应的日期对象
	 */
	public static Date formatToDate(String date, String format)
	{
		try
		{
			if (StringUtils.isBlank(date))
			{
				return null;
			}

			SimpleDateFormat sorceFmt = new SimpleDateFormat(format);
			return new Date(sorceFmt.parse(date).getTime());
		}
		catch (ParseException e)
		{
			return null;
		}
	}

	/**
	 * 将字符串格式化为日期对象
	 * @param dateStr
	 * @param format
	 * @return
	 */
	public static Timestamp formatToTimestamp(String dateStr, String format)
	{
		if (StringUtils.isBlank(dateStr))
		{
			return null;
		}
		try
		{
			SimpleDateFormat sorceFmt = new SimpleDateFormat(format);
			return new Timestamp(sorceFmt.parse(dateStr).getTime()); // 一天的时间24*3600*1000
		}
		catch (ParseException e)
		{
			return null;
		}
	}

	/**
	 * 得到当前时间的TimeStamp格式
	 * @return
	 */
	public static Timestamp getCurrentTimestamp()
	{
		return new Timestamp(System.currentTimeMillis());
	}

	/**
	 * 得到当前时间字符串
	 * @return
	 */
	public static String getCurrentTime()
	{
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		Date d = new Date(System.currentTimeMillis());
		return sdf.format(d);
	}

	/**
	 * 得到当前日期时间字符串
	 * @return
	 */
	public static String getCurrentDateTime()
	{
		SimpleDateFormat sdf = new SimpleDateFormat(FMT_DATE_YYYYMMDD_HHMMSS);
		Date d = new Date(System.currentTimeMillis());
		return sdf.format(d);
	}

	/**
	 * 得到当前日期字符串
	 * @return
	 */
	public static String getCurrentDate()
	{
		SimpleDateFormat sdf = new SimpleDateFormat(FMT_DATE_YYYYMMDD);
		Date d = new Date(System.currentTimeMillis());
		return sdf.format(d);
	}
	public static Timestamp getIntervalYear(Date date, int years)
	{
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.YEAR, years);
		return new Timestamp(calendar.getTime().getTime());
	}

	public static Date getIntervalDate(Date date, int days)
	{
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, days);

		return calendar.getTime();
	}

	public static Date getIntervalHour(Date date, int hours)
	{
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.HOUR_OF_DAY, hours);

		return calendar.getTime();
	}

	public static Date getIntervalMinute(Date date, int minutes)
	{
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MINUTE, minutes);

		return calendar.getTime();
	}

	public static Timestamp getIntervalMinuteTimestamp(Date date, int minutes)
	{
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MINUTE, minutes);

		return new Timestamp(calendar.getTime().getTime());
	}

	public static Timestamp getIntervalMinuteTimestamp(Timestamp timestamp, int minutes)
	{
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(timestamp);
		calendar.add(Calendar.MINUTE, minutes);

		return new Timestamp(calendar.getTime().getTime());
	}

	public static Timestamp getIntervalSecond(Date date, int seconds)
	{
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.SECOND, seconds);

		return new Timestamp(calendar.getTime().getTime());
	}

	public static Timestamp getIntervalSecond(long timestamp, int seconds)
	{
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(timestamp);
		calendar.add(Calendar.SECOND, seconds);
		
		return new Timestamp(calendar.getTime().getTime());
	}

	public static Timestamp getIntervalTimestamp(Date date, int days)
	{
		return new Timestamp(getIntervalDate(date, days).getTime());
	}

	/**
	 * 判断传入日期是否是今天
	 */
	public static boolean isToday(Date date)
	{
		return isSameDay(date, new Date());
	}

	/**
	 * 判断传入日期是否是本月
	 */
	public static boolean isThisMonth(Timestamp date)
	{
		Calendar source = Calendar.getInstance();
		source.setTimeInMillis(date.getTime());
		Calendar today = Calendar.getInstance();
		today.setTimeInMillis(getCurrentTimestamp().getTime());
		return isSameMonth(source, today);
	}

	public static boolean isSameMonth(Calendar source, Calendar target)
	{
		if (source == null || target == null)
		{
			return false;
		}
		SimpleDateFormat sorceFmt = new SimpleDateFormat("yyyy-MM");
		String sourceDate = sorceFmt.format(source.getTime());
		String targetDate = sorceFmt.format(target.getTime());
		if (StringUtils.isNotBlank(sourceDate) && StringUtils.equals(sourceDate, targetDate))
		{
			return true;
		}
		return false;
	}

	/**
	 * 获取当前时间指定月数之前的日期
	 * @param month
	 * @return
	 */
	public static Date getDateBeforeMonth(int month)
	{
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.setTime(new Date());
		calendar.add(Calendar.MONTH, -month); // month月前
		Date dayBeforeHalfYear = new Date(calendar.getTimeInMillis());
		return dayBeforeHalfYear;
	}

	/**
	 * 得到当天开始的Timestamp
	 * 
	 * @return
	 */
	public static Timestamp getBeginOfToday()
	{
		return getBeginOfThisDay(new Date());
	}

	/**
	 * 得到当天结束的Timestamp
	 * 
	 * @return
	 */
	public static Timestamp getEndOfToday()
	{
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat form = new SimpleDateFormat(DEFAULT_DATE_FORMAT);
		String dateStr = form.format(cal.getTime()) + " 23:59:59";
		Date date = null;
		try
		{
			form = new SimpleDateFormat(FMT_DATE_YYYYMMDD_HHMMSS);
			date = form.parse(dateStr);
		}
		catch (ParseException e)
		{
			return null;
		}
		return new Timestamp(date.getTime());
	}

	public static Timestamp getEndOfDay(Date now)
	{
		SimpleDateFormat form = new SimpleDateFormat(DEFAULT_DATE_FORMAT);
		String dateStr = form.format(now.getTime()) + " 23:59:59";
		Date date = null;
		try
		{
			form = new SimpleDateFormat(FMT_DATE_YYYYMMDD_HHMMSS);
			date = form.parse(dateStr);
		}
		catch (ParseException e)
		{
			return null;
		}
		return new Timestamp(date.getTime());
	}

	public static Timestamp getBeginOfThisDay(Date time)
	{
		SimpleDateFormat form = new SimpleDateFormat(DEFAULT_DATE_FORMAT);
		String dateStr = form.format(time);
		Date date = null;
		try
		{
			date = form.parse(dateStr);
		}
		catch (ParseException e)
		{
			return null;
		}
		return new Timestamp(date.getTime());
	}
	
	public static String getBeginOfNextDay(String date)
	{
		return getBeginOfNextDay(date, DEFAULT_DATE_FORMAT);
	}
	
	public static String getBeginOfNextDay(String date, String format)
	{
		Timestamp time = DateUtil.formatToTimestamp(date, format);
		if (time == null)
			return null;
		Timestamp timestampAfter = getTimestampAfter(time, 1);
		return DateUtil.formatDate(timestampAfter, FMT_DATE_YYYYMMDD_HHMMSS);
	}
	
	public static Timestamp getBeginOfThisMonth()
	{
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd");
		cal.set(Calendar.DATE, 1);
		String dateStr = form.format(cal.getTime()) + " 00:00:00";
		Date date = null;
		try
		{
			date = form.parse(dateStr);
		}
		catch (ParseException e)
		{
			return null;
		}
		return new Timestamp(date.getTime());

	}

	public static Timestamp getTimestamp(String time)
	{
		return new Timestamp(Long.parseLong(time));
	}

	public static Timestamp getTimestampAfter(Date from, int days)
	{
		return getIntervalTimestamp(from, days);
	}

	/**
	 * 时间加n个月,n可为负数
	 * @return
	 */
	public static Timestamp getTimestampAfterMonth(Date from, int months)
	{
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(from);
		calendar.add(Calendar.MONTH, months);
		return new Timestamp(calendar.getTime().getTime());
	}

	public static Date getTimestampAfterHours(Timestamp from, int hours)
	{
		//SimpleDateFormat fmtDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date dayFrom = new Date(from.getTime());
		//fmtDate.format(dayFrom);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(dayFrom);
		calendar.add(Calendar.HOUR, hours);
		return calendar.getTime();
	}

	public static long formatAndGetTimeLongValue(Date time, String format)
	{
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Date formatTime = null;
		try
		{
			formatTime = sdf.parse(sdf.format(time.getTime()));
		}
		catch (ParseException e)
		{
			formatTime = new Date();
		}
		return formatTime.getTime() / 1000;
	}

	/**
	 * 判断时间是否在区间范围内,比如source和target是否间隔为1小时内
	 * @param source 基点时间
	 * @param target 目标时间
	 * @param range 区间范围
	 * @param Unit 时间单位，使用Calendar的单位
	 * @return
	 */
	public static boolean checkTimeRange(Calendar source, Calendar target, int range, int Unit)
	{
		if (source == null || target == null || range == 0)
		{
			return false;
		}
		if (source.before(target))
		{
			source.add(Unit, range);
			if (source.compareTo(target) >= 0)
			{
				return true;
			}
		}
		else
		{
			source.add(Unit, range * -1);
			if (source.compareTo(target) <= 0)
			{
				return true;
			}
		}
		return false;
	}

	/**
	 * 判断传入的两个日期是否是同年同月同日
	 * @param source
	 * @param target
	 * @return
	 */
	public static boolean isSameDay(Date source, Date target)
	{
		if (source == null || target == null)
		{
			return false;
		}
		SimpleDateFormat sorceFmt = new SimpleDateFormat(DEFAULT_DATE_FORMAT);
		String sourceDate = sorceFmt.format(source);
		String targetDate = sorceFmt.format(target);
		if (StringUtils.isNotBlank(sourceDate) && StringUtils.equals(sourceDate, targetDate))
		{
			return true;
		}
		return false;
	}

	/**
	 * 检验日期字符串是否为期望的格式
	 * 
	 * @param dateStr
	 * @param dateFormat
	 * @return
	 */
	public static boolean checkDateFormat(String dateStr, String dateFormat)
	{
		if (dateStr == null || dateStr.equals(""))
		{
			return false;
		}

		try
		{
			SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
			sdf.setLenient(false);
			sdf.parse(dateStr);
		}
		catch (ParseException e)
		{

			return false;
		}

		return true;
	}

	/**
	 * 根据距当前时间的分钟数获得timestamp
	 * 
	 * @long minute 当前时间之后的分钟数
	 * @return Timestamp
	 */
	public static Timestamp getTimestampByDiffMinute(long minute)
	{
		Calendar cal = Calendar.getInstance();
		long time = cal.getTimeInMillis() + minute * 60 * 1000;
		return new Timestamp(time);
	}

	/**
	 * 
	 * @param date2Get
	 *            将日期按照指定的天数增加或者减少，并转换为需要的日期格式
	 * @param format
	 *            需要转换为的格式
	 * @param days
	 *            时间间隔
	 * @return date2Get 成功：转换后的日期，失败：can't format your input
	 */
	public static String getIntervalDate(Date date2Get, String format, int days)
	{
		Calendar c = Calendar.getInstance();
		c.setTime(date2Get);
		c.add(Calendar.DAY_OF_YEAR, days); // 增加天数(如果days为负数,则为减少天数)
		String dateToGet = new SimpleDateFormat(format).format(c.getTime());
		return dateToGet;
	}

	/*
	 * 时间格式转换
	 */
	public static String convertTime(Timestamp timestamp)
	{
		long begin_time_gap = getBeginOfToday().getTime() - timestamp.getTime();
		long time_gap = System.currentTimeMillis() - timestamp.getTime();
		if (begin_time_gap > 1000L * 3600 * 24)
		{
			SimpleDateFormat sdf = new SimpleDateFormat(FMT_DATE_YYYYMMDDHHMM);
			return sdf.format(timestamp);
		}
		else if (begin_time_gap > 0L)
		{
			SimpleDateFormat form = new SimpleDateFormat(FMT_DATE_HHMM);
			return "昨天 " + form.format(timestamp);
		}
		else if (time_gap >= 1000L * 3600)
		{
			SimpleDateFormat form = new SimpleDateFormat(FMT_DATE_HHMM);
			return "今天 " + form.format(timestamp);
		}
		else if (time_gap >= 1000L * 60)
		{
			return time_gap / (1000L * 60) + "分钟前";
		}
		else if (time_gap > 1000L)
		{
			return time_gap / 1000L + "秒前";
		}
		else
		{
			return "";
		}
	}
	
	public static Date getDate(int year, int month, int day)
	{
		return getDate(year, month, day, 0, 0, 0);
	}

	public static Date getDate(int year, int month, int day, int hour, int minute, int second)
	{
		Date ts = null;
		Date dt = null;
		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month - 1, day, hour, minute, second);
		dt = calendar.getTime();
		ts = new Date(dt.getTime());
		return ts;
	}
	
	/**
	 * 获取 YYYYMMDDHH 格式字符串
	 * @param timestamp
	 * @return
	 */
	public static String formatDateYYYYMMDDHH(Timestamp timestamp)
	{
		if (timestamp == null)
		{
			return null;
		}
		return new SimpleDateFormat(FMT_DATE_YYYYMMDDHH).format(timestamp);
	}
	public static Date parseUtilDate(String strDate, String nFmtDate)
	{
		if (strDate == null || strDate.trim().length() == 0)
			return null;
		SimpleDateFormat fmtDate = null;
		switch (nFmtDate)
		{
			default:
			case FMT_DATE_YYYYMMDD:
				fmtDate = new SimpleDateFormat("yyyy-MM-dd");
				break;
			case FMT_DATE_YYYYMMDD_HHMMSS:
				fmtDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				break;
			case FMT_DATE_YYYYMMDDHHMMSS:
				fmtDate = new SimpleDateFormat("yyyyMMddHHmmss");
				break;
			case FMT_DATE_HHMM:
				fmtDate = new SimpleDateFormat("HH:mm");
				break;
			case FMT_DATE_HHMMSS:
				fmtDate = new SimpleDateFormat("HH:mm:ss");
				break;
			case FMT_DATE_YYYYMMDDHH_MM_SS:
				fmtDate = new SimpleDateFormat("yyyyMMddHH:mm:ss");
		}
		try
		{
			return fmtDate.parse(strDate);
		}
		catch (ParseException e)
		{
			return null;
		}
	}
	
	public static long getDaysBetween(Date begin, Date end)
	{
		Date beginOfStart = getBeginOfThisDay(begin);
		Date beginOfEnd = getBeginOfThisDay(end);
		long oneday = 24L * 60L * 60L * 1000L;
		return (beginOfEnd.getTime() - beginOfStart.getTime()) / oneday;
	}

	public static Timestamp getDefaultOrIntervalMinTimestamp(Timestamp dealTime, String intervalTime, String defaultTime)
	{
		Timestamp time;
		if (StringUtils.isEmpty(intervalTime))
		{
			time = DateUtil.getIntervalMinuteTimestamp(dealTime, Integer.parseInt(defaultTime));
		}
		else
		{
			time = DateUtil.getIntervalMinuteTimestamp(dealTime, Integer.parseInt(intervalTime));
		}
		return time;
	}
	
	/**
	 * 给KScheduleTask使用的处理输入日期通用方法
	 * 输出map中：
	 * startTime为起始时间Timestamp
	 * endTime为结束时间Timestamp
	 * @param dealTime
	 * @param startIntervalMin
	 * @param endIntervalMin
	 * @param defaultStartTime
	 * @param defaultEndTime
	 * @return
	 */
	public static Map<String, Timestamp> getStartTimeAndEndTimeForKScheduleTask(String dealTime,
			String startIntervalMin, String endIntervalMin, String defaultStartTime, String defaultEndTime)
	{
		Map<String, Timestamp> map = new HashMap<String, Timestamp>();
		//设置时间
		Timestamp dTime, sTime, eTime;
		if (StringUtils.isEmpty(dealTime))
		{
			dTime = DateUtil.getCurrentTimestamp();
		}
		else
		{
			dTime = DateUtil.formatToTimestamp(dealTime, DateUtil.FMT_DATE_YYYYMMDDHHMM_NEW);
		}

		sTime = getDefaultOrIntervalMinTimestamp(dTime, startIntervalMin, defaultStartTime);
		eTime = getDefaultOrIntervalMinTimestamp(dTime, endIntervalMin, defaultEndTime);

		if (sTime.after(eTime))
		{
			Timestamp temp = sTime;
			sTime = eTime;
			eTime = temp;
		}
		map.put("startTime", sTime);
		map.put("endTime", eTime);
		return map;
	}

}