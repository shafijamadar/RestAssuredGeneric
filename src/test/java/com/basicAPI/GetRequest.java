package com.basicAPI;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class GetRequest {
	
	// BaseURI
	public static String baseURI = "https://maps.googleapis.com/";
	

	@Test
	public static void searchPlace(){
		
		RestAssured.baseURI  = baseURI;
		
		given().
			param("location", "-33.8670522,151.1957362").
			param("radius", "500").
			param("type", "restuarant").
			param("key","").when().get("/maps/api/nearbysearch/json").
			then().assertThat().statusCode(200);
		
	}
}
