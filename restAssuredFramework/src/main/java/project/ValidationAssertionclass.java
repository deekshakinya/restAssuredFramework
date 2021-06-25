package project;

import org.testng.Assert;

import Utility.TestUtils;
import io.restassured.response.Response;

public class ValidationAssertionclass {
	public static void verifyStatusCode(Response response,int status){
		Assert.assertEquals(TestUtils.getResponseCode(response), status);
		System.out.println("Assertion passed.");
		
	}

}
