package com.hnn.mock.junit;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.io.IOException;
import java.io.InputStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestWebClientEasyMock {

	private ConnectionFactory connectionFactory;
	private InputStream stream;
	
	@Before
	public void setUp() {
		connectionFactory = createMock("connectionFactory", ConnectionFactory.class); 
		stream = createMock("stream", InputStream.class);
	}
	
	@Test
	public void testGetContentOk() throws Exception {
		expect(connectionFactory.getData()).andReturn(stream);
		expect(stream.read()).andReturn(new Integer('W'));
		expect(stream.read()).andReturn(new Integer('o'));
		expect(stream.read()).andReturn(new Integer('r'));
		expect(stream.read()).andReturn(new Integer('k'));
		expect(stream.read()).andReturn(new Integer('s'));
		expect(stream.read()).andReturn(new Integer('!'));
		expect(stream.read()).andReturn(-1);
		stream.close();
		
		replay(connectionFactory, stream);
		
		WebClient client = new WebClient();
		String result = client.getContent(connectionFactory);
		
		assertEquals("Works!", result);
	}

	@Test
	public void testGetContentCannotCloseInputStream() throws Exception {
		expect(connectionFactory.getData()).andReturn(stream);
		expect(stream.read()).andReturn(-1);
		stream.close();
		expectLastCall().andThrow(new IOException("cannot close")); 
		
		replay(connectionFactory, stream);
		
		WebClient client = new WebClient();
		String result = client.getContent(connectionFactory);
		
		assertNull(result);
	}
	
	@After
	public void tearDown() {
		verify(connectionFactory, stream);
	}
}
