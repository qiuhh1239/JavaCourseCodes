package com.geektime.week03Code.HttpClientRequest;

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

		String httpUrl = "http://localhost:80";
		
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(httpUrl);
		CloseableHttpResponse response = httpclient.execute(httpGet);
		
		try {
			
		    System.out.println(response.getProtocolVersion());
			System.out.println(response.getStatusLine().getStatusCode());
			System.out.println(response.getStatusLine().getReasonPhrase());
			System.out.println(response.getStatusLine().toString());
			
		    HttpEntity myEntity = response.getEntity();
		    
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
		    response.close();
		}
	}

}
