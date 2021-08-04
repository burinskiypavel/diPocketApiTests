package tests.emailsVerification.supervision;

import appmanager.EmailVerificationHelper;
import base.TestBase;
import org.testng.annotations.Test;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

import static appmanager.EmailIMAPHelper.getEmailBodyText;
import static appmanager.EmailIMAPHelper.getEmailFooterText;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class SupervisionEmailTests extends TestBase {
    String expectedSender = "legal.team@dipocket.org";
    String expectedUpAndGoSender = "regulacje@upcard.pl";

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
                .spec(app.requestSpecEmailVerification)
                .body(body(landId, site, id))
                .when()
                .post( "/EmailService/sendSupervisionEmail")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    public void testSupervisionEmailDipocketEN() throws InterruptedException, MessagingException, IOException {
        postSupervisionEmail(1, app.mobile_site, 32761);

        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualSender = senderAndSubject.get(0);
        String actualSubject = senderAndSubject.get(1);

        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualBody = getEmailBodyText(emailText, 0, 398);
        String actualFooter = getEmailFooterText(emailText, 399);

        assertThat(actualSender, equalTo(expectedSender));
        assertThat(actualSubject, equalTo(""+app.site+" Terms and Conditions - PLEASE DO NOT DISCARD"));
        assertThat(actualBody, equalTo("Dear "+app.emailsVerificationsFirstName+", Please find attached the section of "+app.site+" Terms and Conditions (the “T&Cs”) regulating Supervised accounts. It is the same that you have already agreed to as part of the T&Cs, but we want to draw your attention on it now that you will start using a Supervised account since it contains important provisions on the Supervisor’s role and responsibilities. With kind regards, Legal Team"));
        assertThat(actualFooter, equalTo(""+app.SITE_REG+" "+app.site+" UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT"));
    }

    @Test
    public void testSupervisionEmailDipocketUA() throws InterruptedException, MessagingException, IOException {
        postSupervisionEmail(2, app.mobile_site, 32761);

        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualSender = senderAndSubject.get(0);
        String actualSubject = senderAndSubject.get(1);

        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualBody = getEmailBodyText(emailText, 28, 486);
        String actualFooter = getEmailFooterText(emailText, 487);

        assertThat(actualSender, equalTo(expectedSender));
        assertThat(actualSubject, equalTo("Правила та Умови користування додатком "+app.site+" - будь ласка, збережіть це повідомлення"));
        assertThat(actualBody, equalTo("Вітаємо, "+app.emailsVerificationsFirstName+"! В додатку знаходиться розділ \"Умови та Правила користування додатком "+app.site+"\" (\"Правила користування\"), який стосується Опіки за рахунком. Ви прийняли їх разом з іншою частиною Правил користування, але зараз ми хочемо ще раз звернути на них Вашу увагу, адже Ви розпочинаєте користуватися Опікунськими рахунками, а в цьому розділі знаходиться більш детальна інформація про роль та відповідальність Опікуна рахунку. З повагою, Юридичний відділ"));
        assertThat(actualFooter, equalTo(""+app.SITE_REG+" Для Вашого спокою, "+app.site+" UAB авторизований та контролюється Банком Литви, як емітент електронних грошей (#75) Upės str. 23, 08128 Vilnius, LT"));
    }

    @Test
    public void testSupervisionEmailDipocketPL() throws InterruptedException, MessagingException, IOException {
        postSupervisionEmail(3, app.mobile_site, 32761);

        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualSender = senderAndSubject.get(0);
        String actualSubject = senderAndSubject.get(1);

        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualBody = getEmailBodyText(emailText, 0, 436);
        String actualFooter = getEmailFooterText(emailText, 437);

        assertThat(actualSender, equalTo(expectedSender));
        assertThat(actualSubject, equalTo("Zasady i Warunki korzystania z aplikacji "+app.site+" - PROSIMY O ZACHOWANIE TEJ WIADOMOŚCI"));
        assertThat(actualBody, equalTo("Witaj "+app.emailsVerificationsFirstName+", W załączeniu znajduje się sekcja Warunków i Zasad korzystania (\"Warunki korzystania\"), dotycząca Kont Nadzorowanych. Zaakceptowałeś ją wraz z pozostałą częścią Warunków korzystania, jednak chcemy raz jeszcze zwrócić na nią Twoją uwagę teraz, gdy rozpoczynasz korzystanie z Konta Nadzorowanego, a w tej sekcji znajdziesz szczegółowe zapisy dotyczące roli i odpowiedzialności Opiekuna Konta. Z wyrazami szacunku, Dział Prawny"));
        assertThat(actualFooter, equalTo(""+app.SITE_REG+" "+app.site+" UAB, autoryzowana Instytucja Pieniądza Elektronicznego, podlegająca nadzorowi Banku Litwy (numer licencji 75) | Licencjonowana przez Mastercard do działania na Europejskim Obszarze Gospodarczego Upės g. 23, 08128 Vilnius, LT"));
    }

    @Test
    public void testSupervisionEmailDipocketRU() throws InterruptedException, MessagingException, IOException {
        postSupervisionEmail(4, app.mobile_site, 32761);

        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualSender = senderAndSubject.get(0);
        String actualSubject = senderAndSubject.get(1);

        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualBody = getEmailBodyText(emailText, 28, 295);
        String actualFooter = getEmailFooterText(emailText, 296);

        assertThat(actualSender, equalTo(expectedSender));
        assertThat(actualSubject, equalTo("Условия пользования приложением "+app.site+" - пожалуйста, сохраните это сообщение"));
        assertThat(actualBody, equalTo("Здравствуйте, "+app.emailsVerificationsFirstName+"! В приложении находится раздел \"Условий пользования приложением "+app.site+"\" об опеке. Вы уже приняли эти условия в момент регистрации, но мы хотим напомнить Вам детали перед началом использования этой функциональности. С уважением, Юридический отдел"));
        assertThat(actualFooter, equalTo(""+app.SITE_REG+" Для вашего спокойствия, "+app.site+" UAB авторизован и контролируется Банком Литвы как эмитент электронных денег (#75) Upės str. 23, 08128 Vilnius, LT"));
    }

    @Test
    public void testSupervisionEmailDiscontuEN() throws InterruptedException, MessagingException, IOException {
        postSupervisionEmail(1, app.mobile_site_discontu, 32717);

        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualSender = senderAndSubject.get(0);
        String actualSubject = senderAndSubject.get(1);

        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualBody = getEmailBodyText(emailText, 0, 398);
        String actualFooter = getEmailFooterText(emailText, 399);

        assertThat(actualSender, equalTo(expectedSender));
        assertThat(actualSubject, equalTo(""+app.site_discontu+" Terms and Conditions - PLEASE DO NOT DISCARD"));
        assertThat(actualBody, equalTo("Dear "+app.emailsVerificationsFirstName+", Please find attached the section of "+app.site_discontu+" Terms and Conditions (the “T&Cs”) regulating Supervised accounts. It is the same that you have already agreed to as part of the T&Cs, but we want to draw your attention on it now that you will start using a Supervised account since it contains important provisions on the Supervisor’s role and responsibilities. With kind regards, Legal Team"));
        assertThat(actualFooter, equalTo(""+app.SITE_REG+" "+app.site_discontu+" is powered by DiPocket UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT"));
    }

    @Test
    public void testSupervisionEmailDiscontuPL() throws InterruptedException, MessagingException, IOException {
        postSupervisionEmail(3, app.mobile_site_discontu, 32717);

        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualSender = senderAndSubject.get(0);
        String actualSubject = senderAndSubject.get(1);

        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualBody = getEmailBodyText(emailText, 0, 436);
        String actualFooter = getEmailFooterText(emailText, 437);

        assertThat(actualSender, equalTo(expectedSender));
        assertThat(actualSubject, equalTo("Zasady i Warunki korzystania z aplikacji "+app.site_discontu+" - PROSIMY O ZACHOWANIE TEJ WIADOMOŚCI"));
        assertThat(actualBody, equalTo("Witaj "+app.emailsVerificationsFirstName+", W załączeniu znajduje się sekcja Warunków i Zasad korzystania (\"Warunki korzystania\"), dotycząca Kont Nadzorowanych. Zaakceptowałeś ją wraz z pozostałą częścią Warunków korzystania, jednak chcemy raz jeszcze zwrócić na nią Twoją uwagę teraz, gdy rozpoczynasz korzystanie z Konta Nadzorowanego, a w tej sekcji znajdziesz szczegółowe zapisy dotyczące roli i odpowiedzialności Opiekuna Konta. Z wyrazami szacunku, Dział Prawny"));
        assertThat(actualFooter, equalTo(""+app.SITE_REG+" "+app.site_discontu+" dostarcza DiPocket UAB, autoryzowana Instytucja Pieniądza Elektronicznego, podlegająca nadzorowi Banku Litwy (numer licencji 75) | Licencjonowana przez Mastercard do działania na Europejskim Obszarze Gospodarczego Upės g. 23, 08128 Vilnius, LT"));
    }

    @Test
    public void testSupervisionEmailPlayITEN() throws InterruptedException, MessagingException, IOException {
        postSupervisionEmail(1, app.mobile_site_playIt, 32732);

        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualSender = senderAndSubject.get(0);
        String actualSubject = senderAndSubject.get(1);

        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualBody = getEmailBodyText(emailText, 0, 396);
        String actualFooter = getEmailFooterText(emailText, 397);

        assertThat(actualSender, equalTo("PlayIT Card <playitcard@dipocket.org>"));
        assertThat(actualSubject, equalTo(""+app.site_PlayIT+" Terms and Conditions - PLEASE DO NOT DISCARD"));
        assertThat(actualBody, equalTo("Dear "+app.emailsVerificationsFirstName+", Please find attached the section of "+app.site_PlayIT+" Terms and Conditions (the “T&Cs”) regulating Supervised accounts. It is the same that you have already agreed to as part of the T&Cs, but we want to draw your attention on it now that you will start using a Supervised account since it contains important provisions on the Supervisor’s role and responsibilities. With kind regards, Legal Team"));
        assertThat(actualFooter, equalTo(""+app.SITE_REG+" "+app.site_PlayIT+" is powered by DiPocket UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT"));
    }

    @Test
    public void testSupervisionEmailPlayITHU() throws InterruptedException, MessagingException, IOException {
        postSupervisionEmail(5, app.mobile_site_playIt, 32732);

        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualSender = senderAndSubject.get(0);
        String actualSubject = senderAndSubject.get(1);

        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualBody = getEmailBodyText(emailText, 0, 247);
        String actualFooter = getEmailFooterText(emailText, 248);

        assertThat(actualSender, equalTo("PlayIT Card <playitcard@dipocket.org>"));
        assertThat(actualSubject, equalTo(""+app.site_PlayIT+" használatának feltételei – KÉRJÜK, NE DOBJA EL"));
        assertThat(actualBody, equalTo("Kedves "+app.emailsVerificationsFirstName+", Csatolva találja \"A "+app.site_PlayIT+" alkalmazás felügyelt számlák használati feltételei\". Regisztrációkor már elfogadta ezeket a feltételeket, de emlékeztetni szeretnénk a részletekre, mielőtt ezt a funkciót használná. Üdvözlettel, Jogi csapat"));
        assertThat(actualFooter, equalTo(""+app.SITE_REG+" Megnyugtatásul tájékoztatjuk, hogy a "+app.site_PlayIT+" Kártya számládat a DiPocket UAB kezeli, mely vállalatot a Litván Nemzeti Bank elektronikus pénzintézetenként (# 75) engedélyezett és felügyel Upės str. 23, 08128 Vilnius, LT"));
    }

    @Test
    public void testSupervisionEmailUpAndGoEN() throws InterruptedException, MessagingException, IOException {
        postSupervisionEmail(1, app.mobile_site_upAndGo, 32727);

        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualSender = senderAndSubject.get(0);
        String actualSubject = senderAndSubject.get(1);

        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualBody = getEmailBodyText(emailText, 0, 399);
        String actualFooter = getEmailFooterText(emailText, 400);

        //assertThat(actualSender, equalTo(expectedUpAndGoSender));
        assertThat(actualSubject, equalTo(""+app.site_upAndGo+" Terms and Conditions - PLEASE DO NOT DISCARD"));
        assertThat(actualBody, equalTo("Dear "+app.emailsVerificationsFirstName+", Please find attached the section of "+app.site_upAndGo+" Terms and Conditions (the “T&Cs”) regulating Supervised accounts. It is the same that you have already agreed to as part of the T&Cs, but we want to draw your attention on it now that you will start using a Supervised account since it contains important provisions on the Supervisor’s role and responsibilities. With kind regards, Legal Team"));
        assertThat(actualFooter, equalTo(""+app.SITE_REG+" "+app.site_upAndGo+" is powered by DiPocket UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT"));
    }

    @Test
    public void testSupervisionEmailUpAndGoUA() throws InterruptedException, MessagingException, IOException {
        postSupervisionEmail(2, app.mobile_site_upAndGo, 32727);

        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualSender = senderAndSubject.get(0);
        String actualSubject = senderAndSubject.get(1);

        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualBody = getEmailBodyText(emailText, 29, 488);
        String actualFooter = getEmailFooterText(emailText, 489);

        //assertThat(actualSender, equalTo(expectedUpAndGoSender));
        assertThat(actualSubject, equalTo("Правила та Умови користування додатком "+app.site_upAndGo+" - будь ласка, збережіть це повідомлення"));
        assertThat(actualBody, equalTo("Вітаємо, "+app.emailsVerificationsFirstName+"! В додатку знаходиться розділ \"Умови та Правила користування додатком up and go\" (\"Правила користування\"), який стосується Опіки за рахунком. Ви прийняли їх разом з іншою частиною Правил користування, але зараз ми хочемо ще раз звернути на них Вашу увагу, адже Ви розпочинаєте користуватися Опікунськими рахунками, а в цьому розділі знаходиться більш детальна інформація про роль та відповідальність Опікуна рахунку. З повагою, Юридичний відділ"));
        assertThat(actualFooter, equalTo(""+app.SITE_REG+" Для Вашого спокою, "+app.site_upAndGo+" працює при підтримці DiPocket UAB, що авторизований та контролюється Банком Литви, як емітент електронних грошей (#75) Upės str. 23, 08128 Vilnius, LT"));
    }

    @Test
    public void testSupervisionEmailUpAndGoPL() throws InterruptedException, MessagingException, IOException {
        postSupervisionEmail(3, app.mobile_site_upAndGo, 32727);

        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualSender = senderAndSubject.get(0);
        String actualSubject = senderAndSubject.get(1);

        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualBody = getEmailBodyText(emailText, 0, 436);
        String actualFooter = getEmailFooterText(emailText, 437);

        //assertThat(actualSender, equalTo(expectedUpAndGoSender));
        assertThat(actualSubject, equalTo("Zasady i Warunki korzystania z aplikacji "+app.site_upAndGo+" - PROSIMY O ZACHOWANIE TEJ WIADOMOŚCI"));
        assertThat(actualBody, equalTo("Witaj "+app.emailsVerificationsFirstName+", W załączeniu znajduje się sekcja Warunków i Zasad korzystania (\"Warunki korzystania\"), dotycząca Kont Nadzorowanych. Zaakceptowałeś ją wraz z pozostałą częścią Warunków korzystania, jednak chcemy raz jeszcze zwrócić na nią Twoją uwagę teraz, gdy rozpoczynasz korzystanie z Konta Nadzorowanego, a w tej sekcji znajdziesz szczegółowe zapisy dotyczące roli i odpowiedzialności Opiekuna Konta. Z wyrazami szacunku, Dział Prawny"));
        assertThat(actualFooter, equalTo(""+app.SITE_REG+" "+app.site_upAndGo+" dostarcza DiPocket UAB, autoryzowana Instytucja Pieniądza Elektronicznego, podlegająca nadzorowi Banku Litwy (numer licencji 75) | Licencjonowana przez Mastercard do działania na Europejskim Obszarze Gospodarczego Upės g. 23, 08128 Vilnius, LT"));
    }

    @Test
    public void testSupervisionEmailUpAndGoRU() throws InterruptedException, MessagingException, IOException {
        postSupervisionEmail(4, app.mobile_site_upAndGo, 32727);

        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualSender = senderAndSubject.get(0);
        String actualSubject = senderAndSubject.get(1);

        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualBody = getEmailBodyText(emailText, 29, 297);
        String actualFooter = getEmailFooterText(emailText, 298);

        //assertThat(actualSender, equalTo(expectedUpAndGoSender));
        assertThat(actualSubject, equalTo("Условия пользования приложением "+app.site_upAndGo+" - пожалуйста, сохраните это сообщение"));
        assertThat(actualBody, equalTo("Здравствуйте, "+app.emailsVerificationsFirstName+"! В приложении находится раздел \"Условий пользования приложением "+app.site_upAndGo+"\" об опеке. Вы уже приняли эти условия в момент регистрации, но мы хотим напомнить Вам детали перед началом использования этой функциональности. С уважением, Юридический отдел"));
        assertThat(actualFooter, equalTo(""+app.SITE_REG+" Для вашего спокойствия, "+app.site_upAndGo+" осуществляет деятельность при поддержке DiPocket UAB, который авторизован и контролируется Банком Литвы как эмитент электронных денег (#75) Upės str. 23, 08128 Vilnius, LT"));
    }

    @Test(enabled = false)//bug Legal, Supervision, Reset Password there are no send emails for Snow Attack users
    public void testSupervisionEmailSnowAttackEN() throws InterruptedException, MessagingException, IOException {
        postSupervisionEmail(1, app.mobile_site_snowAttack, 32855);

        String emailSender =  EmailVerificationHelper.getEmailSender(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailBody = getEmailBodyText(emailText, 0, 398);
        String emailFooter = getEmailFooterText(emailText, 399);

        assertThat(emailSender, equalTo(expectedSender));
        assertThat(emailBody, equalTo("Dear "+app.emailsVerificationsFirstName+", Please find attached the section of "+app.site_SnowAttack+" Terms and Conditions (the “T&Cs”) regulating Supervised accounts. It is the same that you have already agreed to as part of the T&Cs, but we want to draw your attention on it now that you will start using a Supervised account since it contains important provisions on the Supervisor’s role and responsibilities. With kind regards, Legal Team"));
        assertThat(emailFooter, equalTo(""+app.SITE_REG+" "+app.site_SnowAttack+" UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT"));
    }
}