package tests.emailsVerification.statement;

import appmanager.EmailVerificationHelper;
import appmanager.HelperBase;
import base.TestBase;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import javax.mail.MessagingException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import static appmanager.EmailIMAPHelper.getEmailBodyText;
import static appmanager.EmailIMAPHelper.getEmailFooterText;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.testng.Assert.assertEquals;

public class StatementAttachmentsPlayITTests extends TestBase {
    String cliSessionId = null;
    //String email = "testdipocket2@gmail.com";
    //String emailPass = "pasword12!";
    //String pass = "pasword1";
    //String deviceuuid = "380633192217-AutoTest-Login";
    //String phone = "380633192217";
    String expectedPlayITSender = "PlayIT Card <playitcard@dipocket.org>";

    String pass = "526986";
    String phone = "380685448615";
    String deviceuuid = "380685448615-AutoTest-Login";


    @Test(priority = 1)
    public void test_ClientServices_v1_homePage_AutintificateMobileApp() throws SQLException, ClassNotFoundException {
        app.getDbHelper().deleteClientDeviceFromDB(deviceuuid);
        given().log().all()
                .auth().preemptive().basic("9_" + phone, pass)
                .header("deviceuuid", deviceuuid)
                .header("site", app.mobile_site_playIt)
                .contentType("application/json; charset=UTF-8")
                .body("{\n" +
                        "  \"devToken\" : \"eGy9q-lDQBGKz-bgdz1U6q:APA91bF8bT00_Cj-KVTiTSLlB-LBL8itr4LKxJVSxKJGZs3eyvHMbLZ4mZWYyo_r290PQFuKhx7mQOgAFeisGhBByoHXzQ0ANETYA-nTnDGM29zXKxcaIh47qJ7dyFQymXolPLYtmeM8\",\n" +
                        "  \"devType\" : \"android\",\n" +
                        "  \"deviceUUID\" : \""+ deviceuuid+"\",\n" +
                        "  \"appVersion\" : \"1.4.9\"\n" +
                        "}")
                .when()
                .post( HelperBase.prop.getProperty("mobile.base.url")+"homePage/authenticateMobileApp")
                .then().log().all()
                .statusCode(400)
                //.body("errDesc", equalTo("Введите код (#1) из SMS, что б подтвердить вход на этом устройстве"))
                .body("errCode", equalTo("DIP-00591"));

        String loginSMSCode = app.getDbHelper().getLoginSMSFromDB(phone, deviceuuid, "PLAYIT");
        Response res =  given().log().all()
                .auth().preemptive().basic("9_" + phone, pass)
                .header("deviceuuid", deviceuuid)
                .header("site", app.mobile_site_playIt)
                .contentType("application/json; charset=UTF-8")
                .body("{\n" +
                        "  \"devToken\" : \"eGy9q-lDQBGKz-bgdz1U6q:APA91bF8bT00_Cj-KVTiTSLlB-LBL8itr4LKxJVSxKJGZs3eyvHMbLZ4mZWYyo_r290PQFuKhx7mQOgAFeisGhBByoHXzQ0ANETYA-nTnDGM29zXKxcaIh47qJ7dyFQymXolPLYtmeM8\",\n" +
                        "  \"devType\" : \"android\",\n" +
                        "  \"deviceUUID\" : \""+ deviceuuid+"\",\n" +
                        "  \"appVersion\" : \"1.4.9\",\n" +
                        "  \"otp\" : \""+loginSMSCode+"\"\n" +
                        "}")
                .when()
                .post( HelperBase.prop.getProperty("mobile.base.url")+"homePage/authenticateMobileApp");
        cliSessionId = res.getHeader("cliSessionId");
        System.out.println(res.getHeaders());
        System.out.println("cliSessionId " + cliSessionId);
        int StatusCode = res.getStatusCode();
        assertEquals(StatusCode, 200);
    }

    @Test(priority = 2)
    public void test_dashBoard_customerStatementRequestList() throws SQLException, ClassNotFoundException {
        //app.getDbHelper().deleteClientDeviceFromDB("380980316499-AutoTest-Login");
        //app.getDbHelper().updateClientLanguageFromDB(email, "1", app.mobile_site_upAndGo);


        given()
                .baseUri(HelperBase.prop.getProperty("mobile.base.url"))
                .header("site", HelperBase.prop.getProperty("mobile.site.playIt"))
                .header("deviceuuid", deviceuuid)
                .auth().preemptive().basic("9_" + phone, pass)
                .header("clisessionid", ""+cliSessionId+"")
                .when()
                .get("/dashBoard/customerStatementRequestList")
                .then().log().all()
                .statusCode(200)
                .body("statementRequestList.month", hasItems("07", "06"),
                        "statementRequestList.year", hasItems("2021"));
    }

    public void sendCustomerStatements(String phone, String pass, String cliSessionId) {
        given().log().uri().log().headers().log().body()
                .baseUri(HelperBase.prop.getProperty("mobile.base.url"))
                .header("site", HelperBase.prop.getProperty("mobile.site.playIt"))
                .header("deviceuuid", deviceuuid)
                .auth().preemptive().basic("9_" + phone, pass)
                .header("clisessionid", cliSessionId)
                .contentType("application/json")
                .body("{\n" +
                        "  \"reportTypeId\": 0,\n" +
                        "  \"statementRequestList\": [\n" +
                        "    {\n" +
                        "      \"month\": \"07\",\n" +
                        "      \"year\": \"2021\"\n" +
                        "    }\n" +
                        "  ]\n" +
                        "}")
                .when()
                .put("/dashBoard/sendCustomerStatements")
                .then().log().all()
                .statusCode(200);
    }

    @Test(priority = 3, enabled = false) // problem, letter without attachment
    public void test_dashBoard_sendCustomerStatements_PlayITEN() throws InterruptedException, MessagingException, IOException, SQLException, ClassNotFoundException {
        app.getDbHelper().updateClientLanguageFromDB(app.emailsVerificationsEmail, "1", app.mobile_site_playIt);
        sendCustomerStatements(phone, pass, "" + cliSessionId + "");

        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualSender = senderAndSubject.get(0);
        String actualSubject = senderAndSubject.get(1);
        List<String>actualAttachedFileNames = EmailVerificationHelper.getFileNameFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualBody = getEmailBodyText(emailText, 26, 163);
        String actualFooter = getEmailFooterText(emailText, 164);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualAttachedFileNames, Arrays.asList( "Card Terms and Conditions.pdf"), "File name is not correct");
        softAssert.assertEquals(actualSender, expectedPlayITSender, "Sender is not correct");
        softAssert.assertEquals(actualSubject, "Your "+app.site_PlayIT+" Legal Documents", "Subject is not correct");
        softAssert.assertEquals(actualBody, "Dear "+app.emailsVerificationsFirstName+", As requested, please find attached selected "+app.site_PlayIT+" legal documents. Thank you for using "+app.site_PlayIT+". With kind regards, Legal Team", "Body is not correct");
        softAssert.assertEquals(actualFooter, ""+app.SITE_REG+" "+app.site_PlayIT+" is powered by DiPocket UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT", "Footer is not correct");
        softAssert.assertAll();
    }

    @Test(priority = 4, enabled = false)
    public void test_dashBoard_sendCustomerStatements_PlayITHU() throws InterruptedException, MessagingException, IOException, SQLException, ClassNotFoundException {
        app.getDbHelper().updateClientLanguageFromDB(app.emailsVerificationsEmail, "5", app.mobile_site_playIt);
        sendCustomerStatements(phone, pass, "" + cliSessionId + "");

        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualSender = senderAndSubject.get(0);
        String actualSubject = senderAndSubject.get(1);
        List<String>actualAttachedFileNames = EmailVerificationHelper.getFileNameFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualBody = getEmailBodyText(emailText, 26, 171);
        String actualFooter = getEmailFooterText(emailText, 172);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualAttachedFileNames, Arrays.asList( "Kártyaszerződési feltételek.pdf"), "File name is not correct");
        softAssert.assertEquals(actualSender, expectedPlayITSender, "Sender is not correct");
        softAssert.assertEquals(actualSubject, "Az Ön "+app.site_PlayIT+" jogi dokumentumai", "Subject is not correct");
        softAssert.assertEquals(actualBody, "Kedves "+app.emailsVerificationsFirstName+", Kívánsága szerint, csatolva találja a jogi dokumentumokat. Köszönjük, hogy a PlayIT alkalmazást használja. Üdvözlettel, Jogi csapat", "Body is not correct");
        softAssert.assertEquals(actualFooter, ""+app.SITE_REG+" Megnyugtatásul tájékoztatjuk, hogy a "+app.site_PlayIT+" Kártya számládat a DiPocket UAB kezeli, mely vállalatot a Litván Nemzeti Bank elektronikus pénzintézetenként (# 75) engedélyezett és felügyel Upės str. 23, 08128 Vilnius, LT", "Footer is not correct");
        softAssert.assertAll();
    }
}