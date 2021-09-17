package tests.emailsVerification.legalEmail;

import appmanager.EmailVerificationHelper;
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

public class LegalAttachmentsDipocketTests extends TestBase {
    String cliSessionId = null;
    String email = "testdipocket2@gmail.com";
    String emailPass = "pasword12!";
    String phone =  "380633192217";
    String pass = "pasword1";
    String deviceUUID = "380633192217-AutoTest-Login";

    @Test(priority = 1)
    public void test_clientProfile_getLegalDocumentList() throws SQLException, ClassNotFoundException {
        app.getDbHelper().updateClientLanguageFromDB(email, "4", app.mobile_site);
        cliSessionId = app.getLogin_registrationHelper().loginDipocket(phone, pass, deviceUUID);

        given()
                .spec(app.requestSpecDipocketHomePage)
                .auth().preemptive().basic(phone, pass)
                .header("clisessionid", ""+cliSessionId+"")
                .when()
                .get("clientProfile/getLegalDocumentList")
                .then().log().all()
                .statusCode(200)
                .body("documentList.type", hasItems("Tariff Table", "Limits Table", "General Terms and Conditions", "Supervised Accounts T&Cs", "Privacy Policy", "Complaints Policy", "E-wallet terms of usage", "DiPocket Card Transaction Dispute Declaration"),
                        "documentList.nameForClient", hasItems("Тарифы", "Лимиты", "Общие условия", "Условия использования счетов под опекой", "Политика конфиденциальности", "Политика жалоб", "Условия пользования электронным кошельком", "Бланк для споров по операциям с карточками DiPocket"),
                        "documentList.selected", hasItems(false, false, false, false, false, false, false, false));
    }

    @Test(priority = 2)
    public void test_clientProfile_sendLegalInfo2_DipocketRU() throws InterruptedException, MessagingException, IOException, SQLException, ClassNotFoundException {
        app.getDbHelper().updateClientLanguageFromDB(email, "4", app.mobile_site);
        app.getAttachmentHelper().sendLegalInfo2(phone, pass, "" + cliSessionId + "", "Тарифы", email, "Tariff Table");

        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(email, emailPass);
        String actualSender = senderAndSubject.get(0);
        String actualSubject = senderAndSubject.get(1);
        List<String>actualAttachedFileNames = EmailVerificationHelper.getFileNameFromEmail("pop.gmail.com", email, emailPass);
        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", email, emailPass);
        String actualBody = getEmailBodyText(emailText, 28, 181);
        String actualFooter = getEmailFooterText(emailText, 182);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualAttachedFileNames, Arrays.asList( "Тарифы.pdf"), "File name is not correct");
        softAssert.assertEquals(actualSender, "legal.team@dipocket.org", "Sender is not correct");
        softAssert.assertEquals(actualSubject, "Документы "+app.site+"", "Subject is not correct");
        softAssert.assertEquals(actualBody,"Здравствуйте, "+app.emailsVerificationsFirstName+"! В приложении находятся юридические документы, которые Вы заказывали. Спасибо за пользование "+app.site+". С уважением, Юридический отдел", "Body is not correct");
        softAssert.assertEquals(actualFooter, ""+app.SITE_REG+" Для вашего спокойствия, "+app.site+" UAB авторизован и контролируется Банком Литвы как эмитент электронных денег (#75) Upės str. 23, 08128 Vilnius, LT", "Footer is not correct");
        softAssert.assertAll();
    }

    @Test(priority = 3)
    public void test_clientProfile_sendLegalInfo2_DipocketEN() throws InterruptedException, MessagingException, IOException, SQLException, ClassNotFoundException {
        app.getDbHelper().updateClientLanguageFromDB(email, "1", app.mobile_site);
        app.getAttachmentHelper().sendLegalInfo2("380633192217", "pasword1", "" + cliSessionId + "", "Tariff Table", email, "Tariff Table");

        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(email, emailPass);
        String actualSender = senderAndSubject.get(0);
        String actualSubject = senderAndSubject.get(1);
        List<String>actualAttachedFileNames = EmailVerificationHelper.getFileNameFromEmail("pop.gmail.com", email, emailPass);
        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", email, emailPass);
        String actualBody = getEmailBodyText(emailText, 28, 169);
        String actualFooter = getEmailFooterText(emailText, 170);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualAttachedFileNames, Arrays.asList( "Tariff Table.pdf"), "File name is not correct");
        softAssert.assertEquals(actualSender, "legal.team@dipocket.org", "Sender is not correct");
        softAssert.assertEquals(actualSubject, "Your "+app.site+" Legal Documents", "Subject is not correct");
        softAssert.assertEquals(actualBody, "Dear "+app.emailsVerificationsFirstName+", As requested, please find attached selected "+app.site+" legal documents. Thank you for using "+app.site+". With kind regards, Legal Team", "Body is not correct");
        softAssert.assertEquals(actualFooter, ""+app.SITE_REG+" "+app.site+" UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT", "Footer is not correct");
        softAssert.assertAll();
    }

    @Test(priority = 4)
    public void test_clientProfile_sendLegalInfo2_DipocketPL() throws InterruptedException, MessagingException, IOException, SQLException, ClassNotFoundException {
        app.getDbHelper().updateClientLanguageFromDB(email, "3", app.mobile_site);
        app.getAttachmentHelper().sendLegalInfo2("380633192217", "pasword1", "" + cliSessionId + "", "Tabela Opłat", email, "Tariff Table");

        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(email, emailPass);
        String actualSender = senderAndSubject.get(0);
        String actualSubject = senderAndSubject.get(1);
        List<String>actualAttachedFileNames = EmailVerificationHelper.getFileNameFromEmail("pop.gmail.com", email, emailPass);
        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", email, emailPass);
        String actualBody = getEmailBodyText(emailText, 0, 146);
        String actualFooter = getEmailFooterText(emailText, 147);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualAttachedFileNames, Arrays.asList( "Tabela Opłat.pdf"), "File name is not correct");
        softAssert.assertEquals(actualSender, "legal.team@dipocket.org", "Sender is not correct");
        softAssert.assertEquals(actualSubject, "Twoje dokumenty prawne "+app.site+"", "Subject is not correct");
        softAssert.assertEquals(actualBody, "Witaj "+app.emailsVerificationsFirstName+", W załączniku znajdują się zamówione dokumenty prawne. Dziękujemy za korzystanie z serwisu "+app.site+". Z wyrazami szacunku, Dział Prawny", "Body is not correct");
        softAssert.assertEquals(actualFooter, ""+app.SITE_REG+" "+app.site+" UAB, autoryzowana Instytucja Pieniądza Elektronicznego, podlegająca nadzorowi Banku Litwy (numer licencji 75) | Licencjonowana przez Mastercard do działania na Europejskim Obszarze Gospodarczego Upės g. 23, 08128 Vilnius, LT", "Footer is not correct");
        softAssert.assertAll();
    }

    @Test(priority = 5)
    public void test_clientProfile_sendLegalInfo2_DipocketUA() throws InterruptedException, MessagingException, IOException, SQLException, ClassNotFoundException {
        app.getDbHelper().updateClientLanguageFromDB(email, "2", app.mobile_site);
        app.getAttachmentHelper().sendLegalInfo2("380633192217", "pasword1", "" + cliSessionId + "", "Тарифи", "email", "Tariff Table");

        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(email, emailPass);
        String actualSender = senderAndSubject.get(0);
        String actualSubject = senderAndSubject.get(1);
        List<String>actualAttachedFileNames = EmailVerificationHelper.getFileNameFromEmail("pop.gmail.com", email, emailPass);
        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", email, emailPass);
        String actualBody = getEmailBodyText(emailText, 28, 172);
        String actualFooter = getEmailFooterText(emailText, 173);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualAttachedFileNames, Arrays.asList( "Тарифи.pdf"), "File name is not correct");
        softAssert.assertEquals(actualSender, "legal.team@dipocket.org", "Sender is not correct");
        softAssert.assertEquals(actualSubject, "Ваші юридичні документи "+app.site+"", "Subject is not correct");
        softAssert.assertEquals(actualBody, "Вітаємо, "+app.emailsVerificationsFirstName+"! В додатку знаходяться юридичні документи, що Ви запитали. Дякуємо за користування додатком "+app.site+". З повагою, Юридичний відділ", "Body is not correct");
        softAssert.assertEquals(actualFooter, ""+app.SITE_REG+" Для Вашого спокою, "+app.site+" UAB авторизований та контролюється Банком Литви, як емітент електронних грошей (#75) Upės str. 23, 08128 Vilnius, LT", "Footer is not correct");
        softAssert.assertAll();
    }
}