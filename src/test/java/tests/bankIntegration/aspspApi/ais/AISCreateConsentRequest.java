package tests.bankIntegration.aspspApi.ais;

import base.TestBase;
import io.restassured.RestAssured;
import io.restassured.config.RestAssuredConfig;
import io.restassured.config.SSLConfig;
import io.restassured.http.ContentType;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;
import org.openqa.selenium.Beta;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.net.ssl.*;
///import javax.xml.ws.Response;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.*;
import java.security.cert.CertificateException;

import static io.restassured.RestAssured.given;

public class AISCreateConsentRequest  extends TestBase {

    @BeforeTest
    public void setUp(){
        javax.net.ssl.HttpsURLConnection.setDefaultHostnameVerifier( new javax.net.ssl.HostnameVerifier() {
            public boolean verify(String hostname, javax.net.ssl.SSLSession sslSession) {
                if (hostname.equals("https://client.badssl.com")) {
                    return true; }
                return false; }
        } );

//        RestAssured.config = RestAssured.config().sslConfig(
//                SSLConfig.sslConfig().with()
//                        .trustStore("truststore", "abcd@1234")
//                        .trustStoreType("PKCS12")
//                        .keyStore("badssl.com-client.p12", "badssl.com")
//                        .keystoreType("PKCS12")
//        );
    }

    @Test(priority = 0)
    public void websiteBadSSLTest(){
//        RestAssured.config = RestAssured.config().sslConfig(SSLConfig.sslConfig()
//                .trustStore("badssl.com-client.p12", "badssl.com").trustStoreType("JKS")
//                .keyStore("badssl.com-client.p12", "badssl.com").keystoreType("PKCS12"));

        System.setProperty("com.sun.net.ssl.checkRevocation", "false");

        RestAssuredConfig sslConfig = RestAssuredConfig.config().sslConfig(
                SSLConfig.sslConfig()
                        .trustStore("files/certs/truststoreRootX1", "123456").trustStoreType("JKS")
                        .keyStore("files/certs/badssl.com-client.p12", "badssl.com").keystoreType("PKCS12"));
        SSLFix.execute();

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
        //String certificatesTrustStorePath = "<JAVA HOME>/lib/security/cacerts";
        //System.setProperty("javax.net.ssl.trustStore", certificatesTrustStorePath);

        RestAssuredConfig sslConfig = RestAssuredConfig.config().sslConfig(
                SSLConfig.sslConfig()
                        .trustStore("files/certs/truststoreSandboxCompany.jks", "123456").trustStoreType("JKS")
                        .keyStore("files/certs/client_created.p12", "123456").keystoreType("PKCS12")
                        .allowAllHostnames()
        );


        RestAssuredConfig sslConfig2 = RestAssuredConfig.config().sslConfig(
                SSLConfig.sslConfig()
                        .trustStore("files/certs/truststoreSandboxCompany.jks", "123456").trustStoreType("JKS")
                        .keyStore("files/certs/client_.p12", "123456").keystoreType("PKCS12"));


        //System.setProperty("com.sun.net.ssl.checkRevocation", "false");



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
    public void test_AISCreateConsentRequest() throws KeyStoreException, IOException, NoSuchAlgorithmException, KeyManagementException, CertificateException {
        RestAssuredConfig sslConfig = RestAssuredConfig.config().sslConfig(
                SSLConfig.sslConfig()
                        .trustStore("files/certs/truststore5", "123456").trustStoreType("JKS")
                        .keyStore("files/certs/client_.p12", "123456").keystoreType("PKCS12")
                       // .relaxedHTTPSValidation()
        );

        RestAssuredConfig sslConfig2 = RestAssured.config().sslConfig(
                new SSLConfig()
                        .trustStore("files/certs/trustStore.p12", "123456")
                        .keyStore("files/certs/client_.p12", "123456"));













//        String clientCertificatePath = "certs/ClientCertificate.p12";
//        String trustStorePath = "C:/Program Files/Java/jre1.8.0_91/lib/security/cacerts";
//        String trustStorePassword = "changeit"; // default trust store password
//
//        KeyStore clientStore = KeyStore.getInstance("PKCS12");
//        clientStore.load(new FileInputStream(clientCertificatePath), clientPassword.toCharArray());
//
//        KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
//        kmf.init(clientStore, clientPassword.toCharArray());
//        KeyManager[] kms = kmf.getKeyManagers();
//
//        KeyStore trustStore = KeyStore.getInstance("JKS");
//        trustStore.load(new FileInputStream(trustStorePath), trustStorePassword.toCharArray());
//
//        TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
//        tmf.init(trustStore);
//        TrustManager[] tms = tmf.getTrustManagers();
//
//        SSLContext sslContext = null;
//        sslContext = SSLContext.getInstance("TLS");
//        sslContext.init(kms, tms, new SecureRandom());
//
//        SSLSocketFactory lSchemeSocketFactory=null;
//
//        lSchemeSocketFactory = new SSLSocketFactory(clientStore, clientPassword, trustStore);
//
//// configure Rest Assured
//        RestAssured.config = RestAssured.config().sslConfig(sslConfig().with().sslSocketFactory(lSchemeSocketFactory).and().allowAllHostnames());











//        KeyStore keyStore = null;
//        SSLConfig config = null;
//
//        try {
//            keyStore = KeyStore.getInstance("PKCS12");
//            keyStore.load(
//                    new FileInputStream("certs/client_cert_and_private.p12"),
//                    password.toCharArray());
//
//        } catch (Exception ex) {
//            System.out.println("Error while loading keystore >>>>>>>>>");
//            ex.printStackTrace();
//        }
//
//        if (keyStore != null) {
//
//            org.apache.http.conn.ssl.SSLSocketFactory clientAuthFactory = new org.apache.http.conn.ssl.SSLSocketFactory(keyStore, password);
//
//            // set the config in rest assured
//            config = new SSLConfig().with().sslSocketFactory(clientAuthFactory).and().allowAllHostnames();
//
//            RestAssured.config = RestAssured.config().sslConfig(config);
        given()
                //.auth().certificate("", "")
                //.relaxedHTTPSValidation()
                .log().uri().log().headers().log().body()
                .contentType("application/json")
                .config(sslConfig2)
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
                //.relaxedHTTPSValidation()
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
                .post("https://openbanking.dipocket.site:3443/654321/bg/v1/consents/")
                .then().log().all()
                .statusCode(200);
    }
}