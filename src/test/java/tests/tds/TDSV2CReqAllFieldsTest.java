package tests.tds;

import base.TestBase;
import io.restassured.response.Response;
import model.BackgroundARes;
import model.FinalCResDecline;
import org.testng.annotations.Test;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.testng.Assert.assertEquals;

public class TDSV2CReqAllFieldsTest extends TestBase {
    String randomAcsTransId = app.generateRandomNumber(10) + "-integrTest-acsTransid-v2";
    String dsTransId = app.generateRandomNumber(10) + "-integrTest-dsTransId-v2";
    String pan = "5455980836095804";

    @Test(priority = 1)
    public void test_AReq_TDSServices_acs_bgAuth() throws IOException, SAXException, ParserConfigurationException {
        printCurentThredId();
        Response res = given()
                .spec(app.requestSpecTDS)
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
                        "      <threeDSServerTransID>85cd7a75-deb1-5934-8000-0000003b9495</threeDSServerTransID>\n" +
                        "      <threeDSServerURL>integration test</threeDSServerURL>\n" +
                        "      <acquirerBIN>444444</acquirerBIN>\n" +
                        "      <acquirerMerchantID>1000-string-value</acquirerMerchantID>\n" +
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
                        "      <purchaseAmount>6000</purchaseAmount>\n" +
                        "      <purchaseCurrency>840</purchaseCurrency>\n" +
                        "      <purchaseExponent>2</purchaseExponent>\n" +
                        "      <purchaseDate>20200303145453</purchaseDate>\n" +
                        "   </backgroundAReq>\n" +
                        "</backgroundRequest2>")
                .when()
                .post("/TDSServices/acs/bgAuth");

        res.then().log().all().statusCode(200)
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
    public void test_CReq_TDSServices_acs_bgAuth() throws IOException, SAXException, ParserConfigurationException {
        printCurentThredId();
        Response res = given()
                .spec(app.requestSpecTDS)
                .body("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                        "<backgroundRequest2>\n" +
                        "   <backgroundCReq>\n" +
                        "      <acsTransID>"+randomAcsTransId+"</acsTransID>\n" +
                        "      <challengeCancel>01</challengeCancel>\n" +
                        "      <challengeDataEntry>some info</challengeDataEntry>\n" +
                        "      <challengeHTMLDataEntry>some info</challengeHTMLDataEntry>\n" +
                        "      <challengeWindowSize>03</challengeWindowSize>\n" +
                        "      <messageExtension>\n" +
                        "        <name>testExtensionField</name>\n" +
                        "        <id>ID1</id>\n" +
                        "        <criticalityIndicator>false</criticalityIndicator>\n" +
                        "        <data>str1234</data>\n" +
                        "      </messageExtension>\n" +
                        "      <messageType>CReq</messageType>\n" +
                        "      <messageVersion>2.1.0</messageVersion>\n" +
                        "      <oobContinue>false</oobContinue>\n" +
                        "      <resendChallenge>N</resendChallenge>\n" +
                        "      <sdkTransID>some info</sdkTransID>\n" +
                        "      <sdkCounterStoA>abx</sdkCounterStoA>\n" +
                        "      <backgroundPageResponse>\n" +
                        "      \t<pageId>someValue</pageId>\n" +
                        "      \t<values>\n" +
                        "      \t\t<entry>\n" +
                        "      \t\t\t<name>n1</name>\n" +
                        "      \t\t\t<value>v1</value>\n" +
                        "      \t\t</entry>\n" +
                        "      \t\t<entry>\n" +
                        "      \t\t\t<name>n2</name>\n" +
                        "      \t\t\t<value>v2</value>\n" +
                        "      \t\t</entry>\n" +
                        "      \t\t<error>\n" +
                        "      \t\t\t<errorCode>9856</errorCode>\n" +
                        "      \t\t\t<errorDescription>some description info</errorDescription>\n" +
                        "      \t\t</error>\n" +
                        "      \t</values>\n" +
                        "      </backgroundPageResponse>\n" +
                        "   </backgroundCReq>\n" +
                        "</backgroundRequest2>")
                .when()
                .post("/TDSServices/acs/bgAuth");

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