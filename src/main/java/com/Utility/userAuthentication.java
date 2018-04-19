package com.Utility;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class userAuthentication {

		
		public String getHostName(){
					
			InetAddress ip;
			String hostname = null;
			
			try{
				ip = InetAddress.getLocalHost();
				hostname = ip.getHostName();
			}catch (UnknownHostException e){
				e.getMessage();
			}
			return hostname;	
		}
		
		public String setUsername(){
			String hostName = getHostName();
			String Username = null;
			Username = hostName+"@ssg.com"; 
			System.out.println(Username);	
			return Username.trim();
		}
	}

	
