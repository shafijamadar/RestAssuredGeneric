package com.Utility;

import java.io.IOException;

import RestAssuredCore.RESTCalls;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class BaseTest {

	public static String doLogin() throws IOException{
		
		Response response;
		String loginPayload = PayloadConvertor.generatePayLoadString("JiraLogin.JSON");
		
		String endPointURI = URL.getEndPoint("/rest/auth/1/session");
		
		response = RESTCalls.POSTRequest(endPointURI, loginPayload);
		
		String strResponse = TestUtils.getResponseString(response);
		/*System.out.println("********************Response JSON is**************");
		System.out.println(strResponse);
		*/
		
		JsonPath jsonRes = TestUtils.jsonParser(strResponse);
		
		String sessionID = jsonRes.getString("session.value");
		
	//	System.out.println(sessionID);
		return sessionID;
	
}
}
