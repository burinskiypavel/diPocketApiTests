package emailsVerification.bankTransfer;

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

public class BankTransferUpAndGoTests extends TestBase {
    String site = "up and go";
    String expectedEmailSender = "wsparcie@upcard.pl";

    public String body(int landId, String firstName){
        return "{\n" +
                "\"id\": 32727,\n" +
                "\"clientFirstName\": \""+app.emailsVerificationsFirstName+"\",\n" +
                "\"clientLastName\": \""+app.emailsVerificationsLastName+"\",\n" +
                "\"countryId\": "+app.emailsVerificationsCountryId+",\n" +
                "\"langId\": "+landId+",\n" +
                "\"mainPhone\": \""+app.emailsVerificationsPhoneNumber+"\",\n" +
                "\"email\": \""+app.emailsVerificationsEmail+"\",\n" +
                "\"currencyId\": "+app.emailsVerificationsCurrencyId+",\n" +
                "\"site\": \""+app.mobile_site_upAndGo+"\",\n" +
                "\"siteEnum\": \""+app.mobile_site_upAndGo+"\",\n" +
                "\"programNickName\": \""+app.mobile_site_upAndGo+"\"\n" +
                "}";
    }

    public void postSendBankTransferEmail(int landId) {
        given()
                .header("Content-Type", "application/json")
                .body(body(landId, app.emailsVerificationsFirstName))
                .when()
                .post( app.dipocket3_intranet+"/EmailService/sendBankTransferEmail")
                .then().log().all()
                .statusCode(200);
    }

    @Test(priority = 1)
    public void testBankTransferUpAndGoEN() throws InterruptedException, MessagingException, IOException {
        postSendBankTransferEmail(1);

        String emailSender =  EmailIMAPHelper3.getEmailSender(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailText =  EmailIMAPHelper3.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailBody = getEmailBodyText(emailText, 39, 159);
        String emailFooter = getEmailFooterText(emailText, 160);

        assertThat(emailSender, equalTo(expectedEmailSender));
        assertThat(emailBody, equalTo("Dear "+app.emailsVerificationsFirstName+", As requested, please find attached your bank transfer confirmation. With kind regards, Customer Service Team"));
        assertThat(emailFooter, equalTo(""+app.SITE_REG+" "+site+" is powered by DiPocket UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT"));
    }

    @Test(priority = 2)
    public void testBankTransferUpAndGoUA() throws InterruptedException, MessagingException, IOException {
        postSendBankTransferEmail(2);

        String emailSender =  EmailIMAPHelper3.getEmailSender(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailText =  EmailIMAPHelper3.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailBody = getEmailBodyText(emailText, 29, 155);
        String emailFooter = getEmailFooterText(emailText, 156);

        assertThat(emailSender, equalTo(expectedEmailSender));
        assertThat(emailBody, equalTo("Вітаємо, "+app.emailsVerificationsFirstName+"! В додатку знаходиться замовлене Вами підтвердження банківського переказу. З повагою, Відділ підтримки клієнтів"));
        assertThat(emailFooter, equalTo(""+app.SITE_REG+" Для Вашого спокою, "+site+" працює при підтримці DiPocket UAB, що авторизований та контролюється Банком Литви, як емітент електронних грошей (#75) Upės str. 23, 08128 Vilnius, LT"));
    }

    @Test(priority = 3)
    public void testBankTransferUpAndGoPL() throws InterruptedException, MessagingException, IOException {
        postSendBankTransferEmail(3);

        String emailSender =  EmailIMAPHelper3.getEmailSender(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailText =  EmailIMAPHelper3.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailBody = getEmailBodyText(emailText, 0, 126);
        String emailFooter = getEmailFooterText(emailText, 127);

        assertThat(emailSender, equalTo(expectedEmailSender));
        assertThat(emailBody, equalTo("Witaj "+app.emailsVerificationsFirstName+", W załączniku znajduje się zamówione potwierdzenie przelewu bankowego. Z wyrazami szacunku, Zespół Obsługi Klienta"));
        assertThat(emailFooter, equalTo(""+app.SITE_REG+" "+site+" dostarcza DiPocket UAB, autoryzowana Instytucja Pieniądza Elektronicznego, podlegająca nadzorowi Banku Litwy (numer licencji 75) | Licencjonowana przez Mastercard do działania na Europejskim Obszarze Gospodarczego Upės g. 23, 08128 Vilnius, LT"));
    }

    @Test(priority = 4)
    public void testBankTransferUpAndGoRU() throws InterruptedException, MessagingException, IOException {
        postSendBankTransferEmail(4);

        String emailSender =  EmailIMAPHelper3.getEmailSender(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailText =  EmailIMAPHelper3.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailBody = getEmailBodyText(emailText, 29, 170);
        String emailFooter = getEmailFooterText(emailText, 171);

        assertThat(emailSender, equalTo(expectedEmailSender));
        assertThat(emailBody, equalTo("Здравствуйте, "+app.emailsVerificationsFirstName+"! В приложении находится подтверждение банковского перевода, которое Вы заказывали. С уважением, Служба поддержки клиентов"));
        assertThat(emailFooter, equalTo(""+app.SITE_REG+" Для вашего спокойствия, "+site+" осуществляет деятельность при поддержке DiPocket UAB, который авторизован и контролируется Банком Литвы как эмитент электронных денег (#75) Upės str. 23, 08128 Vilnius, LT"));
    }
}