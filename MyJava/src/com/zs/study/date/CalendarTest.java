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
	 * ʱ��ʹ��ʱ��
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

		System.out.println("����ʱ��: " + cd.getTime());
		System.out.println("����: " + day);
		System.out.println("�·�: " + month);
		System.out.println("���: " + year);
		System.out.println("һ�ܵĵڼ���: " + dow); // ������Ϊһ�ܵĵ�һ�����Ϊ 1������һ���Ϊ 2���Դ�����
		System.out.println("һ���еĵڼ���: " + dom);
		System.out.println("һ��ĵڼ���: " + doy);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:S",
				Locale.CHINA);
		sdf.setTimeZone(TimeZone.getTimeZone("GMT+8")); // ����ʱ��ΪGMT
		return sdf.format(cd.getTime());
	}

	/**
	 * ʱ���ת����ʱ��
	 */
	public void timeMilltoString() {
		Long timeStamp = System.currentTimeMillis(); // ��ȡ��ǰʱ���
		System.out.println("��ǰʱ���Ϊ��" + timeStamp);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String sd = sdf.format(new Date(Long.parseLong(String
				.valueOf(timeStamp)))); // ʱ���ת����ʱ��
		System.out.println(sd);
	}
}
