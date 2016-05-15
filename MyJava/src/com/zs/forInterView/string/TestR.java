package com.zs.forInterView.string;

public class TestR {

	static int[] arr = new int[10];
	public static void main(String[] args) {

		int a = getResult(1000);
		System.out.println(a);
		
		int b = getRes(2);
		System.out.println(b);
		
		System.out.println(arr[1]);
		
	}

	private static int getResult(int n) {
		if(n <= 0) 
			return 0;
		if(n == 1)
			return 1;
		int one = 1;
		int two = 0;
		int res = 0;
		for(int i = 2; i <= n; ++i) {
			res = one + two;
			two = one;
			one = res;
		}
		return res;
	}
	
	private static int getRes(int n) {
		if(n <= 0)
			return 0;
		int add = 0;
		int sub = 0;
		for(int i = 1; i <= n; i++) {
			
			if(i % 2 == 0) {
				sub += i;
			} else {
				add += i;
			}
		}
		return add - sub;
		
	}
	
}
