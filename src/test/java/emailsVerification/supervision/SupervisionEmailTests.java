package emailsVerification.supervision;

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

public class SupervisionEmailTests extends TestBase {
    String site = "DiPocket";
    String emailFrom = "legal.team@dipocket.org";

    public String body(int landId, String site, int id){
        return "{\n" +
                "\"id\": " + id + ",\n" +
                "\"clientFirstName\": \"" + app.emailsVerificationsFirstName + "\",\n" +
                "\"clientLastName\": \""+app.emailsVerificationsLastName+"\",\n" +
                "\"countryId\": "+app.emailsVerificationsCountryId+",\n" +
                "\"langId\": " + landId + ",\n" +
                "\"mainPhone\": \""+app.emailsVerificationsPhoneNumber+"\",\n" +
                "\"email\": \"" + app.emailsVerificationsEmail + "\",\n" +
                "\"currencyId\": "+app.emailsVerificationsCurrencyId+",\n" +
                "\"site\": \"" + site + "\",\n" +
                "\"siteEnum\": \"" + site + "\",\n" +
                "\"programNickName\": \"" + site + "\"\n" +
                "}";
    }

    public void postSupervisionEmail(int landId, String site, int id) {
        given()
                .header("Content-Type", "application/json")
                .body(body(landId, site, id))
                .when()
                .post( app.dipocket3_intranet+"/EmailService/sendSupervisionEmail")
                .then().log().all()
                .statusCode(200);
    }

    @Test(priority = 1)
    public void testSupervisionEmailDipocketEN() throws InterruptedException, MessagingException, IOException {
        postSupervisionEmail(1, "DIPOCKET", 32761);

        String emailSender =  EmailIMAPHelper3.getEmailSender(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailText =  EmailIMAPHelper3.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailBody = getEmailBodyText(emailText, 0, 398);
        String emailFooter = getEmailFooterText(emailText, 399);

        assertThat(emailSender, equalTo(emailFrom));
        assertThat(emailBody, equalTo("Dear "+app.emailsVerificationsFirstName+", Please find attached the section of "+site+" Terms and Conditions (the “T&Cs”) regulating Supervised accounts. It is the same that you have already agreed to as part of the T&Cs, but we want to draw your attention on it now that you will start using a Supervised account since it contains important provisions on the Supervisor’s role and responsibilities. With kind regards, Legal Team"));
        assertThat(emailFooter, equalTo(""+app.SITE_REG+" "+site+" UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT"));
    }

    @Test(priority = 2)
    public void testSupervisionEmailDipocketUA() throws InterruptedException, MessagingException, IOException {
        postSupervisionEmail(2, "DIPOCKET", 32761);

        String emailSender =  EmailIMAPHelper3.getEmailSender(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailText =  EmailIMAPHelper3.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailBody = getEmailBodyText(emailText, 28, 486);
        String emailFooter = getEmailFooterText(emailText, 487);

        assertThat(emailSender, equalTo(emailFrom));
        assertThat(emailBody, equalTo("Вітаємо, "+app.emailsVerificationsFirstName+"! В додатку знаходиться розділ \"Умови та Правила користування додатком DiPocket\" (\"Правила користування\"), який стосується Опіки за рахунком. Ви прийняли їх разом з іншою частиною Правил користування, але зараз ми хочемо ще раз звернути на них Вашу увагу, адже Ви розпочинаєте користуватися Опікунськими рахунками, а в цьому розділі знаходиться більш детальна інформація про роль та відповідальність Опікуна рахунку. З повагою, Юридичний відділ"));
        assertThat(emailFooter, equalTo(""+app.SITE_REG+" Для Вашого спокою, "+site+" UAB авторизований та контролюється Банком Литви, як емітент електронних грошей (#75) Upės str. 23, 08128 Vilnius, LT"));
    }

    @Test(priority = 3)
    public void testSupervisionEmailDipocketPL() throws InterruptedException, MessagingException, IOException {
        postSupervisionEmail(3, "DIPOCKET", 32761);

        String emailSender =  EmailIMAPHelper3.getEmailSender(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailText =  EmailIMAPHelper3.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailBody = getEmailBodyText(emailText, 0, 436);
        String emailFooter = getEmailFooterText(emailText, 437);

        assertThat(emailSender, equalTo(emailFrom));
        assertThat(emailBody, equalTo("Witaj "+app.emailsVerificationsFirstName+", W załączeniu znajduje się sekcja Warunków i Zasad korzystania (\"Warunki korzystania\"), dotycząca Kont Nadzorowanych. Zaakceptowałeś ją wraz z pozostałą częścią Warunków korzystania, jednak chcemy raz jeszcze zwrócić na nią Twoją uwagę teraz, gdy rozpoczynasz korzystanie z Konta Nadzorowanego, a w tej sekcji znajdziesz szczegółowe zapisy dotyczące roli i odpowiedzialności Opiekuna Konta. Z wyrazami szacunku, Dział Prawny"));
        assertThat(emailFooter, equalTo(""+app.SITE_REG+" "+site+" UAB, autoryzowana Instytucja Pieniądza Elektronicznego, podlegająca nadzorowi Banku Litwy (numer licencji 75) | Licencjonowana przez Mastercard do działania na Europejskim Obszarze Gospodarczego Upės g. 23, 08128 Vilnius, LT"));
    }

    @Test(priority = 4)
    public void testSupervisionEmailDipocketRU() throws InterruptedException, MessagingException, IOException {
        postSupervisionEmail(4, "DIPOCKET", 32761);

        String emailSender =  EmailIMAPHelper3.getEmailSender(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailText =  EmailIMAPHelper3.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailBody = getEmailBodyText(emailText, 28, 295);
        String emailFooter = getEmailFooterText(emailText, 296);

        assertThat(emailSender, equalTo(emailFrom));
        assertThat(emailBody, equalTo("Здравствуйте, "+app.emailsVerificationsFirstName+"! В приложении находится раздел \"Условий пользования приложением DiPocket\" об опеке. Вы уже приняли эти условия в момент регистрации, но мы хотим напомнить Вам детали перед началом использования этой функциональности. С уважением, Юридический отдел"));
        assertThat(emailFooter, equalTo(""+app.SITE_REG+" Для вашего спокойствия, "+site+" UAB авторизован и контролируется Банком Литвы как эмитент электронных денег (#75) Upės str. 23, 08128 Vilnius, LT"));
    }

    @Test(priority = 5)
    public void testSupervisionEmailDiscontuEN() throws InterruptedException, MessagingException, IOException {
        postSupervisionEmail(1, "DISCONTU", 32717);

        String emailSender =  EmailIMAPHelper3.getEmailSender(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailText =  EmailIMAPHelper3.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailBody = getEmailBodyText(emailText, 0, 398);
        String emailFooter = getEmailFooterText(emailText, 399);

        assertThat(emailSender, equalTo(emailFrom));
        assertThat(emailBody, equalTo("Dear "+app.emailsVerificationsFirstName+", Please find attached the section of discontu Terms and Conditions (the “T&Cs”) regulating Supervised accounts. It is the same that you have already agreed to as part of the T&Cs, but we want to draw your attention on it now that you will start using a Supervised account since it contains important provisions on the Supervisor’s role and responsibilities. With kind regards, Legal Team"));
        assertThat(emailFooter, equalTo(""+app.SITE_REG+" discontu is powered by DiPocket UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT"));
    }

    @Test(priority = 6)
    public void testSupervisionEmailDiscontuPL() throws InterruptedException, MessagingException, IOException {
        postSupervisionEmail(3, "DISCONTU", 32717);

        String emailSender =  EmailIMAPHelper3.getEmailSender(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailText =  EmailIMAPHelper3.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailBody = getEmailBodyText(emailText, 0, 436);
        String emailFooter = getEmailFooterText(emailText, 437);

        assertThat(emailSender, equalTo(emailFrom));
        assertThat(emailBody, equalTo("Witaj "+app.emailsVerificationsFirstName+", W załączeniu znajduje się sekcja Warunków i Zasad korzystania (\"Warunki korzystania\"), dotycząca Kont Nadzorowanych. Zaakceptowałeś ją wraz z pozostałą częścią Warunków korzystania, jednak chcemy raz jeszcze zwrócić na nią Twoją uwagę teraz, gdy rozpoczynasz korzystanie z Konta Nadzorowanego, a w tej sekcji znajdziesz szczegółowe zapisy dotyczące roli i odpowiedzialności Opiekuna Konta. Z wyrazami szacunku, Dział Prawny"));
        assertThat(emailFooter, equalTo(""+app.SITE_REG+" discontu dostarcza DiPocket UAB, autoryzowana Instytucja Pieniądza Elektronicznego, podlegająca nadzorowi Banku Litwy (numer licencji 75) | Licencjonowana przez Mastercard do działania na Europejskim Obszarze Gospodarczego Upės g. 23, 08128 Vilnius, LT"));
    }

    @Test(priority = 7)
    public void testSupervisionEmailPlayITEN() throws InterruptedException, MessagingException, IOException {
        postSupervisionEmail(1, "PLAYIT", 32732);

        String emailSender =  EmailIMAPHelper3.getEmailSender(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailText =  EmailIMAPHelper3.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailBody = getEmailBodyText(emailText, 0, 396);
        String emailFooter = getEmailFooterText(emailText, 397);

        assertThat(emailSender, equalTo("PlayIT Card <playitcard@dipocket.org>"));
        assertThat(emailBody, equalTo("Dear "+app.emailsVerificationsFirstName+", Please find attached the section of PlayIT Terms and Conditions (the “T&Cs”) regulating Supervised accounts. It is the same that you have already agreed to as part of the T&Cs, but we want to draw your attention on it now that you will start using a Supervised account since it contains important provisions on the Supervisor’s role and responsibilities. With kind regards, Legal Team"));
        assertThat(emailFooter, equalTo(""+app.SITE_REG+" PlayIT is powered by DiPocket UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT"));
    }

    @Test(priority = 8)
    public void testSupervisionEmailUpAndGoEN() throws InterruptedException, MessagingException, IOException {
        postSupervisionEmail(1, app.mobile_site_upAndGo, 32727);

        String emailSender =  EmailIMAPHelper3.getEmailSender(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailText =  EmailIMAPHelper3.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailBody = getEmailBodyText(emailText, 0, 399);
        String emailFooter = getEmailFooterText(emailText, 400);

        assertThat(emailSender, equalTo("regulacje@upcard.pl"));
        assertThat(emailBody, equalTo("Dear "+app.emailsVerificationsFirstName+", Please find attached the section of up and go Terms and Conditions (the “T&Cs”) regulating Supervised accounts. It is the same that you have already agreed to as part of the T&Cs, but we want to draw your attention on it now that you will start using a Supervised account since it contains important provisions on the Supervisor’s role and responsibilities. With kind regards, Legal Team"));
        assertThat(emailFooter, equalTo(""+app.SITE_REG+" up and go is powered by DiPocket UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT"));
    }

    @Test(priority = 9)
    public void testSupervisionEmailUpAndGoUA() throws InterruptedException, MessagingException, IOException {
        postSupervisionEmail(2, app.mobile_site_upAndGo, 32727);

        String emailSender =  EmailIMAPHelper3.getEmailSender(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailText =  EmailIMAPHelper3.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailBody = getEmailBodyText(emailText, 29, 488);
        String emailFooter = getEmailFooterText(emailText, 489);

        assertThat(emailSender, equalTo("regulacje@upcard.pl"));
        assertThat(emailBody, equalTo("Вітаємо, "+app.emailsVerificationsFirstName+"! В додатку знаходиться розділ \"Умови та Правила користування додатком up and go\" (\"Правила користування\"), який стосується Опіки за рахунком. Ви прийняли їх разом з іншою частиною Правил користування, але зараз ми хочемо ще раз звернути на них Вашу увагу, адже Ви розпочинаєте користуватися Опікунськими рахунками, а в цьому розділі знаходиться більш детальна інформація про роль та відповідальність Опікуна рахунку. З повагою, Юридичний відділ"));
        assertThat(emailFooter, equalTo(""+app.SITE_REG+" Для Вашого спокою, up and go працює при підтримці DiPocket UAB, що авторизований та контролюється Банком Литви, як емітент електронних грошей (#75) Upės str. 23, 08128 Vilnius, LT"));
    }

    @Test(priority = 10)
    public void testSupervisionEmailUpAndGoPL() throws InterruptedException, MessagingException, IOException {
        postSupervisionEmail(3, app.mobile_site_upAndGo, 32727);

        String emailSender =  EmailIMAPHelper3.getEmailSender(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailText =  EmailIMAPHelper3.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailBody = getEmailBodyText(emailText, 0, 436);
        String emailFooter = getEmailFooterText(emailText, 437);

        assertThat(emailSender, equalTo("regulacje@upcard.pl"));
        assertThat(emailBody, equalTo("Witaj "+app.emailsVerificationsFirstName+", W załączeniu znajduje się sekcja Warunków i Zasad korzystania (\"Warunki korzystania\"), dotycząca Kont Nadzorowanych. Zaakceptowałeś ją wraz z pozostałą częścią Warunków korzystania, jednak chcemy raz jeszcze zwrócić na nią Twoją uwagę teraz, gdy rozpoczynasz korzystanie z Konta Nadzorowanego, a w tej sekcji znajdziesz szczegółowe zapisy dotyczące roli i odpowiedzialności Opiekuna Konta. Z wyrazami szacunku, Dział Prawny"));
        assertThat(emailFooter, equalTo(""+app.SITE_REG+" up and go dostarcza DiPocket UAB, autoryzowana Instytucja Pieniądza Elektronicznego, podlegająca nadzorowi Banku Litwy (numer licencji 75) | Licencjonowana przez Mastercard do działania na Europejskim Obszarze Gospodarczego Upės g. 23, 08128 Vilnius, LT"));
    }

    @Test(priority = 11, enabled = false)
    public void testSupervisionEmailUpAndGoRU() throws InterruptedException, MessagingException, IOException {
        postSupervisionEmail(4, app.mobile_site_upAndGo, 32727);

        String emailSender =  EmailIMAPHelper3.getEmailSender(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailText =  EmailIMAPHelper3.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailBody = getEmailBodyText(emailText, 28, 295);
        String emailFooter = getEmailFooterText(emailText, 296);

        assertThat(emailSender, equalTo("regulacje@upcard.pl"));
        assertThat(emailBody, equalTo("Здравствуйте, "+app.emailsVerificationsFirstName+"! В приложении находится раздел \"Условий пользования приложением DiPocket\" об опеке. Вы уже приняли эти условия в момент регистрации, но мы хотим напомнить Вам детали перед началом использования этой функциональности. С уважением, Юридический отдел"));
        assertThat(emailFooter, equalTo(""+app.SITE_REG+" Для вашего спокойствия, up and go осуществляет деятельность при поддержке DiPocket UAB, который авторизован и контролируется Банком Литвы как эмитент электронных денег (#75) Upės str. 23, 08128 Vilnius, LT"));
    }
}