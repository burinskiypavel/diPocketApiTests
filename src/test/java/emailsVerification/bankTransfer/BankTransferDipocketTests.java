package emailsVerification.bankTransfer;

import appmanager.EmailIMAPHelper3;
import appmanager.HelperBase;
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
    String site = "DiPocket";
    String emailFrom = "customer.service@dipocket.org";
    String SITE_REG = "DiPocket®";

    public String body(int landId){
        return "{\n" +
                "\"id\": 32726,\n" +
                "\"clientFirstName\": \""+HelperBase.prop.getProperty("emailsVerifications.firstName")+"\",\n" +
                "\"clientLastName\": \""+HelperBase.prop.getProperty("emailsVerifications.lastName")+"\",\n" +
                "\"countryId\": 826,\n" +
                "\"langId\": "+landId+",\n" +
                "\"mainPhone\": \""+HelperBase.prop.getProperty("emailsVerifications.phoneNumber")+"\",\n" +
                "\"email\": \""+HelperBase.prop.getProperty("emailsVerifications.email")+"\",\n" +
                "\"currencyId\": 978,\n" +
                "\"site\": \""+HelperBase.prop.getProperty("mobile.site")+"\",\n" +
                "\"siteEnum\": \""+HelperBase.prop.getProperty("mobile.site")+"\",\n" +
                "\"programNickName\": \""+HelperBase.prop.getProperty("mobile.site")+"\"\n" +
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

        String emailSender =  EmailIMAPHelper3.getEmailSender(HelperBase.prop.getProperty("emailsVerifications.email"), HelperBase.prop.getProperty("emailsVerifications.pass"));
        String emailText =  EmailIMAPHelper3.getTextFromEmail("pop.gmail.com", HelperBase.prop.getProperty("emailsVerifications.email"), HelperBase.prop.getProperty("emailsVerifications.pass"));
        String emailBody = getEmailBodyText(emailText, 38, 158);
        String emailFooter = getEmailFooterText(emailText, 159);

        assertThat(emailSender, equalTo(emailFrom));
        assertThat(emailBody, equalTo("Dear "+HelperBase.prop.getProperty("emailsVerifications.firstName")+", As requested, please find attached your bank transfer confirmation. With kind regards, Customer Service Team"));
        assertThat(emailFooter, equalTo(""+SITE_REG+" "+site+" UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT"));
    }

    @Test(priority = 2)
    public void testBankTransferDipocketUA() throws InterruptedException, MessagingException, IOException {
        postSendBankTransferEmail(2);

        String emailSender =  EmailIMAPHelper3.getEmailSender(HelperBase.prop.getProperty("emailsVerifications.email"), HelperBase.prop.getProperty("emailsVerifications.pass"));
        String emailText =  EmailIMAPHelper3.getTextFromEmail("pop.gmail.com", HelperBase.prop.getProperty("emailsVerifications.email"), HelperBase.prop.getProperty("emailsVerifications.pass"));
        String emailBody = getEmailBodyText(emailText, 28, 154);
        String emailFooter = getEmailFooterText(emailText, 155);

        assertThat(emailSender, equalTo(emailFrom));
        assertThat(emailBody, equalTo("Вітаємо, "+HelperBase.prop.getProperty("emailsVerifications.firstName")+"! В додатку знаходиться замовлене Вами підтвердження банківського переказу. З повагою, Відділ підтримки клієнтів"));
        assertThat(emailFooter, equalTo(""+SITE_REG+" Для Вашого спокою, "+site+" UAB авторизований та контролюється Банком Литви, як емітент електронних грошей (#75) Upės str. 23, 08128 Vilnius, LT"));
    }

    @Test(priority = 3)
    public void testBankTransferDipocketPL() throws InterruptedException, MessagingException, IOException {
        postSendBankTransferEmail(3);

        String emailSender =  EmailIMAPHelper3.getEmailSender(HelperBase.prop.getProperty("emailsVerifications.email"), HelperBase.prop.getProperty("emailsVerifications.pass"));
        String emailText =  EmailIMAPHelper3.getTextFromEmail("pop.gmail.com", HelperBase.prop.getProperty("emailsVerifications.email"), HelperBase.prop.getProperty("emailsVerifications.pass"));
        String emailBody = getEmailBodyText(emailText, 0, 126);
        String emailFooter = getEmailFooterText(emailText, 127);

        assertThat(emailSender, equalTo(emailFrom));
        assertThat(emailBody, equalTo("Witaj "+HelperBase.prop.getProperty("emailsVerifications.firstName")+", W załączniku znajduje się zamówione potwierdzenie przelewu bankowego. Z wyrazami szacunku, Zespół Obsługi Klienta"));
        assertThat(emailFooter, equalTo(""+SITE_REG+" "+site+" UAB, autoryzowana Instytucja Pieniądza Elektronicznego, podlegająca nadzorowi Banku Litwy (numer licencji 75) | Licencjonowana przez Mastercard do działania na Europejskim Obszarze Gospodarczego Upės g. 23, 08128 Vilnius, LT"));
    }

    @Test(priority = 4)
    public void testBankTransferDipocketRU() throws InterruptedException, MessagingException, IOException {
        postSendBankTransferEmail(4);

        String emailSender =  EmailIMAPHelper3.getEmailSender(HelperBase.prop.getProperty("emailsVerifications.email"), HelperBase.prop.getProperty("emailsVerifications.pass"));
        String emailText =  EmailIMAPHelper3.getTextFromEmail("pop.gmail.com", HelperBase.prop.getProperty("emailsVerifications.email"), HelperBase.prop.getProperty("emailsVerifications.pass"));
        String emailBody = getEmailBodyText(emailText, 28, 169);
        String emailFooter = getEmailFooterText(emailText, 170);

        assertThat(emailSender, equalTo(emailFrom));
        assertThat(emailBody, equalTo("Здравствуйте, "+HelperBase.prop.getProperty("emailsVerifications.firstName")+"! В приложении находится подтверждение банковского перевода, которое Вы заказывали. С уважением, Служба поддержки клиентов"));
        assertThat(emailFooter, equalTo(""+SITE_REG+" Для вашего спокойствия, "+site+" UAB авторизован и контролируется Банком Литвы как эмитент электронных денег (#75) Upės str. 23, 08128 Vilnius, LT"));
    }
}