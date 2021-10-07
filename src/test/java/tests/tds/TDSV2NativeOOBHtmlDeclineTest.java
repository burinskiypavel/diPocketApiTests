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
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.testng.Assert.assertEquals;

public class TDSV2NativeOOBHtmlDeclineTest extends TestBase {
    String randomAcsTransId = app.generateRandomNumber(10) + "-integrTest-acsTransid-v2";
    String dsTransId = app.generateRandomNumber(10) + "-integrTest-dsTransId-v2";
    String tranId = null;

    @Test(priority = 1)
    public void test_AReq_DiPocket3ds_acs_bgAuth() throws IOException, SAXException, ParserConfigurationException {
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
                        "      <threeDSServerTransID>b2bd1f48-4e2b-5331-8000-0000003bba47</threeDSServerTransID>\n" +
                        "      <threeDSServerURL>integration test</threeDSServerURL>\n" +
                        "      <acquirerBIN>444444</acquirerBIN>\n" +
                        "      <acquirerMerchantID>1000</acquirerMerchantID>\n" +
                        "      <cardExpiryDate>3205</cardExpiryDate>\n" +
                        "      <acctNumber>"+ app.pan +"</acctNumber>\n" +
                        "      <deviceChannel>01</deviceChannel>\n" +
                        "      <deviceInfo>some device info for integration test</deviceInfo>\n" +
                        "      <deviceRenderOptions>\n" +
                        "         <sdkInterface>01</sdkInterface>\n" +
                        "         <sdkUiType>\n" +
                        "            <uiType>05</uiType>\n" +
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
                        "      <purchaseAmount>4900</purchaseAmount>\n" +
                        "      <purchaseCurrency>840</purchaseCurrency>\n" +
                        "      <purchaseExponent>2</purchaseExponent>\n" +
                        "      <purchaseDate>"+now+"</purchaseDate>\n" +
                        "      <sdkAppID>221477f0-460c-4bb8-b759-a70cc803a753</sdkAppID>\n" +
                        "      <sdkMaxTimeout>05</sdkMaxTimeout>\n" +
                        "      <sdkReferenceNumber>3DSSDK74332823FF</sdkReferenceNumber>\n" +
                        "      <sdkTransID>58b5d144-83ab-4a8e-9ec3-d304ee91ab8d</sdkTransID>\n" +
                        "   </backgroundAReq>\n" +
                        "</backgroundRequest2>")
                .when()
                .post("/DiPocket3ds/acs/bgAuth");

        res.then().log().all().statusCode(200)
                .body("backgroundResponse2.backgroundARes.acsRenderingType.acsInterface", equalTo("02"),
                        "backgroundResponse2.backgroundARes.acsRenderingType.acsUiTemplate", equalTo("05"),
                                "backgroundResponse2.backgroundARes.messageExtension", equalTo(""));

        String response = res.asString();
        System.out.println(res.asString());

        Document document = app.getXmlHelper().initXmlParsing(response);
        BackgroundARes backgroundARes = app.getXmlHelper().parseXmlResponseReturnBackgroundAResObject(document);

        assertEquals(backgroundARes.getAcsTransID(), randomAcsTransId);
        assertEquals(backgroundARes.getAcsChallengeMandated(), "Y");
        assertEquals(backgroundARes.getAuthenticationType(), "02");
        assertEquals(backgroundARes.getMessageType(), "ARes");
        assertEquals(backgroundARes.getMessageVersion(), "2.1.0");
        assertEquals(backgroundARes.getTransStatus(), "C");
    }

    @Test(priority = 2)
    public void test_CReq_DiPocket3ds_acs_bgAuth() throws IOException, SAXException, ParserConfigurationException {
        Response res = given()
                .spec(app.requestSpecTDS)
                .body("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                        "<backgroundRequest2>\n" +
                        "   <backgroundCReq>\n" +
                        "      <acsTransID>"+randomAcsTransId+"</acsTransID>\n" +
                        "      <messageType>CReq</messageType>\n" +
                        "      <messageVersion>2.1.0</messageVersion>\n" +
                        "      <sdkTransID>58b5d144-83ab-4a8e-9ec3-d304ee91ab8d</sdkTransID>\n" +
                        "      <sdkCounterStoA>000</sdkCounterStoA>\n" +
                        "   </backgroundCReq>\n" +
                        "</backgroundRequest2>")
                .when()
                .post("/DiPocket3ds/acs/bgAuth");

        res.then().log().all().statusCode(200);
        String response = res.asString();
        System.out.println(res.asString());

        Document document = app.getXmlHelper().initXmlParsing(response);
        OOBBackgroundCRes oobBackgroundCRes = app.getXmlHelper().parseXmlReturnOOBBackgroundCResObject_NativeOOOBHtml(document);

        List<Entry> listEnty = app.getXmlHelper().parseXmlSetNameSetValueFromEntryAddThemToCollection(document);

        System.out.println(listEnty);
        //System.out.println(backgroudResponse);

        String masName[] = {"TXID", "CONFIRM_TITLE", "SMS_SWITCH_MESSAGE", "CONFIRM_MESSAGE", "CONFIRM_MESSAGE_DONE", "SMS_MESSAGE", "CONTINUE_TEXT"};
        String masValue[] = {randomAcsTransId, "Confirm with mobile App", "Don’t have App at hand?", "To confirm the transaction, please open, review and confirm the notification we sent to your up and go App", "When done, you need to return to this screen and tap ‘Continue’", "Tap ‘Continue’ and we will send you a confirmation Code by SMS", "Continue"};

        app.getXmlHelper().checkTextInCollectionEntryName(listEnty, masName);
        app.getXmlHelper().checkTextInCollectionEntryValue(listEnty, masValue);
        assertEquals(oobBackgroundCRes.getAcsTransID(), randomAcsTransId);
        assertEquals(oobBackgroundCRes.getAcsCounterAtoS(), "000");
        assertEquals(oobBackgroundCRes.getAcsUiType(), "05");
        assertEquals(oobBackgroundCRes.getMessageType(), "CRes");
        assertEquals(oobBackgroundCRes.getMessageVersion(), "2.1.0");
        assertEquals(oobBackgroundCRes.getPageId(), "bio-oob.html");
        assertEquals(oobBackgroundCRes.getChallengeCompletionInd(), "N");
    }

    @Test(priority = 3)
    public void test_getTransId_TDSTestServices_v1_tranId_v2_txId_randomAcsTransId() {
        Response res = given()
                .config(app.configTimeout)
                .contentType("application/json")
                .when()
                .get("http://dipocket3.intranet:8092/TDSTestServices/v1/tranId.v2?txId=" + randomAcsTransId + "");

        res.then().log().all();
        tranId = res.asString();
        System.out.println("tranId " + tranId);
        assertEquals(res.getStatusCode(), 200);
    }

    @Test(priority = 4)
    public void test_tranDecline_ClientServices_v1_tds_tranId_tranDecline() throws SQLException, ClassNotFoundException {
        String cliSessionId = app.getLogin_registrationHelper().loginUpAndGo(app.tds_phone, app.tds_pass, app.mobile_login_deviceuuid_tds);
        System.out.println("cliSessionId: " + cliSessionId);
        Response response = given()
                .config(app.configTimeout)
                .auth().preemptive().basic("10_"+app.tds_phone, app.tds_pass)
                .contentType("application/json")
                .header("SITE", app.mobile_site_upAndGo)
                .header("ClISESSIONID", cliSessionId)
                .when()
                .post("https://dipocket3.intranet:8900/ClientServices/v1/tds/" + tranId + "/tranDecline");

        response.then().log().all();
        assertEquals(response.getStatusCode(), 200);
    }

    @Test(priority = 5)
    public void test_CReq_DiPocket3ds_acs_bgAuth_() throws IOException, SAXException, ParserConfigurationException {
        Response res = given()
                .spec(app.requestSpecTDS)
                .body("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                        "<backgroundRequest2>\n" +
                        "   <backgroundCReq>\n" +
                        "      <acsTransID>"+randomAcsTransId+"</acsTransID>\n" +
                        "      <challengeHTMLDataEntry>BIO_AUTH=OK</challengeHTMLDataEntry>\n" +
                        "      <messageType>CReq</messageType>\n" +
                        "      <messageVersion>2.1.0</messageVersion>\n" +
                        "      <sdkTransID>58b5d144-83ab-4a8e-9ec3-d304ee91ab8d</sdkTransID>\n" +
                        "      <sdkCounterStoA>001</sdkCounterStoA>\n" +
                        "   </backgroundCReq>\n" +
                        "</backgroundRequest2>")
                .when()
                .post("/DiPocket3ds/acs/bgAuth");

        res.then().log().all().statusCode(200);
        String response = res.asString();
        System.out.println(res.asString());

        Document document = app.getXmlHelper().initXmlParsing(response);
        FinalCResDecline finalCResDecline = app.getXmlHelper().parseXmlResponseReturnFinalCResDeclineObject(document);

        assertEquals(finalCResDecline.getAcsTransID(), randomAcsTransId);
        assertEquals(finalCResDecline.getMessageType(), "CRes");
        assertEquals(finalCResDecline.getMessageVersion(), "2.1.0");
        assertEquals(finalCResDecline.getTransStatus(), "N");
        assertEquals(finalCResDecline.getTransStatusReason(), "26");
        assertEquals(finalCResDecline.getChallengeCompletionInd(), "Y");
    }
}