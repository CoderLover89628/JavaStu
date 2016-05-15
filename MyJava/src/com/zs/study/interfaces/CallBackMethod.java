package com.zs.study.interfaces;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.Timer;

public class CallBackMethod {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TalkingClock tc = new TalkingClock();
		tc.start(1000, true);
		
		// 弹框出现需要等待10秒钟
		JOptionPane.showMessageDialog(null, "Quit program?");
		System.exit(0);

	}
	
}

class TalkingClock {
	
	public void start(int interval, final boolean beep) {
		ActionListener listener = new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Date now = new Date();
				System.out.println("At the tone, the time is " + now);
				if(beep) Toolkit.getDefaultToolkit().beep();// 发出一声铃响
				
			}
		};
		
		Timer t = new Timer(interval, listener);// 构造一个定时器，每隔interval毫秒钟通告listener一次
		t.start();

	}
}

class TimerPrinter implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Date now = new Date();
		System.out.println("At the tone, the time is " + now);
		Toolkit.getDefaultToolkit().beep();// 发出一声铃响
		
	}
	
	public class Test {
		
	}
}