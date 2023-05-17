package tests.bankIntegration.aspspApi.ais;

import base.TestBase;
import io.restassured.config.RestAssuredConfig;
import io.restassured.config.SSLConfig;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class AISCreateConsentRequest  extends TestBase {

//    @BeforeTest
//    public void setUp(){
//        javax.net.ssl.HttpsURLConnection.setDefaultHostnameVerifier( new javax.net.ssl.HostnameVerifier() {
//            public boolean verify(String hostname, javax.net.ssl.SSLSession sslSession) {
//                if (hostname.equals("https://client.badssl.com")) {
//                    return true; }
//                return false; }
//        } );

//        RestAssured.config = RestAssured.config().sslConfig(
//                SSLConfig.sslConfig().with()
//                        .trustStore("truststore", "abcd@1234")
//                        .trustStoreType("PKCS12")
//                        .keyStore("badssl.com-client.p12", "badssl.com")
//                        .keystoreType("PKCS12")
//        );
   // }

    @Test(priority = 0)
    public void websiteBadSSLTest(){
        System.setProperty("com.sun.net.ssl.checkRevocation", "false");

        RestAssuredConfig sslConfig = RestAssuredConfig.config().sslConfig(
                SSLConfig.sslConfig()
                        .trustStore("files/certs/truststoreRootX1", "123456").trustStoreType("JKS")
                        .keyStore("files/certs/badssl.com-client.p12", "badssl.com").keystoreType("PKCS12"));
        //SSLFix.execute();

        given()
                .contentType(ContentType.HTML)
                .config(sslConfig)
                .when()
                .get("https://client.badssl.com")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test(priority = 3)
    public void cofGetConsentStatusTest(){
        RestAssuredConfig sslConfig = RestAssuredConfig.config().sslConfig(
                SSLConfig.sslConfig()
                        .trustStore("files/certs/truststoreSandboxCompany.jks", "123456").trustStoreType("JKS")
                        .keyStore("files/certs/client_created.p12", "123456").keystoreType("PKCS12")
                        .allowAllHostnames()
        );


        given()
                .contentType(ContentType.HTML)
                .config(sslConfig)
                .header("X-Request-ID", "b463a960-9616-4df6-909f-f80884190c22")
                .header("TPP-Redirect-URI", "http://www.google.com")
                .when()
                .get("https://openbanking.dipocket.site:3443/654321/bg/v2/consents/confirmation-of-funds/0e0dbc12-9c47-4f54-a06a-fcd8a750b19c/status")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test(priority = 1)
    public void test_AISCreateConsentRequest()  {
        RestAssuredConfig sslConfig = RestAssuredConfig.config().sslConfig(
                SSLConfig.sslConfig()
                        .trustStore("files/certs/truststoreSandboxCompany.jks", "123456").trustStoreType("JKS")
                        .keyStore("files/certs/client_created.p12", "123456").keystoreType("PKCS12")
                        .allowAllHostnames()
        );

        given()
                .log().uri().log().headers().log().body()
                .contentType("application/json")
                .config(sslConfig)
                .header("X-Request-ID", "b463a960-9616-4df6-909f-f80884190c22")
                .header("TPP-Redirect-URI", "https://www.google.com")
                .header("TPP-Nok-Redirect-URI", "https://luxhelsinki.fi")
                .body("{\n" +
                        "    \"access\": {\n" +
                        "        \"balances\": [ \n" +
                        "            \n" +
                        "        ],\n" +
                        "        \"transactions\": [\n" +
                        "            \n" +
                        "        ]\n" +
                        "    },\n" +
                        "    \"recurringIndicator\": true,\n" +
                        "    \"validUntil\": \"2023-05-17\"\n" +
                        "   \n" +
                        "}")
                .post("https://openbanking.dipocket.site:3443/654321/bg/v1/consents/")
                .then().log().all()
                .statusCode(200);
    }

    @Test
    public void cof(){
        RestAssuredConfig sslConfig = RestAssuredConfig.config().sslConfig(
                SSLConfig.sslConfig()
                        .trustStore("files/certs/truststoreSandboxCompany.jks", "123456").trustStoreType("JKS")
                        .keyStore("files/certs/client_created.p12", "123456").keystoreType("PKCS12")
                        .allowAllHostnames()
        );

        given()
                .log().uri().log().headers().log().body()
                .config(sslConfig)
                .header("X-Request-ID", "b463a960-9616-4df6-909f-f80884190c22")
                .header("TPP-Redirect-URI", "https://www.google.com")
                .header("TPP-Nok-Redirect-URI", "https://luxhelsinki.fi/")
                .contentType("application/json")
                .body("{\n" +
                        "    \"account\": {\n" +
                        "        \"iban\": \"EE657777000012110759\"\n" +
                        "    }\n" +
                        "}")
                .post("https://openbanking.dipocket.site:3443/654321/bg/v2/consents/confirmation-of-funds")
                .then().log().all()
                .statusCode(200);
    }
}