package tests.tds;

import base.TestBase;
import io.restassured.response.Response;
import model.BackgroundAResDecline;
import org.testng.annotations.Test;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.testng.Assert.assertEquals;

public class TDSV2NativeIncorrectTranTest extends TestBase {
    String randomAcsTransId = app.generateRandomNumber(10) + "-integrTest-acsTransid-v2";
    String dsTransId = app.generateRandomNumber(10) + "-integrTest-dsTransId-v2";

    @Test(priority = 1)
    public void test_AReq_TDSServices_acs_bgAuth() throws IOException, SAXException, ParserConfigurationException {
        printCurentThredId();
        String now = app.getTimeStamp("YYYYMMddHHmmss");
        String pan4TestSMS = "5455980666358066";
        Response res = given()
                .spec(app.requestSpecTDS)
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
                        "         <sdkUiType/>\n" +
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
                .post("/TDSServices/acs/bgAuth");

        res.then().log().all().statusCode(200)
                .body("backgroundResponse2.backgroundARes.messageExtension", equalTo(""));

        String response = res.asString();
        System.out.println(res.asString());

        Document document = app.getXmlHelper().initXmlParsing(response);
        BackgroundAResDecline backgroundAResDecline = app.getXmlHelper().parseXmlResponseReturnBackgroundAResDeclinedObject(document);

        assertEquals(backgroundAResDecline.getAcsTransID(), randomAcsTransId);
        assertEquals(backgroundAResDecline.getMessageType(), "ARes");
        assertEquals(backgroundAResDecline.getMessageVersion(), "2.1.0");
        assertEquals(backgroundAResDecline.getTransStatus(), "N");
        assertEquals(backgroundAResDecline.getTransStatusReason(), "07");
    }
}