package com.test;

import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeClass;
//import static io.restassured.module.jsv.JsonSchemaValidator;
import org.testng.annotations.Test;

import groovyjarjarpicocli.CommandLine.Spec;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class jasonvalidation {

	RequestSpecification requestSpecification;
	ResponseSpecification responseSpecification;

	@BeforeClass
	public void BeforeAll() throws FileNotFoundException {
		
		PrintStream fileoutStream= new PrintStream("log123.txt");

		RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder().setBaseUri("https://reqres.in/api/")
				.addFilter(new RequestLoggingFilter(LogDetail.HEADERS,fileoutStream)).addFilter(new ResponseLoggingFilter(LogDetail.STATUS,fileoutStream));

			requestSpecification = requestSpecBuilder.build();

		ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder().expectStatusCode(200);
		responseSpecification = responseSpecBuilder.build();

	}

	@Test
	public void test2() {

		given().spec(requestSpecification).

				when().get("/users?page=2").then().assertThat().statusCode(200)

		// then().log().all().assertThat().body(matchesJsonSchemaInClasspath("jsonschema.json"))

		;

	}
}
