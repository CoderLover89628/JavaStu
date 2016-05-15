package com.zs.study.socket;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServiceSocket {

	private static final int port = 8898;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		try {
			ServerSocket server = new ServerSocket(port);
			Socket socket = server.accept();
			Reader reader = new InputStreamReader(socket.getInputStream());
			char[] chars = new char[1024];
			int len;
			StringBuilder sb = new StringBuilder();
			while((len=reader.read(chars)) != -1) {
				sb.append(new String(chars,0,len));
			}
			System.out.println("Receive the message from client is :" + sb.toString());
			reader.close();
			socket.close();
			server.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
