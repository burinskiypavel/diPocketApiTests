package emailsVerification.changePhone;

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

public class ChangePhoneTests extends TestBase {
    String site = "DiPocket";
    String firstName = "Pavel";
    String emailFrom = "customer.service@dipocket.org";
    String testEmail = "testdipocket@gmail.com";
    String pass = "password1<";
    String SITE_REG = "DiPocket®";
    String newPhone = "12345678";

    public String body(int landId, final String site){
        return "{\n" +
                "\"id\": 30457,\n" +
                "\"clientFirstName\": \"" + firstName + "\",\n" +
                "\"clientLastName\": \"Burinsky\",\n" +
                "\"countryId\": 826,\n" +
                "\"langId\": " + landId + ",\n" +
                "\"mainPhone\": \"380685448615\",\n" +
                "\"email\": \"" + testEmail + "\",\n" +
                "\"currencyId\": 978,\n" +
                "\"site\": \"" + site + "\",\n" +
                "\"siteEnum\": \"" + site + "\",\n" +
                "\"programNickName\": \"" + site + "\"\n" +
                "}";
    }

    public void postSendChangePhoneMailRealFlow(int landId, String site) {
        given()
                .header("Content-Type", "application/json")
                .body(body(landId, site))
                .when()
                .post( app.dipocket3_intranet+"/EmailService/sendChangePhoneMailRealFlow?newPhoneNumber="+newPhone+"")
                .then().log().all()
                .statusCode(200);
    }

    @Test(priority = 1)
    public void testChangePhoneDipocketEN() throws InterruptedException, MessagingException, IOException {
        postSendChangePhoneMailRealFlow(1, "DIPOCKET");

        String emailSender =  EmailIMAPHelper3.getEmailSender(testEmail, pass);
        String emailText =  EmailIMAPHelper3.getTextFromEmail("pop.gmail.com", testEmail, pass);
        String emailBody = getEmailBodyText(emailText, 41, 380);
        String emailFooter = getEmailFooterText(emailText, 381);

        assertThat(emailSender, equalTo(emailFrom));
        assertThat(emailBody, equalTo("Dear "+firstName+", The mobile phone number associated with your "+site+" account was changed to: 12345678. If you didn't change it, please click on this link , to block your account and protect your money. You can then contact us at your earliest convenience so that we can safely reactivate your account. With kind regards, Customer Service Team"));
        assertThat(emailFooter, equalTo(""+SITE_REG+" "+site+" UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT"));
    }

    @Test(priority = 2)
    public void testChangePhoneDipocketUA() throws InterruptedException, MessagingException, IOException {
        postSendChangePhoneMailRealFlow(2, "DIPOCKET");

        String emailSender =  EmailIMAPHelper3.getEmailSender(testEmail, pass);
        String emailText =  EmailIMAPHelper3.getTextFromEmail("pop.gmail.com", testEmail, pass);
        String emailBody = getEmailBodyText(emailText, 28, 358);
        String emailFooter = getEmailFooterText(emailText, 359);

        assertThat(emailSender, equalTo(emailFrom));
        assertThat(emailBody, equalTo("Вітаємо, "+firstName+"! Номер телефону, приєднаний до вашого облікового запису "+site+", було змінено на "+newPhone+". Якщо Ви цього не робили, будь ласка, натисніть на це посилання , щоб заблокувати обліковий запис та захистити свої кошти. Після цього Ви можете зв'язатися з нами для відновлення доступу. З повагою, Відділ підтримки клієнтів"));
        assertThat(emailFooter, equalTo(""+SITE_REG+" Для Вашого спокою, "+site+" UAB авторизований та контролюється Банком Литви, як емітент електронних грошей (#75) Upės str. 23, 08128 Vilnius, LT"));
    }

    @Test(priority = 3)
    public void testChangePhoneDipocketPL() throws InterruptedException, MessagingException, IOException {
        postSendChangePhoneMailRealFlow(3, "DIPOCKET");

        String emailSender =  EmailIMAPHelper3.getEmailSender(testEmail, pass);
        String emailText =  EmailIMAPHelper3.getTextFromEmail("pop.gmail.com", testEmail, pass);
        String emailBody = getEmailBodyText(emailText, 0, 336);
        String emailFooter = getEmailFooterText(emailText, 337);

        assertThat(emailSender, equalTo(emailFrom));
        assertThat(emailBody, equalTo("Witaj, "+firstName+"! Numer telefonu powiązany z Twoim kontem "+site+" został zmieniony na: "+newPhone+". Jeśli nie zmieniałeś numeru telefonu, kliknij w ten link aby zablokować konto i zabezpieczyć Twoje środki. Następnie skontaktuj się z nami w wybranym momencie, aby bezpiecznie odblokować Twoje konto. Z wyrazami szacunku, Dział Obsługi Klienta"));
        assertThat(emailFooter, equalTo(""+SITE_REG+" "+site+" UAB, autoryzowana Instytucja Pieniądza Elektronicznego, podlegająca nadzorowi Banku Litwy (numer licencji 75) | Licencjonowana przez Mastercard do działania na Europejskim Obszarze Gospodarczego Upės g. 23, 08128 Vilnius, LT"));
    }

    @Test(priority = 4)
    public void testChangePhoneDipocketRU() throws InterruptedException, MessagingException, IOException {
        postSendChangePhoneMailRealFlow(4, "DIPOCKET");

        String emailSender =  EmailIMAPHelper3.getEmailSender(testEmail, pass);
        String emailText =  EmailIMAPHelper3.getTextFromEmail("pop.gmail.com", testEmail, pass);
        String emailBody = getEmailBodyText(emailText, 28, 361);
        String emailFooter = getEmailFooterText(emailText, 362);

        assertThat(emailSender, equalTo(emailFrom));
        assertThat(emailBody, equalTo("Здравствуйте, "+firstName+"! Номер телефона, указанный для Вашей учетной записи был изменен. Новое значение: "+newPhone+". Если Вы этого не делали, перейдите по этой ссылке , чтобы заблокировать вашу учетную запись и защитить свои средства. После этого Вы можете связаться с нами для возобновления доступа. С уважением, Служба поддержки клиентов"));
        assertThat(emailFooter, equalTo(""+SITE_REG+" Для вашего спокойствия, "+site+" UAB авторизован и контролируется Банком Литвы как эмитент электронных денег (#75) Upės str. 23, 08128 Vilnius, LT"));
    }

    @Test(priority = 5)
    public void testChangePhoneDiscontuEN() throws InterruptedException, MessagingException, IOException {
        postSendChangePhoneMailRealFlow(1, "DISCONTU");

        String emailSender =  EmailIMAPHelper3.getEmailSender(testEmail, pass);
        String emailText =  EmailIMAPHelper3.getTextFromEmail("pop.gmail.com", testEmail, pass);
        String emailBody = getEmailBodyText(emailText, 41, 380);
        String emailFooter = getEmailFooterText(emailText, 381);

        assertThat(emailSender, equalTo(emailFrom));
        assertThat(emailBody, equalTo("Dear "+firstName+", The mobile phone number associated with your discontu account was changed to: 12345678. If you didn't change it, please click on this link , to block your account and protect your money. You can then contact us at your earliest convenience so that we can safely reactivate your account. With kind regards, Customer Service Team"));
        assertThat(emailFooter, equalTo(""+SITE_REG+" discontu is powered by DiPocket UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT"));
    }

    @Test(priority = 6)
    public void testChangePhoneDiscontuPL() throws InterruptedException, MessagingException, IOException {
        postSendChangePhoneMailRealFlow(3, "DISCONTU");

        String emailSender =  EmailIMAPHelper3.getEmailSender(testEmail, pass);
        String emailText =  EmailIMAPHelper3.getTextFromEmail("pop.gmail.com", testEmail, pass);
        String emailBody = getEmailBodyText(emailText, 0, 336);
        String emailFooter = getEmailFooterText(emailText, 337);

        assertThat(emailSender, equalTo(emailFrom));
        assertThat(emailBody, equalTo("Witaj, "+firstName+"! Numer telefonu powiązany z Twoim kontem discontu został zmieniony na: "+newPhone+". Jeśli nie zmieniałeś numeru telefonu, kliknij w ten link aby zablokować konto i zabezpieczyć Twoje środki. Następnie skontaktuj się z nami w wybranym momencie, aby bezpiecznie odblokować Twoje konto. Z wyrazami szacunku, Dział Obsługi Klienta"));
        assertThat(emailFooter, equalTo(""+SITE_REG+" discontu dostarcza DiPocket UAB, autoryzowana Instytucja Pieniądza Elektronicznego, podlegająca nadzorowi Banku Litwy (numer licencji 75) | Licencjonowana przez Mastercard do działania na Europejskim Obszarze Gospodarczego Upės g. 23, 08128 Vilnius, LT"));
    }

    @Test(priority = 7)
    public void testChangePhonePlayITEN() throws InterruptedException, MessagingException, IOException {
        postSendChangePhoneMailRealFlow(1, "PLAYIT");

        String emailSender =  EmailIMAPHelper3.getEmailSender(testEmail, pass);
        String emailText =  EmailIMAPHelper3.getTextFromEmail("pop.gmail.com", testEmail, pass);
        String emailBody = getEmailBodyText(emailText, 39, 377);
        String emailFooter = getEmailFooterText(emailText, 378);

        assertThat(emailSender, equalTo("PlayIT Card <customer.service@dipocket.org>"));
        assertThat(emailBody, equalTo("Dear "+firstName+", The mobile phone number associated with your PlayIT account was changed to: 12345678. If you didn't change it, please  click on this link , to block your account and protect your money. You can then contact us at your earliest convenience so that we can safely reactivate your account. With kind regards, Customer Service Team"));
        assertThat(emailFooter, equalTo(""+SITE_REG+" PlayIT is powered by DiPocket UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT"));
    }
}