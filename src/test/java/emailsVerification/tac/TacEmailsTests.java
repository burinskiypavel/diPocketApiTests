package emailsVerification.tac;

import appmanager.EmailIMAPHelper3;
import base.TestBase;
import org.testng.annotations.Test;

import javax.mail.MessagingException;
import java.io.IOException;
import java.sql.SQLException;

import static appmanager.EmailIMAPHelper.getEmailBodyText;
import static appmanager.EmailIMAPHelper.getEmailFooterText;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class TacEmailsTests extends TestBase {
    String site = "DiPocket";
    String expectedEmailSender = "customer.service@dipocket.org";

    public String body(String testEmail, String site){
        return "{\n" +
                "  \"email\": \""+testEmail+"\",\n" +
                "  \"phoneNumber\": \""+app.emailsVerificationsPhoneNumber+"\",\n" +
                "  \"programNickName\": \""+site+"\",\n" +
                "  \"site\": \""+site+"\",\n" +
                "  \"url\": \"google.com\"\n" +
                "}";
    }

    public void postSendTacEmail(String site) {
        given()
                .contentType("application/json")
                .body(body(app.emailsVerificationsEmail, site))
                .when()
                .post( app.dipocket3_intranet+"/EmailService/sendTacEmail")
                .then().log().all()
                .statusCode(200);
    }

    @Test(priority = 1)
    public void testTacDipocketEN() throws InterruptedException, MessagingException, IOException, SQLException, ClassNotFoundException {
        app.getDbHelper().updateClientLanguageFromDB(app.emailsVerificationsEmail, "1", "DIPOCKET");
        postSendTacEmail("DIPOCKET");

        String emailSender =  EmailIMAPHelper3.getEmailSender(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailText =  EmailIMAPHelper3.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailBody = getEmailBodyText(emailText, 28, 1523);
        String emailFooter = getEmailFooterText(emailText, 1524);

        assertThat(emailSender, equalTo(expectedEmailSender));
        assertThat(emailBody, equalTo("Dear "+app.emailsVerificationsFirstName+", Please find attached \"DiPocket_Terms_and_Conditions\" (the \"T&Cs\"), Tariff Table and Limits Table. It is important that you familiarise yourself with these documents and in particular with our current pricing and transaction limits. With regard to Personal Information, we ask you to please read the section in the T&C’s titled 'Personal Information' - we will process any Information you provide to us according those terms. By providing it to us, you are agreeing for us to process it, including any sensitive data for the purposes described in the Agreement subject to a number of rights you have to be informed about how your Information is processed, to correct any errors, to object to any processing, to restrict processing or have Information erased or to instruct us to copy or transfer Information as you direct. If you accept the T&Cs, please click on this link and proceed with the registration process through DiPocket mobile App. The T&Cs may only be changed upon 2 months notice to you, following which, if you have not objected, you will be deemed to have accepted the new terms. IMPORTANT: to expedite registration you may choose to start using the App even if you have not clicked on the link above. However, if you do not click on it within a week of accessing the App, your DiPocket account will be temporarily blocked until such time as you have clicked on the link and confirmed your agreement to having read and accepted the T&C’s. With kind regards, Legal Team"));
        assertThat(emailFooter, equalTo(""+app.SITE_REG+" "+site+" UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT"));
    }

    @Test(priority = 2)
    public void testTacDipocketPL() throws InterruptedException, MessagingException, IOException, SQLException, ClassNotFoundException {
        app.getDbHelper().updateClientLanguageFromDB(app.emailsVerificationsEmail, "3", "DIPOCKET");
        postSendTacEmail("DIPOCKET");

        String emailSender =  EmailIMAPHelper3.getEmailSender(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailText =  EmailIMAPHelper3.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailBody = getEmailBodyText(emailText, 28, 1703);
        String emailFooter = getEmailFooterText(emailText, 1704);

        assertThat(emailSender, equalTo(expectedEmailSender));
        assertThat(emailBody, equalTo("Witaj "+app.emailsVerificationsFirstName+", Prosimy o zapoznanie się z załączonymi dokumentami: “Warunkami ogólnymi dla klientów indywidualnych DiPocket”, \"Tabelą Limitów\" oraz \"Tabelą Prowizji i Opłat\". Prosimy o uważne przeczytanie zawartych w nich warunków oraz aktualnego cennika i limitów transakcji. W odniesieniu do Informacji osobowych, prosimy o zapoznanie się z sekcją Warunków ogólnych, zatytułowaną „Informacje osobowe” – przetwarzamy wszelkie powierzone nam dane zgodnie z zapisami tej sekcji. Przekazanie danych jest jednoczesnym wyrażeniem zgody na ich przetwarzanie, w tym na przetwarzanie danych poufnych do celów opisanych w Umowie, z zastrzeżeniem szeregu praw, o których użytkownik został poinformowany w aspektach: sposobu przetwarzania Informacji, poprawienia błędów, całkowitej lub częściowej odmowie możliwości przetwarzania, usunięcia informacji lub nakazania nam skopiowania lub transferu danych zgodnie z twoją dyspozycją. Jeżeli akceptujesz “Ogólne warunki dla klientów indywidualnych DiPocket” kliknij w ten link aby kontynuować proces rejestracji w aplikacji mobilnej DiPocket. “Ogólne warunki dla klientów indywidualnych DiPocket” mogą ulec zmianie jedynie, jeśli użytkownicy zostaną powiadomieni z co najmniej dwumiesięcznym wyprzedzeniem. W przypadku niezgłoszenia braku akceptacji, uznamy że akceptujesz nowe regulacje. WAŻNE: Aby przyspieszyć rejestrację, możesz zacząć korzystać z aplikacji DiPocket bez klikania w link zamieszczony powyżej. Jednakże w przypadku, gdy nie klikniesz w link w ciągu 7 dni, Twoje konto DiPocket zostanie tymczasowo zablokowane do momentu zaakceptowania „Ogólnych warunków korzystania z aplikacji DiPocket”. Z wyrazami szacunku, Dział Prawny"));
        assertThat(emailFooter, equalTo(""+app.SITE_REG+" "+site+" UAB, autoryzowana Instytucja Pieniądza Elektronicznego, podlegająca nadzorowi Banku Litwy (numer licencji 75) | Licencjonowana przez Mastercard do działania na Europejskim Obszarze Gospodarczego Upės g. 23, 08128 Vilnius, LT"));
    }

    @Test(priority = 3)
    public void tesTacDiscontuEN() throws InterruptedException, MessagingException, IOException, SQLException, ClassNotFoundException {
        app.getDbHelper().updateClientLanguageFromDB(app.emailsVerificationsEmail, "1", "DISCONTU");
        postSendTacEmail("DISCONTU");

        String emailSender =  EmailIMAPHelper3.getEmailSender(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailText =  EmailIMAPHelper3.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailBody = getEmailBodyText(emailText, 28, 1624);
        String emailFooter = getEmailFooterText(emailText, 1625);

        assertThat(emailSender, equalTo("legal.team@dipocket.org"));
        assertThat(emailBody, equalTo("Dear "+app.emailsVerificationsFirstName+", Please find attached \"discontu_Terms_and_Conditions\" (the \"T&Cs\"). It is important that you familiarise yourself with these documents and in particular that you review in detail \"discontu_at_a_Glance\", which summarises the key clauses applicable to your discontu account and also includes our current pricing and transaction limits. With regard to Personal Information, we ask you to please read the section in the T&C’s titled 'Personal Information' - we will process any Information you provide to us according those terms. By providing it to us, you are agreeing for us to process it, including any sensitive data for the purposes described in the Agreement subject to a number of rights you have to be informed about how your Information is processed, to correct any errors, to object to any processing, to restrict processing or have Information erased or to instruct us to copy or transfer Information as you direct. If you accept the T&Cs, please click on this link and proceed with the registration process through discontu mobile App. The T&Cs may only be changed upon 2 months notice to you, following which, if you have not objected, you will be deemed to have accepted the new terms. IMPORTANT: to expedite registration you may choose to start using the App even if you have not clicked on the link above. However, if you do not click on it within a week of accessing the App, your discontu account will be temporarily blocked until such time as you have clicked on the link and confirmed your agreement to having read and accepted the T&C’s. With kind regards, Legal Team"));
        assertThat(emailFooter, equalTo(""+app.SITE_REG+" discontu is powered by DiPocket UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT"));
    }

    @Test(priority = 4)
    public void testTacDiscontuPL() throws InterruptedException, MessagingException, IOException, SQLException, ClassNotFoundException {
        app.getDbHelper().updateClientLanguageFromDB(app.emailsVerificationsEmail, "3", "DISCONTU");
        postSendTacEmail("DISCONTU");

        String emailSender =  EmailIMAPHelper3.getEmailSender(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailText =  EmailIMAPHelper3.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailBody = getEmailBodyText(emailText, 28, 1750);
        String emailFooter = getEmailFooterText(emailText, 1751);

        assertThat(emailSender, equalTo("legal.team@dipocket.org"));
        assertThat(emailBody, equalTo("Witaj "+app.emailsVerificationsFirstName+", Prosimy o zapoznanie się z załączonym plikiem “Warunki ogólne dla klientów indywidualnych discontu”. Prosimy o zwrócenie szczególnej uwagi na część “Najważniejsze informacje o discontu”, w której znajduje się podsumowanie kluczowych zasad korzystania z konta discontu, aktualny cennik oraz limity transakcji. W odniesieniu do Informacji osobowych, prosimy o zapoznanie się z sekcją Warunków ogólnych, zatytułowaną „Informacje osobowe” – przetwarzamy wszelkie powierzone nam dane zgodnie z zapisami tej sekcji. Przekazanie danych jest jednoczesnym wyrażeniem zgody na ich przetwarzanie, w tym na przetwarzanie danych poufnych do celów opisanych w Umowie, z zastrzeżeniem szeregu praw, o których użytkownik został poinformowany w aspektach: sposobu przetwarzania Informacji, poprawienia błędów, całkowitej lub częściowej odmowie możliwości przetwarzania, usunięcia informacji lub nakazania nam skopiowania lub transferu danych zgodnie z twoją dyspozycją. Jeżeli akceptujesz “Ogólne warunki dla klientów indywidualnych discontu” kliknij w ten link aby kontynuować proces rejestracji w aplikacji mobilnej discontu. “Ogólne warunki dla klientów indywidualnych discontu” mogą ulec zmianie jedynie, jeśli użytkownicy zostaną powiadomieni z co najmniej dwumiesięcznym wyprzedzeniem. W przypadku niezgłoszenia braku akceptacji, uznamy że akceptujesz nowe regulacje. WAŻNE: Aby przyspieszyć rejestrację, możesz zacząć korzystać z aplikacji discontu bez klikania w link zamieszczony powyżej. Jednakże w przypadku, gdy nie klikniesz w link w ciągu 7 dni, Twoje konto discontu zostanie tymczasowo zablokowane do momentu zaakceptowania „Ogólnych warunków korzystania z aplikacji discontu”. Z wyrazami szacunku, Dział Prawny"));
        assertThat(emailFooter, equalTo(""+app.SITE_REG+" discontu dostarcza DiPocket UAB, autoryzowana Instytucja Pieniądza Elektronicznego, podlegająca nadzorowi Banku Litwy (numer licencji 75) | Licencjonowana przez Mastercard do działania na Europejskim Obszarze Gospodarczego Upės g. 23, 08128 Vilnius, LT"));
    }

    @Test(priority = 5, enabled = false)
    public void testTacPlayITEN() throws InterruptedException, MessagingException, IOException {
        postSendTacEmail("PLAYIT");

        String emailSender =  EmailIMAPHelper3.getEmailSender(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailText =  EmailIMAPHelper3.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailBody = getEmailBodyText(emailText, 26, 163);
        String emailFooter = getEmailFooterText(emailText, 164);

        assertThat(emailSender, equalTo("PlayIT Card <playitcard@dipocket.org>"));
        assertThat(emailBody, equalTo("Dear "+app.emailsVerificationsFirstName+", As requested, please find attached selected PlayIT legal documents. Thank you for using PlayIT. With kind regards, Legal Team"));
        assertThat(emailFooter, equalTo(""+app.SITE_REG+" PlayIT is powered by DiPocket UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT"));
    }
}