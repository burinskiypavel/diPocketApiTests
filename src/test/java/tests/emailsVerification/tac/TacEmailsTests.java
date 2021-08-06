package tests.emailsVerification.tac;

import appmanager.EmailVerificationHelper;
import base.TestBase;
import org.testng.annotations.Test;

import javax.mail.MessagingException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

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
                "  \"programNickName\": \""+site+"\",\n" +
                "  \"site\": \""+site+"\",\n" +
                "  \"url\": \"google.com\"\n" +
                "}";
    }

    public String body2(String testEmail, String site){
        return "{\n" +
                "  \"email\": \""+testEmail+"\",\n" +
                "  \"phoneNumber\": \"380932485981\",\n" +
                "  \"programNickName\": \""+site+"\",\n" +
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

    public void postSendTacTelenorEmail(String site) {
        given()
                .spec(app.requestSpecEmailVerification)
                .body(body2(app.emailsVerificationsEmail, site))
                .when()
                .post( "/EmailService/sendTacTelenorEmail")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    public void testTacDipocketEN() throws InterruptedException, MessagingException, IOException, SQLException, ClassNotFoundException {
        app.getDbHelper().updateClientLanguageFromDB(app.emailsVerificationsEmail, "1", app.mobile_site);
        postSendTacEmail(app.mobile_site);

        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualSender = senderAndSubject.get(0);
        String actualSubject = senderAndSubject.get(1);

        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualBody = getEmailBodyText(emailText, 28, 1523);
        String actualFooter = getEmailFooterText(emailText, 1524);

        assertThat(actualSender, equalTo(expectedSender));
        assertThat(actualSubject, equalTo(""+app.site+" Terms and Conditions - PLEASE DO NOT DISCARD"));
        assertThat(actualBody, equalTo("Dear "+app.emailsVerificationsFirstName+", Please find attached \""+app.site+"_Terms_and_Conditions\" (the \"T&Cs\"), Tariff Table and Limits Table. It is important that you familiarise yourself with these documents and in particular with our current pricing and transaction limits. With regard to Personal Information, we ask you to please read the section in the T&C’s titled 'Personal Information' - we will process any Information you provide to us according those terms. By providing it to us, you are agreeing for us to process it, including any sensitive data for the purposes described in the Agreement subject to a number of rights you have to be informed about how your Information is processed, to correct any errors, to object to any processing, to restrict processing or have Information erased or to instruct us to copy or transfer Information as you direct. If you accept the T&Cs, please click on this link and proceed with the registration process through DiPocket mobile App. The T&Cs may only be changed upon 2 months notice to you, following which, if you have not objected, you will be deemed to have accepted the new terms. IMPORTANT: to expedite registration you may choose to start using the App even if you have not clicked on the link above. However, if you do not click on it within a week of accessing the App, your DiPocket account will be temporarily blocked until such time as you have clicked on the link and confirmed your agreement to having read and accepted the T&C’s. With kind regards, Legal Team"));
        assertThat(actualFooter, equalTo(""+app.SITE_REG+" "+app.site+" UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT"));
    }

    @Test
    public void testTacDipocketUA() throws InterruptedException, MessagingException, IOException, SQLException, ClassNotFoundException {
        app.getDbHelper().updateClientLanguageFromDB(app.emailsVerificationsEmail, "2", app.mobile_site);
        postSendTacEmail(app.mobile_site);

        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualSender = senderAndSubject.get(0);
        String actualSubject = senderAndSubject.get(1);

        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualBody = getEmailBodyText(emailText, 28, 1504);
        String actualFooter = getEmailFooterText(emailText, 1505);

        assertThat(actualSender, equalTo(expectedSender));
        assertThat(actualSubject, equalTo("Правила та Умови користування додатком "+app.site+" - будь ласка, збережіть це повідомлення"));
        assertThat(actualBody, equalTo("Вітаємо, "+app.emailsVerificationsFirstName+"! Будь ласка, ознайомтесь з прикріпленим файлом \""+app.site+"_Terms_and_Conditions\", в ньому знаходяться ключові правила користування DiPocket, актуальні ціни та ліміти для транзакцій. Стосовно особистої інформації, просимо Вас ознайомитись з розділом під назвою \"Personal Information\" - ми будемо обробляти будь-яку інформацію, яку ви надаєте нам відповідно до цих умов. Надавши нам інформацію (включаючи будь-які конфіденційні дані), Ви погоджуєтесь на її обробку для цілей, описаних у Договорі, з урахуванням права бути проінформованим про обробку вашої інформації, для виправлення помилок, для відмови у обробці, обмеження обробки або видалення інформації, для доручення копіювати або передавати інформацію за Вашою вказівкою. Якщо Ви приймаєте \"DiPocket_Terms_and_Conditions\", перейдіть за цим посиланням та продовжіть реєстрацію у додатку DiPocket. \"DiPocket_Terms_and_Conditions\" лишатимуться незмінним, доки ми не повідомимо про зміни, надсилаючи нові документи. Зміни будуть вислані принаймні за два місяці, щоб дати можливість ознайомитись із ними та прийняти їх. ВАЖЛИВО: Для прискорення процесу реєстрації можна почати користуватись додатком DiPocket без переходу за посиланням, яке зазначене вище. Але якщо Ви не зробите цього протягом 7 днів з моменту отримання доступу в додаток, Ваш рахунок DiPocket буде заблоковано, до моменту переходу за посиланням, що підтвердить що Ви ознайомились із \"DiPocket_Terms_and_Conditions\". З повагою, Юридичний відділ"));
        assertThat(actualFooter, equalTo(""+app.SITE_REG+" Для Вашого спокою, "+app.site+" UAB авторизований та контролюється Банком Литви, як емітент електронних грошей (#75) Upės str. 23, 08128 Vilnius, LT"));
    }

    @Test
    public void testTacDipocketPL() throws InterruptedException, MessagingException, IOException, SQLException, ClassNotFoundException {
        app.getDbHelper().updateClientLanguageFromDB(app.emailsVerificationsEmail, "3", app.mobile_site);
        postSendTacEmail(app.mobile_site);

        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualSender = senderAndSubject.get(0);
        String actualSubject = senderAndSubject.get(1);

        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualBody = getEmailBodyText(emailText, 28, 1703);
        String actualFooter = getEmailFooterText(emailText, 1704);

        assertThat(actualSender, equalTo(expectedSender));
        assertThat(actualSubject, equalTo("Zasady i Warunki korzystania z aplikacji "+app.site+" - PROSIMY O ZACHOWANIE TEJ WIADOMOŚCI"));
        assertThat(actualBody, equalTo("Witaj "+app.emailsVerificationsFirstName+", Prosimy o zapoznanie się z załączonymi dokumentami: “Warunkami ogólnymi dla klientów indywidualnych DiPocket”, \"Tabelą Limitów\" oraz \"Tabelą Prowizji i Opłat\". Prosimy o uważne przeczytanie zawartych w nich warunków oraz aktualnego cennika i limitów transakcji. W odniesieniu do Informacji osobowych, prosimy o zapoznanie się z sekcją Warunków ogólnych, zatytułowaną „Informacje osobowe” – przetwarzamy wszelkie powierzone nam dane zgodnie z zapisami tej sekcji. Przekazanie danych jest jednoczesnym wyrażeniem zgody na ich przetwarzanie, w tym na przetwarzanie danych poufnych do celów opisanych w Umowie, z zastrzeżeniem szeregu praw, o których użytkownik został poinformowany w aspektach: sposobu przetwarzania Informacji, poprawienia błędów, całkowitej lub częściowej odmowie możliwości przetwarzania, usunięcia informacji lub nakazania nam skopiowania lub transferu danych zgodnie z twoją dyspozycją. Jeżeli akceptujesz “Ogólne warunki dla klientów indywidualnych DiPocket” kliknij w ten link aby kontynuować proces rejestracji w aplikacji mobilnej DiPocket. “Ogólne warunki dla klientów indywidualnych DiPocket” mogą ulec zmianie jedynie, jeśli użytkownicy zostaną powiadomieni z co najmniej dwumiesięcznym wyprzedzeniem. W przypadku niezgłoszenia braku akceptacji, uznamy że akceptujesz nowe regulacje. WAŻNE: Aby przyspieszyć rejestrację, możesz zacząć korzystać z aplikacji DiPocket bez klikania w link zamieszczony powyżej. Jednakże w przypadku, gdy nie klikniesz w link w ciągu 7 dni, Twoje konto DiPocket zostanie tymczasowo zablokowane do momentu zaakceptowania „Ogólnych warunków korzystania z aplikacji DiPocket”. Z wyrazami szacunku, Dział Prawny"));
        assertThat(actualFooter, equalTo(""+app.SITE_REG+" "+app.site+" UAB, autoryzowana Instytucja Pieniądza Elektronicznego, podlegająca nadzorowi Banku Litwy (numer licencji 75) | Licencjonowana przez Mastercard do działania na Europejskim Obszarze Gospodarczego Upės g. 23, 08128 Vilnius, LT"));
    }

    @Test
    public void testTacDipocketRU() throws InterruptedException, MessagingException, IOException, SQLException, ClassNotFoundException {
        app.getDbHelper().updateClientLanguageFromDB(app.emailsVerificationsEmail, "4", app.mobile_site);
        postSendTacEmail(app.mobile_site);

        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualSender = senderAndSubject.get(0);
        String actualSubject = senderAndSubject.get(1);

        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualBody = getEmailBodyText(emailText, 28, 1490);
        String actualFooter = getEmailFooterText(emailText, 1491);

        assertThat(actualSender, equalTo(expectedSender));
        assertThat(actualSubject, equalTo("Условия пользования приложением "+app.site+" - пожалуйста, сохраните это сообщение"));
        assertThat(actualBody, equalTo("Здравствуйте, "+app.emailsVerificationsFirstName+"! Ознакомьтесь с прикрепленным файлом \""+app.site+"_Terms_and_Conditions\", в нём вы найдете ключевые правила использования "+app.site+", актуальные цены и тарифы. Относительно личных данных, просьба обратить внимание на раздел \"Personal Information\" в \""+app.site+"_Terms_and_Conditions\", поскольку вся личная информация будет обрабатываться согласно этим условиям. Предоставляя нам информацию (включая конфиденциальную), вы даёте согласие на ее обработку в целях, описанных в Договоре. Вы имеете право быть в курсе использования данных, чтобы иметь возможность исправить ошибки, чтобы отказаться от обработки или остановить обработку, или удалить информацию или проинструктировать нас о копировании или передачи информации по Вашему указанию. Если Вы принимаете \"Условия пользования приложением "+app.site+"\",  перейдите по этой ссылке и закончите регистрацию в приложении, если еще не закончили. \""+app.site+"_Terms_and_Conditions\" остаются неизменными до тех пор, пока не будет уведомлено об обратном. Уведомление об изменении условий будет выслано, по меньшей мере, за два месяца, чтобы дать Вам возможность ознакомится и принять их. ВАЖНО: можно закончить регистрацию без перехода по ссылке выше. Но, если вы не сделаете этого в течение 7 дней после получения доступа к приложению, учетная запись в DiPocket будет заблокирована до тех пор, пока Вы не перейдете по ссылке, принимая таким образом \""+app.site+"_Terms_and_Conditions\". С уважением, Юридический отдел"));
        assertThat(actualFooter, equalTo(""+app.SITE_REG+" Для вашего спокойствия, "+app.site+" UAB авторизован и контролируется Банком Литвы как эмитент электронных денег (#75) Upės str. 23, 08128 Vilnius, LT"));
    }

    @Test
    public void testTacDiscontuEN() throws InterruptedException, MessagingException, IOException, SQLException, ClassNotFoundException {
        app.getDbHelper().updateClientLanguageFromDB(app.emailsVerificationsEmail, "1", app.mobile_site_discontu);
        postSendTacEmail(app.mobile_site_discontu);

        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualSender = senderAndSubject.get(0);
        String actualSubject = senderAndSubject.get(1);

        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualBody = getEmailBodyText(emailText, 28, 1624);
        String actualFooter = getEmailFooterText(emailText, 1625);

        assertThat(actualSender, equalTo(expectedDiscontuSender));
        assertThat(actualSubject, equalTo(""+app.site_discontu+" Terms and Conditions - PLEASE DO NOT DISCARD"));
        assertThat(actualBody, equalTo("Dear "+app.emailsVerificationsFirstName+", Please find attached \""+app.site_discontu+"_Terms_and_Conditions\" (the \"T&Cs\"). It is important that you familiarise yourself with these documents and in particular that you review in detail \""+app.site_discontu+"_at_a_Glance\", which summarises the key clauses applicable to your "+app.site_discontu+" account and also includes our current pricing and transaction limits. With regard to Personal Information, we ask you to please read the section in the T&C’s titled 'Personal Information' - we will process any Information you provide to us according those terms. By providing it to us, you are agreeing for us to process it, including any sensitive data for the purposes described in the Agreement subject to a number of rights you have to be informed about how your Information is processed, to correct any errors, to object to any processing, to restrict processing or have Information erased or to instruct us to copy or transfer Information as you direct. If you accept the T&Cs, please click on this link and proceed with the registration process through discontu mobile App. The T&Cs may only be changed upon 2 months notice to you, following which, if you have not objected, you will be deemed to have accepted the new terms. IMPORTANT: to expedite registration you may choose to start using the App even if you have not clicked on the link above. However, if you do not click on it within a week of accessing the App, your discontu account will be temporarily blocked until such time as you have clicked on the link and confirmed your agreement to having read and accepted the T&C’s. With kind regards, Legal Team"));
        assertThat(actualFooter, equalTo(""+app.SITE_REG+" "+app.site_discontu+" is powered by DiPocket UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT"));
    }

    @Test
    public void testTacDiscontuPL() throws InterruptedException, MessagingException, IOException, SQLException, ClassNotFoundException {
        app.getDbHelper().updateClientLanguageFromDB(app.emailsVerificationsEmail, "3", app.mobile_site_discontu);
        postSendTacEmail(app.mobile_site_discontu);

        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualSender = senderAndSubject.get(0);
        String actualSubject = senderAndSubject.get(1);

        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualBody = getEmailBodyText(emailText, 28, 1750);
        String actualFooter = getEmailFooterText(emailText, 1751);

        assertThat(actualSender, equalTo(expectedDiscontuSender));
        assertThat(actualSubject, equalTo("Zasady i Warunki korzystania z aplikacji "+app.site_discontu+" - PROSIMY O ZACHOWANIE TEJ WIADOMOŚCI"));
        assertThat(actualBody, equalTo("Witaj "+app.emailsVerificationsFirstName+", Prosimy o zapoznanie się z załączonym plikiem “Warunki ogólne dla klientów indywidualnych "+app.site_discontu+"”. Prosimy o zwrócenie szczególnej uwagi na część “Najważniejsze informacje o "+app.site_discontu+"”, w której znajduje się podsumowanie kluczowych zasad korzystania z konta "+app.site_discontu+", aktualny cennik oraz limity transakcji. W odniesieniu do Informacji osobowych, prosimy o zapoznanie się z sekcją Warunków ogólnych, zatytułowaną „Informacje osobowe” – przetwarzamy wszelkie powierzone nam dane zgodnie z zapisami tej sekcji. Przekazanie danych jest jednoczesnym wyrażeniem zgody na ich przetwarzanie, w tym na przetwarzanie danych poufnych do celów opisanych w Umowie, z zastrzeżeniem szeregu praw, o których użytkownik został poinformowany w aspektach: sposobu przetwarzania Informacji, poprawienia błędów, całkowitej lub częściowej odmowie możliwości przetwarzania, usunięcia informacji lub nakazania nam skopiowania lub transferu danych zgodnie z twoją dyspozycją. Jeżeli akceptujesz “Ogólne warunki dla klientów indywidualnych discontu” kliknij w ten link aby kontynuować proces rejestracji w aplikacji mobilnej discontu. “Ogólne warunki dla klientów indywidualnych discontu” mogą ulec zmianie jedynie, jeśli użytkownicy zostaną powiadomieni z co najmniej dwumiesięcznym wyprzedzeniem. W przypadku niezgłoszenia braku akceptacji, uznamy że akceptujesz nowe regulacje. WAŻNE: Aby przyspieszyć rejestrację, możesz zacząć korzystać z aplikacji discontu bez klikania w link zamieszczony powyżej. Jednakże w przypadku, gdy nie klikniesz w link w ciągu 7 dni, Twoje konto discontu zostanie tymczasowo zablokowane do momentu zaakceptowania „Ogólnych warunków korzystania z aplikacji discontu”. Z wyrazami szacunku, Dział Prawny"));
        assertThat(actualFooter, equalTo(""+app.SITE_REG+" "+app.site_discontu+" dostarcza DiPocket UAB, autoryzowana Instytucja Pieniądza Elektronicznego, podlegająca nadzorowi Banku Litwy (numer licencji 75) | Licencjonowana przez Mastercard do działania na Europejskim Obszarze Gospodarczego Upės g. 23, 08128 Vilnius, LT"));
    }

    @Test
    public void testTacPlayITEN() throws InterruptedException, MessagingException, IOException, SQLException, ClassNotFoundException {
        app.getDbHelper().updateClientLanguageFromDB(app.emailsVerificationsEmail, "1", app.mobile_site_playIt);
        postSendTacEmail(app.mobile_site_playIt);

        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualSender = senderAndSubject.get(0);
        String actualSubject = senderAndSubject.get(1);

        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualBody = getEmailBodyText(emailText, 26, 1619);
        String actualFooter = getEmailFooterText(emailText, 1620);

        assertThat(actualSender, equalTo("PlayIT Card <playitcard@dipocket.org>"));
        assertThat(actualSubject, equalTo(""+app.site_PlayIT+" Terms and Conditions - PLEASE DO NOT DISCARD"));
        assertThat(actualBody, equalTo("Dear "+app.emailsVerificationsFirstName+", Please find attached \""+app.site_PlayIT+"_Terms_and_Conditions\" (the \"T&Cs\"). It is important that you familiarise yourself with these documents and in particular that you review in detail \"E-wallet terms of usage\", which summarises the key clauses applicable to your "+app.site_PlayIT+" account and also includes our current pricing and transaction limits. With regard to Personal Information, we ask you to please read the section in the T&C’s titled 'Personal Information' - we will process any Information you provide to us according those terms. By providing it to us, you are agreeing for us to process it, including any sensitive data for the purposes described in the Agreement subject to a number of rights you have to be informed about how your Information is processed, to correct any errors, to object to any processing, to restrict processing or have Information erased or to instruct us to copy or transfer Information as you direct. If you accept the T&Cs, please  click on this link  and proceed with the registration process through PlayIT mobile App. The T&Cs may only be changed upon 2 months notice to you, following which, if you have not objected, you will be deemed to have accepted the new terms. IMPORTANT: to expedite registration you may choose to start using the App even if you have not clicked on the link above. However, if you do not click on it within a week of accessing the App, your "+app.site_PlayIT+" account will be temporarily blocked until such time as you have clicked on the link and confirmed your agreement to having read and accepted the T&C’s. With kind regards, Legal Team"));
        assertThat(actualFooter, equalTo(""+app.SITE_REG+" "+app.site_PlayIT+" is powered by DiPocket UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT"));
    }

    @Test
    public void testTacPlayITHU() throws InterruptedException, MessagingException, IOException, SQLException, ClassNotFoundException {
        app.getDbHelper().updateClientLanguageFromDB(app.emailsVerificationsEmail, "5", app.mobile_site_playIt);
        postSendTacEmail(app.mobile_site_playIt);

        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualSender = senderAndSubject.get(0);
        String actualSubject = senderAndSubject.get(1);

        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualBody = getEmailBodyText(emailText, 26, 1907);
        String actualFooter = getEmailFooterText(emailText, 1908);

        assertThat(actualSender, equalTo("PlayIT Card <playitcard@dipocket.org>"));
        assertThat(actualSubject, equalTo(""+app.site_PlayIT+" használatának feltételei – KÉRJÜK, NE DOBJA EL"));
        assertThat(actualBody, equalTo("Kedves "+app.emailsVerificationsFirstName+", Lásd a csatolt „"+app.site_PlayIT+"_Terms_and_Conditions” (a „T&Cs”) dokumentumot. Fontos, hogy megismerkedjen ezekkel a dokumentumokkal és különösen fontos, hogy részletesen áttekintse az 'E-pénztárca használati feltételei' címűt, amely összegezi az Ön PlayIT fiókjára vonatkozó legfontosabb tudnivalókat, és tartalmazza az aktuális árainkat és a tranzakciós limiteket is. A Személyi adatokkal kapcsolatban kérjük, hogy olvassa el a Használati feltételek 'Személyi adatok' szakaszát – az ebben foglalt feltételek szerint kezelünk minden Ön által megadott információt. Azáltal, hogy információt szolgáltat nekünk, Ön beleegyezik abba, hogy azokat – beleértve a bizalmas adatokat – kezeljük és felhasználjuk a Megállapodásban leírt célokra, és amelyekkel kapcsolatban Ön számos jogosultsággal rendelkezik, úgy mint tájékoztatásra az Ön adatainak kezelési módjáról, valamint jog a hibák kijavítására, a kezelés elutasítására, a kezelés korlátozására, az adatai töröltetésére, vagy utasítani bennünket, hogy másoljuk vagy továbbítsuk adatait az Ön utasításai szerint. Ha elfogadja a Használati feltételeket, kérjük, kattintson erre  a hivatkozásra , és folytassa a regisztrációt a PlayIT mobilalkalmazás segítségével. A Használati feltételek módosítása csak 2 hónappal korábban, előzetesen megküldött értesítés után lehetséges, amely 2 hónap lejártával, ha nem kifogásolta, úgy tekintendő, hogy Ön az új feltételeket elfogadta. FONTOS: a regisztráció felgyorsítása érdekében választhatja, hogy megkezdi az alkalmazás használatát, még ha nem is kattintott a fenti hivatkozásra. Ha azonban nem kattintasz rá az alkalmazás megnyitását követő egy héten belül, akkor a PlayIT fiókod ideiglenesen blokkolva lesz mindaddig, amíg rá nem kattintasz a hivatkozásra, és meg nem erősítetted a megállapodást arról, hogy elolvastad és elfogadtad a Használati feltételeket. Üdvözlettel, Jogi csapat"));
        assertThat(actualFooter, equalTo(""+app.SITE_REG+" Megnyugtatásul tájékoztatjuk, hogy a "+app.site_PlayIT+" Kártya számládat a DiPocket UAB kezeli, mely vállalatot a Litván Nemzeti Bank elektronikus pénzintézetenként (# 75) engedélyezett és felügyel Upės str. 23, 08128 Vilnius, LT"));
    }

    @Test
    public void testTacUpAndGoEN() throws InterruptedException, MessagingException, IOException, SQLException, ClassNotFoundException {
        app.getDbHelper().updateClientLanguageFromDB(app.emailsVerificationsEmail, "1", app.mobile_site_upAndGo);
        postSendTacEmail(app.mobile_site_upAndGo);

        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualSender = senderAndSubject.get(0);
        String actualSubject = senderAndSubject.get(1);

        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualBody = getEmailBodyText(emailText, 29, 1630);
        String actualFooter = getEmailFooterText(emailText, 1631);

        //assertThat(actualSender, equalTo(expectedUpAndGoSender));
        assertThat(actualSubject, equalTo(""+app.site_upAndGo+" Terms and Conditions - PLEASE DO NOT DISCARD"));
        assertThat(actualBody, equalTo("Dear "+app.emailsVerificationsFirstName+", Please find attached \""+app.site_upAndGo+"_Terms_and_Conditions\" (the \"T&Cs\"). It is important that you familiarise yourself with these documents and in particular that you review in detail \"up and go_at_a_Glance\", which summarises the key clauses applicable to your up and go account and also includes our current pricing and transaction limits. With regard to Personal Information, we ask you to please read the section in the T&C’s titled 'Personal Information' - we will process any Information you provide to us according those terms. By providing it to us, you are agreeing for us to process it, including any sensitive data for the purposes described in the Agreement subject to a number of rights you have to be informed about how your Information is processed, to correct any errors, to object to any processing, to restrict processing or have Information erased or to instruct us to copy or transfer Information as you direct. If you accept the T&Cs, please click on this link and proceed with the registration process through up and go mobile App. The T&Cs may only be changed upon 2 months notice to you, following which, if you have not objected, you will be deemed to have accepted the new terms. IMPORTANT: to expedite registration you may choose to start using the App even if you have not clicked on the link above. However, if you do not click on it within a week of accessing the App, your up and go account will be temporarily blocked until such time as you have clicked on the link and confirmed your agreement to having read and accepted the T&C’s. With kind regards, Legal Team"));
        assertThat(actualFooter, equalTo(""+app.SITE_REG+" "+app.site_upAndGo+" is powered by DiPocket UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT"));
    }

    @Test
    public void testTacUpAndGoUA() throws InterruptedException, MessagingException, IOException, SQLException, ClassNotFoundException {
        app.getDbHelper().updateClientLanguageFromDB(app.emailsVerificationsEmail, "2", app.mobile_site_upAndGo);
        postSendTacEmail(app.mobile_site_upAndGo);

        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualSender = senderAndSubject.get(0);
        String actualSubject = senderAndSubject.get(1);

        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualBody = getEmailBodyText(emailText, 29, 1576);
        String actualFooter = getEmailFooterText(emailText, 1577);

        //assertThat(actualSender, equalTo(expectedUpAndGoSender));
        assertThat(actualSubject, equalTo("Правила та Умови користування додатком "+app.site_upAndGo+" - будь ласка, збережіть це повідомлення"));
        assertThat(actualBody, equalTo("Вітаємо, "+app.emailsVerificationsFirstName+"! Будь ласка, ознайомтесь з прикріпленим файлом \"up and go_Terms_and_Conditions\". Будь ласка, зверніть увагу на частину \"up and go_at_a_Glance\", в ньому знаходяться ключові правила користування up and go, актуальні ціни та ліміти для транзакцій. Стосовно особистої інформації, просимо Вас ознайомитись з розділом під назвою \"Personal Information\" - ми будемо обробляти будь-яку інформацію, яку ви надаєте нам відповідно до цих умов. Надавши нам інформацію (включаючи будь-які конфіденційні дані), Ви погоджуєтесь на її обробку для цілей, описаних у Договорі, з урахуванням права бути проінформованим про обробку вашої інформації, для виправлення помилок, для відмови у обробці, обмеження обробки або видалення інформації, для доручення копіювати або передавати інформацію за Вашою вказівкою. Якщо Ви приймаєте \"up and go_Terms_and_Conditions\", перейдіть за цим посиланням та продовжіть реєстрацію у додатку up and go. \"up and go_Terms_and_Conditions\" лишатимуться незмінним, доки ми не повідомимо про зміни, надсилаючи нові документи. Зміни будуть вислані принаймні за два місяці, щоб дати можливість ознайомитись із ними та прийняти їх. ВАЖЛИВО: Для прискорення процесу реєстрації можна почати користуватись додатком up and go без переходу за посиланням, яке зазначене вище. Але якщо Ви не зробите цього протягом 7 днів з моменту отримання доступу в додаток, Ваш рахунок up and go буде заблоковано, до моменту переходу за посиланням, що підтвердить що Ви ознайомились із \"up and go_Terms_and_Conditions\". З повагою, Юридичний відділ"));
        assertThat(actualFooter, equalTo(""+app.SITE_REG+" Для Вашого спокою, "+app.site_upAndGo+" працює при підтримці DiPocket UAB, що авторизований та контролюється Банком Литви, як емітент електронних грошей (#75) Upės str. 23, 08128 Vilnius, LT"));
    }

    @Test
    public void testTacUpAndGoPL() throws InterruptedException, MessagingException, IOException, SQLException, ClassNotFoundException {
        app.getDbHelper().updateClientLanguageFromDB(app.emailsVerificationsEmail, "3", app.mobile_site_upAndGo);
        postSendTacEmail(app.mobile_site_upAndGo);

        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualSender = senderAndSubject.get(0);
        String actualSubject = senderAndSubject.get(1);

        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualBody = getEmailBodyText(emailText, 29, 1760);
        String actualFooter = getEmailFooterText(emailText, 1761);

        //assertThat(actualSender, equalTo(expectedUpAndGoSender));
        assertThat(actualSubject, equalTo("Zasady i Warunki korzystania z aplikacji "+app.site_upAndGo+" - PROSIMY O ZACHOWANIE TEJ WIADOMOŚCI"));
        assertThat(actualBody, equalTo("Witaj "+app.emailsVerificationsFirstName+", Prosimy o zapoznanie się z załączonym plikiem “Warunki ogólne dla klientów indywidualnych up and go”. Prosimy o zwrócenie szczególnej uwagi na część “Najważniejsze informacje o up and go”, w której znajduje się podsumowanie kluczowych zasad korzystania z konta up and go, aktualny cennik oraz limity transakcji. W odniesieniu do Informacji osobowych, prosimy o zapoznanie się z sekcją Warunków ogólnych, zatytułowaną „Informacje osobowe” – przetwarzamy wszelkie powierzone nam dane zgodnie z zapisami tej sekcji. Przekazanie danych jest jednoczesnym wyrażeniem zgody na ich przetwarzanie, w tym na przetwarzanie danych poufnych do celów opisanych w Umowie, z zastrzeżeniem szeregu praw, o których użytkownik został poinformowany w aspektach: sposobu przetwarzania Informacji, poprawienia błędów, całkowitej lub częściowej odmowie możliwości przetwarzania, usunięcia informacji lub nakazania nam skopiowania lub transferu danych zgodnie z twoją dyspozycją. Jeżeli akceptujesz “Ogólne warunki dla klientów indywidualnych up and go” kliknij w ten link aby kontynuować proces rejestracji w aplikacji mobilnej up and go. “Ogólne warunki dla klientów indywidualnych up and go” mogą ulec zmianie jedynie, jeśli użytkownicy zostaną powiadomieni z co najmniej dwumiesięcznym wyprzedzeniem. W przypadku niezgłoszenia braku akceptacji, uznamy że akceptujesz nowe regulacje. WAŻNE: Aby przyspieszyć rejestrację, możesz zacząć korzystać z aplikacji up and go bez klikania w link zamieszczony powyżej. Jednakże w przypadku, gdy nie klikniesz w link w ciągu 7 dni, Twoje konto up and go zostanie tymczasowo zablokowane do momentu zaakceptowania „Ogólnych warunków korzystania z aplikacji up and go”. Z wyrazami szacunku, Dział Prawny"));
        assertThat(actualFooter, equalTo(""+app.SITE_REG+" "+app.site_upAndGo+" dostarcza DiPocket UAB, autoryzowana Instytucja Pieniądza Elektronicznego, podlegająca nadzorowi Banku Litwy (numer licencji 75) | Licencjonowana przez Mastercard do działania na Europejskim Obszarze Gospodarczego Upės g. 23, 08128 Vilnius, LT"));
    }

    @Test
    public void testTacUpAndGoRU() throws InterruptedException, MessagingException, IOException, SQLException, ClassNotFoundException {
        app.getDbHelper().updateClientLanguageFromDB(app.emailsVerificationsEmail, "4", app.mobile_site_upAndGo);
        postSendTacEmail(app.mobile_site_upAndGo);

        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualSender = senderAndSubject.get(0);
        String actualSubject = senderAndSubject.get(1);

        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualBody = getEmailBodyText(emailText, 29, 1551);
        String actualFooter = getEmailFooterText(emailText, 1552);

        //assertThat(actualSender, equalTo(expectedUpAndGoSender));
        assertThat(actualSubject, equalTo("Условия пользования приложением "+app.site_upAndGo+" - пожалуйста, сохраните это сообщение"));
        assertThat(actualBody, equalTo("Здравствуйте, "+app.emailsVerificationsFirstName+"! Ознакомьтесь с прикрепленным файлом \""+app.site_upAndGo+"_Terms_and_Conditions\". Обратите внимание на документ \""+app.site_upAndGo+"_at_a_Glance\", в нём вы найдете ключевые правила пользования "+app.site_upAndGo+", актуальные цены и тарифы. Относительно личных данных, просьба обратить внимание на раздел \"Personal Information\" в \""+app.site_upAndGo+"_Terms_and_Conditions\", поскольку вся личная информация будет обрабатываться согласно этим условиям. Предоставляя нам информацию (включая конфиденциальную), вы даёте согласие на ее обработку в целях, описанных в Договоре. Вы имеете право быть в курсе использования данных, чтобы иметь возможность исправить ошибки, чтобы отказаться от обработки или остановить обработку, или удалить информацию или проинструктировать нас о копировании или передачи информации по Вашему указанию. Если Вы принимаете \"Условия пользования приложением "+app.site_upAndGo+"\",  перейдите по этой ссылке и закончите регистрацию в приложении, если еще не закончили. \""+app.site_upAndGo+"_Terms_and_Conditions\" остаются неизменными до тех пор, пока не будет уведомлено об обратном. Уведомление об изменении условий будет выслано, по меньшей мере, за два месяца, чтобы дать Вам возможность ознакомится и принять их. ВАЖНО: можно закончить регистрацию без перехода по ссылке выше. Но, если вы не сделаете этого в течение 7 дней после получения доступа к приложению, учетная запись в up and go будет заблокирована до тех пор, пока Вы не перейдете по ссылке, принимая таким образом \""+app.site_upAndGo+"_Terms_and_Conditions\". С уважением, Юридический отдел"));
        assertThat(actualFooter, equalTo(""+app.SITE_REG+" Для вашего спокойствия, "+app.site_upAndGo+" осуществляет деятельность при поддержке DiPocket UAB, который авторизован и контролируется Банком Литвы как эмитент электронных денег (#75) Upės str. 23, 08128 Vilnius, LT"));
    }

    @Test(enabled = false)//bug Tac Snow Attack EN email body is not correct
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

    @Test(enabled = false)// приходит письмо Регистрация виртуальной карты - подтвердите свой e-mail
    public void testTacSocexo() throws InterruptedException, MessagingException, IOException, SQLException, ClassNotFoundException {
        //app.getDbHelper().updateClientLanguageFromDB(app.emailsVerificationsEmail, "1", "SODEXO");
        postSendTacEmail("SODEXO");

        String emailSender =  EmailVerificationHelper.getEmailSender(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailBody = getEmailBodyText(emailText, 29, 1551);
        String emailFooter = getEmailFooterText(emailText, 1552);

        assertThat(emailSender, equalTo(expectedUpAndGoSender));
        assertThat(emailBody, equalTo(""));
        assertThat(emailFooter, equalTo(""));
    }

    @Test(enabled = false)// 400 error
    public void testTacTelenorEN() throws InterruptedException, MessagingException, IOException, SQLException, ClassNotFoundException {
        app.getDbHelper().updateClientLanguageFromDB(app.emailsVerificationsEmail, "1", app.telenorSite);
        postSendTacTelenorEmail(app.telenorSite);

        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualSender = senderAndSubject.get(0);
        String actualSubject = senderAndSubject.get(1);

        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualBody = getEmailBodyText(emailText, 29, 1630);
        String actualFooter = getEmailFooterText(emailText, 1631);

        //assertThat(actualSender, equalTo(expectedUpAndGoSender));
        assertThat(actualSubject, equalTo(""+app.site_upAndGo+" Terms and Conditions - PLEASE DO NOT DISCARD"));
        assertThat(actualBody, equalTo("Dear "+app.emailsVerificationsFirstName+", Please find attached Terms_and_Conditions\" (the \"T&Cs\"). It is important that you familiarise yourself with these documents and in particular that you review in detail \"up and go_at_a_Glance\", which summarises the key clauses applicable to your up and go account and also includes our current pricing and transaction limits. With regard to Personal Information, we ask you to please read the section in the T&C’s titled 'Personal Information' - we will process any Information you provide to us according those terms. By providing it to us, you are agreeing for us to process it, including any sensitive data for the purposes described in the Agreement subject to a number of rights you have to be informed about how your Information is processed, to correct any errors, to object to any processing, to restrict processing or have Information erased or to instruct us to copy or transfer Information as you direct. If you accept the T&Cs, please click on this link and proceed with the registration process through up and go mobile App. The T&Cs may only be changed upon 2 months notice to you, following which, if you have not objected, you will be deemed to have accepted the new terms. IMPORTANT: to expedite registration you may choose to start using the App even if you have not clicked on the link above. However, if you do not click on it within a week of accessing the App, your up and go account will be temporarily blocked until such time as you have clicked on the link and confirmed your agreement to having read and accepted the T&C’s. With kind regards, Legal Team"));
        assertThat(actualFooter, equalTo(""+app.SITE_REG+" is powered by DiPocket UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT"));
    }
}