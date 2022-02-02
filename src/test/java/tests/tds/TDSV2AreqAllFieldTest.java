package tests.tds;

import base.TestBase;
import io.restassured.response.Response;
import model.BackgroundARes;
import org.testng.annotations.Test;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.testng.Assert.assertEquals;

public class TDSV2AreqAllFieldTest extends TestBase {
    String randomAcsTransId = app.generateRandomNumber(10) + "-integrTest-acsTransid-v2";
    String dsTransId = app.generateRandomNumber(10) + "-integrTest-dsTransId-v2";

    @Test(priority = 1)
    public void test_AReq_TDSServices_acs_bgAuth() throws IOException, SAXException, ParserConfigurationException {
        String now = app.getTimeStamp("YYYYMMddHHmmss");
        Response res = given()
                .spec(app.requestSpecTDS)
                .body("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                        "<backgroundRequest2>\n" +
                        "   <backgroundAReq>\n" +
                        "      <acsTransID>" + randomAcsTransId + "</acsTransID>\n" +
                        "      <threeDSCompInd>Y</threeDSCompInd>\n" +
                        "      <threeDSRequestorAuthenticationInd>01</threeDSRequestorAuthenticationInd>\n" +
                        "      <threeDSRequestorAuthenticationInfo>\n" +
                        "        <threeDSReqAuthMethod>01</threeDSReqAuthMethod>\n" +
                        "        <threeDSReqAuthTimestamp>202004171501</threeDSReqAuthTimestamp>\n" +
                        "        <threeDSReqAuthData>str1234</threeDSReqAuthData>\n" +
                        "      </threeDSRequestorAuthenticationInfo>\n" +
                        "      <threeDSRequestorChallengeInd>01</threeDSRequestorChallengeInd>   \n" +
                        "      <threeDSRequestorID>1000</threeDSRequestorID>\n" +
                        "      <threeDSRequestorName>integration test</threeDSRequestorName>\n" +
                        "      <threeDSRequestorPriorAuthenticationInfo>\n" +
                        "          <threeDSReqPriorRef>6586bc82-3915-4e1b-b162-75a03a263991</threeDSReqPriorRef>\n" +
                        "          <threeDSReqPriorAuthMethod>02</threeDSReqPriorAuthMethod>\n" +
                        "          <threeDSReqPriorAuthTimestamp>202004171501</threeDSReqPriorAuthTimestamp>\n" +
                        "          <threeDSReqPriorAuthData>str1234</threeDSReqPriorAuthData>\n" +
                        "      </threeDSRequestorPriorAuthenticationInfo>     \n" +
                        "      <threeDSRequestorURL>integration test</threeDSRequestorURL>\n" +
                        "      <threeDSServerRefNumber>3DS_LOA_SER_MOMD_020100_00068</threeDSServerRefNumber>\n" +
                        "      <threeDSServerOperatorID>12345678</threeDSServerOperatorID>   \n" +
                        "      <threeDSServerTransID>threeDSServerTransID</threeDSServerTransID>\n" +
                        "      <threeDSServerURL>integration test</threeDSServerURL>\n" +
                        "      <threeRIInd>01</threeRIInd>\n" +
                        "      <acctType>02</acctType>      \n" +
                        "      <acquirerBIN>444444</acquirerBIN>\n" +
                        "      <acquirerMerchantID>1000</acquirerMerchantID>\n" +
                        "      <addrMatch>Y</addrMatch>\n" +
                        "      <broadInfo>str1234</broadInfo>      \n" +
                        "      <browserAcceptHeader>text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9</browserAcceptHeader>\n" +
                        "      <browserIP>123.456.789.10</browserIP>\n" +
                        "      <browserJavaEnabled>false</browserJavaEnabled>\n" +
                        "      <browserLanguage>ru-RU</browserLanguage>\n" +
                        "      <browserColorDepth>24</browserColorDepth>\n" +
                        "      <browserScreenHeight>1200</browserScreenHeight>\n" +
                        "      <browserScreenWidth>1920</browserScreenWidth>\n" +
                        "      <browserTZ>-120</browserTZ>\n" +
                        "      <browserUserAgent>Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.130 Safari/537.36</browserUserAgent>\n" +
                        "      <cardExpiryDate>3205</cardExpiryDate>\n" +
                        "      <acctInfo>\n" +
                        "          <chAccAgeInd>05</chAccAgeInd>\n" +
                        "          <chAccChange>20201105</chAccChange>\n" +
                        "          <chAccChangeInd>04</chAccChangeInd>          \n" +
                        "          <chAccDate>20200304</chAccDate>\n" +
                        "          <chAccPwChangeInd>01</chAccPwChangeInd>\n" +
                        "          <chAccPwChange>20201030</chAccPwChange>\n" +
                        "          <nbPurchaseAccount>11</nbPurchaseAccount>\n" +
                        "          <provisionAttemptsDay>1</provisionAttemptsDay>\n" +
                        "          <txnActivityDay>2</txnActivityDay>\n" +
                        "          <txnActivityYear>35</txnActivityYear>\n" +
                        "          <paymentAccAge>20200304</paymentAccAge>\n" +
                        "          <paymentAccInd>05</paymentAccInd>\n" +
                        "          <shipAddressUsage>20160304</shipAddressUsage>\n" +
                        "          <shipAddressUsageInd>04</shipAddressUsageInd>\n" +
                        "          <shipNameIndicator>01</shipNameIndicator>\n" +
                        "          <suspiciousAccActivity>01</suspiciousAccActivity>\n" +
                        "      </acctInfo>\n" +
                        "      <acctNumber>"+ app.pan +"</acctNumber>\n" +
                        "      <acctID>987654321</acctID>\n" +
                        "      <billAddrCity>City name</billAddrCity>\n" +
                        "      <billAddrCountry>pol</billAddrCountry>\n" +
                        "      <billAddrLine1>Address info 1</billAddrLine1>\n" +
                        "      <billAddrLine2>Address info 2</billAddrLine2>\n" +
                        "      <billAddrLine3>Address info 3</billAddrLine3>\n" +
                        "      <billAddrPostCode>ZIP-1234</billAddrPostCode>\n" +
                        "      <billAddrState>pol</billAddrState>\n" +
                        "      <email>firstname.lastname@provider.com</email>\n" +
                        "      <homePhone>\n" +
                        "        <cc>47</cc>\n" +
                        "        <subscriber>12345678</subscriber>\n" +
                        "      </homePhone>\n" +
                        "      <mobilePhone>\n" +
                        "        <cc>47</cc>\n" +
                        "        <subscriber>12345678</subscriber>\n" +
                        "      </mobilePhone>\n" +
                        "      <cardholderName>Firstname Lastname</cardholderName>\n" +
                        "      <shipAddrCity>Cituy name</shipAddrCity>\n" +
                        "      <shipAddrCountry>pol</shipAddrCountry>\n" +
                        "      <shipAddrLine1>Address info 1</shipAddrLine1>\n" +
                        "      <shipAddrLine2>Address info 2</shipAddrLine2>\n" +
                        "      <shipAddrLine3>Address info 3</shipAddrLine3>\n" +
                        "      <shipAddrPostCode>ZIP-1234</shipAddrPostCode>\n" +
                        "      <shipAddrState>lo</shipAddrState>\n" +
                        "      <workPhone>\n" +
                        "        <cc>47</cc>\n" +
                        "        <subscriber>12345678</subscriber>\n" +
                        "      </workPhone>\n" +
                        "      <deviceChannel>02</deviceChannel>      \n" +
                        "      <deviceInfo>deviceInfo</deviceInfo>\n" +
                        "      <deviceRenderOptions>\n" +
                        "    \t<sdkInterface>03</sdkInterface>\n" +
                        "    \t<sdkUiType>\n" +
                        "    \t  <uiType>01</uiType>\n" +
                        "    \t  <uiType>02</uiType>\n" +
                        "    \t  <uiType>03</uiType>\n" +
                        "    \t</sdkUiType>\n" +
                        "      </deviceRenderOptions>\n" +
                        "      <dsReferenceNumber>EMVCo1234567</dsReferenceNumber>\n" +
                        "      <dsTransID>" + dsTransId + "</dsTransID>\n" +
                        "      <dsURL>integration test</dsURL>\n" +
                        "      <payTokenInd>false</payTokenInd>\n" +
                        "      <purchaseInstalData>2</purchaseInstalData>\n" +
                        "      <mcc>0000</mcc>\n" +
                        "      <merchantCountryCode>246</merchantCountryCode>\n" +
                        "      <merchantName>integration test</merchantName>\n" +
                        "      <merchantRiskIndicator>\n" +
                        "        <deliveryEmailAddress>firstname.lastname@provider.com</deliveryEmailAddress>\n" +
                        "        <deliveryTimeframe>02</deliveryTimeframe>\n" +
                        "        <giftCardAmount>30</giftCardAmount>\n" +
                        "        <giftCardCount>1</giftCardCount>\n" +
                        "        <giftCardCurr>978</giftCardCurr>\n" +
                        "        <preOrderDate>20181212</preOrderDate>\n" +
                        "        <preOrderPurchaseInd>02</preOrderPurchaseInd>\n" +
                        "        <reorderItemsInd>01</reorderItemsInd>\n" +
                        "        <shipIndicator>01</shipIndicator>\n" +
                        "      </merchantRiskIndicator>\n" +
                        "      <messageCategory>01</messageCategory>\n" +
                        "      <messageExtension>\n" +
                        "        <name>testExtensionField</name>\n" +
                        "        <id>ID1</id>\n" +
                        "        <criticalityIndicator>false</criticalityIndicator>\n" +
                        "        <data>str1234</data>\n" +
                        "      </messageExtension>\n" +
                        "      <messageType>AReq</messageType>\n" +
                        "      <messageVersion>2.1.0</messageVersion>\n" +
                        "      <notificationURL>https://3ds2-mpi.test.modirum.com/mdpaympi/MerchantServer/msgid/3914591</notificationURL>\n" +
                        "      <purchaseAmount>6000</purchaseAmount>\n" +
                        "      <purchaseCurrency>840</purchaseCurrency>\n" +
                        "      <purchaseExponent>2</purchaseExponent>\n" +
                        "      <purchaseDate>" + now + "</purchaseDate>\n" +
                        "      <recurringExpiry>20190127</recurringExpiry>\n" +
                        "      <recurringFrequency>30</recurringFrequency>\n" +
                        "      <sdkAppID>012569</sdkAppID>\n" +
                        "      <sdkMaxTimeout>11</sdkMaxTimeout>\n" +
                        "      <sdkReferenceNumber>11</sdkReferenceNumber>\n" +
                        "      <sdkTransID>25698365</sdkTransID>      \n" +
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
        BackgroundARes backgroundARes = app.getXmlHelper().parseXmlResponseReturnBackgroundAResAllFieldsObject(document);

        assertEquals(backgroundARes.getAcsTransID(), randomAcsTransId);
        assertEquals(backgroundARes.getAcsChallengeMandated(), "N");
        assertEquals(backgroundARes.getMessageType(), "ARes");
        assertEquals(backgroundARes.getMessageVersion(), "2.1.0");
        assertEquals(backgroundARes.getTransStatus(), "Y");
    }
}