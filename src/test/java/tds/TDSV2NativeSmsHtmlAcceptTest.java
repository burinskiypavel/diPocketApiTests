package tds;

import base.BaseTest;
import io.restassured.response.Response;
import model.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class TDSV2NativeSmsHtmlAcceptTest extends BaseTest {
    String randomAcsTransId = generateRandomNumber(10) + "-integrTest-acsTransid-v2";
    String dsTransId = generateRandomNumber(10) + "-integrTest-dsTransId-v2";
    String tranId = null;
    String now = getTimeStamp("YYYYMMddHHmmss");
    String now2 = getTimeStamp("dd.MM.YYYY HH:mm");
    String sms = null;

    @Test(priority = 1)
    public void test_AReq_DiPocket3ds_acs_bgAuth() throws IOException, SAXException, ParserConfigurationException {
        String pan4TestSMS = "5455980666358066";
        Response res = given()
                .header("Content-Type", "application/xml")
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
                .post(TDSBaseUrl+"/DiPocket3ds/acs/bgAuth");

        res.then().log().all().statusCode(200)
                .body("backgroundResponse2.backgroundARes.acsRenderingType.acsInterface", equalTo("02"))
                .body("backgroundResponse2.backgroundARes.acsRenderingType.acsUiTemplate", equalTo("05"));

        String response = res.asString();
        System.out.println(res.asString());

        Document document = initXmlParsing(response);
        BackgroundARes backgroundARes = parseXmlResponseReturnBackgroundAResObject(document);

        Assert.assertEquals(backgroundARes.getAcsTransID(), randomAcsTransId);
        Assert.assertEquals(backgroundARes.getAcsChallengeMandated(), "Y");
        Assert.assertEquals(backgroundARes.getAuthenticationType(), "02");
        Assert.assertEquals(backgroundARes.getMessageType(), "ARes");
        Assert.assertEquals(backgroundARes.getMessageVersion(), "2.1.0");
        Assert.assertEquals(backgroundARes.getTransStatus(), "C");
    }

    @Test(priority = 2)
    public void test_CReq_DiPocket3ds_acs_bgAuth() throws IOException, SAXException, ParserConfigurationException {
        Response res = given()
                .header("Content-Type", "application/xml")
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
                .post(TDSBaseUrl+"/DiPocket3ds/acs/bgAuth");

        res.then().log().all().statusCode(200)
                .body("backgroundResponse2.backgroundCRes.InProgressCRes.acsCounterAtoS", equalTo("000"))
                .body("backgroundResponse2.backgroundCRes.InProgressCRes.acsUiType", equalTo("05"));

        String response = res.asString();
        System.out.println(res.asString());

        Document document = initXmlParsing(response);
        BackgroundCRes backgroundCRes = parseXmlResponseReturnBackgroundCResObject(document);

        List<Entry> listEnty = parseXmlSetNameSetValueFromEntryAddThemToCollection(document);

        System.out.println(listEnty);
        //System.out.println(backgroudResponse);

        String masName[] = {"TXID", "CANCEL_TEXT", "CONFIRM_TITLE", "CONFIRM_MESSAGE", "MASKED_PAN_TITLE", "MASKED_PAN", "PURCHASEDATE_TITLE", "PURCHASEDATE", "MERCHANTNAME_TITLE", "MERCHANTNAME", "PURCHASEAMOUNT_TITLE", "PURCHASEAMOUNT", "ENTER_CODE_TEXT", "SUBMIT_TEXT"};
        String masValue[] = {randomAcsTransId, "Cancel", "Confirm with SMS code", "To confirm the transaction, please enter below the Code we sent by SMS to 4984", "Card #", "545598******8066", "Date", now2, "Store", "integration test", "Amount", "47.00 USD", "Enter the Code here", "Submit"};

        checkTextInCollectionEntryName(listEnty, masName);
        checkTextInCollectionEntryValue(listEnty, masValue);

        Assert.assertEquals(backgroundCRes.getAcsTransID(), randomAcsTransId);
        Assert.assertEquals(backgroundCRes.getMessageType(), "CRes");
        Assert.assertEquals(backgroundCRes.getMessageVersion(), "2.1.0");
        Assert.assertEquals(backgroundCRes.getPageId(), "sms_oob.html");
        Assert.assertEquals(backgroundCRes.getChallengeCompletionInd(), "N");
    }

    @Test(priority = 3)
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

    @Test(priority = 4)
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

    @Test(priority = 5)
    public void test_CReq_DiPocket3ds_acs_bgAuth_() throws IOException, SAXException, ParserConfigurationException {
        Response res = given()
                .header("Content-Type", "application/xml")
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
                .post(TDSBaseUrl+"/DiPocket3ds/acs/bgAuth");

        res.then().log().all().statusCode(200);
        String response = res.asString();
        System.out.println(res.asString());

        Document document = initXmlParsing(response);
        FinalCRes finalCRes = parseXmlResponseReturnFinalCResObject(document);

        Assert.assertEquals(finalCRes.getAcsTransID(), randomAcsTransId);
        Assert.assertEquals(finalCRes.getMessageType(), "CRes");
        Assert.assertEquals(finalCRes.getMessageVersion(), "2.1.0");
        Assert.assertEquals(finalCRes.getTransStatus(), "Y");
        Assert.assertEquals(finalCRes.getChallengeCompletionInd(), "Y");
    }
}