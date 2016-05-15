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
 * ��������Ҫҵ���߼��ǣ�
 * 
 * 1. �ڹ��캯���
 * ͨ����������ΪInetAddress���Ͳ�����3333����ʼ���˱������Socket�������ʵ����������IO���󣬲�ͨ��start����
 * ������������run�����ڵı��̵߳�ҵ���߼���
 * 
 * 2. �ڶ����߳����嶯����run�����ͨ��IO�������Socket�ŵ��ϴ��䱾�ͻ��˵�ID�ţ�������Ϻ󣬴��䡱byebye���ַ�����
 * ��������˱�ʾ���̵߳�ͨѶ������
 * 
 * 3. ͬ���أ�catch�Ӿ佫������try�����������IO������쳣������finally�Ӿ������ͨѶ������رտͻ��˵�Socket�����
 * 
 * ����������д�ͻ��˵�������룬����δ������ͨ��forѭ��������ָ���Ĵ��������߳�������ͨ��ClientThreadCode�Ĺ��캯����
 * �������ɸ��ͻ����̣߳�ͬ���غͷ�������ͨѶ��
 * 
 * @author JZ
 * 
 */
public class ClientThreadCode extends Thread {

	// �ͻ��˵�socket
	private Socket socket;

	// �߳�ͳ�������������̱߳��
	private static int cnt = 0;

	private int clientId = cnt++;

	private BufferedReader in;

	private PrintWriter out;

	// ���캯��
	public ClientThreadCode(InetAddress addr) {

		try {

			socket = new Socket(addr, 3333);

		} catch (IOException e) {

			e.printStackTrace();

		}

		// ʵ����IO����
		try {

			in = new BufferedReader(

			new InputStreamReader(socket.getInputStream()));

			out = new PrintWriter(

					new BufferedWriter(new OutputStreamWriter(
							socket.getOutputStream())), true);

			// �����߳�
			start();

		} catch (IOException e) {

			// �����쳣���ر�socket
			try {

				socket.close();

			} catch (IOException e2) {

				e2.printStackTrace();

			}

		}

	}

	// �߳����巽��
	public void run() {

		try {

			out.println("Hello Server,My id is " + clientId);

			String str = in.readLine();

			System.out.println(str);

			out.println("byebye");

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				socket.close();

			} catch (IOException e) {

				e.printStackTrace();

			}

		}

	}
}
