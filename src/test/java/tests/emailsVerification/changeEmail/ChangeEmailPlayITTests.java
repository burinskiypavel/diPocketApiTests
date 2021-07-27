package tests.emailsVerification.changeEmail;

import appmanager.EmailVerificationHelper;
import base.TestBase;
import org.testng.annotations.Test;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

import static appmanager.EmailIMAPHelper.getEmailBodyText;
import static appmanager.EmailIMAPHelper.getEmailFooterText;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ChangeEmailPlayITTests extends TestBase {
    String expectedEmailSender = "PlayIT Card <customer.service@dipocket.org>";

    public String body(int landId){
        return "{\n" +
                "\"id\": 32732,\n" +
                "\"clientFirstName\": \""+app.emailsVerificationsFirstName+"\",\n" +
                "\"clientLastName\": \""+app.emailsVerificationsLastName+"\",\n" +
                "\"countryId\": "+app.emailsVerificationsCountryId+",\n" +
                "\"langId\": "+landId+",\n" +
                "\"mainPhone\": \""+app.emailsVerificationsPhoneNumber+"\",\n" +
                "\"email\": \""+app.emailsVerificationsEmail+"\",\n" +
                "\"currencyId\": "+app.emailsVerificationsCurrencyId+",\n" +
                "\"site\": \""+app.mobile_site_playIt+"\",\n" +
                "\"siteEnum\": \""+app.mobile_site_playIt+"\",\n" +
                "\"programNickName\": \""+app.mobile_site_playIt+"\"\n" +
                "}";
    }

    public void postSendChangeEmail(int landId) {
        given()
                .spec(app.requestSpecEmailVerification)
                .body(body(landId))
                .when()
                .post( "/EmailService/sendChangeEmail")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test(priority = 1)
    public void testChangeEmailPlayITEN() throws InterruptedException, MessagingException, IOException {
        postSendChangeEmail(1);

        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualSender = senderAndSubject.get(0);
        String actualSubject = senderAndSubject.get(1);

        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualBody = getEmailBodyText(emailText, 44, 261);
        String actualFooter = getEmailFooterText(emailText, 262);

        assertThat(actualSender, equalTo(expectedEmailSender));
        assertThat(actualSubject, equalTo(""+app.site_PlayIT+" - email address verification request"));
        assertThat(actualBody, equalTo("Dear "+app.emailsVerificationsFirstName+", We received your request to verify the email address associated with your "+app.site_PlayIT+" account. Please click on this link to confirm your request and finalise the change. With kind regards, Customer Service Team"));
        assertThat(actualFooter, equalTo(""+app.SITE_REG+" "+app.site_PlayIT+" is powered by DiPocket UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT"));
    }

    @Test(priority = 2, enabled = false)//bug Change Email(Play IT, Snow Attack) HU email has incorrect body and subject
    public void testChangeEmailPlayITHU() throws InterruptedException, MessagingException, IOException {
        postSendChangeEmail(5);

        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualSender = senderAndSubject.get(0);
        String actualSubject = senderAndSubject.get(1);

        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualBody = getEmailBodyText(emailText, 44, 276);
        String actualFooter = getEmailFooterText(emailText, 277);

        assertThat(actualSender, equalTo(expectedEmailSender));
        assertThat(actualSubject, equalTo(""+app.site_PlayIT+" - email cím megerősítés kérés"));
        assertThat(actualBody, equalTo("Kedves "+app.emailsVerificationsFirstName+", Megkaptuk a "+app.site_PlayIT+" fiókjához tartozó e-mail cím megerősítésére vonatkozó kérését. Kérjük, kattintson erre a hivatkozásra a kérése megerősítéséhez és a módosítás véglegesítéséhez. Üdvözlettel, az Ügyfélszolgálati csapat"));
        assertThat(actualFooter, equalTo(""+app.SITE_REG+" Megnyugtatásul tájékoztatjuk, hogy a PlayIT Kártya számládat a DiPocket UAB kezeli, mely vállalatot a Litván Nemzeti Bank elektronikus pénzintézetenként (# 75) engedélyezett és felügyel Upės str. 23, 08128 Vilnius, LT"));
    }
}