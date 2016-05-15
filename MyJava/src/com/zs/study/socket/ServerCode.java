package com.zs.study.socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * socketͨ�ŷ����
 * 
 * ��δ������Ҫҵ���߼��ǣ�
 * 
 * 1. �������������main����ǰ������������ͨѶ���õ��Ķ˿ںţ�Ϊ3333��
 * 
 * 2. ��main��������ݸ���3333�˿ںţ���ʼ��һ��ServerSocket����s���ö��������е��������˼������Ӻ��ṩͨѶ����Ĺ��ܡ�
 * 
 * 3. ����ServerSocket�����accept�����������ӿͻ��˵��������󡣵���ɵ���accept���������η������˴��뽫�����������
 * ֱ���ͻ��˷���connect����
 * 
 * 4. ���ͻ��˷���connect���󣬻���ͨ�����캯��ֱ�Ӱѿͻ��˵�Socket�������ӵ��������˺������ڴ˵Ĵ��뽫��������С�
 * ��ʱ�������˽������accept������ִ�н������һ��Socket�����������ͻ��˵����Ӿ����
 * 
 * 5. ����������Ϊin��out�Ķ�����������ͽ���ͨѶʱ����������
 * 
 * 6. ����һ��while(true)����ѭ���������ѭ���ͨ��in.readLine()��������ȡ�ӿͻ��˷�������IO�����ַ�����������ӡ������
 * ����������ַ����ǡ�byebye������ô�˳�whileѭ����
 * 
 * 7. ��try��catch��finally�����������try�������Ƿ����쳣�����Ҳ�����Щ�쳣�����࣬finally�Ӿ䶼���ᱻִ�е���
 * ��finally�Ӿ�����ر������ͻ��˵����Ӿ��socket�����ServerSocket���͵�s����
 * 
 * @author JZ
 * 
 */
public class ServerCode {

	// ���ö˿ں�
	public static int portNo = 3333;

	public static void main(String[] args) throws IOException

	{

		ServerSocket s = new ServerSocket(portNo);

		System.out.println("The Server is start: " + s);

		// ����,ֱ���пͻ�������

		Socket socket = s.accept();

		try

		{

			System.out.println("Accept the Client: " + socket);

			// ����IO���

			BufferedReader in = new BufferedReader(new InputStreamReader(socket

			.getInputStream()));

			PrintWriter out = new PrintWriter(new BufferedWriter(

			new OutputStreamWriter(socket.getOutputStream())), true);

			while (true)

			{

				String str = in.readLine();

				if (str.equals("byebye"))

				{

					break;

				}

				System.out.println("In Server reveived the info: " + str);

				out.println(str);

			}

		}

		finally

		{

			System.out.println("close the Server socket and the io.");

			socket.close();

			s.close();

		}

	}

}
