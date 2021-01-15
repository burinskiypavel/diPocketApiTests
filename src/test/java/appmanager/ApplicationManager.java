package appmanager;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import io.restassured.RestAssured;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;
import org.testng.Assert;

import javax.net.ssl.SSLContext;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ApplicationManager {
    //public static java.util.Properties prop = new java.util.Properties();
    //static java.util.Properties prop = new java.util.Properties();
    //static String projectPath = System.getProperty("user.dir");
    private XmlHelper xmlHelper = new XmlHelper();
    private DBHelper dbHelper = new DBHelper();
    public String pan = null;
    public String TDSBaseUrl = null;

    //private MailHelper mailHelper;

//    public java.util.Properties loadDataFromConfigFile(){
//        FileInputStream input = null;
//        try {
//            input = new FileInputStream("src\\test\\java\\config\\config.properties");
//            prop.load(input);
//        } catch (Exception exp) {
//            System.out.println(exp.getMessage());
//            System.out.println(exp.getCause());
//            exp.printStackTrace();
//        }
//        return prop;
//    }

    public void initStart() {
        dbHelper.prop = dbHelper.loadDataFromConfigFile();
        pan = dbHelper.prop.getProperty("tds.pan");
        TDSBaseUrl = dbHelper.prop.getProperty("tds.base.url");
    }

    public void init() {
        RestAssured.useRelaxedHTTPSValidation();
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

    public String getTimeStamp(String pattern) {
        String timeStamp = new SimpleDateFormat(pattern).format(Calendar.getInstance().getTime());
        return timeStamp;
    }

    public DBHelper getDbHelper() {
        return dbHelper;
    }

    public XmlHelper getXmlHelper() {
        return xmlHelper;
    }

//    public MailHelper mail(){
//        if(mailHelper == null){
//            mailHelper = new MailHelper(this);
//        }
//        return mailHelper;
//    }
}
