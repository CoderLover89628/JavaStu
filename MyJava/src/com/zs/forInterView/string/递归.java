package com.zs.forInterView.string;

public class ตÝน้ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int a = getResult(2);
		System.out.println(a);
	}

	public static int getResult(int n) {
		if(n <= 0) return 0;
		if(n % 2 == 0) return -n;
		return getResult(n-1) + n;
	}
}
