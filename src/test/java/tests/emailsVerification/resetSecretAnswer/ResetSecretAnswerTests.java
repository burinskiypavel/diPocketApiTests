package tests.emailsVerification.resetSecretAnswer;

import appmanager.EmailVerificationHelper;
import base.TestBase;
import com.cs.dipocketback.base.data.Site;
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
        app.getDbHelper().updateClientLanguageFromDB(app.emailsVerificationsEmail, "1", Site.TELENOR.toString());
        postSendResetPasswordEmail();

        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualSender = senderAndSubject.get(0);
        String actualSubject = senderAndSubject.get(1);

        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualBody = getEmailBodyText(emailText, 10, 215);
        String actualFooter = getEmailFooterText(emailText, 216);

        assertThat(actualSender, equalTo(expectedSender));
        assertThat(actualSubject, equalTo("Your secret answer reset request"));
        assertThat(actualBody, equalTo("Dear Test. We received a request to reset the secret answer associated with your account. Please click on this link to confirm your request and finalise the change. With kind regards, Customer Service Team"));
        assertThat(actualFooter, equalTo(""+app.SITE_REG+" "+app.site_Telenor+" is powered by DiPocket UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Mastercard for the European Economic Area Upės str. 23, 08128 Vilnius, LT"));
    }

    @Test()//incorrect body, footer
    public void testResetSecretAnswerTelenorHU() throws InterruptedException, MessagingException, IOException, SQLException, ClassNotFoundException {
        app.getDbHelper().updateClientLanguageFromDB(app.emailsVerificationsEmail, "5", Site.TELENOR.toString());
        postSendResetPasswordEmail();

        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualSender = senderAndSubject.get(0);
        String actualSubject = senderAndSubject.get(1);

        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualBody = getEmailBodyText(emailText, 28, 217);
        String actualFooter = getEmailFooterText(emailText, 218);

        assertThat(actualSender, equalTo(expectedSender));
        assertThat(actualSubject, equalTo("Biztonsági kérdés visszaállítási kérése"));
        //assertThat(actualBody, equalTo(""));
        //assertThat(actualFooter, equalTo(""+app.SITE_REG+" "+app.site_Telenor+", a DiPocket UAB támogatásával, mely vállalatot a Litván Nemzeti Bank elektronikus pénzintézetenként (# 75) engedélyezett és felügyel | a Mastercard licencével rendelkezik az Európai Gazdasági Térségre vonatkozva Upės str. 23, 08128 Vilnius, LT"));
    }
}