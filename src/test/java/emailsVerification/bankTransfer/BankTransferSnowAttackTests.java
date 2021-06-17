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
    String site = "Snow Attack";
    String expectedEmailSender = "customer.service@dipocket.org";

    public String body(int landId){
        return "{\n" +
                "\"id\": 32717,\n" +
                "\"clientFirstName\": \""+app.emailsVerificationsFirstName+"\",\n" +
                "\"clientLastName\": \""+app.emailsVerificationsLastName+"\",\n" +
                "\"countryId\": "+app.emailsVerificationsCountryId+",\n" +
                "\"langId\": "+landId+",\n" +
                "\"mainPhone\": \""+app.emailsVerificationsPhoneNumber+"\",\n" +
                "\"email\": \""+app.emailsVerificationsEmail+"\",\n" +
                "\"currencyId\": "+app.emailsVerificationsCurrencyId+",\n" +
                "\"site\": \""+app.mobile_site_snowAttack+"\",\n" +
                "\"siteEnum\": \""+app.mobile_site_snowAttack+"\",\n" +
                "\"programNickName\": \""+app.mobile_site_snowAttack+"\"\n" +
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

    @Test(priority = 1, enabled = false) // bub incorrect word SnowAttack
    public void testBankTransferSnowAttackEN() throws InterruptedException, MessagingException, IOException {
        postSendBankTransferEmail(1);

        String emailSender =  EmailIMAPHelper3.getEmailSender(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailText =  EmailIMAPHelper3.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailBody = getEmailBodyText(emailText, 40, 160);
        String emailFooter = getEmailFooterText(emailText, 161);

        assertThat(emailSender, equalTo(expectedEmailSender));
        assertThat(emailBody, equalTo("Dear "+app.emailsVerificationsFirstName+", As requested, please find attached your bank transfer confirmation. With kind regards, Customer Service Team"));
        assertThat(emailFooter, equalTo(""+app.SITE_REG+" "+site+" is powered by DiPocket UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT"));
    }

    @Test(priority = 2, enabled = false) //нету докуметации на венгерском футер и боди
    public void testBankTransferSnowAttackHU() throws InterruptedException, MessagingException, IOException {
        postSendBankTransferEmail(5);

        String emailSender =  EmailIMAPHelper3.getEmailSender(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailText =  EmailIMAPHelper3.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailBody = getEmailBodyText(emailText, 40, 168);
        String emailFooter = getEmailFooterText(emailText, 169);

        assertThat(emailSender, equalTo(expectedEmailSender));
        assertThat(emailBody, equalTo("Kedves "+app.emailsVerificationsFirstName+", Kívánsága szerint, csatolva találja az Ön banki átutalásának megerősítése. Üdvözlettel, az Ügyfélszolgálati csapat"));
        assertThat(emailFooter, equalTo(""+app.SITE_REG+" "+site+" is powered by DiPocket UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT"));
    }
}