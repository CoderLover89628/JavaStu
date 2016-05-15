package com.zs.forInterView.排序;

import java.math.BigDecimal;

public class TestFibonacci {

	private static BigDecimal ZREO = new BigDecimal(0);
	private static BigDecimal ONE = new BigDecimal(1);
	private static BigDecimal TWO = new BigDecimal(2);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// long time1 = System.currentTimeMillis();
		// System.out.println(getFibonacci(2000));
		// long time2 = System.currentTimeMillis();
		// System.out.println(time2 - time1);

		// System.out.println("++++++++++++++++++++++++");
		// long time3 = System.currentTimeMillis();
		// System.out.println(getFibonacciSec(20));
		// long time4 = System.currentTimeMillis();
		// System.out.println(time4 - time3);

		String[] word = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
				"K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
				"W", "X", "Y", "Z" };

		System.out.println(word.length);
		String msg = "Z";
		if (msg.length() == 1) {
			for (int i = 0; i < word.length; i++) {
				if (msg.equalsIgnoreCase(word[i])) {
					int count = i + 1;
					System.out.println(msg + "is Num: " + count + "列");
				}
			}
		} else if(msg.length() > 1) {
			char[] cha = msg.toCharArray();
			
		} else {
			System.out.println("输入文字不正确！");
		}

		
	}

	private static BigDecimal getFibonacci(int n) {
		if (n == 1)
			return ONE;
		if (n == 2)
			return TWO;
		BigDecimal one = ONE;
		BigDecimal two = TWO;
		BigDecimal fibn = ZREO;

		for (int i = 3; i <= n; i++) {
			fibn = one.add(two);
			one = two;
			two = fibn;
		}
		return fibn;
	}

	private static int getFibonacciSec(int n) {
		if (n == 1)
			return 1;
		if (n == 2)
			return 2;
		return getFibonacciSec(n - 1) + getFibonacciSec(n - 2);

	}

	private static int NumOf1(int n) {
		int count = 0;
		return count;
		
	}
}
