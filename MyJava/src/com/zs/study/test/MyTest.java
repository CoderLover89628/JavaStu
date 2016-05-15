package com.zs.study.test;

public class MyTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "";
		for (int n = 5; n > 0; n /= 2) 
		{
			System.out.println("n is :" + n);
			s = (n % 2) + s;
		}
		
		System.out.println(s);
		
		System.out.println(lg(2));
	}

	public static int lg(int n) {
		int res = 0;
		if(n == 1) return res;
		for(int i = n; i > 1; i /= 2) {
			res += 1;
		}		
		return res;
		
	}
}
