package tests.tds;

import base.TestBase;
import io.restassured.response.Response;
import model.*;
import org.testng.annotations.Test;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.testng.Assert.assertEquals;

public class TDSV2BrowserAppDeclineTest extends TestBase {
    String randomAcsTransId = app.generateRandomNumber(10) + "-integrTest-acsTransid-v2";
    String dsTransId = app.generateRandomNumber(10) + "-integrTest-dsTransId-v2";
    String tranId = null;

    @Test(priority = 59)
    public void test_AReq_DiPocket3ds_acs_bgAuth() throws IOException, SAXException, ParserConfigurationException {
        Response res = given()
                .spec(app.requestSpecTDS)
                .body("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                        "<backgroundRequest2>\n" +
                        "   <backgroundAReq>\n" +
                        "      <acsTransID>" + randomAcsTransId + "</acsTransID>\n" +
                        "      <threeDSCompInd>Y</threeDSCompInd>\n" +
                        "      <threeDSRequestorAuthenticationInd>01</threeDSRequestorAuthenticationInd>\n" +
                        "      <threeDSRequestorID>1000</threeDSRequestorID>\n" +
                        "      <threeDSRequestorName>integration test</threeDSRequestorName>\n" +
                        "      <threeDSRequestorURL>integration test</threeDSRequestorURL>\n" +
                        "      <threeDSServerRefNumber>3DS_LOA_SER_MOMD_020100_00068</threeDSServerRefNumber>\n" +
                        "      <threeDSServerTransID>85cd7a75-deb1-5934-8000-0000003b9495</threeDSServerTransID>\n" +
                        "      <threeDSServerURL>integration test</threeDSServerURL>\n" +
                        "      <acquirerBIN>444444</acquirerBIN>\n" +
                        "      <acquirerMerchantID>1000</acquirerMerchantID>\n" +
                        "      <browserAcceptHeader>text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9</browserAcceptHeader>\n" +
                        "      <browserIP>123.456.789.10</browserIP>\n" +
                        "      <browserJavaEnabled>false</browserJavaEnabled>\n" +
                        "      <browserLanguage>ru-RU</browserLanguage>\n" +
                        "      <browserColorDepth>24</browserColorDepth>\n" +
                        "      <browserScreenHeight>1200</browserScreenHeight>\n" +
                        "      <browserScreenWidth>1920</browserScreenWidth>\n" +
                        "      <browserTZ>-120</browserTZ>\n" +
                        "      <browserUserAgent>Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.130 Safari/537.36</browserUserAgent>\n" +
                        "      <cardExpiryDate>3210</cardExpiryDate>\n" +
                        "      <acctNumber>" +app.pan + "</acctNumber>\n" +
                        "      <deviceChannel>02</deviceChannel>\n" +
                        "      <dsReferenceNumber>EMVCo1234567</dsReferenceNumber>\n" +
                        "      <dsTransID>" + dsTransId + "</dsTransID>\n" +
                        "      <dsURL>integration test</dsURL>\n" +
                        "      <mcc>0000</mcc>\n" +
                        "      <merchantCountryCode>246</merchantCountryCode>\n" +
                        "      <merchantName>integration test</merchantName>\n" +
                        "      <messageCategory>01</messageCategory>\n" +
                        "      <messageType>AReq</messageType>\n" +
                        "      <messageVersion>2.1.0</messageVersion>\n" +
                        "      <notificationURL>integration test</notificationURL>\n" +
                        "      <purchaseAmount>6000</purchaseAmount>\n" +
                        "      <purchaseCurrency>840</purchaseCurrency>\n" +
                        "      <purchaseExponent>2</purchaseExponent>\n" +
                        "      <purchaseDate>20200303145453</purchaseDate>\n" +
                        "   </backgroundAReq>\n" +
                        "</backgroundRequest2>")
                .when()
                .post("/DiPocket3ds/acs/bgAuth");

        res.then().log().all().statusCode(200).
                body("backgroundResponse2.backgroundARes.messageExtension", equalTo(""));
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

    @Test(priority = 60)
    public void test_CReq_DiPocket3ds_acs_bgAuth() throws IOException, SAXException, ParserConfigurationException {
        Response res = given()
                .spec(app.requestSpecTDS)
                .body("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                        "<backgroundRequest2>\n" +
                        "   <backgroundCReq>\n" +
                        "      <acsTransID>" + randomAcsTransId + "</acsTransID>\n" +
                        "      <challengeWindowSize>03</challengeWindowSize>\n" +
                        "      <messageType>CReq</messageType>\n" +
                        "      <messageVersion>2.1.0</messageVersion>\n" +
                        "   </backgroundCReq>\n" +
                        "</backgroundRequest2>")
                .when()
                .post("/DiPocket3ds/acs/bgAuth");

        res.then().log().all().statusCode(200);
        String response = res.asString();
        System.out.println(res.asString());

        Document document = app.getXmlHelper().initXmlParsing(response);
        BackgroundCRes backgroudCres = app.getXmlHelper().parseXmlResponseReturnBackgroundCResObject(document);
        List<Entry> listEnty = app.getXmlHelper().parseXmlSetNameSetValueFromEntryAddThemToCollection(document);

        System.out.println(listEnty);
        //System.out.println(backgroudResponse);

        String masName[] = {"TXID", "CONFIRM_TITLE", "SMS_SWITCH_MESSAGE", "CONFIRM_MESSAGE", "CONFIRM_MESSAGE_DONE", "SMS_MESSAGE", "CANCEL_TEXT"};
        String masValue[] = {randomAcsTransId, "Confirm with mobile App", "Don’t have App at hand?", "To confirm the transaction, please open, review and confirm the notification we sent to your up and go App", "When done, you need to return to this screen and tap ‘Continue’", "Confirm with SMS code", "Cancel"};

        app.getXmlHelper().checkTextInCollectionEntryName(listEnty, masName);
        app.getXmlHelper().checkTextInCollectionEntryValue(listEnty, masValue);
        assertEquals(backgroudCres.getAcsTransID(), randomAcsTransId);
        assertEquals(backgroudCres.getMessageType(), "CRes");
        assertEquals(backgroudCres.getMessageVersion(), "2.1.0");
        assertEquals(backgroudCres.getPageId(), "bio-web.html");
        assertEquals(backgroudCres.getChallengeCompletionInd(), "N");
    }

    @Test(priority = 61)
    public void test_tranStatus_DiPocket3ds_acs_tranStatus() {
        given()
                .contentType("application/json")
                .body("{\n" +
                        "\t\"txId\" : \"" + randomAcsTransId + "\"\n" +
                        "}")
                .when()
                .post(app.TDSBaseUrl+"/DiPocket3ds/acs/tranStatus")
                .then().log().all()
                .statusCode(200)
                .body("value", equalTo("AWAITING"));
    }

    @Test(priority = 62)
    public void test_getTransId_TDSTestServices_v1_tranId_v2_txId_randomAcsTransId() {
        Response res = given()
                .contentType("application/json")
                .when()
                .get("http://dipocket3.intranet:8092/TDSTestServices/v1/tranId.v2?txId=" + randomAcsTransId + "");

        res.then().log().all();
        tranId = res.asString();
        System.out.println("tranId " + tranId);
        assertEquals(res.getStatusCode(), 200);
    }

    @Test(priority = 63)
    public void test_tranDecline_ClientServices_v1_tds_tranId_tranDecline() {
        String cliSessionId = app.getDbHelper().getDateFromFileDef("files\\tds\\cliSessionId.txt");
        System.out.println("cliSessionId: " + cliSessionId);
        Response response = given()
                .auth().preemptive().basic("10_"+app.tds_phone, app.tds_pass)
                .contentType("application/json")
                .header("SITE", app.mobile_site_upAndGo)
                .header("ClISESSIONID", cliSessionId)
                .when()
                .post("https://dipocket3.intranet:8900/ClientServices/v1/tds/" + tranId + "/tranDecline");

        response.then().log().all();
        assertEquals(response.getStatusCode(), 200);
    }

    @Test(priority = 64)
    public void test_tranStatus_DiPocket3ds_acs_tranStatus_() {
        given()
                .contentType("application/json")
                .body("{\n" +
                        "\t\"txId\" : \"" + randomAcsTransId + "\"\n" +
                        "}")
                .when()
                .post(app.TDSBaseUrl+"/DiPocket3ds/acs/tranStatus")
                .then().log().all()
                .statusCode(200)
                .body("value", equalTo("DECLINED"));
    }

    @Test(priority = 65)
    public void test_CReq_DiPocket3ds_acs_bgAuth_() throws IOException, SAXException, ParserConfigurationException {
        Response res = given()
                .spec(app.requestSpecTDS)
                .body("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                        "<backgroundRequest2>\n" +
                        "   <backgroundCReq>\n" +
                        "      <acsTransID>" + randomAcsTransId + "</acsTransID>\n" +
                        "      <challengeWindowSize>03</challengeWindowSize>\n" +
                        "      <messageType>CReq</messageType>\n" +
                        "      <messageVersion>2.1.0</messageVersion>\n" +
                        "      <backgroundPageResponse>\n" +
                        "         <pageId>bio-web.html</pageId>\n" +
                        "         <values>\n" +
                        "            <entry>\n" +
                        "               <name>TXID</name>\n" +
                        "               <value>" + randomAcsTransId + "</value>\n" +
                        "            </entry>\n" +
                        "            <entry>\n" +
                        "               <name>BIO_AUTH</name>\n" +
                        "               <value>DECLINED</value>\n" +
                        "            </entry>\n" +
                        "         </values>\n" +
                        "      </backgroundPageResponse>\n" +
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