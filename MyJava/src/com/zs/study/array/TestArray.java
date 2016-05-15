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
	 * 打印数组
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
	 * 排序
	 */
	public void sort() {
		int array[] = { 2, 5, -2, 6, -3, 8, 0, -7, -9, 4 };
		Arrays.sort(array);
		printArray("数组排序结果为", array);
		int index = Arrays.binarySearch(array, 2);
		System.out.println("元素 2  在第 " + index + " 个位置");
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
	 * 数组反转
	 */
	public void arrReverse() {
		ArrayList<String> arrayList = new ArrayList<String>();
		arrayList.add("A");
		arrayList.add("B");
		arrayList.add("C");
		arrayList.add("D");
		arrayList.add("E");
		System.out.println("反转前排序: " + arrayList);
		Collections.reverse(arrayList);
		System.out.println("反转后排序: " + arrayList);
	}

	/**
	 * 获得最大最小值
	 */
	public void getMaxAndMinValue() {
		Integer[] numbers = { 8, 2, 7, 1, 4, 9, 5 };
		int min = (int) Collections.min(Arrays.asList(numbers));
		int max = (int) Collections.max(Arrays.asList(numbers));
		System.out.println("最小值: " + min);
		System.out.println("最大值: " + max);
	}

	/**
	 * 数组合并
	 */
	public void arrCombine() {
		String a[] = { "A", "E", "I" };
		String b[] = { "O", "U", "E" };
		List<String> list = new ArrayList<String>(Arrays.asList(a));

		// 全部合并
		//list.addAll(Arrays.asList(b));
		
		// 排他合并
		list.removeAll(Arrays.asList(b));
		list.addAll(Arrays.asList(b));
		Object[] c = list.toArray();
		System.out.println(Arrays.toString(c));

	}

	/**
	 * 数组填充
	 */
	public void arrFill() {
		int array[] = new int[6];
		Arrays.fill(array, 100);// 将数组全部设置成100

		for (int i = 0, n = array.length; i < n; i++) {
			System.out.println(array[i]);
		}

		System.out.println();

		Arrays.fill(array, 3, 6, 50);// 将数组3-6位填充为50
		for (int i = 0, n = array.length; i < n; i++) {
			System.out.println(array[i]);
		}
	}

	/**
	 * 数组扩容
	 */
	public void arrExtend() {
		String[] names = new String[] { "A", "B", "C" };
		String[] extended = new String[5];
		extended[3] = "D";
		extended[4] = "E";
		
		/**
		 * names：待拷贝数组
		 * 1：	    待拷贝数组拷贝的起始位置
		 * extended:拷贝到数组
		 * 0：拷贝到数组的位置，
		 * names.length - 1拷贝的长度（即，拷贝元素的个数）
		 */
		System.arraycopy(names, 1, extended, 0, names.length - 1);
		for (String str : extended) {
			System.out.println(str);
		}
	}

}
