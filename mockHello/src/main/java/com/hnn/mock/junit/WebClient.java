package com.hnn.mock.junit;

import java.io.InputStream;

public class WebClient {
	
	public String getContent(ConnectionFactory connectionFactory) {
		StringBuilder content = new StringBuilder(); 
		try {
			InputStream is = connectionFactory.getData();
			int count; 
			while (-1 != (count = is.read())) {
				content.append(new String(Character.toChars(count))); 
			}
		} catch (Exception e) {
			return null;
		} 
		return content.toString();
	}

//	public String getContent(URL url) {
//		StringBuilder content = new StringBuilder(); 
//		try {
//			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//			connection.setDoInput(true);
//			InputStream is = connection.getInputStream(); 
//			byte[] buffer = new byte[2048]; 
//			int count; 
//			while (-1 != (count = is.read(buffer))) {
//				content.append(new String(buffer, 0, count)); 
//			}
//		} catch (IOException e) {
//			return null; 
//		} 
//		return content.toString();
//	}
}
