package com.basicAPI;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class DemoClass {

	public static void main(String[] args) {
		
			
			RestAssured.baseURI = "https://maps.googleapis.com";
			given().
			 param("location", "-33.8670522,151.1957362").
			 param("radius", "500").
			 param("type", "restaurant").
			 param("key", "AIzaSyB-ZliaFkPtyfykn7E2nW2yxgBPAvRVUMo").
			 when().
			 get("/maps/api/place/nearbysearch/json").
			 then().assertThat().statusCode(200).and().
			 contentType(ContentType.XML);
			
			/*.and().
			 body("results[0].name", equalTo("The Little Snail Restaurant")).and().
			 body("results[13].name", equalTo("Harvest Buffet")).and().
			 body("results[5].vicinity", equalTo("80 Pyrmont Street, Pyrmont")).and().
			 header("server", "pablo");*/
			
			System.out.println("Request is " );
		}
}
