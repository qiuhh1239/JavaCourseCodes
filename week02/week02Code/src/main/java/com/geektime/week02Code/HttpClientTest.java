package com.geektime.week02Code;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HttpClientTest {


	public static void main(String[] args) throws ClientProtocolException, IOException {
		// TODO Auto-generated method stub

		String httpUrl = "http://localhost:8081";
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(httpUrl);
		CloseableHttpResponse response1 = httpclient.execute(httpGet);
		
		try {
		    
		    System.out.println(response1.getProtocolVersion());
			System.out.println(response1.getStatusLine().getStatusCode());
			System.out.println(response1.getStatusLine().getReasonPhrase());
			System.out.println(response1.getStatusLine().toString());
			
		    HttpEntity myEntity = response1.getEntity();
		    
		    if (myEntity != null) {
		        long len = myEntity.getContentLength();
		        if (len != -1 ) {
		            System.out.println(EntityUtils.toString(myEntity));
		        } else {
		        	System.out.println("error");
		        }
		    }
		    EntityUtils.consume(myEntity);
		} finally {
		    response1.close();
		}
		
	
	}

}
