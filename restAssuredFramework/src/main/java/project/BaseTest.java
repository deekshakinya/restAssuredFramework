package project;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.testng.annotations.Test;

import Utility.APIURL;
import Utility.PayLoadConverter;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import project.RestCalls;

public class BaseTest {
	static Response response;
		
	@Test(priority =0)
	public static String login() throws IOException{
		String endpointUrl= APIURL.endPoint("/user/login");
		String loginPayload=PayLoadConverter.generatePayLoadString("Login.json");
		response = RestCalls.postRequest(endpointUrl, loginPayload);
		
		String resBody= response.getBody().asString();
		JsonPath jsonRes= new JsonPath(resBody);
		String accessToken =jsonRes.getString("accessToken");
		return accessToken;
		             
	}

}
