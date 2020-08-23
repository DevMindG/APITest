package com.api.tests;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;//this part we import by typing cuz it doesn't auto generate!

public class GETCallUsersAPI {
	//BDD Approach technique //bbd is like a bridge between businessmen and us using "Jerkin" and his advantage check interview Qs!
	
	@Test(priority=1, enabled=false)
	public void getUserAPITest(){
		
		RestAssured.baseURI = "http://localhost:3000"; // this is from terminal and json server so no need authorization
		given().log().all()
		 .contentType("application/json") 
	 	//.header("Authorization", "Bearer daf3391fea654ae0b5c39923888d727bb9be9879d480d62b866842acaffc7392")
	 	.when().log().all()
		 .get("/users") //this is to get url
		.then().log().all() // for the result
		 .statusCode(200)
		 .and() //merely connection or extension.
		 .header("X-Powered-By", "Express")
		 .header("Connection", "keep-alive");
	}
	
	
	//Single User
	@Test(priority=2, enabled=false)
	public void getSingleUserAPITest(){

		RestAssured.baseURI = "http://localhost:3000";
		given().log().all()
		.contentType("application/json") 
	 	//.header("Authorization", "Bearer daf3391fea654ae0b5c39923888d727bb9be9879d480d62b866842acaffc7392")
	 	.when().log().all()
		.get("/users/4") //this is to get url
		.then().log().all() // for the result
		.statusCode(200)
		.and()
		.header("X-Powered-By", "Express")
		.header("Connection", "keep-alive");
}
	
	@Test(priority=3, enabled=true)
	public void getUsersWithParametersAPITest() {
		//this is single user parameter!
		
		RestAssured.baseURI = "http://localhost:3000";
		given().log().all()
		.contentType("application/json") 
	 //	.header("Authorization", "Bearer daf3391fea654ae0b5c39923888d727bb9be9879d480d62b866842acaffc7392")
	 	.queryParam("Firstname", "Furkan")
	 	.queryParam("age", "25")
	 	.queryParam("companyID", "1")
	 	.when().log().all()
		.get("") //this is to get url
		.then().log().all() // for the result
		.statusCode(200)
		.and()
		.header("X-Powered-By", "Express")
		.header("Connection", "keep-alive");
	}
}
