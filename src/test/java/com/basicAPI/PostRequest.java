package com.basicAPI;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.equalTo;

public class PostRequest {

	@Test
	public void verifyResponse(){
		
		RestAssured.baseURI = "https://maps.googleapis.com";
		
		String payload = "{"+
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
		
		System.out.println(payload);
		given().
		queryParam("key", "AIzaSyB-ZliaFkPtyfykn7E2nW2yxgBPAvRVUMo").
		body("{"+
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
				"}").
		when().post("/maps/api/place/add/json").then().assertThat().statusCode(200).and().body("status", equalTo("OK"));		
		System.out.println("Request is " );
	}


}
