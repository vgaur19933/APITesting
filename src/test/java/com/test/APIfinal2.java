package com.test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

import org.hamcrest.core.IsEqual;
import org.junit.validator.PublicClassValidator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.test.POJO.Resreq;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class APIfinal2 {
	
	@Test(priority = 0)
	public void schemaval() {
		
		Resreq requestdataResreq = new Resreq();
		requestdataResreq.setName("vikas12345555ffddd");
		requestdataResreq.setJob("Astonaught++");
		
		
		given().baseUri("https://reqres.in/").body(requestdataResreq).
		when().post("api/users");
	//	then().log().all().assertThat().body(matchesJsonSchemaInClasspath(""));
		
	}

}
