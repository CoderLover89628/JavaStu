package com.zs.study.sort;

/**
 * ��ѡ������
 * 
 * ����˼�룺
 *  ��Ҫ�����һ�����У�ѡ����С��һ�������һ��λ�õ���������
 * Ȼ����ʣ�µ�������������С����ڶ���λ�õ������������ѭ���������ڶ����������һ�����Ƚ�Ϊֹ��
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
		System.out.println("����ǰ��");

		for (int i = 0; i < a.length; i++)
			System.out.print(a[i] + " ");
		
		System.out.println();
		System.out.println("�����");
		
		new SelectSort().selectSort(a);
	}

	/**
	 * ��ѡ������
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
