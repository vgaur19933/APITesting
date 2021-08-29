package com.test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.emptyArray;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

import java.io.File;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;



public class PayloadTest {

	RequestSpecification requestSpecification;
	ResponseSpecification responseSpecification;

	@BeforeClass
	public void BeforeAll() {

		RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder().setBaseUri("https://reqres.in/")
				.log(LogDetail.ALL).setContentType(ContentType.JSON);

		requestSpecification = requestSpecBuilder.build();

		ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder().expectStatusCode(204)
				.expectContentType(ContentType.JSON).log(LogDetail.ALL);
		// .log(LogDetail.COOKIES);

		responseSpecification = responseSpecBuilder.build();

	}
	
	@Test

	public void test() {

		File payloadFile = new File("\\src\\test\\resources\\payload.json");

		given().body(payloadFile).spec(requestSpecification).

				when().post("/api/users").

				then().log().all();
		// .assertThat()
		// .body("ichael.lawson@reqres.in","tobias.funke@reqres.in"));
		// body("data.email", is(not(emptyArray())), "data.email",
		// hasSize(6)).extract().headers();
	}

}
