package emailsVerification.bankTransfer;

import appmanager.EmailIMAPHelper3;
import base.TestBase;
import org.testng.annotations.Test;

import javax.mail.MessagingException;
import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class BankTransferDipocketTests extends TestBase {

    @Test(priority = 1)
    public void testBankTransferDipocketEN() throws InterruptedException, MessagingException, IOException {
        given()
                .header("Content-Type", "application/json")
                .body("{\n" +
                        "\"id\": 30457,\n" +
                        "\"clientFirstName\": \"Salat\",\n" +
                        "\"clientLastName\": \"Test\",\n" +
                        "\"countryId\": 826,\n" +
                        "\"langId\": 1,\n" +
                        "\"mainPhone\": \"380661470959\",\n" +
                        "\"email\": \"testdipocket@gmail.com\",\n" +
                        "\"currencyId\": 978,\n" +
                        "\"site\": \"DIPOCKET\",\n" +
                        "\"siteEnum\": \"DIPOCKET\",\n" +
                        "\"programNickName\": \"DIPOCKET\"\n" +
                        "}")
                .when()
                .post( app.dipocket3_intranet+"/EmailService/sendBankTransferEmail")
                .then().log().all()
                .statusCode(200);

        String emailText =  EmailIMAPHelper3.getTextFromEmail("pop.gmail.com", "testdipocket@gmail.com", "password1<");
        String emailSender =  EmailIMAPHelper3.getEmailSender("pop.gmail.com", "testdipocket@gmail.com", "password1<");

        System.out.println("email text:  " + emailText);
        System.out.println("email sender:  " + emailSender);

        String emailBody = app.getTelenorHelper().cutText(emailText, 50, 158);
        System.out.println("email body:  " + emailBody);

        String emailFooter = app.getTelenorHelper().cutText(emailText, 159);
        System.out.println("email footer:  " + emailFooter);

        assertThat(emailSender, equalTo("customer.service@dipocket.org"));
        assertThat(emailBody, equalTo("As requested, please find attached your bank transfer confirmation. With kind regards, Customer Service Team"));
        assertThat(emailFooter, equalTo("DiPocket® DiPocket UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT"));
    }

    @Test(priority = 2)
    public void testBankTransferDipocketUA() throws InterruptedException, MessagingException, IOException {
        given()
                .header("Content-Type", "application/json")
                .body("{\n" +
                        "\"id\": 30457,\n" +
                        "\"clientFirstName\": \"Salat\",\n" +
                        "\"clientLastName\": \"Test\",\n" +
                        "\"countryId\": 826,\n" +
                        "\"langId\": 2,\n" +
                        "\"mainPhone\": \"380661470959\",\n" +
                        "\"email\": \"testdipocket@gmail.com\",\n" +
                        "\"currencyId\": 978,\n" +
                        "\"site\": \"DIPOCKET\",\n" +
                        "\"siteEnum\": \"DIPOCKET\",\n" +
                        "\"programNickName\": \"DIPOCKET\"\n" +
                        "}")
                .when()
                .post( app.dipocket3_intranet+"/EmailService/sendBankTransferEmail")
                .then().log().all()
                .statusCode(200);

        String emailText =  EmailIMAPHelper3.getTextFromEmail("pop.gmail.com", "testdipocket@gmail.com", "password1<");
        String emailSender =  EmailIMAPHelper3.getEmailSender("pop.gmail.com", "testdipocket@gmail.com", "password1<");

        System.out.println("email text:  " + emailText);
        System.out.println("email sender:  " + emailSender);

        String emailBody = app.getTelenorHelper().cutText(emailText, 44, 154);
        System.out.println("email body:  " + emailBody);

        String emailFooter = app.getTelenorHelper().cutText(emailText, 155);
        System.out.println("email footer:  " + emailFooter);

        assertThat(emailSender, equalTo("customer.service@dipocket.org"));
        assertThat(emailBody, equalTo("В додатку знаходиться замовлене Вами підтвердження банківського переказу. З повагою, Відділ підтримки клієнтів"));
        assertThat(emailFooter, equalTo("DiPocket® Для Вашого спокою, DiPocket UAB авторизований та контролюється Банком Литви, як емітент електронних грошей (#75) Upės str. 23, 08128 Vilnius, LT"));
    }

    @Test(priority = 3, enabled = false)
    public void testBankTransferDipocketPL() throws InterruptedException, MessagingException, IOException {
        given()
                .header("Content-Type", "application/json")
                .body("{\n" +
                        "\"id\": 30457,\n" +
                        "\"clientFirstName\": \"Salat\",\n" +
                        "\"clientLastName\": \"Test\",\n" +
                        "\"countryId\": 826,\n" +
                        "\"langId\": 3,\n" +
                        "\"mainPhone\": \"380661470959\",\n" +
                        "\"email\": \"testdipocket@gmail.com\",\n" +
                        "\"currencyId\": 978,\n" +
                        "\"site\": \"DIPOCKET\",\n" +
                        "\"siteEnum\": \"DIPOCKET\",\n" +
                        "\"programNickName\": \"DIPOCKET\"\n" +
                        "}")
                .when()
                .post( app.dipocket3_intranet+"/EmailService/sendBankTransferEmail")
                .then().log().all()
                .statusCode(200);

        String emailText =  EmailIMAPHelper3.getTextFromEmail("pop.gmail.com", "testdipocket@gmail.com", "password1<");
        String emailSender =  EmailIMAPHelper3.getEmailSender("pop.gmail.com", "testdipocket@gmail.com", "password1<");

        System.out.println("email text:  " + emailText);
        System.out.println("email sender:  " + emailSender);

        //String emailBody = emailText.substring(13, 126);
        String emailBody = app.getTelenorHelper().cutText(emailText, 13, 126);
        System.out.println("email body:  " + emailBody);

        //String emailFooter = emailText.substring(127);
        String emailFooter = app.getTelenorHelper().cutText(emailText, 127);

        System.out.println("email footer:  " + emailFooter);

        assertThat(emailSender, equalTo("customer.service@dipocket.org"));
        assertThat(emailBody, equalTo("W załączniku znajduje się zamówione potwierdzenie przelewu bankowego. Z wyrazami szacunku, Zespół Obsługi Klienta"));
        assertThat(emailFooter, equalTo("DiPocket® DiPocket UAB, autoryzowana Instytucja Pieniądza Elektronicznego, podlegająca nadzorowi Banku Litwy (numer licencji 75) | Licencjonowana przez Masterсard do działania na Europejskim Obszarze Gospodarczego Upės g. 23, 08128 Vilnius, LT"));
    }
}
