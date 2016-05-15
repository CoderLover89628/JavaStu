package com.zs.study.reflection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int a = getNa();
		System.out.println(a);
		
		Map<String,Integer> dd = new HashMap<String, Integer>(); 
		List<String> list = new ArrayList<String>();
		Set<String> set = new HashSet<String>();
		String msg = "-123456";
		int radix = 10;
		int result = parseInt(msg,radix);
		System.out.println("result is :" + result);
		
		String s = "hi,hello world!";
		System.out.println(getResult(s));
		
		
	}

	public static String getResult(String s) {
		if(s == null || s.length() == 0)
			return "";
		return getResult(s.substring(1)) + s.charAt(0);
		
	}
	private static int getNa() {
		String s = "12345";
		return Integer.parseInt(s);
	}

	public static int parseInt(String s, int radix)
			throws NumberFormatException {

		if (s == null) {
			throw new NumberFormatException("null");
		}

		if (radix < Character.MIN_RADIX) {
			throw new NumberFormatException("radix " + radix
					+ " less than Character.MIN_RADIX");
		}

		if (radix > Character.MAX_RADIX) {
			throw new NumberFormatException("radix " + radix
					+ " greater than Character.MAX_RADIX");
		}

		int result = 0;
		boolean negative = false;
		int i = 0, len = s.length();
		int limit = -Integer.MAX_VALUE;
		int multmin;
		int digit;

		if (len > 0) {
			char firstChar = s.charAt(0);
			if (firstChar < '0') { // Possible leading "+" or "-"
				if (firstChar == '-') {
					negative = true;
					limit = Integer.MIN_VALUE;
				} else if (firstChar != '+')
					throw new NumberFormatException("For input string: \"" + s + "\"");

				if (len == 1) // Cannot have lone "+" or "-"
					throw new NumberFormatException("For input string: \"" + s + "\"");
				i++;
			}
			multmin = limit / radix;
			while (i < len) {
				// Accumulating negatively avoids surprises near MAX_VALUE
				digit = Character.digit(s.charAt(i++), radix);
				if (digit < 0) {
					throw new NumberFormatException("For input string: \"" + s + "\"");
				}
				if (result < multmin) {
					throw new NumberFormatException("For input string: \"" + s + "\"");
				}
				result *= radix;
				if (result < limit + digit) {
					throw new NumberFormatException("For input string: \"" + s + "\"");
				}
				result -= digit;
			}
		} else {
			throw new NumberFormatException("For input string: \"" + s + "\"");
		}
		return negative ? result : -result;
	}

}
