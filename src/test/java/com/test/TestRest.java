package com.test;

import org.apache.tools.ant.taskdefs.condition.IsFalse;
import org.apache.tools.ant.types.resources.comparators.Size;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

import java.util.HashMap;

public class TestRest {

	RequestSpecification requestSpecification;
	ResponseSpecification responseSpecification;

	@BeforeClass
	public void BeforeAll() {

		RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder().setBaseUri("https://reqres.in/")
				.log(LogDetail.ALL).setContentType(ContentType.JSON);

		requestSpecification = requestSpecBuilder.build();

		ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder().expectStatusCode(200)
				.expectContentType(ContentType.JSON).log(LogDetail.ALL);
		// .log(LogDetail.COOKIES);

		responseSpecification = responseSpecBuilder.build();

	}

	@Test
	public void test() {
//		
//		HashMap<String ,String > puttingheardes =new HashMap<String ,String>() ;
//		puttingheardes.put("abc", "1");

		// Headers h1= given().baseUri("https://reqres.in").log().all().
		// given().baseUri("https://reqres.in").log().headers().
		
		Response response=
		given().spec(requestSpecification).log().all().

				when().get("/api/users?page=2").

				then().spec(responseSpecification).extract().response();
		
		JsonPath jp= new JsonPath(response.asString());
		
	 String expected =(jp.getString("data[0].email"));
	 
	 Assert.assertEquals(expected,"michael.lawson@reqres.in" );
	
	   
	 
	   
				// .assertThat()
				// .body("ichael.lawson@reqres.in","tobias.funke@reqres.in"));

	}
//		for(Header h2:h1) {
//			
//			System.out.print("header names " + h2.getName() + ","  );
//			System.out.println("header value " + h2.getValue());
//			
//			
//		}
//		
// .body("data.email",
// hasItems("michael.lawson@reqres.in","tobias.funke@reqres.in"));
// body("data[0].email", equalTo("michael.lawson@reqres.in"),
// "data.size()",equalTo(5));
// Assert.assertEquals(data.email, "michael.lawson@reqres.in");

	@Test(enabled = false)
	public void Post() {

		String payload = " {\r\n" + "    \"name\": \"vikki12345\",\r\n" + "    \"job\": \"leader1234\"\r\n" + "}   ";
		given().spec(requestSpecification).body(payload).when().post("api/users").then().spec(responseSpecification)
				.assertThat().body("name", equalTo("vikki12345"), "job", equalTo("leader1234"));

	}

	@Test(enabled = false)

	public void put() {

		String payload = " {\r\n" + "    \"name\": \"vikki12345777777\",\r\n" + "    \"job\": \"leader1234\"\r\n"
				+ "}   ";
		given().spec(requestSpecification).body(payload).when().put("/api/users/2").then().spec(responseSpecification)
				.assertThat().body("name", equalTo("vikki12345777777"), "job", equalTo("leader1234"))

		;

	}

	@Test(enabled = false)

	public void patch() {
		String payload = " {\r\n" + "    \"name\": \"morpheus\"\r\n" + "\r\n" + "} ";
		given().spec(requestSpecification).body(payload).when().patch("/api/users/2").then().spec(responseSpecification)
				.assertThat().body("name", equalTo("morpheus"));

	}

	@Test(enabled = false)

	public void delete() {

		given().spec(requestSpecification).when().delete("/api/users/2").then().spec(responseSpecification);

	}
}