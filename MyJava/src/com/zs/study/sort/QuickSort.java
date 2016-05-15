package com.zs.study.sort;

import java.util.Arrays;

/**
 * ��������
 * 
 * ����˼�룺 
 * ѡ��һ����׼Ԫ��,ͨ��ѡ���һ��Ԫ�ػ������һ��Ԫ��, 
 * ͨ��һ��ɨ�裬���������зֳ�������,һ���ֱȻ�׼Ԫ��С,һ���ִ��ڵ��ڻ�׼Ԫ��,
 * ��ʱ��׼Ԫ�������ź�������ȷλ��,Ȼ������ͬ���ķ����ݹ�����򻮷ֵ������֡�
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
		
		System.out.println("����ǰ��");
		for (int i = 0; i < a.length; i++)
			System.out.print(a[i] + " ");
		
		System.out.println();
		System.out.println("�����");
		
		new QuickSort().quickSort(a);
	}

	/**
	 * ��������
	 * 
	 * @param a
	 * @return
	 */
	public int[] quickSort(int[] a) {
		if (a.length > 0) { // �鿴�����Ƿ�Ϊ��
			_quickSort(a, 0, a.length - 1);
		}
		
		for (int i = 0; i < a.length; i++)
			System.out.print(a[i] + " ");
		return a;
	}
	
	public void _quickSort(int[] list, int low, int high) {
		if (low < high) {
			int middle = getMiddle(list, low, high); // ��list�������һ��Ϊ��
			_quickSort(list, low, middle - 1); // �Ե��ֱ���еݹ�����
			_quickSort(list, middle + 1, high); // �Ը��ֱ���еݹ�����
		}
	}
	
	public int getMiddle(int[] list, int low, int high) {
		int tmp = list[low]; // ����ĵ�һ����Ϊ����
		while (low < high) {
			while (low < high && list[high] >= tmp) {

				high--;
			}
			list[low] = list[high]; // ������С�ļ�¼�Ƶ��Ͷ�
			//�˴�high��λ��Ϊ����high--���λ�ã�list[low]��ֵΪ�����������ֵ
			while (low < high && list[low] <= tmp) {
				low++;
			}
			list[high] = list[low]; // �������ļ�¼�Ƶ��߶�
			System.out.println(Arrays.toString(list));
		}
		list[low] = tmp; // �����¼��β
		return low; // ���������λ��
	}
}
