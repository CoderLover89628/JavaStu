package com.zs.study.collection;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String url = "http://127.0.0.1:8080/AirportService/admin/businessNorm?action=getBusinessNormInfo&uname=anno&AirportCode=CAN";
		System.out.println("admin's position is:" + url.lastIndexOf('/'));
		int pos = url.lastIndexOf('/') + 1;
		System.out.println("new url's position is:" + url.substring(pos));
		
		SimpleDateFormat myFmt=new SimpleDateFormat("yyyyMMddHHmmssS");
		System.out.println(myFmt.format(new Date()));
	}

}
