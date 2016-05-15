package com.zs.study.sort;

/**
 * 直接插入排序
 * 
 * 基本思想： 
 * 在要排序的一组数中，假设前面(n-1)[n>=2] 个数已经是排 好顺序的，
 * 现在要把第n个数插到前面的有序数中，使得这n个数
 * 也是排好顺序的。如此反复循环，直到全部排好顺序。
 * 
 * @author JZ
 * 
 */
public class InsertSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int[] a = { 49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 5, 4, 62,
				99, 98, 54, 56, 17, 18, 23, 34, 15, 35, 25, 53, 51 };
		System.out.println("排序前：");
		for (int i = 0; i < a.length; i++) 
		{
			System.out.print(a[i] + " ");
		}
			
		
		new InsertSort().insertSort(a); 
	}
	
	/**
	 * 排序
	 * 
	 * @param args
	 * @return
	 */
	public int[] insertSort(int[] args) {
		int temp = 0;
		for (int i = 1; i < args.length; i++) {
			int j = i - 1;
			temp = args[i];
			for (; j >= 0 && temp < args[j]; j--) {
				args[j + 1] = args[j]; // 将大于temp的值整体后移一个单位
			}
			args[j + 1] = temp;
		}
		System.out.println();
		System.out.println("排序后：");
		for (int i = 0; i < args.length; i++)
			System.out.print(args[i] + " ");
		return args;
		
	}

}
