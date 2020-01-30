package com.hnn.mock.junit.webclient;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.hnn.mock.junit.webclient.WebClient;

public class TestWebClientWithExpectation {

	@Test 
	public void testGetContentOk() {
		MockConnectionFactory mockConnectionFactory = new MockConnectionFactory();
		MockInputStream mockInputStream = new MockInputStream(); 
		mockInputStream.setBuffer("It works");
		mockConnectionFactory.setInputStream(mockInputStream);
		
		WebClient client = new WebClient(); 
		String result = client.getContent(mockConnectionFactory); 
		assertEquals("It works", result);
		
		mockInputStream.verify();
	}
}
