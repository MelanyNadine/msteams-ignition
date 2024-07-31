package com.inductiveautomation.ignition.msteams.gateway;

import com.inductiveautomation.ignition.msteams.common.MsteamsModule;

import java.util.HashMap;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class GatewayMsteamsModule extends MsteamsModule{
	
	@Override
    protected String postImpl(String arg0, String arg1) {
		String requestResponse = new String();
		
		  try {
			HttpClient client = HttpClient.newBuilder().build();
			
		    String urlString = arg0;
		    
		    //String payload = "{\"title\":\""+arg1+"\",\"userId\": \"7\"}";
		    String payload = "{\r\n"
		    		+ "	  	\"type\": \"message\",\r\n"
		    		+ "	  	\"attachments\": [\r\n"
		    		+ "	    {\r\n"
		    		+ "	      \"contentType\": \"application/vnd.microsoft.card.adaptive\",\r\n"
		    		+ "	      \"content\": {\r\n"
		    		+ "	        \"type\": \"AdaptiveCard\",\r\n"
		    		+ "	        \"body\": [\r\n"
		    		+ "	          {\r\n"
		    		+ "	            \"type\": \"TextBlock\",\r\n"
		    		+ "	            \"text\": \""+arg1+"\"\r\n"
		    		+ "	          }\r\n"
		    		+ "	        ],\r\n"
		    		+ "	        \"$schema\": \"http://adaptivecards.io/schemas/adaptive-card.json\",\r\n"
		    		+ "	        \"version\": \"1.0\"\r\n"
		    		+ "	      }\r\n"
		    		+ "	    }\r\n"
		    		+ "	  ]\r\n"
		    		+ "	}";
		    
		    HttpRequest request = HttpRequest.newBuilder()
		    		.uri(URI.create(urlString))
		    		.header("Content-Type", "application/json")
		    		.POST(HttpRequest.BodyPublishers.ofString(payload))
		    		.build();
		    
		    HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());	
		    
		    if (response.statusCode()==202) {
		    	requestResponse = "Request accepted. " + response.body();
		    }
		    
		  } catch (Exception e) {
		    e.printStackTrace();
		}
        return requestResponse;
    }
}
