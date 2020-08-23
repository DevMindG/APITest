package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GETAPINonBDD {
  //No BDD
		
		@Test(priority=1, enabled=false)
		public void getUsersAPITest() {
			RestAssured.baseURI = "http://localhost:3000";
			RequestSpecification request = RestAssured.given().log().all();
			//request.header("Authorization" ,"Bearer SXbmytsyJxP3DTdBR2hlWUqr4KhKXma1rwoF");
			Response response = request.get("/users");
			System.out.println(response.asString()); //to print all results in JSON
			System.out.println(response.prettyPrint()); //to print on the console appropriate format
			int statusCode = response.getStatusCode();
			Assert.assertEquals(statusCode, 200);
			String server = response.getHeader("X-Powered-By");
			Assert.assertEquals(server, "Express");
		}

	
	@Test(priority=2, enabled=false)
	public void getSingleUserAPITest(){
		

        RestAssured.baseURI = "http://localhost:3000";
		RequestSpecification request = RestAssured.given().log().all();
		//request.header("Authorization" ,"Bearer SXbmytsyJxP3DTdBR2hlWUqr4KhKXma1rwoF");
		Response response = request.get("/users/?firstName=Hasan");
		System.out.println(response.asString()); //to print all results in JSON
		System.out.println(response.prettyPrint()); //to print on the console appropriate format
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
		String server = response.getHeader("X-Powered-By");
		Assert.assertEquals(server, "Express");
	}
	
	@Test(priority=3, enabled=true)
	public static void getUserByParamsTest(){
		

	       RestAssured.baseURI = "http://localhost:3000";
			RequestSpecification request = RestAssured.given().log().all();
			//request.header("Authorization" ,"Bearer 4242b4a465097df28229861ee3a53a1ab3e674935bb89e135543e470750c4e3b");
			request.queryParam("firstName", "Hasan");
			request.queryParam("age", "19");
			request.queryParam("companyId", "4");
			Response response = request.get("/users");
			System.out.println(response.asString()); //to print all results in JSON
			System.out.println(response.prettyPrint()); //to print on the console appropriate format
			int statusCode = response.getStatusCode();
			Assert.assertEquals(statusCode, 200);
			String server = response.getHeader("X-Powered-By");
			Assert.assertEquals(server, "Express");
		}
}
