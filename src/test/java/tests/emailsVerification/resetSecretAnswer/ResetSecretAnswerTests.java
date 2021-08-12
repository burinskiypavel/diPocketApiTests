package tests.emailsVerification.resetSecretAnswer;

import appmanager.EmailVerificationHelper;
import base.TestBase;
import org.testng.annotations.Test;

import javax.mail.MessagingException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import static appmanager.EmailIMAPHelper.getEmailBodyText;
import static appmanager.EmailIMAPHelper.getEmailFooterText;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ResetSecretAnswerTests extends TestBase {
    String expectedSender = "telenorwallet@dipocket.org";


    public void postSendResetPasswordEmail() {
        given()
                .spec(app.requestSpecEmailVerification)
                .queryParam("email", "testdipocket@gmail.com")
                .when()
                .post( "/EmailService/sendTelenorEmailForResetSecretAnswer")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    public void testResetSecretAnswerTelenorEN() throws InterruptedException, MessagingException, IOException, SQLException, ClassNotFoundException {
        app.getDbHelper().updateClientLanguageFromDB(app.emailsVerificationsEmail, "1", "TELENOR");
        postSendResetPasswordEmail();

        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualSender = senderAndSubject.get(0);
        String actualSubject = senderAndSubject.get(1);

        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualBody = getEmailBodyText(emailText, 28, 217);
        String actualFooter = getEmailFooterText(emailText, 218);

        //assertThat(actualSender, equalTo(expectedSender));
        assertThat(actualSubject, equalTo("Your secret answer reset request"));
        //assertThat(actualBody, equalTo(""));
        //assertThat(actualFooter, equalTo(""+app.SITE_REG+" "+app.site_Telenor+" is powered by DiPocket UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT"));
    }

    @Test(enabled = false)//incorrect subject, footer, body
    public void testResetSecretAnswerTelenorHU() throws InterruptedException, MessagingException, IOException, SQLException, ClassNotFoundException {
        app.getDbHelper().updateClientLanguageFromDB(app.emailsVerificationsEmail, "5", "TELENOR");
        postSendResetPasswordEmail();

        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualSender = senderAndSubject.get(0);
        String actualSubject = senderAndSubject.get(1);

        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualBody = getEmailBodyText(emailText, 28, 217);
        String actualFooter = getEmailFooterText(emailText, 218);

        //assertThat(actualSender, equalTo(expectedSender));
        assertThat(actualSubject, equalTo(""));
        assertThat(actualBody, equalTo(""));
        assertThat(actualFooter, equalTo(""));
    }


}