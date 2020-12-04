package base;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;
import org.testng.Assert;

import javax.net.ssl.SSLContext;
import java.io.FileInputStream;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.sql.*;

public class BaseTest extends ApplicationManager {

    public String getSMSCodeFromDB(String number) throws ClassNotFoundException, SQLException {
        String dbUrl = "jdbc:oracle:thin:@"+prop.getProperty("dbUrl")+"";
        String username = prop.getProperty("dbUsername");
        String password = prop.getProperty("dbPassword");
        //Querry to Execute
        String query = "select * from VERIFYPHONECODE where PHONE = '"+number+"'";

        Class.forName("oracle.jdbc.driver.OracleDriver");

        //Create Connection to DB
        Connection con = DriverManager.getConnection(dbUrl, username, password);

        //Create Statement Object
        Statement stmt = con.createStatement();

        // Execute the SQL Query. Store results in ResultSet
        ResultSet rs= stmt.executeQuery(query);

        // While Loop to iterate through all data and print results
        String smsCode = null;
        while (rs.next()){
            String numberFromDB = rs.getString(1);
            smsCode = rs.getString(2);

            System. out.println(numberFromDB+"  "+smsCode);
        }
        // closing DB Connection
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
        String dbUrl = "jdbc:oracle:thin:@dipocket1.intranet/dip";

        //Database Username
        String username = "Dipocket";
        String password = "c67";

        String query2 = "commit";

        Class.forName("oracle.jdbc.driver.OracleDriver");

        //Create Connection to DB
        Connection connection = DriverManager.getConnection(dbUrl, username, password);

        CallableStatement myCall = connection.prepareCall("{call PKI_CLIENT.CLEARCLIENTBYPHONE(p_Site=>'DIPOCKET',p_Phone=>'"+number+"')}");
        myCall.executeUpdate();

        //Create Statement Object
        Statement stmt = connection.createStatement();

        // Execute the SQL Query. Store results in ResultSet
        ResultSet rs2= stmt.executeQuery(query2);

        // closing DB Connection
        connection.close();
    }

    public String getClientDeviceFromDB(String number, String uuid) throws ClassNotFoundException, SQLException {
        String dbUrl = "jdbc:oracle:thin:@dipocket1.intranet/dip";
        String username = "Dipocket";
        String password = "c67";
        //Querry to Execute
        String query = "select ID from CLIENTDEVICE\n" +
                "where uuid = '"+uuid+"'\n" +
                "and clientid = (select id from client where MAINPHONE = '"+number+"' and site = 'DIPOCKET')";

        Class.forName("oracle.jdbc.driver.OracleDriver");

        //Create Connection to DB
        Connection con = DriverManager.getConnection(dbUrl, username, password);

        //Create Statement Object
        Statement stmt = con.createStatement();

        // Execute the SQL Query. Store results in ResultSet
        ResultSet rs= stmt.executeQuery(query);

        // While Loop to iterate through all data and print results
        String clientDevice = null;
        while (rs.next()){
            clientDevice = rs.getString(1);

            System. out.println("Client device: " +clientDevice);
        }
        // closing DB Connection
        con.close();
        return clientDevice;
    }

    public String getLoginSMSFromDB(String number, String uuid) throws ClassNotFoundException, SQLException {
        String clienDevice = getClientDeviceFromDB(number, uuid);

        String dbUrl = "jdbc:oracle:thin:@dipocket1.intranet/dip";
        String username = "Dipocket";
        String password = "c67";
        //Querry to Execute
        String query = "select CODE from VERIFYCODE where SRCID = '"+clienDevice+"'";

        Class.forName("oracle.jdbc.driver.OracleDriver");

        //Create Connection to DB
        Connection con = DriverManager.getConnection(dbUrl, username, password);

        //Create Statement Object
        Statement stmt = con.createStatement();

        // Execute the SQL Query. Store results in ResultSet
        ResultSet rs= stmt.executeQuery(query);

        // While Loop to iterate through all data and print results
        String smsLoginCode = null;
        while (rs.next()){
            smsLoginCode = rs.getString(1);

            System. out.println("smsLoginCode: " +smsLoginCode);
        }
        // closing DB Connection
        con.close();
        return smsLoginCode;
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

        // unirest 2
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
        //Assert.assertEquals("Success", postResponse.getBody().getObject().getString("authStatus"));
    }
}
