package tds;

import base.BaseTest;
import io.restassured.response.Response;
import model.BackgroudResponse;
import model.BackgroundARes;
import model.Entry;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class TDS_v2_browser_app_accept_Test extends BaseTest {
    String randomTXID = generateRandomNumber(10);
    String randomAcsTransId = generateRandomNumber(11) + "-integrTest-acsTransid-v2";
    String dsTransId = generateRandomNumber(10) + "-integrTest-dsTransId-v2";
    String pan = "5455980836095804";
    String tranId = null;
    String pan4TestSMS = "5455980666358066";
    String sms = null;

    @Test(priority = 42)
    public void test_AReq_DiPocket3ds_acs_bgAuth_v1() throws IOException, SAXException, ParserConfigurationException {
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
                .post("https://lvov.csltd.com.ua/DiPocket3ds/acs/bgAuth");

        res.then().log().all().statusCode(200);
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

    @Test(priority = 43, enabled = false)
    public void test_paReqStep1_DiPocket3ds_acs_bgAuth_v1() {
        String now = getTimeStamp("YYYYMMdd HH:mm:ss");
        String nowAsExpected = getTimeStamp("dd.MM.YYYY HH:mm");
        Response res = given()
                .header("Content-Type", "application/xml")
                .body("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                        "<backgroundRequest>\n" +
                        "   <backgroundPareq>\n" +
                        "      <txId>" + randomTXID + "</txId>\n" +
                        "      <pan>" + pan4TestSMS + "</pan>\n" +
                        "      <expiry>3306</expiry>\n" +
                        "      <acqBIN>502502</acqBIN>\n" +
                        "      <merchant>CH</merchant>\n" +
                        "      <merID>502-string-value</merID>\n" +
                        "      <merchantUrl>integration test</merchantUrl>\n" +
                        "      <merCountry>578</merCountry>\n" +
                        "      <purchaseAmount>6300</purchaseAmount>\n" +
                        "      <formattedAmount>USD 63.00</formattedAmount>\n" +
                        "      <currencyCode>USD</currencyCode>\n" +
                        "      <numericCurrencyCode>840</numericCurrencyCode>\n" +
                        "      <exponent>2</exponent>\n" +
                        "      <purchaseDesc>Coffee</purchaseDesc>\n" +
                        "      <purchaseDate>" + now + "</purchaseDate>\n" +
                        "      <channel>0</channel>\n" +
                        "      <sID>2</sID>\n" +
                        "      <xid>IWN8Tpt4ft1QcNIxvuMP80MAFmY=</xid>\n" +
                        "      <httpAccept>text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9</httpAccept>\n" +
                        "      <httpAgent>integration test</httpAgent>\n" +
                        "      <cardholderIp>123.456.789.10</cardholderIp>\n" +
                        "      <acsKey></acsKey>\n" +
                        "   </backgroundPareq>\n" +
                        "</backgroundRequest>")
                .when()
                .post("https://lvov.csltd.com.ua/DiPocket3ds/acs/bgAuth.v1");

        res.then().log().all().statusCode(200);
        String response = res.asString();
        System.out.println(res.asString());

        try {
            Document document = initXmlParsing(response);
            BackgroudResponse backgroudResponse = parseXmlResponseSetDataStatusSetPageId(document);
            List<Entry> listEnty = parseXmlSetNameSetValueFromEntryAddThemToCollection(document, backgroudResponse);

            System.out.println(listEnty);
            //System.out.println(backgroudResponse);

            String masName[] = {"TXID", "CANCEL_TEXT", "CONFIRM_TITLE", "CONFIRM_MESSAGE", "MASKED_PAN_TITLE", "MASKED_PAN", "PURCHASEDATE_TITLE", "PURCHASEDATE", "MERCHANTNAME_TITLE", "MERCHANTNAME", "PURCHASEAMOUNT_TITLE", "PURCHASEAMOUNT", "ENTER_CODE_TEXT", "SUBMIT_TEXT"};
            String masValue[] = {randomTXID, "Cancel", "Confirm with SMS code", "To confirm the transaction, please enter below the Code we sent by SMS to 4984", "Card #", "545598******8066", "Date", "" + nowAsExpected + "", "Store", "CH", "Amount", "63.00 USD", "Enter the Code here", "Submit"};

            checkTextInCollectionEntryName(listEnty, masName);
            checkTextInCollectionEntryValue(listEnty, masValue);
            Assert.assertEquals(backgroudResponse.getDataStatus(), "0");
            Assert.assertEquals(backgroudResponse.getPageId(), "sms_web.html");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 44, enabled = false)
    public void test_getTransId_TDSTestServices_v1_tranId_txId_randomTXID() {
        Response res = given()
                .when()
                .header("Content-Type", "application/json")
                .get("http://dipocket3.intranet:8092/TDSTestServices/v1/tranId?txId=" + randomTXID + "");

        res.then().log().all();
        tranId = res.asString();
        System.out.println("tranId " + tranId);
        Assert.assertEquals(200, res.getStatusCode());
    }

    @Test(priority = 45, enabled = false)
    public void test_getSMS_TDSTestServices_v1_tranId_txId_randomTXID() {
        Response res = given()
                .when()
                .header("Content-Type", "application/json")
                .get("http://dipocket3.intranet:8092/TDSTestServices/v1/sms?tranId="+tranId+"");

        res.then().log().all();
        sms = res.asString();
        System.out.println("response " + sms);
        Assert.assertEquals(200, res.getStatusCode());
    }

    @Test(priority = 46, enabled = false)
    public void test_paReqStep2_DiPocket3ds_acs_bgAuth_v1() {
        given()
                .header("Content-Type", "application/xml")
                .body("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                        "<backgroundRequest>\n" +
                        "   <backgroundPageResponse>\n" +
                        "      <txId>" + randomTXID + "</txId>\n" +
                        "      <pageId>sms_web.html</pageId>\n" +
                        "      <values>\n" +
                        "         <entry>\n" +
                        "            <name>SMS_OTP</name>\n" +
                        "            <value>" + sms + "</value>\n" +
                        "         </entry>\n" +
                        "      </values>\n" +
                        "   </backgroundPageResponse>\n" +
                        "</backgroundRequest>")
                .when()
                .post("https://lvov.csltd.com.ua/DiPocket3ds/acs/bgAuth.v1")
                .then()
                .log().all()
                .statusCode(200)
                .body("backgroundResponse.backgroundPares.paresStatus", equalTo("Y"));
    }
}
