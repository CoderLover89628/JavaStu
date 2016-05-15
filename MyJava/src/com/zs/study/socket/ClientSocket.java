package com.zs.study.socket;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientSocket {

	private static final String host = "127.0.0.1";
	private static final int port = 8898;
	
	public static void main(String[] args) {
		try {
			Socket client = new Socket(host, port);
			Writer writer = new OutputStreamWriter(client.getOutputStream());
			writer.write("hello world!");
			writer.flush();
			writer.close();
			client.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
