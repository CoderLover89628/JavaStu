package com.zs.forInterView.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestMap {

	volatile static int count = 0;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		ThreadLocal<String> sss = new ThreadLocal<String>(){
			@Override
			protected String initialValue() {
				return "";
			}
		};
		//Thread.currentThread().threadLocals.toString();
		Map<String, String> sMap = new HashMap<String, String>();
		Lock lock = new ReentrantLock();

		
		Map<String, String> sMa = new ConcurrentHashMap<String, String>();
		sMa.put("", "");
		
		Iterator a = sMa.entrySet().iterator();
		while(a.hasNext()) {
			a.next();
		}
		AtomicInteger ati = new AtomicInteger();
		ati.set(10);
		
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					count++;
					 System.out.println(Thread.currentThread() + "first i : "
					 + i + ",count is:" + count);
				}
				System.out.println("current count is :" + count);
			}
		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					count++;
					 System.out.println(Thread.currentThread() + "second i : "
					 + i + ",count is:" + count);
				}
				System.out.println("second Thread,current count is :" + count);
			}
		});

		t1.setName("first Thread");
		t2.setName("second Thread");
		t1.start();
		t2.start();
		System.out.println(Thread.currentThread() + "AAAAAAAAAAAAA count is : " + count);
		for (int i = 0; i < 100; i++) {
			System.out.println("count is : " + count);
		}
	}

}
