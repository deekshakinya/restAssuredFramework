package Utility;

public class APIURL {
	public static String url="https://ecommerceservice.herokuapp.com";
	
	public static String endPoint(){
		return url;
	}
	
	public static String endPoint(String resource){
		return url+resource;
	}

}
