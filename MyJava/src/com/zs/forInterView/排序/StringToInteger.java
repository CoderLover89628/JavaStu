package com.zs.forInterView.ÅÅÐò;

public class StringToInteger {

	public static void main(String[] args) {

		int a = getRes("-12345");
		System.out.println(a);
	}

	public static int getRes(String msg) {
		if(msg == null)
			throw new NumberFormatException();
		int count = 0;
		int j = 1;
		int len = msg.length();
		if(len > 0) {
			char firstChar = msg.charAt(0);
			char[] res = msg.toCharArray();
			if(firstChar < '0') {
				if(firstChar == '-'){
					if(len == 1)
						throw new NumberFormatException(msg);
					for(int i = res.length - 1; i >= 1; i--){
						System.out.println(res[i]);
						int a = (int)res[i];
						count += a * j;
						j *= 10;
					}
				}else if(firstChar != '+'){
					throw new NumberFormatException(msg);
				}
				
				if(len == 1)
					throw new NumberFormatException(msg);
			}
			
		} else {
			throw new NumberFormatException();
		}
		
		return -count;
	}
}
