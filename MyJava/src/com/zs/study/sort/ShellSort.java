package com.zs.study.sort;

/**
 * ϣ������ 
 * 
 * ����˼�룺
 * �㷨�Ƚ�Ҫ�����һ������ĳ������d(n/2,nΪҪ�������ĸ���)�ֳ������飬
 * ÿ���м�¼���±����d.��ÿ����ȫ��Ԫ�ؽ���ֱ�Ӳ�������
 * Ȼ������һ����С������(d/2)�������з��飬��ÿ�����ٽ���ֱ�Ӳ�������
 * ����������1ʱ������ֱ�Ӳ��������������ɡ�
 * 
 * @author JZ
 * 
 */
public class ShellSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a[] = { 1, 54, 6, 3, 78, 34, 12, 45, 56, 100 };
		System.out.println("����ǰ��");
		
		for (int i = 0; i < a.length; i++)
			System.out.print(a[i] + " ");
		System.out.println();
		System.out.println("�����");
		
		new ShellSort().shellSort(a);

	}
	
	/**
	 * ϣ������
	 * 
	 * @param args
	 * @return
	 */
	public int[] shellSort(int[] args) {
		
		double d1 = args.length;
		int temp = 0;
		while (true) 
		{
			d1 = Math.ceil(d1 / 2);
			int d = (int) d1;
			for (int x = 0; x < d; x++) 
			{
				for (int i = x + d; i < args.length; i += d) 
				{
					int j = i - d;
					temp = args[i];
					for (; j >= 0 && temp < args[j]; j -= d) 
					{
						args[j + d] = args[j];
					}
					args[j + d] = temp;
				}
			}
			if (d == 1)
				break;
		}
		for (int i = 0; i < args.length; i++)
			System.out.print(args[i] + " ");
		return args;
		
	} 

}
