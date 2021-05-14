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

public class ChangeEmailPlayITTests extends TestBase {
    String site = "PlayIT";
    String firstName = "Salat";
    String emailFrom = "PlayIT Card <customer.service@dipocket.org>";
    String testEmail = "testdipocket@gmail.com";
    String pass = "password1<";
    String SITE_REG = "DiPocket®";

    public String body(int landId){
        return "{\n" +
                "\"id\": 30457,\n" +
                "\"clientFirstName\": \""+firstName+"\",\n" +
                "\"clientLastName\": \"Test\",\n" +
                "\"countryId\": 826,\n" +
                "\"langId\": "+landId+",\n" +
                "\"mainPhone\": \"380661470959\",\n" +
                "\"email\": \""+testEmail+"\",\n" +
                "\"currencyId\": 978,\n" +
                "\"site\": \"PLAYIT\",\n" +
                "\"siteEnum\": \"PLAYIT\",\n" +
                "\"programNickName\": \"PLAYIT\"\n" +
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
    public void testChangeEmailPlayITEN() throws InterruptedException, MessagingException, IOException {
        postSendChangeEmail(1);

        String emailSender =  EmailIMAPHelper3.getEmailSender(testEmail, pass);
        String emailText =  EmailIMAPHelper3.getTextFromEmail("pop.gmail.com", testEmail, pass);
        String emailBody = getEmailBodyText(emailText, 44, 261);
        String emailFooter = getEmailFooterText(emailText, 262);

        assertThat(emailSender, equalTo(emailFrom));
        assertThat(emailBody, equalTo("Dear "+firstName+", We received your request to verify the email address associated with your "+site+" account. Please click on this link to confirm your request and finalise the change. With kind regards, Customer Service Team"));
        assertThat(emailFooter, equalTo(""+SITE_REG+" "+site+" is powered by DiPocket UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT"));
    }

    @Test(priority = 2, enabled = false)//bug body is not correct
    public void testChangeEmailPlayITHU() throws InterruptedException, MessagingException, IOException {
        postSendChangeEmail(5);

        String emailSender =  EmailIMAPHelper3.getEmailSender(testEmail, pass);
        String emailText =  EmailIMAPHelper3.getTextFromEmail("pop.gmail.com", testEmail, pass);
        String emailBody = getEmailBodyText(emailText, 44, 276);
        String emailFooter = getEmailFooterText(emailText, 277);

        assertThat(emailSender, equalTo(emailFrom));
        assertThat(emailBody, equalTo("Здравствуйте, "+firstName+"! Мы получили запрос на верификацию адреса электронной почты, которая указана в Вашей учетной записи. Пожалуйста, перейдите по этой ссылке , чтобы подтвердить изменение. С уважением, Служба поддержки клиентов"));
        assertThat(emailFooter, equalTo(""+SITE_REG+" Для вашего спокойствия, "+site+" UAB авторизован и контролируется Банком Литвы как эмитент электронных денег (#75) Upės str. 23, 08128 Vilnius, LT"));
    }
}