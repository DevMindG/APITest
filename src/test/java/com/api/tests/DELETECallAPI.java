package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
 
public class DELETECallAPI {
	
	
	@Test
	public void deleteUserAPI() {
		RestAssured.baseURI = "http://localhost:3000";
		
		RequestSpecification request = RestAssured.given().log().all();
		Response response = request.delete("/users/23");
		System.out.println(response.prettyPrint());
		Assert.assertEquals(response.getStatusCode(), 200);
		JsonPath js = response.jsonPath();
		System.out.println(js.get("result"));
		Assert.assertNull(js.get("result"));
	}
}
