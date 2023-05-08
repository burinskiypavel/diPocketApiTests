package requests.aspsp;

import appmanager.HelperBase;
import appmanager.SSLCertHelper;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class ConsentsRequests {
    SSLCertHelper sslCertHelper = new SSLCertHelper();

    //protected final ApplicationManager app = new ApplicationManager();

    public RequestSpecification requestSpecConsents = given()
            .log().uri().log().headers().log().body()
            //.basePath("")
            .baseUri("https://openbanking.dipocket.site")
            .port(3443);

    public RequestSpecification requestSpecConsentsTest = given()
            .log().uri().log().headers().log().body()
            .basePath("BOServices")
            .contentType("application/json");

    public void clientServices_v1_clientProfile_changeCardholderName(String cliSessionId, String phone, String pass, String newCardHolderName){
        given()
                //.spec(requestSpecDipocketHomePage)
                .auth().preemptive().basic(phone, pass)
                .baseUri(HelperBase.prop.getProperty("mobile.base.url"))
                .header("clisessionid", ""+cliSessionId+"")
                .header("content-type", "application/json")
                .body("{\n" +
                        "  \"value\" : \""+newCardHolderName+"\"\n" +
                        "}")
                .when()
                .post("clientProfile/changeCardholderName")
                .then().log().all()
                .statusCode(200);
    }

    public String partnerId_bg_v1_consents(String json) {
        String response = given()
                .log().uri().log().headers().log().body()
                .config(sslCertHelper.aspspSslConfig)
                //.baseUri(HelperBase.prop.getProperty("mobile.base.url"))
                .header("X-Request-ID", "b463a960-9616-4df6-909f-f80884190c22")
                .header("TPP-Redirect-URI", "https://www.google.com")
                .header("TPP-Nok-Redirect-URI", "https://luxhelsinki.fi")
                .contentType("application/json")
                .body(json)
//                .body("{\n" +
//                        "    \"access\": {\n" +
//                        "        \"balances\": [\n" +
//                        "            \n" +
//                        "        ],\n" +
//                        "        \"transactions\": [\n" +
//                        "            \n" +
//                        "        ]\n" +
//                        "    },\n" +
//                        "    \"recurringIndicator\": true,\n" +
//                        "    \"validUntil\": \"2023-05-17\"\n" +
//                        "}")
                .post("https://openbanking.dipocket.site:3443/654321/bg/v1/consents/")
                .then().log().all()
                .statusCode(200).extract().response().asString();
        return response;
    }
}