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
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class StatementAttachmentsSnowAttackTests extends TestBase {
    String cliSessionId = null;
    String expectedSender = "statements@dipocket.org";
    String email = "testdipocket2@gmail.com";
    String emailPass = "pasword12!";
    String pass = "pasword1";
    String deviceuuid = "380633192217-AutoTest-Login";
    String phone = "380633192217";


    @Test(priority = 2, enabled = false)
    public void test_dashBoard_customerStatementRequestList() {
        cliSessionId = app.getLogin_registrationHelper().loginSnowAttack(phone, pass);
        given()
                .baseUri(HelperBase.prop.getProperty("mobile.base.url"))
                .header("site", app.mobile_site_snowAttack)
                .header("deviceuuid", deviceuuid)
                .auth().preemptive().basic("11_" + phone, pass)
                .header("clisessionid", ""+cliSessionId+"")
                .when()
                .get("/dashBoard/customerStatementRequestList")
                .then().log().all()
                .statusCode(200)
                .body("statementRequestList.month", hasItems("08"),
                        "statementRequestList.year", hasItems("2021"));
    }

    public void sendCustomerStatements(String phone, String pass, String cliSessionId) {
        given().log().uri().log().headers().log().body()
                .baseUri(HelperBase.prop.getProperty("mobile.base.url"))
                .header("site", app.mobile_site_snowAttack)
                .header("deviceuuid", deviceuuid)
                .auth().preemptive().basic("9_" + phone, pass)
                .header("clisessionid", cliSessionId)
                .contentType("application/json")
                .body("{\n" +
                        "  \"reportTypeId\": 1,\n" +
                        "  \"statementRequestList\": [\n" +
                        "    {\n" +
                        "      \"month\": \"08\",\n" +
                        "      \"year\": \"2021\"\n" +
                        "    }\n" +
                        "  ]\n" +
                        "}")
                .when()
                .put("/dashBoard/sendCustomerStatements")
                .then().log().all()
                .statusCode(200);
    }

    @Test(priority = 3, enabled = false)
    public void test_dashBoard_sendCustomerStatements_SnowAttackEN() throws InterruptedException, MessagingException, IOException, SQLException, ClassNotFoundException {
        app.getDbHelper().updateClientLanguageFromDB(email, "1", app.mobile_site_snowAttack);
        sendCustomerStatements(phone, pass, "" + cliSessionId + "");

        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(email, emailPass);
        String actualSender = senderAndSubject.get(0);
        String actualSubject = senderAndSubject.get(1);
        List<String>actualAttachedFileNames = EmailVerificationHelper.getFileNameFromEmail("pop.gmail.com", email, emailPass);
        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", email, emailPass);
        String actualBody = getEmailBodyText(emailText, 31, 179);
        String actualFooter = getEmailFooterText(emailText, 180);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualAttachedFileNames, Arrays.asList(""), "File name is not correct");
        softAssert.assertEquals(actualSender, expectedSender, "Sender is not correct ");
        softAssert.assertEquals(actualSubject, "Your "+app.site_SnowAttack+" account statement", "Subject is not correct");
        softAssert.assertEquals(actualBody, "Dear "+app.emailsVerificationsFirstName+", As requested, please find attached your "+app.site_SnowAttack+" account statement(s). Thank you for using "+app.site_SnowAttack+". With kind regards, Legal Team", "Body is not correct ");
        softAssert.assertEquals(actualFooter, ""+app.SITE_REG+" "+app.site_SnowAttack+" is powered by DiPocket UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT", "Footer is not correct");
        softAssert.assertAll();
    }

    @Test(priority = 4, enabled = false)
    public void test_dashBoard_sendCustomerStatements_SnowAttackHU() throws InterruptedException, MessagingException, IOException, SQLException, ClassNotFoundException {
        app.getDbHelper().updateClientLanguageFromDB(email, "5", app.mobile_site_snowAttack);
        sendCustomerStatements(phone, pass, "" + cliSessionId + "");

        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(email, emailPass);
        String actualSender = senderAndSubject.get(0);
        String actualSubject = senderAndSubject.get(1);
        List<String>actualAttachedFileNames = EmailVerificationHelper.getFileNameFromEmail("pop.gmail.com", email, emailPass);
        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", email, emailPass);
        String actualBody = getEmailBodyText(emailText, 26, 186);
        String actualFooter = getEmailFooterText(emailText, 187);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualAttachedFileNames, Arrays.asList("statement-08.2021.pdf"), "File name is not correct");
        softAssert.assertEquals(actualSender, expectedSender, "Sender is not correct");
        softAssert.assertEquals(actualSubject, "AZ Ön "+app.site_PlayIT+" számlakivonata", "Subject is not correct");
        softAssert.assertEquals(actualBody, "Kedves "+app.emailsVerificationsFirstName+", Kívánsága szerint, csatolva találja a számlakivonatát (számlakivonatait). Köszönjük, hogy a PlayIT alkalmazást használja. Üdvözlettel, Jogi csapat", "Body is not correct");
        softAssert.assertEquals(actualFooter, ""+app.SITE_REG+" Megnyugtatásul tájékoztatjuk, hogy a PlayIT Kártya számládat a DiPocket UAB kezeli, mely vállalatot a Litván Nemzeti Bank elektronikus pénzintézetenként (# 75) engedélyezett és felügyel Upės str. 23, 08128 Vilnius, LT", "Footer is not correct");
        softAssert.assertAll();
    }

}