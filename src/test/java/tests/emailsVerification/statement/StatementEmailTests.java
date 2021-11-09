package tests.emailsVerification.statement;

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
import java.util.Iterator;
import java.util.List;

import static appmanager.EmailIMAPHelper.getEmailBodyText;
import static appmanager.EmailIMAPHelper.getEmailFooterText;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class StatementEmailTests extends TestBase {
    String expectedSender = "statements@dipocket.org";
    String expectedUpAndGoSender = "zestawienia@upcard.pl";
    String expectedPlayITSender = "PlayIT Card <statements@dipocket.org>";

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

    public void sendStatementEmail(int landId, String site, int id) {
        given()
                .spec(app.requestSpecEmailVerification)
                .body(body(landId, site, id))
                .when()
                .post( "/EmailService/sendStatementEmail")
                .then()
                .log().all()
                .statusCode(200);
    }

    @DataProvider
    public Iterator<Object[]> Statement() throws SQLException, ClassNotFoundException {
        List<Object[]> list = new ArrayList<Object[]>();
        list.add(new Object[] {Site.DIPOCKET.toString(), Language.EN.toString(), Language.EN.getOurId(), app.getDbHelper().getClientIdFromDB2(app.emailsVerificationsEmail, app.mobile_site), app.emailsVerificationsEmail, app.emailsVerificationsPass, 28, 170, 171, expectedSender, "Your "+app.site+" account statement", "Dear "+app.emailsVerificationsFirstName+", As requested, please find attached your "+app.site+" account statement(s). Thank you for using "+app.site+". With kind regards, Legal Team", ""+app.SITE_REG+" "+app.site+" UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT"});
        list.add(new Object[] {Site.DIPOCKET.toString(), Language.UK.toString(), Language.UK.getOurId(), app.getDbHelper().getClientIdFromDB2(app.emailsVerificationsEmail, app.mobile_site), app.emailsVerificationsEmail, app.emailsVerificationsPass, 28, 191, 192, expectedSender, "Виписка по рахунку "+app.site+"", "Вітаємо, "+app.emailsVerificationsFirstName+"! В додатку знаходиться замовлена Вами банківська виписка по рахунку "+app.site+". Дякуємо за користування додатком "+app.site+". З повагою, Юридичний відділ", ""+app.SITE_REG+" Для Вашого спокою, "+app.site+" UAB авторизований та контролюється Банком Литви, як емітент електронних грошей (#75) Upės str. 23, 08128 Vilnius, LT"});
        list.add(new Object[] {Site.DIPOCKET.toString(), Language.PL.toString(), Language.PL.getOurId(), app.getDbHelper().getClientIdFromDB2(app.emailsVerificationsEmail, app.mobile_site), app.emailsVerificationsEmail,  app.emailsVerificationsPass, 0, 153, 154, expectedSender, "Twój wyciąg z konta "+app.site+"", "Witaj "+app.emailsVerificationsFirstName+", W załączniku znajduje się zamówiony wyciąg z konta "+app.site+". Dziękujemy za korzystanie z serwisu "+app.site+". Z wyrazami szacunku, Dział Prawny", ""+app.SITE_REG+" "+app.site+" UAB, autoryzowana Instytucja Pieniądza Elektronicznego, podlegająca nadzorowi Banku Litwy (numer licencji 75) | Licencjonowana przez Mastercard do działania na Europejskim Obszarze Gospodarczego Upės g. 23, 08128 Vilnius, LT"});
        list.add(new Object[] {Site.DIPOCKET.toString(), Language.RU.toString(), Language.RU.getOurId(), app.getDbHelper().getClientIdFromDB2(app.emailsVerificationsEmail, app.mobile_site), app.emailsVerificationsEmail, app.emailsVerificationsPass, 0, 146, 147, expectedSender, "Выписка по счету "+app.site+"", "Здравствуйте, "+app.emailsVerificationsFirstName+"! К письму прикреплена выписка по счету, которую Вы заказывали. Спасибо за пользование "+app.site+". С уважением, Юридический отдел", ""+app.SITE_REG+" Для вашего спокойствия, "+app.site+" UAB авторизован и контролируется Банком Литвы как эмитент электронных денег (#75) Upės str. 23, 08128 Vilnius, LT"});
        list.add(new Object[] {Site.DISCONTU.toString(), Language.EN.toString(), Language.EN.getOurId(), app.getDbHelper().getClientIdFromDB2(app.emailsVerificationsEmail, app.mobile_site_discontu), app.emailsVerificationsEmail, app.emailsVerificationsPass, 28, 170, 171, expectedSender, "Your "+app.site_discontu+" account statement", "Dear "+app.emailsVerificationsFirstName+", As requested, please find attached your "+app.site_discontu+" account statement(s). Thank you for using "+app.site_discontu+". With kind regards, Legal Team", ""+app.SITE_REG+" "+app.site_discontu+" is powered by DiPocket UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT"});
        list.add(new Object[] {Site.DISCONTU.toString(), Language.PL.toString(), Language.PL.getOurId(), app.getDbHelper().getClientIdFromDB2(app.emailsVerificationsEmail, app.mobile_site_discontu), app.emailsVerificationsEmail, app.emailsVerificationsPass, 0, 153, 154, expectedSender, "Twój wyciąg z konta "+app.site_discontu+"", "Witaj "+app.emailsVerificationsFirstName+", W załączniku znajduje się zamówiony wyciąg z konta "+app.site_discontu+". Dziękujemy za korzystanie z serwisu "+app.site_discontu+". Z wyrazami szacunku, Dział Prawny", ""+app.SITE_REG+" "+app.site_discontu+" dostarcza DiPocket UAB, autoryzowana Instytucja Pieniądza Elektronicznego, podlegająca nadzorowi Banku Litwy (numer licencji 75) | Licencjonowana przez Mastercard do działania na Europejskim Obszarze Gospodarczego Upės g. 23, 08128 Vilnius, LT"});
        list.add(new Object[] {Site.PLAYIT.toString(), Language.EN.toString(), Language.EN.getOurId(), app.getDbHelper().getClientIdFromDB2(app.emailsVerificationsEmail, app.mobile_site_playIt), app.emailsVerificationsEmail, app.emailsVerificationsPass, 26, 164, 165, expectedPlayITSender, "Your "+app.site_PlayIT+" account statement", "Dear "+app.emailsVerificationsFirstName+", As requested, please find attached your "+app.site_PlayIT+" account statement(s). Thank you for using "+app.site_PlayIT+". With kind regards, Legal Team", ""+app.SITE_REG+" "+app.site_PlayIT+" is powered by DiPocket UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT"});
        list.add(new Object[] {Site.PLAYIT.toString(), Language.HU.toString(), Language.HU.getOurId(), app.getDbHelper().getClientIdFromDB2(app.emailsVerificationsEmail, app.mobile_site_playIt), app.emailsVerificationsEmail, app.emailsVerificationsPass, 26, 186, 187, expectedPlayITSender, "AZ Ön "+app.site_PlayIT+" számlakivonata", "Kedves "+app.emailsVerificationsFirstName+", Kívánsága szerint, csatolva találja a számlakivonatát (számlakivonatait). Köszönjük, hogy a PlayIT alkalmazást használja. Üdvözlettel, Jogi csapat", ""+app.SITE_REG+" Megnyugtatásul tájékoztatjuk, hogy a PlayIT Kártya számládat a DiPocket UAB kezeli, mely vállalatot a Litván Nemzeti Bank elektronikus pénzintézetenként (# 75) engedélyezett és felügyel Upės str. 23, 08128 Vilnius, LT"});
        list.add(new Object[] {Site.SNOW_ATTACK.toString(), Language.EN.toString(), Language.EN.getOurId(), app.getDbHelper().getClientIdFromDB2(app.emailsVerificationsEmail, app.mobile_site_snowAttack), app.emailsVerificationsEmail, app.emailsVerificationsPass, 31, 179, 180, expectedSender, "Your "+app.site_SnowAttack+" account statement", "Dear "+app.emailsVerificationsFirstName+", As requested, please find attached your "+app.site_SnowAttack+" account statement(s). Thank you for using "+app.site_SnowAttack+". With kind regards, Legal Team", ""+app.SITE_REG+" "+app.site_SnowAttack+" is powered by DiPocket UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT"});
        list.add(new Object[] {Site.SNOW_ATTACK.toString(), Language.HU.toString(), Language.HU.getOurId(), app.getDbHelper().getClientIdFromDB2(app.emailsVerificationsEmail, app.mobile_site_snowAttack), app.emailsVerificationsEmail, app.emailsVerificationsPass, 31, 196, 197, expectedSender, "AZ Ön "+app.site_SnowAttack+" számlakivonata", "Kedves "+app.emailsVerificationsFirstName+", Kívánsága szerint, csatolva találja a számlakivonatát (számlakivonatait). Köszönjük, hogy a "+app.site_SnowAttack+" alkalmazást használja. Üdvözlettel, Jogi csapat", ""+app.SITE_REG+" "+app.site_SnowAttack+", a DiPocket UAB támogatásával, mely vállalatot a Litván Nemzeti Bank elektronikus pénzintézetenként (# 75) engedélyezett és felügyel | a Mastercard licencével rendelkezik az Európai Gazdasági Térségre vonatkozva Upės str. 23, 08128 Vilnius, LT"});
        list.add(new Object[] {Site.UPANDGO.toString(), Language.EN.toString(), Language.EN.getOurId(), app.getDbHelper().getClientIdFromDB2(app.emailsVerificationsEmail, app.mobile_site_upAndGo), app.emailsVerificationsEmail, app.emailsVerificationsPass, 29, 173, 174, expectedUpAndGoSender, "Your "+app.site_upAndGo+" account statement", "Dear "+app.emailsVerificationsFirstName+", As requested, please find attached your up and go account statement(s). Thank you for using "+app.site_upAndGo+". With kind regards, Legal Team", ""+app.SITE_REG+" "+app.site_upAndGo+" is powered by DiPocket UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT"});
        list.add(new Object[] {Site.UPANDGO.toString(), Language.UK.toString(), Language.UK.getOurId(), app.getDbHelper().getClientIdFromDB2(app.emailsVerificationsEmail, app.mobile_site_upAndGo), app.emailsVerificationsEmail, app.emailsVerificationsPass, 29, 194, 195, expectedUpAndGoSender, "Виписка по рахунку "+app.site_upAndGo+"", "Вітаємо, "+app.emailsVerificationsFirstName+"! В додатку знаходиться замовлена Вами банківська виписка по рахунку "+app.site_upAndGo+". Дякуємо за користування додатком "+app.site_upAndGo+". З повагою, Юридичний відділ", ""+app.SITE_REG+" Для Вашого спокою, "+app.site_upAndGo+" працює при підтримці DiPocket UAB, що авторизований та контролюється Банком Литви, як емітент електронних грошей (#75) Upės str. 23, 08128 Vilnius, LT"});
        list.add(new Object[] {Site.UPANDGO.toString(), Language.PL.toString(), Language.PL.getOurId(), app.getDbHelper().getClientIdFromDB2(app.emailsVerificationsEmail, app.mobile_site_upAndGo), app.emailsVerificationsEmail, app.emailsVerificationsPass, 0, 155, 156, expectedUpAndGoSender, "Twój wyciąg z konta "+app.site_upAndGo+"", "Witaj "+app.emailsVerificationsFirstName+", W załączniku znajduje się zamówiony wyciąg z konta up and go. Dziękujemy za korzystanie z serwisu "+app.site_upAndGo+". Z wyrazami szacunku, Dział Prawny", ""+app.SITE_REG+" "+app.site_upAndGo+" dostarcza DiPocket UAB, autoryzowana Instytucja Pieniądza Elektronicznego, podlegająca nadzorowi Banku Litwy (numer licencji 75) | Licencjonowana przez Mastercard do działania na Europejskim Obszarze Gospodarczego Upės g. 23, 08128 Vilnius, LT"});
        list.add(new Object[] {Site.UPANDGO.toString(), Language.RU.toString(), Language.RU.getOurId(), app.getDbHelper().getClientIdFromDB2(app.emailsVerificationsEmail, app.mobile_site_upAndGo), app.emailsVerificationsEmail, app.emailsVerificationsPass, 29, 176, 177, expectedUpAndGoSender, "Выписка по счету "+app.site_upAndGo+"", "Здравствуйте, "+app.emailsVerificationsFirstName+"! К письму прикреплена выписка по счету, которую Вы заказывали. Спасибо за пользование "+app.site_upAndGo+". С уважением, Юридический отдел", ""+app.SITE_REG+" Для вашего спокойствия, "+app.site_upAndGo+" осуществляет деятельность при поддержке DiPocket UAB, который авторизован и контролируется Банком Литвы как эмитент электронных денег (#75) Upės str. 23, 08128 Vilnius, LT"});
        return list.iterator();
    }

    @Test(dataProvider = "Statement")
    public void testStatement(String site, String lang, int langId, int id, String email, String pass, int bodyBegin, int bodyEnd, int footerEnd, String expectedEmailSender, String expectedEmailSubject, String expectedEmailBody, String expectedEmailFooter) throws InterruptedException, MessagingException, IOException, SQLException, ClassNotFoundException {
        sendStatementEmail(langId, site, id);

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

        if(!site.equals("UPANDGO")){
            softAssert.assertEquals(actualFooter, expectedEmailFooter, "Footer is not correct");
        }

        softAssert.assertAll();
    }

//    @Test
//    public void testStatementEmailDipocketEN() throws InterruptedException, MessagingException, IOException {
//        sendStatementEmail(1, app.mobile_site, 32761);
//
//        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(app.emailsVerificationsEmail, app.emailsVerificationsPass);
//        String actualSender = senderAndSubject.get(0);
//        String actualSubject = senderAndSubject.get(1);
//
//        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
//        String actualBody = getEmailBodyText(emailText, 28, 170);
//        String actualFooter = getEmailFooterText(emailText, 171);
//
//        assertThat(actualSender, equalTo(expectedSender));
//        assertThat(actualSubject, equalTo("Your "+app.site+" account statement"));
//        assertThat(actualBody, equalTo("Dear "+app.emailsVerificationsFirstName+", As requested, please find attached your "+app.site+" account statement(s). Thank you for using "+app.site+". With kind regards, Legal Team"));
//        assertThat(actualFooter, equalTo(""+app.SITE_REG+" "+app.site+" UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT"));
//    }
//
//    @Test
//    public void testStatementEmailDipocketUA() throws InterruptedException, MessagingException, IOException {
//        sendStatementEmail(2, app.mobile_site, 32761);
//
//        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(app.emailsVerificationsEmail, app.emailsVerificationsPass);
//        String actualSender = senderAndSubject.get(0);
//        String actualSubject = senderAndSubject.get(1);
//
//        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
//        String actualBody = getEmailBodyText(emailText, 28, 191);
//        String actualFooter = getEmailFooterText(emailText, 192);
//
//        assertThat(actualSender, equalTo(expectedSender));
//        assertThat(actualSubject, equalTo("Виписка по рахунку "+app.site+""));
//        assertThat(actualBody, equalTo("Вітаємо, "+app.emailsVerificationsFirstName+"! В додатку знаходиться замовлена Вами банківська виписка по рахунку "+app.site+". Дякуємо за користування додатком "+app.site+". З повагою, Юридичний відділ"));
//        assertThat(actualFooter, equalTo(""+app.SITE_REG+" Для Вашого спокою, "+app.site+" UAB авторизований та контролюється Банком Литви, як емітент електронних грошей (#75) Upės str. 23, 08128 Vilnius, LT"));
//    }
//
//    @Test
//    public void testStatementEmailDipocketPL() throws InterruptedException, MessagingException, IOException {
//        sendStatementEmail(3, app.mobile_site, 32761);
//
//        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(app.emailsVerificationsEmail, app.emailsVerificationsPass);
//        String actualSender = senderAndSubject.get(0);
//        String actualSubject = senderAndSubject.get(1);
//
//        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
//        String actualBody = getEmailBodyText(emailText, 0, 153);
//        String actualFooter = getEmailFooterText(emailText, 154);
//
//        assertThat(actualSender, equalTo(expectedSender));
//        assertThat(actualSubject, equalTo("Twój wyciąg z konta "+app.site+""));
//        assertThat(actualBody, equalTo("Witaj "+app.emailsVerificationsFirstName+", W załączniku znajduje się zamówiony wyciąg z konta "+app.site+". Dziękujemy za korzystanie z serwisu "+app.site+". Z wyrazami szacunku, Dział Prawny"));
//        assertThat(actualFooter, equalTo(""+app.SITE_REG+" "+app.site+" UAB, autoryzowana Instytucja Pieniądza Elektronicznego, podlegająca nadzorowi Banku Litwy (numer licencji 75) | Licencjonowana przez Mastercard do działania na Europejskim Obszarze Gospodarczego Upės g. 23, 08128 Vilnius, LT"));
//    }
//
//    @Test
//    public void testStatementEmailDipocketRU() throws InterruptedException, MessagingException, IOException {
//        sendStatementEmail(4, app.mobile_site, 32761);
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
//        assertThat(actualSubject, equalTo("Выписка по счету "+app.site+""));
//        assertThat(actualBody, equalTo("Здравствуйте, "+app.emailsVerificationsFirstName+"! К письму прикреплена выписка по счету, которую Вы заказывали. Спасибо за пользование "+app.site+". С уважением, Юридический отдел"));
//        assertThat(actualFooter, equalTo(""+app.SITE_REG+" Для вашего спокойствия, "+app.site+" UAB авторизован и контролируется Банком Литвы как эмитент электронных денег (#75) Upės str. 23, 08128 Vilnius, LT"));
//    }
//
//    @Test
//    public void testStatementEmailDiscontuEN() throws InterruptedException, MessagingException, IOException {
//        sendStatementEmail(1, app.mobile_site_discontu, 32717);
//
//        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(app.emailsVerificationsEmail, app.emailsVerificationsPass);
//        String actualSender = senderAndSubject.get(0);
//        String actualSubject = senderAndSubject.get(1);
//
//        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
//        String actualBody = getEmailBodyText(emailText, 28, 170);
//        String actualFooter = getEmailFooterText(emailText, 171);
//
//        assertThat(actualSender, equalTo(expectedSender));
//        assertThat(actualSubject, equalTo("Your "+app.site_discontu+" account statement"));
//        assertThat(actualBody, equalTo("Dear "+app.emailsVerificationsFirstName+", As requested, please find attached your "+app.site_discontu+" account statement(s). Thank you for using "+app.site_discontu+". With kind regards, Legal Team"));
//        assertThat(actualFooter, equalTo(""+app.SITE_REG+" "+app.site_discontu+" is powered by DiPocket UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT"));
//    }
//
//    @Test
//    public void testStatementEmailDiscontuPL() throws InterruptedException, MessagingException, IOException {
//        sendStatementEmail(3, app.mobile_site_discontu, 32717);
//
//        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(app.emailsVerificationsEmail, app.emailsVerificationsPass);
//        String actualSender = senderAndSubject.get(0);
//        String actualSubject = senderAndSubject.get(1);
//
//        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
//        String actualBody = getEmailBodyText(emailText, 0, 153);
//        String actualFooter = getEmailFooterText(emailText, 154);
//
//        assertThat(actualSender, equalTo(expectedSender));
//        assertThat(actualSubject, equalTo("Twój wyciąg z konta "+app.site_discontu+""));
//        assertThat(actualBody, equalTo("Witaj "+app.emailsVerificationsFirstName+", W załączniku znajduje się zamówiony wyciąg z konta "+app.site_discontu+". Dziękujemy za korzystanie z serwisu "+app.site_discontu+". Z wyrazami szacunku, Dział Prawny"));
//        assertThat(actualFooter, equalTo(""+app.SITE_REG+" "+app.site_discontu+" dostarcza DiPocket UAB, autoryzowana Instytucja Pieniądza Elektronicznego, podlegająca nadzorowi Banku Litwy (numer licencji 75) | Licencjonowana przez Mastercard do działania na Europejskim Obszarze Gospodarczego Upės g. 23, 08128 Vilnius, LT"));
//    }
//
//    @Test
//    public void testStatementEmailPlayITEN() throws InterruptedException, MessagingException, IOException {
//        sendStatementEmail(1, app.mobile_site_playIt, 32732);
//
//        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(app.emailsVerificationsEmail, app.emailsVerificationsPass);
//        String actualSender = senderAndSubject.get(0);
//        String actualSubject = senderAndSubject.get(1);
//
//        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
//        String actualBody = getEmailBodyText(emailText, 26, 164);
//        String actualFooter = getEmailFooterText(emailText, 165);
//
//        assertThat(actualSender, equalTo(expectedPlayITSender));
//        assertThat(actualSubject, equalTo("Your "+app.site_PlayIT+" account statement"));
//        assertThat(actualBody, equalTo("Dear "+app.emailsVerificationsFirstName+", As requested, please find attached your "+app.site_PlayIT+" account statement(s). Thank you for using "+app.site_PlayIT+". With kind regards, Legal Team"));
//        assertThat(actualFooter, equalTo(""+app.SITE_REG+" "+app.site_PlayIT+" is powered by DiPocket UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT"));
//    }
//
//    @Test
//    public void testStatementEmailPlayITHU() throws InterruptedException, MessagingException, IOException {
//        sendStatementEmail(5, app.mobile_site_playIt, 32732);
//
//        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(app.emailsVerificationsEmail, app.emailsVerificationsPass);
//        String actualSender = senderAndSubject.get(0);
//        String actualSubject = senderAndSubject.get(1);
//
//        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
//        String actualBody = getEmailBodyText(emailText, 26, 186);
//        String actualFooter = getEmailFooterText(emailText, 187);
//
//        assertThat(actualSender, equalTo(expectedPlayITSender));
//        assertThat(actualSubject, equalTo("AZ Ön "+app.site_PlayIT+" számlakivonata"));
//        assertThat(actualBody, equalTo("Kedves "+app.emailsVerificationsFirstName+", Kívánsága szerint, csatolva találja a számlakivonatát (számlakivonatait). Köszönjük, hogy a PlayIT alkalmazást használja. Üdvözlettel, Jogi csapat"));
//        assertThat(actualFooter, equalTo(""+app.SITE_REG+" Megnyugtatásul tájékoztatjuk, hogy a PlayIT Kártya számládat a DiPocket UAB kezeli, mely vállalatot a Litván Nemzeti Bank elektronikus pénzintézetenként (# 75) engedélyezett és felügyel Upės str. 23, 08128 Vilnius, LT"));
//    }
//
//    @Test
//    public void testStatementEmailUpAndGoEN() throws InterruptedException, MessagingException, IOException {
//        sendStatementEmail(1, app.mobile_site_upAndGo, 32727);
//
//        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(app.emailsVerificationsEmail, app.emailsVerificationsPass);
//        String actualSender = senderAndSubject.get(0);
//        String actualSubject = senderAndSubject.get(1);
//
//        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
//        String actualBody = getEmailBodyText(emailText, 29, 173);
//        String actualFooter = getEmailFooterText(emailText, 174);
//
//        assertThat(actualSender, equalTo(expectedUpAndGoSender));
//        assertThat(actualSubject, equalTo("Your "+app.site_upAndGo+" account statement"));
//        assertThat(actualBody, equalTo("Dear "+app.emailsVerificationsFirstName+", As requested, please find attached your up and go account statement(s). Thank you for using "+app.site_upAndGo+". With kind regards, Legal Team"));
//        //assertThat(actualFooter, equalTo(""+app.SITE_REG+" "+app.site_upAndGo+" is powered by DiPocket UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT"));
//    }
//
//    @Test
//    public void testStatementEmailUpAndGoUA() throws InterruptedException, MessagingException, IOException {
//        sendStatementEmail(2, app.mobile_site_upAndGo, 32727);
//
//        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(app.emailsVerificationsEmail, app.emailsVerificationsPass);
//        String actualSender = senderAndSubject.get(0);
//        String actualSubject = senderAndSubject.get(1);
//
//        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
//        String actualBody = getEmailBodyText(emailText, 29, 194);
//        String actualFooter = getEmailFooterText(emailText, 195);
//
//        assertThat(actualSender, equalTo(expectedUpAndGoSender));
//        assertThat(actualSubject, equalTo("Виписка по рахунку "+app.site_upAndGo+""));
//        assertThat(actualBody, equalTo("Вітаємо, "+app.emailsVerificationsFirstName+"! В додатку знаходиться замовлена Вами банківська виписка по рахунку "+app.site_upAndGo+". Дякуємо за користування додатком "+app.site_upAndGo+". З повагою, Юридичний відділ"));
//        //assertThat(actualFooter, equalTo(""+app.SITE_REG+" Для Вашого спокою, "+app.site_upAndGo+" працює при підтримці DiPocket UAB, що авторизований та контролюється Банком Литви, як емітент електронних грошей (#75) Upės str. 23, 08128 Vilnius, LT"));
//    }
//
//    @Test
//    public void testStatementEmailUpAndGoPL() throws InterruptedException, MessagingException, IOException {
//        sendStatementEmail(3, app.mobile_site_upAndGo, 32727);
//
//        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(app.emailsVerificationsEmail, app.emailsVerificationsPass);
//        String actualSender = senderAndSubject.get(0);
//        String actualSubject = senderAndSubject.get(1);
//
//        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
//        String actualBody = getEmailBodyText(emailText, 0, 155);
//        String actualFooter = getEmailFooterText(emailText, 156);
//
//        assertThat(actualSender, equalTo(expectedUpAndGoSender));
//        assertThat(actualSubject, equalTo("Twój wyciąg z konta "+app.site_upAndGo+""));
//        assertThat(actualBody, equalTo("Witaj "+app.emailsVerificationsFirstName+", W załączniku znajduje się zamówiony wyciąg z konta up and go. Dziękujemy za korzystanie z serwisu "+app.site_upAndGo+". Z wyrazami szacunku, Dział Prawny"));
//        //assertThat(actualFooter, equalTo(""+app.SITE_REG+" "+app.site_upAndGo+" dostarcza DiPocket UAB, autoryzowana Instytucja Pieniądza Elektronicznego, podlegająca nadzorowi Banku Litwy (numer licencji 75) | Licencjonowana przez Mastercard do działania na Europejskim Obszarze Gospodarczego Upės g. 23, 08128 Vilnius, LT"));
//    }
//
//    @Test
//    public void testStatementEmailUpAndGoRU() throws InterruptedException, MessagingException, IOException {
//        sendStatementEmail(4, app.mobile_site_upAndGo, 32727);
//
//        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(app.emailsVerificationsEmail, app.emailsVerificationsPass);
//        String actualSender = senderAndSubject.get(0);
//        String actualSubject = senderAndSubject.get(1);
//
//        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
//        String actualBody = getEmailBodyText(emailText, 29, 176);
//        String actualFooter = getEmailFooterText(emailText, 177);
//
//        assertThat(actualSender, equalTo(expectedUpAndGoSender));
//        assertThat(actualSubject, equalTo("Выписка по счету "+app.site_upAndGo+""));
//        assertThat(actualBody, equalTo("Здравствуйте, "+app.emailsVerificationsFirstName+"! К письму прикреплена выписка по счету, которую Вы заказывали. Спасибо за пользование "+app.site_upAndGo+". С уважением, Юридический отдел"));
//        //assertThat(actualFooter, equalTo(""+app.SITE_REG+" Для вашего спокойствия, "+app.site_upAndGo+" осуществляет деятельность при поддержке DiPocket UAB, который авторизован и контролируется Банком Литвы как эмитент электронных денег (#75) Upės str. 23, 08128 Vilnius, LT"));
//    }
//
//    @Test
//    public void testStatementEmailSnowAttackEN() throws InterruptedException, MessagingException, IOException {
//        sendStatementEmail(1, app.mobile_site_snowAttack, 32855);
//
//        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(app.emailsVerificationsEmail, app.emailsVerificationsPass);
//        String actualSender = senderAndSubject.get(0);
//        String actualSubject = senderAndSubject.get(1);
//
//        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
//        String actualBody = getEmailBodyText(emailText, 31, 179);
//        String actualFooter = getEmailFooterText(emailText, 180);
//
//        assertThat(actualSender, equalTo(expectedSender));
//        assertThat(actualSubject, equalTo("Your "+app.site_SnowAttack+" account statement"));
//        assertThat(actualBody, equalTo("Dear "+app.emailsVerificationsFirstName+", As requested, please find attached your "+app.site_SnowAttack+" account statement(s). Thank you for using "+app.site_SnowAttack+". With kind regards, Legal Team"));
//        assertThat(actualFooter, equalTo(""+app.SITE_REG+" "+app.site_SnowAttack+" is powered by DiPocket UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT"));
//    }
//
//    @Test
//    public void testStatementEmailSnowAttackHU() throws InterruptedException, MessagingException, IOException {
//        sendStatementEmail(5, app.mobile_site_snowAttack, 32855);
//
//        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(app.emailsVerificationsEmail, app.emailsVerificationsPass);
//        String actualSender = senderAndSubject.get(0);
//        String actualSubject = senderAndSubject.get(1);
//
//        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
//        String actualBody = getEmailBodyText(emailText, 31, 196);
//        String actualFooter = getEmailFooterText(emailText, 197);
//
//        assertThat(actualSender, equalTo(expectedSender));
//        assertThat(actualSubject, equalTo("AZ Ön "+app.site_SnowAttack+" számlakivonata"));
//        assertThat(actualBody, equalTo("Kedves "+app.emailsVerificationsFirstName+", Kívánsága szerint, csatolva találja a számlakivonatát (számlakivonatait). Köszönjük, hogy a "+app.site_SnowAttack+" alkalmazást használja. Üdvözlettel, Jogi csapat"));
//        assertThat(actualFooter, equalTo(""+app.SITE_REG+" "+app.site_SnowAttack+", a DiPocket UAB támogatásával, mely vállalatot a Litván Nemzeti Bank elektronikus pénzintézetenként (# 75) engedélyezett és felügyel | a Mastercard licencével rendelkezik az Európai Gazdasági Térségre vonatkozva Upės str. 23, 08128 Vilnius, LT"));
//    }
}