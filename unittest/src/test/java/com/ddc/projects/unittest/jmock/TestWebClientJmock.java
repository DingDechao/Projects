package com.ddc.projects.unittest.jmock;

import com.ddc.projects.unittest.mocks.web.ConnectionFactory;
import com.ddc.projects.unittest.mocks.web.WebClient2;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.jmock.lib.legacy.ClassImposteriser;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(JMock.class)
public class TestWebClientJmock {

    private Mockery mockery = new JUnit4Mockery(){{
        setImposteriser(ClassImposteriser.INSTANCE);
    }};

    @Test
    public void testGetContentOk() throws Exception{
        final ConnectionFactory connectionFactory = mockery.mock(ConnectionFactory.class);
        final InputStream inputStream = mockery.mock(InputStream.class);

        mockery.checking(new Expectations(){{
            oneOf(connectionFactory).getData();
            will(returnValue(inputStream));

            atLeast(1).of(inputStream).read();
            will(onConsecutiveCalls(returnValue(new Integer((byte) 'W')),
                                    returnValue(new Integer((byte) 'o')),
                                    returnValue(new Integer((byte) 'r')),
                                    returnValue(new Integer((byte) 'k')),
                                    returnValue(new Integer((byte) 'i')),
                                    returnValue(new Integer((byte) 'n')),
                                    returnValue(new Integer((byte) 'g')),
                                    returnValue(-1)
                    ));
            oneOf(inputStream).close();
        }});

        WebClient2 webClient2 = new WebClient2();
        String result = webClient2.getContent(connectionFactory);

        assertEquals( "Working", result );
    }

    @Test
    public void testGetContentCannotCloseInputStream() throws Exception {

        final ConnectionFactory connectionFactory = mockery.mock(ConnectionFactory.class);
        final InputStream inputStream = mockery.mock(InputStream.class);

        mockery.checking(new Expectations() {{
                oneOf(connectionFactory).getData();
                will(returnValue(inputStream));
                oneOf(inputStream).read();
                will(returnValue(-1));
                oneOf(inputStream).close();
                will(throwException(new IOException( "cannot close" )));
            }
        } );

        WebClient2 webClient2 = new WebClient2();

        String result = webClient2.getContent(connectionFactory);

        assertNull(result);
    }
}
