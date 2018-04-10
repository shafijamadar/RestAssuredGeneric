package RestAssuredCore;

import org.testng.Assert;

import com.Utility.TestUtils;

import io.restassured.response.Response;

public class BaseAssertions {

	public static void verifyTrue(boolean flag){
		Assert.assertTrue(flag);
	}
	
	public static void verifyFalse(boolean flag){
		Assert.assertFalse(flag);
	}
	
	public static void verifyStatuCode(Response response, int statusCode){
		Assert.assertEquals(TestUtils.getStatusCode(response), statusCode);
	}
	
	public static void verifyStatuMessage(Response response, String statusMessage){
		Assert.assertEquals(TestUtils.getStatusMessage(response), statusMessage);
	}
}
