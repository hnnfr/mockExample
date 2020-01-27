package com.hnn.mock.junit;

import java.io.InputStream;

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
