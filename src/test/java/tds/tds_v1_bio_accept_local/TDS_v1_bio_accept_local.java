package tds.tds_v1_bio_accept_local;

import base.BaseTest;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import io.restassured.response.Response;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;
import org.testng.Assert;
import org.testng.annotations.Test;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


import javax.net.ssl.SSLContext;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.events.EndElement;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.filters;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class TDS_v1_bio_accept_local extends BaseTest {
    String txId = generateRandomNumber(10);
    String tranId = null;

    @Test(priority = 1)
    public void test_veReqAEx1_DiPocket3ds_acs_bgAuth_v1() {
        given()
                .header("Content-Type", "application/xml")
                .body("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                        "<backgroundRequest>\n" +
                        "    <backgroundVereq>\n" +
                        "        <txId>" + txId + "</txId>\n" +  //6381223761
                        "        <pan>5455980836095804</pan>\n" +
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

    @Test(priority = 2, enabled = false)
    public void test_paReqStep1_DiPocket3ds_acs_bgAuth_v1_parseFromFile() {
        String now = getTimeStamp();
        Response res = given()
                .header("Content-Type", "application/xml")
                .body("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                        "<backgroundRequest>\n" +
                        "   <backgroundPareq>\n" +
                        "      <txId>" + txId + "</txId>\n" +
                        "      <pan>5455980836095804</pan>\n" +
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
                .post("https://lvov.csltd.com.ua/DiPocket3ds/acs/bgAuth.v1");

        String response = res.toString();

        try {

            File fXmlFile = new File("files/response.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);

            //optional, but recommended
            //read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
            doc.getDocumentElement().normalize();

            System.out.println("\nRoot element :" + doc.getDocumentElement().getNodeName());

            NodeList nList = doc.getElementsByTagName("entry");


            System.out.println("----------------------------");

            for (int temp = 0; temp < nList.getLength(); temp++) {

                Node nNode = nList.item(temp);

                System.out.println("\nCurrent Element :" + nNode.getNodeName());

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element eElement = (Element) nNode;

                    //System.out.println("Staff id : " + eElement.getAttribute("id"));
//                    System.out.println("dataStatus : " + eElement.getElementsByTagName("dataStatus").item(0).getTextContent());
//                    System.out.println("pageId : " + eElement.getElementsByTagName("pageId").item(0).getTextContent());


                    System.out.println("name : " + eElement.getElementsByTagName("name").item(0).getTextContent());
                    System.out.println("value : " + eElement.getElementsByTagName("value").item(0).getTextContent());
                    //System.out.println("Nick Name : " + eElement.getElementsByTagName("nickname").item(0).getTextContent());
                    //System.out.println("Salary : " + eElement.getElementsByTagName("salary").item(0).getTextContent());

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 2)
    public void test_paReqStep1_DiPocket3ds_acs_bgAuth_v1() {
        String now = getTimeStamp();
        Response res = given()
                .header("Content-Type", "application/xml")
                .body("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                        "<backgroundRequest>\n" +
                        "   <backgroundPareq>\n" +
                        "      <txId>" + txId + "</txId>\n" +
                        "      <pan>5455980836095804</pan>\n" +
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
                .post("https://lvov.csltd.com.ua/DiPocket3ds/acs/bgAuth.v1");

        String response = res.asString();
        System.out.println(res.asString());

        try {
            Document document = initXmlParsing(response);
            BackgroudResponse backgroudResponse = parseXmlResponseSetDataStatusSetPageId(document);
            List<Entry> listEnty = parseXmlSetNameSetValueFromEntryAddThemToCollection(document, backgroudResponse);

            System.out.println(listEnty);
            //System.out.println(backgroudResponse);

            String masName[] = {"TXID", "CONFIRM_TITLE", "SMS_SWITCH_MESSAGE", "CONFIRM_MESSAGE", "CONFIRM_MESSAGE_DONE", "SMS_MESSAGE", "CANCEL_TEXT"};
            String masValue[] = {txId, "Confirm with mobile App", "Don’t have App at hand?", "To confirm the transaction, please open, review and confirm the notification we sent to your up and go App", "When done, you need to return to this screen and tap ‘Continue’", "Confirm with SMS code", "Cancel"};

            checkTextInCollectionEntryName(listEnty, masName);
            checkTextInCollectionEntryValue(listEnty, masValue);
            Assert.assertEquals(backgroudResponse.getDataStatus(), "0");
            Assert.assertEquals(backgroudResponse.getPageId(), "bio-web.html");
            Assert.assertEquals(res.getStatusCode(), 200);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Document initXmlParsing(String response) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document document = documentBuilder.parse(new ByteArrayInputStream(response.getBytes()));
        System.out.println("\nRoot element :" + document.getDocumentElement().getNodeName());
        return document;
    }

    public List<Entry> parseXmlSetNameSetValueFromEntryAddThemToCollection(Document document, BackgroudResponse backgroudResponse) {
        List<Entry> listEnty = new ArrayList<>();

        NodeList entryList = document.getElementsByTagName("entry");

        System.out.println("----------------------------");

        for (int i = 0; i < entryList.getLength(); i++) {

            Node nNode = entryList.item(i);

            System.out.println("\nCurrent Element :" + nNode.getNodeName());

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                Element eElement = (Element) nNode;

                Entry entry = new Entry();
                entry.setName(eElement.getElementsByTagName("name").item(0).getTextContent());
                entry.setValue(eElement.getElementsByTagName("value").item(0).getTextContent());

                System.out.println("name : " + eElement.getElementsByTagName("name").item(0).getTextContent());
                System.out.println("value : " + eElement.getElementsByTagName("value").item(0).getTextContent());

                listEnty.add(entry);
                //backgroudResponse.setEntries(listEnty);

            }
        }
        return listEnty;
    }

    public BackgroudResponse parseXmlResponseSetDataStatusSetPageId(Document document) {
        BackgroudResponse backgroudResponse = new BackgroudResponse();

        Element dataStatusElement = (Element) document.getElementsByTagName("dataStatus").item(0);
        System.out.println("dataStatus " + dataStatusElement.getTextContent());
        backgroudResponse.setDataStatus(dataStatusElement.getTextContent());

        Element pageIdElement = (Element) document.getElementsByTagName("pageId").item(0);
        System.out.println("pageId " + pageIdElement.getTextContent());
        backgroudResponse.setPageId(pageIdElement.getTextContent());

        return backgroudResponse;
    }

    @Test(priority = 3)
    public void test_tranStatusStep1_DiPocket3ds_acs_tranStatus_v1() {
        given()
                .header("Content-Type", "application/json")
                .body("{\n" +
                        "\t\"txId\" : " + txId + "\n" +
                        "}")
                .when()
                .post("https://lvov.csltd.com.ua/DiPocket3ds/acs/tranStatus.v1")
                .then()
                .log().all()
                .statusCode(200)
                .body("value", equalTo("AWAITING"));
    }

    @Test(priority = 4)
    public void test_getTransId_TDSTestServices_v1_tranId_txId_randomTXID() {
        Response res = given()
                .when()
                .header("Content-Type", "application/json")
                .get("http://dipocket3.intranet:8092/TDSTestServices/v1/tranId?txId="+txId+"");

        res.then().log().all();
        tranId = res.asString();
        System.out.println("tranId " + tranId);
        Assert.assertEquals(200, res.getStatusCode());
    }

    @Test(priority = 5)
    public void test_tranAccept_ClientServices_v1_tds_tranId_tranAccept() {
        Response response = given()
                .when()
                .auth()
                .preemptive()
                .basic("380730000069", "a111111")
                .header("Content-Type", "application/json")
                .header("SITE", "UPANDGO")
                .header("ClISESSIONID", "123456")
                .post("https://dipocket3.intranet:8900/ClientServices/v1/tds/"+tranId+"/tranAccept");

        response.then().log().all();
        Assert.assertEquals(200, response.getStatusCode());
    }

    @Test(priority = 6)
    public void test_tranStatusStep2_DiPocket3ds_acs_tranStatus_v1() {
        given()
                .header("Content-Type", "application/json")
                .body("{\n" +
                        "\t\"txId\" : "+txId+"\n" +
                        "}")
                .when()
                .post("https://lvov.csltd.com.ua/DiPocket3ds/acs/tranStatus.v1")
                .then()
                .log().all()
                .statusCode(200)
                .body("value", equalTo("ACCEPTED"));
    }

    @Test(priority = 7)
    public void test_paReqStep2_DiPocket3ds_acs_bgAuth_v1() {
        given()
                .header("Content-Type", "application/xml")
                .body("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                        "<backgroundRequest>\n" +
                        "   <backgroundPageResponse>\n" +
                        "      <txId>"+txId+"</txId>\n" +
                        "      <pageId>bio-web.html</pageId>\n" +
                        "      <values>\n" +
                        "         <entry>\n" +
                        "            <name>TXID</name>\n" +
                        "            <value>"+txId+"</value>\n" +
                        "         </entry>\n" +
                        "         <entry>\n" +
                        "            <name>BIO_AUTH</name>\n" +
                        "            <value>ACCEPTED</value>\n" +
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
