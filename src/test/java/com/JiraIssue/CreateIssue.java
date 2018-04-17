package com.JiraIssue;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.Utility.BaseTest;
import com.Utility.PayloadConvertor;
import com.Utility.URL;
import RestAssuredCore.BaseAssertions;
import RestAssuredCore.RESTCalls;
import io.restassured.response.Response;

public class CreateIssue {

	private String sessionID;
	public Response response;
	
	@BeforeMethod
	public void setup() throws IOException{
		sessionID = BaseTest.doLogin();
	}
	
	@Test
	public void createIssue() throws IOException{
		String URI = URL.getEndPoint("/rest/api/2/issue");
		String createIssuePayload = PayloadConvertor.generatePayLoadString("CreateBug.json");
		
		response = RESTCalls.POSTRequest(URI, createIssuePayload, sessionID);
		BaseAssertions.verifyStatuCode(response, 200);
	}
}