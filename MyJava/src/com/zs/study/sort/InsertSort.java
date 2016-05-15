package com.zs.study.sort;

/**
 * ֱ�Ӳ�������
 * 
 * ����˼�룺 
 * ��Ҫ�����һ�����У�����ǰ��(n-1)[n>=2] �����Ѿ����� ��˳��ģ�
 * ����Ҫ�ѵ�n�����嵽ǰ����������У�ʹ����n����
 * Ҳ���ź�˳��ġ���˷���ѭ����ֱ��ȫ���ź�˳��
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
		System.out.println("����ǰ��");
		for (int i = 0; i < a.length; i++) 
		{
			System.out.print(a[i] + " ");
		}
			
		
		new InsertSort().insertSort(a); 
	}
	
	/**
	 * ����
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
				args[j + 1] = args[j]; // ������temp��ֵ�������һ����λ
			}
			args[j + 1] = temp;
		}
		System.out.println();
		System.out.println("�����");
		for (int i = 0; i < args.length; i++)
			System.out.print(args[i] + " ");
		return args;
		
	}

}
