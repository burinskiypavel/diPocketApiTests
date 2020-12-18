package base;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.sun.org.apache.xpath.internal.objects.XString;
import io.restassured.RestAssured;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import tds.tds_v1_bio_accept_local.Entry;


import javax.net.ssl.SSLContext;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

public class BaseTest extends ApplicationManager {
   public static java.util.Properties prop = new java.util.Properties();

    @BeforeClass
    public void start() {
        prop = loadDataFromConfigFile();
    }

    @BeforeTest
    public void setUp(){
        RestAssured.useRelaxedHTTPSValidation();
    }

    public String getSMSCodeFromDB(String number) throws ClassNotFoundException, SQLException {
        String dbUrl = "jdbc:oracle:thin:@"+prop.getProperty("db.url")+"";
        String username = prop.getProperty("db.username");
        String password = prop.getProperty("db.password");
        String query = "select * from VERIFYPHONECODE where PHONE = '"+number+"'";

        Class.forName("oracle.jdbc.driver.OracleDriver");

        Connection con = DriverManager.getConnection(dbUrl, username, password);

        Statement stmt = con.createStatement();

        ResultSet rs= stmt.executeQuery(query);

        String smsCode = null;
        while (rs.next()){
            String numberFromDB = rs.getString(1);
            smsCode = rs.getString(2);

            System. out.println(numberFromDB+"  "+smsCode);
        }
        con.close();
        return smsCode;
    }

//    public void deleteClientFromDB2() throws SQLException, ClassNotFoundException {
//        //Connection con = DriverManager.getConnection(dbUrl,username,password);
//        String dbUrl = "jdbc:oracle:thin:@dipocket1.intranet/dip";
//        //Database Username
//        String username = "Dipocket";
//        String password = "c67";
//        //Querry to Execute
//        String query = "BEGIN\n" +
//                "PKI_CLIENT.CLEARCLIENTBYPHONE(p_Site=>'DIPOCKET',p_Phone=>'380685448615');\n" +
//                "END;";
//
//        String query2 = "commit";
//
//        Class.forName("oracle.jdbc.driver.OracleDriver");
//
//        //Create Connection to DB
//        Connection con = DriverManager.getConnection(dbUrl, username, password);
//
//        //Create Statement Object
//        Statement stmt = con.createStatement();
//
//        // Execute the SQL Query. Store results in ResultSet
//        ResultSet rs= stmt.executeQuery(query);
//        ResultSet rs2= stmt.executeQuery(query2);
//
//        // closing DB Connection
//        con.close();
//    }

    public void deleteClientFromDB(String number) throws SQLException, ClassNotFoundException {
        String dbUrl = "jdbc:oracle:thin:@"+prop.getProperty("db.url")+"";
        String username = prop.getProperty("db.username");
        String password = prop.getProperty("db.password");

        String query2 = "commit";

        Class.forName("oracle.jdbc.driver.OracleDriver");

        Connection connection = DriverManager.getConnection(dbUrl, username, password);

        CallableStatement myCall = connection.prepareCall("{call PKI_CLIENT.CLEARCLIENTBYPHONE(p_Site=>'DIPOCKET',p_Phone=>'"+number+"')}");
        myCall.executeUpdate();

        Statement stmt = connection.createStatement();

        ResultSet rs2= stmt.executeQuery(query2);

        connection.close();
    }

    public String getClientDeviceFromDB(String number, String uuid) throws ClassNotFoundException, SQLException {
        String dbUrl = "jdbc:oracle:thin:@"+prop.getProperty("db.url")+"";
        String username = prop.getProperty("db.username");
        String password = prop.getProperty("db.password");
        String query = "select ID from CLIENTDEVICE\n" +
                "where uuid = '"+uuid+"'\n" +
                "and clientid = (select id from client where MAINPHONE = '"+number+"' and site = 'DIPOCKET')";

        Class.forName("oracle.jdbc.driver.OracleDriver");

        Connection con = DriverManager.getConnection(dbUrl, username, password);

        Statement stmt = con.createStatement();

        ResultSet rs= stmt.executeQuery(query);

        String clientDevice = null;
        while (rs.next()){
            clientDevice = rs.getString(1);

            System. out.println("Client device: " +clientDevice);
        }
        con.close();
        return clientDevice;
    }

    public String getLoginSMSFromDB(String number, String uuid) throws ClassNotFoundException, SQLException {
        String clienDevice = getClientDeviceFromDB(number, uuid);

        String dbUrl = "jdbc:oracle:thin:@"+prop.getProperty("db.url")+"";
        String username = prop.getProperty("db.username");
        String password = prop.getProperty("db.password");
        String query = "select CODE from VERIFYCODE where SRCID = '"+clienDevice+"'";

        Class.forName("oracle.jdbc.driver.OracleDriver");

        Connection con = DriverManager.getConnection(dbUrl, username, password);

        Statement stmt = con.createStatement();

        ResultSet rs= stmt.executeQuery(query);

        String smsLoginCode = null;
        while (rs.next()){
            smsLoginCode = rs.getString(1);

            System. out.println("smsLoginCode: " +smsLoginCode);
        }
        con.close();
        return smsLoginCode;
    }

    public void deleteClientDeviceFromDB(String clientDevice) throws ClassNotFoundException, SQLException {
        String dbUrl = "jdbc:oracle:thin:@"+prop.getProperty("db.url")+"";
        String username = prop.getProperty("db.username");
        String password = prop.getProperty("db.password");
        String query = "delete from clientdevice where uuid = '"+clientDevice+"'";
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection(dbUrl, username, password);
        Statement stmt = con.createStatement();
        ResultSet rs= stmt.executeQuery(query);
        con.close();
    }

    public void unirest() throws KeyStoreException, NoSuchAlgorithmException, KeyManagementException, UnirestException {
        //unirest ssl
        SSLContext sslcontext = SSLContexts.custom()
                .loadTrustMaterial(null, new TrustSelfSignedStrategy())
                .build();

        SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslcontext,SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
        CloseableHttpClient httpclient = HttpClients.custom()
                .setSSLSocketFactory(sslsf)
                .build();
        Unirest.setHttpClient(httpclient);

        HttpResponse<JsonNode> postResponse = Unirest.put("https://dipocket3.intranet:8900/ClientServices/v1/userRegistration/registrationSavePoint2?value=com.cs.dipocketback.pojo.registration.RegSavepointData@7ae86ada")
                .header("site", "DIPOCKET")
                .header("deviceuuid", "eC10LFCnS1mDsuNoQaa-KH")
                .header("Content-Type", "application/json")
                .body("{\n" +
                        "  \"deviceUUID\" : \"eC10LFCnS1mDsuNoQaa-KH\",\n" +
                        "  \"langId\" : 4,\n" +
                        "  \"mainPhone\" : \"380685448615\",\n" +
                        "  \"stepNo\" : 1,\n" +
                        "  \"registeredAddrAsmail\" : true,\n" +
                        "  \"address\" : {\n" +
                        "    \"typeId\" : 0\n" +
                        "  },\n" +
                        "  \"regAddress\" : {\n" +
                        "    \"typeId\" : 3\n" +
                        "  },\n" +
                        "  \"attachedCardsList\" : [ ],\n" +
                        "  \"smsCode\" : \"336052\",\n" +
                        "  \"isSkipped\" : false,\n" +
                        "  \"address1\" : {\n" +
                        "    \"typeId\" : 0\n" +
                        "  },\n" +
                        "  \"attachedCardIds\" : [ ]\n" +
                        "}")
                .asJson();
        //.asString();
        //.getBody();
        System.out.println(postResponse.getBody());
        //bearer = postResponse.getBody().getObject().getString("bearer");
        //System.out.println("bearer " + postResponse.getBody().getObject().getString("bearer"));
        Assert.assertNotNull(postResponse.getBody());
    }

    public String generateRandomString(int count){
        String randomString =  RandomStringUtils.random(count, true, true);
        return randomString;
    }

    public String generateRandomNumber(int count){
        String randomNumber =  RandomStringUtils.random(count, false, true);
        return randomNumber;
    }

    public String getTimeStamp() {
        String timeStamp = new SimpleDateFormat("YYYYMMdd HH:mm:ss").format(Calendar.getInstance().getTime());
        return timeStamp;
    }

    public void checkTextInCollectionEntryName(List<Entry> listEnty, String text) {
        List<Entry> result = listEnty.stream()
                .filter(line -> text.equals(line.getName()))
                .collect(Collectors.toList());

        if(result.size() == 0){
            Assert.fail("Filter result is empty " + text + " is not in the list");
        }
        for(Entry element : result){
            element.getName();
            Assert.assertEquals(element.getName(), text);
        }
    }

    public void checkTextInCollectionEntryName(List<Entry> listEnty, String[] textArr) {
        for(int i = 0; i < textArr.length; i++) {
            int finalI = i;
            List<Entry> result = listEnty.stream()
                    .filter(line -> textArr[finalI].equals(line.getName()))
                    .collect(Collectors.toList());

            if(result.size() == 0){
                Assert.fail("Filter result is empty " + textArr[i]+ " is not in the list");
            }

            for (Entry element : result) {
                element.getName();
                Assert.assertEquals(element.getName(), textArr[i]);
            }

        }
    }

    public void checkTextInCollectionEntryValue(List<Entry> listEnty, String[] textArr) {
        for(int i = 0; i < textArr.length; i++) {
            int finalI = i;
            List<Entry> result = listEnty.stream()
                    .filter(line -> textArr[finalI].equals(line.getValue()))
                    .collect(Collectors.toList());

            if(result.size() == 0){
                Assert.fail("Filter result is empty " + textArr[i]+ " is not in the list");
            }

            for (Entry element : result) {
                element.getValue();
                Assert.assertEquals(element.getValue(), textArr[i]);
            }

        }
    }

    public void checkTextInCollectionEntryValue(List<Entry> listEnty, String text) {
        List<Entry> result = listEnty.stream()
                .filter(line -> text.equals(line.getValue()))
                .collect(Collectors.toList());
        if(result.size() == 0){
            Assert.fail("Filter result is empty " + text + " is not in the list");
        }
        for(Entry element : result){
            element.getName();
            Assert.assertEquals(element.getValue(), text);
        }
    }
}
