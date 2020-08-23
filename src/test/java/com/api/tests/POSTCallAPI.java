package com.api.tests;

import java.io.File;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class POSTCallAPI {
	@Test
	public void createUserAPI() {
		RestAssured.baseURI = "http://localhost:3000";
		RequestSpecification request = RestAssured.given().log().all();
		request.contentType("application/json");
		File file = new File("/Users/sonamdickyi/Documents/workspace/APITesting/"
				+ "src/test/java/com/api/tests/createuser.json");
		request.body(file);
		Response response = request.post("/users");
		System.out.println(response.prettyPrint());
	}
}
