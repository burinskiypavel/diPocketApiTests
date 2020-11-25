import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.net.ssl.SSLContext;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

public class UnirestTest {

    @Test
    public void test1() throws KeyStoreException, NoSuchAlgorithmException, KeyManagementException, UnirestException {
        //unirest ssl
        SSLContext sslcontext = SSLContexts.custom()
                .loadTrustMaterial(null, new TrustSelfSignedStrategy())
                .build();

        SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslcontext,SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
        CloseableHttpClient httpclient = HttpClients.custom()
                .setSSLSocketFactory(sslsf)
                .build();
        Unirest.setHttpClient(httpclient);

        // unirest 2
        HttpResponse<JsonNode> postResponse = Unirest.put("https://dipocket3.intranet:8900/ClientServices/v1/userRegistration/registrationSavePoint2?value=com.cs.dipocketback.pojo.registration.RegSavepointData@7ae86ada")
                .header("site", "DIPOCKET")
                .header("deviceuuid", "eC10LFCnS1mDsuNoQaa-KH")
                .header("Content-Type", "application/json")
                .body("{\n" +
                        "  \"deviceUUID\" : \"eC10LFCnS1mDsuNoQaa-KH\",\n" +
                        "  \"langId\" : 4,\n" +
                        "  \"mainPhone\" : \"380685448615\",\n" +
                        "  \"stepNo\" : 1,\n" +
                        "  \"registeredAddrAsmail\" : true,\n" +
                        "  \"address\" : {\n" +
                        "    \"typeId\" : 0\n" +
                        "  },\n" +
                        "  \"regAddress\" : {\n" +
                        "    \"typeId\" : 3\n" +
                        "  },\n" +
                        "  \"attachedCardsList\" : [ ],\n" +
                        "  \"smsCode\" : \"336052\",\n" +
                        "  \"isSkipped\" : false,\n" +
                        "  \"address1\" : {\n" +
                        "    \"typeId\" : 0\n" +
                        "  },\n" +
                        "  \"attachedCardIds\" : [ ]\n" +
                        "}")
                .asJson();
        //.asString();
        //.getBody();
        System.out.println(postResponse.getBody());
        //bearer = postResponse.getBody().getObject().getString("bearer");
        //System.out.println("bearer " + postResponse.getBody().getObject().getString("bearer"));
        Assert.assertNotNull(postResponse.getBody());
        //Assert.assertEquals("Success", postResponse.getBody().getObject().getString("authStatus"));
    }
}
