package Utility;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class TestUtils {
	public  static String getResponseString(Response response){
		String res= response.getBody().asString();
		return res;
		
	}
	
	public  static JsonPath jsonParser(String response){
		JsonPath jsonpath= new JsonPath(response);
		return jsonpath;
		
	}
	
	public static int getResponseCode(Response response){
		int statusCode =response.getStatusCode();
		return statusCode;
	}
	
	public static String getResponseMessage(Response response){
		String statusMessage =response.getStatusLine();
		return statusMessage;
	}

}
