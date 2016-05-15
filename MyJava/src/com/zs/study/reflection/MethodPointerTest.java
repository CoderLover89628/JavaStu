package com.zs.study.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodPointerTest {

	/**
	 * @param args
	 * 
	 * 
	 */
	public static void main(String[] args) throws Exception {

		// ���ͬ��ǰ��һ����ָ���ķ���
		Method square = MethodPointerTest.class.getMethod("square", double.class);
		Method sqrt = Math.class.getMethod("sqrt", double.class);
		
		// ��ӡͨ���Ʊ�
		printTable(1, 10, 10, square);
		printTable(1, 10, 10, sqrt);
	}

	/**
	 * ����
	 * 
	 * @param x
	 * @return
	 */
	public static double square(double x) {
		return x * x;
		
	}
	
	public static void printTable(int from, int to, int n, Method f) {
		
		System.out.println(f);
		
		double dx = (to - from)/(n - 1);
		
		for(double x = from; x <= to; x += dx) {
			try {
				double y = (Double) f.invoke(null, x);
				System.out.printf("%10.4f | %10.4f%n", x, y);
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		}
	}

}
