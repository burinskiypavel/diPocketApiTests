package tests.tds;

import appmanager.HelperBase;
import base.TestBase;
import io.restassured.response.Response;

import model.BackgroudResponse;
import model.Entry;
import org.testng.annotations.Test;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.testng.Assert.assertEquals;

public class TDSV1BioAcceptTest extends TestBase {
    String randomTXID = app.generateRandomNumber(10);
    String tranId = null;

    @Test(priority = 1)
    public void test_veReqAEx1_DiPocket3ds_acs_bgAuth_v1() {
        System.out.println("app.TDSBaseUrl: " + app.TDSBaseUrl + " txid: " + randomTXID + " pan: " + app.pan);
        given().log().uri().log().headers().log().body()
                .spec(app.requestSpecTDS)
                .body("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                        "<backgroundRequest>\n" +
                        "    <backgroundVereq>\n" +
                        "        <txId>" + randomTXID + "</txId>\n" +
                        "        <pan>" + app.pan + "</pan>\n" +
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
                .post("/DiPocket3ds/acs/bgAuth.v1")
                .then().log().all()
                .statusCode(200)
                .body("backgroundResponse.backgroundVeres.chName", equalTo(""),
                        "backgroundResponse.backgroundVeres.enrollStatus", equalTo("Y"),
                                "backgroundResponse.backgroundVeres.enrollStatusCode", equalTo("0"));
    }

    @Test(priority = 2)
    public void test_paReq_DiPocket3ds_acs_bgAuth_v1() throws IOException, SAXException, ParserConfigurationException {
        String now = app.getTimeStamp("YYYYMMdd HH:mm:ss");
        System.out.println("txid: " + randomTXID + " pan: " + app.pan + " now: " + now);
        Response res = given().log().uri().log().headers().log().body()
                .spec(app.requestSpecTDS)
                .body("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                        "<backgroundRequest>\n" +
                        "   <backgroundPareq>\n" +
                        "      <txId>" + randomTXID + "</txId>\n" +
                        "      <pan>" + app.pan + "</pan>\n" +
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
                .post("/DiPocket3ds/acs/bgAuth.v1");

        res.then().log().all();
        String response = res.asString();
        System.out.println(res.asString());

        Document document = app.getXmlHelper().initXmlParsing(response);
        BackgroudResponse backgroudResponse = app.getXmlHelper().parseXmlResponseSetDataStatusSetPageId(document);
        List<Entry> listEnty = app.getXmlHelper().parseXmlSetNameSetValueFromEntryAddThemToCollection(document, backgroudResponse);

        System.out.println(listEnty);
        //System.out.println(backgroudResponse);

        String[] masName = {"TXID", "CONFIRM_TITLE", "SMS_SWITCH_MESSAGE", "CONFIRM_MESSAGE", "CONFIRM_MESSAGE_DONE", "SMS_MESSAGE", "CANCEL_TEXT"};
        String[] masValue = {randomTXID, "Confirm with mobile App", "Don’t have App at hand?", "To confirm the transaction, please open, review and confirm the notification we sent to your up and go App", "When done, you need to return to this screen and tap ‘Continue’", "Confirm with SMS code", "Cancel"};

        assertEquals(res.getStatusCode(), 200);
        app.getXmlHelper().checkTextInCollectionEntryName(listEnty, masName);
        app.getXmlHelper().checkTextInCollectionEntryValue(listEnty, masValue);
        assertEquals(backgroudResponse.getDataStatus(), "0");
        assertEquals(backgroudResponse.getPageId(), "bio-web.html");
    }

    @Test(priority = 3)
    public void test_tranStatus_DiPocket3ds_acs_tranStatus_v1() {
        System.out.println("txid: " + randomTXID);
        given().log().uri().log().headers().log().body()
                .contentType("application/json")
                .body("{\n" +
                        "\t\"txId\" : \"" + randomTXID + "\"\n" +
                        "}")
                .when()
                .post(app.TDSBaseUrl+"/DiPocket3ds/acs/tranStatus.v1")
                .then().log().all()
                .statusCode(200)
                .body("value", equalTo("AWAITING"));
    }

    @Test(priority = 4)
    public void test_getTransId_TDSTestServices_v1_tranId_txId_randomTXID() {
        System.out.println("txid: " + randomTXID);
        Response res = given().log().uri().log().headers().log().body()
                .when()
                .header("Content-Type", "application/json")
                .get("http://dipocket3.intranet:8092/TDSTestServices/v1/tranId?txId=" + randomTXID + "");

        res.then().log().all();
        tranId = res.asString();
        System.out.println("tranId " + tranId);
        assertEquals(res.getStatusCode(), 200);
    }

    @Test(priority = 5)
    public void test_tranAccept_ClientServices_v1_tds_tranId_tranAccept() throws SQLException, ClassNotFoundException {
        System.out.println("tranId: " + tranId);
        String cliSessionId = app.getLogin_registrationHelper().loginUpAndGo(app.tds_phone, app.tds_pass, app.mobile_login_deviceuuid_tds);
        Response response = given().log().uri().log().headers().log().body()
                .auth().preemptive().basic("10_"+app.tds_phone, app.tds_pass)
                .contentType("application/json")
                .header("SITE", app.mobile_site_upAndGo)
                .header("ClISESSIONID", cliSessionId)
                .when()
                .post("https://dipocket3.intranet:8900/ClientServices/v1/tds/" + tranId + "/tranAccept");

        response.then().log().all();
        assertEquals(response.getStatusCode(), 200);
    }

    @Test(priority = 6)
    public void test_tranStatus_DiPocket3ds_acs_tranStatus_v1_() {
        System.out.println("txid: " + randomTXID);
        given().log().uri().log().headers().log().body()
                .contentType("application/json")
                .body("{\n" +
                        "\t\"txId\" : \"" + randomTXID + "\"\n" +
                        "}")
                .when()
                .post(app.TDSBaseUrl+"/DiPocket3ds/acs/tranStatus.v1")
                .then().log().all()
                .statusCode(200)
                .body("value", equalTo("ACCEPTED"));
    }

    @Test(priority = 7)
    public void test_paReq_DiPocket3ds_acs_bgAuth_v1_() {
        System.out.println("txid: " + randomTXID);
        given().log().uri().log().headers().log().body()
                .spec(app.requestSpecTDS)
                .body("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                        "<backgroundRequest>\n" +
                        "   <backgroundPageResponse>\n" +
                        "      <txId>" + randomTXID + "</txId>\n" +
                        "      <pageId>bio-web.html</pageId>\n" +
                        "      <values>\n" +
                        "         <entry>\n" +
                        "            <name>TXID</name>\n" +
                        "            <value>" + randomTXID + "</value>\n" +
                        "         </entry>\n" +
                        "         <entry>\n" +
                        "            <name>BIO_AUTH</name>\n" +
                        "            <value>ACCEPTED</value>\n" +
                        "         </entry>\n" +
                        "      </values>\n" +
                        "   </backgroundPageResponse>\n" +
                        "</backgroundRequest>")
                .when()
                .post("/DiPocket3ds/acs/bgAuth.v1")
                .then().log().all()
                .statusCode(200)
                .body("backgroundResponse.backgroundPares.paresStatus", equalTo("Y"));
    }
}