package com.zs.study.thread;

public class myThread implements Runnable{

	private String name;
	
	public myThread(String name) {
		this.name = name;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		myThread mt = new myThread("ZhangSheng");
		myThread mt2 = new myThread("LiDong");

		Thread t1 = new Thread(mt);
        Thread t2 = new Thread(mt2);
        
        t1.start();
        t1.setName("t1");
        t1.setPriority(6);
        t2.start();
        t2.setName("t2");
        
	}

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
            for (long k = 0; k < 100000000; k++) ;
            try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
            System.out.println(Thread.currentThread().getName() + ":" +  name + ": " + i);
        } 
		
	}

}
