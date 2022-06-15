package tests.emailsVerification.statement;

import appmanager.EmailVerificationHelper;
import appmanager.HelperBase;
import appmanager.Language;
import base.TestBase;
import com.cs.dipocketback.base.data.Site;
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

public class StatementAttachmentsDipocketTests extends TestBase {
    String cliSessionId = null;
    String email = "testdipocket3@gmail.com";
    String emailPass = "pasword12!";
    String appPass = "whotpsgrehudbtqv";
    String phone = "380980316499";
    String pass = "reset246740";
    String expectedSender = "statements@dipocket.org";

    @Test(priority = 1)
    public void test_dashBoard_customerStatementRequestList() throws SQLException, ClassNotFoundException {
        app.getDbHelper().updateClientLanguageFromDB(email, String.valueOf(Language.EN.getOurId()), Site.DIPOCKET.toString());
        //app.getDbHelper().updateEmailForTelenorFromDB("burinskiypavel@gmail.com", Site.DIPOCKET.toString(), "testdipocket3@gmail.com", "380980316499");
        cliSessionId = app.getLogin_registrationHelper().loginDipocket(phone, pass, "380980316499-AutoTest-Login");

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

    @Test(priority = 2)
    public void test_dashBoard_sendCustomerStatements_DipocketEN() throws InterruptedException, MessagingException, IOException, SQLException, ClassNotFoundException {
        app.getDbHelper().updateClientLanguageFromDB(email, String.valueOf(Language.EN.getOurId()), Site.DIPOCKET.toString());
        app.getAttachmentHelper().sendCustomerStatements(phone, pass, "" + cliSessionId + "", "06", "2021", Site.DIPOCKET.toString(), HelperBase.prop.getProperty("mobile.login.deviceuuid"), "");

        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(email, emailPass, appPass);
        String actualSender = senderAndSubject.get(0);
        String actualSubject = senderAndSubject.get(1);
        List<String>actualAttachedFileNames = EmailVerificationHelper.getFileNameFromEmail("pop.gmail.com", email, emailPass, appPass);
        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", email, emailPass, appPass);
        String actualBody = getEmailBodyText(emailText, 28, 170);
        String actualFooter = getEmailFooterText(emailText, 171);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualAttachedFileNames, Arrays.asList("statement-06.2021.pdf"), "File name is not correct");
        softAssert.assertEquals(actualSender, expectedSender, "Sender is not correct");
        softAssert.assertEquals(actualSubject, "Your "+app.site+" account statement", "Subject is not correct");
        softAssert.assertEquals(actualBody, "Dear "+app.emailsVerificationsFirstName+", As requested, please find attached your "+app.site+" account statement(s). Thank you for using "+app.site+". With kind regards, Legal Team", "Body is not correct");
        softAssert.assertEquals(actualFooter, ""+app.SITE_REG+" "+app.site+" UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT", "Footer is not correct");
        softAssert.assertAll();
    }

    @Test(priority = 3)
    public void test_dashBoard_sendCustomerStatements_DipocketUA() throws InterruptedException, MessagingException, IOException, SQLException, ClassNotFoundException {
        app.getDbHelper().updateClientLanguageFromDB(email, String.valueOf(Language.UK.getOurId()), Site.DIPOCKET.toString());
        app.getAttachmentHelper().sendCustomerStatements(phone, pass, "" + cliSessionId + "", "04", "2021", Site.DIPOCKET.toString(), HelperBase.prop.getProperty("mobile.login.deviceuuid"), "");

        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(email, emailPass, appPass);
        String actualSender = senderAndSubject.get(0);
        String actualSubject = senderAndSubject.get(1);
        List<String>actualAttachedFileNames = EmailVerificationHelper.getFileNameFromEmail("pop.gmail.com", email, emailPass, appPass);
        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", email, emailPass, appPass);
        String actualBody = getEmailBodyText(emailText, 28, 191);
        String actualFooter = getEmailFooterText(emailText, 192);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualAttachedFileNames, Arrays.asList("statement-04.2021.pdf"), "File name is not correct");
        softAssert.assertEquals(actualSender, expectedSender);
        softAssert.assertEquals(actualSubject, "Виписка по рахунку "+app.site+"");
        softAssert.assertEquals(actualBody, "Вітаємо, "+app.emailsVerificationsFirstName+"! В додатку знаходиться замовлена Вами банківська виписка по рахунку "+app.site+". Дякуємо за користування додатком "+app.site+". З повагою, Юридичний відділ");
        softAssert.assertEquals(actualFooter, ""+app.SITE_REG+" Для Вашого спокою, "+app.site+" UAB авторизований та контролюється Банком Литви, як емітент електронних грошей (#75) Upės str. 23, 08128 Vilnius, LT");
        softAssert.assertAll();
    }

    @Test(priority = 4)
    public void test_dashBoard_sendCustomerStatements_DipocketPL() throws InterruptedException, MessagingException, IOException, SQLException, ClassNotFoundException {
        app.getDbHelper().updateClientLanguageFromDB(email, String.valueOf(Language.PL.getOurId()), Site.DIPOCKET.toString());
        app.getAttachmentHelper().sendCustomerStatements(phone, pass, "" + cliSessionId + "", "05", "2021", Site.DIPOCKET.toString(), HelperBase.prop.getProperty("mobile.login.deviceuuid"), "");

        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(email, emailPass, appPass);
        String actualSender = senderAndSubject.get(0);
        String actualSubject = senderAndSubject.get(1);
        List<String>actualAttachedFileNames = EmailVerificationHelper.getFileNameFromEmail("pop.gmail.com", email, emailPass, appPass);
        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", email, emailPass, appPass);
        String actualBody = getEmailBodyText(emailText, 0, 153);
        String actualFooter = getEmailFooterText(emailText, 154);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualAttachedFileNames, Arrays.asList("statement-05.2021.pdf"), "File name is not correct");
        softAssert.assertEquals(actualSender, expectedSender);
        softAssert.assertEquals(actualSubject, "Twój wyciąg z konta "+app.site+"");
        softAssert.assertEquals(actualBody, "Witaj "+app.emailsVerificationsFirstName+", W załączniku znajduje się zamówiony wyciąg z konta "+app.site+". Dziękujemy za korzystanie z serwisu "+app.site+". Z wyrazami szacunku, Dział Prawny");
        softAssert.assertEquals(actualFooter, ""+app.SITE_REG+" "+app.site+" UAB, autoryzowana Instytucja Pieniądza Elektronicznego, podlegająca nadzorowi Banku Litwy (numer licencji 75) | Licencjonowana przez Mastercard do działania na Europejskim Obszarze Gospodarczego Upės g. 23, 08128 Vilnius, LT");
        softAssert.assertAll();
    }

    @Test(priority = 5)
    public void test_dashBoard_sendCustomerStatements_DipocketRU() throws InterruptedException, MessagingException, IOException, SQLException, ClassNotFoundException {
        app.getDbHelper().updateClientLanguageFromDB(email, String.valueOf(Language.RU.getOurId()), Site.DIPOCKET.toString());
        app.getAttachmentHelper().sendCustomerStatements(phone, pass, "" + cliSessionId + "", "07", "2021", Site.DIPOCKET.toString(), HelperBase.prop.getProperty("mobile.login.deviceuuid"), "");

        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(email, emailPass, appPass);
        String actualSender = senderAndSubject.get(0);
        String actualSubject = senderAndSubject.get(1);
        List<String>actualAttachedFileNames = EmailVerificationHelper.getFileNameFromEmail("pop.gmail.com", email, emailPass, appPass);
        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", email, emailPass, appPass);
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
}