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

public class TDSV2NativeSmsHtmlAcceptTest extends TestBase {
    String randomAcsTransId = app.generateRandomNumber(10) + "-integrTest-acsTransid-v2";
    String dsTransId = app.generateRandomNumber(10) + "-integrTest-dsTransId-v2";
    String tranId = null;
    String now = app.getTimeStamp("YYYYMMddHHmmss");
    String now2 = app.getTimeStamp("dd.MM.YYYY HH:mm");
    String sms = null;

    @Test(priority = 1)
    public void test_AReq_TDSServices_acs_bgAuth() throws IOException, SAXException, ParserConfigurationException {
        printCurentThredId();
        String pan4TestSMS = "5455980666358066";
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
                        "      <threeDSServerTransID>5b72c04e-7d15-5cb4-8000-0000003bb8df</threeDSServerTransID>\n" +
                        "      <threeDSServerURL>integration test</threeDSServerURL>\n" +
                        "      <acquirerBIN>444444</acquirerBIN>\n" +
                        "      <acquirerMerchantID>1000</acquirerMerchantID>\n" +
                        "      <cardExpiryDate>3205</cardExpiryDate>\n" +
                        "      <acctNumber>"+pan4TestSMS+"</acctNumber>\n" +
                        "      <deviceChannel>01</deviceChannel>\n" +
                        "      <deviceInfo>some device info</deviceInfo>\n" +
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
                        "      <purchaseAmount>4700</purchaseAmount>\n" +
                        "      <purchaseCurrency>840</purchaseCurrency>\n" +
                        "      <purchaseExponent>2</purchaseExponent>\n" +
                        "      <purchaseDate>"+now+"</purchaseDate>\n" +
                        "      <sdkAppID>221477f0-460c-4bb8-b759-a70cc803a753</sdkAppID>\n" +
                        "      <sdkMaxTimeout>05</sdkMaxTimeout>\n" +
                        "      <sdkReferenceNumber>3DSSDK74332823FF</sdkReferenceNumber>\n" +
                        "      <sdkTransID>ebf18e48-6863-46f8-b480-f8c439e436a1</sdkTransID>\n" +
                        "   </backgroundAReq>\n" +
                        "</backgroundRequest2>")
                .when()
                .post("/TDSServices/acs/bgAuth");

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
                        "      <sdkTransID>ebf18e48-6863-46f8-b480-f8c439e436a1</sdkTransID>\n" +
                        "      <sdkCounterStoA>000</sdkCounterStoA>\n" +
                        "   </backgroundCReq>\n" +
                        "</backgroundRequest2>")
                .when()
                .post("/TDSServices/acs/bgAuth");

        res.then().log().all().statusCode(200)
                .body("backgroundResponse2.backgroundCRes.InProgressCRes.acsCounterAtoS", equalTo("000"),
                        "backgroundResponse2.backgroundCRes.InProgressCRes.acsUiType", equalTo("05"));

        String response = res.asString();
        System.out.println(res.asString());

        Document document = app.getXmlHelper().initXmlParsing(response);
        BackgroundCRes backgroundCRes = app.getXmlHelper().parseXmlResponseReturnBackgroundCResObject(document);

        List<Entry> listEnty = app.getXmlHelper().parseXmlSetNameSetValueFromEntryAddThemToCollection(document);

        System.out.println(listEnty);
        //System.out.println(backgroudResponse);

        String masName[] = {"TXID", "CANCEL_TEXT", "CONFIRM_TITLE", "CONFIRM_MESSAGE", "MASKED_PAN_TITLE", "MASKED_PAN", "PURCHASEDATE_TITLE", "PURCHASEDATE", "MERCHANTNAME_TITLE", "MERCHANTNAME", "PURCHASEAMOUNT_TITLE", "PURCHASEAMOUNT", "ENTER_CODE_TEXT", "SUBMIT_TEXT"};
        String masValue[] = {randomAcsTransId, "Cancel", "Confirm with SMS code", "To confirm the transaction, please enter below the Code we sent by SMS to 4984", "Card #", "545598******8066", "Date", now2, "Store", "integration test", "Amount", "47.00 USD", "Enter the Code here", "Submit"};

        app.getXmlHelper().checkTextInCollectionEntryName(listEnty, masName);
        app.getXmlHelper().checkTextInCollectionEntryValue(listEnty, masValue);

        assertEquals(backgroundCRes.getAcsTransID(), randomAcsTransId);
        assertEquals(backgroundCRes.getMessageType(), "CRes");
        assertEquals(backgroundCRes.getMessageVersion(), "2.1.0");
        assertEquals(backgroundCRes.getPageId(), "sms_oob.html");
        assertEquals(backgroundCRes.getChallengeCompletionInd(), "N");
    }

    @Test(priority = 3)
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

    @Test(priority = 4)
    public void test_getSMS_TDSTestServices_v1_sms_tranId_tranId() {
        printCurentThredId();
        Response res = given()
                .spec(app.requestSpecTDSJson)
                .when()
                .get("/TDSTestServices/v1/sms?tranId=" + tranId + "");

        res.then().log().all();
        sms = res.asString();
        System.out.println("sms " + sms);
        assertEquals(res.getStatusCode(), 200);
    }

    @Test(priority = 5)
    public void test_CReq_TDSServices_acs_bgAuth_() throws IOException, SAXException, ParserConfigurationException {
        printCurentThredId();
        Response res = given()
                .spec(app.requestSpecTDS)
                .body("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                        "<backgroundRequest2>\n" +
                        "   <backgroundCReq>\n" +
                        "      <acsTransID>"+randomAcsTransId+"</acsTransID>\n" +
                        "      <challengeHTMLDataEntry>SMS_OTP="+sms+"</challengeHTMLDataEntry>\n" +
                        "      <messageType>CReq</messageType>\n" +
                        "      <messageVersion>2.1.0</messageVersion>\n" +
                        "      <sdkTransID>ebf18e48-6863-46f8-b480-f8c439e436a1</sdkTransID>\n" +
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