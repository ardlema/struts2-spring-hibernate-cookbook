package org.ardlema.integration;

import junit.framework.TestCase;

import java.net.HttpURLConnection;
import java.net.URL;


public class LoginTestIT extends TestCase
{
    private String baseUrl;

    public void setUp() throws Exception
    {
        super.setUp();
        String port = System.getProperty("servlet.port");
        this.baseUrl = "http://localhost:" + port + "/cookbook/cookbook/Login.jsp";
    }

    public void testCallLoginPage() throws Exception
    {
        URL url = new URL(this.baseUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.connect();
        assertEquals(200, connection.getResponseCode());
    }
}
