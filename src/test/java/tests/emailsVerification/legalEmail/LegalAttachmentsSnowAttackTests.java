package tests.emailsVerification.legalEmail;

import appmanager.EmailVerificationHelper;
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

public class LegalAttachmentsSnowAttackTests extends TestBase {
    String cliSessionId = null;
    String email = "testdipocket0@gmail.com";//testdipocket2@gmail.com"
    String pass = "pasword1";
    String emailPass = "password1<";
    String appPass = "xnzmwhidkvyjeoxb";
    String phone = "380987419131";//380633192217
    String expectedSender = "legal.team@dipocket.org";
    String cookie = null;

    @Test(priority = 1)
    public void test_clientProfile_getLegalDocumentList() throws SQLException, ClassNotFoundException {
        //app.getDbHelper().deleteClientDeviceFromDB("380633192217-AutoTest-Login");
        app.getDbHelper().updateClientLanguageFromDB(email, String.valueOf(Language.EN.getOurId()), Site.SNOW_ATTACK.toString());
        List<String> cockiesCliSessionId = app.getLogin_registrationHelper().loginSnowAttack2(phone, pass);

        cookie = cockiesCliSessionId.get(0);
        cliSessionId = cockiesCliSessionId.get(1);

        given()
                .spec(app.requestSpecSnowAttackHomePage)
                //.auth().preemptive().basic(phone, pass)
                .header("clisessionid", ""+cliSessionId+"")
                .cookie("JSESSIONID", cookie)
                .when()
                .get("clientProfile/getLegalDocumentList")
                .then().log().all()
                .statusCode(200)
                .body("documentList.type", hasItems("General Terms and Conditions", "Card Terms and Conditions"),
                        "documentList.nameForClient", hasItems("General Terms and Conditions", "Card Terms and Conditions"),
                        "documentList.selected", hasItems(false, false));
    }

    public void sendLegalInfo2(String phone, String pass, String cliSessionId, String nameForClient) {
        given()
                .spec(app.requestSpecSnowAttackHomePage)
                //.auth().preemptive().basic(phone, pass)
                .header("clisessionid", cliSessionId)
                .cookie("JSESSIONID", cookie)
                .contentType("application/json")
                .body("{\n" +
                        "  \"documentList\": [\n" +
                        "    {\n" +
                        "      \"nameForClient\": \"" + nameForClient + "\",\n" +
                        "      \"nameForEmail\": \""+email+"\",\n" +
                        "      \"selected\": true,\n" +
                        "      \"type\": \"Card Terms and Conditions\"\n" +
                        "    }\n" +
                        "  ]\n" +
                        "}")
                .when()
                .post("clientProfile/sendLegalInfo2")
                .then().log().all()
                .statusCode(200);
    }

    @Test(priority = 2)
    public void test_clientProfile_sendLegalInfo2_SnowAttackEN() throws InterruptedException, MessagingException, IOException, SQLException, ClassNotFoundException {
        app.getDbHelper().updateClientLanguageFromDB(email, String.valueOf(Language.EN.getOurId()), Site.SNOW_ATTACK.toString());
        sendLegalInfo2(phone, pass, "" + cliSessionId + "", "Card Terms and Conditions");

        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(email, emailPass, appPass);
        String actualSender = senderAndSubject.get(0);
        String actualSubject = senderAndSubject.get(1);
        List<String>actualAttachedFileNames = EmailVerificationHelper.getFileNameFromEmail("pop.gmail.com", email, emailPass, appPass);
        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", email, emailPass, appPass);
        String actualBody = getEmailBodyText(emailText, 31, 178);
        String actualFooter = getEmailFooterText(emailText, 179);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualAttachedFileNames, Arrays.asList( "Card Terms and Conditions.pdf"), "File name is not correct");
        softAssert.assertEquals(actualSender, expectedSender, "Sender is not correct");
        softAssert.assertEquals(actualSubject, "Your "+app.site_SnowAttack+" Legal Documents", "Subject is not correct");
        softAssert.assertEquals(actualBody, "Dear "+app.emailsVerificationsFirstName+", As requested, please find attached selected "+app.site_SnowAttack+" legal documents. Thank you for using "+app.site_SnowAttack+". With kind regards, Legal Team", "Boody is not correct");
        softAssert.assertEquals(actualFooter, ""+app.SITE_REG+" "+app.site_SnowAttack+" is powered by DiPocket UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT", "Footer is not correct");
        softAssert.assertAll();
    }

    @Test(priority = 3)
    public void test_clientProfile_sendLegalInfo2_SnowAttackHU() throws InterruptedException, MessagingException, IOException, SQLException, ClassNotFoundException {
        app.getDbHelper().updateClientLanguageFromDB(email, String.valueOf(Language.HU.getOurId()), Site.SNOW_ATTACK.toString());
        sendLegalInfo2(phone, pass, "" + cliSessionId + "", "Kártyaszerződési feltételek");

        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(email, emailPass, appPass);
        String actualSender = senderAndSubject.get(0);
        String actualSubject = senderAndSubject.get(1);
        List<String>actualAttachedFileNames = EmailVerificationHelper.getFileNameFromEmail("pop.gmail.com", email, emailPass, appPass);
        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", email, emailPass, appPass);
        String actualBody = getEmailBodyText(emailText, 31, 181);
        String actualFooter = getEmailFooterText(emailText, 182);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualAttachedFileNames, Arrays.asList( "Kártyaszerződési feltételek.pdf"), "File name is not correct");
        softAssert.assertEquals(actualSender, expectedSender, "Sender is not correct");
        softAssert.assertEquals(actualSubject, "Az Ön "+app.site_SnowAttack+" jogi dokumentumai", "Subject is not correct");
        softAssert.assertEquals(actualBody, "Kedves "+app.emailsVerificationsFirstName+"! Kívánsága szerint, csatolva találja a jogi dokumentumokat. Köszönjük, hogy a Snow Attack alkalmazást használja. Üdvözlettel, Jogi csapat", "Boody is not correct");
        softAssert.assertEquals(actualFooter, ""+app.SITE_REG+" "+app.site_SnowAttack+", a DiPocket UAB támogatásával, mely vállalatot a Litván Nemzeti Bank elektronikus pénzintézetenként (# 75) engedélyezett és felügyel | a Mastercard licencével rendelkezik az Európai Gazdasági Térségre vonatkozva Upės str. 23, 08128 Vilnius, LT", "Footer is not correct");
        softAssert.assertAll();
    }
}