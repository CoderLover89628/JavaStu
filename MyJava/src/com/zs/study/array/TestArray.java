package com.zs.study.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TestArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TestArray ta = new TestArray();
		ta.sort();
		ta.arrReverse();
		ta.getMaxAndMinValue();
		ta.arrCombine();
		ta.arrFill();
		ta.arrExtend();

	}

	/**
	 * ��ӡ����
	 * 
	 * @param message
	 * @param array
	 */
	public void printArray(String message, int array[]) {
		System.out.println(message + ": [length: " + array.length + "]");
		for (int i = 0; i < array.length; i++) {
			if (i != 0) {
				System.out.print(", ");
			}
			System.out.print(array[i]);
		}
		System.out.println();
	}

	/**
	 * ����
	 */
	public void sort() {
		int array[] = { 2, 5, -2, 6, -3, 8, 0, -7, -9, 4 };
		Arrays.sort(array);
		printArray("����������Ϊ", array);
		int index = Arrays.binarySearch(array, 2);
		System.out.println("Ԫ�� 2  �ڵ� " + index + " ��λ��");
	}

	public int[] insertArr(int original[], int element, int index) {
		int length = original.length;
		int destination[] = new int[length + 1];
		System.arraycopy(original, 0, destination, 0, index);
		destination[index] = element;
		System.arraycopy(original, index, destination, index + 1, length
				- index);
		return destination;
	}

	/**
	 * ���鷴ת
	 */
	public void arrReverse() {
		ArrayList<String> arrayList = new ArrayList<String>();
		arrayList.add("A");
		arrayList.add("B");
		arrayList.add("C");
		arrayList.add("D");
		arrayList.add("E");
		System.out.println("��תǰ����: " + arrayList);
		Collections.reverse(arrayList);
		System.out.println("��ת������: " + arrayList);
	}

	/**
	 * ��������Сֵ
	 */
	public void getMaxAndMinValue() {
		Integer[] numbers = { 8, 2, 7, 1, 4, 9, 5 };
		int min = (int) Collections.min(Arrays.asList(numbers));
		int max = (int) Collections.max(Arrays.asList(numbers));
		System.out.println("��Сֵ: " + min);
		System.out.println("���ֵ: " + max);
	}

	/**
	 * ����ϲ�
	 */
	public void arrCombine() {
		String a[] = { "A", "E", "I" };
		String b[] = { "O", "U", "E" };
		List<String> list = new ArrayList<String>(Arrays.asList(a));

		// ȫ���ϲ�
		//list.addAll(Arrays.asList(b));
		
		// �����ϲ�
		list.removeAll(Arrays.asList(b));
		list.addAll(Arrays.asList(b));
		Object[] c = list.toArray();
		System.out.println(Arrays.toString(c));

	}

	/**
	 * �������
	 */
	public void arrFill() {
		int array[] = new int[6];
		Arrays.fill(array, 100);// ������ȫ�����ó�100

		for (int i = 0, n = array.length; i < n; i++) {
			System.out.println(array[i]);
		}

		System.out.println();

		Arrays.fill(array, 3, 6, 50);// ������3-6λ���Ϊ50
		for (int i = 0, n = array.length; i < n; i++) {
			System.out.println(array[i]);
		}
	}

	/**
	 * ��������
	 */
	public void arrExtend() {
		String[] names = new String[] { "A", "B", "C" };
		String[] extended = new String[5];
		extended[3] = "D";
		extended[4] = "E";
		
		/**
		 * names������������
		 * 1��	    ���������鿽������ʼλ��
		 * extended:����������
		 * 0�������������λ�ã�
		 * names.length - 1�����ĳ��ȣ���������Ԫ�صĸ�����
		 */
		System.arraycopy(names, 1, extended, 0, names.length - 1);
		for (String str : extended) {
			System.out.println(str);
		}
	}

}
