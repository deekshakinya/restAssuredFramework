package project;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestCalls {

	public static Response getRequest(String uri){
		RequestSpecification reqSpecififcation=RestAssured.given();
		reqSpecififcation.contentType(ContentType.JSON);
		Response resp=reqSpecififcation.get(uri);
		return resp;
	}
	
	public static Response getRequestWithHeader(String uri,String accessToken){
		RequestSpecification reqSpecififcation=RestAssured.given();
		reqSpecififcation.contentType(ContentType.JSON);
		reqSpecififcation.header("Authorization","bearer "+accessToken);
		Response resp=reqSpecififcation.get(uri);
		return resp;
	}
	
	public static Response postRequest(String uri,String strJson){
		RequestSpecification reqSpecififcation=RestAssured.given().body(strJson);
		reqSpecififcation.contentType(ContentType.JSON);
		Response resp=reqSpecififcation.post(uri);
		return resp;
	}
	
	
	public static Response putRequest(String uri,String strJson){
		RequestSpecification reqSpecififcation=RestAssured.given().body(strJson);
		reqSpecififcation.contentType(ContentType.JSON);
		Response resp=reqSpecififcation.put(uri);
		return resp;
	}
	
	public static Response deleteRequest(String uri,String strJson){
		RequestSpecification reqSpecififcation=RestAssured.given().body(strJson);
		reqSpecififcation.contentType(ContentType.JSON);
		Response resp=reqSpecififcation.delete(uri);
		return resp;
	}
	
	public static Response deleteRequestWithHeader(String uri, String accessToken){
		RequestSpecification reqSpecififcation=RestAssured.given();
		reqSpecififcation.contentType(ContentType.JSON);
		reqSpecififcation.header("Authorization","bearer "+accessToken);//.log().all();to log the message in console
		Response resp=reqSpecififcation.delete(uri);
		return resp;
	}
	
}
