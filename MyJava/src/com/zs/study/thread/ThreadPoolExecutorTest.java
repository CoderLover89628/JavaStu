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
	 * 创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务， 保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行
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
	 * 创建一个定长线程池，支持定时及周期性任务执行
	 */
	private static void newScheduledThreadPool() {
		ScheduledExecutorService scheduledThreadPool = Executors
				.newScheduledThreadPool(5);
		scheduledThreadPool.schedule(new Runnable() {
			public void run() {
				System.out.println("delay 3 seconds");
			}
		}, 3, TimeUnit.SECONDS);// 延迟3秒执行
	}

	/**
	 * 创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待。 因为线程池大小为3，每个任务输出index后sleep
	 * 2秒，所以每两秒打印3个数字。 定长线程池的大小最好根据系统资源进行设置。
	 * 如Runtime.getRuntime().availableProcessors()
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
	 * 创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程。
	 * 线程池为无限大，当执行第二个任务时第一个任务已经完成，会复用执行第一个任务的线程，而不用每次新建线程
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
