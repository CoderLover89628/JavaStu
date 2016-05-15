package com.zs.study.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class TestHello implements TestInterface {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(url);

		//HashMap是根据散列值分段存储的，同步Map在同步的时候锁住了所有的段，而ConcurrentHashMap加锁的时候根据散列值锁住了散列值锁对应的那段，因此提高了并发性能。
		//ConcurrentHashMap也增加了对常用复合操作的支持，比如"若没有则添加"：putIfAbsent()，替换：replace()。这2个操作都是原子操作。
		Map<Object, Object> s = new ConcurrentHashMap<Object, Object>(new HashMap<Object, Object>());
	}

}
