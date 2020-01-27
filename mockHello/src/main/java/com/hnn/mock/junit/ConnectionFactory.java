package com.hnn.mock.junit;

import java.io.InputStream;

public interface ConnectionFactory {
	InputStream getData() throws Exception;
}
