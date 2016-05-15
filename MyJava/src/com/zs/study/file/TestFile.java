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
	 * 创建成功后当前目录下就会生成一个名为 outfilename 的文件并将"w3cschool菜鸟教程"字符串写入该文件
	 * 该创建属于强制性创建，即会完全覆盖原文件
	 */
	public void writeFile() {
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(
					"outfilename.txt"));
			out.write("w3cschool菜鸟教程!!!");
			out.close();
			System.out.println("文件创建成功！");
		} catch (IOException e) {
			System.out.println("文件创建失败！");
		}
	}

	/**
	 * 读取文件
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
			System.out.println("文件读取失败！");
		}
	}

	/**
	 * 删除文件
	 */
	public void deleteFile() {
		try {
			File file = new File("F:\\AIRPORT_SERVICE_Workplace\\MyJava\\outfilename.txt");
			if (file.delete()) {
				System.out.println(file.getName() + " 文件已被删除！");
			} else {
				System.out.println("文件删除失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 将文件内容复制到另一个文件
	 * @throws IOException 
	 */
	public void fileDetailCopy() throws IOException {
		
		// 第一部分：创建文件，并写入内容
		BufferedWriter out1 = new BufferedWriter(new FileWriter("srcfile"));
		out1.write("string to be copied\n");
		out1.close();
		
		// 第二部分：读取写入的内容，并写入目标文件
		InputStream in = new FileInputStream(new File("srcfile"));
		OutputStream out = new FileOutputStream(new File("destnfile"));
		byte[] buf = new byte[1024];
		int len;
		while ((len = in.read(buf)) > 0) {
			out.write(buf, 0, len);
		}
		in.close();
		out.close();
		
		// 第三部分：读取目标文件内容
		BufferedReader in1 = new BufferedReader(new FileReader("destnfile"));
		String str;
		while ((str = in1.readLine()) != null) {
			System.out.println(str);
		}
		in1.close();
	}
	
	/**
	 * 获取文件的大小
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
	 * 文件重命名
	 */
	public void reName() {
		File oldName = new File("F:\\AIRPORT_SERVICE_Workplace\\MyJava\\outfilename.txt");
		File newName = new File("F:\\AIRPORT_SERVICE_Workplace\\MyJava\\outFileName.txt");
		if(oldName.renameTo(newName)) {
			System.out.println("已经重命名！");
		} else {
			System.out.println("Error!");
		}
	}
}
