package org.aidas.app.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import org.apache.commons.io.IOUtils;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;

/**
 * The Class HttpClientUtil.
 */
public class HttpClientUtil {

	/** The Constant logger. */
	private static final Logger logger = LoggerFactory.getLogger(HttpClientUtil.class);
	
	private static final String USER_AGENT = "Mozilla/5.0";
	
	/** The Constant SOCKET_TIMEOUT. */
	public static final Integer SOCKET_TIMEOUT = 5000;
	
	/** The Constant CONNECTION_TIMEOUT. */
	public static final Integer CONNECTION_TIMEOUT = 10000;
	
	/** The Constant CONNECTION_REQUEST_TIMEOUT. */
	public static final Integer CONNECTION_REQUEST_TIMEOUT = 10000;
	
	/**
	 * Post request.
	 *
	 * @param jsonInput the json input
	 * @return the string
	 */
	public static String postRequest(String jsonInput) {
		
		logger.debug("jsonInput : "+jsonInput);
		InputStream inputStream = null;
		
		String jsonResponse = null;
		
		final CloseableHttpClient httpClient = HttpClients.createDefault();
		
		final String serviceUrl = CommonUtil.getPropertyValue("enliven.crypt.service.url");
		
		try {
		logger.debug("serviceUrl : "+serviceUrl);
		
			HttpPost httpPost = new HttpPost(serviceUrl);
		    httpPost.addHeader("User-Agent", USER_AGENT);
		    httpPost.addHeader("Accept-Language", "en");
		    RequestConfig requestConfig = RequestConfig.custom()
		    		  .setSocketTimeout(SOCKET_TIMEOUT)
		    		  .setConnectTimeout(CONNECTION_TIMEOUT)
		    		  .setConnectionRequestTimeout(CONNECTION_REQUEST_TIMEOUT)
		    		  .build();

		    httpPost.setConfig(requestConfig);
		 
		    StringEntity entity = new StringEntity(jsonInput);
		    entity.setContentType(MediaType.APPLICATION_JSON_VALUE);
		    httpPost.setEntity(entity);
		    httpPost.setHeader("Accept", MediaType.APPLICATION_JSON_VALUE);
		    httpPost.setHeader("Content-type", MediaType.APPLICATION_JSON_VALUE);
		
		    CloseableHttpResponse response = httpClient.execute(httpPost);
		    if(response.getStatusLine().getStatusCode() == 200 || response.getStatusLine().getStatusCode() == 202){
		    	inputStream = response.getEntity().getContent();
		    	jsonResponse = IOUtils.toString(inputStream);
		    }
			httpClient.close();
		} catch (UnsupportedEncodingException e) {
			logger.error("UnsupportedEncodingException : "+e.getMessage());
		} catch (ClientProtocolException e) {
			logger.error("ClientProtocolException : "+e.getMessage());
		} catch (IOException e) {
			logger.error("IOException : "+e.getMessage());
		}
		logger.debug("jsonResponse : "+jsonResponse);
		return jsonResponse;
	}
}
