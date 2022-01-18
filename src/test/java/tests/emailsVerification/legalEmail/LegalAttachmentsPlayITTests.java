package tests.emailsVerification.legalEmail;

import appmanager.EmailVerificationHelper;
import appmanager.HelperBase;
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

public class LegalAttachmentsPlayITTests extends TestBase {
    String cliSessionId = null;
    String email = "testdipocket2@gmail.com";
    String emailPass = "pasword12!";
    String pass = "pasword1";
    String deviceuuid = "380633192217-AutoTest-Login";
    String phone = "380633192217";
    String expectedPlayITSender = "PlayIT Card <playitcard@dipocket.org>";

    @Test(priority = 1)
    public void test_clientProfile_getLegalDocumentListEN() throws SQLException, ClassNotFoundException {
        app.getDbHelper().updateClientLanguageFromDB(email, "1", Site.PLAYIT.toString());
        cliSessionId = app.getLogin_registrationHelper().loginPlayIT(phone,pass, deviceuuid);

        given()
                .baseUri(HelperBase.prop.getProperty("mobile.base.url"))
                .header("site", Site.PLAYIT.toString())
                .header("deviceuuid", deviceuuid)
                .auth().preemptive().basic("9_" + phone, pass)
                .header("clisessionid", ""+cliSessionId+"")
                .when()
                .get("clientProfile/getLegalDocumentList")
                .then().log().all()
                .statusCode(200)
                .body("documentList.type", hasItems("Card Terms and Conditions", "General Terms and Conditions", "Supervised Accounts T&Cs",  "Privacy Policy", "Complaints Policy", "E-wallet terms of usage", "DiPocket Card Transaction Dispute Declaration"),
                        "documentList.nameForClient", hasItems("Card Terms and Conditions", "General Terms and Conditions", "Supervised Accounts T&Cs", "Privacy Policy", "Complaints Policy", "E-wallet terms of usage", "DiPocket Card Transaction Dispute Declaration"),
                        "documentList.selected", hasItems(false, false, false, false, false, false, false));
    }

    @Test(priority = 2)
    public void test_clientProfile_sendLegalInfo2_PlayITEN() throws InterruptedException, MessagingException, IOException, SQLException, ClassNotFoundException {
        app.getDbHelper().updateClientLanguageFromDB(email, "1", Site.PLAYIT.toString());
        app.getAttachmentHelper().sendLegalInfo2(phone, pass, "" + cliSessionId + "", "Card Terms and Conditions", email, "Card Terms and Conditions", Site.PLAYIT.toString(), "9_");

        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(email, emailPass);
        String actualSender = senderAndSubject.get(0);
        String actualSubject = senderAndSubject.get(1);
        List<String>actualAttachedFileNames = EmailVerificationHelper.getFileNameFromEmail("pop.gmail.com", email, emailPass);
        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", email, emailPass);
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

    @Test(priority = 3)
    public void test_clientProfile_sendLegalInfo2_PlayITHU() throws InterruptedException, MessagingException, IOException, SQLException, ClassNotFoundException {
        app.getDbHelper().updateClientLanguageFromDB(email, "5", Site.PLAYIT.toString());
        app.getAttachmentHelper().sendLegalInfo2(phone, pass, "" + cliSessionId + "", "Kártyaszerződési feltételek", email, "General Terms and Conditions", Site.PLAYIT.toString(), "9_");

        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(email, emailPass);
        String actualSender = senderAndSubject.get(0);
        String actualSubject = senderAndSubject.get(1);
        List<String>actualAttachedFileNames = EmailVerificationHelper.getFileNameFromEmail("pop.gmail.com", email, emailPass);
        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", email, emailPass);
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