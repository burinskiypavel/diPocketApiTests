package tests.bankIntegration.aspspApi.ais;

import java.io.FileInputStream;
import java.io.InputStream;
import java.security.KeyStore;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.SingleClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
//import org.codehaus.plexus.util.IOUtil;

/**
 * This example demonstrates how to create secure connections with a custom SSL
 * context.
 */
public class clientCustomSSLTest {

    public final static void main(String[] args) throws Exception {

        String   trustStorePath="C:/cert/truststore.jks";
        String   trustStorePassword="changeit";

        String   keyStorePath="C:/cert/client.p12";

        String   keyStorePassword="password1";



        // keystore has the certificates presented to the server when a server
        // requests one to authenticate this application to the server
//        System.setProperty("javax.net.ssl.keyStore", keyStorePath);
//        System.setProperty("javax.net.ssl.keyStorePassword", keyStorePassword);

        KeyStore keystore = KeyStore.getInstance("pkcs12");
        InputStream keystoreInput = new FileInputStream(keyStorePath);
        keystore.load(keystoreInput, keyStorePassword.toCharArray());
        System.out.println("Keystore has " + keystore.size() + " keys");

        // trustStore has the certificates that are presented by the server that
        // this application is to trust
//        System.setProperty("javax.net.ssl.trustStore", trustStorePath);
//        System.setProperty("javax.net.ssl.trustStorePassword", trustStorePassword);

        KeyStore truststore = KeyStore.getInstance(KeyStore.getDefaultType());
        InputStream truststoreInput = new FileInputStream(trustStorePath);
        truststore.load(truststoreInput, trustStorePassword.toCharArray());
        System.out.println("Truststore has " + truststore.size() + " keys");


        SchemeRegistry schemeRegistry = new SchemeRegistry();
        SSLSocketFactory lSchemeSocketFactory = new SSLSocketFactory(keystore, keyStorePassword, truststore);
        schemeRegistry.register(new Scheme("https", 8443, lSchemeSocketFactory));

        final HttpParams httpParams = new BasicHttpParams();
        DefaultHttpClient lHttpClient = new DefaultHttpClient(new SingleClientConnManager(schemeRegistry), httpParams);

        String lUrl = "https://someserver:8443/customer";

        HttpGet lMethod = new HttpGet(lUrl);
//        "NAP-User-Credentials", "test:THIS,THAT")
        lMethod.setHeader("NAP-User-Credentials", "test:THIS,THAT");

        HttpResponse lHttpResponse = lHttpClient.execute(lMethod);

        System.out.println("Response status code: " + lHttpResponse.getStatusLine().getStatusCode());

        System.out.println("Response " + EntityUtils.toString(lHttpResponse.getEntity()) );


    }
}