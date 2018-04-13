package com.basicAPI;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class PostResponseValidation {
	
	@Test
	public void verifyResponse(){
		
		RestAssured.baseURI = "https://maps.googleapis.com";
		
		String requestpayload = "{"+
  "\"location\": { "+
   " \"lat\": -33.8669710,"+
   " \"lng\": 151.1958750"+
  "}, "+
  "\"accuracy\": 50, "+
  "\"name\": \"Google Shoes!\", "+
  "\"phone_number\": \"(02) 9374 4000\", "+
  "\"address\": \"48 Pirrama Road, Pyrmont, NSW 2009, Australia\", "+
  "\"types\": [\"shoe_store\"], "+
  "\"website\": \"http://www.google.com.au/\","+
  "\"language\": \"en-AU\" "+
"}";
		Response response = 
	
		given().
		queryParam("key", "AIzaSyB-ZliaFkPtyfykn7E2nW2yxgBPAvRVUMo").
		body(requestpayload).
		when().post("/maps/api/place/add/json").then().assertThat().statusCode(200).
		extract().response();
				
		System.out.println("Request is " +response.asString());
		String res = response.asString();
		JsonPath jsonpath = new JsonPath(res);
		System.out.println(jsonpath.get("place_id"));
		

	}


}
