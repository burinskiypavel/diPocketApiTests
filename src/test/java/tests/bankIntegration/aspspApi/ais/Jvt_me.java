package tests.bankIntegration.aspspApi.ais;

import base.TestBase;
import io.restassured.RestAssured;
import io.restassured.config.RestAssuredConfig;
import io.restassured.config.SSLConfig;
import io.restassured.specification.RequestSpecification;
import java.io.FileInputStream;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import org.apache.http.HttpStatus;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.testng.annotations.Test;

public class Jvt_me  {
    /*
     * Example code
     */

    @Test
    public static void clientCertWithKeyStore()
            throws UnrecoverableKeyException, NoSuchAlgorithmException, KeyStoreException,
            KeyManagementException {
        clientCertSpecification(
                "/path/to/keystore.jks",
                "keystore-pass")
                .log()
                .all()
                .get("https://client.badssl.com/")
                .then()
                .log()
                .all()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public static void clientCertWithTrustStoreBadSSl()
            throws UnrecoverableKeyException, NoSuchAlgorithmException, KeyStoreException,
            KeyManagementException {
        clientCertSpecification(
                "files/certs/badssl.com-client.p12",
                "badssl.com",
                "files/certs/truststore3",
                "123456")
                .log()
                .all()
                .get("https://client.badssl.com/")
                .then()
                .log()
                .all()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public static void clientCertWithTrustStore()
            throws UnrecoverableKeyException, NoSuchAlgorithmException, KeyStoreException,
            KeyManagementException {
        clientCertSpecification(
                "files/certs/clientKeystore.p12",
                "123456",
                "files/certs/truststore5",
                "123456")
                .log().all()
                .header("X-Request-ID", "b463a960-9616-4df6-909f-f80884190c22")
                .header("TPP-Redirect-URI", "http://www.google.com")
                .header("TPP-Nok-Redirect-URI", "https://luxhelsinki.fi/")
                .body("{\n" +
                        "    \"account\": {\n" +
                        "        \"iban\": \"EE657777000012110759\"\n" +
                        "    }\n" +
                        "}")
                .post("https://openbanking.dipocket.site:3443/654321/bg/v2/consents/confirmation-of-funds")
                .then()
                .log()
                .all()
                .statusCode(HttpStatus.SC_OK);
    }

    /*
     * Helper methods
     */

    private static RequestSpecification clientCertSpecification(
            String keyStorePath, String keyStorePass)
            throws UnrecoverableKeyException, NoSuchAlgorithmException, KeyStoreException,
            KeyManagementException {
        return clientCertSpecification(keyStorePath, keyStorePass, null, null);
    }

    private static RequestSpecification clientCertSpecification(
            String keyStorePath, String keyStorePass, String trustStorePath, String trustStorePass)
            throws UnrecoverableKeyException, NoSuchAlgorithmException, KeyStoreException,
            KeyManagementException {
        return clientCertSpecification(
                keyStorePath,
                keyStorePass,
                KeyStore.getDefaultType(),
                trustStorePath,
                trustStorePass,
                KeyStore.getDefaultType());
    }

    private static RequestSpecification clientCertSpecification(
            String keyStorePath,
            String keyStorePass,
            String keyStoreType,
            String trustStorePath,
            String trustStorePass,
            String trustStoreType)
            throws UnrecoverableKeyException, NoSuchAlgorithmException, KeyStoreException,
            KeyManagementException {

        KeyStore keyStore = loadKeyStore(keyStorePath, keyStorePass.toCharArray(), keyStoreType);
        SSLSocketFactory clientAuthFactory = new SSLSocketFactory(keyStore, keyStorePass);
        if (null != trustStorePath) {
            KeyStore trustStore =
                    loadKeyStore(trustStorePath, trustStorePass.toCharArray(), trustStoreType);
            clientAuthFactory = new SSLSocketFactory(keyStore, keyStorePass, trustStore);
        }

        SSLConfig sslConfig =
                RestAssuredConfig.config().getSSLConfig().with().sslSocketFactory(clientAuthFactory);
        RestAssuredConfig config = RestAssured.config().sslConfig(sslConfig);

        return RestAssured.given().config(config);
    }

    private static KeyStore loadKeyStore(String path, char[] password, String storeType) {
        KeyStore keyStore;
        try {
            keyStore = KeyStore.getInstance(storeType);
            keyStore.load(new FileInputStream(path), password);
        } catch (Exception ex) {
            throw new RuntimeException("Error while extracting the keystore", ex);
        }
        return keyStore;
    }

    private static KeyStore loadKeyStore(String path, char[] password) {
        return loadKeyStore(path, password, KeyStore.getDefaultType());
    }
}
