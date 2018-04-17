package com.TestCases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.Utility.PayloadConvertor;
import com.Utility.URL;

import RestAssuredCore.RESTCalls;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class JiraAPI {

	Response response;
	@Test
	public void doLogin() throws IOException{
		String loginPayload = PayloadConvertor.generatePayLoadString("JiraLogin.JSON");
		
		System.out.println(loginPayload);
		
		String endPointURI = URL.getEndPoint("/rest/auth/1/session");
		
		response = RESTCalls.POSTRequest(endPointURI, loginPayload);
		
		System.out.println(response.getStatusCode());
		String strResponse = response.getBody().asString();
		System.out.println("********************Response JSON is**************");
		System.out.println(strResponse);
		
		JsonPath jsonRes = new JsonPath(strResponse);
		
		String sessionID = jsonRes.getString("session.value");
		
		System.out.println(sessionID);
				
	}
}
