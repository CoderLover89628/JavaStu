package com.zs.study.file;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Set<Integer> set = new HashSet<Integer>();
		for(int i = 0; i < 50000; i++) {
			
		}
		set.add(10);
		set.add(11);
		set.add(14);
		set.add(10);
		Iterator<Integer> it = set.iterator();
		while (it.hasNext())
		{
		    System.out.print(it.next() + " ");
		}
		
		System.out.println();
		List<Integer> list = new ArrayList<Integer>(set);
		for (int i = 0; i < list.size(); i++)
		{
		    System.out.print(list.get(i) + " ");
		}
	}

}
