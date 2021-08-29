package com.test;


import org.apache.tools.ant.taskdefs.condition.IsFalse;
import org.apache.tools.ant.types.resources.comparators.Size;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class Pojomain {
	RequestSpecification requestSpecification;
	ResponseSpecification responseSpecification;

	@BeforeClass
	public void BeforeAll() {

		RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder().setBaseUri("https://reqres.in/")
				.log(LogDetail.BODY).setContentType(ContentType.JSON);

		requestSpecification = requestSpecBuilder.build();

		ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder().expectStatusCode(201)
				.expectContentType(ContentType.JSON).log(LogDetail.ALL);
		// .log(LogDetail.COOKIES);

		responseSpecification = responseSpecBuilder.build();

	}

	@Test(dataProvider="POJO")
	
	public void test(String name,String job) {
		
		POJODATA checkPojodata = new POJODATA(name,job);

		given().body(checkPojodata).spec(requestSpecification).

				when().post("/api/users").

				then().spec(responseSpecification).extract().response().as(POJODATA.class);
				

	}
	
	
		 @DataProvider (name = "POJO")
		 public Object[][] Method(){
		 return new Object[][] {
			 {"vikas1223","developer2"}, {"vikas1234","dataananalyst3"}
		 };
		 }

}
