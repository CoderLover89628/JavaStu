package com.zs.study.string;

public class TestString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TestString ts = new TestString();
//		ts.strCompareTo();
//		ts.strLastIndexof();
//		ts.strReplaceEmp();
//		ts.StrReverseExample();
//		String msg = "abcdef";
//		ts.strReverse(msg);
//		ts.javaStringSplitEmp();
		ts.strComparePerformance();

	}

	/**
	 * 字符串比较
	 */
	public void strCompareTo() {
		String str = "Hello World";
		String anotherString = "hello world";
		Object objStr = str;

		System.out.println(str.compareTo(anotherString));
		System.out.println(str.compareToIgnoreCase(anotherString)); // 忽略大小写
		System.out.println(str.compareTo(objStr.toString()));
	}

	/**
	 * 查找字符串最后一次出现的位置
	 */
	public void strLastIndexof() {
		String strOrig = "Hello world ,Hello Reader";
		int lastIndex = strOrig.lastIndexOf("Hello");
		if (lastIndex == -1) {
			System.out.println("Hello not found");
		} else {
			System.out.println("Last occurrence of Hello is at index "
					+ lastIndex);
		}
	}

	/**
	 * 字符串替换
	 */
	public void strReplaceEmp() {
		String str = "Hello World";
		System.out.println(str.replace('H', 'W'));
		System.out.println(str.replaceFirst("He", "Wa"));
		System.out.println(str.replaceAll("He", "Ha"));
	}

	/**
	 * 字符串反转
	 */
	public void StrReverseExample() {
		String string = "abcdef";
		String reverse = new StringBuffer(string).reverse().toString();
		System.out.println("\nString before reverse:" + string);
		System.out.println("String after reverse:" + reverse);
	}

	/**
	 * 字符串反转 递归
	 * 
	 * @param str
	 * @return
	 */
	public String strReverse(String str) {
		if (str == null || str.length() == 1)
			return str;
		return strReverse(str.substring(1)) + str.charAt(0);
	}

	/**
	 * 字符串分割
	 */
	public void javaStringSplitEmp() {
		String str = "www-runoob-com";
		String[] temp;
		String delimeter = "-"; // 指定分割字符
		temp = str.split(delimeter); // 分割字符串
		// 普通 for 循环
		for (int i = 0; i < temp.length; i++) {
			System.out.println(temp[i]);
			System.out.println("");
		}

		System.out.println("------java for each循环输出的方法-----");
		String str1 = "www.runoob.com";
		String[] temp1;
		String delimeter1 = "\\."; // 指定分割字符， . 号需要转义
		temp1 = str1.split(delimeter1); // 分割字符串
		for (String x : temp1) {
			System.out.println(x);
			System.out.println("");
		}
	}

	/**
	 * 字符串创建性能比较测试
	 */
	public void strComparePerformance() {
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < 50000; i++) {
			String s1 = "hello";
			String s2 = "hello";
		}
		long endTime = System.currentTimeMillis();
		System.out.println("通过 String 关键词创建字符串" + " : " + (endTime - startTime)
				+ " 毫秒");
		long startTime1 = System.currentTimeMillis();
		for (int i = 0; i < 50000; i++) {
			String s3 = new String("hello");
			String s4 = new String("hello");
		}
		long endTime1 = System.currentTimeMillis();
		System.out.println("通过 String 对象创建字符串" + " : "
				+ (endTime1 - startTime1) + " 毫秒");
		
		long startTime2 = System.currentTimeMillis();
		for (int i = 0; i < 50000; i++) {
			String s5 = new String("hello");
			String s6 = new String("hello");
		}
		long endTime2 = System.currentTimeMillis();
		System.out.println("通过 String '+'创建字符串" + " : "
				+ (endTime2 - startTime2) + " 毫秒");
		
		long startTime3 = System.currentTimeMillis();
	      for(int i=0;i<5000;i++){
	         String result = "This is"
	         + "testing the"
	         + "difference"+ "between"
	         + "String"+ "and"+ "StringBuffer";
	      }
	      long endTime3 = System.currentTimeMillis();
	      System.out.println("字符串连接" 
	      + " - 使用 + 操作符 : " 
	      + (endTime3 - startTime3)+ " ms");
	      long startTime4 = System.currentTimeMillis();
	      for(int i=0;i<5000;i++){
	         StringBuffer result = new StringBuffer();
	         result.append("This is");
	         result.append("testing the");
	         result.append("difference");
	         result.append("between");
	         result.append("String");
	         result.append("and");
	         result.append("StringBuffer");
	      }
	      long endTime4 = System.currentTimeMillis();
	      System.out.println("字符串连接" 
	      + " - 使用 StringBuffer : "
	      + (endTime4 - startTime4)+ " ms");
	}
}
