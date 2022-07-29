package tests.tds;

import base.TestBase;
import io.restassured.response.Response;
import model.BackgroudResponse;
import model.Entry;
import org.testng.annotations.Test;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.testng.Assert.assertEquals;

public class TDSV1EPINAcceptTest extends TestBase {
    String randomTXID = app.generateRandomNumber(10);
    String tranId = null;
    String pan4TestEPIN = "5455980630924647";
    String ePIN = "2566";

    @Test(priority = 1)
    public void test_veReqAEx1_TDSServices_acs_bgAuth_v1() {
        given()
                .spec(app.requestSpecTDS)
                .body("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                        "<backgroundRequest>\n" +
                        "    <backgroundVereq>\n" +
                        "        <txId>" + randomTXID + "</txId>\n" +
                        "        <pan>" + pan4TestEPIN + "</pan>\n" +
                        "        <acqBIN>502502</acqBIN>\n" +
                        "        <merID>502-string-value</merID>\n" +
                        "        <deviceCategory>0</deviceCategory>\n" +
                        "        <userAgent>integration test</userAgent>\n" +
                        "        <messageId>integration test</messageId>\n" +
                        "        <Extension id=\"test.3ds.idr\" critical=\"false\">\n" +
                        "        \ttest_value_in_Extension_tag\n" +
                        "        </Extension>\n" +
                        "    </backgroundVereq>\n" +
                        "</backgroundRequest>")
                .when()
                .post("/TDSServices/acs/bgAuth.v1")
                .then().log().all()
                .statusCode(200)
                .body("backgroundResponse.backgroundVeres.enrollStatus", equalTo("Y"),
                        "backgroundResponse.backgroundVeres.enrollStatusCode", equalTo("0"),
                                "backgroundResponse.backgroundVeres.chName", equalTo("DON'TTOUCH"));
    }

    @Test(priority = 2)
    public void test_paReq_TDSServices_acs_bgAuth_v1() throws IOException, SAXException, ParserConfigurationException {
        String now = app.getTimeStamp("YYYYMMdd HH:mm:ss");
        String nowAsExpected = app.getTimeStamp("dd.MM.YYYY HH:mm");
        Response res = given()
                .spec(app.requestSpecTDS)
                .body("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                        "<backgroundRequest>\n" +
                        "   <backgroundPareq>\n" +
                        "      <txId>" + randomTXID + "</txId>\n" +
                        "      <pan>" + pan4TestEPIN + "</pan>\n" +
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
                .post("/TDSServices/acs/bgAuth.v1");

        res.then().log().all().statusCode(200);
        String response = res.asString();
        System.out.println(res.asString());

        Document document = app.getXmlHelper().initXmlParsing(response);
        BackgroudResponse backgroudResponse = app.getXmlHelper().parseXmlResponseSetDataStatusSetPageId(document);
        List<Entry> listEnty = app.getXmlHelper().parseXmlSetNameSetValueFromEntryAddThemToCollection(document, backgroudResponse);

        System.out.println(listEnty);
        //System.out.println(backgroudResponse);

        String masName[] = {"TXID", "CANCEL_TEXT", "CONFIRM_TITLE", "CONFIRM_MESSAGE", "MASKED_PAN_TITLE", "MASKED_PAN", "PURCHASEDATE_TITLE", "PURCHASEDATE", "MERCHANTNAME_TITLE", "MERCHANTNAME", "PURCHASEAMOUNT_TITLE", "PURCHASEAMOUNT", "ENTER_CODE_TEXT", "SUBMIT_TEXT"};
        String masValue[] = {randomTXID, "Cancel", "Confirm with SMS code", "To confirm the transaction, please enter below the Code we sent by SMS to 4984", "Card #", "545598******8066", "Date", "" + nowAsExpected + "", "Store", "CH", "Amount", "63.00 USD", "Enter the Code here", "Submit"};

        app.getXmlHelper().checkTextInCollectionEntryName(listEnty, masName);
        app.getXmlHelper().checkTextInCollectionEntryValue(listEnty, masValue);
        assertEquals(backgroudResponse.getDataStatus(), "0");
        assertEquals(backgroudResponse.getPageId(), "sms_web.html");
    }

    @Test(priority = 3)
    public void test_getTransId_TDSTestServices_v1_tranId_txId_randomTXID() {
        Response res = given()
                //.config(app.configTimeout)
                //.contentType("application/json")
                .spec(app.requestSpecTDSJson)
                .when()
                .get("/TDSTestServices/v1/tranId?txId=" + randomTXID + "");

        res.then().log().all();
        tranId = res.asString();
        System.out.println("tranId " + tranId);
        assertEquals(res.getStatusCode(), 200);
    }

    @Test(priority = 4, enabled = false)
    public void test_getSMS_TDSTestServices_v1_sms_tranId_tranId() {
        Response res = given()
                //.config(app.configTimeout)
                //.contentType("application/json")
                .spec(app.requestSpecTDSJson)
                .when()
                .get("/TDSTestServices/v1/sms?tranId=" + tranId + "");

        res.then().log().all();
        ePIN = res.asString();
        System.out.println("response " + ePIN);
        assertEquals(res.getStatusCode(), 200);
    }

    @Test(priority = 5)
    public void test_paReq_TDSServices_acs_bgAuth_v1_() {
        given()
                .spec(app.requestSpecTDS)
                .body("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                        "<backgroundRequest>\n" +
                        "   <backgroundPageResponse>\n" +
                        "      <txId>" + randomTXID + "</txId>\n" +
                        "      <pageId>sms_web.html</pageId>\n" +
                        "      <values>\n" +
                        "         <entry>\n" +
                        "            <name>SMS_OTP</name>\n" +
                        "            <value>" + ePIN + "</value>\n" +
                        "         </entry>\n" +
                        "      </values>\n" +
                        "   </backgroundPageResponse>\n" +
                        "</backgroundRequest>")
                .when()
                .post("/TDSServices/acs/bgAuth.v1")
                .then().log().all()
                .statusCode(200)
                .body("backgroundResponse.backgroundPares.paresStatus", equalTo("Y"));
    }
}