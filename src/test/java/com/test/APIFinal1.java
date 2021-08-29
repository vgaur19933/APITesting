package com.test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import org.apache.tools.ant.taskdefs.condition.IsFalse;
import org.hamcrest.core.IsEqual;
import org.mozilla.javascript.ast.NewExpression;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.test.POJO.Resreq;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class APIFinal1 {

	RequestSpecification requestSpecification;
	ResponseSpecification responseSpecification;

	@BeforeClass
	public void Specbuilder() {

		RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder().setBaseUri("https://reqres.in/")
				.log(LogDetail.ALL).setContentType(ContentType.JSON);

		requestSpecification = requestSpecBuilder.build();

		ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder().log(LogDetail.ALL)
				.expectContentType(ContentType.JSON).expectStatusCode(201);

		responseSpecification = responseSpecBuilder.build();

	}

	@Test
	public void Reportgenertaion() {

		Resreq requestdataResreq = new Resreq();
		requestdataResreq.setName("vikas12345555ffgggg");
		requestdataResreq.setJob("Astonaught++");

		Resreq responsedataResreq = given().spec(requestSpecification).body(requestdataResreq).when().post("/api/users")
				.then().spec(responseSpecification).extract().response().as(Resreq.class);

		assertThat(responsedataResreq.getName(), equalTo(requestdataResreq.getName()));
		assertThat(responsedataResreq.getJob(), equalTo(requestdataResreq.getJob()));
		assertThat(responsedataResreq.getName().length(),greaterThan(50));

	}

	@Test(enabled = false)
	public void schemaval() {

		Resreq requestdataResreq = new Resreq();
		requestdataResreq.setName("vikas12345555ffdddggg");
		requestdataResreq.setJob("Astonaught++");

		Response res = given().baseUri("https://reqres.in/").body(requestdataResreq).when().post("api/users").then()
				.log().all().assertThat().statusCode(201).body(matchesJsonSchemaInClasspath("pojo.json")).extract()
				.response();

		Headers contentType = res.getHeaders();
		System.out.printf(contentType.getValue("Content-Type"));

		String cString = contentType.getValue("Connection");
		assertThat(contentType.getValue("Connection"), equalTo(cString));

	}

@Test(enabled = false)
	public void upload() {

		given().baseUri("https://postman-echo.com").multiPart("file", new File("Hii.txt")).log().all().when()
				.post("/post").then().log().all();

	}
	
	@Test(enabled = false)
	public void download() throws IOException {

		byte [] vikas=given().baseUri("https://raw.githubusercontent.com/appium/appium/").
				when().get("master/sample-code/apps/ApiDemos-debug.apk").
				then().extract().asByteArray();
		
		OutputStream os =new FileOutputStream(new File("ApiDemos-debug777.apk"));
		os.write(vikas);
		os.close();


	}
}

