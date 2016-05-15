package com.zs.study.socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * ������ҵ���߼�˵�����£�
 * 
 * 1. �����ͨ���̳�Thread����ʵ���̵߳Ĺ��ܣ�Ҳ����˵�������е�run����������˸��߳�������Ҫִ�е�ҵ������
 * 
 * 2. ������ṩ���������͵����غ������ڲ�������ΪSocket�Ĺ��캯���
 * ͨ����������ʼ���˱������Socket����ͬʱʵ����������IO�����ڴ˻����ϣ�ͨ��start����������������run�����ڵı��̵߳�ҵ���߼���
 * 
 * 3. �ڶ����߳����嶯����run�����ͨ��һ��for(;;)���͵�ѭ��������IO�������ȡ��Socket�ŵ��ϴ�������Ŀͻ��˷��͵�ͨѶ��Ϣ��
 * ����õ�����ϢΪ��byebye�������������ͨѶ�������˳�forѭ����
 * 
 * 4. catch�Ӿ佫������try�����������IO������쳣������finally�Ӿ������ͨѶ������رտͻ��˵�Socket�����
 * 
 * @author JZ
 * 
 */
public class ServerThreadCode extends Thread {

	// �ͻ��˵�socket
	private Socket clientSocket;

	// IO���
	private BufferedReader sin;

	private PrintWriter sout;

	// Ĭ�ϵĹ��캯��
	public ServerThreadCode() {
	}

	public ServerThreadCode(Socket s) throws IOException {

		clientSocket = s;

		// ��ʼ��sin��sout�ľ��
		sin = new BufferedReader(new InputStreamReader(
				clientSocket.getInputStream()));

		sout = new PrintWriter(new BufferedWriter(new OutputStreamWriter(
				clientSocket.getOutputStream())), true);

		// �����߳�
		start();

	}

	// �߳�ִ�е����庯��
	public void run() {

		try {

			// ��ѭ��������ͨѶ����
			for (;;) {

				String str = sin.readLine();

				// ������յ�����byebye���˳�����ͨѶ
				if (str.equals("byebye")) {
					break;
				}

				System.out.println("In Server reveived the info: " + str);
				sout.println(str);

			}

			System.out.println("closing the server socket!");

		}

		catch (IOException e) {

			e.printStackTrace();

		}

		finally {

			System.out.println("close the Server socket and the io.");

			try {

				clientSocket.close();

			} catch (IOException e) {

				e.printStackTrace();

			}

		}

	}

}
