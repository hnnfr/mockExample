package com.hnn.mock.junit.webclient;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.io.IOException;
import java.io.InputStream;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.jmock.lib.legacy.ClassImposteriser;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.hnn.mock.junit.webclient.ConnectionFactory;
import com.hnn.mock.junit.webclient.WebClient;

@RunWith(JMock.class)
public class TestWebClientJMock {
	
	private Mockery context = new JUnit4Mockery() {
		{
			setImposteriser(ClassImposteriser.INSTANCE);
		}
	};
	
	private ConnectionFactory factory; 
	private InputStream mockStream;
	
	@Before
	public void setUp() {
		factory = context.mock(ConnectionFactory.class); 
		mockStream = context.mock(InputStream.class);
	}
	
	@Test
	public void testGetContentOk() throws Exception {
		
		context.checking(new Expectations() {
			{
				oneOf(factory).getData();
				will(returnValue(mockStream));
				
				atLeast(1).of(mockStream).read();
				will(onConsecutiveCalls(
						returnValue(new Integer('W')), 
						returnValue(new Integer('o')), 
						returnValue(new Integer('r')), 
						returnValue(new Integer('k')), 
						returnValue(new Integer('s')), 
						returnValue(new Integer('!')), 
						returnValue(-1)));
				oneOf(mockStream).close();
			}
		});
		
		WebClient client = new WebClient();
		String result = client.getContent(factory);
		
		assertEquals("Works!", result);
	}
	
	@Test
	public void testGetContectCannotCloseInputStream() throws Exception {
		context.checking(new Expectations() {
			{
				oneOf(factory).getData();
				will(returnValue(mockStream));
				oneOf(mockStream).read();
				will(returnValue(-1)); 
				oneOf(mockStream).close();
				will(throwException(new IOException("cannot close")));
			}
		});
		
		WebClient client = new WebClient();
		String result = client.getContent(factory);
		
		assertNull(result);
	}
}
