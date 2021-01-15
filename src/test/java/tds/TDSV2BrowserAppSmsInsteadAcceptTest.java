package tds;

import base.TestBase;
import io.restassured.response.Response;
import model.BackgroundARes;
import model.BackgroundCRes;
import model.Entry;
import model.FinalCRes;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class TDSV2BrowserAppSmsInsteadAcceptTest extends TestBase {
    String randomAcsTransId = app.generateRandomNumber(10) + "-integrTest-acsTransid-v2";
    String dsTransId = app.generateRandomNumber(10) + "-integrTest-dsTransId-v2";
    String pan = "5455980836095804";
    String maskedPan = "545598******5804";
    String tranId = null;
    String sms = null;

    @Test(priority = 66)
    public void test_AReq_DiPocket3ds_acs_bgAuth() throws IOException, SAXException, ParserConfigurationException {
        String now = app.getTimeStamp("YYYYMMddHHmmss");
        Response res = given()
                .header("Content-Type", "application/xml")
                .body("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                        "<backgroundRequest2>\n" +
                        "   <backgroundAReq>\n" +
                        "      <acsTransID>"+randomAcsTransId+"</acsTransID>\n" +
                        "      <threeDSCompInd>Y</threeDSCompInd>\n" +
                        "      <threeDSRequestorAuthenticationInd>01</threeDSRequestorAuthenticationInd>\n" +
                        "      <threeDSRequestorID>1000</threeDSRequestorID>\n" +
                        "      <threeDSRequestorName>integration test</threeDSRequestorName>\n" +
                        "      <threeDSRequestorURL>integration test</threeDSRequestorURL>\n" +
                        "      <threeDSServerRefNumber>3DS_LOA_SER_MOMD_020100_00068</threeDSServerRefNumber>\n" +
                        "      <threeDSServerTransID>43abe893-8e2b-591e-8000-0000003b9535</threeDSServerTransID>\n" +
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
                        "      <cardExpiryDate>3510</cardExpiryDate>\n" +
                        "      <acctNumber>"+pan+"</acctNumber>\n" +
                        "      <deviceChannel>02</deviceChannel>\n" +
                        "      <dsReferenceNumber>EMVCo1234567</dsReferenceNumber>\n" +
                        "      <dsTransID>"+dsTransId+"</dsTransID>\n" +
                        "      <dsURL>integration test</dsURL>\n" +
                        "      <mcc>0000</mcc>\n" +
                        "      <merchantCountryCode>246</merchantCountryCode>\n" +
                        "      <merchantName>integration test</merchantName>\n" +
                        "      <messageCategory>01</messageCategory>\n" +
                        "      <messageType>AReq</messageType>\n" +
                        "      <messageVersion>2.1.0</messageVersion>\n" +
                        "      <notificationURL>integration test</notificationURL>\n" +
                        "      <purchaseAmount>6500</purchaseAmount>\n" +
                        "      <purchaseCurrency>840</purchaseCurrency>\n" +
                        "      <purchaseExponent>2</purchaseExponent>\n" +
                        "      <purchaseDate>"+now+"</purchaseDate>\n" +
                        "   </backgroundAReq>\n" +
                        "</backgroundRequest2>")
                .when()
                .post("https://lvov.csltd.com.ua/DiPocket3ds/acs/bgAuth");

        res.then().log().all().statusCode(200);
        String response = res.asString();
        System.out.println(res.asString());

        Document document = app.getXmlHelper().initXmlParsing(response);
        BackgroundARes backgroundARes = app.getXmlHelper().parseXmlResponseReturnBackgroundAResObject(document);

        Assert.assertEquals(backgroundARes.getAcsTransID(), randomAcsTransId);
        Assert.assertEquals(backgroundARes.getAcsChallengeMandated(), "Y");
        Assert.assertEquals(backgroundARes.getAuthenticationType(), "02");
        Assert.assertEquals(backgroundARes.getMessageType(), "ARes");
        Assert.assertEquals(backgroundARes.getMessageVersion(), "2.1.0");
        Assert.assertEquals(backgroundARes.getTransStatus(), "C");
    }

    @Test(priority = 67)
    public void test_CReq_DiPocket3ds_acs_bgAuth() throws IOException, SAXException, ParserConfigurationException {
        Response res = given()
                .header("Content-Type", "application/xml")
                .body("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                        "<backgroundRequest2>\n" +
                        "   <backgroundCReq>\n" +
                        "      <acsTransID>"+randomAcsTransId+"</acsTransID>\n" +
                        "      <challengeWindowSize>03</challengeWindowSize>\n" +
                        "      <messageType>CReq</messageType>\n" +
                        "      <messageVersion>2.1.0</messageVersion>\n" +
                        "   </backgroundCReq>\n" +
                        "</backgroundRequest2>")
                .when()
                .post("https://lvov.csltd.com.ua/DiPocket3ds/acs/bgAuth");

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
        Assert.assertEquals(backgroudCres.getAcsTransID(), randomAcsTransId);
        Assert.assertEquals(backgroudCres.getMessageType(), "CRes");
        Assert.assertEquals(backgroudCres.getMessageVersion(), "2.1.0");
        Assert.assertEquals(backgroudCres.getPageId(), "bio-web.html");
        Assert.assertEquals(backgroudCres.getChallengeCompletionInd(), "N");
    }

    @Test(priority = 68)
    public void test_tranStatus_DiPocket3ds_acs_tranStatus() {
        given()
                .header("Content-Type", "application/json")
                .body("{\n" +
                        "\t\"txId\" : \"" + randomAcsTransId + "\"\n" +
                        "}")
                .when()
                .post("https://lvov.csltd.com.ua/DiPocket3ds/acs/tranStatus")
                .then()
                .log().all()
                .statusCode(200)
                .body("value", equalTo("AWAITING"));
    }


    @Test(priority = 69)
    public void test_CReq_DiPocket3ds_acs_bgAuth_() throws IOException, SAXException, ParserConfigurationException {
        Response res = given()
                .header("Content-Type", "application/xml")
                .body("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                        "<backgroundRequest2>\n" +
                        "   <backgroundCReq>\n" +
                        "      <acsTransID>"+randomAcsTransId+"</acsTransID>\n" +
                        "      <challengeWindowSize>03</challengeWindowSize>\n" +
                        "      <messageType>CReq</messageType>\n" +
                        "      <messageVersion>2.1.0</messageVersion>\n" +
                        "      <backgroundPageResponse>\n" +
                        "         <pageId>bio-web.html</pageId>\n" +
                        "         <values>\n" +
                        "            <entry>\n" +
                        "               <name>TXID</name>\n" +
                        "               <value>"+randomAcsTransId+"</value>\n" +
                        "            </entry>\n" +
                        "            <entry>\n" +
                        "               <name>BIO_AUTH</name>\n" +
                        "               <value>DECLINED</value>\n" +
                        "            </entry>\n" +
                        "            <entry>\n" +
                        "               <name>SMS_INSTEAD</name>\n" +
                        "               <value>Y</value>\n" +
                        "            </entry>\n" +
                        "         </values>\n" +
                        "      </backgroundPageResponse>\n" +
                        "   </backgroundCReq>\n" +
                        "</backgroundRequest2>")
                .when()
                .post("https://lvov.csltd.com.ua/DiPocket3ds/acs/bgAuth");

        res.then().log().all().statusCode(200);
        String response = res.asString();
        System.out.println(res.asString());


        Document document = app.getXmlHelper().initXmlParsing(response);
        BackgroundCRes backgroudCres = app.getXmlHelper().parseXmlResponseReturnBackgroundCResObject(document);
        List<Entry> listEnty = app.getXmlHelper().parseXmlSetNameSetValueFromEntryAddThemToCollection(document);

        System.out.println(listEnty);
        //System.out.println(backgroudResponse);

        String masName[] = {"TXID", "CANCEL_TEXT", "CONFIRM_TITLE", "CONFIRM_MESSAGE", "MASKED_PAN_TITLE", "MASKED_PAN", "PURCHASEDATE_TITLE", "PURCHASEDATE", "MERCHANTNAME_TITLE", "MERCHANTNAME", "PURCHASEAMOUNT_TITLE", "PURCHASEAMOUNT", "ENTER_CODE_TEXT", "SUBMIT_TEXT"};
        String masValue[] = {randomAcsTransId, "Cancel", "Confirm with SMS code", "To confirm the transaction, please enter below the Code we sent by SMS to 0069", "Card #", maskedPan, "Date", "Store", "integration test", "Amount", "65.00 USD", "Enter the Code here", "Submit"};

        app.getXmlHelper().checkTextInCollectionEntryName(listEnty, masName);
        app.getXmlHelper().checkTextInCollectionEntryValue(listEnty, masValue);
        Assert.assertEquals(backgroudCres.getAcsTransID(), randomAcsTransId);
        Assert.assertEquals(backgroudCres.getMessageType(), "CRes");
        Assert.assertEquals(backgroudCres.getMessageVersion(), "2.1.0");
        Assert.assertEquals(backgroudCres.getPageId(), "sms_web.html");
        Assert.assertEquals(backgroudCres.getChallengeCompletionInd(), "N");
    }

    @Test(priority = 70)
    public void test_tranStatus_DiPocket3ds_acs_tranStatus_() {
        given()
                .header("Content-Type", "application/json")
                .body("{\n" +
                        "\t\"txId\" : \"" + randomAcsTransId + "\"\n" +
                        "}")
                .when()
                .post("https://lvov.csltd.com.ua/DiPocket3ds/acs/tranStatus")
                .then()
                .log().all()
                .statusCode(200)
                .body("value", equalTo("AWAITING"));
    }

    @Test(priority = 71)
    public void test_getTransId_TDSTestServices_v1_tranId_v2_txId_randomAcsTransId() {
        Response res = given()
                .when()
                .header("Content-Type", "application/json")
                .get("http://dipocket3.intranet:8092/TDSTestServices/v1/tranId.v2?txId=" + randomAcsTransId + "");

        res.then().log().all();
        tranId = res.asString();
        System.out.println("tranId " + tranId);
        Assert.assertEquals(res.getStatusCode(), 200);
    }

    @Test(priority = 72)
    public void test_getSMS_TDSTestServices_v1_sms_tranId_tranId() {
        Response res = given()
                .when()
                .header("Content-Type", "application/json")
                .get("http://dipocket3.intranet:8092/TDSTestServices/v1/sms?tranId=" + tranId + "");

        res.then().log().all();
        sms = res.asString();
        System.out.println("sms " + sms);
        Assert.assertEquals(res.getStatusCode(), 200);
    }

    @Test(priority = 73)
    public void test_CReq_DiPocket3ds_acs_bgAuth__() throws IOException, SAXException, ParserConfigurationException {
        Response res = given()
                .header("Content-Type", "application/xml")
                .body("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                        "<backgroundRequest2>\n" +
                        "   <backgroundCReq>\n" +
                        "      <acsTransID>"+randomAcsTransId+"</acsTransID>\n" +
                        "      <challengeWindowSize>03</challengeWindowSize>\n" +
                        "      <messageType>CReq</messageType>\n" +
                        "      <messageVersion>2.1.0</messageVersion>\n" +
                        "      <backgroundPageResponse>\n" +
                        "         <pageId>sms_web.html</pageId>\n" +
                        "         <values>\n" +
                        "            <entry>\n" +
                        "               <name>SMS_OTP</name>\n" +
                        "               <value>"+sms+"</value>\n" +
                        "            </entry>\n" +
                        "         </values>\n" +
                        "      </backgroundPageResponse>\n" +
                        "   </backgroundCReq>\n" +
                        "</backgroundRequest2>")
                .when()
                .post("https://lvov.csltd.com.ua/DiPocket3ds/acs/bgAuth");

        res.then().log().all().statusCode(200);
        String response = res.asString();
        System.out.println(res.asString());

        Document document = app.getXmlHelper().initXmlParsing(response);
        FinalCRes finalCRes = app.getXmlHelper().parseXmlResponseReturnFinalCResObject(document);

        Assert.assertEquals(finalCRes.getAcsTransID(), randomAcsTransId);
        Assert.assertEquals(finalCRes.getMessageType(), "CRes");
        Assert.assertEquals(finalCRes.getMessageVersion(), "2.1.0");
        Assert.assertEquals(finalCRes.getTransStatus(), "Y");
        Assert.assertEquals(finalCRes.getChallengeCompletionInd(), "Y");
    }
}