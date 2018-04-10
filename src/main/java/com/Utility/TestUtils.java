package com.Utility;

import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class TestUtils {

	public static String getResponseString(Response response){
		String strResponse = response.getBody().asString();
		return strResponse;
	}
	
	public static JsonPath jsonParser(String response){
		JsonPath jsonResponse = new JsonPath(response);
		return jsonResponse;	
	}
	
	public static XmlPath xmlParser(String response){
		XmlPath xmlResponse = new XmlPath(response);
		return xmlResponse;	
	}
	
	public static int getStatusCode(Response response){
		int statusCode = response.getStatusCode();
		return statusCode;
	}
	
	public static String getStatusMessage(Response response){
		String statusMessage = response.getStatusLine();
		return statusMessage;
	}
}
