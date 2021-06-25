package testRest;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Utility.APIURL;
import Utility.TestUtils;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import project.BaseTest;
import project.RestCalls;
import project.ValidationAssertionclass;

public class TestAPI {
	public String accessToken;
	public static String id;                   
	Response response;
	@BeforeTest
	public void setUp() throws IOException{
		accessToken = BaseTest.login();
		Assert.assertNotNull(accessToken);
		System.out.println("Login in and fetched accesstoken successfully.");
	}

	
	@Test()
	public void getAllUsers(){
		String endpoint=APIURL.endPoint("/user");
		response = RestCalls.getRequestWithHeader(endpoint, accessToken);
		
		String res= TestUtils.getResponseString(response);
		System.out.println("Response :"+ res);
		JsonPath jsonRes = TestUtils.jsonParser(res);
		id = jsonRes.getString("users[4]._id");
		System.out.println("ID :"+ id);
		ValidationAssertionclass.verifyStatusCode(response,200);
	}
	
	@Test(dependsOnMethods="getAllUsers")
	public void deleteUser(){
		String endpoint =APIURL.endPoint("/user/"+id);
		System.out.println("URL :"+endpoint);
		response =RestCalls.deleteRequestWithHeader(endpoint, accessToken);
		String res =TestUtils.getResponseString(response);
		System.out.println("Response :"+ res);
		ValidationAssertionclass.verifyStatusCode(response,200); 
		
	}
}
