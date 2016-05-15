package com.zs.forInterView.string;

public class StringTest {

	public static void main(String[] args) {

		int[][] numeight = { { 100, 200, 300, 400 }, { 500, 600, 700, 800 },
				{ 900, 1000, 1100, 1200, 1300 } };

		for (int i = 0; i < numeight.length; i++) {
			for (int j = 0; j < numeight[i].length; j++) {
				System.out.print(" ");
				System.out.print(numeight[i][j]);
			}
		}
		int find = 1400;
		int rows = numeight.length;
		int cols = numeight[0].length;
		
		System.out.println(found(numeight, find, rows, cols));
		
		String msg = "We are happy.";
		System.out.println("old msg's length is :" + msg.length());
		msg = msg.replace(" ", "%20");
		System.out.println("new msg is :" + msg + "length is:" + msg.length());
	}

	private static boolean found(int[][] numeight, int find, int rows, int cols) {
		boolean findFlag = false;
		if(numeight != null && rows > 0 && cols > 0) {
			int row = 0;
			int col = cols - 1;
			while(row < rows && col >= 0) {
				if(numeight[row][col] == find) {
					findFlag = true;
					break;
				}
				else if(numeight[row][col] > find) {
					--col;
				}
				else
					++row;
			}
		}
		return findFlag;
	}

}
