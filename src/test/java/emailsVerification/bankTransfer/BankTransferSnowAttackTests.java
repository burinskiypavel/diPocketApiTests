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

public class BankTransferSnowAttackTests extends TestBase {
    String site = "SnowAttack";
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
                "\"site\": \"SNOW_ATTACK\",\n" +
                "\"siteEnum\": \"SNOW_ATTACK\",\n" +
                "\"programNickName\": \"SNOW_ATTACK\"\n" +
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

    @Test(priority = 1, enabled = false) // нету ® после дикокет в футере
    public void testBankTransferSnowAttackEN() throws InterruptedException, MessagingException, IOException {
        postSendBankTransferEmail(1);

        String emailSender =  EmailIMAPHelper3.getEmailSender(testEmail, pass);
        String emailText =  EmailIMAPHelper3.getTextFromEmail("pop.gmail.com", testEmail, pass);
        String emailBody = getEmailBodyText(emailText, 40, 160);
        String emailFooter = getEmailFooterText(emailText, 161);

        assertThat(emailSender, equalTo(emailFrom));
        assertThat(emailBody, equalTo("Dear "+firstName+", As requested, please find attached your bank transfer confirmation. With kind regards, Customer Service Team"));
        assertThat(emailFooter, equalTo("DiPocket® "+site+" is powered by DiPocket UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT"));
    }

    @Test(priority = 2, enabled = false) //нету докуметации на венгерском футер и боди
    public void testBankTransferSnowAttackHU() throws InterruptedException, MessagingException, IOException {
        postSendBankTransferEmail(5);

        String emailSender =  EmailIMAPHelper3.getEmailSender(testEmail, pass);
        String emailText =  EmailIMAPHelper3.getTextFromEmail("pop.gmail.com", testEmail, pass);
        String emailBody = getEmailBodyText(emailText, 40, 168);
        String emailFooter = getEmailFooterText(emailText, 169);

        assertThat(emailSender, equalTo(emailFrom));
        assertThat(emailBody, equalTo("Kedves "+firstName+", Kívánsága szerint, csatolva találja az Ön banki átutalásának megerősítése. Üdvözlettel, az Ügyfélszolgálati csapat"));
        assertThat(emailFooter, equalTo("DiPocket® "+site+" is powered by DiPocket UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT"));
    }
}