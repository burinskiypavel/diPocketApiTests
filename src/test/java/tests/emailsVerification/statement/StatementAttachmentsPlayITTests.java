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

public class StatementAttachmentsPlayITTests extends TestBase {
    String cliSessionId = null;
    String expectedPlayITSender = "PlayIT Card <statements@dipocket.org>";
    String email = "testdipocket2@gmail.com";
    String emailPass = "pasword12!";
    String appPass = "mjledaazrygvvoqj";
    String pass = "pasword1";
    String deviceuuid = "380633192217-AutoTest-Login";
    String phone = "380633192217";

    @Test(priority = 1)
    public void test_dashBoard_customerStatementRequestList() throws SQLException, ClassNotFoundException {
        cliSessionId = app.getLogin_registrationHelper().loginPlayIT(phone, pass, deviceuuid);

        given()
                .baseUri(HelperBase.prop.getProperty("mobile.base.url"))
                .header("site", Site.PLAYIT.toString())
                .header("deviceuuid", deviceuuid)
                .auth().preemptive().basic("9_" + phone, pass)
                .header("clisessionid", ""+cliSessionId+"")
                .when()
                .get("/dashBoard/customerStatementRequestList")
                .then().log().all()
                .statusCode(200)
                .body("statementRequestList.month", hasItems("08"),
                        "statementRequestList.year", hasItems("2021"));
    }

    @Test(priority = 2)
    public void test_dashBoard_sendCustomerStatements_PlayITEN() throws InterruptedException, MessagingException, IOException, SQLException, ClassNotFoundException {
        app.getDbHelper().updateClientLanguageFromDB(email, String.valueOf(Language.EN.getOurId()), Site.PLAYIT.toString());
        app.getAttachmentHelper().sendCustomerStatements(phone, pass, "" + cliSessionId + "", "08", "2021", Site.PLAYIT.toString(), deviceuuid, "9_");

        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(email, emailPass, appPass);
        String actualSender = senderAndSubject.get(0);
        String actualSubject = senderAndSubject.get(1);
        List<String>actualAttachedFileNames = EmailVerificationHelper.getFileNameFromEmail("pop.gmail.com", email, emailPass, appPass);
        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", email, emailPass, appPass);
        String actualBody = getEmailBodyText(emailText, 26, 164);
        String actualFooter = getEmailFooterText(emailText, 165);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualAttachedFileNames, Arrays.asList("statement-08.2021.pdf"), "File name is not correct");
        softAssert.assertEquals(actualSender, expectedPlayITSender, "Sender is not correct");
        softAssert.assertEquals(actualSubject, "Your "+app.site_PlayIT+" account statement", "Subject is not correct");
        softAssert.assertEquals(actualBody, "Dear "+app.emailsVerificationsFirstName+", As requested, please find attached your "+app.site_PlayIT+" account statement(s). Thank you for using "+app.site_PlayIT+". With kind regards, Legal Team", "Body is not correct");
        softAssert.assertEquals(actualFooter, ""+app.SITE_REG+" "+app.site_PlayIT+" is powered by DiPocket UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT", "Footer is not correct");
        softAssert.assertAll();
    }

    @Test(priority = 3)
    public void test_dashBoard_sendCustomerStatements_PlayITHU() throws InterruptedException, MessagingException, IOException, SQLException, ClassNotFoundException {
        app.getDbHelper().updateClientLanguageFromDB(email, String.valueOf(Language.HU.getOurId()), Site.PLAYIT.toString());
        app.getAttachmentHelper().sendCustomerStatements(phone, pass, "" + cliSessionId + "", "08", "2021", Site.PLAYIT.toString(), deviceuuid, "9_");

        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(email, emailPass, appPass);
        String actualSender = senderAndSubject.get(0);
        String actualSubject = senderAndSubject.get(1);
        List<String>actualAttachedFileNames = EmailVerificationHelper.getFileNameFromEmail("pop.gmail.com", email, emailPass, appPass);
        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", email, emailPass, appPass);
        String actualBody = getEmailBodyText(emailText, 26, 186);
        String actualFooter = getEmailFooterText(emailText, 187);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualAttachedFileNames, Arrays.asList("statement-08.2021.pdf"), "File name is not correct");
        softAssert.assertEquals(actualSender, expectedPlayITSender, "Sender is not correct");
        softAssert.assertEquals(actualSubject, "AZ Ön "+app.site_PlayIT+" számlakivonata", "Subject is not correct");
        softAssert.assertEquals(actualBody, "Kedves "+app.emailsVerificationsFirstName+", Kívánsága szerint, csatolva találja a számlakivonatát (számlakivonatait). Köszönjük, hogy a PlayIT alkalmazást használja. Üdvözlettel, Jogi csapat", "Body is not correct");
        softAssert.assertEquals(actualFooter, ""+app.SITE_REG+" Megnyugtatásul tájékoztatjuk, hogy a PlayIT Kártya számládat a DiPocket UAB kezeli, mely vállalatot a Litván Nemzeti Bank elektronikus pénzintézetenként (# 75) engedélyezett és felügyel Upės str. 23, 08128 Vilnius, LT", "Footer is not correct");
        softAssert.assertAll();
    }
}