package com.Utility;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PayloadConvertor {

	/*
	 * This method converts the JSON Payload or XML payload it will convert to String 
	 */
	public static String generatePayLoadString(String filename) throws IOException{
		String filePath = System.getProperty("user.dir")+"\\resources\\"+filename;
		
		return new String(Files.readAllBytes(Paths.get(filePath)));
	}
}
