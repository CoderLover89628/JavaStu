package com.zs.forInterView.string;

public class OuterClass {

	private class InnerClass {
		public InnerClass(){
			System.out.println("InnerClass create");
		}
	}
	public OuterClass() {
		//InnerClass inc = new InnerClass();
		System.out.println("OuterClass create");
	}
	public static void main(String[] args) {
		OuterClass oc =  new OuterClass();
		child c = new child();
		new Thread(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
			}
		};
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
		});

	}

	public static class child extends OuterClass {
		public child() {
			System.out.println("childclass create");
		}
	}
	
}
