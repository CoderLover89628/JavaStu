package com.zs.study.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 这段代码的主要业务逻辑说明如下：
 * 
 * 1. 首先定义了通讯所用的端口号，为3333。
 * 
 * 2. 在main函数里，根据端口号，创建一个ServerSocket类型的服务器端的Socket，用来同客户端通讯。
 * 
 * 3. 在for(;;)的循环里，调用accept方法，监听从客户端请求过来的socket，请注意这里又是一个阻塞。当客户端有请求过来时，
 * 将通过ServerThreadCode的构造函数
 * ，创建一个线程类，用来接收客户端发送来的字符串。在这里我们可以再一次观察ServerThreadCode类，
 * 在其中，这个类通过构造函数里的start方法，开启run方法，而在run方法里，是通过sin对象来接收字符串，通过sout对象来输出。
 * 
 * 4. 在finally从句里，关闭服务器端的Socket，从而结束本次通讯。
 * 
 * @author JZ
 * 
 */
public class ThreadServer {

	// 端口号
	static final int portNo = 3333;

	public static void main(String[] args) throws IOException

	{

		// 服务器端的socket
		ServerSocket s = new ServerSocket(portNo);

		System.out.println("The Server is start: " + s);

		try {

			for (;;) {

				// 阻塞,直到有客户端连接
				Socket socket = s.accept();

				// 通过构造函数，启动线程
				new ServerThreadCode(socket);

			}

		} finally {
			s.close();

		}

	}

}
