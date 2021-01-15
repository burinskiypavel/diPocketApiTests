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

public class TDSV1PareqAllFieldsTest extends BaseTest {
    String randomTXID = app.generateRandomNumber(10);
    String tranId = null;
    String pan = "5455980836095804";

    @Test(priority = 47)
    public void test_veReqAEx1_DiPocket3ds_acs_bgAuth_v1() {
        given()
                .header("Content-Type", "application/xml")
                .body("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                        "<backgroundRequest>\n" +
                        "    <backgroundVereq>\n" +
                        "        <txId>"+randomTXID+"</txId>\n" +
                        "        <pan>"+pan+"</pan>\n" +
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
                .post(app.getDbHelper().prop.getProperty("tds.base.url")+"/DiPocket3ds/acs/bgAuth.v1")
                .then()
                .statusCode(200)
                .log().all()
                .body("backgroundResponse.backgroundVeres.chName", equalTo(""))
                .body("backgroundResponse.backgroundVeres.enrollStatus", equalTo("Y"))
                .body("backgroundResponse.backgroundVeres.enrollStatusCode", equalTo("0"));
    }

    @Test(priority = 48)
    public void test_paReq_DiPocket3ds_acs_bgAuth_v1() throws IOException, SAXException, ParserConfigurationException {
        String now = app.getTimeStamp("YYYYMMdd HH:mm:ss");
        Response res = given()
                .header("Content-Type", "application/xml")
                .body("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                        "<backgroundRequest>\n" +
                        "   <backgroundPareq>\n" +
                        "      <txId>"+randomTXID+"</txId>\n" +
                        "      <pan>"+pan+"</pan>\n" +
                        "      <expiry>3306</expiry>\n" +
                        "      <acqBIN>501900</acqBIN>\n" +
                        "      <merchant>CH</merchant>\n" +
                        "      <merID>501-string-value</merID>\n" +
                        "      <merchantUrl>integration test</merchantUrl>\n" +
                        "      <merCountry>578</merCountry>\n" +
                        "      <purchaseAmount>6200</purchaseAmount>\n" +
                        "      <formattedAmount>USD 62.00</formattedAmount>\n" +
                        "      <currencyCode>USD</currencyCode>\n" +
                        "      <numericCurrencyCode>840</numericCurrencyCode>\n" +
                        "      <exponent>2</exponent>\n" +
                        "      <purchaseDesc>Coffee</purchaseDesc>\n" +
                        "      <purchaseRecurFreq>4</purchaseRecurFreq>\n" +
                        "      <purchaseRecurEnd>20200520</purchaseRecurEnd>\n" +
                        "      <purchaseInstallments>2</purchaseInstallments>\n" +
                        "      <purchaseDate>"+now+"</purchaseDate>\n" +
                        "      <channel>0</channel>\n" +
                        "      <sID>2</sID>\n" +
                        "      <xid>IWN8Tpt4ft1QcNIxvuMP80MAFmY=</xid>\n" +
                        "      <httpAccept>text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9</httpAccept>\n" +
                        "      <httpAgent>integration test</httpAgent>\n" +
                        "      <cardholderIp>123.456.789.10</cardholderIp>\n" +
                        "      <acsKey>some info</acsKey>\n" +
                        "      <Extension id=\"test.3ds.idr\" critical=\"false\">\n" +
                        "        \t test_value_in_Extension_tag\n" +
                        "        </Extension>\n" +
                        "   </backgroundPareq>\n" +
                        "</backgroundRequest>")
                .when()
                .post(app.getDbHelper().prop.getProperty("tds.base.url")+"/DiPocket3ds/acs/bgAuth.v1");

        res.then().log().all().statusCode(200);
        String response = res.asString();
        System.out.println(res.asString());


        Document document = app.getXmlHelper().initXmlParsing(response);
        BackgroudResponse backgroudResponse = app.getXmlHelper().parseXmlResponseSetDataStatusSetPageId(document);
        List<Entry> listEnty = app.getXmlHelper().parseXmlSetNameSetValueFromEntryAddThemToCollection(document, backgroudResponse);

        System.out.println(listEnty);
        //System.out.println(backgroudResponse);

        String masName[] = {"TXID", "CONFIRM_TITLE", "SMS_SWITCH_MESSAGE", "CONFIRM_MESSAGE", "CONFIRM_MESSAGE_DONE", "SMS_MESSAGE", "CANCEL_TEXT"};
        String masValue[] = {randomTXID, "Confirm with mobile App", "Don’t have App at hand?", "To confirm the transaction, please open, review and confirm the notification we sent to your up and go App", "When done, you need to return to this screen and tap ‘Continue’", "Confirm with SMS code", "Cancel"};

        app.getXmlHelper().checkTextInCollectionEntryName(listEnty, masName);
        app.getXmlHelper().checkTextInCollectionEntryValue(listEnty, masValue);
        Assert.assertEquals(backgroudResponse.getDataStatus(), "0");
        Assert.assertEquals(backgroudResponse.getPageId(), "bio-web.html");
    }
}
