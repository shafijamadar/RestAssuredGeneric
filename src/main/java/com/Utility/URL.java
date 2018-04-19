package com.Utility;

public class URL {

	public static String URL = "http://southseasgaming.microgaming.com/";
			//"http://localhost:8080"; 
	public static String SouthseasgamingURI = "http://southseasgaming.microgaming.com/"; 


	public String getEndPoint(){

		return URL;
	}

	public String getEndPoint(String resource){

		URL = URL+ resource;
		System.out.println(URL);
		return URL;
	}

}
