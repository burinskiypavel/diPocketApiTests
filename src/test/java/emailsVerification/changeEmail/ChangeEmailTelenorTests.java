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

public class ChangeEmailTelenorTests extends TestBase {
    String site = "Telenor";

    public String body(int landId){
        return "{\n" +
                "\"id\": 30457,\n" +
                "\"clientFirstName\": \"Salat\",\n" +
                "\"clientLastName\": \"Test\",\n" +
                "\"countryId\": 826,\n" +
                "\"langId\": "+landId+",\n" +
                "\"mainPhone\": \"380661470959\",\n" +
                "\"email\": \"testdipocket@gmail.com\",\n" +
                "\"currencyId\": 978,\n" +
                "\"site\": \"TELENOR\",\n" +
                "\"siteEnum\": \"TELENOR\",\n" +
                "\"programNickName\": \"TELENOR\"\n" +
                "}";
    }

    public void postSendChangeEmailEmail(int landId) {
        given()
                .header("Content-Type", "application/json")
                .body(body(landId))
                .when()
                .post( app.dipocket3_intranet+"/EmailService/sendChangeEmail")
                .then().log().all()
                .statusCode(200);
    }

    @Test(priority = 1)
    public void testChangeEmailTelenorEN() throws InterruptedException, MessagingException, IOException {
        postSendChangeEmailEmail(1);

        String emailSender =  EmailIMAPHelper3.getEmailSender("testdipocket@gmail.com", "password1<");
        String emailText =  EmailIMAPHelper3.getTextFromEmail("pop.gmail.com", "testdipocket@gmail.com", "password1<");
        String emailBody = getEmailBodyText(emailText, 12, 218);
        String emailFooter = getEmailFooterText(emailText, 219);

        assertThat(emailSender, equalTo("telenorwallet@dipocket.org"));
        assertThat(emailBody, equalTo("We received your request to verify the email address associated with your "+site+" account. Please click on this link to confirm your request and finalise the change. With kind regards, Customer Service Team"));
        assertThat(emailFooter, equalTo(""+site+"® "+site+" is powered by DiPocket UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT"));
    }

    @Test(priority = 2, enabled = false)
    public void testChangeEmailTelenorHU() throws InterruptedException, MessagingException, IOException {
        postSendChangeEmailEmail(2);

        String emailSender =  EmailIMAPHelper3.getEmailSender("testdipocket@gmail.com", "password1<");
        String emailText =  EmailIMAPHelper3.getTextFromEmail("pop.gmail.com", "testdipocket@gmail.com", "password1<");
        String emailBody = getEmailBodyText(emailText, 12, 218);
        String emailFooter = getEmailFooterText(emailText, 219);

        assertThat(emailSender, equalTo("telenorwallet@dipocket.org"));
        assertThat(emailBody, equalTo("Ми отримали запит на верифікацію Вашої електронної адреси приєднану до вашого облікового запису "+site+". Будь ласка, перейдіть за цим посиланням , щоб підтвердити Ваш запит та завершити зміни. З повагою, Відділ підтримки клієнтів"));
        assertThat(emailFooter, equalTo("DiPocket® Для Вашого спокою, DiPocket UAB авторизований та контролюється Банком Литви, як емітент електронних грошей (#75) Upės str. 23, 08128 Vilnius, LT"));
    }
}