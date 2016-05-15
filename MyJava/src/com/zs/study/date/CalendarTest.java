package com.zs.study.date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class CalendarTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println(new CalendarTest().getTime());
		new CalendarTest().timeMilltoString();
	}

	/**
	 * 时间使用时区
	 * 
	 * @return
	 */
	private String getTime() {

		Calendar cd = Calendar.getInstance();

		int day = cd.get(Calendar.DATE);
		int month = cd.get(Calendar.MONTH) + 1;
		int year = cd.get(Calendar.YEAR);
		int dow = cd.get(Calendar.DAY_OF_WEEK);
		int dom = cd.get(Calendar.DAY_OF_MONTH);
		int doy = cd.get(Calendar.DAY_OF_YEAR);

		System.out.println("当期时间: " + cd.getTime());
		System.out.println("日期: " + day);
		System.out.println("月份: " + month);
		System.out.println("年份: " + year);
		System.out.println("一周的第几天: " + dow); // 星期日为一周的第一天输出为 1，星期一输出为 2，以此类推
		System.out.println("一月中的第几天: " + dom);
		System.out.println("一年的第几天: " + doy);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:S",
				Locale.CHINA);
		sdf.setTimeZone(TimeZone.getTimeZone("GMT+8")); // 设置时区为GMT
		return sdf.format(cd.getTime());
	}

	/**
	 * 时间戳转换成时间
	 */
	public void timeMilltoString() {
		Long timeStamp = System.currentTimeMillis(); // 获取当前时间戳
		System.out.println("当前时间戳为：" + timeStamp);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String sd = sdf.format(new Date(Long.parseLong(String
				.valueOf(timeStamp)))); // 时间戳转换成时间
		System.out.println(sd);
	}
}
