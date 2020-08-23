package com.api.tests;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PUTCallAPI {
	@Test
	public void updateUsersAPI(){
	RestAssured.baseURI ="https://localhost:3000";
	
	RequestSpecification request = RestAssured.given().log().all();
	request.contentType("application/json");
	
	File file = new File("/Users/sonamdickyi/Documents/workspace/APITesting/"
			+ "src/test/java/com/api/tests/updateuser");
	
	request.body(file);
	
	Response response = request.put("/users/1");
	System.out.println(response.prettyPrint());
}
}
