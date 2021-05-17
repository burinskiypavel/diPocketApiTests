package tds;

import base.TestBase;
import io.restassured.response.Response;
import model.BackgroundARes;
import model.FinalCResDecline;
import model.NativeSms;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class TDSV2NativeSmsInccodeTest extends TestBase {
    String randomAcsTransId = app.generateRandomNumber(10) + "-integrTest-acsTransid-v2";
    String dsTransId = app.generateRandomNumber(10) + "-integrTest-dsTransId-v2";
    String now = app.getTimeStamp("YYYYMMddHHmmss");
    String now2 = app.getTimeStamp("dd.MM.YYYY HH:mm");
    String wrongSMSCode = "123456";

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
                .post(app.TDSBaseUrl+"/DiPocket3ds/acs/bgAuth");

        res.then().log().all().statusCode(200)
                .body("backgroundResponse2.backgroundARes.acsRenderingType.acsInterface", equalTo("01"))
                .body("backgroundResponse2.backgroundARes.acsRenderingType.acsUiTemplate", equalTo("01"))
                .body("backgroundResponse2.backgroundARes.messageExtension", equalTo(""));

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
                .post(app.TDSBaseUrl+"/DiPocket3ds/acs/bgAuth");

        res.then().log().all().statusCode(200);
        String response = res.asString();
        System.out.println(res.asString());

        Document document = app.getXmlHelper().initXmlParsing(response);
        NativeSms nativeSms = app.getXmlHelper().parseXmlReturnNativeSmsObject(document);

        assertEquals(nativeSms.getAcsTransID(), randomAcsTransId);
        assertEquals(nativeSms.getAcsCounterAtoS(), "000");
        assertEquals(nativeSms.getAcsUiType(), "01");
        assertEquals(nativeSms.getChallengeInfoHeader(), "Confirm with SMS code");
        assertEquals(nativeSms.getChallengeInfoLabel(), "Enter the Code here");

        assertThat(nativeSms.getChallengeInfoText(), equalTo("To confirm the transaction, please enter below the Code we sent by SMS to 4984\\n\\n\n" +
                "Card # 545598******8066\\n\\n\n" +
                        "Date   " + now2 + "\\n\\n\n" +
                        "Store  integration test\\n\\n\n" +
                        "Amount 102.00 USD\\n\\n"
                ));

        assertEquals(nativeSms.getIssuerImage(), "https://dipocket.org/img/dip-logo.png");
        assertEquals(nativeSms.getPsImage(), "https://brand.mastercard.com/content/dam/mccom/brandcenter/thumbnails/mc_bc_othermarks_idcheck_thmb.png");
        assertEquals(nativeSms.getMessageType(), "CRes");
        assertEquals(nativeSms.getMessageVersion(), "2.1.0");
        assertEquals(nativeSms.getSubmitAuthenticationLabel(), "Submit");
        assertEquals(nativeSms.getChallengeCompletionInd(), "N");
    }

    @Test(priority = 3)
    public void test_CReq_DiPocket3ds_acs_bgAuth_() throws IOException, SAXException, ParserConfigurationException {
        Response res = given()
                .header("Content-Type", "application/xml")
                .body("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                        "<backgroundRequest2>\n" +
                        "   <backgroundCReq>\n" +
                        "      <acsTransID>"+randomAcsTransId+"</acsTransID>\n" +
                        "      <challengeDataEntry>"+wrongSMSCode+"</challengeDataEntry>\n" +
                        "      <messageType>CReq</messageType>\n" +
                        "      <messageVersion>2.1.0</messageVersion>\n" +
                        "      <sdkTransID>aa73e9ae-affd-45f1-b098-21d812ddf29f</sdkTransID>\n" +
                        "      <sdkCounterStoA>001</sdkCounterStoA>\n" +
                        "   </backgroundCReq>\n" +
                        "</backgroundRequest2>")
                .when()
                .post(app.TDSBaseUrl+"/DiPocket3ds/acs/bgAuth");

        res.then().log().all().statusCode(200);
        String response = res.asString();
        System.out.println(res.asString());

        Document document = app.getXmlHelper().initXmlParsing(response);
        FinalCResDecline finalCResDecline = app.getXmlHelper().parseXmlResponseReturnFinalCResDeclineObject(document);

        assertEquals(finalCResDecline.getAcsTransID(), randomAcsTransId);
        assertEquals(finalCResDecline.getMessageType(), "CRes");
        assertEquals(finalCResDecline.getMessageVersion(), "2.1.0");
        assertEquals(finalCResDecline.getTransStatus(), "N");
        assertEquals(finalCResDecline.getTransStatusReason(), "01");
        assertEquals(finalCResDecline.getChallengeCompletionInd(), "Y");
    }
}