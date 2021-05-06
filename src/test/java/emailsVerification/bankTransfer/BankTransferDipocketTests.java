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

public class BankTransferDipocketTests extends TestBase {

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
                "\"site\": \"DIPOCKET\",\n" +
                "\"siteEnum\": \"DIPOCKET\",\n" +
                "\"programNickName\": \"DIPOCKET\"\n" +
                "}";
    }

    public void postSendBankTransferEmail(int landId) {
        given()
                .header("Content-Type", "application/json")
                .body(body(landId))
                .when()
                .post( app.dipocket3_intranet+"/EmailService/sendBankTransferEmail")
                .then().log().all()
                .statusCode(200);
    }

    @Test(priority = 1)
    public void testBankTransferDipocketEN() throws InterruptedException, MessagingException, IOException {
        postSendBankTransferEmail(1);

        String emailSender =  EmailIMAPHelper3.getEmailSender("testdipocket@gmail.com", "password1<");
        String emailText =  EmailIMAPHelper3.getTextFromEmail("pop.gmail.com", "testdipocket@gmail.com", "password1<");
        String emailBody = getEmailBodyText(emailText, 50, 158);
        String emailFooter = getEmailFooterText(emailText, 159);

        assertThat(emailSender, equalTo("customer.service@dipocket.org"));
        assertThat(emailBody, equalTo("As requested, please find attached your bank transfer confirmation. With kind regards, Customer Service Team"));
        assertThat(emailFooter, equalTo("DiPocket® DiPocket UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT"));
    }

    @Test(priority = 2)
    public void testBankTransferDipocketUA() throws InterruptedException, MessagingException, IOException {
        postSendBankTransferEmail(2);

        String emailSender =  EmailIMAPHelper3.getEmailSender("testdipocket@gmail.com", "password1<");
        String emailText =  EmailIMAPHelper3.getTextFromEmail("pop.gmail.com", "testdipocket@gmail.com", "password1<");
        String emailBody = getEmailBodyText(emailText, 44, 154);
        String emailFooter = getEmailFooterText(emailText, 155);

        assertThat(emailSender, equalTo("customer.service@dipocket.org"));
        assertThat(emailBody, equalTo("В додатку знаходиться замовлене Вами підтвердження банківського переказу. З повагою, Відділ підтримки клієнтів"));
        assertThat(emailFooter, equalTo("DiPocket® Для Вашого спокою, DiPocket UAB авторизований та контролюється Банком Литви, як емітент електронних грошей (#75) Upės str. 23, 08128 Vilnius, LT"));
    }

    @Test(priority = 3, enabled = false)
    public void testBankTransferDipocketPL() throws InterruptedException, MessagingException, IOException {
        postSendBankTransferEmail(3);

        String emailSender =  EmailIMAPHelper3.getEmailSender("testdipocket@gmail.com", "password1<");
        String emailText =  EmailIMAPHelper3.getTextFromEmail("pop.gmail.com", "testdipocket@gmail.com", "password1<");
        String emailBody = getEmailBodyText(emailText, 13, 126);
        String emailFooter = getEmailFooterText(emailText, 127);

        assertThat(emailSender, equalTo("customer.service@dipocket.org"));
        assertThat(emailBody, equalTo("W załączniku znajduje się zamówione potwierdzenie przelewu bankowego. Z wyrazami szacunku, Zespół Obsługi Klienta"));
        assertThat(emailFooter, equalTo("DiPocket® DiPocket UAB, autoryzowana Instytucja Pieniądza Elektronicznego, podlegająca nadzorowi Banku Litwy (numer licencji 75) | Licencjonowana przez Masterсard do działania na Europejskim Obszarze Gospodarczego Upės g. 23, 08128 Vilnius, LT"));
    }

    @Test(priority = 4)
    public void testBankTransferDipocketRU() throws InterruptedException, MessagingException, IOException {
        postSendBankTransferEmail(4);

        String emailSender =  EmailIMAPHelper3.getEmailSender("testdipocket@gmail.com", "password1<");
        String emailText =  EmailIMAPHelper3.getTextFromEmail("pop.gmail.com", "testdipocket@gmail.com", "password1<");
        String emailBody = getEmailBodyText(emailText, 49, 169);
        String emailFooter = getEmailFooterText(emailText, 170);

        assertThat(emailSender, equalTo("customer.service@dipocket.org"));
        assertThat(emailBody, equalTo("В приложении находится подтверждение банковского перевода, которое Вы заказывали. С уважением, Служба поддержки клиентов"));
        assertThat(emailFooter, equalTo("DiPocket® Для вашего спокойствия, DiPocket UAB авторизован и контролируется Банком Литвы как эмитент электронных денег (#75) Upės str. 23, 08128 Vilnius, LT"));
    }
}