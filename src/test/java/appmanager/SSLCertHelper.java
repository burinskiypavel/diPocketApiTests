package appmanager;

import io.restassured.config.RestAssuredConfig;
import io.restassured.config.SSLConfig;

public class SSLCertHelper {

    public RestAssuredConfig aspspSslConfig = RestAssuredConfig.config().sslConfig(
            SSLConfig.sslConfig()
                    .trustStore("files/certs/truststoreSandboxCompany.jks", "123456").trustStoreType("JKS")
                    .keyStore("files/certs/client_created.p12", "123456").keystoreType("PKCS12")
                    .allowAllHostnames()
    );
}