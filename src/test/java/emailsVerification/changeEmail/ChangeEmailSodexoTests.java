package emailsVerification.changeEmail;

import appmanager.EmailVerificationHelper;
import base.TestBase;
import org.testng.annotations.Test;

import javax.mail.MessagingException;
import java.io.IOException;

import static appmanager.EmailIMAPHelper.getEmailBodyText;
import static appmanager.EmailIMAPHelper.getEmailFooterText;
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
                .header("Content-Type", "application/json")
                .body(body(landId))
                .when()
                .post( app.dipocket3_intranet+"/EmailService/sendChangeEmail")
                .then().log().all()
                .statusCode(200);
    }

    @Test(priority = 1)//bug incorrect email sender
    public void testChangeEmailSodexoEN() throws InterruptedException, MessagingException, IOException {
        postSendChangeEmail(1);

        String emailSender =  EmailVerificationHelper.getEmailSender(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailBody = getEmailBodyText(emailText, 44, 265);
        String emailFooter = getEmailFooterText(emailText, 266);

        assertThat(emailSender, equalTo(expectedEmailSender));
        assertThat(emailBody, equalTo("Dear "+app.emailsVerificationsFirstName+", We received your request to verify the email address associated with your "+site+" account. Please click on this link to confirm your request and finalise the change. With kind regards, Customer Service Team"));
        assertThat(emailFooter, equalTo(""+app.SITE_REG+" "+site+" is powered by DiPocket UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT"));
    }

    @Test(priority = 2)//bug incorrect email sender
    public void testChangeEmailSodexoPL() throws InterruptedException, MessagingException, IOException {
        postSendChangeEmail(2);

        String emailSender =  EmailVerificationHelper.getEmailSender(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailBody = getEmailBodyText(emailText, 0, 210);
        String emailFooter = getEmailFooterText(emailText, 211);

        assertThat(emailSender, equalTo(expectedEmailSender));
        assertThat(emailBody, equalTo("Witaj, "+app.emailsVerificationsFirstName+"! Otrzymaliśmy prośbę o weryfikację adresu email powiązanego z Twoim kontem "+site+". Kliknij w ten link , aby potwierdzić tę prośbę i sfinalizować zmianę. Z wyrazami szacunku, Dział Obsługi Klienta"));
        assertThat(emailFooter, equalTo(""+app.SITE_REG+" "+site+" dostarcza DiPocket UAB, autoryzowana Instytucja Pieniądza Elektronicznego, podlegająca nadzorowi Banku Litwy (numer licencji 75) | Licencjonowana przez Mastercard do działania na Europejskim Obszarze Gospodarczego Upės g. 23, 08128 Vilnius, LT"));
    }
}