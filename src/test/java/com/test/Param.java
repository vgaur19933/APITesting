package com.test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.emptyArray;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;


import java.util.HashMap;

import org.apache.tools.ant.taskdefs.optional.script.ScriptDef.NestedElement;
import org.testng.annotations.Test;

public class Param {
	
	
	@Test(enabled = false)
	public void test2() {
//		
//		HashMap<String ,String > puttingheardes =new HashMap<String ,String>() ;
//		puttingheardes.put("abc", "1");

		// Headers h1= given().baseUri("https://reqres.in").log().all().
		// given().baseUri("https://reqres.in").log().headers().
		given().baseUri("https://postman-echo.com/post").log().all().param("foo1", "bar1").param("foo2", "bar2").

				when().post().

				then().log().all()
				// .assertThat()
				;

	}
	
	@Test
	public void test() {
		
		HashMap<String, String> pathparHashMap = new HashMap<String, String>();
		
		pathparHashMap.put("id", "2");
		
		
		

		
		given().baseUri("https://reqres.in/api/").log().all().pathParams("pathparHashMap",pathparHashMap).

				when().get("/users/{pathparHashMap}").

				then().log().all()
				// .assertThat()
				;

	}


}
