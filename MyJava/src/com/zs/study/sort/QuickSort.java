package com.zs.study.sort;

import java.util.Arrays;

/**
 * 快速排序
 * 
 * 基本思想： 
 * 选择一个基准元素,通常选择第一个元素或者最后一个元素, 
 * 通过一趟扫描，将待排序列分成两部分,一部分比基准元素小,一部分大于等于基准元素,
 * 此时基准元素在其排好序后的正确位置,然后再用同样的方法递归地排序划分的两部分。
 * 
 * @author JZ
 * 
 */
public class QuickSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int[] a = { 49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 5, 4, 62,
				99, 98, 54, 56, 17, 18, 23, 34, 15, 35, 25, 53, 51 };
		
		System.out.println("排序前：");
		for (int i = 0; i < a.length; i++)
			System.out.print(a[i] + " ");
		
		System.out.println();
		System.out.println("排序后：");
		
		new QuickSort().quickSort(a);
	}

	/**
	 * 快速排序
	 * 
	 * @param a
	 * @return
	 */
	public int[] quickSort(int[] a) {
		if (a.length > 0) { // 查看数组是否为空
			_quickSort(a, 0, a.length - 1);
		}
		
		for (int i = 0; i < a.length; i++)
			System.out.print(a[i] + " ");
		return a;
	}
	
	public void _quickSort(int[] list, int low, int high) {
		if (low < high) {
			int middle = getMiddle(list, low, high); // 将list数组进行一分为二
			_quickSort(list, low, middle - 1); // 对低字表进行递归排序
			_quickSort(list, middle + 1, high); // 对高字表进行递归排序
		}
	}
	
	public int getMiddle(int[] list, int low, int high) {
		int tmp = list[low]; // 数组的第一个作为中轴
		while (low < high) {
			while (low < high && list[high] >= tmp) {

				high--;
			}
			list[low] = list[high]; // 比中轴小的记录移到低端
			//此处high的位置为上面high--后的位置；list[low]的值为上述交换后的值
			while (low < high && list[low] <= tmp) {
				low++;
			}
			list[high] = list[low]; // 比中轴大的记录移到高端
			System.out.println(Arrays.toString(list));
		}
		list[low] = tmp; // 中轴记录到尾
		return low; // 返回中轴的位置
	}
}
