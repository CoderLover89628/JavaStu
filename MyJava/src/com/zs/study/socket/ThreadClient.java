package com.zs.study.socket;

import java.io.IOException;
import java.net.InetAddress;

/**
 * ��δ���ִ���Ժ��ڿͻ��˽�����3��ͨѶ�̣߳�ÿ���߳����Ƚ�����������˷���"Hello Server,My id is "���ַ�����Ȼ���͡�
 * byebye������ֹ���̵߳�ͨѶ��
 * 
 * @author JZ
 * 
 */
public class ThreadClient {

	public static void main(String[] args)

	throws IOException, InterruptedException

	{

		int threadNo = 0;

		InetAddress addr =

		InetAddress.getByName("localhost");

		for (threadNo = 0; threadNo < 3; threadNo++)

		{

			new ClientThreadCode(addr);

		}

	}
}
