package tests.tds;

import base.TestBase;
import io.restassured.response.Response;
import model.*;
import org.testng.annotations.Test;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.sql.SQLException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.testng.Assert.assertEquals;

public class TDSV2NativeOOBAppTest extends TestBase {
    String randomAcsTransId = app.generateRandomNumber(10) + "-integrTest-acsTransid-v2";
    String dsTransId = app.generateRandomNumber(10) + "-integrTest-dsTransId-v2";
    String tranId = null;

    @Test(timeOut = 30000, priority = 1)
    public void test_AReq_TDSServices_acs_bgAuth() throws IOException, SAXException, ParserConfigurationException {
        printCurentThredId();
        String now = app.getTimeStamp("YYYYMMddHHmmss");
        Response res = given()
                .spec(app.requestSpecTDS)
                .body("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                        "<backgroundRequest2>\n" +
                        "   <backgroundAReq>\n" +
                        "      <acsTransID>"+randomAcsTransId+"</acsTransID>\n" +
                        "      <threeDSRequestorAuthenticationInd>01</threeDSRequestorAuthenticationInd>\n" +
                        "      <threeDSRequestorID>1000</threeDSRequestorID>\n" +
                        "      <threeDSRequestorName>integration test</threeDSRequestorName>\n" +
                        "      <threeDSRequestorURL>integration test</threeDSRequestorURL>\n" +
                        "      <threeDSServerRefNumber>3DS_LOA_SER_MOMD_020100_00068</threeDSServerRefNumber>\n" +
                        "      <threeDSServerTransID>56daad02-3752-5a48-8000-0000003ba453</threeDSServerTransID>\n" +
                        "      <threeDSServerURL>integration test</threeDSServerURL>\n" +
                        "      <acquirerBIN>444444</acquirerBIN>\n" +
                        "      <acquirerMerchantID>1000</acquirerMerchantID>\n" +
                        "      <cardExpiryDate>3201</cardExpiryDate>\n" +
                        "      <acctNumber>"+ app.pan +"</acctNumber>\n" +
                        "      <deviceChannel>01</deviceChannel>\n" +
                        "      <deviceInfo>some deviceInfo for integration test</deviceInfo>\n" +
                        "      <deviceRenderOptions>\n" +
                        "         <sdkInterface>01</sdkInterface>\n" +
                        "         <sdkUiType>\n" +
                        "            <uiType>04</uiType>\n" +
                        "         </sdkUiType>\n" +
                        "      </deviceRenderOptions>\n" +
                        "      <dsReferenceNumber>EMVCo1234567</dsReferenceNumber>\n" +
                        "      <dsTransID>"+dsTransId+"</dsTransID>\n" +
                        "      <dsURL>integration test</dsURL>\n" +
                        "      <mcc>1234</mcc>\n" +
                        "      <merchantCountryCode>246</merchantCountryCode>\n" +
                        "      <merchantName>integration test</merchantName>\n" +
                        "      <messageCategory>01</messageCategory>\n" +
                        "      <messageType>AReq</messageType>\n" +
                        "      <messageVersion>2.1.0</messageVersion>\n" +
                        "      <purchaseAmount>4500</purchaseAmount>\n" +
                        "      <purchaseCurrency>840</purchaseCurrency>\n" +
                        "      <purchaseExponent>2</purchaseExponent>\n" +
                        "      <purchaseDate>"+now+"</purchaseDate>\n" +
                        "      <sdkAppID>221477f0-460c-4bb8-b759-a70cc803a753</sdkAppID>\n" +
                        "      <sdkMaxTimeout>05</sdkMaxTimeout>\n" +
                        "      <sdkReferenceNumber>3DSSDK74332823FF</sdkReferenceNumber>\n" +
                        "      <sdkTransID>62bd871a-7ac3-4df0-9e0e-c24d60acb7d2</sdkTransID>\n" +
                        "   </backgroundAReq>\n" +
                        "</backgroundRequest2>")
                .when()
                .post("/TDSServices/acs/bgAuth");

        res.then().log().all().statusCode(200)
                .body("backgroundResponse2.backgroundARes.acsRenderingType.acsInterface", equalTo("01"),
                        "backgroundResponse2.backgroundARes.acsRenderingType.acsUiTemplate", equalTo("04"),
                                "backgroundResponse2.backgroundARes.messageExtension", equalTo(""));

        String response = res.asString();
        System.out.println(res.asString());

        Document document = app.getXmlHelper().initXmlParsing(response);
        BackgroundARes backgroundARes = app.getXmlHelper().parseXmlResponseReturnBackgroundAResObject(document);

        assertEquals(backgroundARes.getAcsTransID(), randomAcsTransId);
        assertEquals(backgroundARes.getAcsChallengeMandated(), "Y");
        assertEquals(backgroundARes.getAuthenticationType(), "03");
        assertEquals(backgroundARes.getMessageType(), "ARes");
        assertEquals(backgroundARes.getMessageVersion(), "2.1.0");
        assertEquals(backgroundARes.getTransStatus(), "C");
    }

    @Test(timeOut = 30000, priority = 2)
    public void test_CReq_TDSServices_acs_bgAuth() throws IOException, SAXException, ParserConfigurationException {
        printCurentThredId();
        Response res = given()
                .spec(app.requestSpecTDS)
                .body("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                        "<backgroundRequest2>\n" +
                        "   <backgroundCReq>\n" +
                        "      <acsTransID>"+randomAcsTransId+"</acsTransID>\n" +
                        "      <messageType>CReq</messageType>\n" +
                        "      <messageVersion>2.1.0</messageVersion>\n" +
                        "      <sdkTransID>62bd871a-7ac3-4df0-9e0e-c24d60acb7d2</sdkTransID>\n" +
                        "      <sdkCounterStoA>000</sdkCounterStoA>\n" +
                        "   </backgroundCReq>\n" +
                        "</backgroundRequest2>")
                .when()
                .post("/TDSServices/acs/bgAuth");

        res.then().log().all().statusCode(200)
                .body("backgroundResponse2.backgroundCRes.InProgressCRes.challengeInfoText", containsString("To confirm the transaction, please open, review and confirm the notification we sent to your up and go App"),
                        "backgroundResponse2.backgroundCRes.InProgressCRes.challengeInfoText", containsString("When done, you need to return to this screen and tap ‘Continue’"));

        String response = res.asString();
        System.out.println(res.asString());

        Document document = app.getXmlHelper().initXmlParsing(response);
        OOBBackgroundCRes oobBackgroundCRes = app.getXmlHelper().parseXmlReturnOOBBackgroundCResObject(document);

        assertEquals(oobBackgroundCRes.getAcsTransID(), randomAcsTransId);
        assertEquals(oobBackgroundCRes.getAcsCounterAtoS(), "000");
        assertEquals(oobBackgroundCRes.getAcsUiType(), "04");
        assertEquals(oobBackgroundCRes.getChallengeInfoHeader(), "Confirm with mobile App");
        //Assert.assertEquals(oobBackgroundCRes.getChallengeInfoText(), "To confirm the transaction, please open, review and confirm the notification we sent to your up and go App" +
        //        "\nWhen done, you need to return to this screen and tap ‘Continue’");
        assertEquals(oobBackgroundCRes.getExpandInfoLabel(), "Don’t have App at hand?");
        assertEquals(oobBackgroundCRes.getExpandInfoText(), "Tap ‘Continue’ and we will send you a confirmation Code by SMS");
        assertEquals(oobBackgroundCRes.getIssuerImage(), "https://dipocket.org/img/dip-logo.png");
        assertEquals(oobBackgroundCRes.getPsImage(), "https://brand.mastercard.com/content/dam/mccom/brandcenter/thumbnails/mc_bc_othermarks_idcheck_thmb.png");
        assertEquals(oobBackgroundCRes.getMessageType(), "CRes");
        assertEquals(oobBackgroundCRes.getMessageVersion(), "2.1.0");
        assertEquals(oobBackgroundCRes.getOobContinueLabel(), "Continue");
        assertEquals(oobBackgroundCRes.getChallengeCompletionInd(), "N");
    }

    @Test(timeOut = 30000, priority = 3)
    public void test_getTransId_TDSTestServices_v1_tranId_v2_txId_randomAcsTransId() {
        printCurentThredId();
        Response res = given()
                .spec(app.requestSpecTDSJson)
                .when()
                .get("/TDSTestServices/v1/tranId.v2?txId=" + randomAcsTransId + "");

        res.then().log().all();
        tranId = res.asString();
        System.out.println("tranId " + tranId);
        assertEquals(res.getStatusCode(), 200);
    }

    @Test(timeOut = 30000, priority = 4)
    public void test_tranAccept_ClientServices_v1_tds_tranId_tranAccept() throws SQLException, ClassNotFoundException {
        printCurentThredId();
        System.out.println("tranId: " + tranId);
        String cliSessionId = app.getLogin_registrationHelper().loginUpAndGo(app.tds_phone, app.tds_pass, app.mobile_login_deviceuuid_tds);
        System.out.println("cliSessionId: " + cliSessionId);
        Response response = given()
                .config(app.configTimeout)
                .auth().preemptive().basic("10_"+app.tds_phone, app.tds_pass)
                .contentType("application/json")
                .header("SITE", app.mobile_site_upAndGo)
                .header("ClISESSIONID", cliSessionId)
                .when()
                .post(app.baseURL + "ClientServices/v1/tds/" + tranId + "/tranAccept");

        response.then().log().all();
        assertEquals(response.getStatusCode(), 200);
    }

    @Test(timeOut = 30000, priority = 5)
    public void test_CReq_TDSServices_acs_bgAuth_() throws IOException, SAXException, ParserConfigurationException {
        printCurentThredId();
        Response res = given()
                .spec(app.requestSpecTDS)
                .body("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                        "<backgroundRequest2>\n" +
                        "   <backgroundCReq>\n" +
                        "      <acsTransID>"+randomAcsTransId+"</acsTransID>\n" +
                        "      <messageType>CReq</messageType>\n" +
                        "      <messageVersion>2.1.0</messageVersion>\n" +
                        "      <oobContinue>true</oobContinue>\n" +
                        "      <sdkTransID>62bd871a-7ac3-4df0-9e0e-c24d60acb7d2</sdkTransID>\n" +
                        "      <sdkCounterStoA>001</sdkCounterStoA>\n" +
                        "   </backgroundCReq>\n" +
                        "</backgroundRequest2>")
                .when()
                .post("/TDSServices/acs/bgAuth");

        res.then().log().all().statusCode(200);
        String response = res.asString();
        System.out.println(res.asString());

        Document document = app.getXmlHelper().initXmlParsing(response);
        FinalCRes finalCRes = app.getXmlHelper().parseXmlResponseReturnFinalCResObject(document);

        assertEquals(finalCRes.getAcsTransID(), randomAcsTransId);
        assertEquals(finalCRes.getMessageType(), "CRes");
        assertEquals(finalCRes.getMessageVersion(), "2.1.0");
        assertEquals(finalCRes.getTransStatus(), "Y");
        assertEquals(finalCRes.getChallengeCompletionInd(), "Y");
    }
}