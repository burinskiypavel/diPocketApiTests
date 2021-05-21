package emailsVerification.legalEmail;

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

public class LegalEmailTests extends TestBase {
    String site = "DiPocket";
    String firstName = "Salat";
    String emailFrom = "legal.team@dipocket.org";
    String testEmail = "testdipocket@gmail.com";
    String pass = "password1<";
    String SITE_REG = "DiPocket®";
    String newPhone = "12345678";

    public String body(int landId, final String site){
        return "{\n" +
                "\"id\": 30457,\n" +
                "\"clientFirstName\": \"" + firstName + "\",\n" +
                "\"clientLastName\": \"Test\",\n" +
                "\"countryId\": 826,\n" +
                "\"langId\": " + landId + ",\n" +
                "\"mainPhone\": \"380661470959\",\n" +
                "\"email\": \"" + testEmail + "\",\n" +
                "\"currencyId\": 978,\n" +
                "\"site\": \"" + site + "\",\n" +
                "\"siteEnum\": \"" + site + "\",\n" +
                "\"programNickName\": \"" + site + "\"\n" +
                "}";
    }

    public void postSendLegalEmail(int landId, String site) {
        given()
                .header("Content-Type", "application/json")
                .body(body(landId, site))
                .when()
                .post( app.dipocket3_intranet+"/EmailService/sendLegalEmail")
                .then().log().all()
                .statusCode(200);
    }

    @Test(priority = 1, enabled = false)
    public void testLegalEmailDipocketEN() throws InterruptedException, MessagingException, IOException {
        postSendLegalEmail(1, "DIPOCKET");

        String emailSender =  EmailIMAPHelper3.getEmailSender(testEmail, pass);
        String emailText =  EmailIMAPHelper3.getTextFromEmail("pop.gmail.com", testEmail, pass);
        String emailBody = getEmailBodyText(emailText, 41, 380);
        String emailFooter = getEmailFooterText(emailText, 381);

        assertThat(emailSender, equalTo(emailFrom));
        assertThat(emailBody, equalTo("Dear "+firstName+", The mobile phone number associated with your "+site+" account was changed to: 12345678. If you didn't change it, please click on this link , to block your account and protect your money. You can then contact us at your earliest convenience so that we can safely reactivate your account. With kind regards, Customer Service Team"));
        assertThat(emailFooter, equalTo(""+SITE_REG+" "+site+" UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT"));
    }

    @Test(priority = 2)
    public void testLegalEmailDipocketUA() throws InterruptedException, MessagingException, IOException {
        postSendLegalEmail(2, "DIPOCKET");

        String emailSender =  EmailIMAPHelper3.getEmailSender(testEmail, pass);
        String emailText =  EmailIMAPHelper3.getTextFromEmail("pop.gmail.com", testEmail, pass);
        String emailBody = getEmailBodyText(emailText, 28, 172);
        String emailFooter = getEmailFooterText(emailText, 173);

        assertThat(emailSender, equalTo(emailFrom));
        assertThat(emailBody, equalTo("Вітаємо, "+firstName+"! В додатку знаходяться юридичні документи, що Ви запитали. Дякуємо за користування додатком "+site+". З повагою, Юридичний відділ"));
        assertThat(emailFooter, equalTo(""+SITE_REG+" Для Вашого спокою, "+site+" UAB авторизований та контролюється Банком Литви, як емітент електронних грошей (#75) Upės str. 23, 08128 Vilnius, LT"));
    }

    @Test(priority = 3, enabled = false)
    public void testLegalEmailDipocketPL() throws InterruptedException, MessagingException, IOException {
        postSendLegalEmail(3, "DIPOCKET");

        String emailSender =  EmailIMAPHelper3.getEmailSender(testEmail, pass);
        String emailText =  EmailIMAPHelper3.getTextFromEmail("pop.gmail.com", testEmail, pass);
        String emailBody = getEmailBodyText(emailText, 0, 336);
        String emailFooter = getEmailFooterText(emailText, 337);

        assertThat(emailSender, equalTo(emailFrom));
        assertThat(emailBody, equalTo("Witaj, "+firstName+"! Numer telefonu powiązany z Twoim kontem "+site+" został zmieniony na: "+newPhone+". Jeśli nie zmieniałeś numeru telefonu, kliknij w ten link aby zablokować konto i zabezpieczyć Twoje środki. Następnie skontaktuj się z nami w wybranym momencie, aby bezpiecznie odblokować Twoje konto. Z wyrazami szacunku, Dział Obsługi Klienta"));
        assertThat(emailFooter, equalTo(""+SITE_REG+" "+site+" UAB, autoryzowana Instytucja Pieniądza Elektronicznego, podlegająca nadzorowi Banku Litwy (numer licencji 75) | Licencjonowana przez Mastercard do działania na Europejskim Obszarze Gospodarczego Upės g. 23, 08128 Vilnius, LT"));
    }

    @Test(priority = 4)
    public void testLegalEmailDipocketRU() throws InterruptedException, MessagingException, IOException {
        postSendLegalEmail(4, "DIPOCKET");

        String emailSender =  EmailIMAPHelper3.getEmailSender(testEmail, pass);
        String emailText =  EmailIMAPHelper3.getTextFromEmail("pop.gmail.com", testEmail, pass);
        String emailBody = getEmailBodyText(emailText, 28, 181);
        String emailFooter = getEmailFooterText(emailText, 182);

        assertThat(emailSender, equalTo(emailFrom));
        assertThat(emailBody, equalTo("Здравствуйте, "+firstName+"! В приложении находятся юридические документы, которые Вы заказывали. Спасибо за пользование "+site+". С уважением, Юридический отдел"));
        assertThat(emailFooter, equalTo(""+SITE_REG+" Для вашего спокойствия, "+site+" UAB авторизован и контролируется Банком Литвы как эмитент электронных денег (#75) Upės str. 23, 08128 Vilnius, LT"));
    }

    @Test(priority = 5, enabled = false)
    public void testLegalEmailDiscontuEN() throws InterruptedException, MessagingException, IOException {
        postSendLegalEmail(1, "DISCONTU");

        String emailSender =  EmailIMAPHelper3.getEmailSender(testEmail, pass);
        String emailText =  EmailIMAPHelper3.getTextFromEmail("pop.gmail.com", testEmail, pass);
        String emailBody = getEmailBodyText(emailText, 41, 380);
        String emailFooter = getEmailFooterText(emailText, 381);

        assertThat(emailSender, equalTo(emailFrom));
        assertThat(emailBody, equalTo("Dear "+firstName+", The mobile phone number associated with your discontu account was changed to: 12345678. If you didn't change it, please click on this link , to block your account and protect your money. You can then contact us at your earliest convenience so that we can safely reactivate your account. With kind regards, Customer Service Team"));
        assertThat(emailFooter, equalTo(""+SITE_REG+" discontu is powered by DiPocket UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT"));
    }

    @Test(priority = 6, enabled = false)
    public void testLegalEmailDiscontuPL() throws InterruptedException, MessagingException, IOException {
        postSendLegalEmail(3, "DISCONTU");

        String emailSender =  EmailIMAPHelper3.getEmailSender(testEmail, pass);
        String emailText =  EmailIMAPHelper3.getTextFromEmail("pop.gmail.com", testEmail, pass);
        String emailBody = getEmailBodyText(emailText, 0, 336);
        String emailFooter = getEmailFooterText(emailText, 337);

        assertThat(emailSender, equalTo(emailFrom));
        assertThat(emailBody, equalTo("Witaj, "+firstName+"! Numer telefonu powiązany z Twoim kontem discontu został zmieniony na: "+newPhone+". Jeśli nie zmieniałeś numeru telefonu, kliknij w ten link aby zablokować konto i zabezpieczyć Twoje środki. Następnie skontaktuj się z nami w wybranym momencie, aby bezpiecznie odblokować Twoje konto. Z wyrazami szacunku, Dział Obsługi Klienta"));
        assertThat(emailFooter, equalTo(""+SITE_REG+" discontu dostarcza DiPocket UAB, autoryzowana Instytucja Pieniądza Elektronicznego, podlegająca nadzorowi Banku Litwy (numer licencji 75) | Licencjonowana przez Mastercard do działania na Europejskim Obszarze Gospodarczego Upės g. 23, 08128 Vilnius, LT"));
    }

    @Test(priority = 7, enabled = false)
    public void testLegalEmailPlayITEN() throws InterruptedException, MessagingException, IOException {
        postSendLegalEmail(1, "PLAYIT");

        String emailSender =  EmailIMAPHelper3.getEmailSender(testEmail, pass);
        String emailText =  EmailIMAPHelper3.getTextFromEmail("pop.gmail.com", testEmail, pass);
        String emailBody = getEmailBodyText(emailText, 39, 377);
        String emailFooter = getEmailFooterText(emailText, 378);

        assertThat(emailSender, equalTo("PlayIT Card <customer.service@dipocket.org>"));
        assertThat(emailBody, equalTo("Dear "+firstName+", The mobile phone number associated with your PlayIT account was changed to: 12345678. If you didn't change it, please  click on this link , to block your account and protect your money. You can then contact us at your earliest convenience so that we can safely reactivate your account. With kind regards, Customer Service Team"));
        assertThat(emailFooter, equalTo(""+SITE_REG+" PlayIT is powered by DiPocket UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT"));
    }
}