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

public class BankTransferDiscontuTests extends TestBase {
    String site = "discontu";
    String firstName = "Pavel";
    String emailFrom = "customer.service@dipocket.org";
    String testEmail = "testdipocket@gmail.com";
    String pass = "password1<";
    String SITE_REG = "DiPocket®";

    public String body(int landId){
        return "{\n" +
                "\"id\": 32717,\n" +
                "\"clientFirstName\": \""+firstName+"\",\n" +
                "\"clientLastName\": \"Burinsky\",\n" +
                "\"countryId\": 826,\n" +
                "\"langId\": "+landId+",\n" +
                "\"mainPhone\": \"380685448615\",\n" +
                "\"email\": \""+testEmail+"\",\n" +
                "\"currencyId\": 978,\n" +
                "\"site\": \"DISCONTU\",\n" +
                "\"siteEnum\": \"DISCONTU\",\n" +
                "\"programNickName\": \"DISCONTU\"\n" +
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
    public void testBankTransferDiscontuEN() throws InterruptedException, MessagingException, IOException {
        postSendBankTransferEmail(1);

        String emailSender =  EmailIMAPHelper3.getEmailSender(testEmail, pass);
        String emailText =  EmailIMAPHelper3.getTextFromEmail("pop.gmail.com", testEmail, pass);
        String emailBody = getEmailBodyText(emailText, 38, 158);
        String emailFooter = getEmailFooterText(emailText, 159);

        assertThat(emailSender, equalTo(emailFrom));
        assertThat(emailBody, equalTo("Dear "+firstName+", As requested, please find attached your bank transfer confirmation. With kind regards, Customer Service Team"));
        assertThat(emailFooter, equalTo(""+SITE_REG+" "+site+" is powered by DiPocket UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT"));
    }

    @Test(priority = 2)
    public void testBankTransferDiscontuPL() throws InterruptedException, MessagingException, IOException {
        postSendBankTransferEmail(2);

        String emailSender =  EmailIMAPHelper3.getEmailSender(testEmail, pass);
        String emailText =  EmailIMAPHelper3.getTextFromEmail("pop.gmail.com", testEmail, pass);
        String emailBody = getEmailBodyText(emailText, 0, 126);
        String emailFooter = getEmailFooterText(emailText, 127);

        assertThat(emailSender, equalTo(emailFrom));
        assertThat(emailBody, equalTo("Witaj "+firstName+", W załączniku znajduje się zamówione potwierdzenie przelewu bankowego. Z wyrazami szacunku, Zespół Obsługi Klienta"));
        assertThat(emailFooter, equalTo(""+SITE_REG+" "+site+" dostarcza DiPocket UAB, autoryzowana Instytucja Pieniądza Elektronicznego, podlegająca nadzorowi Banku Litwy (numer licencji 75) | Licencjonowana przez Mastercard do działania na Europejskim Obszarze Gospodarczego Upės g. 23, 08128 Vilnius, LT"));
    }
}