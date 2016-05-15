package com.zs.study.sort;

/**
 * 简单选择排序
 * 
 * 基本思想：
 *  在要排序的一组数中，选出最小的一个数与第一个位置的数交换；
 * 然后在剩下的数当中再找最小的与第二个位置的数交换，如此循环到倒数第二个数和最后一个数比较为止。
 * 
 * @author JZ
 * 
 */
public class SelectSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int a[] = { 1, 54, 6, 3, 78, 34, 12, 45 };
		System.out.println("排序前：");

		for (int i = 0; i < a.length; i++)
			System.out.print(a[i] + " ");
		
		System.out.println();
		System.out.println("排序后：");
		
		new SelectSort().selectSort(a);
	}

	/**
	 * 简单选择排序
	 * 
	 * @param args
	 * @return
	 */
	public int[] selectSort(int[] args) {

		int position = 0;
		for (int i = 0; i < args.length; i++) {

			int j = i + 1;
			position = i;
			int temp = args[i];
			for (; j < args.length; j++) {
				if (args[j] < temp) {
					temp = args[j];
					position = j;
				}
			}
			args[position] = args[i];
			args[i] = temp;
		}
		for (int i = 0; i < args.length; i++)
			System.out.print(args[i] + " ");
		return args;
	}

}
