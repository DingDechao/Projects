package com.ddc.projects.unittest.easymock;

import com.ddc.projects.unittest.mocks.web.ConnectionFactory;
import com.ddc.projects.unittest.mocks.web.WebClient2;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;

import static org.easymock.EasyMock.expect;
import static org.easymock.classextension.EasyMock.createMock;
import static org.easymock.classextension.EasyMock.replay;
import static org.junit.Assert.assertEquals;

public class TestWebClientWithEasyMock {

    private ConnectionFactory connectionFactory;

    private InputStream inputStream;

    @Before
    public void setUp() {
        connectionFactory = createMock("connectionFactory", ConnectionFactory.class);
        inputStream = createMock("inputStream", InputStream.class);
    }

    @Test
    public void testGetContentOk() throws Exception {
        expect(connectionFactory.getData()).andReturn(inputStream);
        expect(inputStream.read()).andReturn(new Integer((byte) 'W'));
        expect(inputStream.read()).andReturn(new Integer((byte) 'o'));
        expect(inputStream.read()).andReturn(new Integer((byte) 'r'));
        expect(inputStream.read()).andReturn(new Integer((byte) 'k'));
        expect(inputStream.read()).andReturn(new Integer((byte) 'i'));
        expect(inputStream.read()).andReturn(new Integer((byte) 'n'));
        expect(inputStream.read()).andReturn(new Integer((byte) 'g'));
        expect(inputStream.read()).andReturn(-1);

        inputStream.close();

        replay(connectionFactory);
        replay(inputStream);

        WebClient2 webClient2 = new WebClient2();
        String result = webClient2.getContent(connectionFactory);

        assertEquals("Working", result);
    }

}
