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
	 * �ַ����Ƚ�
	 */
	public void strCompareTo() {
		String str = "Hello World";
		String anotherString = "hello world";
		Object objStr = str;

		System.out.println(str.compareTo(anotherString));
		System.out.println(str.compareToIgnoreCase(anotherString)); // ���Դ�Сд
		System.out.println(str.compareTo(objStr.toString()));
	}

	/**
	 * �����ַ������һ�γ��ֵ�λ��
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
	 * �ַ����滻
	 */
	public void strReplaceEmp() {
		String str = "Hello World";
		System.out.println(str.replace('H', 'W'));
		System.out.println(str.replaceFirst("He", "Wa"));
		System.out.println(str.replaceAll("He", "Ha"));
	}

	/**
	 * �ַ�����ת
	 */
	public void StrReverseExample() {
		String string = "abcdef";
		String reverse = new StringBuffer(string).reverse().toString();
		System.out.println("\nString before reverse:" + string);
		System.out.println("String after reverse:" + reverse);
	}

	/**
	 * �ַ�����ת �ݹ�
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
	 * �ַ����ָ�
	 */
	public void javaStringSplitEmp() {
		String str = "www-runoob-com";
		String[] temp;
		String delimeter = "-"; // ָ���ָ��ַ�
		temp = str.split(delimeter); // �ָ��ַ���
		// ��ͨ for ѭ��
		for (int i = 0; i < temp.length; i++) {
			System.out.println(temp[i]);
			System.out.println("");
		}

		System.out.println("------java for eachѭ������ķ���-----");
		String str1 = "www.runoob.com";
		String[] temp1;
		String delimeter1 = "\\."; // ָ���ָ��ַ��� . ����Ҫת��
		temp1 = str1.split(delimeter1); // �ָ��ַ���
		for (String x : temp1) {
			System.out.println(x);
			System.out.println("");
		}
	}

	/**
	 * �ַ����������ܱȽϲ���
	 */
	public void strComparePerformance() {
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < 50000; i++) {
			String s1 = "hello";
			String s2 = "hello";
		}
		long endTime = System.currentTimeMillis();
		System.out.println("ͨ�� String �ؼ��ʴ����ַ���" + " : " + (endTime - startTime)
				+ " ����");
		long startTime1 = System.currentTimeMillis();
		for (int i = 0; i < 50000; i++) {
			String s3 = new String("hello");
			String s4 = new String("hello");
		}
		long endTime1 = System.currentTimeMillis();
		System.out.println("ͨ�� String ���󴴽��ַ���" + " : "
				+ (endTime1 - startTime1) + " ����");
		
		long startTime2 = System.currentTimeMillis();
		for (int i = 0; i < 50000; i++) {
			String s5 = new String("hello");
			String s6 = new String("hello");
		}
		long endTime2 = System.currentTimeMillis();
		System.out.println("ͨ�� String '+'�����ַ���" + " : "
				+ (endTime2 - startTime2) + " ����");
		
		long startTime3 = System.currentTimeMillis();
	      for(int i=0;i<5000;i++){
	         String result = "This is"
	         + "testing the"
	         + "difference"+ "between"
	         + "String"+ "and"+ "StringBuffer";
	      }
	      long endTime3 = System.currentTimeMillis();
	      System.out.println("�ַ�������" 
	      + " - ʹ�� + ������ : " 
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
	      System.out.println("�ַ�������" 
	      + " - ʹ�� StringBuffer : "
	      + (endTime4 - startTime4)+ " ms");
	}
}
