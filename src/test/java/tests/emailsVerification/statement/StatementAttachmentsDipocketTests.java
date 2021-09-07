package tests.emailsVerification.statement;

import appmanager.EmailVerificationHelper;
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

public class StatementAttachmentsDipocketTests extends TestBase {
    String cliSessionId = null;
    String email = "testdipocket3@gmail.com";
    String emailPass = "pasword12!";
    String phone = "380980316499";
    String pass = "reset246740";
    String expectedSender = "statements@dipocket.org";

    @Test(priority = 1)
    public void test_dashBoard_customerStatementRequestList() throws SQLException, ClassNotFoundException {
        app.getDbHelper().deleteClientDeviceFromDB("380980316499-AutoTest-Login");
        app.getDbHelper().updateClientLanguageFromDB(email, "1", app.mobile_site);
        //app.getDbHelper().updateEmailForTelenorFromDB("burinskiypavel@gmail.com", "DIPOCKET", "testdipocket3@gmail.com", "380980316499");

        cliSessionId = login(phone, pass, "380980316499-AutoTest-Login", "DIPOCKET");


        given()
                .spec(app.requestSpecDipocketHomePage)
                .auth().preemptive().basic(phone, pass)
                .header("clisessionid", ""+cliSessionId+"")
                .when()
                .get("/dashBoard/customerStatementRequestList")
                .then().log().all()
                .statusCode(200)
                .body("statementRequestList.month", hasItems("07", "06", "05", "04", "03", "02", "01"),
                        "statementRequestList.year", hasItems("2021", "2020"));
    }

    public void sendCustomerStatements(String phone, String pass, String cliSessionId) {
        given()
                .spec(app.requestSpecDipocketHomePage)
                .auth().preemptive().basic(phone, pass)
                .header("clisessionid", cliSessionId)
                .contentType("application/json")
                .body("{\n" +
                        "  \"reportTypeId\": 1,\n" +
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

    @Test(priority = 2)
    public void test_dashBoard_sendCustomerStatements_DipocketRU() throws InterruptedException, MessagingException, IOException, SQLException, ClassNotFoundException {
        app.getDbHelper().updateClientLanguageFromDB(email, "4", app.mobile_site);
        sendCustomerStatements(phone, pass, "" + cliSessionId + "");

        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(email, emailPass);
        String actualSender = senderAndSubject.get(0);
        String actualSubject = senderAndSubject.get(1);
        List<String>actualAttachedFileNames = EmailVerificationHelper.getFileNameFromEmail("pop.gmail.com", email, emailPass);
        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", email, emailPass);
        String actualBody = getEmailBodyText(emailText, 0, 146);
        String actualFooter = getEmailFooterText(emailText, 147);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualAttachedFileNames, Arrays.asList("statement-07.2021.pdf"), "File name is not correct");
        softAssert.assertEquals(actualSender, "statements@dipocket.org", "Sender is not correct");
        softAssert.assertEquals(actualSubject, "Выписка по счету "+app.site+"", "Subject is not correct");
        softAssert.assertEquals(actualBody,"Здравствуйте, "+app.emailsVerificationsFirstName+"! К письму прикреплена выписка по счету, которую Вы заказывали. Спасибо за пользование "+app.site+". С уважением, Юридический отдел", "Body is not correct");
        softAssert.assertEquals(actualFooter, ""+app.SITE_REG+" Для вашего спокойствия, "+app.site+" UAB авторизован и контролируется Банком Литвы как эмитент электронных денег (#75) Upės str. 23, 08128 Vilnius, LT", "Footer is not correct");
        softAssert.assertAll();
    }

    @Test(priority = 3)
    public void test_dashBoard_sendCustomerStatements_DipocketEN() throws InterruptedException, MessagingException, IOException, SQLException, ClassNotFoundException {
        app.getDbHelper().updateClientLanguageFromDB(email, "1", app.mobile_site);
        sendCustomerStatements(phone, pass, "" + cliSessionId + "");

        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(email, emailPass);
        String actualSender = senderAndSubject.get(0);
        String actualSubject = senderAndSubject.get(1);
        List<String>actualAttachedFileNames = EmailVerificationHelper.getFileNameFromEmail("pop.gmail.com", email, emailPass);
        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", email, emailPass);
        String actualBody = getEmailBodyText(emailText, 28, 170);
        String actualFooter = getEmailFooterText(emailText, 171);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualAttachedFileNames, Arrays.asList("statement-07.2021.pdf"), "File name is not correct");
        softAssert.assertEquals(actualSender, expectedSender, "Sender is not correct");
        softAssert.assertEquals(actualSubject, "Your "+app.site+" account statement", "Subject is not correct");
        softAssert.assertEquals(actualBody, "Dear "+app.emailsVerificationsFirstName+", As requested, please find attached your "+app.site+" account statement(s). Thank you for using "+app.site+". With kind regards, Legal Team", "Body is not correct");
        softAssert.assertEquals(actualFooter, ""+app.SITE_REG+" "+app.site+" UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT", "Footer is not correct");
        softAssert.assertAll();
    }


    @Test(priority = 4)
    public void test_dashBoard_sendCustomerStatements_DipocketPL() throws InterruptedException, MessagingException, IOException, SQLException, ClassNotFoundException {
        app.getDbHelper().updateClientLanguageFromDB(email, "3", app.mobile_site);
        sendCustomerStatements(phone, pass, "" + cliSessionId + "");

        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(email, emailPass);
        String actualSender = senderAndSubject.get(0);
        String actualSubject = senderAndSubject.get(1);
        List<String>actualAttachedFileNames = EmailVerificationHelper.getFileNameFromEmail("pop.gmail.com", email, emailPass);
        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", email, emailPass);
        String actualBody = getEmailBodyText(emailText, 0, 153);
        String actualFooter = getEmailFooterText(emailText, 154);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualAttachedFileNames, Arrays.asList("statement-07.2021.pdf"), "File name is not correct");
        softAssert.assertEquals(actualSender, expectedSender);
        softAssert.assertEquals(actualSubject, "Twój wyciąg z konta "+app.site+"");
        softAssert.assertEquals(actualBody, "Witaj "+app.emailsVerificationsFirstName+", W załączniku znajduje się zamówiony wyciąg z konta "+app.site+". Dziękujemy za korzystanie z serwisu "+app.site+". Z wyrazami szacunku, Dział Prawny");
        softAssert.assertEquals(actualFooter, ""+app.SITE_REG+" "+app.site+" UAB, autoryzowana Instytucja Pieniądza Elektronicznego, podlegająca nadzorowi Banku Litwy (numer licencji 75) | Licencjonowana przez Mastercard do działania na Europejskim Obszarze Gospodarczego Upės g. 23, 08128 Vilnius, LT");
        softAssert.assertAll();
    }

    @Test(priority = 5)
    public void test_dashBoard_sendCustomerStatements_DipocketUA() throws InterruptedException, MessagingException, IOException, SQLException, ClassNotFoundException {
        app.getDbHelper().updateClientLanguageFromDB(email, "2", app.mobile_site);
        sendCustomerStatements(phone, pass, "" + cliSessionId + "");

        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(email, emailPass);
        String actualSender = senderAndSubject.get(0);
        String actualSubject = senderAndSubject.get(1);
        List<String>actualAttachedFileNames = EmailVerificationHelper.getFileNameFromEmail("pop.gmail.com", email, emailPass);
        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", email, emailPass);
        String actualBody = getEmailBodyText(emailText, 28, 191);
        String actualFooter = getEmailFooterText(emailText, 192);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualAttachedFileNames, Arrays.asList("statement-07.2021.pdf"), "File name is not correct");
        softAssert.assertEquals(actualSender, expectedSender);
        softAssert.assertEquals(actualSubject, "Виписка по рахунку "+app.site+"");
        softAssert.assertEquals(actualBody, "Вітаємо, "+app.emailsVerificationsFirstName+"! В додатку знаходиться замовлена Вами банківська виписка по рахунку "+app.site+". Дякуємо за користування додатком "+app.site+". З повагою, Юридичний відділ");
        softAssert.assertEquals(actualFooter, ""+app.SITE_REG+" Для Вашого спокою, "+app.site+" UAB авторизований та контролюється Банком Литви, як емітент електронних грошей (#75) Upės str. 23, 08128 Vilnius, LT");
        softAssert.assertAll();
    }


    public String login(String phone, String pass, final String deviceUUID, String site) throws ClassNotFoundException, SQLException {
        given()
                .spec(app.requestSpecDipocketHomePage)
                .auth().preemptive().basic(phone, pass)
                .contentType("application/json; charset=UTF-8")
                .body("{\n" +
                        "  \"devToken\" : \"eGy9q-lDQBGKz-bgdz1U6q:APA91bF8bT00_Cj-KVTiTSLlB-LBL8itr4LKxJVSxKJGZs3eyvHMbLZ4mZWYyo_r290PQFuKhx7mQOgAFeisGhBByoHXzQ0ANETYA-nTnDGM29zXKxcaIh47qJ7dyFQymXolPLYtmeM8\",\n" +
                        "  \"devType\" : \"android\",\n" +
                        "  \"deviceUUID\" : \"" + deviceUUID + "\",\n" +
                        "  \"appVersion\" : \"2.2.7\"\n" +
                        "}")
                .when()
                .post( "homePage/authenticateMobileApp")
                .then().log().all()
                .statusCode(400)
                //.body("errDesc", equalTo("Введите код (#1) из SMS, что б подтвердить вход на этом устройстве"))
                .body("errCode", equalTo("DIP-00591"));


        String loginSMSCode = app.getDbHelper().getLoginSMSFromDB(phone, deviceUUID, site);

        Response res =  given()
                .spec(app.requestSpecDipocketHomePage)
                .auth().preemptive().basic(phone, pass)
                .contentType("application/json; charset=UTF-8")
                .body("{\n" +
                        "  \"devToken\" : \"eGy9q-lDQBGKz-bgdz1U6q:APA91bF8bT00_Cj-KVTiTSLlB-LBL8itr4LKxJVSxKJGZs3eyvHMbLZ4mZWYyo_r290PQFuKhx7mQOgAFeisGhBByoHXzQ0ANETYA-nTnDGM29zXKxcaIh47qJ7dyFQymXolPLYtmeM8\",\n" +
                        "  \"devType\" : \"android\",\n" +
                        "  \"deviceUUID\" : \""+deviceUUID+"\",\n" +
                        "  \"appVersion\" : \"2.2.7\",\n" +
                        "  \"otp\" : \""+loginSMSCode+"\"\n" +
                        "}")
                .when()
                .post( "homePage/authenticateMobileApp");
        String cliSessionId = res.getHeader("cliSessionId");
        System.out.println(res.getHeaders());
        System.out.println("cliSessionId " + cliSessionId);
        int StatusCode = res.getStatusCode();
        assertEquals(StatusCode, 200);
        return cliSessionId;
    }
}