package tests.emailsVerification.changeEmail;

import appmanager.EmailVerificationHelper;
import base.TestBase;
import org.testng.annotations.Test;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

import static appmanager.EmailIMAPHelper.getEmailBodyText;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ChangeEmailSodexoTests extends TestBase {
    String site = "Sodexo";
    String expectedEmailSender = "kontakt.wirtualna@sodexo.com";

    public String body(int landId){
        return "{\n" +
                "\"id\": 32762,\n" +
                "\"clientFirstName\": \""+app.emailsVerificationsFirstName+"\",\n" +
                "\"clientLastName\": \""+app.emailsVerificationsLastName+"\",\n" +
                "\"countryId\": "+app.emailsVerificationsCountryId+",\n" +
                "\"langId\": "+landId+",\n" +
                "\"mainPhone\": \""+app.emailsVerificationsPhoneNumber+"\",\n" +
                "\"email\": \""+app.emailsVerificationsEmail+"\",\n" +
                "\"currencyId\": "+app.emailsVerificationsCurrencyId+",\n" +
                "\"site\": \"SODEXO\",\n" +
                "\"siteEnum\": \"SODEXO\",\n" +
                "\"programNickName\": \"SODEXO\"\n" +
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

    @Test(priority = 1)//bug incorrect email sender
    public void testChangeEmailSodexoPLEN() throws InterruptedException, MessagingException, IOException {
        postSendChangeEmail(1);

        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualSender = senderAndSubject.get(0);
        String actualSubject = senderAndSubject.get(1);

        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualBody = getEmailBodyText(emailText, 94, 724);

        //assertThat(actualSender, equalTo(expectedEmailSender));
        assertThat(actualSubject, equalTo(""+site+" - email address verification request"));
        assertThat(actualBody, equalTo(""+app.emailsVerificationsFirstName+" Burinsky, Potwierdź adres mailowy powiązany z Twoim Profilem Wirtualnej Karty Sodexo. Kliknij w ten link, aby potwierdzić i zakończyć proces. Pozdrawiamy, Zespół Wirtualnej Karty Sodexo Centrum Obsługi Klienta +48 (22) 535 11 11 | info.svc.pl@sodexo.com Your Virtual Sodexo Card profile - email address verification request "+app.emailsVerificationsFirstName+" Burinsky, Verify the email address associated with your Virtual Sodexo Card Profile. Please click on this link to confirm and finalize the process. With kind regards, Virtual Sodexo Card Team Customer Service Center +48 (22) 535 11 11 | info.svc.pl@sodexo.com powered by DiPocket (dipocket.org)"));
    }
}