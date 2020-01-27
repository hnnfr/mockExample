package com.hnn.mock.junit;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;

import org.junit.Test;

public class TestWebClient {

	@Test 
	public void testGetContentOk() {
		MockConnectionFactory mockConnectionFactory = new MockConnectionFactory(); 
		mockConnectionFactory.setInputStream(new ByteArrayInputStream("It works".getBytes()));
		
		WebClient client = new WebClient(); 
		String result = client.getContent(mockConnectionFactory); 
		assertEquals("It works", result);
	}
}
