package tests.emailsVerification.legalEmail;

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

public class LegalAttachmentsUpAndGoTests extends TestBase {
    String cliSessionId = null;
    String email = "testdipocket@gmail.com";
    String pass = "DvAUtN6";
    String phone = "380685448615";
    String deviceuuid = "380685448615-AutoTest-Login";

    @Test(priority = 2)
    public void test_clientProfile_getLegalDocumentList() throws SQLException, ClassNotFoundException {
        app.getDbHelper().updateClientLanguageFromDB(email, "4", app.mobile_site_upAndGo);
        cliSessionId = app.getLogin_registrationHelper().loginUpAndGo(phone, pass ,deviceuuid);

        given()
                .baseUri(HelperBase.prop.getProperty("mobile.base.url"))
                .header("site", app.mobile_site_upAndGo)
                .header("deviceuuid", deviceuuid)
                .auth().preemptive().basic("10_"+ phone, pass)
                .header("clisessionid", ""+cliSessionId+"")
                .when()
                .get("clientProfile/getLegalDocumentList")
                .then().log().all()
                .statusCode(200)
                .body("documentList.type", hasItems("Tariff Table", "Limits Table", "General Terms and Conditions", "Supervised Accounts T&Cs", "Privacy Policy", "Complaints Policy", "E-wallet terms of usage", "DiPocket Card Transaction Dispute Declaration"),
                        "documentList.nameForClient", hasItems("Тарифы", "Лимиты", "Общие условия", "Условия использования счетов под опекой", "Политика конфиденциальности", "Политика жалоб", "Условия пользования электронным кошельком", "Бланк для споров по операциям с карточками DiPocket"),
                        "documentList.selected", hasItems(false, false, false, false, false, false, false, false));
    }

    @Test(priority = 3)
    public void test_clientProfile_sendLegalInfo2_UpAndGoRU() throws InterruptedException, MessagingException, IOException, SQLException, ClassNotFoundException {
        app.getDbHelper().updateClientLanguageFromDB(email, "4", app.mobile_site_upAndGo);
        app.getAttachmentHelper().sendLegalInfo2(phone, pass, "" + cliSessionId + "", "Общие условия", "testdipocket2@gmail.com", "Tariff Table", app.mobile_site_upAndGo, "10_");

        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualSender = senderAndSubject.get(0);
        String actualSubject = senderAndSubject.get(1);
        List<String>actualAttachedFileNames = EmailVerificationHelper.getFileNameFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualBody = getEmailBodyText(emailText, 29, 183);
        String actualFooter = getEmailFooterText(emailText, 184);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualAttachedFileNames, Arrays.asList( "Общие условия.pdf"), "File name is not correct");
        //softAssert.assertEquals(actualSender, "legal.team@dipocket.org", "Sender is not correct");
        softAssert.assertEquals(actualSubject, "Документы "+app.site_upAndGo+"", "Subject is not correct");
        softAssert.assertEquals(actualBody,"Здравствуйте, "+app.emailsVerificationsFirstName+"! В приложении находятся юридические документы, которые Вы заказывали. Спасибо за пользование "+app.site_upAndGo+". С уважением, Юридический отдел", "Body is not correct");
        softAssert.assertEquals(actualFooter, ""+app.SITE_REG+" Для вашего спокойствия, "+app.site_upAndGo+" осуществляет деятельность при поддержке DiPocket UAB, который авторизован и контролируется Банком Литвы как эмитент электронных денег (#75) Upės str. 23, 08128 Vilnius, LT", "Footer is not correct");
        softAssert.assertAll();
    }

    @Test(priority = 4)
    public void test_clientProfile_sendLegalInfo2_UpAndGoEN() throws InterruptedException, MessagingException, IOException, SQLException, ClassNotFoundException {
        app.getDbHelper().updateClientLanguageFromDB(email, "1", app.mobile_site_upAndGo);
        app.getAttachmentHelper().sendLegalInfo2(phone, pass, "" + cliSessionId + "", "Tariff Table", "testdipocket2@gmail.com", "Tariff Table", app.mobile_site_upAndGo, "10_");

        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualSender = senderAndSubject.get(0);
        String actualSubject = senderAndSubject.get(1);
        List<String>actualAttachedFileNames = EmailVerificationHelper.getFileNameFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualBody = getEmailBodyText(emailText, 29, 172);
        String actualFooter = getEmailFooterText(emailText, 173);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualAttachedFileNames, Arrays.asList( "Tariff Table.pdf"), "File name is not correct");
        //softAssert.assertEquals(actualSender, expectedUpAngGoSender, "Sender is not correct");
        softAssert.assertEquals(actualSubject, "Your "+app.site_upAndGo+" Legal Documents", "Subject is not correct");
        softAssert.assertEquals(actualBody, "Dear "+app.emailsVerificationsFirstName+", As requested, please find attached selected "+app.site_upAndGo+" legal documents. Thank you for using "+app.site_upAndGo+". With kind regards, Legal Team", "Body is not correct");
        softAssert.assertEquals(actualFooter, ""+app.SITE_REG+" "+app.site_upAndGo+" is powered by DiPocket UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT", "Footer is not correct");
        softAssert.assertAll();
    }

    @Test(priority = 5)
    public void test_clientProfile_sendLegalInfo2_UpAndGoPL() throws InterruptedException, MessagingException, IOException, SQLException, ClassNotFoundException {
        app.getDbHelper().updateClientLanguageFromDB(email, "3", app.mobile_site_upAndGo);
        app.getAttachmentHelper().sendLegalInfo2(phone, pass, "" + cliSessionId + "", "Tabela Opłat", "testdipocket2@gmail.com", "Tariff Table", app.mobile_site_upAndGo, "10_");

        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualSender = senderAndSubject.get(0);
        String actualSubject = senderAndSubject.get(1);
        List<String>actualAttachedFileNames = EmailVerificationHelper.getFileNameFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualBody = getEmailBodyText(emailText, 0, 147);
        String actualFooter = getEmailFooterText(emailText, 148);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualAttachedFileNames, Arrays.asList( "Tabela Opłat.pdf"), "File name is not correct");
        //softAssert.assertEquals(actualSender, expectedUpAngGoSender, "Sender is not correct");
        softAssert.assertEquals(actualSubject, "Twoje dokumenty prawne "+app.site_upAndGo+"", "Subject is not correct");
        softAssert.assertEquals(actualBody, "Witaj "+app.emailsVerificationsFirstName+", W załączniku znajdują się zamówione dokumenty prawne. Dziękujemy za korzystanie z serwisu "+app.site_upAndGo+". Z wyrazami szacunku, Dział Prawny", "Body is not correct");
        softAssert.assertEquals(actualFooter, ""+app.SITE_REG+" "+app.site_upAndGo+" dostarcza DiPocket UAB, autoryzowana Instytucja Pieniądza Elektronicznego, podlegająca nadzorowi Banku Litwy (numer licencji 75) | Licencjonowana przez Mastercard do działania na Europejskim Obszarze Gospodarczego Upės g. 23, 08128 Vilnius, LT", "Footer is not correct");
        softAssert.assertAll();
    }

    @Test(priority = 6)
    public void test_clientProfile_sendLegalInfo2_UpAndGoUA() throws InterruptedException, MessagingException, IOException, SQLException, ClassNotFoundException {
        app.getDbHelper().updateClientLanguageFromDB(email, "2", app.mobile_site_upAndGo);
        app.getAttachmentHelper().sendLegalInfo2(phone, pass, "" + cliSessionId + "", "Тарифи", "testdipocket2@gmail.com", "Tariff Table", app.mobile_site_upAndGo, "10_");

        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualSender = senderAndSubject.get(0);
        String actualSubject = senderAndSubject.get(1);
        List<String>actualAttachedFileNames = EmailVerificationHelper.getFileNameFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualBody = getEmailBodyText(emailText, 29, 174);
        String actualFooter = getEmailFooterText(emailText, 175);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualAttachedFileNames, Arrays.asList( "Тарифи.pdf"), "File name is not correct");
        //softAssert.assertEquals(actualSender, expectedUpAngGoSender, "Sender is not correct");
        softAssert.assertEquals(actualSubject, "Ваші юридичні документи "+app.site_upAndGo+"", "Subject is not correct");
        softAssert.assertEquals(actualBody, "Вітаємо, "+app.emailsVerificationsFirstName+"! В додатку знаходяться юридичні документи, що Ви запитали. Дякуємо за користування додатком "+app.site_upAndGo+". З повагою, Юридичний відділ", "Body is not correct");
        softAssert.assertEquals(actualFooter, ""+app.SITE_REG+" Для Вашого спокою, "+app.site_upAndGo+" працює при підтримці DiPocket UAB, що авторизований та контролюється Банком Литви, як емітент електронних грошей (#75) Upės str. 23, 08128 Vilnius, LT", "Footer is not correct");
        softAssert.assertAll();
    }
}