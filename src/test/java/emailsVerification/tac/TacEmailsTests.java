package emailsVerification.tac;

import appmanager.EmailVerificationHelper;
import base.TestBase;
import io.restassured.specification.RequestSpecification;
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
    String expectedSender = "customer.service@dipocket.org";
    String expectedDiscontuSender = "legal.team@dipocket.org";
    String expectedUpAndGoSender = "regulacje@upcard.pl";

    public String body(String testEmail, String site){
        return "{\n" +
                "  \"email\": \""+testEmail+"\",\n" +
                "  \"phoneNumber\": \""+app.emailsVerificationsPhoneNumber+"\",\n" +
                //"  \"programNickName\": \""+site+"\",\n" +
                "  \"site\": \""+site+"\",\n" +
                "  \"url\": \"google.com\"\n" +
                "}";
    }

    public void postSendTacEmail(String site) {
        given()
                .spec(app.requestSpecEmailVerification)
                .body(body(app.emailsVerificationsEmail, site))
                .when()
                .post( "/EmailService/sendTacEmail")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    public void testTacDipocketEN() throws InterruptedException, MessagingException, IOException, SQLException, ClassNotFoundException {
        app.getDbHelper().updateClientLanguageFromDB(app.emailsVerificationsEmail, "1", app.mobile_site);
        postSendTacEmail(app.mobile_site);

        String emailSender =  EmailVerificationHelper.getEmailSender(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailBody = getEmailBodyText(emailText, 28, 1523);
        String emailFooter = getEmailFooterText(emailText, 1524);

        assertThat(emailSender, equalTo(expectedSender));
        assertThat(emailBody, equalTo("Dear "+app.emailsVerificationsFirstName+", Please find attached \""+app.site+"_Terms_and_Conditions\" (the \"T&Cs\"), Tariff Table and Limits Table. It is important that you familiarise yourself with these documents and in particular with our current pricing and transaction limits. With regard to Personal Information, we ask you to please read the section in the T&C’s titled 'Personal Information' - we will process any Information you provide to us according those terms. By providing it to us, you are agreeing for us to process it, including any sensitive data for the purposes described in the Agreement subject to a number of rights you have to be informed about how your Information is processed, to correct any errors, to object to any processing, to restrict processing or have Information erased or to instruct us to copy or transfer Information as you direct. If you accept the T&Cs, please click on this link and proceed with the registration process through DiPocket mobile App. The T&Cs may only be changed upon 2 months notice to you, following which, if you have not objected, you will be deemed to have accepted the new terms. IMPORTANT: to expedite registration you may choose to start using the App even if you have not clicked on the link above. However, if you do not click on it within a week of accessing the App, your DiPocket account will be temporarily blocked until such time as you have clicked on the link and confirmed your agreement to having read and accepted the T&C’s. With kind regards, Legal Team"));
        assertThat(emailFooter, equalTo(""+app.SITE_REG+" "+app.site+" UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT"));
    }

    @Test
    public void testTacDipocketUA() throws InterruptedException, MessagingException, IOException, SQLException, ClassNotFoundException {
        app.getDbHelper().updateClientLanguageFromDB(app.emailsVerificationsEmail, "2", app.mobile_site);
        postSendTacEmail(app.mobile_site);

        String emailSender =  EmailVerificationHelper.getEmailSender(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailBody = getEmailBodyText(emailText, 28, 1504);
        String emailFooter = getEmailFooterText(emailText, 1505);

        assertThat(emailSender, equalTo(expectedSender));
        assertThat(emailBody, equalTo("Вітаємо, "+app.emailsVerificationsFirstName+"! Будь ласка, ознайомтесь з прикріпленим файлом \""+app.site+"_Terms_and_Conditions\", в ньому знаходяться ключові правила користування DiPocket, актуальні ціни та ліміти для транзакцій. Стосовно особистої інформації, просимо Вас ознайомитись з розділом під назвою \"Personal Information\" - ми будемо обробляти будь-яку інформацію, яку ви надаєте нам відповідно до цих умов. Надавши нам інформацію (включаючи будь-які конфіденційні дані), Ви погоджуєтесь на її обробку для цілей, описаних у Договорі, з урахуванням права бути проінформованим про обробку вашої інформації, для виправлення помилок, для відмови у обробці, обмеження обробки або видалення інформації, для доручення копіювати або передавати інформацію за Вашою вказівкою. Якщо Ви приймаєте \"DiPocket_Terms_and_Conditions\", перейдіть за цим посиланням та продовжіть реєстрацію у додатку DiPocket. \"DiPocket_Terms_and_Conditions\" лишатимуться незмінним, доки ми не повідомимо про зміни, надсилаючи нові документи. Зміни будуть вислані принаймні за два місяці, щоб дати можливість ознайомитись із ними та прийняти їх. ВАЖЛИВО: Для прискорення процесу реєстрації можна почати користуватись додатком DiPocket без переходу за посиланням, яке зазначене вище. Але якщо Ви не зробите цього протягом 7 днів з моменту отримання доступу в додаток, Ваш рахунок DiPocket буде заблоковано, до моменту переходу за посиланням, що підтвердить що Ви ознайомились із \"DiPocket_Terms_and_Conditions\". З повагою, Юридичний відділ"));
        assertThat(emailFooter, equalTo(""+app.SITE_REG+" Для Вашого спокою, "+app.site+" UAB авторизований та контролюється Банком Литви, як емітент електронних грошей (#75) Upės str. 23, 08128 Vilnius, LT"));
    }

    @Test
    public void testTacDipocketPL() throws InterruptedException, MessagingException, IOException, SQLException, ClassNotFoundException {
        app.getDbHelper().updateClientLanguageFromDB(app.emailsVerificationsEmail, "3", app.mobile_site);
        postSendTacEmail(app.mobile_site);

        String emailSender =  EmailVerificationHelper.getEmailSender(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailBody = getEmailBodyText(emailText, 28, 1703);
        String emailFooter = getEmailFooterText(emailText, 1704);

        assertThat(emailSender, equalTo(expectedSender));
        assertThat(emailBody, equalTo("Witaj "+app.emailsVerificationsFirstName+", Prosimy o zapoznanie się z załączonymi dokumentami: “Warunkami ogólnymi dla klientów indywidualnych DiPocket”, \"Tabelą Limitów\" oraz \"Tabelą Prowizji i Opłat\". Prosimy o uważne przeczytanie zawartych w nich warunków oraz aktualnego cennika i limitów transakcji. W odniesieniu do Informacji osobowych, prosimy o zapoznanie się z sekcją Warunków ogólnych, zatytułowaną „Informacje osobowe” – przetwarzamy wszelkie powierzone nam dane zgodnie z zapisami tej sekcji. Przekazanie danych jest jednoczesnym wyrażeniem zgody na ich przetwarzanie, w tym na przetwarzanie danych poufnych do celów opisanych w Umowie, z zastrzeżeniem szeregu praw, o których użytkownik został poinformowany w aspektach: sposobu przetwarzania Informacji, poprawienia błędów, całkowitej lub częściowej odmowie możliwości przetwarzania, usunięcia informacji lub nakazania nam skopiowania lub transferu danych zgodnie z twoją dyspozycją. Jeżeli akceptujesz “Ogólne warunki dla klientów indywidualnych DiPocket” kliknij w ten link aby kontynuować proces rejestracji w aplikacji mobilnej DiPocket. “Ogólne warunki dla klientów indywidualnych DiPocket” mogą ulec zmianie jedynie, jeśli użytkownicy zostaną powiadomieni z co najmniej dwumiesięcznym wyprzedzeniem. W przypadku niezgłoszenia braku akceptacji, uznamy że akceptujesz nowe regulacje. WAŻNE: Aby przyspieszyć rejestrację, możesz zacząć korzystać z aplikacji DiPocket bez klikania w link zamieszczony powyżej. Jednakże w przypadku, gdy nie klikniesz w link w ciągu 7 dni, Twoje konto DiPocket zostanie tymczasowo zablokowane do momentu zaakceptowania „Ogólnych warunków korzystania z aplikacji DiPocket”. Z wyrazami szacunku, Dział Prawny"));
        assertThat(emailFooter, equalTo(""+app.SITE_REG+" "+app.site+" UAB, autoryzowana Instytucja Pieniądza Elektronicznego, podlegająca nadzorowi Banku Litwy (numer licencji 75) | Licencjonowana przez Mastercard do działania na Europejskim Obszarze Gospodarczego Upės g. 23, 08128 Vilnius, LT"));
    }

    @Test
    public void testTacDipocketRU() throws InterruptedException, MessagingException, IOException, SQLException, ClassNotFoundException {
        app.getDbHelper().updateClientLanguageFromDB(app.emailsVerificationsEmail, "4", app.mobile_site);
        postSendTacEmail(app.mobile_site);

        String emailSender =  EmailVerificationHelper.getEmailSender(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailBody = getEmailBodyText(emailText, 28, 1490);
        String emailFooter = getEmailFooterText(emailText, 1491);

        assertThat(emailSender, equalTo(expectedSender));
        assertThat(emailBody, equalTo("Здравствуйте, "+app.emailsVerificationsFirstName+"! Ознакомьтесь с прикрепленным файлом \""+app.site+"_Terms_and_Conditions\", в нём вы найдете ключевые правила использования "+app.site+", актуальные цены и тарифы. Относительно личных данных, просьба обратить внимание на раздел \"Personal Information\" в \""+app.site+"_Terms_and_Conditions\", поскольку вся личная информация будет обрабатываться согласно этим условиям. Предоставляя нам информацию (включая конфиденциальную), вы даёте согласие на ее обработку в целях, описанных в Договоре. Вы имеете право быть в курсе использования данных, чтобы иметь возможность исправить ошибки, чтобы отказаться от обработки или остановить обработку, или удалить информацию или проинструктировать нас о копировании или передачи информации по Вашему указанию. Если Вы принимаете \"Условия пользования приложением "+app.site+"\",  перейдите по этой ссылке и закончите регистрацию в приложении, если еще не закончили. \""+app.site+"_Terms_and_Conditions\" остаются неизменными до тех пор, пока не будет уведомлено об обратном. Уведомление об изменении условий будет выслано, по меньшей мере, за два месяца, чтобы дать Вам возможность ознакомится и принять их. ВАЖНО: можно закончить регистрацию без перехода по ссылке выше. Но, если вы не сделаете этого в течение 7 дней после получения доступа к приложению, учетная запись в DiPocket будет заблокирована до тех пор, пока Вы не перейдете по ссылке, принимая таким образом \""+app.site+"_Terms_and_Conditions\". С уважением, Юридический отдел"));
        assertThat(emailFooter, equalTo(""+app.SITE_REG+" Для вашего спокойствия, "+app.site+" UAB авторизован и контролируется Банком Литвы как эмитент электронных денег (#75) Upės str. 23, 08128 Vilnius, LT"));
    }

    @Test
    public void tesTacDiscontuEN() throws InterruptedException, MessagingException, IOException, SQLException, ClassNotFoundException {
        app.getDbHelper().updateClientLanguageFromDB(app.emailsVerificationsEmail, "1", app.mobile_site_discontu);
        postSendTacEmail(app.mobile_site_discontu);

        String emailSender =  EmailVerificationHelper.getEmailSender(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailBody = getEmailBodyText(emailText, 28, 1624);
        String emailFooter = getEmailFooterText(emailText, 1625);

        assertThat(emailSender, equalTo(expectedDiscontuSender));
        assertThat(emailBody, equalTo("Dear "+app.emailsVerificationsFirstName+", Please find attached \""+app.site_discontu+"_Terms_and_Conditions\" (the \"T&Cs\"). It is important that you familiarise yourself with these documents and in particular that you review in detail \""+app.site_discontu+"_at_a_Glance\", which summarises the key clauses applicable to your "+app.site_discontu+" account and also includes our current pricing and transaction limits. With regard to Personal Information, we ask you to please read the section in the T&C’s titled 'Personal Information' - we will process any Information you provide to us according those terms. By providing it to us, you are agreeing for us to process it, including any sensitive data for the purposes described in the Agreement subject to a number of rights you have to be informed about how your Information is processed, to correct any errors, to object to any processing, to restrict processing or have Information erased or to instruct us to copy or transfer Information as you direct. If you accept the T&Cs, please click on this link and proceed with the registration process through discontu mobile App. The T&Cs may only be changed upon 2 months notice to you, following which, if you have not objected, you will be deemed to have accepted the new terms. IMPORTANT: to expedite registration you may choose to start using the App even if you have not clicked on the link above. However, if you do not click on it within a week of accessing the App, your discontu account will be temporarily blocked until such time as you have clicked on the link and confirmed your agreement to having read and accepted the T&C’s. With kind regards, Legal Team"));
        assertThat(emailFooter, equalTo(""+app.SITE_REG+" "+app.site_discontu+" is powered by DiPocket UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT"));
    }

    @Test
    public void testTacDiscontuPL() throws InterruptedException, MessagingException, IOException, SQLException, ClassNotFoundException {
        app.getDbHelper().updateClientLanguageFromDB(app.emailsVerificationsEmail, "3", app.mobile_site_discontu);
        postSendTacEmail(app.mobile_site_discontu);

        String emailSender =  EmailVerificationHelper.getEmailSender(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailBody = getEmailBodyText(emailText, 28, 1750);
        String emailFooter = getEmailFooterText(emailText, 1751);

        assertThat(emailSender, equalTo(expectedDiscontuSender));
        assertThat(emailBody, equalTo("Witaj "+app.emailsVerificationsFirstName+", Prosimy o zapoznanie się z załączonym plikiem “Warunki ogólne dla klientów indywidualnych "+app.site_discontu+"”. Prosimy o zwrócenie szczególnej uwagi na część “Najważniejsze informacje o "+app.site_discontu+"”, w której znajduje się podsumowanie kluczowych zasad korzystania z konta "+app.site_discontu+", aktualny cennik oraz limity transakcji. W odniesieniu do Informacji osobowych, prosimy o zapoznanie się z sekcją Warunków ogólnych, zatytułowaną „Informacje osobowe” – przetwarzamy wszelkie powierzone nam dane zgodnie z zapisami tej sekcji. Przekazanie danych jest jednoczesnym wyrażeniem zgody na ich przetwarzanie, w tym na przetwarzanie danych poufnych do celów opisanych w Umowie, z zastrzeżeniem szeregu praw, o których użytkownik został poinformowany w aspektach: sposobu przetwarzania Informacji, poprawienia błędów, całkowitej lub częściowej odmowie możliwości przetwarzania, usunięcia informacji lub nakazania nam skopiowania lub transferu danych zgodnie z twoją dyspozycją. Jeżeli akceptujesz “Ogólne warunki dla klientów indywidualnych discontu” kliknij w ten link aby kontynuować proces rejestracji w aplikacji mobilnej discontu. “Ogólne warunki dla klientów indywidualnych discontu” mogą ulec zmianie jedynie, jeśli użytkownicy zostaną powiadomieni z co najmniej dwumiesięcznym wyprzedzeniem. W przypadku niezgłoszenia braku akceptacji, uznamy że akceptujesz nowe regulacje. WAŻNE: Aby przyspieszyć rejestrację, możesz zacząć korzystać z aplikacji discontu bez klikania w link zamieszczony powyżej. Jednakże w przypadku, gdy nie klikniesz w link w ciągu 7 dni, Twoje konto discontu zostanie tymczasowo zablokowane do momentu zaakceptowania „Ogólnych warunków korzystania z aplikacji discontu”. Z wyrazami szacunku, Dział Prawny"));
        assertThat(emailFooter, equalTo(""+app.SITE_REG+" "+app.site_discontu+" dostarcza DiPocket UAB, autoryzowana Instytucja Pieniądza Elektronicznego, podlegająca nadzorowi Banku Litwy (numer licencji 75) | Licencjonowana przez Mastercard do działania na Europejskim Obszarze Gospodarczego Upės g. 23, 08128 Vilnius, LT"));
    }

    @Test(enabled = false)
    public void testTacPlayITEN() throws InterruptedException, MessagingException, IOException, SQLException, ClassNotFoundException {
        app.getDbHelper().updateClientLanguageFromDB(app.emailsVerificationsEmail, "1", app.mobile_site_playIt);
        postSendTacEmail(app.mobile_site_playIt);

        String emailSender =  EmailVerificationHelper.getEmailSender(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailBody = getEmailBodyText(emailText, 26, 163);
        String emailFooter = getEmailFooterText(emailText, 164);

        assertThat(emailSender, equalTo("PlayIT Card <playitcard@dipocket.org>"));
        assertThat(emailBody, equalTo("Dear "+app.emailsVerificationsFirstName+", As requested, please find attached selected "+app.site_PlayIT+" legal documents. Thank you for using "+app.site_PlayIT+". With kind regards, Legal Team"));
        assertThat(emailFooter, equalTo(""+app.SITE_REG+" "+app.site_PlayIT+" is powered by DiPocket UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT"));
    }

    @Test(enabled = false)
    public void testTacUpAndGoEN() throws InterruptedException, MessagingException, IOException, SQLException, ClassNotFoundException {
        app.getDbHelper().updateClientLanguageFromDB(app.emailsVerificationsEmail, "1", app.mobile_site_upAndGo);
        postSendTacEmail(app.mobile_site_upAndGo);

        String emailSender =  EmailVerificationHelper.getEmailSender(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailBody = getEmailBodyText(emailText, 28, 1523);
        String emailFooter = getEmailFooterText(emailText, 1524);

        assertThat(emailSender, equalTo(expectedUpAndGoSender));
        assertThat(emailBody, equalTo("Dear "+app.emailsVerificationsFirstName+", Please find attached \""+app.site_upAndGo+"_Terms_and_Conditions\" (the \"T&Cs\"), Tariff Table and Limits Table. It is important that you familiarise yourself with these documents and in particular with our current pricing and transaction limits. With regard to Personal Information, we ask you to please read the section in the T&C’s titled 'Personal Information' - we will process any Information you provide to us according those terms. By providing it to us, you are agreeing for us to process it, including any sensitive data for the purposes described in the Agreement subject to a number of rights you have to be informed about how your Information is processed, to correct any errors, to object to any processing, to restrict processing or have Information erased or to instruct us to copy or transfer Information as you direct. If you accept the T&Cs, please click on this link and proceed with the registration process through "+app.site_upAndGo+" mobile App. The T&Cs may only be changed upon 2 months notice to you, following which, if you have not objected, you will be deemed to have accepted the new terms. IMPORTANT: to expedite registration you may choose to start using the App even if you have not clicked on the link above. However, if you do not click on it within a week of accessing the App, your "+app.site_upAndGo+" account will be temporarily blocked until such time as you have clicked on the link and confirmed your agreement to having read and accepted the T&C’s. With kind regards, Legal Team"));
        assertThat(emailFooter, equalTo(""+app.SITE_REG+" "+app.site_upAndGo+" is powered by DiPocket UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT"));
    }

    @Test(enabled = false)
    public void testTacUpAndGoUA() throws InterruptedException, MessagingException, IOException, SQLException, ClassNotFoundException {
        app.getDbHelper().updateClientLanguageFromDB(app.emailsVerificationsEmail, "2", app.mobile_site_upAndGo);
        postSendTacEmail(app.mobile_site_upAndGo);

        String emailSender =  EmailVerificationHelper.getEmailSender(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailBody = getEmailBodyText(emailText, 29, 1576);
        String emailFooter = getEmailFooterText(emailText, 1577);

        assertThat(emailSender, equalTo(expectedUpAndGoSender));
        assertThat(emailBody, equalTo("Вітаємо, Pavel! Будь ласка, ознайомтесь з прикріпленим файлом \"up and go_Terms_and_Conditions\". Будь ласка, зверніть увагу на частину \"up and go_at_a_Glance\", в ньому знаходяться ключові правила користування up and go, актуальні ціни та ліміти для транзакцій. Стосовно особистої інформації, просимо Вас ознайомитись з розділом під назвою \"Personal Information\" - ми будемо обробляти будь-яку інформацію, яку ви надаєте нам відповідно до цих умов. Надавши нам інформацію (включаючи будь-які конфіденційні дані), Ви погоджуєтесь на її обробку для цілей, описаних у Договорі, з урахуванням права бути проінформованим про обробку вашої інформації, для виправлення помилок, для відмови у обробці, обмеження обробки або видалення інформації, для доручення копіювати або передавати інформацію за Вашою вказівкою. Якщо Ви приймаєте \"up and go_Terms_and_Conditions\", перейдіть за цим посиланням та продовжіть реєстрацію у додатку up and go. \"up and go_Terms_and_Conditions\" лишатимуться незмінним, доки ми не повідомимо про зміни, надсилаючи нові документи. Зміни будуть вислані принаймні за два місяці, щоб дати можливість ознайомитись із ними та прийняти їх. ВАЖЛИВО: Для прискорення процесу реєстрації можна почати користуватись додатком up and go без переходу за посиланням, яке зазначене вище. Але якщо Ви не зробите цього протягом 7 днів з моменту отримання доступу в додаток, Ваш рахунок up and go буде заблоковано, до моменту переходу за посиланням, що підтвердить що Ви ознайомились із \"up and go_Terms_and_Conditions\". З повагою, Юридичний відділ"));
        assertThat(emailFooter, equalTo(""+app.SITE_REG+" Для Вашого спокою, "+app.site_upAndGo+" працює при підтримці DiPocket UAB, що авторизований та контролюється Банком Литви, як емітент електронних грошей (#75) Upės str. 23, 08128 Vilnius, LT"));
    }

    @Test(enabled = false)
    public void testTacUpAndGoPL() throws InterruptedException, MessagingException, IOException, SQLException, ClassNotFoundException {
        app.getDbHelper().updateClientLanguageFromDB(app.emailsVerificationsEmail, "3", app.mobile_site_upAndGo);
        postSendTacEmail(app.mobile_site_upAndGo);

        String emailSender =  EmailVerificationHelper.getEmailSender(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailBody = getEmailBodyText(emailText, 28, 1703);
        String emailFooter = getEmailFooterText(emailText, 1704);

        assertThat(emailSender, equalTo(expectedUpAndGoSender));
        assertThat(emailBody, equalTo("Witaj "+app.emailsVerificationsFirstName+", Prosimy o zapoznanie się z załączonymi dokumentami: “Warunkami ogólnymi dla klientów indywidualnych "+app.site_upAndGo+"”, \"Tabelą Limitów\" oraz \"Tabelą Prowizji i Opłat\". Prosimy o uważne przeczytanie zawartych w nich warunków oraz aktualnego cennika i limitów transakcji. W odniesieniu do Informacji osobowych, prosimy o zapoznanie się z sekcją Warunków ogólnych, zatytułowaną „Informacje osobowe” – przetwarzamy wszelkie powierzone nam dane zgodnie z zapisami tej sekcji. Przekazanie danych jest jednoczesnym wyrażeniem zgody na ich przetwarzanie, w tym na przetwarzanie danych poufnych do celów opisanych w Umowie, z zastrzeżeniem szeregu praw, o których użytkownik został poinformowany w aspektach: sposobu przetwarzania Informacji, poprawienia błędów, całkowitej lub częściowej odmowie możliwości przetwarzania, usunięcia informacji lub nakazania nam skopiowania lub transferu danych zgodnie z twoją dyspozycją. Jeżeli akceptujesz “Ogólne warunki dla klientów indywidualnych "+app.site_upAndGo+"” kliknij w ten link aby kontynuować proces rejestracji w aplikacji mobilnej "+app.site_upAndGo+". “Ogólne warunki dla klientów indywidualnych "+app.site_upAndGo+"” mogą ulec zmianie jedynie, jeśli użytkownicy zostaną powiadomieni z co najmniej dwumiesięcznym wyprzedzeniem. W przypadku niezgłoszenia braku akceptacji, uznamy że akceptujesz nowe regulacje. WAŻNE: Aby przyspieszyć rejestrację, możesz zacząć korzystać z aplikacji "+app.site_upAndGo+" bez klikania w link zamieszczony powyżej. Jednakże w przypadku, gdy nie klikniesz w link w ciągu 7 dni, Twoje konto "+app.site_upAndGo+" zostanie tymczasowo zablokowane do momentu zaakceptowania „Ogólnych warunków korzystania z aplikacji "+app.site_upAndGo+"”. Z wyrazami szacunku, Dział Prawny"));
        assertThat(emailFooter, equalTo(""+app.SITE_REG+" "+app.site_upAndGo+" dostarcza DiPocket UAB, autoryzowana Instytucja Pieniądza Elektronicznego, podlegająca nadzorowi Banku Litwy (numer licencji 75) | Licencjonowana przez Mastercard do działania na Europejskim Obszarze Gospodarczego Upės g. 23, 08128 Vilnius, LT"));
    }

    @Test(enabled = false)
    public void testTacUpAndGoRU() throws InterruptedException, MessagingException, IOException, SQLException, ClassNotFoundException {
        app.getDbHelper().updateClientLanguageFromDB(app.emailsVerificationsEmail, "4", app.mobile_site_upAndGo);
        postSendTacEmail(app.mobile_site_upAndGo);

        String emailSender =  EmailVerificationHelper.getEmailSender(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailBody = getEmailBodyText(emailText, 29, 1551);
        String emailFooter = getEmailFooterText(emailText, 1552);

        assertThat(emailSender, equalTo(expectedUpAndGoSender));
        assertThat(emailBody, equalTo("Здравствуйте, "+app.emailsVerificationsFirstName+"! Ознакомьтесь с прикрепленным файлом \""+app.site_upAndGo+"_Terms_and_Conditions\". Обратите внимание на документ \""+app.site_upAndGo+"_at_a_Glance\", в нём вы найдете ключевые правила пользования "+app.site_upAndGo+", актуальные цены и тарифы. Относительно личных данных, просьба обратить внимание на раздел \"Personal Information\" в \""+app.site_upAndGo+"_Terms_and_Conditions\", поскольку вся личная информация будет обрабатываться согласно этим условиям. Предоставляя нам информацию (включая конфиденциальную), вы даёте согласие на ее обработку в целях, описанных в Договоре. Вы имеете право быть в курсе использования данных, чтобы иметь возможность исправить ошибки, чтобы отказаться от обработки или остановить обработку, или удалить информацию или проинструктировать нас о копировании или передачи информации по Вашему указанию. Если Вы принимаете \"Условия пользования приложением "+app.site_upAndGo+"\",  перейдите по этой ссылке и закончите регистрацию в приложении, если еще не закончили. \""+app.site_upAndGo+"_Terms_and_Conditions\" остаются неизменными до тех пор, пока не будет уведомлено об обратном. Уведомление об изменении условий будет выслано, по меньшей мере, за два месяца, чтобы дать Вам возможность ознакомится и принять их. ВАЖНО: можно закончить регистрацию без перехода по ссылке выше. Но, если вы не сделаете этого в течение 7 дней после получения доступа к приложению, учетная запись в up and go будет заблокирована до тех пор, пока Вы не перейдете по ссылке, принимая таким образом \""+app.site_upAndGo+"_Terms_and_Conditions\". С уважением, Юридический отдел"));
        assertThat(emailFooter, equalTo(""+app.SITE_REG+" Для вашего спокойствия, "+app.site_upAndGo+" осуществляет деятельность при поддержке DiPocket UAB, который авторизован и контролируется Банком Литвы как эмитент электронных денег (#75) Upės str. 23, 08128 Vilnius, LT"));
    }

    @Test(enabled = false)
    public void testTacSnowAttackEN() throws InterruptedException, MessagingException, IOException, SQLException, ClassNotFoundException {
        app.getDbHelper().updateClientLanguageFromDB(app.emailsVerificationsEmail, "1", "SNOW_ATTACK");
        postSendTacEmail("SNOW_ATTACK");

        String emailSender =  EmailVerificationHelper.getEmailSender(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailBody = getEmailBodyText(emailText, 29, 1551);
        String emailFooter = getEmailFooterText(emailText, 1552);

        assertThat(emailSender, equalTo(expectedUpAndGoSender));
        assertThat(emailBody, equalTo("Здравствуйте, "+app.emailsVerificationsFirstName+"! Ознакомьтесь с прикрепленным файлом \""+app.site_upAndGo+"_Terms_and_Conditions\". Обратите внимание на документ \""+app.site_upAndGo+"_at_a_Glance\", в нём вы найдете ключевые правила пользования "+app.site_upAndGo+", актуальные цены и тарифы. Относительно личных данных, просьба обратить внимание на раздел \"Personal Information\" в \""+app.site_upAndGo+"_Terms_and_Conditions\", поскольку вся личная информация будет обрабатываться согласно этим условиям. Предоставляя нам информацию (включая конфиденциальную), вы даёте согласие на ее обработку в целях, описанных в Договоре. Вы имеете право быть в курсе использования данных, чтобы иметь возможность исправить ошибки, чтобы отказаться от обработки или остановить обработку, или удалить информацию или проинструктировать нас о копировании или передачи информации по Вашему указанию. Если Вы принимаете \"Условия пользования приложением "+app.site_upAndGo+"\",  перейдите по этой ссылке и закончите регистрацию в приложении, если еще не закончили. \""+app.site_upAndGo+"_Terms_and_Conditions\" остаются неизменными до тех пор, пока не будет уведомлено об обратном. Уведомление об изменении условий будет выслано, по меньшей мере, за два месяца, чтобы дать Вам возможность ознакомится и принять их. ВАЖНО: можно закончить регистрацию без перехода по ссылке выше. Но, если вы не сделаете этого в течение 7 дней после получения доступа к приложению, учетная запись в up and go будет заблокирована до тех пор, пока Вы не перейдете по ссылке, принимая таким образом \""+app.site_upAndGo+"_Terms_and_Conditions\". С уважением, Юридический отдел"));
        assertThat(emailFooter, equalTo(""+app.SITE_REG+" Для вашего спокойствия, "+app.site_upAndGo+" осуществляет деятельность при поддержке DiPocket UAB, который авторизован и контролируется Банком Литвы как эмитент электронных денег (#75) Upės str. 23, 08128 Vilnius, LT"));
    }
}