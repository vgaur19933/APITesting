package com.test;

import java.io.FileNotFoundException;

import org.apache.tools.ant.taskdefs.compilers.Jvc;

public class java123 {

	public static void main(String[] args) throws FileNotFoundException {
		
		javtutorial jv =new javtutorial();
		
		jv.test(5);	

	System.out.println("value of b" + jv.getB());
	jv.exceptions();
		}

}
