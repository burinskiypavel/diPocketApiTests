package appmanager;

import io.restassured.RestAssured;
import io.restassured.config.HttpClientConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.lang3.RandomStringUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import static io.restassured.RestAssured.given;

public class ApplicationManager {
    //public static java.util.Properties prop = new java.util.Properties();
    //static java.util.Properties prop = new java.util.Properties();
    //static String projectPath = System.getProperty("user.dir");
    private XmlHelper xmlHelper = new XmlHelper();
    private DBHelper dbHelper = new DBHelper();
    private TelenorHelper telenorHelper = new TelenorHelper();
    private ResponseValidationHelper responseValidationHelper = new ResponseValidationHelper();
    private Login_RegistrationHelper login_registrationHelper = new Login_RegistrationHelper();
    private AttachmentHelper attachmentHelper = new AttachmentHelper();
    public String pan = null;
    public String TDSBaseUrl = null;
    public String telenorSite = null;
    public String dipocket3_intranet = "https://dipocket3.intranet:8900";
    public String telenorLoginPhone = null;
    public String loginPhone = null;
    public String telenorRegistrationPhone = "380980316499";
    public String telenorRegistrationPhone2 = "380636083315";
    public String fullRegistrationTelenorLoginPhone = null;
    public String bannedPhone = "380639348839";
    public String loginBannedPhone = null;
    public String hexRedColor = "#ff422a";
    public String offloadFundsPhone = "380932485981";
    public String emailsVerificationsFirstName = null;
    public String emailsVerificationsLastName = null;
    public String emailsVerificationsPhoneNumber = null;
    public String emailsVerificationsEmail = null;
    public String emailsVerificationsPass = null;
    public String SITE_REG = "DiPocket®";
    public String mobile_site = null;
    public String mobile_site_discontu = null;
    public String mobile_site_playIt = null;
    public String mobile_site_upAndGo = null;
    public String mobile_site_snowAttack = null;
    public String mobile_site_festival = "FESTIVAL";
    public String mobile_site_sodexo = "SODEXO";
    public String mobile_site_getsby = "GETSBY";
    public String emailsVerificationsCountryId = null;
    public String emailsVerificationsCurrencyId = null;
    public String expectedEmailSender_upAndGo = "wsparcie@upcard.pl";
    public String expectedEmailSender_playIt = "PlayIT Card <customer.service@dipocket.org>";
    public String mobile_login_deviceuuid_tds = "380730000069-AutoTest-Login";
    public String tds_phone = "380730000069";
    public String tds_pass = "a111111";
    public String site = "DiPocket";
    public String site_discontu = "discontu";
    public String site_PlayIT = "PlayIT";
    public String site_upAndGo = "up and go";
    public String site_SnowAttack = "Snow Attack";
    public String site_Sodexo = "Sodexo";
    public String site_Telenor = "Telenor";
    public RequestSpecification requestSpecDipocketRegistration;
    public RequestSpecification requestSpecDiscontuRegistration;
    public RequestSpecification requestSpecPlayITRegistration;
    public RequestSpecification requestSpecUpAndGoRegistration;
    public RequestSpecification requestSpecSnowAttackRegistration;
    public RequestSpecification requestSpecSodexoRegistration;
    public RequestSpecification requestSpecGetsbyRegistration;
    public RequestSpecification requestSpecDipocketHomePage;
    public RequestSpecification requestSpecSnowAttackHomePage;
    public RequestSpecification requestSpecEmailVerification;
    public RequestSpecification requestSpecTelenor;
    public RequestSpecification requestSpecSnowAttack;
    public RequestSpecification requestSpecTDS;
    public RequestSpecification requestSpecTDSJson;
    public RequestSpecification requestSpecPeak;
    public RestAssuredConfig configTimeout;
    public String playITRegistrationPhone = "380636083315";
    public String playITRegistrationEmail = "testdipocket4@gmail.com";
    public String registrationPhone = "380636083315";
    public String registrationEmail = "testdipocket4@gmail.com";


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
        configTimeout = RestAssured.config()
                .httpClient(HttpClientConfig.httpClientConfig()
                        .setParam("http.socket.timeout", 50000)
                        .setParam("http.connection.timeout", 50000));

        dbHelper.prop = dbHelper.loadDataFromConfigFile();
        pan = dbHelper.prop.getProperty("tds.pan");
        TDSBaseUrl = dbHelper.prop.getProperty("tds.base.url");
        telenorSite = "TELENOR";
        //dipocket3_intranet = "https://dipocket3.intranet:8900";
        telenorLoginPhone = dbHelper.prop.getProperty("mobile.registration.phoneNumber");
        loginPhone = "$5_" + telenorLoginPhone; //$5_380685448615
        //telenorRegistrationPhone = "380980316499";
        fullRegistrationTelenorLoginPhone = "$5_" + telenorRegistrationPhone;
        loginBannedPhone = "$5_" + bannedPhone;
        emailsVerificationsFirstName = HelperBase.prop.getProperty("emailsVerifications.firstName");
        emailsVerificationsLastName = HelperBase.prop.getProperty("emailsVerifications.lastName");
        emailsVerificationsPhoneNumber = HelperBase.prop.getProperty("emailsVerifications.phoneNumber");
        emailsVerificationsEmail = HelperBase.prop.getProperty("emailsVerifications.email");
        emailsVerificationsPass = HelperBase.prop.getProperty("emailsVerifications.pass");
        mobile_site = HelperBase.prop.getProperty("mobile.site");
        mobile_site_discontu = HelperBase.prop.getProperty("mobile.site.discontu");
        mobile_site_playIt = HelperBase.prop.getProperty("mobile.site.playIt");
        mobile_site_upAndGo = HelperBase.prop.getProperty("mobile.site.upAndGo");
        mobile_site_snowAttack = HelperBase.prop.getProperty("mobile.site.snowAttack");
        emailsVerificationsCountryId = HelperBase.prop.getProperty("emailsVerifications.countryId");
        emailsVerificationsCurrencyId = HelperBase.prop.getProperty("emailsVerifications.currencyId");

        requestSpecDipocketRegistration = given()
                .baseUri(HelperBase.prop.getProperty("mobile.base.url"))
                .header("site", HelperBase.prop.getProperty("mobile.site"))
                .header("deviceuuid", HelperBase.prop.getProperty("mobile.registration.deviceuuid"));

        requestSpecDiscontuRegistration = given()
                .baseUri(HelperBase.prop.getProperty("mobile.base.url"))
                .header("site", HelperBase.prop.getProperty("mobile.site.discontu"))
                .header("deviceuuid", HelperBase.prop.getProperty("mobile.registration.deviceuuid"));

        requestSpecPlayITRegistration = given()
                .baseUri(HelperBase.prop.getProperty("mobile.base.url"))
                .header("site", HelperBase.prop.getProperty("mobile.site.playIt"))
                .header("deviceuuid", HelperBase.prop.getProperty("mobile.registration.deviceuuid"));

        requestSpecUpAndGoRegistration = given()
                .baseUri(HelperBase.prop.getProperty("mobile.base.url"))
                .header("site", HelperBase.prop.getProperty("mobile.site.upAndGo"))
                .header("deviceuuid", HelperBase.prop.getProperty("mobile.registration.deviceuuid"));

        requestSpecSnowAttackRegistration = given()
                .baseUri(HelperBase.prop.getProperty("web.base.url"))
                .header("site", HelperBase.prop.getProperty("mobile.site.snowAttack"))
                .header("deviceuuid", HelperBase.prop.getProperty("mobile.registration.deviceuuid"));

        requestSpecSodexoRegistration = given()
                .baseUri(HelperBase.prop.getProperty("web.base.url"))
                .header("site", mobile_site_sodexo)
                .header("deviceuuid", HelperBase.prop.getProperty("mobile.registration.deviceuuid"));

        requestSpecGetsbyRegistration = given()
                .baseUri(HelperBase.prop.getProperty("web.base.url"))
                .header("site", mobile_site_getsby)
                .header("deviceuuid", HelperBase.prop.getProperty("mobile.registration.deviceuuid"));

        requestSpecDipocketHomePage = given()
                .baseUri(HelperBase.prop.getProperty("mobile.base.url"))
                .header("site", HelperBase.prop.getProperty("mobile.site"))
                .header("deviceuuid", HelperBase.prop.getProperty("mobile.login.deviceuuid"));

        requestSpecSnowAttackHomePage = given()
                .baseUri(HelperBase.prop.getProperty("mobile.base.url"))
                .header("site", HelperBase.prop.getProperty("mobile.site.snowAttack"));
                //.header("deviceuuid", HelperBase.prop.getProperty("mobile.login.deviceuuid"));

        requestSpecEmailVerification = given()
                .baseUri(dipocket3_intranet)
                .contentType("application/json");

        requestSpecTelenor = given()
                .baseUri(dipocket3_intranet)
                .header("site", telenorSite)
                .contentType("application/json; charset=utf-8");

        requestSpecSnowAttack = given()
                .baseUri(dipocket3_intranet)
                .header("site", mobile_site_snowAttack)
                .contentType("application/json; charset=utf-8");

        requestSpecTDS = given()
                .config(configTimeout)
                .baseUri(TDSBaseUrl)
                .contentType("application/xml");

        requestSpecPeak = given()
                .log().uri().log().headers()
                .config(configTimeout)
                .baseUri("http://dipocket3.intranet:8092/");

        requestSpecTDSJson = given()
                .config(configTimeout)
                .baseUri(TDSBaseUrl)
                .contentType("application/json");
    }

    public void init() {
        RestAssured.useRelaxedHTTPSValidation();
    }

//    public void unirest() throws KeyStoreException, NoSuchAlgorithmException, KeyManagementException, UnirestException {
//        //unirest ssl
//        SSLContext sslcontext = SSLContexts.custom()
//                .loadTrustMaterial(null, new TrustSelfSignedStrategy())
//                .build();
//
//        SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslcontext,SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
//        CloseableHttpClient httpclient = HttpClients.custom()
//                .setSSLSocketFactory(sslsf)
//                .build();
//        Unirest.setHttpClient(httpclient);
//
//        HttpResponse<JsonNode> postResponse = Unirest.put("https://dipocket3.intranet:8900/ClientServices/v1/userRegistration/registrationSavePoint2?value=com.cs.dipocketback.pojo.registration.RegSavepointData@7ae86ada")
//                .header("site", "DIPOCKET")
//                .header("deviceuuid", "eC10LFCnS1mDsuNoQaa-KH")
//                .header("Content-Type", "application/json")
//                .body("{\n" +
//                        "  \"deviceUUID\" : \"eC10LFCnS1mDsuNoQaa-KH\",\n" +
//                        "  \"langId\" : 4,\n" +
//                        "  \"mainPhone\" : \"380685448615\",\n" +
//                        "  \"stepNo\" : 1,\n" +
//                        "  \"registeredAddrAsmail\" : true,\n" +
//                        "  \"address\" : {\n" +
//                        "    \"typeId\" : 0\n" +
//                        "  },\n" +
//                        "  \"regAddress\" : {\n" +
//                        "    \"typeId\" : 3\n" +
//                        "  },\n" +
//                        "  \"attachedCardsList\" : [ ],\n" +
//                        "  \"smsCode\" : \"336052\",\n" +
//                        "  \"isSkipped\" : false,\n" +
//                        "  \"address1\" : {\n" +
//                        "    \"typeId\" : 0\n" +
//                        "  },\n" +
//                        "  \"attachedCardIds\" : [ ]\n" +
//                        "}")
//                .asJson();
//        //.asString();
//        //.getBody();
//        System.out.println(postResponse.getBody());
//        //bearer = postResponse.getBody().getObject().getString("bearer");
//        //System.out.println("bearer " + postResponse.getBody().getObject().getString("bearer"));
//        Assert.assertNotNull(postResponse.getBody());
//    }

    public String generateRandomString(int amount){
        String randomString =  RandomStringUtils.random(amount, true, true);
        return randomString;
    }

    public String generateRandomNumber(int amount){
        String randomNumber =  RandomStringUtils.random(amount, false, true);
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

    public TelenorHelper getTelenorHelper() { return telenorHelper; }

    public ResponseValidationHelper getResponseValidationHelper() { return responseValidationHelper; }

    public Login_RegistrationHelper getLogin_registrationHelper() {
        return login_registrationHelper;
    }

    public AttachmentHelper getAttachmentHelper() {
        return attachmentHelper;
    }

//    public MailHelper mail(){
//        if(mailHelper == null){
//            mailHelper = new MailHelper(this);
//        }
//        return mailHelper;
//    }
}
