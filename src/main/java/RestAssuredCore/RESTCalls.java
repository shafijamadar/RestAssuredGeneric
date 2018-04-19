package RestAssuredCore;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RESTCalls {

	/*
	 * This class is responsible to fire requests
	 */
	public static Response GETRequest(String URI, String token){

		//RequestSepcification is an interface 

		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.contentType(ContentType.JSON);
		requestSpecification.header("Authorisation", token);
		Response response = requestSpecification.get(URI);
		return response;
	}

	public static Response POSTRequest(String URI, String strJSON){

		RequestSpecification requestSpecification = RestAssured.given().body(strJSON);
		requestSpecification.contentType(ContentType.JSON);
		Response response = requestSpecification.post(URI);
		return response;
	}
	
	public static Response POSTRequest(String URI, String strJSON, String sessionID){

		RequestSpecification requestSpecification = RestAssured.given().body(strJSON);

		requestSpecification.contentType(ContentType.JSON);
		requestSpecification.header("cookie", "JSESSIONID=" +sessionID+"" );

		Response response = requestSpecification.post(URI);
		return response;
	}

	public static Response PUTRequest(String URI, String strJSON, String sessionID){

		RequestSpecification requestSpecification = RestAssured.given().body(strJSON);

		requestSpecification.contentType(ContentType.JSON);
		requestSpecification.header("cookie", "JSESSIONID=" +sessionID+"" );

		Response response = requestSpecification.put(URI);
		return response;
	}

	public static Response DELETERequest(String URI, String strJSON){

		RequestSpecification requestSpecification = RestAssured.given().body(strJSON);

		requestSpecification.contentType(ContentType.JSON);

		Response response = requestSpecification.delete(URI);
		return response;
	}
}
