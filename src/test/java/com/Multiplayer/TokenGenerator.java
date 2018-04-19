package com.Multiplayer;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Utility.PayloadConvertor;
import com.Utility.TestUtils;
import com.Utility.URL;
import com.Utility.userAuthentication;

import RestAssuredCore.RESTCalls;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class TokenGenerator {


	userAuthentication hostName = new userAuthentication();
	String Username = hostName.setUsername(); 

	String sessionID = null;
	URL url;
	Response response;


	@BeforeMethod
	public void tokenGenerator() throws IOException{
		String requestPayload = PayloadConvertor.generatePayLoadString("MultiplayerLogin.json");

		System.out.println(requestPayload);
		url = new URL();
		String endPointURI = url.getEndPoint("Framework/api/Security/Login");

		response = RESTCalls.POSTRequest(endPointURI, requestPayload);

		System.out.println(response.getStatusCode());
		String strResponse = response.getBody().asString();
		System.out.println("********************Response JSON is**************");
		//	System.out.println(strResponse);

		JsonPath jsonRes = new JsonPath(strResponse);

		sessionID = jsonRes.getString("sessionToken");		
		System.out.println(sessionID);	

	}
	@Test
	public void doLogin() throws IOException{
		sessionID = "UserSession " + sessionID;
		String roundTemplateID = "1";
		String endPointURL = url.getEndPoint("roundTemplates/template/" + roundTemplateID);
		
		System.out.println(endPointURL);
		response = RESTCalls.GETRequest(endPointURL, sessionID);
		
		System.out.println(TestUtils.getStatusCode(response));
		System.out.println(TestUtils.jsonParser(TestUtils.getResponseString(response)));
		
		/*String Username = "DERIW50Z0019@ssg.com"; 
		//String requestPayload = "{" + "\"loginName\": "+Username+","   + "\"password\": \"test\"" + "}";
		String requestPayload = "{" + "\"loginName\": \""+Username+"\""+","   + "\"password\": \"test\"" + "}";
		System.out.println(requestPayload);*/



	}
}

