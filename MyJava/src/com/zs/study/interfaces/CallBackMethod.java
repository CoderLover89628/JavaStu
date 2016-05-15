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
		
		// ���������Ҫ�ȴ�10����
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
				if(beep) Toolkit.getDefaultToolkit().beep();// ����һ������
				
			}
		};
		
		Timer t = new Timer(interval, listener);// ����һ����ʱ����ÿ��interval������ͨ��listenerһ��
		t.start();

	}
}

class TimerPrinter implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Date now = new Date();
		System.out.println("At the tone, the time is " + now);
		Toolkit.getDefaultToolkit().beep();// ����һ������
		
	}
	
	public class Test {
		
	}
}