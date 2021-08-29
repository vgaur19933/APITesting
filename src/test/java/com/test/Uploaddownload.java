package com.test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.emptyArray;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.testng.annotations.Test;

public class Uploaddownload {

	@Test(enabled = false)
	public void Upload() {

		given().baseUri("https://postman-echo.com/").
		multiPart("File",new File ("Hii.txt")).log().all().

				when().post("/post").

				then().log().all()
			
				;

	}
	
	@Test
	public void downlaod() throws IOException {

		byte [] vikas=given().baseUri("https://raw.githubusercontent.com/appium/appium/").
				when().get("master/sample-code/apps/ApiDemos-debug.apk").
				then().extract().asByteArray();
		
		OutputStream os =new FileOutputStream(new File("ApiDemos-debug12366.apk"));
		os.write(vikas);
		os.close();

	
	
	}
	
	
	
}
