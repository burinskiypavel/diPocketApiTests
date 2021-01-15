package tds;

import base.BaseTest;
import io.restassured.response.Response;
import model.BackgroudResponse;
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

public class TDSV1SmsDeclineTest extends BaseTest {
    String randomTXID = app.generateRandomNumber(10);
    String tranId = null;
    String pan4TestSMS = "5455980666358066";

    @Test(priority = 38)
    public void test_veReqAEx1_DiPocket3ds_acs_bgAuth_v1() {
        given()
                .header("Content-Type", "application/xml")
                .body("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                        "<backgroundRequest>\n" +
                        "    <backgroundVereq>\n" +
                        "        <txId>" + randomTXID + "</txId>\n" +
                        "        <pan>" + pan4TestSMS + "</pan>\n" +
                        "        <acqBIN>412321</acqBIN>\n" +
                        "        <merID>501-string-value</merID>\n" +
                        "        <deviceCategory>0</deviceCategory>\n" +
                        "        <userAgent>integration test</userAgent>\n" +
                        "        <messageId>98000</messageId>\n" +
                        "        <Extension id=\"test.3ds.idr\" critical=\"false\">\n" +
                        "        \ttest_value_in_Extension_tag\n" +
                        "        </Extension>\n" +
                        "    </backgroundVereq>\n" +
                        "</backgroundRequest>")
                .when()
                .post("https://lvov.csltd.com.ua/DiPocket3ds/acs/bgAuth.v1")
                .then()
                .statusCode(200)
                .body("backgroundResponse.backgroundVeres.enrollStatus", equalTo("Y"))
                .body("backgroundResponse.backgroundVeres.enrollStatusCode", equalTo("0"))
                .log().all();
    }

    @Test(priority = 39)
    public void test_paReq_DiPocket3ds_acs_bgAuth_v1() throws IOException, SAXException, ParserConfigurationException {
        String now = app.getTimeStamp("YYYYMMdd HH:mm:ss");
        String now2 = app.getTimeStamp("dd.MM.YYYY HH:mm");
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

        Document document = app.getXmlHelper().initXmlParsing(response);
        BackgroudResponse backgroudResponse = app.getXmlHelper().parseXmlResponseSetDataStatusSetPageId(document);
        List<Entry> listEnty = app.getXmlHelper().parseXmlSetNameSetValueFromEntryAddThemToCollection(document, backgroudResponse);

        System.out.println(listEnty);
        //System.out.println(backgroudResponse);

        String masName[] = {"TXID", "CANCEL_TEXT", "CONFIRM_TITLE", "CONFIRM_MESSAGE", "MASKED_PAN_TITLE", "MASKED_PAN", "PURCHASEDATE_TITLE", "PURCHASEDATE", "MERCHANTNAME_TITLE", "MERCHANTNAME", "PURCHASEAMOUNT_TITLE", "PURCHASEAMOUNT", "ENTER_CODE_TEXT", "SUBMIT_TEXT"};
        String masValue[] = {randomTXID, "Cancel", "Confirm with SMS code", "To confirm the transaction, please enter below the Code we sent by SMS to 4984", "Card #", "545598******8066", "Date", "" + now2 + "", "Store", "CH", "Amount", "63.00 USD", "Enter the Code here", "Submit"};

        app.getXmlHelper().checkTextInCollectionEntryName(listEnty, masName);
        app.getXmlHelper().checkTextInCollectionEntryValue(listEnty, masValue);
        Assert.assertEquals(backgroudResponse.getDataStatus(), "0");
        Assert.assertEquals(backgroudResponse.getPageId(), "sms_web.html");
    }

    @Test(priority = 40)
    public void test_getTransId_TDSTestServices_v1_tranId_txId_randomTXID() {
        Response res = given()
                .when()
                .header("Content-Type", "application/json")
                .get("http://dipocket3.intranet:8092/TDSTestServices/v1/tranId?txId=" + randomTXID + "");

        res.then().log().all();
        tranId = res.asString();
        System.out.println("tranId " + tranId);
        Assert.assertEquals(res.getStatusCode(), 200);
    }

    @Test(priority = 41)
    public void test_paReq_DiPocket3ds_acs_bgAuth_v1_() {
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
                        "            <value>123456</value>\n" +
                        "         </entry>\n" +
                        "      </values>\n" +
                        "   </backgroundPageResponse>\n" +
                        "</backgroundRequest>")
                .when()
                .post("https://lvov.csltd.com.ua/DiPocket3ds/acs/bgAuth.v1")
                .then()
                .log().all()
                .statusCode(200)
                .body("backgroundResponse.backgroundPares.paresStatus", equalTo("N"));
    }
}
