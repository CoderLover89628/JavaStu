package com.zs.forInterView.����;

import java.util.Random;

public class TestSort {

	public static void main(String[] args) {

		int[] ages = new int[100];
		for(int i = 0; i < 100; i++) {
			Random rd = new Random();
			ages[i] = rd.nextInt(99);
		}
		
		int length = ages.length;
		
		if(ages == null || length <= 0) {
			System.out.println("��ǰ����Ϊ�գ���");
			return ;
		}
		
		System.out.println("��ǰ����ĳ���Ϊ��" + length);
		
		int oldestAge = 99;
		int[] timesOfAge = new int[length];
		
		for(int i = 0; i<= oldestAge; ++i) {
			timesOfAge[i] = 0;
		}
		
		for(int i = 0; i < length; ++i) {
			System.out.println(ages[i]);
			int age = ages[i];
			if(age < 0 || age > oldestAge) {
				System.out.println("�������󣡣�");
			}
			++timesOfAge[i];
		}
		
		for(int j = 0; j < timesOfAge.length; ++j) {
			System.out.println(timesOfAge[j]);
		}
		int index = 0;
		
		for(int i = 0; i <= oldestAge; ++i) {
			for(int j = 0; j < timesOfAge[i]; ++j) {
				ages[index] = i;
				++index;
			}
		}
		
		
	}

}
