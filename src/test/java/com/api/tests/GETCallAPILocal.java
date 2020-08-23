package com.api.tests;
import static io.restassured.RestAssured.*;
//import static org.testng.Assert.fail;

import org.testng.annotations.Test;
import io.restassured.RestAssured;

public class GETCallAPILocal {
	@Test(priority=1, enabled=false)
	public void getUsersAPITest() {
		RestAssured.baseURI = "http://localhost:3000";
		given().log().all()
		 .contentType("application/json")
		 //.header("Authorization", "Bearer SXbmytsyJxP3DTdBR2hlWUqr4KhKXma1rwoF")
		.when().log().all()
		 .get("/users")
		.then().log().all()
		 .statusCode(200)
		 .and()
		 .header("X-Powered-By", "Express")
		 .header("Connection", "keep-alive");
	}
	//Single User
	@Test(priority=2, enabled=false)
	public void getSingleUserAPITest() {
		RestAssured.baseURI = "http://localhost:3000";
		given().log().all()
		 .contentType("application/json")
		 //.header("Authorization", "Bearer SXbmytsyJxP3DTdBR2hlWUqr4KhKXma1rwoF")
		.when().log().all()
		 .get("/users/4")
		.then().log().all()
		 .statusCode(200)
		 .and()
		 .header("X-Powered-By", "Express")
		 .header("Connection", "keep-alive");
	}
	@Test(priority=3, enabled=true)
	public void getUsersWithParametersAPITest() {
		RestAssured.baseURI = "http://localhost:3000";
		given().log().all()
		 .contentType("application/json")
		 //.header("Authorization", "Bearer SXbmytsyJxP3DTdBR2hlWUqr4KhKXma1rwoF")
		 .queryParam("firstName", "Furkan")
		 .queryParam("age", "25")
		 .queryParam("companyId", "1")
		.when().log().all()
		 .get("/users")
		.then().log().all()
		 .statusCode(200)
		 .and()
		 .header("X-Powered-By", "Express")
		 .header("Connection", "keep-alive");
	}
}
