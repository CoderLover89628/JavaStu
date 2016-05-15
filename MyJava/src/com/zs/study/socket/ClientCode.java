package com.zs.study.socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

/**
 * socketͨ�ſͻ���
 * 
 * �����ͻ��˴������Ҫҵ���߼��ǣ�
 * 
 * 1. ͬ��������ͨѶ�˿ںţ���������Ķ˿ںű���Ҫ�ͷ������˵�һ�¡�
 * 
 * 2. ��main��������ݵ�ַ��Ϣ��localhost��������һ��InetAddress���͵Ķ���addr�����
 * ��Ϊ���ǰѿͻ��˺ͷ������˵Ĵ��붼���ڱ������У�����ͬ�������á�127.0.0.1���ַ�����������InetAddress����
 * 
 * 3. ����addr�Ͷ˿ں���Ϣ������һ��Socket���Ͷ��󣬸ö�������ͬ�������˵�ServerSocket���Ͷ��󽻻�����ͬ���C/SͨѶ���̡�
 * 
 * 4. ͬ���ش���in��out����IO�����������������˷��ͺͽ�����������
 * 
 * 5. ͨ��out������������˷���"Hello Server,I am ��"���ַ��������ͺ�ͬ��������in��������մӷ������˵���Ϣ��
 * 
 * 6. ����out���󣬷��͡�byebye���ַ��������Ը�֮�������ˣ�����ͨѶ������
 * 
 * 7. ��finally�Ӿ���ر�Socket���󣬶Ͽ�ͬ�������˵����ӡ�
 * 
 * @author JZ
 * 
 */
public class ClientCode {

	static String clientName = "ZhangSheng-PC";

	// �˿ں�

	public static int portNo = 3333;

	public static void main(String[] args) throws IOException

	{

		// �������ӵ�ַ��,���ӱ���

		InetAddress addr = InetAddress.getByName("localhost");

		// Ҫ��Ӧ�������˵�3333�˿ں�

		Socket socket = new Socket(addr, portNo);

		try

		{

			System.out.println("socket = " + socket);

			// ����IO���

			BufferedReader in = new BufferedReader(new InputStreamReader(socket

			.getInputStream()));

			PrintWriter out = new PrintWriter(new BufferedWriter(

			new OutputStreamWriter(socket.getOutputStream())), true);

			out.println("Hello Server,I am " + clientName);

			String str = in.readLine();

			System.out.println("str is:" + str);

			out.println("byebye");

		}

		finally

		{

			System.out.println("close the Client socket and the io.");

			socket.close();

		}

	}

}
