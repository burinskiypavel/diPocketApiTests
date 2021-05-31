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
    String firstName = "Pavel";
    String emailFrom = "customer.service@dipocket.org";
    String testEmail = "testdipocket@gmail.com";
    String pass = "password1<";
    String SITE_REG = "DiPocket®";

    public String body(String testEmail, String site){
        return "{\n" +
                "  \"email\": \""+testEmail+"\",\n" +
                "  \"phoneNumber\": \"380661470959\",\n" +
                "  \"programNickName\": \""+site+"\",\n" +
                "  \"site\": \""+site+"\",\n" +
                "  \"url\": \"google.com\"\n" +
                "}";
    }

    public void postSendTacEmail(String site) {
        given()
                .header("Content-Type", "application/json")
                .body(body(testEmail, site))
                .when()
                .post( app.dipocket3_intranet+"/EmailService/sendTacEmail")
                .then().log().all()
                .statusCode(200);
    }

    @Test(priority = 1)
    public void testTacDipocketEN() throws InterruptedException, MessagingException, IOException, SQLException, ClassNotFoundException {
        app.getDbHelper().updateClientLanguageFromDB(testEmail, "1");
        postSendTacEmail("DIPOCKET");

        String emailSender =  EmailIMAPHelper3.getEmailSender(testEmail, pass);
        String emailText =  EmailIMAPHelper3.getTextFromEmail("pop.gmail.com", testEmail, pass);
        String emailBody = getEmailBodyText(emailText, 28, 1523);
        String emailFooter = getEmailFooterText(emailText, 1524);

        assertThat(emailSender, equalTo(emailFrom));
        assertThat(emailBody, equalTo("Dear "+firstName+", Please find attached \"DiPocket_Terms_and_Conditions\" (the \"T&Cs\"), Tariff Table and Limits Table. It is important that you familiarise yourself with these documents and in particular with our current pricing and transaction limits. With regard to Personal Information, we ask you to please read the section in the T&C’s titled 'Personal Information' - we will process any Information you provide to us according those terms. By providing it to us, you are agreeing for us to process it, including any sensitive data for the purposes described in the Agreement subject to a number of rights you have to be informed about how your Information is processed, to correct any errors, to object to any processing, to restrict processing or have Information erased or to instruct us to copy or transfer Information as you direct. If you accept the T&Cs, please click on this link and proceed with the registration process through DiPocket mobile App. The T&Cs may only be changed upon 2 months notice to you, following which, if you have not objected, you will be deemed to have accepted the new terms. IMPORTANT: to expedite registration you may choose to start using the App even if you have not clicked on the link above. However, if you do not click on it within a week of accessing the App, your DiPocket account will be temporarily blocked until such time as you have clicked on the link and confirmed your agreement to having read and accepted the T&C’s. With kind regards, Legal Team"));
        assertThat(emailFooter, equalTo(""+SITE_REG+" "+site+" UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT"));
    }

    @Test(priority = 2)
    public void testTacDipocketPL() throws InterruptedException, MessagingException, IOException, SQLException, ClassNotFoundException {
        app.getDbHelper().updateClientLanguageFromDB(testEmail, "3");
        postSendTacEmail("DIPOCKET");

        String emailSender =  EmailIMAPHelper3.getEmailSender(testEmail, pass);
        String emailText =  EmailIMAPHelper3.getTextFromEmail("pop.gmail.com", testEmail, pass);
        String emailBody = getEmailBodyText(emailText, 28, 1703);
        String emailFooter = getEmailFooterText(emailText, 1704);

        assertThat(emailSender, equalTo(emailFrom));
        assertThat(emailBody, equalTo("Witaj "+firstName+", Prosimy o zapoznanie się z załączonymi dokumentami: “Warunkami ogólnymi dla klientów indywidualnych DiPocket”, \"Tabelą Limitów\" oraz \"Tabelą Prowizji i Opłat\". Prosimy o uważne przeczytanie zawartych w nich warunków oraz aktualnego cennika i limitów transakcji. W odniesieniu do Informacji osobowych, prosimy o zapoznanie się z sekcją Warunków ogólnych, zatytułowaną „Informacje osobowe” – przetwarzamy wszelkie powierzone nam dane zgodnie z zapisami tej sekcji. Przekazanie danych jest jednoczesnym wyrażeniem zgody na ich przetwarzanie, w tym na przetwarzanie danych poufnych do celów opisanych w Umowie, z zastrzeżeniem szeregu praw, o których użytkownik został poinformowany w aspektach: sposobu przetwarzania Informacji, poprawienia błędów, całkowitej lub częściowej odmowie możliwości przetwarzania, usunięcia informacji lub nakazania nam skopiowania lub transferu danych zgodnie z twoją dyspozycją. Jeżeli akceptujesz “Ogólne warunki dla klientów indywidualnych DiPocket” kliknij w ten link aby kontynuować proces rejestracji w aplikacji mobilnej DiPocket. “Ogólne warunki dla klientów indywidualnych DiPocket” mogą ulec zmianie jedynie, jeśli użytkownicy zostaną powiadomieni z co najmniej dwumiesięcznym wyprzedzeniem. W przypadku niezgłoszenia braku akceptacji, uznamy że akceptujesz nowe regulacje. WAŻNE: Aby przyspieszyć rejestrację, możesz zacząć korzystać z aplikacji DiPocket bez klikania w link zamieszczony powyżej. Jednakże w przypadku, gdy nie klikniesz w link w ciągu 7 dni, Twoje konto DiPocket zostanie tymczasowo zablokowane do momentu zaakceptowania „Ogólnych warunków korzystania z aplikacji DiPocket”. Z wyrazami szacunku, Dział Prawny"));
        assertThat(emailFooter, equalTo(""+SITE_REG+" "+site+" UAB, autoryzowana Instytucja Pieniądza Elektronicznego, podlegająca nadzorowi Banku Litwy (numer licencji 75) | Licencjonowana przez Mastercard do działania na Europejskim Obszarze Gospodarczego Upės g. 23, 08128 Vilnius, LT"));
    }

    @Test(priority = 3, enabled = false)
    public void tesTacDiscontuEN() throws InterruptedException, MessagingException, IOException {
        postSendTacEmail("DISCONTU");

        String emailSender =  EmailIMAPHelper3.getEmailSender(testEmail, pass);
        String emailText =  EmailIMAPHelper3.getTextFromEmail("pop.gmail.com", testEmail, pass);
        String emailBody = getEmailBodyText(emailText, 28, 169);
        String emailFooter = getEmailFooterText(emailText, 170);

        assertThat(emailSender, equalTo(emailFrom));
        assertThat(emailBody, equalTo("Dear "+firstName+", As requested, please find attached selected discontu legal documents. Thank you for using discontu. With kind regards, Legal Team"));
        assertThat(emailFooter, equalTo(""+SITE_REG+" discontu is powered by DiPocket UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT"));
    }

    @Test(priority = 6, enabled = false)
    public void testTacDiscontuPL() throws InterruptedException, MessagingException, IOException {
        postSendTacEmail("DISCONTU");

        String emailSender =  EmailIMAPHelper3.getEmailSender(testEmail, pass);
        String emailText =  EmailIMAPHelper3.getTextFromEmail("pop.gmail.com", testEmail, pass);
        String emailBody = getEmailBodyText(emailText, 0, 146);
        String emailFooter = getEmailFooterText(emailText, 147);

        assertThat(emailSender, equalTo(emailFrom));
        assertThat(emailBody, equalTo("Witaj "+firstName+", W załączniku znajdują się zamówione dokumenty prawne. Dziękujemy za korzystanie z serwisu discontu. Z wyrazami szacunku, Dział Prawny"));
        assertThat(emailFooter, equalTo(""+SITE_REG+" discontu dostarcza DiPocket UAB, autoryzowana Instytucja Pieniądza Elektronicznego, podlegająca nadzorowi Banku Litwy (numer licencji 75) | Licencjonowana przez Mastercard do działania na Europejskim Obszarze Gospodarczego Upės g. 23, 08128 Vilnius, LT"));
    }

    @Test(priority = 7, enabled = false)
    public void testTacPlayITEN() throws InterruptedException, MessagingException, IOException {
        postSendTacEmail("PLAYIT");

        String emailSender =  EmailIMAPHelper3.getEmailSender(testEmail, pass);
        String emailText =  EmailIMAPHelper3.getTextFromEmail("pop.gmail.com", testEmail, pass);
        String emailBody = getEmailBodyText(emailText, 26, 163);
        String emailFooter = getEmailFooterText(emailText, 164);

        assertThat(emailSender, equalTo("PlayIT Card <playitcard@dipocket.org>"));
        assertThat(emailBody, equalTo("Dear "+firstName+", As requested, please find attached selected PlayIT legal documents. Thank you for using PlayIT. With kind regards, Legal Team"));
        assertThat(emailFooter, equalTo(""+SITE_REG+" PlayIT is powered by DiPocket UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT"));
    }
}