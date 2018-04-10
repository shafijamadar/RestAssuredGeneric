package com.Utility;

public class URL {

	public static String URL = "http://localhost:8080"; // 

	public static String getEndPoint(){

		return URL;
	}

	public static String getEndPoint(String resource){

		URL = URL+ resource;
		System.out.println(URL);
		return URL;
	}

}
