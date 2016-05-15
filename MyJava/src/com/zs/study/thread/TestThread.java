package com.zs.study.thread;

public class TestThread {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		for(int i = 0; i < 10000; i++) 
		{
			new Thread("CURRENT THREAD IS :" + i){
				@Override
				public void run() {
					
					for(int i=0;i<100;){
						i++;
						System.out.println("i is :" + i);
					}
					
				}
			}.start();
		}

	}

	

}
