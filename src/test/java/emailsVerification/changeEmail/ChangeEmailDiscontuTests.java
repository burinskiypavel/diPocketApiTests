package emailsVerification.changeEmail;

import appmanager.EmailIMAPHelper3;
import base.TestBase;
import org.testng.annotations.Test;

import javax.mail.MessagingException;
import java.io.IOException;

import static appmanager.EmailIMAPHelper.getEmailBodyText;
import static appmanager.EmailIMAPHelper.getEmailFooterText;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ChangeEmailDiscontuTests extends TestBase {
    String site = "discontu";
    String firstName = "Salat";
    String emailFrom = "customer.service@dipocket.org";
    String testEmail = "testdipocket@gmail.com";
    String pass = "password1<";
    String SITE_REG = "DiPocket®";

    public String body(int landId){
        return "{\n" +
                "\"id\": 31019,\n" +
                "\"clientFirstName\": \""+firstName+"\",\n" +
                "\"clientLastName\": \"Sergeyt\",\n" +
                "\"countryId\": 826,\n" +
                "\"langId\": "+landId+",\n" +
                "\"mainPhone\": \"380661470959\",\n" +
                "\"email\": \""+testEmail+"\",\n" +
                "\"currencyId\": 978,\n" +
                "\"site\": \"DISCONTU\",\n" +
                "\"siteEnum\": \"DISCONTU\",\n" +
                "\"programNickName\": \"DISCONTU\"\n" +
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

    @Test(priority = 1)
    public void testChangeEmailDiscontuEN() throws InterruptedException, MessagingException, IOException {
        postSendChangeEmail(1);

        String emailSender =  EmailIMAPHelper3.getEmailSender(testEmail, pass);
        String emailText =  EmailIMAPHelper3.getTextFromEmail("pop.gmail.com", testEmail, pass);
        String emailBody = getEmailBodyText(emailText, 46, 265);
        String emailFooter = getEmailFooterText(emailText, 266);

        assertThat(emailSender, equalTo(emailFrom));
        assertThat(emailBody, equalTo("Dear "+firstName+", We received your request to verify the email address associated with your "+site+" account. Please click on this link to confirm your request and finalise the change. With kind regards, Customer Service Team"));
        assertThat(emailFooter, equalTo(""+SITE_REG+" "+site+" is powered by DiPocket UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT"));
    }

    @Test(priority = 2)
    public void testChangeEmailDiscontuPL() throws InterruptedException, MessagingException, IOException {
        postSendChangeEmail(2);

        String emailSender =  EmailIMAPHelper3.getEmailSender(testEmail, pass);
        String emailText =  EmailIMAPHelper3.getTextFromEmail("pop.gmail.com", testEmail, pass);
        String emailBody = getEmailBodyText(emailText, 0, 210);
        String emailFooter = getEmailFooterText(emailText, 211);

        assertThat(emailSender, equalTo(emailFrom));
        assertThat(emailBody, equalTo("Witaj, "+firstName+"! Otrzymaliśmy prośbę o weryfikację adresu email powiązanego z Twoim kontem "+site+". Kliknij w ten link , aby potwierdzić tę prośbę i sfinalizować zmianę. Z wyrazami szacunku, Dział Obsługi Klienta"));
        assertThat(emailFooter, equalTo(""+SITE_REG+" "+site+" dostarcza DiPocket UAB, autoryzowana Instytucja Pieniądza Elektronicznego, podlegająca nadzorowi Banku Litwy (numer licencji 75) | Licencjonowana przez Mastercard do działania na Europejskim Obszarze Gospodarczego Upės g. 23, 08128 Vilnius, LT"));
    }
}