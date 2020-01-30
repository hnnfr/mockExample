package com.hnn.mock.junit.webclient;

import java.io.InputStream;

public interface ConnectionFactory {
	InputStream getData() throws Exception;
}
