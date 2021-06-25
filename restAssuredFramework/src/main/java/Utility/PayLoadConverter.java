package Utility;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PayLoadConverter {
	
	public static  String generatePayLoadString(String fileName) throws IOException{
		//String filePath="C:\\Users\\DeekshaKinya\\workspace\\restAssuredFramework\\src\\test\\resources\\JsonFiles\\"+fileName;
		String filePath=System.getProperty("user.dir")+"\\src\\test\\resources\\JsonFiles\\"+ fileName;        
		return new String(Files.readAllBytes(Paths.get(filePath)));
	}

}
