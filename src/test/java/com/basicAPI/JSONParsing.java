package com.basicAPI;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class JSONParsing {

	@Test
	public void ParsingJson(){
		
	
		RestAssured.baseURI = "https://maps.googleapis.com";
		Response response = 
				given().
				param("location", "-33.8670522,151.1957362").
				param("radius", "500").
				param("type", "restaurant").
				param("key", "AIzaSyB-ZliaFkPtyfykn7E2nW2yxgBPAvRVUMo").
				
				when().
				get("/maps/api/place/nearbysearch/json").
				
				then().
				assertThat().statusCode(200).
				and().
				
				contentType(ContentType.JSON).
				extract().response();
		
		String responseString = response.asString();
			
	//	System.out.println("Request is " +responseString);
		
		
		JsonPath json = new JsonPath(responseString);
		int arraySize = json.getInt("results.size()");
		
		for(int i=0;i < arraySize;i++){
			String name = json.getString("results["+i+"].name");
			System.out.println(name);
		}
	
	}
}
