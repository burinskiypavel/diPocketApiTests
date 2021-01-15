package tds;

import base.TestBase;
import io.restassured.response.Response;
import model.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import static org.hamcrest.MatcherAssert.assertThat;

public class TDSV2NativeSmsAcceptTest extends TestBase {
    String randomAcsTransId = app.generateRandomNumber(10) + "-integrTest-acsTransid-v2";
    String dsTransId = app.generateRandomNumber(10) + "-integrTest-dsTransId-v2";
    String tranId = null;
    String now = app.getTimeStamp("YYYYMMddHHmmss");
    String now2 = app.getTimeStamp("dd.MM.YYYY HH:mm");
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
                        "      <threeDSRequestorAuthenticationInfo>\n" +
                        "         <threeDSReqAuthMethod>05</threeDSReqAuthMethod>\n" +
                        "      </threeDSRequestorAuthenticationInfo>\n" +
                        "      <threeDSRequestorChallengeInd>01</threeDSRequestorChallengeInd>\n" +
                        "      <threeDSRequestorID>1000</threeDSRequestorID>\n" +
                        "      <threeDSRequestorName>integration test</threeDSRequestorName>\n" +
                        "      <threeDSRequestorURL>integration test</threeDSRequestorURL>\n" +
                        "      <threeDSServerRefNumber>3DS_LOA_SER_MOMD_020100_00068</threeDSServerRefNumber>\n" +
                        "      <threeDSServerTransID>d6847293-17b3-5913-8000-0000003bad3b</threeDSServerTransID>\n" +
                        "      <threeDSServerURL>integration test</threeDSServerURL>\n" +
                        "      <acquirerBIN>444444</acquirerBIN>\n" +
                        "      <acquirerMerchantID>1000</acquirerMerchantID>\n" +
                        "      <cardExpiryDate>3201</cardExpiryDate>\n" +
                        "      <acctNumber>"+pan4TestSMS+"</acctNumber>\n" +
                        "      <deviceChannel>01</deviceChannel>\n" +
                        "      <deviceInfo>some device info for integration test</deviceInfo>\n" +
                        "      <deviceRenderOptions>\n" +
                        "         <sdkInterface>03</sdkInterface>\n" +
                        "         <sdkUiType>\n" +
                        "            <uiType>01</uiType>\n" +
                        "         </sdkUiType>\n" +
                        "      </deviceRenderOptions>\n" +
                        "      <dsReferenceNumber>EMVCo1234567</dsReferenceNumber>\n" +
                        "      <dsTransID>"+dsTransId+"</dsTransID>\n" +
                        "      <dsURL>https://3ds2-ds.test.modirum.com:9901/ds/DServer</dsURL>\n" +
                        "      <mcc>1234</mcc>\n" +
                        "      <merchantCountryCode>246</merchantCountryCode>\n" +
                        "      <merchantName>integration test</merchantName>\n" +
                        "      <messageCategory>01</messageCategory>\n" +
                        "      <messageType>AReq</messageType>\n" +
                        "      <messageVersion>2.1.0</messageVersion>\n" +
                        "      <purchaseAmount>10200</purchaseAmount>\n" +
                        "      <purchaseCurrency>840</purchaseCurrency>\n" +
                        "      <purchaseExponent>2</purchaseExponent>\n" +
                        "      <purchaseDate>"+now+"</purchaseDate>\n" +
                        "      <sdkAppID>70184078-071f-4460-8537-bcc452e2c734</sdkAppID>\n" +
                        "      <sdkMaxTimeout>05</sdkMaxTimeout>\n" +
                        "      <sdkReferenceNumber>3DSSDK74332823FF</sdkReferenceNumber>\n" +
                        "      <sdkTransID>aa73e9ae-affd-45f1-b098-21d812ddf29f</sdkTransID>\n" +
                        "      <transType>01</transType>\n" +
                        "   </backgroundAReq>\n" +
                        "</backgroundRequest2>")
                .when()
                .post(app.TDSBaseUrl +"/DiPocket3ds/acs/bgAuth");

        res.then().log().all().statusCode(200)
                .body("backgroundResponse2.backgroundARes.acsRenderingType.acsInterface", equalTo("01"))
                .body("backgroundResponse2.backgroundARes.acsRenderingType.acsUiTemplate", equalTo("01"));

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
                        "      <sdkTransID>aa73e9ae-affd-45f1-b098-21d812ddf29f</sdkTransID>\n" +
                        "      <sdkCounterStoA>000</sdkCounterStoA>\n" +
                        "   </backgroundCReq>\n" +
                        "</backgroundRequest2>")
                .when()
                .post(app.TDSBaseUrl +"/DiPocket3ds/acs/bgAuth");

        res.then().log().all().statusCode(200);
        String response = res.asString();
        System.out.println(res.asString());

        Document document = app.getXmlHelper().initXmlParsing(response);
        NativeSms nativeSms = app.getXmlHelper().parseXmlReturnNativeSmsObject(document);

        Assert.assertEquals(nativeSms.getAcsTransID(), randomAcsTransId);
        Assert.assertEquals(nativeSms.getAcsCounterAtoS(), "000");
        Assert.assertEquals(nativeSms.getAcsUiType(), "01");
        Assert.assertEquals(nativeSms.getChallengeInfoHeader(), "Confirm with SMS code");
        Assert.assertEquals(nativeSms.getChallengeInfoLabel(), "Enter the Code here");

        assertThat(nativeSms.getChallengeInfoText(), equalTo("To confirm the transaction, please enter below the Code we sent by SMS to 4984\\n\\n\n" +
                "Card # 545598******8066\\n\\n\n" +
                        "Date   " + now2 + "\\n\\n\n" +
                        "Store  integration test\\n\\n\n" +
                        "Amount 102.00 USD\\n\\n"
                ));

        Assert.assertEquals(nativeSms.getIssuerImage(), "https://dipocket.org/img/dip-logo.png");
        Assert.assertEquals(nativeSms.getPsImage(), "https://brand.mastercard.com/content/dam/mccom/brandcenter/thumbnails/mc_bc_othermarks_idcheck_thmb.png");
        Assert.assertEquals(nativeSms.getMessageType(), "CRes");
        Assert.assertEquals(nativeSms.getMessageVersion(), "2.1.0");
        Assert.assertEquals(nativeSms.getSubmitAuthenticationLabel(), "Submit");
        Assert.assertEquals(nativeSms.getChallengeCompletionInd(), "N");
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
                        "      <challengeDataEntry>"+sms+"</challengeDataEntry>\n" +
                        "      <messageType>CReq</messageType>\n" +
                        "      <messageVersion>2.1.0</messageVersion>\n" +
                        "      <sdkTransID>aa73e9ae-affd-45f1-b098-21d812ddf29f</sdkTransID>\n" +
                        "      <sdkCounterStoA>001</sdkCounterStoA>\n" +
                        "   </backgroundCReq>\n" +
                        "</backgroundRequest2>")
                .when()
                .post(app.TDSBaseUrl +"/DiPocket3ds/acs/bgAuth");

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