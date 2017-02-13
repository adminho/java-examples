package com.cuttingfile;


public class MainProgram {

	public static void main(String agrs[]) {
		try {
			new MainWindow();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}
	}
}
