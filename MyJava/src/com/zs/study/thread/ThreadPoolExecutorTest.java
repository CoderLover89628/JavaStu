package com.zs.study.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Thread pool four kinds of Thread pool first:newCachedThreadPool second
 * http://cuisuqiang.iteye.com/blog/2019372
 * @author JZ
 * 
 */
public class ThreadPoolExecutorTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		newCachedThreadPoll();

		newFixedThreadPool();

		newScheduledThreadPool();

		newSingleThreadExecutor();
	}

	/**
	 * ����һ�����̻߳����̳߳أ���ֻ����Ψһ�Ĺ����߳���ִ������ ��֤����������ָ��˳��(FIFO, LIFO, ���ȼ�)ִ��
	 */
	private static void newSingleThreadExecutor() {
		ExecutorService singleThreadExecutor = Executors
				.newSingleThreadExecutor();
		// for (int i = 0; i < 10; i++) {
		// final int index = i;
		// singleThreadExecutor.execute(new Runnable() {
		// public void run() {
		// try {
		// System.out.println(index);
		// Thread.sleep(2000);
		// } catch (InterruptedException e) {
		// e.printStackTrace();
		// }
		// }
		// });
		// }

		for (int i = 0; i < 100; i++) {
			final int index = i;
			singleThreadExecutor.execute(new Runnable() {
				public void run() {
					try {
						while (true) {
							System.out.println(index);
							Thread.sleep(10 * 1000);
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			});
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * ����һ�������̳߳أ�֧�ֶ�ʱ������������ִ��
	 */
	private static void newScheduledThreadPool() {
		ScheduledExecutorService scheduledThreadPool = Executors
				.newScheduledThreadPool(5);
		scheduledThreadPool.schedule(new Runnable() {
			public void run() {
				System.out.println("delay 3 seconds");
			}
		}, 3, TimeUnit.SECONDS);// �ӳ�3��ִ��
	}

	/**
	 * ����һ�������̳߳أ��ɿ����߳���󲢷������������̻߳��ڶ����еȴ��� ��Ϊ�̳߳ش�СΪ3��ÿ���������index��sleep
	 * 2�룬����ÿ�����ӡ3�����֡� �����̳߳صĴ�С��ø���ϵͳ��Դ�������á�
	 * ��Runtime.getRuntime().availableProcessors()
	 */
	private static void newFixedThreadPool() {
		ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
		for (int i = 0; i < 10; i++) {
			final int index = i;
			fixedThreadPool.execute(new Runnable() {
				public void run() {
					try {
						System.out.println(index);
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			});
		}
	}

	/**
	 * ����һ���ɻ����̳߳أ�����̳߳س��ȳ���������Ҫ���������տ����̣߳����޿ɻ��գ����½��̡߳�
	 * �̳߳�Ϊ���޴󣬵�ִ�еڶ�������ʱ��һ�������Ѿ���ɣ��Ḵ��ִ�е�һ��������̣߳�������ÿ���½��߳�
	 */
	private static void newCachedThreadPoll() {

		ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
		for (int i = 0; i < 10; i++) {
			final int index = i;
			try {
				Thread.sleep(index * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			cachedThreadPool.execute(new Runnable() {
				public void run() {
					System.out.println(index);
				}
			});
		}
	}

}
