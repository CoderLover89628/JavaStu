package com.zs.study.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class TestFile {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		TestFile tf = new TestFile();
//		tf.writeFile();
//		tf.readFile();
//		tf.deleteFile();
//		tf.fileDetailCopy();
		tf.getFileSize("F:\\AIRPORT_SERVICE_Workplace\\MyJava\\outfilename.txt");
		tf.reName();

	}

	/**
	 * �����ɹ���ǰĿ¼�¾ͻ�����һ����Ϊ outfilename ���ļ�����"w3cschool����̳�"�ַ���д����ļ�
	 * �ô�������ǿ���Դ�����������ȫ����ԭ�ļ�
	 */
	public void writeFile() {
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(
					"outfilename.txt"));
			out.write("w3cschool����̳�!!!");
			out.close();
			System.out.println("�ļ������ɹ���");
		} catch (IOException e) {
			System.out.println("�ļ�����ʧ�ܣ�");
		}
	}

	/**
	 * ��ȡ�ļ�
	 */
	public void readFile() {
		try {
			BufferedReader in = new BufferedReader(new FileReader(
					"outfilename.txt"));
			String str;
			while ((str = in.readLine()) != null) {
				System.out.println(str);
			}
		} catch (IOException e) {
			System.out.println("�ļ���ȡʧ�ܣ�");
		}
	}

	/**
	 * ɾ���ļ�
	 */
	public void deleteFile() {
		try {
			File file = new File("F:\\AIRPORT_SERVICE_Workplace\\MyJava\\outfilename.txt");
			if (file.delete()) {
				System.out.println(file.getName() + " �ļ��ѱ�ɾ����");
			} else {
				System.out.println("�ļ�ɾ��ʧ�ܣ�");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * ���ļ����ݸ��Ƶ���һ���ļ�
	 * @throws IOException 
	 */
	public void fileDetailCopy() throws IOException {
		
		// ��һ���֣������ļ�����д������
		BufferedWriter out1 = new BufferedWriter(new FileWriter("srcfile"));
		out1.write("string to be copied\n");
		out1.close();
		
		// �ڶ����֣���ȡд������ݣ���д��Ŀ���ļ�
		InputStream in = new FileInputStream(new File("srcfile"));
		OutputStream out = new FileOutputStream(new File("destnfile"));
		byte[] buf = new byte[1024];
		int len;
		while ((len = in.read(buf)) > 0) {
			out.write(buf, 0, len);
		}
		in.close();
		out.close();
		
		// �������֣���ȡĿ���ļ�����
		BufferedReader in1 = new BufferedReader(new FileReader("destnfile"));
		String str;
		while ((str = in1.readLine()) != null) {
			System.out.println(str);
		}
		in1.close();
	}
	
	/**
	 * ��ȡ�ļ��Ĵ�С
	 * 
	 * @param fileName
	 * @return
	 */
	public long getFileSize(String fileName) {
		File file = new File(fileName);
		if(!file.exists() || !file.isFile()) {
			System.out.println("file is not exists!");
			return -1;
		}
		System.out.println(file.length());
		return file.length();
		
	}
	
	/**
	 * �ļ�������
	 */
	public void reName() {
		File oldName = new File("F:\\AIRPORT_SERVICE_Workplace\\MyJava\\outfilename.txt");
		File newName = new File("F:\\AIRPORT_SERVICE_Workplace\\MyJava\\outFileName.txt");
		if(oldName.renameTo(newName)) {
			System.out.println("�Ѿ���������");
		} else {
			System.out.println("Error!");
		}
	}
}
