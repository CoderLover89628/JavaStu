package com.zs.study.contend;

import java.io.File;

public class TestDir {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TestDir td = new TestDir();
		//td.setDirs();
		String directories = "D:\\a";
		File file = new File(directories);
		td.deleteDir(file);

	}

	/**
	 * �ݹ鴴��Ŀ¼
	 */
	public void setDirs() {
		String directories = "D:\\a\\b\\c\\d\\e\\f\\g\\h\\i";
		File file = new File(directories);
		boolean result = file.mkdirs();
		System.out.println("Status = " + result);
	}
	
	/**
	 * ɾ��Ŀ¼
	 */
	public boolean deleteDir(File file) {
		
		if(file.isDirectory()) {
			String[] children = file.list();
	         for (int i = 0; i < children.length; i++) {
	            boolean success = deleteDir
	            (new File(file, children[i]));
	            if (!success) {
	               return false;
	            }
	         }
		}
		System.out.println("Ŀ¼�ѱ�ɾ��");
		return file.delete();
	}
}
