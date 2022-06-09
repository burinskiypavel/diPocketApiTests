package tests.emailsVerification.supervision;

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

public class SupervisionEmailTests extends TestBase {
    String expectedSender = "legal.team@dipocket.org";
    String expectedUpAndGoSender = "regulacje@upcard.pl";
    String expectedPlayITSender = "PlayIT Card <playitcard@dipocket.org>";

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
                "\"programNickName\": null\n" +
                "}";
    }

    public void sendSupervisionEmail(int landId, String site, int id) {
        given()
                .spec(app.requestSpecEmailVerification)
                .body(body(landId, site, id))
                .when()
                .post( "/EmailService/sendSupervisionEmail")
                .then()
                .log().all()
                .statusCode(200);
    }

    @DataProvider
    public Iterator<Object[]> Supervision() throws SQLException, ClassNotFoundException {
        List<Object[]> list = new ArrayList<Object[]>();
        list.add(new Object[] {Site.DIPOCKET.toString(), Language.EN.toString(), Language.EN.getOurId(), app.getDbHelper().getClientIdFromDB2(app.emailsVerificationsEmail, app.mobile_site), app.emailsVerificationsEmail, app.emailsVerificationsPass, 0, 398, 399, expectedSender, ""+app.site+" Terms and Conditions - PLEASE DO NOT DISCARD", "Dear "+app.emailsVerificationsFirstName+", Please find attached the section of "+app.site+" Terms and Conditions (the “T&Cs”) regulating Supervised accounts. It is the same that you have already agreed to as part of the T&Cs, but we want to draw your attention on it now that you will start using a Supervised account since it contains important provisions on the Supervisor’s role and responsibilities. With kind regards, Legal Team", ""+app.SITE_REG+" "+app.site+" UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT", "Supervised Accounts T&Cs.pdf"});
        list.add(new Object[] {Site.DIPOCKET.toString(), Language.UK.toString(), Language.UK.getOurId(), app.getDbHelper().getClientIdFromDB2(app.emailsVerificationsEmail, app.mobile_site), app.emailsVerificationsEmail, app.emailsVerificationsPass, 28, 486, 487, expectedSender, "Правила та Умови користування додатком "+app.site+" - будь ласка, збережіть це повідомлення", "Вітаємо, "+app.emailsVerificationsFirstName+"! В додатку знаходиться розділ \"Умови та Правила користування додатком "+app.site+"\" (\"Правила користування\"), який стосується Опіки за рахунком. Ви прийняли їх разом з іншою частиною Правил користування, але зараз ми хочемо ще раз звернути на них Вашу увагу, адже Ви розпочинаєте користуватися Опікунськими рахунками, а в цьому розділі знаходиться більш детальна інформація про роль та відповідальність Опікуна рахунку. З повагою, Юридичний відділ", ""+app.SITE_REG+" Для Вашого спокою, "+app.site+" UAB авторизований та контролюється Банком Литви, як емітент електронних грошей (#75) Upės str. 23, 08128 Vilnius, LT", "Умови використання рахунків під опікою.pdf"});
        list.add(new Object[] {Site.DIPOCKET.toString(), Language.PL.toString(), Language.PL.getOurId(), app.getDbHelper().getClientIdFromDB2(app.emailsVerificationsEmail, app.mobile_site), app.emailsVerificationsEmail,  app.emailsVerificationsPass, 0, 436, 437, expectedSender, "Zasady i Warunki korzystania z aplikacji "+app.site+" - PROSIMY O ZACHOWANIE TEJ WIADOMOŚCI", "Witaj "+app.emailsVerificationsFirstName+", W załączeniu znajduje się sekcja Warunków i Zasad korzystania (\"Warunki korzystania\"), dotycząca Kont Nadzorowanych. Zaakceptowałeś ją wraz z pozostałą częścią Warunków korzystania, jednak chcemy raz jeszcze zwrócić na nią Twoją uwagę teraz, gdy rozpoczynasz korzystanie z Konta Nadzorowanego, a w tej sekcji znajdziesz szczegółowe zapisy dotyczące roli i odpowiedzialności Opiekuna Konta. Z wyrazami szacunku, Dział Prawny", ""+app.SITE_REG+" "+app.site+" UAB, autoryzowana Instytucja Pieniądza Elektronicznego, podlegająca nadzorowi Banku Litwy (numer licencji 75) | Licencjonowana przez Mastercard do działania na Europejskim Obszarze Gospodarczego Upės g. 23, 08128 Vilnius, LT", "Konta Nadzorowane - warunki ogólne.pdf"});
        list.add(new Object[] {Site.DIPOCKET.toString(), Language.RU.toString(), Language.RU.getOurId(), app.getDbHelper().getClientIdFromDB2(app.emailsVerificationsEmail, app.mobile_site), app.emailsVerificationsEmail, app.emailsVerificationsPass, 28, 295, 296, expectedSender, "Условия пользования приложением "+app.site+" - пожалуйста, сохраните это сообщение", "Здравствуйте, "+app.emailsVerificationsFirstName+"! В приложении находится раздел \"Условий пользования приложением "+app.site+"\" об опеке. Вы уже приняли эти условия в момент регистрации, но мы хотим напомнить Вам детали перед началом использования этой функциональности. С уважением, Юридический отдел", ""+app.SITE_REG+" Для вашего спокойствия, "+app.site+" UAB авторизован и контролируется Банком Литвы как эмитент электронных денег (#75) Upės str. 23, 08128 Vilnius, LT", "Условия использования счетов под опекой.pdf"});
        list.add(new Object[] {Site.DISCONTU.toString(), Language.EN.toString(), Language.EN.getOurId(), app.getDbHelper().getClientIdFromDB2(app.emailsVerificationsEmail, app.mobile_site_discontu), app.emailsVerificationsEmail, app.emailsVerificationsPass, 0, 398, 399, expectedSender, ""+app.site_discontu+" Terms and Conditions - PLEASE DO NOT DISCARD", "Dear "+app.emailsVerificationsFirstName+", Please find attached the section of "+app.site_discontu+" Terms and Conditions (the “T&Cs”) regulating Supervised accounts. It is the same that you have already agreed to as part of the T&Cs, but we want to draw your attention on it now that you will start using a Supervised account since it contains important provisions on the Supervisor’s role and responsibilities. With kind regards, Legal Team", ""+app.SITE_REG+" "+app.site_discontu+" is powered by DiPocket UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT", "Supervised Accounts T&Cs.pdf"});
        list.add(new Object[] {Site.DISCONTU.toString(), Language.PL.toString(), Language.PL.getOurId(), app.getDbHelper().getClientIdFromDB2(app.emailsVerificationsEmail, app.mobile_site_discontu), app.emailsVerificationsEmail, app.emailsVerificationsPass, 0, 436, 437, expectedSender, "Zasady i Warunki korzystania z aplikacji "+app.site_discontu+" - PROSIMY O ZACHOWANIE TEJ WIADOMOŚCI", "Witaj "+app.emailsVerificationsFirstName+", W załączeniu znajduje się sekcja Warunków i Zasad korzystania (\"Warunki korzystania\"), dotycząca Kont Nadzorowanych. Zaakceptowałeś ją wraz z pozostałą częścią Warunków korzystania, jednak chcemy raz jeszcze zwrócić na nią Twoją uwagę teraz, gdy rozpoczynasz korzystanie z Konta Nadzorowanego, a w tej sekcji znajdziesz szczegółowe zapisy dotyczące roli i odpowiedzialności Opiekuna Konta. Z wyrazami szacunku, Dział Prawny", ""+app.SITE_REG+" "+app.site_discontu+" dostarcza DiPocket UAB, autoryzowana Instytucja Pieniądza Elektronicznego, podlegająca nadzorowi Banku Litwy (numer licencji 75) | Licencjonowana przez Mastercard do działania na Europejskim Obszarze Gospodarczego Upės g. 23, 08128 Vilnius, LT", "Konta Nadzorowane - warunki ogólne.pdf"});
        list.add(new Object[] {Site.PLAYIT.toString(), Language.EN.toString(), Language.EN.getOurId(), app.getDbHelper().getClientIdFromDB2(app.emailsVerificationsEmail, app.mobile_site_playIt), app.emailsVerificationsEmail, app.emailsVerificationsPass, 0, 396, 397, expectedPlayITSender, ""+app.site_PlayIT+" Terms and Conditions - PLEASE DO NOT DISCARD", "Dear "+app.emailsVerificationsFirstName+", Please find attached the section of "+app.site_PlayIT+" Terms and Conditions (the “T&Cs”) regulating Supervised accounts. It is the same that you have already agreed to as part of the T&Cs, but we want to draw your attention on it now that you will start using a Supervised account since it contains important provisions on the Supervisor’s role and responsibilities. With kind regards, Legal Team", ""+app.SITE_REG+" "+app.site_PlayIT+" is powered by DiPocket UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT", "Supervised Accounts T&Cs.pdf"});
        list.add(new Object[] {Site.PLAYIT.toString(), Language.HU.toString(), Language.HU.getOurId(), app.getDbHelper().getClientIdFromDB2(app.emailsVerificationsEmail, app.mobile_site_playIt), app.emailsVerificationsEmail, app.emailsVerificationsPass, 0, 247, 248, expectedPlayITSender, ""+app.site_PlayIT+" használatának feltételei – KÉRJÜK, NE DOBJA EL", "Kedves "+app.emailsVerificationsFirstName+", Csatolva találja \"A "+app.site_PlayIT+" alkalmazás felügyelt számlák használati feltételei\". Regisztrációkor már elfogadta ezeket a feltételeket, de emlékeztetni szeretnénk a részletekre, mielőtt ezt a funkciót használná. Üdvözlettel, Jogi csapat", ""+app.SITE_REG+" Megnyugtatásul tájékoztatjuk, hogy a "+app.site_PlayIT+" Kártya számládat a DiPocket UAB kezeli, mely vállalatot a Litván Nemzeti Bank elektronikus pénzintézetenként (# 75) engedélyezett és felügyel Upės str. 23, 08128 Vilnius, LT", "Felügyelt számlák használati feltételei.pdf"});
        list.add(new Object[] {Site.SNOW_ATTACK.toString(), Language.EN.toString(), Language.EN.getOurId(), app.getDbHelper().getClientIdFromDB2(app.emailsVerificationsEmail, app.mobile_site_snowAttack), app.emailsVerificationsEmail, app.emailsVerificationsPass, 0, 401, 402, expectedSender, ""+app.site_SnowAttack+" Terms and Conditions - PLEASE DO NOT DISCARD", "Dear "+app.emailsVerificationsFirstName+", Please find attached the section of "+app.site_SnowAttack+" Terms and Conditions (the “T&Cs”) regulating Supervised accounts. It is the same that you have already agreed to as part of the T&Cs, but we want to draw your attention on it now that you will start using a Supervised account since it contains important provisions on the Supervisor’s role and responsibilities. With kind regards, Legal Team", ""+app.SITE_REG+" "+app.site_SnowAttack+" is powered by DiPocket UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT", ""});
        list.add(new Object[] {Site.SNOW_ATTACK.toString(), Language.HU.toString(), Language.HU.getOurId(), app.getDbHelper().getClientIdFromDB2(app.emailsVerificationsEmail, app.mobile_site_snowAttack), app.emailsVerificationsEmail, app.emailsVerificationsPass, 0, 252, 253, expectedSender, ""+app.site_SnowAttack+" használatának feltételei – KÉRJÜK, NE DOBJA EL", "Kedves "+app.emailsVerificationsFirstName+"! Csatolva találja \"A Snow Attack alkalmazás felügyelt számlák használati feltételei\". Regisztrációkor már elfogadta ezeket a feltételeket, de emlékeztetni szeretnénk a részletekre, mielőtt ezt a funkciót használná. Üdvözlettel, Jogi csapat", ""+app.SITE_REG+" "+app.site_SnowAttack+", a DiPocket UAB támogatásával, mely vállalatot a Litván Nemzeti Bank elektronikus pénzintézetenként (# 75) engedélyezett és felügyel | a Mastercard licencével rendelkezik az Európai Gazdasági Térségre vonatkozva Upės str. 23, 08128 Vilnius, LT", ""});
        list.add(new Object[] {Site.UPANDGO.toString(), Language.EN.toString(), Language.EN.getOurId(), app.getDbHelper().getClientIdFromDB2(app.emailsVerificationsEmail, app.mobile_site_upAndGo), app.emailsVerificationsEmail, app.emailsVerificationsPass, 0, 399, 400, expectedUpAndGoSender, ""+app.site_upAndGo+" Terms and Conditions - PLEASE DO NOT DISCARD", "Dear "+app.emailsVerificationsFirstName+", Please find attached the section of "+app.site_upAndGo+" Terms and Conditions (the “T&Cs”) regulating Supervised accounts. It is the same that you have already agreed to as part of the T&Cs, but we want to draw your attention on it now that you will start using a Supervised account since it contains important provisions on the Supervisor’s role and responsibilities. With kind regards, Legal Team", ""+app.SITE_REG+" "+app.site_upAndGo+" is powered by DiPocket UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT", "Supervised Accounts T&Cs.pdf"});
        list.add(new Object[] {Site.UPANDGO.toString(), Language.UK.toString(), Language.UK.getOurId(), app.getDbHelper().getClientIdFromDB2(app.emailsVerificationsEmail, app.mobile_site_upAndGo), app.emailsVerificationsEmail, app.emailsVerificationsPass, 29, 488, 489, expectedUpAndGoSender, "Правила та Умови користування додатком "+app.site_upAndGo+" - будь ласка, збережіть це повідомлення", "Вітаємо, "+app.emailsVerificationsFirstName+"! В додатку знаходиться розділ \"Умови та Правила користування додатком up and go\" (\"Правила користування\"), який стосується Опіки за рахунком. Ви прийняли їх разом з іншою частиною Правил користування, але зараз ми хочемо ще раз звернути на них Вашу увагу, адже Ви розпочинаєте користуватися Опікунськими рахунками, а в цьому розділі знаходиться більш детальна інформація про роль та відповідальність Опікуна рахунку. З повагою, Юридичний відділ", ""+app.SITE_REG+" Для Вашого спокою, "+app.site_upAndGo+" працює при підтримці DiPocket UAB, що авторизований та контролюється Банком Литви, як емітент електронних грошей (#75) Upės str. 23, 08128 Vilnius, LT", "Умови використання рахунків під опікою.pdf"});
        list.add(new Object[] {Site.UPANDGO.toString(), Language.PL.toString(), Language.PL.getOurId(), app.getDbHelper().getClientIdFromDB2(app.emailsVerificationsEmail, app.mobile_site_upAndGo), app.emailsVerificationsEmail, app.emailsVerificationsPass, 0, 436, 437, expectedUpAndGoSender, "Zasady i Warunki korzystania z aplikacji "+app.site_upAndGo+" - PROSIMY O ZACHOWANIE TEJ WIADOMOŚCI", "Witaj "+app.emailsVerificationsFirstName+", W załączeniu znajduje się sekcja Warunków i Zasad korzystania (\"Warunki korzystania\"), dotycząca Kont Nadzorowanych. Zaakceptowałeś ją wraz z pozostałą częścią Warunków korzystania, jednak chcemy raz jeszcze zwrócić na nią Twoją uwagę teraz, gdy rozpoczynasz korzystanie z Konta Nadzorowanego, a w tej sekcji znajdziesz szczegółowe zapisy dotyczące roli i odpowiedzialności Opiekuna Konta. Z wyrazami szacunku, Dział Prawny", ""+app.SITE_REG+" "+app.site_upAndGo+" dostarcza DiPocket UAB, autoryzowana Instytucja Pieniądza Elektronicznego, podlegająca nadzorowi Banku Litwy (numer licencji 75) | Licencjonowana przez Mastercard do działania na Europejskim Obszarze Gospodarczego Upės g. 23, 08128 Vilnius, LT", "Konta Nadzorowane - warunki ogólne.pdf"});
        list.add(new Object[] {Site.UPANDGO.toString(), Language.RU.toString(), Language.RU.getOurId(), app.getDbHelper().getClientIdFromDB2(app.emailsVerificationsEmail, app.mobile_site_upAndGo), app.emailsVerificationsEmail, app.emailsVerificationsPass, 29, 297, 298, expectedUpAndGoSender, "Условия пользования приложением "+app.site_upAndGo+" - пожалуйста, сохраните это сообщение", "Здравствуйте, "+app.emailsVerificationsFirstName+"! В приложении находится раздел \"Условий пользования приложением "+app.site_upAndGo+"\" об опеке. Вы уже приняли эти условия в момент регистрации, но мы хотим напомнить Вам детали перед началом использования этой функциональности. С уважением, Юридический отдел", ""+app.SITE_REG+" Для вашего спокойствия, "+app.site_upAndGo+" осуществляет деятельность при поддержке DiPocket UAB, который авторизован и контролируется Банком Литвы как эмитент электронных денег (#75) Upės str. 23, 08128 Vilnius, LT", "Условия использования счетов под опекой.pdf"});
        return list.iterator();
    }

    @Test(dataProvider = "Supervision")
    public void testSupervision(String site, String lang, int langId, int id, String email, String pass, int bodyBegin, int bodyEnd, int footerEnd, String expectedEmailSender, String expectedEmailSubject, String expectedEmailBody, String expectedEmailFooter, String expectedFileName) throws InterruptedException, MessagingException, IOException, SQLException, ClassNotFoundException {
        app.getDbHelper().updateClientLanguageFromDB(email, String.valueOf(langId), site);
        sendSupervisionEmail(langId, site, id);

        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(email, pass);
        String actualSender = senderAndSubject.get(0);
        String actualSubject = senderAndSubject.get(1);
        List<String>actualAttachedFileNames = EmailVerificationHelper.getFileNameFromEmail("pop.gmail.com", email, pass);
        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", email, pass);
        String actualBody = getEmailBodyText(emailText, bodyBegin, bodyEnd);
        String actualFooter = getEmailFooterText(emailText, footerEnd);

        SoftAssert softAssert = new SoftAssert();
        if(!site.equals("SNOW_ATTACK")){
            softAssert.assertEquals(actualAttachedFileNames, Arrays.asList(expectedFileName), "File name is not correct");

        }
        if(!site.equals("UPANDGO")){
            softAssert.assertEquals(actualSender, expectedEmailSender, "Sender is not correct");
        }
        softAssert.assertEquals(actualSubject, expectedEmailSubject, "Subject is not correct ");
        softAssert.assertEquals(actualBody, expectedEmailBody, "Body is not correct");

        if(!site.equals("UPANDGO")){
            softAssert.assertEquals(actualFooter, expectedEmailFooter, "Footer is not correct");
        }

        softAssert.assertAll();
    }
}