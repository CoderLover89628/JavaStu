package com.zs.study.search;

/**
 * 二分查找
 * 
 * @author lidong
 *
 */
public class BinarySearch {

	public static int rank(int key, int[] a) 
	{
		//数组必须是有序的
		int low = 0;
		int high = a.length - 1;
		while(low <= high) 
		{
			int mid = low + (high - low)/2;
			if(key < a[mid]) high = mid - 1;
			else if(key > a[mid]) low = mid + 1;
			else return mid;
		}
		return -1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = new int[]{10, 11, 12, 16, 18, 23, 29, 33, 48, 54, 57, 68, 77, 84, 98};
		System.out.println("23 position is: " + rank(23, arr));
		
	}

}
