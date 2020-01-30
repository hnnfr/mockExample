package com.hnn.mock.junit.webclient;

import java.io.InputStream;

import com.hnn.mock.junit.webclient.ConnectionFactory;

public class MockConnectionFactory implements ConnectionFactory {
	
	private InputStream inputStream; 
	
	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	@Override
	public InputStream getData() throws Exception {
		return inputStream;
	}

}
