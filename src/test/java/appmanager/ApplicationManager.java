package appmanager;

import appmanager.ui.UITelenorHelper;
import appmanager.ui.UIBOHelper;
import appmanager.ui.UIUpAndGoHelper;
import io.restassured.RestAssured;
import io.restassured.config.HttpClientConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.config.SSLConfig;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import requests.aspsp.ConsentsRequests;
import requests.bo.BORequests;
import requests.bo.ClientProfileRequests;
import requests.clientServices.ClientServicesRequests;
import requests.customerServices.CustomerServicesRequests;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import static io.restassured.RestAssured.given;

public class ApplicationManager {
    //public static java.util.Properties prop = new java.util.Properties();
    //static java.util.Properties prop = new java.util.Properties();
    //static String projectPath = System.getProperty("user.dir");
    public WebDriver driver;
    public WebDriverWait wait;

    private XmlHelper xmlHelper = new XmlHelper();
    private DBHelper dbHelper = new DBHelper();
    private TelenorHelper telenorHelper = new TelenorHelper();
    private ResponseValidationHelper responseValidationHelper = new ResponseValidationHelper();
    private Login_RegistrationHelper login_registrationHelper = new Login_RegistrationHelper();
    private AttachmentHelper attachmentHelper = new AttachmentHelper();
    private BOHelper boHelper = new BOHelper();
    private SSLCertHelper sslCertHelper = new SSLCertHelper();
    private BankIntegrationHelper bankIntegrationHelper = new BankIntegrationHelper();
    private JsonHelper jsonHelper = new JsonHelper();
    private TimeStampHelper timeStampHelper = new TimeStampHelper();
    private BORequests boRequestsHelper = new BORequests();
    private ConsentsRequests consentsRequestsHelper = new ConsentsRequests();
    private ClientServicesRequests clientServicesRequestsHelper = new ClientServicesRequests();
    private CustomerServicesRequests customerServicesRequestsHelper = new CustomerServicesRequests();
    private ClientProfileRequests clientProfileRequestsHelper = new ClientProfileRequests();
    //private ClientServicesRequests clientServicesRequests = new ClientServicesRequests();
    public UIBOHelper uiboHelper;
    public UIUpAndGoHelper uiUpAndGoHelper;
    public UITelenorHelper uiTelenorHelper;
    public String pan = null;
    public String TDSBaseUrl = null;
    public String telenorSite = null;
    public String dipocket3_intranet = "https://dipocket3.intranet:8900";
    public String baseURL = null;
    public String telenorLoginPhone = "380685448616";
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
    public String tds_phone = null;
    public String tds_pass = null;
    public String site = "DiPocket";
    public String site_discontu = "discontu";
    public String site_PlayIT = "Eventure Card";
    public String site_upAndGo = "up and go";
    public String site_SnowAttack = "Snow Attack";
    public String site_Sodexo = "Sodexo";
    public String site_Telenor = "Telenor";
    public String mobile_registration_phoneNumber = "380685448616";
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
    public RequestSpecification requestSpecBO;
    public RequestSpecification requestSpecBOTest;
    public RequestSpecification requestSpecCustomerServicesTest;
    public RequestSpecification requestSpecASPSPTest;
    public RestAssuredConfig configTimeout;
    public String playITRegistrationPhone = "380636083315";
    public String playITRegistrationEmail = "testdipocket4@gmail.com";
    public String registrationPhone = "380636083315";
    public String registrationEmail = "testdipocket4@gmail.com";
    //public String BOURL = "https://support.dipocket.dev";
    public String BOURL = null;
    public String BOTestURL = null;
    public String baseTestURL = null;
    public String CBOuserLogin = null;
    public String CBOuserPass = null;
    public String CBOusername = null;
    public String CBOuserLogin2 = null;
    public String CBOuserPass2 = null;
    public String CBOusername2 = null;
    public String CBOuserLogin3 = null;
    public String CBOuserPass3 = null;
    public String BOuserLogin2 = null;
    public String BOuserPass2 = null;
    public String BOuserLogin = null;
    public String BOuserPass = null;
    public String BOusername = null;
    public String homePageLoginPhone = null;
    public String homePagePass = null;
    public int homePageClientId = 40263;
    public String sandboxLogin = null;
    public String sandboxPass = null;
    public String boUserLogin_test = null;
    public String boUserPass_test = null;
    public String cboUserLogin_test = null;
    public String cboUserPass_test = null;
    public String cboUsername_test = "PAVELB_CBO";
    public String bankIntegrationPaymentsLogin = null;
    public String bankIntegrationPaymentPass = null;
    public String mobileRegPass = null;
    public String mobileRegPhone = "380685448616";

    public String testEverypayPhone = null;
    public String testEverypayPass = null;
    public String testPaybanLogin = null;
    public String testPaybanPass = null;
    public String testOpenbankingUrl = "https://openbanking.dipocket.site";

    public void initStart() {
//        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
//        ChromeOptions chromeOptions = new ChromeOptions();
//        //chromeOptions.addArguments("--headless");
//        //WebDriverManager.chromedriver().version("88").setup();
//        driver = new ChromeDriver(chromeOptions);
//        driver.manage().window().maximize();
//        wait = new WebDriverWait(driver, 20);


        uiboHelper = new UIBOHelper(driver);
        uiUpAndGoHelper = new UIUpAndGoHelper(driver);
        uiTelenorHelper = new UITelenorHelper(driver);
        configTimeout = RestAssured.config()
                .httpClient(HttpClientConfig.httpClientConfig()
                        .setParam("http.socket.timeout", 50000)
                        .setParam("http.connection.timeout", 50000));

        dbHelper.prop = dbHelper.loadDataFromConfigFile();
        pan = dbHelper.prop.getProperty("tds.pan");
        TDSBaseUrl = dbHelper.prop.getProperty("tds.base.url");
        baseURL = HelperBase.prop.getProperty("base.url");
        telenorSite = "TELENOR";
        //dipocket3_intranet = "https://dipocket3.intranet:8900";
        //telenorLoginPhone = dbHelper.prop.getProperty("mobile.registration.phoneNumber");
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
        BOURL = HelperBase.prop.getProperty("bo.base.url");
        BOTestURL = HelperBase.prop.getProperty("bo.test.base.url");
        baseTestURL = HelperBase.prop.getProperty("test.base.url");
        sandboxLogin = HelperBase.prop.getProperty("test.sandbox.login");
        sandboxPass = HelperBase.prop.getProperty("test.sandbox.pass");
        boUserLogin_test = HelperBase.prop.getProperty("test.bo.userlogin");
        boUserPass_test = HelperBase.prop.getProperty("test.bo.userpass");
        cboUserLogin_test = HelperBase.prop.getProperty("test.cbo.userlogin");
        cboUserPass_test = HelperBase.prop.getProperty("test.cbo.userpass");

        tds_phone = HelperBase.prop.getProperty("tds.phone");
        tds_pass = HelperBase.prop.getProperty("tds.pass");
        CBOuserLogin = HelperBase.prop.getProperty("dev.cbo.userLogin2");
        CBOuserPass = HelperBase.prop.getProperty("dev.cbo.userPass2");
        CBOusername = HelperBase.prop.getProperty("dev.cbo.username2");
        CBOuserLogin2 = HelperBase.prop.getProperty("cbo.user.login");
        CBOuserPass2 = HelperBase.prop.getProperty("cbo.user.pass");
        CBOusername2 = HelperBase.prop.getProperty("cbo.username");
        CBOuserLogin3 = HelperBase.prop.getProperty("cbo.userLogin3");
        CBOuserPass3 = HelperBase.prop.getProperty("cbo.userPass3");
        BOuserLogin2 = HelperBase.prop.getProperty("bo.userLogin2");
        BOuserPass2 = HelperBase.prop.getProperty("bo.userPass2");
        BOuserLogin = HelperBase.prop.getProperty("bo.user.login");
        BOuserPass = HelperBase.prop.getProperty("bo.user.pass");
        BOusername = HelperBase.prop.getProperty("bo.username");
        //mobileRegPhone = HelperBase.prop.getProperty("mobile.registration.phoneNumber");
        mobileRegPass = HelperBase.prop.getProperty("mobile.registration.pass");
        homePageLoginPhone = HelperBase.prop.getProperty("mobile.login.homePage.loginPhone");
        homePagePass = HelperBase.prop.getProperty("mobile.login.homePage.pass");
        bankIntegrationPaymentsLogin = HelperBase.prop.getProperty("test.bankIntegrationPayments.login");
        bankIntegrationPaymentPass = HelperBase.prop.getProperty("test.bankIntegrationPayment.pass");
        testEverypayPhone = HelperBase.prop.getProperty("test.everypay.phone");
        testEverypayPass = HelperBase.prop.getProperty("test.everypay.pass");
        testPaybanLogin = HelperBase.prop.getProperty("test.payban.login");
        testPaybanPass = HelperBase.prop.getProperty("test.payban.pass");

        requestSpecDipocketRegistration = given()
                .log().uri().log().headers().log().body()
                .baseUri(HelperBase.prop.getProperty("mobile.base.url"))
                .header("site", HelperBase.prop.getProperty("mobile.site"))
                .header("deviceuuid", HelperBase.prop.getProperty("mobile.registration.deviceuuid"));

        requestSpecDiscontuRegistration = given()
                .baseUri(HelperBase.prop.getProperty("mobile.base.url"))
                .header("site", HelperBase.prop.getProperty("mobile.site.discontu"))
                .header("deviceuuid", HelperBase.prop.getProperty("mobile.registration.deviceuuid"));

        requestSpecPlayITRegistration = given()
                .log().uri().log().headers().log().body()
                .baseUri(HelperBase.prop.getProperty("mobile.base.url"))
                .header("site", HelperBase.prop.getProperty("mobile.site.playIt"))
                .header("deviceuuid", HelperBase.prop.getProperty("mobile.registration.deviceuuid"));

        requestSpecUpAndGoRegistration = given()
                .log().uri().log().headers().log().body()
                .baseUri(HelperBase.prop.getProperty("mobile.base.url"))
                .header("site", HelperBase.prop.getProperty("mobile.site.upAndGo"))
                .header("deviceuuid", HelperBase.prop.getProperty("mobile.registration.deviceuuid"));

        requestSpecSnowAttackRegistration = given()
                .baseUri(HelperBase.prop.getProperty("mobile.base.url"))
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
                .log().uri().log().headers().log().body()
                .baseUri(HelperBase.prop.getProperty("mobile.base.url"))
                .basePath("")
                .header("site", HelperBase.prop.getProperty("mobile.site"))
                .header("deviceuuid", HelperBase.prop.getProperty("mobile.login.deviceuuid"));

        requestSpecSnowAttackHomePage = given()
                .log().uri().log().headers().log().body()
                .baseUri(HelperBase.prop.getProperty("mobile.base.url"))
                .header("site", HelperBase.prop.getProperty("mobile.site.snowAttack"));
                //.header("deviceuuid", HelperBase.prop.getProperty("mobile.login.deviceuuid"));

        requestSpecEmailVerification = given()
                .baseUri(baseURL)
                .basePath("")
                .log().uri().log().headers().log().body()
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
                .log().uri().log().headers().log().body()
                .config(configTimeout)
                .baseUri(TDSBaseUrl)
                .basePath("")
                .contentType("application/xml");

        requestSpecPeak = given()
                .log().uri().log().headers().log().body()
                .config(configTimeout)
                .baseUri(baseURL);

        requestSpecTDSJson = given()
                .log().uri().log().headers().log().body()
                .config(configTimeout)
                .baseUri(TDSBaseUrl)
                .basePath("")
                .contentType("application/json");

        requestSpecBO = given()
                .log().uri().log().headers().log().body()
                .config(configTimeout)
                .baseUri(BOURL)
                .basePath("BOServices")
                .header("bo-auth-token", "123456")
                .contentType("application/json");

        requestSpecBOTest = given()
                .log().uri().log().headers().log().body()
                .config(configTimeout)
                .baseUri(BOTestURL)
                .basePath("BOServices")
                .contentType("application/json");

        requestSpecCustomerServicesTest = given()
                .log().uri().log().headers().log().body()
                .config(configTimeout)
                .baseUri(baseTestURL)
                .basePath("/CustomerServices");

        requestSpecASPSPTest = given()
                .log().uri().log().headers().log().body()
                .config(configTimeout)
                .config(sslCertHelper.aspspSslConfig)
                .port(3443)
                .baseUri(testOpenbankingUrl);
    }

    public void init() {
        RestAssured.useRelaxedHTTPSValidation();
    }

    public void closeDriver() {
        driver.quit();
    }

    public String generateRandomString(int amount){
        String randomString =  RandomStringUtils.random(amount, true, true);
        return randomString;
    }

    public String generateRandomNumber(int amount){
        String randomNumber =  RandomStringUtils.random(amount, false, true);
        return randomNumber;
    }

//    public String getTimeStamp(String pattern) {
//        String timeStamp = new SimpleDateFormat(pattern).format(Calendar.getInstance().getTime());
//        return timeStamp;
//    }
//
//    public String getTimeStampWithAddSomeAmountOfDays(String pattern, int amountOfDays) throws ParseException {
//        String curentDate = getTimeStamp(pattern);
//        String dt = curentDate;  // Start date
//        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
//        Calendar c = Calendar.getInstance();
//        c.setTime(sdf.parse(dt));
//        c.add(Calendar.DATE, amountOfDays);  // number of days to add
//        dt = sdf.format(c.getTime());  // dt is now the new date
//        return dt;
//    }
//
//    public String getTimeStampWithAddSomeAmountOfMonth(String pattern, int amountOfMonth) throws ParseException {
//        String curentDate = getTimeStamp(pattern);
//        String dt = curentDate;
//        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
//        Calendar c = Calendar.getInstance();
//        c.setTime(sdf.parse(dt));
//        c.add(Calendar.MONTH, amountOfMonth);
//        dt = sdf.format(c.getTime());
//        return dt;
//    }

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
    public TimeStampHelper getTimeStampHelper() {
        return timeStampHelper;
    }
    public BOHelper getBOHelper() { return boHelper; }
    public SSLCertHelper getSSLCertHelper() {
        return sslCertHelper;
    }
    public BankIntegrationHelper getBankIntegrationHelper() { return bankIntegrationHelper; }
    public JsonHelper getJsonHelper() { return jsonHelper; }
    public BORequests getBoRequestsHelper() { return boRequestsHelper; }
    public ConsentsRequests getConsentsRequestsHelper() { return consentsRequestsHelper; }
    public ClientServicesRequests getClientServicesRequestsHelper() { return clientServicesRequestsHelper; }
    public CustomerServicesRequests getCustomerServicesRequestsHelper() { return customerServicesRequestsHelper; }
    public ClientProfileRequests getClientProfileRequestsHelper() { return clientProfileRequestsHelper; }
    //public ClientServicesRequests getClientServicesRequests() { return clientServicesRequests; }
    public UIBOHelper getUiboHelper() { return uiboHelper; }
    public UIUpAndGoHelper getUiUpAndGoHelper() { return uiUpAndGoHelper; }
    public UITelenorHelper getUiTelenorHelper() { return uiTelenorHelper; }
}