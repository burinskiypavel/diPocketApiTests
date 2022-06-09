package tests.emailsVerification.tac;

import appmanager.EmailVerificationHelper;
import appmanager.Language;
import base.TestBase;
import com.cs.dipocketback.base.data.Site;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import javax.mail.MessagingException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
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
    String expectedPlayITSender = "PlayIT Card <playitcard@dipocket.org>";
    String expectedSnowAttackSender = "legal.team@dipocket.org";

    public String body(String testEmail, String site){
        return "{\n" +
                "  \"email\": \""+testEmail+"\",\n" +
                "  \"phoneNumber\": \""+app.emailsVerificationsPhoneNumber+"\",\n" +
                "  \"programNickName\": \""+site+"\",\n" +
                "  \"site\": \""+site+"\",\n" +
                "  \"url\": \"google.com\"\n" +
                "}";
    }

    public String telenorTacbody(String testEmail, String site){
        return "{\n" +
                "  \"email\": \""+testEmail+"\",\n" +
                "  \"phoneNumber\": \"string\",\n" +
                "  \"programNickName\": \"string\",\n" +
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
                .body(telenorTacbody(app.emailsVerificationsEmail, site))
                .when()
                .post( "/EmailService/sendTacTelenorEmail?lang=1")
                .then()
                .log().all()
                .statusCode(200);
    }

    @DataProvider
    public Iterator<Object[]> Tac() throws SQLException, ClassNotFoundException {
        List<Object[]> list = new ArrayList<Object[]>();
        //list.add(new Object[] {Site.DIPOCKET.toString(), Language.EN.toString(), Language.EN.getOurId(), app.getDbHelper().getClientIdFromDB2(app.emailsVerificationsEmail, Site.DIPOCKET.toString()), app.emailsVerificationsEmail, app.emailsVerificationsPass, 28, 1523, 1524, expectedSender, ""+app.site+" Terms and Conditions - PLEASE DO NOT DISCARD", "Dear "+app.emailsVerificationsFirstName+", Please find attached \""+app.site+"_Terms_and_Conditions\" (the \"T&Cs\"), Tariff Table and Limits Table. It is important that you familiarise yourself with these documents and in particular with our current pricing and transaction limits. With regard to Personal Information, we ask you to please read the section in the T&C’s titled 'Personal Information' - we will process any Information you provide to us according those terms. By providing it to us, you are agreeing for us to process it, including any sensitive data for the purposes described in the Agreement subject to a number of rights you have to be informed about how your Information is processed, to correct any errors, to object to any processing, to restrict processing or have Information erased or to instruct us to copy or transfer Information as you direct. If you accept the T&Cs, please click on this link and proceed with the registration process through DiPocket mobile App. The T&Cs may only be changed upon 2 months notice to you, following which, if you have not objected, you will be deemed to have accepted the new terms. IMPORTANT: to expedite registration you may choose to start using the App even if you have not clicked on the link above. However, if you do not click on it within a week of accessing the App, your DiPocket account will be temporarily blocked until such time as you have clicked on the link and confirmed your agreement to having read and accepted the T&C’s. With kind regards, Legal Team", ""+app.SITE_REG+" "+app.site+" UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT", Arrays.asList("Limits Table.pdf", "Tariff Table.pdf", "General Terms and Conditions.pdf")});
        //list.add(new Object[] {Site.DIPOCKET.toString(), Language.UK.toString(), Language.UK.getOurId(), app.getDbHelper().getClientIdFromDB2(app.emailsVerificationsEmail, Site.DIPOCKET.toString()), app.emailsVerificationsEmail, app.emailsVerificationsPass, 28, 1504, 1505, expectedSender, "Правила та Умови користування додатком "+app.site+" - будь ласка, збережіть це повідомлення", "Вітаємо, "+app.emailsVerificationsFirstName+"! Будь ласка, ознайомтесь з прикріпленим файлом \""+app.site+"_Terms_and_Conditions\", в ньому знаходяться ключові правила користування DiPocket, актуальні ціни та ліміти для транзакцій. Стосовно особистої інформації, просимо Вас ознайомитись з розділом під назвою \"Personal Information\" - ми будемо обробляти будь-яку інформацію, яку ви надаєте нам відповідно до цих умов. Надавши нам інформацію (включаючи будь-які конфіденційні дані), Ви погоджуєтесь на її обробку для цілей, описаних у Договорі, з урахуванням права бути проінформованим про обробку вашої інформації, для виправлення помилок, для відмови у обробці, обмеження обробки або видалення інформації, для доручення копіювати або передавати інформацію за Вашою вказівкою. Якщо Ви приймаєте \"DiPocket_Terms_and_Conditions\", перейдіть за цим посиланням та продовжіть реєстрацію у додатку DiPocket. \"DiPocket_Terms_and_Conditions\" лишатимуться незмінним, доки ми не повідомимо про зміни, надсилаючи нові документи. Зміни будуть вислані принаймні за два місяці, щоб дати можливість ознайомитись із ними та прийняти їх. ВАЖЛИВО: Для прискорення процесу реєстрації можна почати користуватись додатком DiPocket без переходу за посиланням, яке зазначене вище. Але якщо Ви не зробите цього протягом 7 днів з моменту отримання доступу в додаток, Ваш рахунок DiPocket буде заблоковано, до моменту переходу за посиланням, що підтвердить що Ви ознайомились із \"DiPocket_Terms_and_Conditions\". З повагою, Юридичний відділ", ""+app.SITE_REG+" Для Вашого спокою, "+app.site+" UAB авторизований та контролюється Банком Литви, як емітент електронних грошей (#75) Upės str. 23, 08128 Vilnius, LT", Arrays.asList("Ліміти.pdf", "Тарифи.pdf", "Загальні умови.pdf")});
        //list.add(new Object[] {Site.DIPOCKET.toString(), Language.PL.toString(), Language.PL.getOurId(), app.getDbHelper().getClientIdFromDB2(app.emailsVerificationsEmail, Site.DIPOCKET.toString()), app.emailsVerificationsEmail,  app.emailsVerificationsPass, 28, 1703, 1704, expectedSender, "Zasady i Warunki korzystania z aplikacji "+app.site+" - PROSIMY O ZACHOWANIE TEJ WIADOMOŚCI", "Witaj "+app.emailsVerificationsFirstName+", Prosimy o zapoznanie się z załączonymi dokumentami: “Warunkami ogólnymi dla klientów indywidualnych DiPocket”, \"Tabelą Limitów\" oraz \"Tabelą Prowizji i Opłat\". Prosimy o uważne przeczytanie zawartych w nich warunków oraz aktualnego cennika i limitów transakcji. W odniesieniu do Informacji osobowych, prosimy o zapoznanie się z sekcją Warunków ogólnych, zatytułowaną „Informacje osobowe” – przetwarzamy wszelkie powierzone nam dane zgodnie z zapisami tej sekcji. Przekazanie danych jest jednoczesnym wyrażeniem zgody na ich przetwarzanie, w tym na przetwarzanie danych poufnych do celów opisanych w Umowie, z zastrzeżeniem szeregu praw, o których użytkownik został poinformowany w aspektach: sposobu przetwarzania Informacji, poprawienia błędów, całkowitej lub częściowej odmowie możliwości przetwarzania, usunięcia informacji lub nakazania nam skopiowania lub transferu danych zgodnie z twoją dyspozycją. Jeżeli akceptujesz “Ogólne warunki dla klientów indywidualnych DiPocket” kliknij w ten link aby kontynuować proces rejestracji w aplikacji mobilnej DiPocket. “Ogólne warunki dla klientów indywidualnych DiPocket” mogą ulec zmianie jedynie, jeśli użytkownicy zostaną powiadomieni z co najmniej dwumiesięcznym wyprzedzeniem. W przypadku niezgłoszenia braku akceptacji, uznamy że akceptujesz nowe regulacje. WAŻNE: Aby przyspieszyć rejestrację, możesz zacząć korzystać z aplikacji DiPocket bez klikania w link zamieszczony powyżej. Jednakże w przypadku, gdy nie klikniesz w link w ciągu 7 dni, Twoje konto DiPocket zostanie tymczasowo zablokowane do momentu zaakceptowania „Ogólnych warunków korzystania z aplikacji DiPocket”. Z wyrazami szacunku, Dział Prawny", ""+app.SITE_REG+" "+app.site+" UAB, autoryzowana Instytucja Pieniądza Elektronicznego, podlegająca nadzorowi Banku Litwy (numer licencji 75) | Licencjonowana przez Mastercard do działania na Europejskim Obszarze Gospodarczego Upės g. 23, 08128 Vilnius, LT", Arrays.asList("Tabela Opłat.pdf", "Tabela Limitów.pdf", "Warunki Ogólne dla Klientów Indywidualnych.pdf")});
        //list.add(new Object[] {Site.DIPOCKET.toString(), Language.RU.toString(), Language.RU.getOurId(), app.getDbHelper().getClientIdFromDB2(app.emailsVerificationsEmail, Site.DIPOCKET.toString()), app.emailsVerificationsEmail, app.emailsVerificationsPass, 28, 1490, 1491, expectedSender, "Условия пользования приложением "+app.site+" - пожалуйста, сохраните это сообщение", "Здравствуйте, "+app.emailsVerificationsFirstName+"! Ознакомьтесь с прикрепленным файлом \""+app.site+"_Terms_and_Conditions\", в нём вы найдете ключевые правила использования "+app.site+", актуальные цены и тарифы. Относительно личных данных, просьба обратить внимание на раздел \"Personal Information\" в \""+app.site+"_Terms_and_Conditions\", поскольку вся личная информация будет обрабатываться согласно этим условиям. Предоставляя нам информацию (включая конфиденциальную), вы даёте согласие на ее обработку в целях, описанных в Договоре. Вы имеете право быть в курсе использования данных, чтобы иметь возможность исправить ошибки, чтобы отказаться от обработки или остановить обработку, или удалить информацию или проинструктировать нас о копировании или передачи информации по Вашему указанию. Если Вы принимаете \"Условия пользования приложением "+app.site+"\",  перейдите по этой ссылке и закончите регистрацию в приложении, если еще не закончили. \""+app.site+"_Terms_and_Conditions\" остаются неизменными до тех пор, пока не будет уведомлено об обратном. Уведомление об изменении условий будет выслано, по меньшей мере, за два месяца, чтобы дать Вам возможность ознакомится и принять их. ВАЖНО: можно закончить регистрацию без перехода по ссылке выше. Но, если вы не сделаете этого в течение 7 дней после получения доступа к приложению, учетная запись в DiPocket будет заблокирована до тех пор, пока Вы не перейдете по ссылке, принимая таким образом \""+app.site+"_Terms_and_Conditions\". С уважением, Юридический отдел", ""+app.SITE_REG+" Для вашего спокойствия, "+app.site+" UAB авторизован и контролируется Банком Литвы как эмитент электронных денег (#75) Upės str. 23, 08128 Vilnius, LT", Arrays.asList("Лимиты.pdf", "Тарифы.pdf", "Общие условия.pdf")});
        //list.add(new Object[] {Site.DISCONTU.toString(), Language.EN.toString(), Language.EN.getOurId(), app.getDbHelper().getClientIdFromDB2(app.emailsVerificationsEmail, Site.DISCONTU.toString()), app.emailsVerificationsEmail, app.emailsVerificationsPass, 28, 1624, 1625, expectedDiscontuSender, ""+app.site_discontu+" Terms and Conditions - PLEASE DO NOT DISCARD", "Dear "+app.emailsVerificationsFirstName+", Please find attached \""+app.site_discontu+"_Terms_and_Conditions\" (the \"T&Cs\"). It is important that you familiarise yourself with these documents and in particular that you review in detail \""+app.site_discontu+"_at_a_Glance\", which summarises the key clauses applicable to your "+app.site_discontu+" account and also includes our current pricing and transaction limits. With regard to Personal Information, we ask you to please read the section in the T&C’s titled 'Personal Information' - we will process any Information you provide to us according those terms. By providing it to us, you are agreeing for us to process it, including any sensitive data for the purposes described in the Agreement subject to a number of rights you have to be informed about how your Information is processed, to correct any errors, to object to any processing, to restrict processing or have Information erased or to instruct us to copy or transfer Information as you direct. If you accept the T&Cs, please click on this link and proceed with the registration process through discontu mobile App. The T&Cs may only be changed upon 2 months notice to you, following which, if you have not objected, you will be deemed to have accepted the new terms. IMPORTANT: to expedite registration you may choose to start using the App even if you have not clicked on the link above. However, if you do not click on it within a week of accessing the App, your discontu account will be temporarily blocked until such time as you have clicked on the link and confirmed your agreement to having read and accepted the T&C’s. With kind regards, Legal Team", ""+app.SITE_REG+" "+app.site_discontu+" is powered by DiPocket UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT", Arrays.asList("E-wallet terms of usage.pdf", "General Terms and Conditions.pdf")});
        list.add(new Object[] {Site.DISCONTU.toString(), Language.PL.toString(), Language.PL.getOurId(), app.getDbHelper().getClientIdFromDB2(app.emailsVerificationsEmail, Site.DISCONTU.toString()), app.emailsVerificationsEmail, app.emailsVerificationsPass, 28, 1750, 1751, expectedDiscontuSender, "Zasady i Warunki korzystania z aplikacji "+app.site_discontu+" - PROSIMY O ZACHOWANIE TEJ WIADOMOŚCI", "Witaj "+app.emailsVerificationsFirstName+", Prosimy o zapoznanie się z załączonym plikiem “Warunki ogólne dla klientów indywidualnych "+app.site_discontu+"”. Prosimy o zwrócenie szczególnej uwagi na część “Najważniejsze informacje o "+app.site_discontu+"”, w której znajduje się podsumowanie kluczowych zasad korzystania z konta "+app.site_discontu+", aktualny cennik oraz limity transakcji. W odniesieniu do Informacji osobowych, prosimy o zapoznanie się z sekcją Warunków ogólnych, zatytułowaną „Informacje osobowe” – przetwarzamy wszelkie powierzone nam dane zgodnie z zapisami tej sekcji. Przekazanie danych jest jednoczesnym wyrażeniem zgody na ich przetwarzanie, w tym na przetwarzanie danych poufnych do celów opisanych w Umowie, z zastrzeżeniem szeregu praw, o których użytkownik został poinformowany w aspektach: sposobu przetwarzania Informacji, poprawienia błędów, całkowitej lub częściowej odmowie możliwości przetwarzania, usunięcia informacji lub nakazania nam skopiowania lub transferu danych zgodnie z twoją dyspozycją. Jeżeli akceptujesz “Ogólne warunki dla klientów indywidualnych discontu” kliknij w ten link aby kontynuować proces rejestracji w aplikacji mobilnej discontu. “Ogólne warunki dla klientów indywidualnych discontu” mogą ulec zmianie jedynie, jeśli użytkownicy zostaną powiadomieni z co najmniej dwumiesięcznym wyprzedzeniem. W przypadku niezgłoszenia braku akceptacji, uznamy że akceptujesz nowe regulacje. WAŻNE: Aby przyspieszyć rejestrację, możesz zacząć korzystać z aplikacji discontu bez klikania w link zamieszczony powyżej. Jednakże w przypadku, gdy nie klikniesz w link w ciągu 7 dni, Twoje konto discontu zostanie tymczasowo zablokowane do momentu zaakceptowania „Ogólnych warunków korzystania z aplikacji discontu”. Z wyrazami szacunku, Dział Prawny", ""+app.SITE_REG+" "+app.site_discontu+" dostarcza DiPocket UAB, autoryzowana Instytucja Pieniądza Elektronicznego, podlegająca nadzorowi Banku Litwy (numer licencji 75) | Licencjonowana przez Mastercard do działania na Europejskim Obszarze Gospodarczego Upės g. 23, 08128 Vilnius, LT", Arrays.asList("Warunki mające zastosowanie do portfela elektronicznego.pdf", "Warunki Ogólne dla Klientów Indywidualnych.pdf")});
//        list.add(new Object[] {Site.PLAYIT.toString(), Language.EN.toString(), Language.EN.getOurId(), app.getDbHelper().getClientIdFromDB2(app.emailsVerificationsEmail, app.mobile_site_playIt), app.emailsVerificationsEmail, app.emailsVerificationsPass, 0, 396, 397, expectedPlayITSender, ""+app.site_PlayIT+" Terms and Conditions - PLEASE DO NOT DISCARD", "Dear "+app.emailsVerificationsFirstName+", Please find attached the section of "+app.site_PlayIT+" Terms and Conditions (the “T&Cs”) regulating Supervised accounts. It is the same that you have already agreed to as part of the T&Cs, but we want to draw your attention on it now that you will start using a Supervised account since it contains important provisions on the Supervisor’s role and responsibilities. With kind regards, Legal Team", ""+app.SITE_REG+" "+app.site_PlayIT+" is powered by DiPocket UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT", "Supervised Accounts T&Cs.pdf"});
//        list.add(new Object[] {Site.PLAYIT.toString(), Language.HU.toString(), Language.HU.getOurId(), app.getDbHelper().getClientIdFromDB2(app.emailsVerificationsEmail, app.mobile_site_playIt), app.emailsVerificationsEmail, app.emailsVerificationsPass, 0, 247, 248, expectedPlayITSender, ""+app.site_PlayIT+" használatának feltételei – KÉRJÜK, NE DOBJA EL", "Kedves "+app.emailsVerificationsFirstName+", Csatolva találja \"A "+app.site_PlayIT+" alkalmazás felügyelt számlák használati feltételei\". Regisztrációkor már elfogadta ezeket a feltételeket, de emlékeztetni szeretnénk a részletekre, mielőtt ezt a funkciót használná. Üdvözlettel, Jogi csapat", ""+app.SITE_REG+" Megnyugtatásul tájékoztatjuk, hogy a "+app.site_PlayIT+" Kártya számládat a DiPocket UAB kezeli, mely vállalatot a Litván Nemzeti Bank elektronikus pénzintézetenként (# 75) engedélyezett és felügyel Upės str. 23, 08128 Vilnius, LT", "Felügyelt számlák használati feltételei.pdf"});
//        list.add(new Object[] {Site.SNOW_ATTACK.toString(), Language.EN.toString(), Language.EN.getOurId(), app.getDbHelper().getClientIdFromDB2(app.emailsVerificationsEmail, app.mobile_site_snowAttack), app.emailsVerificationsEmail, app.emailsVerificationsPass, 0, 401, 402, expectedSender, ""+app.site_SnowAttack+" Terms and Conditions - PLEASE DO NOT DISCARD", "Dear "+app.emailsVerificationsFirstName+", Please find attached the section of "+app.site_SnowAttack+" Terms and Conditions (the “T&Cs”) regulating Supervised accounts. It is the same that you have already agreed to as part of the T&Cs, but we want to draw your attention on it now that you will start using a Supervised account since it contains important provisions on the Supervisor’s role and responsibilities. With kind regards, Legal Team", ""+app.SITE_REG+" "+app.site_SnowAttack+" is powered by DiPocket UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT", ""});
//        list.add(new Object[] {Site.SNOW_ATTACK.toString(), Language.HU.toString(), Language.HU.getOurId(), app.getDbHelper().getClientIdFromDB2(app.emailsVerificationsEmail, app.mobile_site_snowAttack), app.emailsVerificationsEmail, app.emailsVerificationsPass, 0, 252, 253, expectedSender, ""+app.site_SnowAttack+" használatának feltételei – KÉRJÜK, NE DOBJA EL", "Kedves "+app.emailsVerificationsFirstName+"! Csatolva találja \"A Snow Attack alkalmazás felügyelt számlák használati feltételei\". Regisztrációkor már elfogadta ezeket a feltételeket, de emlékeztetni szeretnénk a részletekre, mielőtt ezt a funkciót használná. Üdvözlettel, Jogi csapat", ""+app.SITE_REG+" "+app.site_SnowAttack+", a DiPocket UAB támogatásával, mely vállalatot a Litván Nemzeti Bank elektronikus pénzintézetenként (# 75) engedélyezett és felügyel | a Mastercard licencével rendelkezik az Európai Gazdasági Térségre vonatkozva Upės str. 23, 08128 Vilnius, LT", ""});
//        list.add(new Object[] {Site.UPANDGO.toString(), Language.EN.toString(), Language.EN.getOurId(), app.getDbHelper().getClientIdFromDB2(app.emailsVerificationsEmail, app.mobile_site_upAndGo), app.emailsVerificationsEmail, app.emailsVerificationsPass, 0, 399, 400, expectedUpAndGoSender, ""+app.site_upAndGo+" Terms and Conditions - PLEASE DO NOT DISCARD", "Dear "+app.emailsVerificationsFirstName+", Please find attached the section of "+app.site_upAndGo+" Terms and Conditions (the “T&Cs”) regulating Supervised accounts. It is the same that you have already agreed to as part of the T&Cs, but we want to draw your attention on it now that you will start using a Supervised account since it contains important provisions on the Supervisor’s role and responsibilities. With kind regards, Legal Team", ""+app.SITE_REG+" "+app.site_upAndGo+" is powered by DiPocket UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT", "Supervised Accounts T&Cs.pdf"});
//        list.add(new Object[] {Site.UPANDGO.toString(), Language.UK.toString(), Language.UK.getOurId(), app.getDbHelper().getClientIdFromDB2(app.emailsVerificationsEmail, app.mobile_site_upAndGo), app.emailsVerificationsEmail, app.emailsVerificationsPass, 29, 488, 489, expectedUpAndGoSender, "Правила та Умови користування додатком "+app.site_upAndGo+" - будь ласка, збережіть це повідомлення", "Вітаємо, "+app.emailsVerificationsFirstName+"! В додатку знаходиться розділ \"Умови та Правила користування додатком up and go\" (\"Правила користування\"), який стосується Опіки за рахунком. Ви прийняли їх разом з іншою частиною Правил користування, але зараз ми хочемо ще раз звернути на них Вашу увагу, адже Ви розпочинаєте користуватися Опікунськими рахунками, а в цьому розділі знаходиться більш детальна інформація про роль та відповідальність Опікуна рахунку. З повагою, Юридичний відділ", ""+app.SITE_REG+" Для Вашого спокою, "+app.site_upAndGo+" працює при підтримці DiPocket UAB, що авторизований та контролюється Банком Литви, як емітент електронних грошей (#75) Upės str. 23, 08128 Vilnius, LT", "Умови використання рахунків під опікою.pdf"});
//        list.add(new Object[] {Site.UPANDGO.toString(), Language.PL.toString(), Language.PL.getOurId(), app.getDbHelper().getClientIdFromDB2(app.emailsVerificationsEmail, app.mobile_site_upAndGo), app.emailsVerificationsEmail, app.emailsVerificationsPass, 0, 436, 437, expectedUpAndGoSender, "Zasady i Warunki korzystania z aplikacji "+app.site_upAndGo+" - PROSIMY O ZACHOWANIE TEJ WIADOMOŚCI", "Witaj "+app.emailsVerificationsFirstName+", W załączeniu znajduje się sekcja Warunków i Zasad korzystania (\"Warunki korzystania\"), dotycząca Kont Nadzorowanych. Zaakceptowałeś ją wraz z pozostałą częścią Warunków korzystania, jednak chcemy raz jeszcze zwrócić na nią Twoją uwagę teraz, gdy rozpoczynasz korzystanie z Konta Nadzorowanego, a w tej sekcji znajdziesz szczegółowe zapisy dotyczące roli i odpowiedzialności Opiekuna Konta. Z wyrazami szacunku, Dział Prawny", ""+app.SITE_REG+" "+app.site_upAndGo+" dostarcza DiPocket UAB, autoryzowana Instytucja Pieniądza Elektronicznego, podlegająca nadzorowi Banku Litwy (numer licencji 75) | Licencjonowana przez Mastercard do działania na Europejskim Obszarze Gospodarczego Upės g. 23, 08128 Vilnius, LT", "Konta Nadzorowane - warunki ogólne.pdf"});
//        list.add(new Object[] {Site.UPANDGO.toString(), Language.RU.toString(), Language.RU.getOurId(), app.getDbHelper().getClientIdFromDB2(app.emailsVerificationsEmail, app.mobile_site_upAndGo), app.emailsVerificationsEmail, app.emailsVerificationsPass, 29, 297, 298, expectedUpAndGoSender, "Условия пользования приложением "+app.site_upAndGo+" - пожалуйста, сохраните это сообщение", "Здравствуйте, "+app.emailsVerificationsFirstName+"! В приложении находится раздел \"Условий пользования приложением "+app.site_upAndGo+"\" об опеке. Вы уже приняли эти условия в момент регистрации, но мы хотим напомнить Вам детали перед началом использования этой функциональности. С уважением, Юридический отдел", ""+app.SITE_REG+" Для вашего спокойствия, "+app.site_upAndGo+" осуществляет деятельность при поддержке DiPocket UAB, который авторизован и контролируется Банком Литвы как эмитент электронных денег (#75) Upės str. 23, 08128 Vilnius, LT", "Условия использования счетов под опекой.pdf"});
        return list.iterator();
    }

    @Test(dataProvider = "Tac")
    public void testTac(String site, String lang, int langId, int id, String email, String pass, int bodyBegin, int bodyEnd, int footerEnd, String expectedEmailSender, String expectedEmailSubject, String expectedEmailBody, String expectedEmailFooter, List<String> expectedFileNames) throws InterruptedException, MessagingException, IOException, SQLException, ClassNotFoundException {
        app.getDbHelper().updateClientLanguageFromDB(email, String.valueOf(langId), site);
        postSendTacEmail(site);

        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(email, pass);
        String actualSender = senderAndSubject.get(0);
        String actualSubject = senderAndSubject.get(1);
        List<String>actualAttachedFileNames = EmailVerificationHelper.getFileNameFromEmail("pop.gmail.com", email, pass);
        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", email, pass);
        String actualBody = getEmailBodyText(emailText, bodyBegin, bodyEnd);
        String actualFooter = getEmailFooterText(emailText, footerEnd);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualAttachedFileNames, expectedFileNames, "Attachments are not correct");
        softAssert.assertEquals(actualSender, expectedEmailSender, "Sender is not correct");
        softAssert.assertEquals(actualSubject, expectedEmailSubject, "Subject is not correct");
        softAssert.assertEquals(actualBody, expectedEmailBody, "Body is not correct");
        softAssert.assertEquals(actualFooter, expectedEmailFooter, "Footer is not correct");
        softAssert.assertAll();
    }

    @Test
    public void testTacDipocketEN() throws InterruptedException, MessagingException, IOException, SQLException, ClassNotFoundException {
        app.getDbHelper().updateClientLanguageFromDB(app.emailsVerificationsEmail, String.valueOf(Language.EN.getOurId()), Site.DIPOCKET.toString());
        postSendTacEmail(Site.DIPOCKET.toString());

        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualSender = senderAndSubject.get(0);
        String actualSubject = senderAndSubject.get(1);
        List<String>actualAttachedFileNames = EmailVerificationHelper.getFileNameFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualBody = getEmailBodyText(emailText, 28, 1523);
        String actualFooter = getEmailFooterText(emailText, 1524);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualAttachedFileNames, Arrays.asList("Limits Table.pdf", "Tariff Table.pdf", "General Terms and Conditions.pdf"), "Attachments are not correct");
        softAssert.assertEquals(actualSender, expectedSender, "Sender is not correct");
        softAssert.assertEquals(actualSubject, ""+app.site+" Terms and Conditions - PLEASE DO NOT DISCARD", "Subject is not correct");
        softAssert.assertEquals(actualBody, "Dear "+app.emailsVerificationsFirstName+", Please find attached \""+app.site+"_Terms_and_Conditions\" (the \"T&Cs\"), Tariff Table and Limits Table. It is important that you familiarise yourself with these documents and in particular with our current pricing and transaction limits. With regard to Personal Information, we ask you to please read the section in the T&C’s titled 'Personal Information' - we will process any Information you provide to us according those terms. By providing it to us, you are agreeing for us to process it, including any sensitive data for the purposes described in the Agreement subject to a number of rights you have to be informed about how your Information is processed, to correct any errors, to object to any processing, to restrict processing or have Information erased or to instruct us to copy or transfer Information as you direct. If you accept the T&Cs, please click on this link and proceed with the registration process through DiPocket mobile App. The T&Cs may only be changed upon 2 months notice to you, following which, if you have not objected, you will be deemed to have accepted the new terms. IMPORTANT: to expedite registration you may choose to start using the App even if you have not clicked on the link above. However, if you do not click on it within a week of accessing the App, your DiPocket account will be temporarily blocked until such time as you have clicked on the link and confirmed your agreement to having read and accepted the T&C’s. With kind regards, Legal Team", "Body is not correct");
        softAssert.assertEquals(actualFooter, ""+app.SITE_REG+" "+app.site+" UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT", "Footer is not correct");
        softAssert.assertAll();
    }

    @Test
    public void testTacDipocketUA() throws InterruptedException, MessagingException, IOException, SQLException, ClassNotFoundException {
        app.getDbHelper().updateClientLanguageFromDB(app.emailsVerificationsEmail, String.valueOf(Language.UK.getOurId()), Site.DIPOCKET.toString());
        postSendTacEmail(Site.DIPOCKET.toString());

        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualSender = senderAndSubject.get(0);
        String actualSubject = senderAndSubject.get(1);
        List<String>actualAttachedFileNames = EmailVerificationHelper.getFileNameFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualBody = getEmailBodyText(emailText, 28, 1504);
        String actualFooter = getEmailFooterText(emailText, 1505);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualAttachedFileNames, Arrays.asList("Ліміти.pdf", "Тарифи.pdf", "Загальні умови.pdf"), "Attachments are not correct");
        softAssert.assertEquals(actualSender, expectedSender, "Sender is not correct");
        softAssert.assertEquals(actualSubject, "Правила та Умови користування додатком "+app.site+" - будь ласка, збережіть це повідомлення", "Subject is not correct");
        softAssert.assertEquals(actualBody, "Вітаємо, "+app.emailsVerificationsFirstName+"! Будь ласка, ознайомтесь з прикріпленим файлом \""+app.site+"_Terms_and_Conditions\", в ньому знаходяться ключові правила користування DiPocket, актуальні ціни та ліміти для транзакцій. Стосовно особистої інформації, просимо Вас ознайомитись з розділом під назвою \"Personal Information\" - ми будемо обробляти будь-яку інформацію, яку ви надаєте нам відповідно до цих умов. Надавши нам інформацію (включаючи будь-які конфіденційні дані), Ви погоджуєтесь на її обробку для цілей, описаних у Договорі, з урахуванням права бути проінформованим про обробку вашої інформації, для виправлення помилок, для відмови у обробці, обмеження обробки або видалення інформації, для доручення копіювати або передавати інформацію за Вашою вказівкою. Якщо Ви приймаєте \"DiPocket_Terms_and_Conditions\", перейдіть за цим посиланням та продовжіть реєстрацію у додатку DiPocket. \"DiPocket_Terms_and_Conditions\" лишатимуться незмінним, доки ми не повідомимо про зміни, надсилаючи нові документи. Зміни будуть вислані принаймні за два місяці, щоб дати можливість ознайомитись із ними та прийняти їх. ВАЖЛИВО: Для прискорення процесу реєстрації можна почати користуватись додатком DiPocket без переходу за посиланням, яке зазначене вище. Але якщо Ви не зробите цього протягом 7 днів з моменту отримання доступу в додаток, Ваш рахунок DiPocket буде заблоковано, до моменту переходу за посиланням, що підтвердить що Ви ознайомились із \"DiPocket_Terms_and_Conditions\". З повагою, Юридичний відділ", "Body is not correct");
        softAssert.assertEquals(actualFooter, ""+app.SITE_REG+" Для Вашого спокою, "+app.site+" UAB авторизований та контролюється Банком Литви, як емітент електронних грошей (#75) Upės str. 23, 08128 Vilnius, LT", "Footer is not correct");
        softAssert.assertAll();
    }

    @Test
    public void testTacDipocketPL() throws InterruptedException, MessagingException, IOException, SQLException, ClassNotFoundException {
        app.getDbHelper().updateClientLanguageFromDB(app.emailsVerificationsEmail, String.valueOf(Language.PL.getOurId()), Site.DIPOCKET.toString());
        postSendTacEmail(Site.DIPOCKET.toString());

        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualSender = senderAndSubject.get(0);
        String actualSubject = senderAndSubject.get(1);
        List<String>actualAttachedFileNames = EmailVerificationHelper.getFileNameFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualBody = getEmailBodyText(emailText, 28, 1703);
        String actualFooter = getEmailFooterText(emailText, 1704);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualAttachedFileNames, Arrays.asList("Tabela Opłat.pdf", "Tabela Limitów.pdf", "Warunki Ogólne dla Klientów Indywidualnych.pdf"), "Attachments are not correct");
        softAssert.assertEquals(actualSender, expectedSender, "Sender is not correct");
        softAssert.assertEquals(actualSubject, "Zasady i Warunki korzystania z aplikacji "+app.site+" - PROSIMY O ZACHOWANIE TEJ WIADOMOŚCI", "Subject is not correct");
        softAssert.assertEquals(actualBody, "Witaj "+app.emailsVerificationsFirstName+", Prosimy o zapoznanie się z załączonymi dokumentami: “Warunkami ogólnymi dla klientów indywidualnych DiPocket”, \"Tabelą Limitów\" oraz \"Tabelą Prowizji i Opłat\". Prosimy o uważne przeczytanie zawartych w nich warunków oraz aktualnego cennika i limitów transakcji. W odniesieniu do Informacji osobowych, prosimy o zapoznanie się z sekcją Warunków ogólnych, zatytułowaną „Informacje osobowe” – przetwarzamy wszelkie powierzone nam dane zgodnie z zapisami tej sekcji. Przekazanie danych jest jednoczesnym wyrażeniem zgody na ich przetwarzanie, w tym na przetwarzanie danych poufnych do celów opisanych w Umowie, z zastrzeżeniem szeregu praw, o których użytkownik został poinformowany w aspektach: sposobu przetwarzania Informacji, poprawienia błędów, całkowitej lub częściowej odmowie możliwości przetwarzania, usunięcia informacji lub nakazania nam skopiowania lub transferu danych zgodnie z twoją dyspozycją. Jeżeli akceptujesz “Ogólne warunki dla klientów indywidualnych DiPocket” kliknij w ten link aby kontynuować proces rejestracji w aplikacji mobilnej DiPocket. “Ogólne warunki dla klientów indywidualnych DiPocket” mogą ulec zmianie jedynie, jeśli użytkownicy zostaną powiadomieni z co najmniej dwumiesięcznym wyprzedzeniem. W przypadku niezgłoszenia braku akceptacji, uznamy że akceptujesz nowe regulacje. WAŻNE: Aby przyspieszyć rejestrację, możesz zacząć korzystać z aplikacji DiPocket bez klikania w link zamieszczony powyżej. Jednakże w przypadku, gdy nie klikniesz w link w ciągu 7 dni, Twoje konto DiPocket zostanie tymczasowo zablokowane do momentu zaakceptowania „Ogólnych warunków korzystania z aplikacji DiPocket”. Z wyrazami szacunku, Dział Prawny", "Body is not correct");
        softAssert.assertEquals(actualFooter, ""+app.SITE_REG+" "+app.site+" UAB, autoryzowana Instytucja Pieniądza Elektronicznego, podlegająca nadzorowi Banku Litwy (numer licencji 75) | Licencjonowana przez Mastercard do działania na Europejskim Obszarze Gospodarczego Upės g. 23, 08128 Vilnius, LT", "Footer is not correct");
        softAssert.assertAll();
    }

    @Test
    public void testTacDipocketRU() throws InterruptedException, MessagingException, IOException, SQLException, ClassNotFoundException {
        app.getDbHelper().updateClientLanguageFromDB(app.emailsVerificationsEmail, String.valueOf(Language.RU.getOurId()), Site.DIPOCKET.toString());
        postSendTacEmail(Site.DIPOCKET.toString());

        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualSender = senderAndSubject.get(0);
        String actualSubject = senderAndSubject.get(1);
        List<String>actualAttachedFileNames = EmailVerificationHelper.getFileNameFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualBody = getEmailBodyText(emailText, 28, 1490);
        String actualFooter = getEmailFooterText(emailText, 1491);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualAttachedFileNames, Arrays.asList("Лимиты.pdf", "Тарифы.pdf", "Общие условия.pdf"), "Attachments are not correct");
        softAssert.assertEquals(actualSender, expectedSender, "Sender is not correct");
        softAssert.assertEquals(actualSubject, "Условия пользования приложением "+app.site+" - пожалуйста, сохраните это сообщение", "Subject is not correct");
        softAssert.assertEquals(actualBody, "Здравствуйте, "+app.emailsVerificationsFirstName+"! Ознакомьтесь с прикрепленным файлом \""+app.site+"_Terms_and_Conditions\", в нём вы найдете ключевые правила использования "+app.site+", актуальные цены и тарифы. Относительно личных данных, просьба обратить внимание на раздел \"Personal Information\" в \""+app.site+"_Terms_and_Conditions\", поскольку вся личная информация будет обрабатываться согласно этим условиям. Предоставляя нам информацию (включая конфиденциальную), вы даёте согласие на ее обработку в целях, описанных в Договоре. Вы имеете право быть в курсе использования данных, чтобы иметь возможность исправить ошибки, чтобы отказаться от обработки или остановить обработку, или удалить информацию или проинструктировать нас о копировании или передачи информации по Вашему указанию. Если Вы принимаете \"Условия пользования приложением "+app.site+"\",  перейдите по этой ссылке и закончите регистрацию в приложении, если еще не закончили. \""+app.site+"_Terms_and_Conditions\" остаются неизменными до тех пор, пока не будет уведомлено об обратном. Уведомление об изменении условий будет выслано, по меньшей мере, за два месяца, чтобы дать Вам возможность ознакомится и принять их. ВАЖНО: можно закончить регистрацию без перехода по ссылке выше. Но, если вы не сделаете этого в течение 7 дней после получения доступа к приложению, учетная запись в DiPocket будет заблокирована до тех пор, пока Вы не перейдете по ссылке, принимая таким образом \""+app.site+"_Terms_and_Conditions\". С уважением, Юридический отдел", "Body is not correct");
        softAssert.assertEquals(actualFooter, ""+app.SITE_REG+" Для вашего спокойствия, "+app.site+" UAB авторизован и контролируется Банком Литвы как эмитент электронных денег (#75) Upės str. 23, 08128 Vilnius, LT", "Footer is not correct");
        softAssert.assertAll();
    }

    @Test
    public void testTacDiscontuEN() throws InterruptedException, MessagingException, IOException, SQLException, ClassNotFoundException {
        app.getDbHelper().updateClientLanguageFromDB(app.emailsVerificationsEmail, String.valueOf(Language.EN.getOurId()), Site.DISCONTU.toString());
        postSendTacEmail(Site.DISCONTU.toString());

        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualSender = senderAndSubject.get(0);
        String actualSubject = senderAndSubject.get(1);
        List<String>actualAttachedFileNames = EmailVerificationHelper.getFileNameFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualBody = getEmailBodyText(emailText, 28, 1624);
        String actualFooter = getEmailFooterText(emailText, 1625);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualAttachedFileNames, Arrays.asList("E-wallet terms of usage.pdf", "General Terms and Conditions.pdf"), "Attachments are not correct");
        softAssert.assertEquals(actualSender, expectedDiscontuSender, "Sender is not correct");
        softAssert.assertEquals(actualSubject, ""+app.site_discontu+" Terms and Conditions - PLEASE DO NOT DISCARD", "Subject is not correct");
        softAssert.assertEquals(actualBody, "Dear "+app.emailsVerificationsFirstName+", Please find attached \""+app.site_discontu+"_Terms_and_Conditions\" (the \"T&Cs\"). It is important that you familiarise yourself with these documents and in particular that you review in detail \""+app.site_discontu+"_at_a_Glance\", which summarises the key clauses applicable to your "+app.site_discontu+" account and also includes our current pricing and transaction limits. With regard to Personal Information, we ask you to please read the section in the T&C’s titled 'Personal Information' - we will process any Information you provide to us according those terms. By providing it to us, you are agreeing for us to process it, including any sensitive data for the purposes described in the Agreement subject to a number of rights you have to be informed about how your Information is processed, to correct any errors, to object to any processing, to restrict processing or have Information erased or to instruct us to copy or transfer Information as you direct. If you accept the T&Cs, please click on this link and proceed with the registration process through discontu mobile App. The T&Cs may only be changed upon 2 months notice to you, following which, if you have not objected, you will be deemed to have accepted the new terms. IMPORTANT: to expedite registration you may choose to start using the App even if you have not clicked on the link above. However, if you do not click on it within a week of accessing the App, your discontu account will be temporarily blocked until such time as you have clicked on the link and confirmed your agreement to having read and accepted the T&C’s. With kind regards, Legal Team", "Body is not correct");
        softAssert.assertEquals(actualFooter, ""+app.SITE_REG+" "+app.site_discontu+" is powered by DiPocket UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT", "Footer is not correct");
        softAssert.assertAll();
    }

    @Test
    public void testTacDiscontuPL() throws InterruptedException, MessagingException, IOException, SQLException, ClassNotFoundException {
        app.getDbHelper().updateClientLanguageFromDB(app.emailsVerificationsEmail, String.valueOf(Language.PL.getOurId()), Site.DISCONTU.toString());
        postSendTacEmail(Site.DISCONTU.toString());

        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualSender = senderAndSubject.get(0);
        String actualSubject = senderAndSubject.get(1);
        List<String>actualAttachedFileNames = EmailVerificationHelper.getFileNameFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualBody = getEmailBodyText(emailText, 28, 1750);
        String actualFooter = getEmailFooterText(emailText, 1751);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualAttachedFileNames, Arrays.asList("Warunki mające zastosowanie do portfela elektronicznego.pdf", "Warunki Ogólne dla Klientów Indywidualnych.pdf"), "Attachments are not correct");
        softAssert.assertEquals(actualSender, expectedDiscontuSender, "Sender is not correct");
        softAssert.assertEquals(actualSubject, "Zasady i Warunki korzystania z aplikacji "+app.site_discontu+" - PROSIMY O ZACHOWANIE TEJ WIADOMOŚCI", "Subject is not correct");
        softAssert.assertEquals(actualBody, "Witaj "+app.emailsVerificationsFirstName+", Prosimy o zapoznanie się z załączonym plikiem “Warunki ogólne dla klientów indywidualnych "+app.site_discontu+"”. Prosimy o zwrócenie szczególnej uwagi na część “Najważniejsze informacje o "+app.site_discontu+"”, w której znajduje się podsumowanie kluczowych zasad korzystania z konta "+app.site_discontu+", aktualny cennik oraz limity transakcji. W odniesieniu do Informacji osobowych, prosimy o zapoznanie się z sekcją Warunków ogólnych, zatytułowaną „Informacje osobowe” – przetwarzamy wszelkie powierzone nam dane zgodnie z zapisami tej sekcji. Przekazanie danych jest jednoczesnym wyrażeniem zgody na ich przetwarzanie, w tym na przetwarzanie danych poufnych do celów opisanych w Umowie, z zastrzeżeniem szeregu praw, o których użytkownik został poinformowany w aspektach: sposobu przetwarzania Informacji, poprawienia błędów, całkowitej lub częściowej odmowie możliwości przetwarzania, usunięcia informacji lub nakazania nam skopiowania lub transferu danych zgodnie z twoją dyspozycją. Jeżeli akceptujesz “Ogólne warunki dla klientów indywidualnych discontu” kliknij w ten link aby kontynuować proces rejestracji w aplikacji mobilnej discontu. “Ogólne warunki dla klientów indywidualnych discontu” mogą ulec zmianie jedynie, jeśli użytkownicy zostaną powiadomieni z co najmniej dwumiesięcznym wyprzedzeniem. W przypadku niezgłoszenia braku akceptacji, uznamy że akceptujesz nowe regulacje. WAŻNE: Aby przyspieszyć rejestrację, możesz zacząć korzystać z aplikacji discontu bez klikania w link zamieszczony powyżej. Jednakże w przypadku, gdy nie klikniesz w link w ciągu 7 dni, Twoje konto discontu zostanie tymczasowo zablokowane do momentu zaakceptowania „Ogólnych warunków korzystania z aplikacji discontu”. Z wyrazami szacunku, Dział Prawny", "Body is not correct");
        softAssert.assertEquals(actualFooter, ""+app.SITE_REG+" "+app.site_discontu+" dostarcza DiPocket UAB, autoryzowana Instytucja Pieniądza Elektronicznego, podlegająca nadzorowi Banku Litwy (numer licencji 75) | Licencjonowana przez Mastercard do działania na Europejskim Obszarze Gospodarczego Upės g. 23, 08128 Vilnius, LT", "Footer is not correct");
        softAssert.assertAll();
    }

    @Test
    public void testTacPlayITEN() throws InterruptedException, MessagingException, IOException, SQLException, ClassNotFoundException {
        app.getDbHelper().updateClientLanguageFromDB(app.emailsVerificationsEmail, String.valueOf(Language.EN.getOurId()), Site.PLAYIT.toString());
        postSendTacEmail(Site.PLAYIT.toString());

        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualSender = senderAndSubject.get(0);
        String actualSubject = senderAndSubject.get(1);
        List<String>actualAttachedFileNames = EmailVerificationHelper.getFileNameFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualBody = getEmailBodyText(emailText, 26, 1619);
        String actualFooter = getEmailFooterText(emailText, 1620);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualAttachedFileNames, Arrays.asList("General Terms and Conditions.pdf", "Card Terms and Conditions.pdf", "E-wallet terms of usage.pdf"), "Attachments are not correct");
        softAssert.assertEquals(actualSender, expectedPlayITSender, "Sender is not correct");
        softAssert.assertEquals(actualSubject, ""+app.site_PlayIT+" Terms and Conditions - PLEASE DO NOT DISCARD", "Subject is not correct");
        softAssert.assertEquals(actualBody, "Dear "+app.emailsVerificationsFirstName+", Please find attached \""+app.site_PlayIT+"_Terms_and_Conditions\" (the \"T&Cs\"). It is important that you familiarise yourself with these documents and in particular that you review in detail \"E-wallet terms of usage\", which summarises the key clauses applicable to your "+app.site_PlayIT+" account and also includes our current pricing and transaction limits. With regard to Personal Information, we ask you to please read the section in the T&C’s titled 'Personal Information' - we will process any Information you provide to us according those terms. By providing it to us, you are agreeing for us to process it, including any sensitive data for the purposes described in the Agreement subject to a number of rights you have to be informed about how your Information is processed, to correct any errors, to object to any processing, to restrict processing or have Information erased or to instruct us to copy or transfer Information as you direct. If you accept the T&Cs, please  click on this link  and proceed with the registration process through PlayIT mobile App. The T&Cs may only be changed upon 2 months notice to you, following which, if you have not objected, you will be deemed to have accepted the new terms. IMPORTANT: to expedite registration you may choose to start using the App even if you have not clicked on the link above. However, if you do not click on it within a week of accessing the App, your "+app.site_PlayIT+" account will be temporarily blocked until such time as you have clicked on the link and confirmed your agreement to having read and accepted the T&C’s. With kind regards, Legal Team", "Body is not correct");
        softAssert.assertEquals(actualFooter, ""+app.SITE_REG+" "+app.site_PlayIT+" is powered by DiPocket UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT", "Footer is not correct");
        softAssert.assertAll();
    }

    @Test
    public void testTacPlayITHU() throws InterruptedException, MessagingException, IOException, SQLException, ClassNotFoundException {
        app.getDbHelper().updateClientLanguageFromDB(app.emailsVerificationsEmail, String.valueOf(Language.HU.getOurId()), Site.PLAYIT.toString());
        postSendTacEmail(Site.PLAYIT.toString());

        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualSender = senderAndSubject.get(0);
        String actualSubject = senderAndSubject.get(1);
        List<String>actualAttachedFileNames = EmailVerificationHelper.getFileNameFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualBody = getEmailBodyText(emailText, 26, 1907);
        String actualFooter = getEmailFooterText(emailText, 1908);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualAttachedFileNames, Arrays.asList("Általános szerződési feltételek.pdf", "Kártyaszerződési feltételek.pdf", "E-pénztárca használati feltételei.pdf"), "Attachments are not correct");
        softAssert.assertEquals(actualSender, expectedPlayITSender, "Sender is not correct");
        softAssert.assertEquals(actualSubject, ""+app.site_PlayIT+" használatának feltételei – KÉRJÜK, NE DOBJA EL", "Subject is not correct");
        softAssert.assertEquals(actualBody, "Kedves "+app.emailsVerificationsFirstName+", Lásd a csatolt „"+app.site_PlayIT+"_Terms_and_Conditions” (a „T&Cs”) dokumentumot. Fontos, hogy megismerkedjen ezekkel a dokumentumokkal és különösen fontos, hogy részletesen áttekintse az 'E-pénztárca használati feltételei' címűt, amely összegezi az Ön PlayIT fiókjára vonatkozó legfontosabb tudnivalókat, és tartalmazza az aktuális árainkat és a tranzakciós limiteket is. A Személyi adatokkal kapcsolatban kérjük, hogy olvassa el a Használati feltételek 'Személyi adatok' szakaszát – az ebben foglalt feltételek szerint kezelünk minden Ön által megadott információt. Azáltal, hogy információt szolgáltat nekünk, Ön beleegyezik abba, hogy azokat – beleértve a bizalmas adatokat – kezeljük és felhasználjuk a Megállapodásban leírt célokra, és amelyekkel kapcsolatban Ön számos jogosultsággal rendelkezik, úgy mint tájékoztatásra az Ön adatainak kezelési módjáról, valamint jog a hibák kijavítására, a kezelés elutasítására, a kezelés korlátozására, az adatai töröltetésére, vagy utasítani bennünket, hogy másoljuk vagy továbbítsuk adatait az Ön utasításai szerint. Ha elfogadja a Használati feltételeket, kérjük, kattintson erre  a hivatkozásra , és folytassa a regisztrációt a PlayIT mobilalkalmazás segítségével. A Használati feltételek módosítása csak 2 hónappal korábban, előzetesen megküldött értesítés után lehetséges, amely 2 hónap lejártával, ha nem kifogásolta, úgy tekintendő, hogy Ön az új feltételeket elfogadta. FONTOS: a regisztráció felgyorsítása érdekében választhatja, hogy megkezdi az alkalmazás használatát, még ha nem is kattintott a fenti hivatkozásra. Ha azonban nem kattintasz rá az alkalmazás megnyitását követő egy héten belül, akkor a PlayIT fiókod ideiglenesen blokkolva lesz mindaddig, amíg rá nem kattintasz a hivatkozásra, és meg nem erősítetted a megállapodást arról, hogy elolvastad és elfogadtad a Használati feltételeket. Üdvözlettel, Jogi csapat", "Body is not correct");
        softAssert.assertEquals(actualFooter, ""+app.SITE_REG+" Megnyugtatásul tájékoztatjuk, hogy a "+app.site_PlayIT+" Kártya számládat a DiPocket UAB kezeli, mely vállalatot a Litván Nemzeti Bank elektronikus pénzintézetenként (# 75) engedélyezett és felügyel Upės str. 23, 08128 Vilnius, LT", "Footer is not correct");
        softAssert.assertAll();
    }

    @Test
    public void testTacSnowAttackEN() throws InterruptedException, MessagingException, IOException, SQLException, ClassNotFoundException {
        app.getDbHelper().updateClientLanguageFromDB(app.emailsVerificationsEmail, String.valueOf(Language.EN.getOurId()), Site.SNOW_ATTACK.toString());
        postSendTacEmail(Site.SNOW_ATTACK.toString());

        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualSender = senderAndSubject.get(0);
        String actualSubject = senderAndSubject.get(1);
        List<String>actualAttachedFileNames = EmailVerificationHelper.getFileNameFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualBody = getEmailBodyText(emailText, 31, 1329);
        String actualFooter = getEmailFooterText(emailText, 1330);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualAttachedFileNames, Arrays.asList("General Terms and Conditions.pdf", "Card Terms and Conditions.pdf"), "Attachments are not correct");
        softAssert.assertEquals(actualSender, expectedSnowAttackSender, "Sender is not correct");
        softAssert.assertEquals(actualSubject, "Festivals Payment Band Terms and Conditions - PLEASE DO NOT DISCARD", "Subject is not correct");
        softAssert.assertEquals(actualBody, "Please find attached DiPocket Terms and Conditions for Festivals’ Customers and the Festivals’ Payment Band Terms and Conditions. It is important that you familiarise yourself with these documents and in particular that you review in detail the Festivals’ Payment Band Terms and Conditions, which summarises the key clauses applicable to your Festivals’ payment band and also includes our current pricing and transaction limits. With regard to Personal Information, we ask you to please read the section in the T&C’s titled 'Personal Information' - we will process any Information you provide to us according those terms. By providing it to us, you are agreeing for us to process it, including any sensitive data for the purposes described in the Agreement subject to a number of rights you have to be informed about how your Information is processed, to correct any errors, to object to any processing, to restrict processing or have Information erased or to instruct us to copy or transfer Information as you direct. If you accept the T&Cs, please click on this link and proceed with the registration process Thank you for registering your Festivals’ Payment Band - enjoy its safety and convenience at the festival and wherever your active lifestyle takes you to! With kind regards, DiPocket Team", "Body is not correct");
        softAssert.assertEquals(actualFooter, ""+app.SITE_REG+" "+app.site_SnowAttack+" is powered by DiPocket UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT", "Footer is not correct");
        softAssert.assertAll();
    }

    @Test
    public void testTacSnowAttackHU() throws InterruptedException, MessagingException, IOException, SQLException, ClassNotFoundException {
        app.getDbHelper().updateClientLanguageFromDB(app.emailsVerificationsEmail, String.valueOf(Language.HU.getOurId()), Site.SNOW_ATTACK.toString());
        postSendTacEmail(Site.SNOW_ATTACK.toString());

        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualSender = senderAndSubject.get(0);
        String actualSubject = senderAndSubject.get(1);
        List<String>actualAttachedFileNames = EmailVerificationHelper.getFileNameFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualBody = getEmailBodyText(emailText, 31, 1466);
        String actualFooter = getEmailFooterText(emailText, 1467);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualAttachedFileNames, Arrays.asList("Kártyaszerződési feltételek.pdf", "Általános szerződési feltételek.pdf"), "Attachments are not correct");
        softAssert.assertEquals(actualSender, expectedSnowAttackSender, "Sender is not correct");
        softAssert.assertEquals(actualSubject, "A fesztivál-okoskarkötő használatának feltételei – KÉRJÜK, NE DOBJA EL", "Subject is not correct");
        softAssert.assertEquals(actualBody, "Mellékeljük a DiPocket fesztiválügyfelek számára szóló Felhasználási feltételeit és a fesztivál-okoskarkötők Felhasználási feltételeit. Fontos, hogy megismerkedjen ezekkel a dokumentumokkal és főként, hogy részletesen áttekintse a fesztiválok okoskarkötőinek Felhasználási feltételeit, amely összegezi az Ön fesztivál-okoskarkötőjére vonatkozó legfontosabb tudnivalókat, és tartalmazza az aktuális árainkat és a tranzakciós limiteket is. A Személyi adatokkal kapcsolatban kérjük, hogy olvassa el a Használati feltételek 'Személyi adatok' szakaszát – az ebben foglalt feltételek szerint kezelünk minden Ön által megadott információt. Azáltal, hogy információt szolgáltat nekünk, Ön beleegyezik abba, hogy azokat – beleértve a bizalmas adatokat – kezeljük és felhasználjuk a Megállapodásban leírt célokra, és amelyekkel kapcsolatban Ön számos jogosultsággal rendelkezik, úgy mint tájékoztatásra az Ön adatainak kezelési módjáról, valamint jog a hibák kijavítására, a kezelés elutasítására, a kezelés korlátozására, az adatai töröltetésére, vagy utasítani bennünket, hogy másoljuk vagy továbbítsuk adatait az Ön utasításai szerint. Amennyiben elfogadja az Általános Szerződési Feltételeket, kérjük klikkeljen erre a linkre és folytassa a regisztrációt Köszönjük, hogy regisztrálta fesztivál-okoskarkötőjét – élvezze annak biztonságát és kényelmét a fesztiválon, és mindenhol, ahova aktív életmódja sodorja! Üdvözlettel, A DiPocket csapata", "Body is not correct");
        softAssert.assertEquals(actualFooter, ""+app.SITE_REG+" "+app.site_SnowAttack+", a DiPocket UAB támogatásával, mely vállalatot a Litván Nemzeti Bank elektronikus pénzintézetenként (# 75) engedélyezett és felügyel | a Mastercard licencével rendelkezik az Európai Gazdasági Térségre vonatkozva Upės str. 23, 08128 Vilnius, LT", "Footer is not correct");
        softAssert.assertAll();
    }

    @Test
    public void testTacUpAndGoEN() throws InterruptedException, MessagingException, IOException, SQLException, ClassNotFoundException {
        app.getDbHelper().updateClientLanguageFromDB(app.emailsVerificationsEmail, String.valueOf(Language.EN.getOurId()), Site.UPANDGO.toString());
        postSendTacEmail(Site.UPANDGO.toString());

        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualSender = senderAndSubject.get(0);
        String actualSubject = senderAndSubject.get(1);
        List<String>actualAttachedFileNames = EmailVerificationHelper.getFileNameFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualBody = getEmailBodyText(emailText, 29, 1630);
        String actualFooter = getEmailFooterText(emailText, 1631);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualAttachedFileNames, Arrays.asList("General Terms and Conditions.pdf", "E-wallet terms of usage.pdf"), "Attachments are not correct");
        softAssert.assertEquals(actualSender, expectedUpAndGoSender, "Sender is not correct");
        softAssert.assertEquals(actualSubject, ""+app.site_upAndGo+" Terms and Conditions - PLEASE DO NOT DISCARD", "Subject is not correct");
        softAssert.assertEquals(actualBody, "Dear "+app.emailsVerificationsFirstName+", Please find attached \""+app.site_upAndGo+"_Terms_and_Conditions\" (the \"T&Cs\"). It is important that you familiarise yourself with these documents and in particular that you review in detail \"up and go_at_a_Glance\", which summarises the key clauses applicable to your up and go account and also includes our current pricing and transaction limits. With regard to Personal Information, we ask you to please read the section in the T&C’s titled 'Personal Information' - we will process any Information you provide to us according those terms. By providing it to us, you are agreeing for us to process it, including any sensitive data for the purposes described in the Agreement subject to a number of rights you have to be informed about how your Information is processed, to correct any errors, to object to any processing, to restrict processing or have Information erased or to instruct us to copy or transfer Information as you direct. If you accept the T&Cs, please click on this link and proceed with the registration process through up and go mobile App. The T&Cs may only be changed upon 2 months notice to you, following which, if you have not objected, you will be deemed to have accepted the new terms. IMPORTANT: to expedite registration you may choose to start using the App even if you have not clicked on the link above. However, if you do not click on it within a week of accessing the App, your up and go account will be temporarily blocked until such time as you have clicked on the link and confirmed your agreement to having read and accepted the T&C’s. With kind regards, Legal Team", "Body is not correct");
        //softAssert.assertEquals(actualFooter, ""+app.SITE_REG+" "+app.site_upAndGo+" is powered by DiPocket UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT", "Footer is not correct");
        softAssert.assertAll();
    }

    @Test
    public void testTacUpAndGoUA() throws InterruptedException, MessagingException, IOException, SQLException, ClassNotFoundException {
        app.getDbHelper().updateClientLanguageFromDB(app.emailsVerificationsEmail, String.valueOf(Language.UK.getOurId()), Site.UPANDGO.toString());
        postSendTacEmail(Site.UPANDGO.toString());

        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualSender = senderAndSubject.get(0);
        String actualSubject = senderAndSubject.get(1);
        List<String>actualAttachedFileNames = EmailVerificationHelper.getFileNameFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualBody = getEmailBodyText(emailText, 29, 1576);
        String actualFooter = getEmailFooterText(emailText, 1577);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualAttachedFileNames, Arrays.asList("Загальні умови.pdf", "Правила та Умови використання електронного гаманця.pdf"), "Attachments are not correct");
        softAssert.assertEquals(actualSender, expectedUpAndGoSender, "Sender is not correct");
        softAssert.assertEquals(actualSubject, "Правила та Умови користування додатком "+app.site_upAndGo+" - будь ласка, збережіть це повідомлення", "Subject is not correct");
        softAssert.assertEquals(actualBody, "Вітаємо, "+app.emailsVerificationsFirstName+"! Будь ласка, ознайомтесь з прикріпленим файлом \"up and go_Terms_and_Conditions\". Будь ласка, зверніть увагу на частину \"up and go_at_a_Glance\", в ньому знаходяться ключові правила користування up and go, актуальні ціни та ліміти для транзакцій. Стосовно особистої інформації, просимо Вас ознайомитись з розділом під назвою \"Personal Information\" - ми будемо обробляти будь-яку інформацію, яку ви надаєте нам відповідно до цих умов. Надавши нам інформацію (включаючи будь-які конфіденційні дані), Ви погоджуєтесь на її обробку для цілей, описаних у Договорі, з урахуванням права бути проінформованим про обробку вашої інформації, для виправлення помилок, для відмови у обробці, обмеження обробки або видалення інформації, для доручення копіювати або передавати інформацію за Вашою вказівкою. Якщо Ви приймаєте \"up and go_Terms_and_Conditions\", перейдіть за цим посиланням та продовжіть реєстрацію у додатку up and go. \"up and go_Terms_and_Conditions\" лишатимуться незмінним, доки ми не повідомимо про зміни, надсилаючи нові документи. Зміни будуть вислані принаймні за два місяці, щоб дати можливість ознайомитись із ними та прийняти їх. ВАЖЛИВО: Для прискорення процесу реєстрації можна почати користуватись додатком up and go без переходу за посиланням, яке зазначене вище. Але якщо Ви не зробите цього протягом 7 днів з моменту отримання доступу в додаток, Ваш рахунок up and go буде заблоковано, до моменту переходу за посиланням, що підтвердить що Ви ознайомились із \"up and go_Terms_and_Conditions\". З повагою, Юридичний відділ", "Body is not correct");
        //softAssert.assertEquals(actualFooter, ""+app.SITE_REG+" Для Вашого спокою, "+app.site_upAndGo+" працює при підтримці DiPocket UAB, що авторизований та контролюється Банком Литви, як емітент електронних грошей (#75) Upės str. 23, 08128 Vilnius, LT", "Footer is not correct");
        softAssert.assertAll();
    }

    @Test
    public void testTacUpAndGoPL() throws InterruptedException, MessagingException, IOException, SQLException, ClassNotFoundException {
        app.getDbHelper().updateClientLanguageFromDB(app.emailsVerificationsEmail, String.valueOf(Language.PL.getOurId()), Site.UPANDGO.toString());
        postSendTacEmail(Site.UPANDGO.toString());

        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualSender = senderAndSubject.get(0);
        String actualSubject = senderAndSubject.get(1);
        List<String>actualAttachedFileNames = EmailVerificationHelper.getFileNameFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualBody = getEmailBodyText(emailText, 29, 1760);
        String actualFooter = getEmailFooterText(emailText, 1761);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualAttachedFileNames, Arrays.asList("Warunki Ogólne dla Klientów Indywidualnych.pdf", "Warunki mające zastosowanie do portfela elektronicznego.pdf"), "Attachments are not correct");
        softAssert.assertEquals(actualSender, expectedUpAndGoSender, "Sender is not correct");
        softAssert.assertEquals(actualSubject, "Zasady i Warunki korzystania z aplikacji "+app.site_upAndGo+" - PROSIMY O ZACHOWANIE TEJ WIADOMOŚCI", "Subject is not correct");
        softAssert.assertEquals(actualBody, "Witaj "+app.emailsVerificationsFirstName+", Prosimy o zapoznanie się z załączonym plikiem “Warunki ogólne dla klientów indywidualnych up and go”. Prosimy o zwrócenie szczególnej uwagi na część “Najważniejsze informacje o up and go”, w której znajduje się podsumowanie kluczowych zasad korzystania z konta up and go, aktualny cennik oraz limity transakcji. W odniesieniu do Informacji osobowych, prosimy o zapoznanie się z sekcją Warunków ogólnych, zatytułowaną „Informacje osobowe” – przetwarzamy wszelkie powierzone nam dane zgodnie z zapisami tej sekcji. Przekazanie danych jest jednoczesnym wyrażeniem zgody na ich przetwarzanie, w tym na przetwarzanie danych poufnych do celów opisanych w Umowie, z zastrzeżeniem szeregu praw, o których użytkownik został poinformowany w aspektach: sposobu przetwarzania Informacji, poprawienia błędów, całkowitej lub częściowej odmowie możliwości przetwarzania, usunięcia informacji lub nakazania nam skopiowania lub transferu danych zgodnie z twoją dyspozycją. Jeżeli akceptujesz “Ogólne warunki dla klientów indywidualnych up and go” kliknij w ten link aby kontynuować proces rejestracji w aplikacji mobilnej up and go. “Ogólne warunki dla klientów indywidualnych up and go” mogą ulec zmianie jedynie, jeśli użytkownicy zostaną powiadomieni z co najmniej dwumiesięcznym wyprzedzeniem. W przypadku niezgłoszenia braku akceptacji, uznamy że akceptujesz nowe regulacje. WAŻNE: Aby przyspieszyć rejestrację, możesz zacząć korzystać z aplikacji up and go bez klikania w link zamieszczony powyżej. Jednakże w przypadku, gdy nie klikniesz w link w ciągu 7 dni, Twoje konto up and go zostanie tymczasowo zablokowane do momentu zaakceptowania „Ogólnych warunków korzystania z aplikacji up and go”. Z wyrazami szacunku, Dział Prawny", "Body is not correct");
        //softAssert.assertEquals(actualFooter, ""+app.SITE_REG+" "+app.site_upAndGo+" dostarcza DiPocket UAB, autoryzowana Instytucja Pieniądza Elektronicznego, podlegająca nadzorowi Banku Litwy (numer licencji 75) | Licencjonowana przez Mastercard do działania na Europejskim Obszarze Gospodarczego Upės g. 23, 08128 Vilnius, LT", "Footer is not correct");
        softAssert.assertAll();
    }

    @Test
    public void testTacUpAndGoRU() throws InterruptedException, MessagingException, IOException, SQLException, ClassNotFoundException {
        app.getDbHelper().updateClientLanguageFromDB(app.emailsVerificationsEmail, String.valueOf(Language.RU.getOurId()), Site.UPANDGO.toString());
        postSendTacEmail(Site.UPANDGO.toString());

        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualSender = senderAndSubject.get(0);
        String actualSubject = senderAndSubject.get(1);
        List<String>actualAttachedFileNames = EmailVerificationHelper.getFileNameFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualBody = getEmailBodyText(emailText, 29, 1551);
        String actualFooter = getEmailFooterText(emailText, 1552);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualAttachedFileNames, Arrays.asList("Общие условия.pdf", "Условия пользования электронным кошельком.pdf"), "Attachments are not correct");
        softAssert.assertEquals(actualSender, expectedUpAndGoSender, "Sender is not correct");
        softAssert.assertEquals(actualSubject, "Условия пользования приложением "+app.site_upAndGo+" - пожалуйста, сохраните это сообщение", "Subject is not correct");
        softAssert.assertEquals(actualBody, "Здравствуйте, "+app.emailsVerificationsFirstName+"! Ознакомьтесь с прикрепленным файлом \""+app.site_upAndGo+"_Terms_and_Conditions\". Обратите внимание на документ \""+app.site_upAndGo+"_at_a_Glance\", в нём вы найдете ключевые правила пользования "+app.site_upAndGo+", актуальные цены и тарифы. Относительно личных данных, просьба обратить внимание на раздел \"Personal Information\" в \""+app.site_upAndGo+"_Terms_and_Conditions\", поскольку вся личная информация будет обрабатываться согласно этим условиям. Предоставляя нам информацию (включая конфиденциальную), вы даёте согласие на ее обработку в целях, описанных в Договоре. Вы имеете право быть в курсе использования данных, чтобы иметь возможность исправить ошибки, чтобы отказаться от обработки или остановить обработку, или удалить информацию или проинструктировать нас о копировании или передачи информации по Вашему указанию. Если Вы принимаете \"Условия пользования приложением "+app.site_upAndGo+"\",  перейдите по этой ссылке и закончите регистрацию в приложении, если еще не закончили. \""+app.site_upAndGo+"_Terms_and_Conditions\" остаются неизменными до тех пор, пока не будет уведомлено об обратном. Уведомление об изменении условий будет выслано, по меньшей мере, за два месяца, чтобы дать Вам возможность ознакомится и принять их. ВАЖНО: можно закончить регистрацию без перехода по ссылке выше. Но, если вы не сделаете этого в течение 7 дней после получения доступа к приложению, учетная запись в up and go будет заблокирована до тех пор, пока Вы не перейдете по ссылке, принимая таким образом \""+app.site_upAndGo+"_Terms_and_Conditions\". С уважением, Юридический отдел", "Body is not correct");
        //softAssert.assertEquals(actualFooter, ""+app.SITE_REG+" Для вашего спокойствия, "+app.site_upAndGo+" осуществляет деятельность при поддержке DiPocket UAB, который авторизован и контролируется Банком Литвы как эмитент электронных денег (#75) Upės str. 23, 08128 Vilnius, LT", "Footer is not correct");
        softAssert.assertAll();
    }

    @Test(enabled = false)// приходит письмо Регистрация виртуальной карты - подтвердите свой e-mail
    public void testTacSodexo() throws InterruptedException, MessagingException, IOException, SQLException, ClassNotFoundException {
        //app.getDbHelper().updateClientLanguageFromDB(app.emailsVerificationsEmail, "1", Site.SODEXO.toString());
        postSendTacEmail(Site.SODEXO.toString());

        String emailSender =  EmailVerificationHelper.getEmailSender(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailBody = getEmailBodyText(emailText, 29, 1551);
        String emailFooter = getEmailFooterText(emailText, 1552);

        assertThat(emailSender, equalTo(expectedUpAndGoSender));
        assertThat(emailBody, equalTo(""));
        assertThat(emailFooter, equalTo(""));
    }

    @Test(enabled = false) // incorrect, body, footer, subject
    public void testTacTelenorEN() throws InterruptedException, MessagingException, IOException, SQLException, ClassNotFoundException {
        app.getDbHelper().updateClientLanguageFromDB(app.emailsVerificationsEmail, String.valueOf(Language.EN.getOurId()), Site.TELENOR.toString());
        postSendTacTelenorEmail(Site.TELENOR.toString());

        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualSender = senderAndSubject.get(0);
        String actualSubject = senderAndSubject.get(1);

        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualBody = getEmailBodyText(emailText, 29, 1400);
        String actualFooter = getEmailFooterText(emailText, 1400);

        //assertThat(actualSender, equalTo());
        assertThat(actualSubject, equalTo(""+app.site_upAndGo+" Terms and Conditions - PLEASE DO NOT DISCARD"));
        assertThat(actualBody, equalTo("Dear "+app.emailsVerificationsFirstName+", Please find attached Terms_and_Conditions\" (the \"T&Cs\"). It is important that you familiarise yourself with these documents and in particular that you review in detail \"up and go_at_a_Glance\", which summarises the key clauses applicable to your up and go account and also includes our current pricing and transaction limits. With regard to Personal Information, we ask you to please read the section in the T&C’s titled 'Personal Information' - we will process any Information you provide to us according those terms. By providing it to us, you are agreeing for us to process it, including any sensitive data for the purposes described in the Agreement subject to a number of rights you have to be informed about how your Information is processed, to correct any errors, to object to any processing, to restrict processing or have Information erased or to instruct us to copy or transfer Information as you direct. If you accept the T&Cs, please click on this link and proceed with the registration process through up and go mobile App. The T&Cs may only be changed upon 2 months notice to you, following which, if you have not objected, you will be deemed to have accepted the new terms. IMPORTANT: to expedite registration you may choose to start using the App even if you have not clicked on the link above. However, if you do not click on it within a week of accessing the App, your up and go account will be temporarily blocked until such time as you have clicked on the link and confirmed your agreement to having read and accepted the T&C’s. With kind regards, Legal Team"));
        assertThat(actualFooter, equalTo(""+app.SITE_REG+" is powered by DiPocket UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT"));
    }

    @Test(enabled = false) // incorrect, body, footer, subject
    public void testTacTelenorHU() throws InterruptedException, MessagingException, IOException, SQLException, ClassNotFoundException {
        app.getDbHelper().updateClientLanguageFromDB(app.emailsVerificationsEmail, String.valueOf(Language.HU.getOurId()), Site.TELENOR.toString());
        postSendTacTelenorEmail(Site.TELENOR.toString());

        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualSender = senderAndSubject.get(0);
        String actualSubject = senderAndSubject.get(1);

        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualBody = getEmailBodyText(emailText, 29, 1400);
        String actualFooter = getEmailFooterText(emailText, 1400);

        //assertThat(actualSender, equalTo());
        assertThat(actualSubject, equalTo(""+app.site_upAndGo+" Terms and Conditions - PLEASE DO NOT DISCARD"));
        assertThat(actualBody, equalTo("Dear "+app.emailsVerificationsFirstName+", Please find attached Terms_and_Conditions\" (the \"T&Cs\"). It is important that you familiarise yourself with these documents and in particular that you review in detail \"up and go_at_a_Glance\", which summarises the key clauses applicable to your up and go account and also includes our current pricing and transaction limits. With regard to Personal Information, we ask you to please read the section in the T&C’s titled 'Personal Information' - we will process any Information you provide to us according those terms. By providing it to us, you are agreeing for us to process it, including any sensitive data for the purposes described in the Agreement subject to a number of rights you have to be informed about how your Information is processed, to correct any errors, to object to any processing, to restrict processing or have Information erased or to instruct us to copy or transfer Information as you direct. If you accept the T&Cs, please click on this link and proceed with the registration process through up and go mobile App. The T&Cs may only be changed upon 2 months notice to you, following which, if you have not objected, you will be deemed to have accepted the new terms. IMPORTANT: to expedite registration you may choose to start using the App even if you have not clicked on the link above. However, if you do not click on it within a week of accessing the App, your up and go account will be temporarily blocked until such time as you have clicked on the link and confirmed your agreement to having read and accepted the T&C’s. With kind regards, Legal Team"));
        assertThat(actualFooter, equalTo(""+app.SITE_REG+" is powered by DiPocket UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT"));
    }
}