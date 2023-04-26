package tests.bankIntegration.aspspApi.ais;

import base.TestBase;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.testng.annotations.Test;


import static kong.unirest.Unirest.config;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class UnirestTest extends TestBase {

    @Test
    public void shouldReturnStatusOkay() throws UnirestException {
        HttpResponse<JsonNode> jsonResponse
                = Unirest.get("http://www.mocky.io/v2/5a9ce37b3100004f00ab5154")
                .header("accept", "application/json").queryString("apiKey", "123")
                .asJson();

        assertNotNull(jsonResponse.getBody());
        assertEquals(200, jsonResponse.getStatus());
    }

    @Test
    public void badssl() throws UnirestException {
        //config()
          //      .clientCertificateStore("files/certs/badssl.com-client.p12", "badssl.com");

        config().verifySsl(false);
        HttpResponse<JsonNode> jsonResponse
                = Unirest.get("https://client.badssl.com")
                .header("ContentType", "application/json")
                .asJson();

        assertNotNull(jsonResponse.getBody());
        assertEquals(200, jsonResponse.getStatus());
    }
}