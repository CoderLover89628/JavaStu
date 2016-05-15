package com.zs.study.socket;

import java.io.IOException;
import java.net.InetAddress;

/**
 * 这段代码执行以后，在客户端将会有3个通讯线程，每个线程首先将先向服务器端发送"Hello Server,My id is "的字符串，然后发送”
 * byebye”，终止该线程的通讯。
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
