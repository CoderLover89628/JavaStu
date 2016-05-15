package com.zs.study.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ��δ������Ҫҵ���߼�˵�����£�
 * 
 * 1. ���ȶ�����ͨѶ���õĶ˿ںţ�Ϊ3333��
 * 
 * 2. ��main��������ݶ˿ںţ�����һ��ServerSocket���͵ķ������˵�Socket������ͬ�ͻ���ͨѶ��
 * 
 * 3. ��for(;;)��ѭ�������accept�����������ӿͻ������������socket����ע����������һ�����������ͻ������������ʱ��
 * ��ͨ��ServerThreadCode�Ĺ��캯��
 * ������һ���߳��࣬�������տͻ��˷��������ַ��������������ǿ�����һ�ι۲�ServerThreadCode�࣬
 * �����У������ͨ�����캯�����start����������run����������run�������ͨ��sin�����������ַ�����ͨ��sout�����������
 * 
 * 4. ��finally�Ӿ���رշ������˵�Socket���Ӷ���������ͨѶ��
 * 
 * @author JZ
 * 
 */
public class ThreadServer {

	// �˿ں�
	static final int portNo = 3333;

	public static void main(String[] args) throws IOException

	{

		// �������˵�socket
		ServerSocket s = new ServerSocket(portNo);

		System.out.println("The Server is start: " + s);

		try {

			for (;;) {

				// ����,ֱ���пͻ�������
				Socket socket = s.accept();

				// ͨ�����캯���������߳�
				new ServerThreadCode(socket);

			}

		} finally {
			s.close();

		}

	}

}
