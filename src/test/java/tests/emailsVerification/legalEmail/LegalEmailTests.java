package tests.emailsVerification.legalEmail;

import appmanager.EmailVerificationHelper;
import base.TestBase;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import javax.mail.MessagingException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static appmanager.EmailIMAPHelper.getEmailBodyText;
import static appmanager.EmailIMAPHelper.getEmailFooterText;
import static io.restassured.RestAssured.given;

public class LegalEmailTests extends TestBase {
    String expectedSender = "legal.team@dipocket.org";
    String expectedUpAngGoSender = "regulacje@upcard.pl";
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

    public void sendLegalEmail(int landId, String site, int id) {
        given()
                .spec(app.requestSpecEmailVerification)
                .body(body(landId, site, id))
                .when()
                .post( "/EmailService/sendLegalEmail")
                .then()
                .log().all()
                .statusCode(200);
    }

    @DataProvider
    public Iterator<Object[]> Legal() throws SQLException, ClassNotFoundException {
        List<Object[]> list = new ArrayList<Object[]>();
        list.add(new Object[] {app.mobile_site, "EN", 1, app.getDbHelper().getClientIdFromDB2(app.emailsVerificationsEmail, app.mobile_site), app.emailsVerificationsEmail, app.emailsVerificationsPass, 28, 169, 170, expectedSender, "Your "+app.site+" Legal Documents", "Dear "+app.emailsVerificationsFirstName+", As requested, please find attached selected "+app.site+" legal documents. Thank you for using "+app.site+". With kind regards, Legal Team", ""+app.SITE_REG+" "+app.site+" UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT"});
        list.add(new Object[] {app.mobile_site, "UA", 2, app.getDbHelper().getClientIdFromDB2(app.emailsVerificationsEmail, app.mobile_site), app.emailsVerificationsEmail, app.emailsVerificationsPass, 28, 172, 173, expectedSender, "Ваші юридичні документи "+app.site+"", "Вітаємо, "+app.emailsVerificationsFirstName+"! В додатку знаходяться юридичні документи, що Ви запитали. Дякуємо за користування додатком "+app.site+". З повагою, Юридичний відділ", ""+app.SITE_REG+" Для Вашого спокою, "+app.site+" UAB авторизований та контролюється Банком Литви, як емітент електронних грошей (#75) Upės str. 23, 08128 Vilnius, LT"});
        list.add(new Object[] {app.mobile_site, "PL", 3, app.getDbHelper().getClientIdFromDB2(app.emailsVerificationsEmail, app.mobile_site), app.emailsVerificationsEmail,  app.emailsVerificationsPass, 0, 146, 147, expectedSender, "Twoje dokumenty prawne "+app.site+"", "Witaj "+app.emailsVerificationsFirstName+", W załączniku znajdują się zamówione dokumenty prawne. Dziękujemy za korzystanie z serwisu "+app.site+". Z wyrazami szacunku, Dział Prawny", ""+app.SITE_REG+" "+app.site+" UAB, autoryzowana Instytucja Pieniądza Elektronicznego, podlegająca nadzorowi Banku Litwy (numer licencji 75) | Licencjonowana przez Mastercard do działania na Europejskim Obszarze Gospodarczego Upės g. 23, 08128 Vilnius, LT"});
        list.add(new Object[] {app.mobile_site, "RU", 4, app.getDbHelper().getClientIdFromDB2(app.emailsVerificationsEmail, app.mobile_site), app.emailsVerificationsEmail, app.emailsVerificationsPass, 28, 181, 182, expectedSender, "Документы "+app.site+"", "Здравствуйте, "+app.emailsVerificationsFirstName+"! В приложении находятся юридические документы, которые Вы заказывали. Спасибо за пользование "+app.site+". С уважением, Юридический отдел", ""+app.SITE_REG+" Для вашего спокойствия, "+app.site+" UAB авторизован и контролируется Банком Литвы как эмитент электронных денег (#75) Upės str. 23, 08128 Vilnius, LT"});
        list.add(new Object[] {app.mobile_site_discontu, "EN", 1, app.getDbHelper().getClientIdFromDB2(app.emailsVerificationsEmail, app.mobile_site_discontu), app.emailsVerificationsEmail, app.emailsVerificationsPass, 28, 169, 170, expectedSender, "Your "+app.site_discontu+" Legal Documents", "Dear "+app.emailsVerificationsFirstName+", As requested, please find attached selected "+app.site_discontu+" legal documents. Thank you for using "+app.site_discontu+". With kind regards, Legal Team", ""+app.SITE_REG+" "+app.site_discontu+" is powered by DiPocket UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT"});
        list.add(new Object[] {app.mobile_site_discontu, "PL", 2, app.getDbHelper().getClientIdFromDB2(app.emailsVerificationsEmail, app.mobile_site_discontu), app.emailsVerificationsEmail, app.emailsVerificationsPass, 0, 146, 147, expectedSender, "Twoje dokumenty prawne "+app.site_discontu+"", "Witaj "+app.emailsVerificationsFirstName+", W załączniku znajdują się zamówione dokumenty prawne. Dziękujemy za korzystanie z serwisu "+app.site_discontu+". Z wyrazami szacunku, Dział Prawny", ""+app.SITE_REG+" "+app.site_discontu+" dostarcza DiPocket UAB, autoryzowana Instytucja Pieniądza Elektronicznego, podlegająca nadzorowi Banku Litwy (numer licencji 75) | Licencjonowana przez Mastercard do działania na Europejskim Obszarze Gospodarczego Upės g. 23, 08128 Vilnius, LT"});
        list.add(new Object[] {app.mobile_site_playIt, "EN", 1, app.getDbHelper().getClientIdFromDB2(app.emailsVerificationsEmail, app.mobile_site_playIt), app.emailsVerificationsEmail, app.emailsVerificationsPass, 26, 163, 164, expectedPlayITSender, "Your "+app.site_PlayIT+" Legal Documents", "Dear "+app.emailsVerificationsFirstName+", As requested, please find attached selected "+app.site_PlayIT+" legal documents. Thank you for using "+app.site_PlayIT+". With kind regards, Legal Team", ""+app.SITE_REG+" "+app.site_PlayIT+" is powered by DiPocket UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT"});
        list.add(new Object[] {app.mobile_site_playIt, "HU", 5, app.getDbHelper().getClientIdFromDB2(app.emailsVerificationsEmail, app.mobile_site_playIt), app.emailsVerificationsEmail, app.emailsVerificationsPass, 26, 171, 172, expectedPlayITSender, "Az Ön "+app.site_PlayIT+" jogi dokumentumai", "Kedves "+app.emailsVerificationsFirstName+", Kívánsága szerint, csatolva találja a jogi dokumentumokat. Köszönjük, hogy a PlayIT alkalmazást használja. Üdvözlettel, Jogi csapat", ""+app.SITE_REG+" Megnyugtatásul tájékoztatjuk, hogy a "+app.site_PlayIT+" Kártya számládat a DiPocket UAB kezeli, mely vállalatot a Litván Nemzeti Bank elektronikus pénzintézetenként (# 75) engedélyezett és felügyel Upės str. 23, 08128 Vilnius, LT"});
        list.add(new Object[] {app.mobile_site_snowAttack, "EN", 1, app.getDbHelper().getClientIdFromDB2(app.emailsVerificationsEmail, app.mobile_site_snowAttack), app.emailsVerificationsEmail, app.emailsVerificationsPass, 31, 178, 179, expectedSender, "Your "+app.site_SnowAttack+" Legal Documents", "Dear "+app.emailsVerificationsFirstName+", As requested, please find attached selected "+app.site_SnowAttack+" legal documents. Thank you for using "+app.site_SnowAttack+". With kind regards, Legal Team", ""+app.SITE_REG+" "+app.site_SnowAttack+" is powered by DiPocket UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT"});
        list.add(new Object[] {app.mobile_site_snowAttack, "HU", 5, app.getDbHelper().getClientIdFromDB2(app.emailsVerificationsEmail, app.mobile_site_snowAttack), app.emailsVerificationsEmail, app.emailsVerificationsPass, 31, 181, 182, expectedSender, "Az Ön "+app.site_SnowAttack+" jogi dokumentumai", "Kedves "+app.emailsVerificationsFirstName+"! Kívánsága szerint, csatolva találja a jogi dokumentumokat. Köszönjük, hogy a Snow Attack alkalmazást használja. Üdvözlettel, Jogi csapat", ""+app.SITE_REG+" "+app.site_SnowAttack+", a DiPocket UAB támogatásával, mely vállalatot a Litván Nemzeti Bank elektronikus pénzintézetenként (# 75) engedélyezett és felügyel | a Mastercard licencével rendelkezik az Európai Gazdasági Térségre vonatkozva Upės str. 23, 08128 Vilnius, LT"});
        list.add(new Object[] {app.mobile_site_upAndGo, "EN", 1, app.getDbHelper().getClientIdFromDB2(app.emailsVerificationsEmail, app.mobile_site_upAndGo), app.emailsVerificationsEmail, app.emailsVerificationsPass, 29, 172, 173, expectedUpAngGoSender, "Your "+app.site_upAndGo+" Legal Documents", "Dear "+app.emailsVerificationsFirstName+", As requested, please find attached selected "+app.site_upAndGo+" legal documents. Thank you for using "+app.site_upAndGo+". With kind regards, Legal Team", ""+app.SITE_REG+" "+app.site_upAndGo+" is powered by DiPocket UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT"});
        list.add(new Object[] {app.mobile_site_upAndGo, "UA", 2, app.getDbHelper().getClientIdFromDB2(app.emailsVerificationsEmail, app.mobile_site_upAndGo), app.emailsVerificationsEmail, app.emailsVerificationsPass, 29, 174, 175, expectedUpAngGoSender, "Ваші юридичні документи "+app.site_upAndGo+"", "Вітаємо, "+app.emailsVerificationsFirstName+"! В додатку знаходяться юридичні документи, що Ви запитали. Дякуємо за користування додатком "+app.site_upAndGo+". З повагою, Юридичний відділ", ""+app.SITE_REG+" Для Вашого спокою, "+app.site_upAndGo+" працює при підтримці DiPocket UAB, що авторизований та контролюється Банком Литви, як емітент електронних грошей (#75) Upės str. 23, 08128 Vilnius, LT"});
        list.add(new Object[] {app.mobile_site_upAndGo, "PL", 3, app.getDbHelper().getClientIdFromDB2(app.emailsVerificationsEmail, app.mobile_site_upAndGo), app.emailsVerificationsEmail, app.emailsVerificationsPass, 0, 147, 148, expectedUpAngGoSender, "Twoje dokumenty prawne "+app.site_upAndGo+"", "Witaj "+app.emailsVerificationsFirstName+", W załączniku znajdują się zamówione dokumenty prawne. Dziękujemy za korzystanie z serwisu "+app.site_upAndGo+". Z wyrazami szacunku, Dział Prawny", ""+app.SITE_REG+" "+app.site_upAndGo+" dostarcza DiPocket UAB, autoryzowana Instytucja Pieniądza Elektronicznego, podlegająca nadzorowi Banku Litwy (numer licencji 75) | Licencjonowana przez Mastercard do działania na Europejskim Obszarze Gospodarczego Upės g. 23, 08128 Vilnius, LT"});
        list.add(new Object[] {app.mobile_site_upAndGo, "RU", 4, app.getDbHelper().getClientIdFromDB2(app.emailsVerificationsEmail, app.mobile_site_upAndGo), app.emailsVerificationsEmail, app.emailsVerificationsPass, 29, 183, 184, expectedUpAngGoSender, "Документы "+app.site_upAndGo+"", "Здравствуйте, "+app.emailsVerificationsFirstName+"! В приложении находятся юридические документы, которые Вы заказывали. Спасибо за пользование "+app.site_upAndGo+". С уважением, Юридический отдел", ""+app.SITE_REG+" Для вашего спокойствия, "+app.site_upAndGo+" осуществляет деятельность при поддержке DiPocket UAB, который авторизован и контролируется Банком Литвы как эмитент электронных денег (#75) Upės str. 23, 08128 Vilnius, LT"});
        return list.iterator();
    }

    @Test(dataProvider = "Legal")
    public void testLegalEmail(String site, String lang, int langId, int id, String email, String pass, int bodyBegin, int bodyEnd, int footerEnd, String expectedEmailSender, String expectedEmailSubject, String expectedEmailBody, String expectedEmailFooter) throws InterruptedException, MessagingException, IOException {
        sendLegalEmail(langId, site, id);

        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(email, pass);
        String actualSender = senderAndSubject.get(0);
        String actualSubject = senderAndSubject.get(1);

        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", email, pass);
        String actualBody = getEmailBodyText(emailText, bodyBegin, bodyEnd);
        String actualFooter = getEmailFooterText(emailText, footerEnd);

        SoftAssert softAssert = new SoftAssert();
        if(!site.equals("UPANDGO")){
            softAssert.assertEquals(actualSender, expectedEmailSender, "Sender is not correct");
        }
        softAssert.assertEquals(actualSubject, expectedEmailSubject, "Subject is not correct");
        softAssert.assertEquals(actualBody, expectedEmailBody, "Body is not correct");
        softAssert.assertEquals(actualFooter, expectedEmailFooter, "Footer is not correct");
        softAssert.assertAll();
    }

//    @Test(priority = 1)
//    public void testLegalEmailDipocketEN() throws InterruptedException, MessagingException, IOException {
//        sendLegalEmail(1, app.mobile_site, 32761);
//
//        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(app.emailsVerificationsEmail, app.emailsVerificationsPass);
//        String actualSender = senderAndSubject.get(0);
//        String actualSubject = senderAndSubject.get(1);
//
//        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
//        String actualBody = getEmailBodyText(emailText, 28, 169);
//        String actualFooter = getEmailFooterText(emailText, 170);
//
//        SoftAssert softAssert = new SoftAssert();
//        softAssert.assertEquals(actualSender, expectedSender, "Sender is not correct");
//        softAssert.assertEquals(actualSubject, "Your "+app.site+" Legal Documents", "Subject is not correct");
//        softAssert.assertEquals(actualBody, "Dear "+app.emailsVerificationsFirstName+", As requested, please find attached selected "+app.site+" legal documents. Thank you for using "+app.site+". With kind regards, Legal Team", "Body is not correct");
//        softAssert.assertEquals(actualFooter, ""+app.SITE_REG+" "+app.site+" UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT", "Footer is not correct");
//        softAssert.assertAll();
//    }
//
//    @Test(priority = 2)
//    public void testLegalEmailDipocketUA() throws InterruptedException, MessagingException, IOException {
//        sendLegalEmail(2, app.mobile_site, 32761);
//
//        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(app.emailsVerificationsEmail, app.emailsVerificationsPass);
//        String actualSender = senderAndSubject.get(0);
//        String actualSubject = senderAndSubject.get(1);
//
//        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
//        String actualBody = getEmailBodyText(emailText, 28, 172);
//        String actualFooter = getEmailFooterText(emailText, 173);
//
//        assertThat(actualSender, equalTo(expectedSender));
//        assertThat(actualSubject, equalTo("Ваші юридичні документи "+app.site+""));
//        assertThat(actualBody, equalTo("Вітаємо, "+app.emailsVerificationsFirstName+"! В додатку знаходяться юридичні документи, що Ви запитали. Дякуємо за користування додатком "+app.site+". З повагою, Юридичний відділ"));
//        assertThat(actualFooter, equalTo(""+app.SITE_REG+" Для Вашого спокою, "+app.site+" UAB авторизований та контролюється Банком Литви, як емітент електронних грошей (#75) Upės str. 23, 08128 Vilnius, LT"));
//    }
//
//    @Test(priority = 3)
//    public void testLegalEmailDipocketPL() throws InterruptedException, MessagingException, IOException {
//        sendLegalEmail(3, app.mobile_site, 32761);
//
//        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(app.emailsVerificationsEmail, app.emailsVerificationsPass);
//        String actualSender = senderAndSubject.get(0);
//        String actualSubject = senderAndSubject.get(1);
//
//        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
//        String actualBody = getEmailBodyText(emailText, 0, 146);
//        String actualFooter = getEmailFooterText(emailText, 147);
//
//        assertThat(actualSender, equalTo(expectedSender));
//        assertThat(actualSubject, equalTo("Twoje dokumenty prawne "+app.site+""));
//        assertThat(actualBody, equalTo("Witaj "+app.emailsVerificationsFirstName+", W załączniku znajdują się zamówione dokumenty prawne. Dziękujemy za korzystanie z serwisu "+app.site+". Z wyrazami szacunku, Dział Prawny"));
//        assertThat(actualFooter, equalTo(""+app.SITE_REG+" "+app.site+" UAB, autoryzowana Instytucja Pieniądza Elektronicznego, podlegająca nadzorowi Banku Litwy (numer licencji 75) | Licencjonowana przez Mastercard do działania na Europejskim Obszarze Gospodarczego Upės g. 23, 08128 Vilnius, LT"));
//    }
//
//    @Test(priority = 4)
//    public void testLegalEmailDipocketRU() throws InterruptedException, MessagingException, IOException {
//        sendLegalEmail(4, app.mobile_site, 32761);
//
//        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(app.emailsVerificationsEmail, app.emailsVerificationsPass);
//        String actualSender = senderAndSubject.get(0);
//        String actualSubject = senderAndSubject.get(1);
//
//        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
//        String actualBody = getEmailBodyText(emailText, 28, 181);
//        String actualFooter = getEmailFooterText(emailText, 182);
//
//        assertThat(actualSender, equalTo(expectedSender));
//        assertThat(actualSubject, equalTo("Документы "+app.site+""));
//        assertThat(actualBody, equalTo("Здравствуйте, "+app.emailsVerificationsFirstName+"! В приложении находятся юридические документы, которые Вы заказывали. Спасибо за пользование "+app.site+". С уважением, Юридический отдел"));
//        assertThat(actualFooter, equalTo(""+app.SITE_REG+" Для вашего спокойствия, "+app.site+" UAB авторизован и контролируется Банком Литвы как эмитент электронных денег (#75) Upės str. 23, 08128 Vilnius, LT"));
//    }
//
//    @Test(priority = 5)
//    public void testLegalEmailDiscontuEN() throws InterruptedException, MessagingException, IOException {
//        sendLegalEmail(1, app.mobile_site_discontu, 32717);
//
//        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(app.emailsVerificationsEmail, app.emailsVerificationsPass);
//        String actualSender = senderAndSubject.get(0);
//        String actualSubject = senderAndSubject.get(1);
//
//        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
//        String actualBody = getEmailBodyText(emailText, 28, 169);
//        String actualFooter = getEmailFooterText(emailText, 170);
//
//        assertThat(actualSender, equalTo(expectedSender));
//        assertThat(actualSubject, equalTo("Your "+app.site_discontu+" Legal Documents"));
//        assertThat(actualBody, equalTo("Dear "+app.emailsVerificationsFirstName+", As requested, please find attached selected "+app.site_discontu+" legal documents. Thank you for using "+app.site_discontu+". With kind regards, Legal Team"));
//        assertThat(actualFooter, equalTo(""+app.SITE_REG+" "+app.site_discontu+" is powered by DiPocket UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT"));
//    }
//
//    @Test(priority = 6)
//    public void testLegalEmailDiscontuPL() throws InterruptedException, MessagingException, IOException {
//        sendLegalEmail(3, app.mobile_site_discontu, 32717);
//
//        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(app.emailsVerificationsEmail, app.emailsVerificationsPass);
//        String actualSender = senderAndSubject.get(0);
//        String actualSubject = senderAndSubject.get(1);
//
//        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
//        String actualBody = getEmailBodyText(emailText, 0, 146);
//        String actualFooter = getEmailFooterText(emailText, 147);
//
//        assertThat(actualSender, equalTo(expectedSender));
//        assertThat(actualSubject, equalTo("Twoje dokumenty prawne "+app.site_discontu+""));
//        assertThat(actualBody, equalTo("Witaj "+app.emailsVerificationsFirstName+", W załączniku znajdują się zamówione dokumenty prawne. Dziękujemy za korzystanie z serwisu "+app.site_discontu+". Z wyrazami szacunku, Dział Prawny"));
//        assertThat(actualFooter, equalTo(""+app.SITE_REG+" "+app.site_discontu+" dostarcza DiPocket UAB, autoryzowana Instytucja Pieniądza Elektronicznego, podlegająca nadzorowi Banku Litwy (numer licencji 75) | Licencjonowana przez Mastercard do działania na Europejskim Obszarze Gospodarczego Upės g. 23, 08128 Vilnius, LT"));
//    }
//
//    @Test(priority = 7)
//    public void testLegalEmailPlayITEN() throws InterruptedException, MessagingException, IOException {
//        sendLegalEmail(1, app.mobile_site_playIt, 32732);
//
//        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(app.emailsVerificationsEmail, app.emailsVerificationsPass);
//        String actualSender = senderAndSubject.get(0);
//        String actualSubject = senderAndSubject.get(1);
//
//        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
//        String actualBody = getEmailBodyText(emailText, 26, 163);
//        String actualFooter = getEmailFooterText(emailText, 164);
//
//        assertThat(actualSender, equalTo(expectedPlayITSender));
//        assertThat(actualSubject, equalTo("Your "+app.site_PlayIT+" Legal Documents"));
//        assertThat(actualBody, equalTo("Dear "+app.emailsVerificationsFirstName+", As requested, please find attached selected "+app.site_PlayIT+" legal documents. Thank you for using "+app.site_PlayIT+". With kind regards, Legal Team"));
//        assertThat(actualFooter, equalTo(""+app.SITE_REG+" "+app.site_PlayIT+" is powered by DiPocket UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT"));
//    }
//
//    @Test(priority = 8)
//    public void testLegalEmailPlayITHU() throws InterruptedException, MessagingException, IOException {
//        sendLegalEmail(5, app.mobile_site_playIt, 32732);
//
//        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(app.emailsVerificationsEmail, app.emailsVerificationsPass);
//        String actualSender = senderAndSubject.get(0);
//        String actualSubject = senderAndSubject.get(1);
//
//        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
//        String actualBody = getEmailBodyText(emailText, 26, 171);
//        String actualFooter = getEmailFooterText(emailText, 172);
//
//        assertThat(actualSender, equalTo(expectedPlayITSender));
//        assertThat(actualSubject, equalTo("Az Ön "+app.site_PlayIT+" jogi dokumentumai"));
//        assertThat(actualBody, equalTo("Kedves "+app.emailsVerificationsFirstName+", Kívánsága szerint, csatolva találja a jogi dokumentumokat. Köszönjük, hogy a PlayIT alkalmazást használja. Üdvözlettel, Jogi csapat"));
//        assertThat(actualFooter, equalTo(""+app.SITE_REG+" Megnyugtatásul tájékoztatjuk, hogy a "+app.site_PlayIT+" Kártya számládat a DiPocket UAB kezeli, mely vállalatot a Litván Nemzeti Bank elektronikus pénzintézetenként (# 75) engedélyezett és felügyel Upės str. 23, 08128 Vilnius, LT"));
//    }
//
//    @Test(priority = 9)
//    public void testLegalEmailUpAndGoEN() throws InterruptedException, MessagingException, IOException {
//        sendLegalEmail(1, app.mobile_site_upAndGo, 32727);
//
//        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(app.emailsVerificationsEmail, app.emailsVerificationsPass);
//        String actualSender = senderAndSubject.get(0);
//        String actualSubject = senderAndSubject.get(1);
//
//        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
//        String actualBody = getEmailBodyText(emailText, 29, 172);
//        String actualFooter = getEmailFooterText(emailText, 173);
//
//        SoftAssert softAssert = new SoftAssert();
//        //softAssert.assertEquals(actualSender, expectedUpAngGoSender, "Sender is not correct");
//        softAssert.assertEquals(actualSubject, "Your "+app.site_upAndGo+" Legal Documents", "Subject is not correct");
//        softAssert.assertEquals(actualBody, "Dear "+app.emailsVerificationsFirstName+", As requested, please find attached selected "+app.site_upAndGo+" legal documents. Thank you for using "+app.site_upAndGo+". With kind regards, Legal Team", "Body is not correct");
//        softAssert.assertEquals(actualFooter, ""+app.SITE_REG+" "+app.site_upAndGo+" is powered by DiPocket UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT", "Footer is not correct");
//        softAssert.assertAll();
//    }
//
//    @Test(priority = 10)
//    public void testLegalEmailUpAndGoUA() throws InterruptedException, MessagingException, IOException {
//        sendLegalEmail(2, app.mobile_site_upAndGo, 32727);
//
//        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(app.emailsVerificationsEmail, app.emailsVerificationsPass);
//        String actualSender = senderAndSubject.get(0);
//        String actualSubject = senderAndSubject.get(1);
//
//        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
//        String actualBody = getEmailBodyText(emailText, 29, 174);
//        String actualFooter = getEmailFooterText(emailText, 175);
//
//        SoftAssert softAssert = new SoftAssert();
//        //softAssert.assertEquals(actualSender, expectedUpAngGoSender, "Sender is not correct");
//        softAssert.assertEquals(actualSubject, "Ваші юридичні документи "+app.site_upAndGo+"", "Subject is not correct");
//        softAssert.assertEquals(actualBody, "Вітаємо, "+app.emailsVerificationsFirstName+"! В додатку знаходяться юридичні документи, що Ви запитали. Дякуємо за користування додатком "+app.site_upAndGo+". З повагою, Юридичний відділ", "Body is not correct");
//        softAssert.assertEquals(actualFooter, ""+app.SITE_REG+" Для Вашого спокою, "+app.site_upAndGo+" працює при підтримці DiPocket UAB, що авторизований та контролюється Банком Литви, як емітент електронних грошей (#75) Upės str. 23, 08128 Vilnius, LT", "Footer is not correct");
//        softAssert.assertAll();
//    }
//
//    @Test(priority = 11)
//    public void testLegalEmailUpAndGoPL() throws InterruptedException, MessagingException, IOException {
//        sendLegalEmail(3, app.mobile_site_upAndGo, 32727);
//
//        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(app.emailsVerificationsEmail, app.emailsVerificationsPass);
//        String actualSender = senderAndSubject.get(0);
//        String actualSubject = senderAndSubject.get(1);
//
//        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
//        String actualBody = getEmailBodyText(emailText, 0, 147);
//        String actualFooter = getEmailFooterText(emailText, 148);
//
//        SoftAssert softAssert = new SoftAssert();
//        //softAssert.assertEquals(actualSender, expectedUpAngGoSender, "Sender is not correct");
//        softAssert.assertEquals(actualSubject, "Twoje dokumenty prawne "+app.site_upAndGo+"", "Subject is not correct");
//        softAssert.assertEquals(actualBody, "Witaj "+app.emailsVerificationsFirstName+", W załączniku znajdują się zamówione dokumenty prawne. Dziękujemy za korzystanie z serwisu "+app.site_upAndGo+". Z wyrazami szacunku, Dział Prawny", "Body is not correct");
//        softAssert.assertEquals(actualFooter, ""+app.SITE_REG+" "+app.site_upAndGo+" dostarcza DiPocket UAB, autoryzowana Instytucja Pieniądza Elektronicznego, podlegająca nadzorowi Banku Litwy (numer licencji 75) | Licencjonowana przez Mastercard do działania na Europejskim Obszarze Gospodarczego Upės g. 23, 08128 Vilnius, LT", "Footer is not correct");
//        softAssert.assertAll();
//    }
//
//    @Test(priority = 12)
//    public void testLegalEmailUpAndGoRU() throws InterruptedException, MessagingException, IOException {
//        sendLegalEmail(4, app.mobile_site_upAndGo, 32727);
//
//        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(app.emailsVerificationsEmail, app.emailsVerificationsPass);
//        String actualSender = senderAndSubject.get(0);
//        String actualSubject = senderAndSubject.get(1);
//
//        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
//        String actualBody = getEmailBodyText(emailText, 29, 183);
//        String actualFooter = getEmailFooterText(emailText, 184);
//
//        SoftAssert softAssert = new SoftAssert();
//        //softAssert.assertEquals(actualSender, expectedUpAngGoSender, "Sender is not correct");
//        softAssert.assertEquals(actualSubject, "Документы "+app.site_upAndGo+"", "Subject is not correct");
//        softAssert.assertEquals(actualBody, "Здравствуйте, "+app.emailsVerificationsFirstName+"! В приложении находятся юридические документы, которые Вы заказывали. Спасибо за пользование "+app.site_upAndGo+". С уважением, Юридический отдел", "Boody is not correct");
//        softAssert.assertEquals(actualFooter, ""+app.SITE_REG+" Для вашего спокойствия, "+app.site_upAndGo+" осуществляет деятельность при поддержке DiPocket UAB, который авторизован и контролируется Банком Литвы как эмитент электронных денег (#75) Upės str. 23, 08128 Vilnius, LT", "Footer is not correct");
//        softAssert.assertAll();
//    }
//
//    @Test(priority = 13)
//    public void testLegalEmailSnowAttackEN() throws InterruptedException, MessagingException, IOException {
//        sendLegalEmail(1, app.mobile_site_snowAttack, 32855);
//
//        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(app.emailsVerificationsEmail, app.emailsVerificationsPass);
//        String actualSender = senderAndSubject.get(0);
//        String actualSubject = senderAndSubject.get(1);
//
//        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
//        String actualBody = getEmailBodyText(emailText, 31, 178);
//        String actualFooter = getEmailFooterText(emailText, 179);
//
//        SoftAssert softAssert = new SoftAssert();
//        softAssert.assertEquals(actualSender, expectedSender, "Sender is not correct");
//        softAssert.assertEquals(actualSubject, "Your "+app.site_SnowAttack+" Legal Documents", "Subject is not correct");
//        softAssert.assertEquals(actualBody, "Dear "+app.emailsVerificationsFirstName+", As requested, please find attached selected "+app.site_SnowAttack+" legal documents. Thank you for using "+app.site_SnowAttack+". With kind regards, Legal Team", "Boody is not correct");
//        softAssert.assertEquals(actualFooter, ""+app.SITE_REG+" "+app.site_SnowAttack+" is powered by DiPocket UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT", "Footer is not correct");
//        softAssert.assertAll();
//    }
//
//    @Test(priority = 14)
//    public void testLegalEmailSnowAttackHU() throws InterruptedException, MessagingException, IOException {
//        sendLegalEmail(5, app.mobile_site_snowAttack, 32855);
//
//        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(app.emailsVerificationsEmail, app.emailsVerificationsPass);
//        String actualSender = senderAndSubject.get(0);
//        String actualSubject = senderAndSubject.get(1);
//
//        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
//        String actualBody = getEmailBodyText(emailText, 31, 181);
//        String actualFooter = getEmailFooterText(emailText, 182);
//
//        SoftAssert softAssert = new SoftAssert();
//        softAssert.assertEquals(actualSender, expectedSender, "Sender is not correct");
//        softAssert.assertEquals(actualSubject, "Az Ön "+app.site_SnowAttack+" jogi dokumentumai", "Subject is not correct");
//        softAssert.assertEquals(actualBody, "Kedves "+app.emailsVerificationsFirstName+"! Kívánsága szerint, csatolva találja a jogi dokumentumokat. Köszönjük, hogy a Snow Attack alkalmazást használja. Üdvözlettel, Jogi csapat", "Boody is not correct");
//        softAssert.assertEquals(actualFooter, ""+app.SITE_REG+" "+app.site_SnowAttack+", a DiPocket UAB támogatásával, mely vállalatot a Litván Nemzeti Bank elektronikus pénzintézetenként (# 75) engedélyezett és felügyel | a Mastercard licencével rendelkezik az Európai Gazdasági Térségre vonatkozva Upės str. 23, 08128 Vilnius, LT", "Footer is not correct");
//        softAssert.assertAll();
//    }
}