package com.test;

import java.io.File;
import java.io.FileNotFoundException;

import io.restassured.internal.support.FileReader;

public class javtutorial {
	static int i;
	
	static private int b;

	public javtutorial() {

	}


	public void test(int i) {
		this.i = i;

		System.out.println(i);
	}


	public int getB() {
		return b;
	}


	public  void setB(int b) {
		this.b = b;
	}
	
	
	public void exceptions(){
		
		File file = new File("vikas.txt");
		//FileReader fReader = new FileReader (file);
		System.out.println("close progrmad");
		
	}
}







