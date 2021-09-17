package tests.emailsVerification.statement;

import appmanager.EmailVerificationHelper;
import appmanager.HelperBase;
import base.TestBase;
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
import static org.hamcrest.CoreMatchers.hasItems;

public class StatementAttachmentsUpAndGoTests extends TestBase {
    String cliSessionId = null;
    //String emailPass = "pasword12!";
    //String email = "testdipocket@gmail.com";
    String pass = "DvAUtN6";
    String phone = "380685448615";
    String deviceuuid = "380685448615-AutoTest-Login";
    String expectedUpAndGoSender = "zestawienia@upcard.pl";


    @Test(priority = 2)
    public void test_dashBoard_customerStatementRequestList() throws SQLException, ClassNotFoundException {
        //app.getDbHelper().updateClientLanguageFromDB(email, "1", app.mobile_site_upAndGo);
        cliSessionId = app.getLogin_registrationHelper().loginUpAndGo(phone, pass, deviceuuid);

        given()
                .baseUri(HelperBase.prop.getProperty("mobile.base.url"))
                .header("site", HelperBase.prop.getProperty("mobile.site.upAndGo"))
                .header("deviceuuid", deviceuuid)
                .auth().preemptive().basic("10_" + phone, pass)
                .header("clisessionid", ""+cliSessionId+"")
                .when()
                .get("/dashBoard/customerStatementRequestList")
                .then().log().all()
                .statusCode(200)
                .body("statementRequestList.month", hasItems("07", "06"),
                        "statementRequestList.year", hasItems("2021"));
    }

    @Test(priority = 3)
    public void test_dashBoard_sendCustomerStatements_UpAndGoRU() throws InterruptedException, MessagingException, IOException, SQLException, ClassNotFoundException {
        app.getDbHelper().updateClientLanguageFromDB(app.emailsVerificationsEmail, "4", app.mobile_site_upAndGo);
        app.getAttachmentHelper().sendCustomerStatements(phone, pass, "" + cliSessionId + "", "07", "2021", app.mobile_site_upAndGo, deviceuuid, "10_");

        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualSender = senderAndSubject.get(0);
        String actualSubject = senderAndSubject.get(1);
        List<String>actualAttachedFileNames = EmailVerificationHelper.getFileNameFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualBody = getEmailBodyText(emailText, 29, 176);
        String actualFooter = getEmailFooterText(emailText, 177);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualAttachedFileNames, Arrays.asList("statement-07.2021.pdf"), "File name is not correct");
        //softAssert.assertEquals(actualSender, expectedUpAndGoSender, "Sender is not correct");
        softAssert.assertEquals(actualSubject, "Выписка по счету "+app.site_upAndGo+"", "Subject is not correct");
        softAssert.assertEquals(actualBody, "Здравствуйте, "+app.emailsVerificationsFirstName+"! К письму прикреплена выписка по счету, которую Вы заказывали. Спасибо за пользование "+app.site_upAndGo+". С уважением, Юридический отдел", "Body is not correct");
        softAssert.assertEquals(actualFooter, ""+app.SITE_REG+" Для вашего спокойствия, "+app.site_upAndGo+" осуществляет деятельность при поддержке DiPocket UAB, который авторизован и контролируется Банком Литвы как эмитент электронных денег (#75) Upės str. 23, 08128 Vilnius, LT", "Footer is not correct");
        softAssert.assertAll();
    }

    @Test(priority = 4)
    public void test_dashBoard_sendCustomerStatements_UpAndGoEN() throws InterruptedException, MessagingException, IOException, SQLException, ClassNotFoundException {
        app.getDbHelper().updateClientLanguageFromDB(app.emailsVerificationsEmail, "1", app.mobile_site_upAndGo);
        app.getAttachmentHelper().sendCustomerStatements(phone, pass, "" + cliSessionId + "", "06", "2021", app.mobile_site_upAndGo, deviceuuid, "10_");

        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualSender = senderAndSubject.get(0);
        String actualSubject = senderAndSubject.get(1);
        List<String>actualAttachedFileNames = EmailVerificationHelper.getFileNameFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualBody = getEmailBodyText(emailText, 29, 173);
        String actualFooter = getEmailFooterText(emailText, 174);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualAttachedFileNames, Arrays.asList("statement-06.2021.pdf"), "File name is not correct");
        //softAssert.assertEquals(actualSender, expectedUpAndGoSender, "Sender is not correct");
        softAssert.assertEquals(actualSubject, "Your "+app.site_upAndGo+" account statement", "Subject is not correct");
        softAssert.assertEquals(actualBody, "Dear "+app.emailsVerificationsFirstName+", As requested, please find attached your up and go account statement(s). Thank you for using "+app.site_upAndGo+". With kind regards, Legal Team", "Body is not correct");
        softAssert.assertEquals(actualFooter, ""+app.SITE_REG+" "+app.site_upAndGo+" is powered by DiPocket UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT", "Footer is not correct");
        softAssert.assertAll();
    }

    @Test(priority = 5)
    public void test_dashBoard_sendCustomerStatements_UpAndGoPL() throws InterruptedException, MessagingException, IOException, SQLException, ClassNotFoundException {
        app.getDbHelper().updateClientLanguageFromDB(app.emailsVerificationsEmail, "3", app.mobile_site_upAndGo);
        app.getAttachmentHelper().sendCustomerStatements(phone, pass, "" + cliSessionId + "", "07", "2021", app.mobile_site_upAndGo, deviceuuid, "10_");

        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualSender = senderAndSubject.get(0);
        String actualSubject = senderAndSubject.get(1);
        List<String>actualAttachedFileNames = EmailVerificationHelper.getFileNameFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualBody = getEmailBodyText(emailText, 0, 155);
        String actualFooter = getEmailFooterText(emailText, 156);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualAttachedFileNames, Arrays.asList("statement-07.2021.pdf"), "File name is not correct");
        //softAssert.assertEquals(actualSender, expectedUpAndGoSender, "Sender is not correct");
        softAssert.assertEquals(actualSubject, "Twój wyciąg z konta "+app.site_upAndGo+"", "Subject is not correct");
        softAssert.assertEquals(actualBody, "Witaj "+app.emailsVerificationsFirstName+", W załączniku znajduje się zamówiony wyciąg z konta up and go. Dziękujemy za korzystanie z serwisu "+app.site_upAndGo+". Z wyrazami szacunku, Dział Prawny", "Body is not correct");
        softAssert.assertEquals(actualFooter, ""+app.SITE_REG+" "+app.site_upAndGo+" dostarcza DiPocket UAB, autoryzowana Instytucja Pieniądza Elektronicznego, podlegająca nadzorowi Banku Litwy (numer licencji 75) | Licencjonowana przez Mastercard do działania na Europejskim Obszarze Gospodarczego Upės g. 23, 08128 Vilnius, LT", "Footer is not correct");
        softAssert.assertAll();
    }

    @Test(priority = 6)
    public void test_dashBoard_sendCustomerStatements_UpAndGoUA() throws InterruptedException, MessagingException, IOException, SQLException, ClassNotFoundException {
        app.getDbHelper().updateClientLanguageFromDB(app.emailsVerificationsEmail, "2", app.mobile_site_upAndGo);
        app.getAttachmentHelper().sendCustomerStatements(phone, pass, "" + cliSessionId + "", "07", "2021", app.mobile_site_upAndGo, deviceuuid, "10_");

        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualSender = senderAndSubject.get(0);
        String actualSubject = senderAndSubject.get(1);
        List<String>actualAttachedFileNames = EmailVerificationHelper.getFileNameFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualBody = getEmailBodyText(emailText, 29, 194);
        String actualFooter = getEmailFooterText(emailText, 195);

        SoftAssert softAssert = new SoftAssert();
        //softAssert.assertEquals(actualSender, expectedUpAndGoSender, "Sender is not correct");
        softAssert.assertEquals(actualSubject, "Виписка по рахунку "+app.site_upAndGo+"", "Subject is not correct");
        softAssert.assertEquals(actualBody,"Вітаємо, "+app.emailsVerificationsFirstName+"! В додатку знаходиться замовлена Вами банківська виписка по рахунку "+app.site_upAndGo+". Дякуємо за користування додатком "+app.site_upAndGo+". З повагою, Юридичний відділ", "Body is not correct");
        softAssert.assertEquals(actualFooter,""+app.SITE_REG+" Для Вашого спокою, "+app.site_upAndGo+" працює при підтримці DiPocket UAB, що авторизований та контролюється Банком Литви, як емітент електронних грошей (#75) Upės str. 23, 08128 Vilnius, LT", "Footer is not correct");
        softAssert.assertAll();
    }
}