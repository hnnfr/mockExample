package com.hnn.mock.junit;

import java.io.IOException;
import java.io.InputStream;

public class MockInputStream extends InputStream {
	
	private String buffer; 
	private int position = 0; 
	private int closeCount = 0; 

	// Tell mock what read method should return
	public void setBuffer(String buffer) {
		this.buffer = buffer;
	}

	@Override
	public int read() throws IOException {
		if (position == buffer.length()) return -1; 
		return buffer.charAt(position++);
	}

	// Count number of time close is called
	@Override
	public void close() throws IOException {
		closeCount++;
		super.close();
	}

	public void verify() {
		if (closeCount != 1) {
			throw new AssertionError("close() should have been called once and only once.");
		}
	}
	
}
