package emailsVerification.statement;

import appmanager.EmailVerificationHelper;
import base.TestBase;
import org.testng.annotations.Test;

import javax.mail.MessagingException;
import java.io.IOException;

import static appmanager.EmailIMAPHelper.getEmailBodyText;
import static appmanager.EmailIMAPHelper.getEmailFooterText;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class StatementEmailTests extends TestBase {
    String expectedSender = "statements@dipocket.org";
    String expectedUpAndGoSender = "zestawienia@upcard.pl";

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

    public void postStatementEmail(int landId, String site, int id) {
        given()
                .spec(app.requestSpecEmailVerification)
                .body(body(landId, site, id))
                .when()
                .post( "/EmailService/sendStatementEmail")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test(priority = 1)
    public void testStatementEmailDipocketEN() throws InterruptedException, MessagingException, IOException {
        postStatementEmail(1, app.mobile_site, 32761);

        String emailSender =  EmailVerificationHelper.getEmailSender(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailBody = getEmailBodyText(emailText, 28, 170);
        String emailFooter = getEmailFooterText(emailText, 171);

        assertThat(emailSender, equalTo(expectedSender));
        assertThat(emailBody, equalTo("Dear "+app.emailsVerificationsFirstName+", As requested, please find attached your "+app.site+" account statement(s). Thank you for using "+app.site+". With kind regards, Legal Team"));
        assertThat(emailFooter, equalTo(""+app.SITE_REG+" "+app.site+" UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT"));
    }

    @Test(priority = 2)
    public void testStatementEmailDipocketUA() throws InterruptedException, MessagingException, IOException {
        postStatementEmail(2, app.mobile_site, 32761);

        String emailSender =  EmailVerificationHelper.getEmailSender(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailBody = getEmailBodyText(emailText, 28, 191);
        String emailFooter = getEmailFooterText(emailText, 192);

        assertThat(emailSender, equalTo(expectedSender));
        assertThat(emailBody, equalTo("Вітаємо, "+app.emailsVerificationsFirstName+"! В додатку знаходиться замовлена Вами банківська виписка по рахунку "+app.site+". Дякуємо за користування додатком "+app.site+". З повагою, Юридичний відділ"));
        assertThat(emailFooter, equalTo(""+app.SITE_REG+" Для Вашого спокою, "+app.site+" UAB авторизований та контролюється Банком Литви, як емітент електронних грошей (#75) Upės str. 23, 08128 Vilnius, LT"));
    }

    @Test(priority = 3)
    public void testStatementEmailDipocketPL() throws InterruptedException, MessagingException, IOException {
        postStatementEmail(3, app.mobile_site, 32761);

        String emailSender =  EmailVerificationHelper.getEmailSender(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailBody = getEmailBodyText(emailText, 0, 153);
        String emailFooter = getEmailFooterText(emailText, 154);

        assertThat(emailSender, equalTo(expectedSender));
        assertThat(emailBody, equalTo("Witaj "+app.emailsVerificationsFirstName+", W załączniku znajduje się zamówiony wyciąg z konta "+app.site+". Dziękujemy za korzystanie z serwisu "+app.site+". Z wyrazami szacunku, Dział Prawny"));
        assertThat(emailFooter, equalTo(""+app.SITE_REG+" "+app.site+" UAB, autoryzowana Instytucja Pieniądza Elektronicznego, podlegająca nadzorowi Banku Litwy (numer licencji 75) | Licencjonowana przez Mastercard do działania na Europejskim Obszarze Gospodarczego Upės g. 23, 08128 Vilnius, LT"));
    }

    @Test(priority = 4)
    public void testStatementEmailDipocketRU() throws InterruptedException, MessagingException, IOException {
        postStatementEmail(4, app.mobile_site, 32761);

        String emailSender =  EmailVerificationHelper.getEmailSender(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailBody = getEmailBodyText(emailText, 0, 146);
        String emailFooter = getEmailFooterText(emailText, 147);

        assertThat(emailSender, equalTo(expectedSender));
        assertThat(emailBody, equalTo("Здравствуйте, "+app.emailsVerificationsFirstName+"! К письму прикреплена выписка по счету, которую Вы заказывали. Спасибо за пользование "+app.site+". С уважением, Юридический отдел"));
        assertThat(emailFooter, equalTo(""+app.SITE_REG+" Для вашего спокойствия, "+app.site+" UAB авторизован и контролируется Банком Литвы как эмитент электронных денег (#75) Upės str. 23, 08128 Vilnius, LT"));
    }

    @Test(priority = 5)
    public void testStatementEmailDiscontuEN() throws InterruptedException, MessagingException, IOException {
        postStatementEmail(1, app.mobile_site_discontu, 32717);

        String emailSender =  EmailVerificationHelper.getEmailSender(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailBody = getEmailBodyText(emailText, 28, 170);
        String emailFooter = getEmailFooterText(emailText, 171);

        assertThat(emailSender, equalTo(expectedSender));
        assertThat(emailBody, equalTo("Dear "+app.emailsVerificationsFirstName+", As requested, please find attached your "+app.site_discontu+" account statement(s). Thank you for using "+app.site_discontu+". With kind regards, Legal Team"));
        assertThat(emailFooter, equalTo(""+app.SITE_REG+" "+app.site_discontu+" is powered by DiPocket UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT"));
    }

    @Test(priority = 6)
    public void testStatementEmailDiscontuPL() throws InterruptedException, MessagingException, IOException {
        postStatementEmail(3, app.mobile_site_discontu, 32717);

        String emailSender =  EmailVerificationHelper.getEmailSender(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailBody = getEmailBodyText(emailText, 0, 153);
        String emailFooter = getEmailFooterText(emailText, 154);

        assertThat(emailSender, equalTo(expectedSender));
        assertThat(emailBody, equalTo("Witaj "+app.emailsVerificationsFirstName+", W załączniku znajduje się zamówiony wyciąg z konta "+app.site_discontu+". Dziękujemy za korzystanie z serwisu "+app.site_discontu+". Z wyrazami szacunku, Dział Prawny"));
        assertThat(emailFooter, equalTo(""+app.SITE_REG+" "+app.site_discontu+" dostarcza DiPocket UAB, autoryzowana Instytucja Pieniądza Elektronicznego, podlegająca nadzorowi Banku Litwy (numer licencji 75) | Licencjonowana przez Mastercard do działania na Europejskim Obszarze Gospodarczego Upės g. 23, 08128 Vilnius, LT"));
    }

    @Test(priority = 7)
    public void testStatementEmailPlayITEN() throws InterruptedException, MessagingException, IOException {
        postStatementEmail(1, app.mobile_site_playIt, 32732);

        String emailSender =  EmailVerificationHelper.getEmailSender(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailBody = getEmailBodyText(emailText, 26, 164);
        String emailFooter = getEmailFooterText(emailText, 165);

        assertThat(emailSender, equalTo("PlayIT Card <statements@dipocket.org>"));
        assertThat(emailBody, equalTo("Dear "+app.emailsVerificationsFirstName+", As requested, please find attached your "+app.site_PlayIT+" account statement(s). Thank you for using "+app.site_PlayIT+". With kind regards, Legal Team"));
        assertThat(emailFooter, equalTo(""+app.SITE_REG+" "+app.site_PlayIT+" is powered by DiPocket UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT"));
    }

    @Test(priority = 8, enabled = false)
    public void testStatementEmailUpAndGoEN() throws InterruptedException, MessagingException, IOException {
        postStatementEmail(1, app.mobile_site_upAndGo, 32727);

        String emailSender =  EmailVerificationHelper.getEmailSender(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailBody = getEmailBodyText(emailText, 28, 170);
        String emailFooter = getEmailFooterText(emailText, 171);

        assertThat(emailSender, equalTo(expectedUpAndGoSender));
        assertThat(emailBody, equalTo("Dear "+app.emailsVerificationsFirstName+", As requested, please find attached your up and go account statement(s). Thank you for using "+app.site_upAndGo+". With kind regards, Legal Team"));
        assertThat(emailFooter, equalTo(""+app.SITE_REG+" "+app.site_upAndGo+" is powered by DiPocket UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT"));
    }

    @Test(priority = 9, enabled = false)
    public void testStatementEmailUpAndGoUA() throws InterruptedException, MessagingException, IOException {
        postStatementEmail(2, app.mobile_site_upAndGo, 32727);

        String emailSender =  EmailVerificationHelper.getEmailSender(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailBody = getEmailBodyText(emailText, 28, 191);
        String emailFooter = getEmailFooterText(emailText, 192);

        assertThat(emailSender, equalTo(expectedUpAndGoSender));
        assertThat(emailBody, equalTo("Вітаємо, "+app.emailsVerificationsFirstName+"! В додатку знаходиться замовлена Вами банківська виписка по рахунку "+app.site_upAndGo+". Дякуємо за користування додатком "+app.site_upAndGo+". З повагою, Юридичний відділ"));
        assertThat(emailFooter, equalTo(""+app.SITE_REG+" Для Вашого спокою, "+app.site_upAndGo+" працює при підтримці DiPocket UAB, що авторизований та контролюється Банком Литви, як емітент електронних грошей (#75) Upės str. 23, 08128 Vilnius, LT"));
    }

    @Test(priority = 10, enabled = false)
    public void testStatementEmailUpAndGoPL() throws InterruptedException, MessagingException, IOException {
        postStatementEmail(3, app.mobile_site_upAndGo, 32727);

        String emailSender =  EmailVerificationHelper.getEmailSender(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailBody = getEmailBodyText(emailText, 0, 155);
        String emailFooter = getEmailFooterText(emailText, 156);

        assertThat(emailSender, equalTo(expectedUpAndGoSender));
        assertThat(emailBody, equalTo("Witaj "+app.emailsVerificationsFirstName+", W załączniku znajduje się zamówiony wyciąg z konta up and go. Dziękujemy za korzystanie z serwisu "+app.site_upAndGo+". Z wyrazami szacunku, Dział Prawny"));
        assertThat(emailFooter, equalTo(""+app.SITE_REG+" "+app.site_upAndGo+" dostarcza DiPocket UAB, autoryzowana Instytucja Pieniądza Elektronicznego, podlegająca nadzorowi Banku Litwy (numer licencji 75) | Licencjonowana przez Mastercard do działania na Europejskim Obszarze Gospodarczego Upės g. 23, 08128 Vilnius, LT"));
    }

    @Test(priority = 11, enabled = false)
    public void testStatementEmailUpAndGoRU() throws InterruptedException, MessagingException, IOException {
        postStatementEmail(4, app.mobile_site_upAndGo, 32727);

        String emailSender =  EmailVerificationHelper.getEmailSender(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailBody = getEmailBodyText(emailText, 0, 146);
        String emailFooter = getEmailFooterText(emailText, 147);

        assertThat(emailSender, equalTo(expectedUpAndGoSender));
        assertThat(emailBody, equalTo("Здравствуйте, "+app.emailsVerificationsFirstName+"! К письму прикреплена выписка по счету, которую Вы заказывали. Спасибо за пользование "+app.site_upAndGo+". С уважением, Юридический отдел"));
        assertThat(emailFooter, equalTo(""+app.SITE_REG+" Для вашего спокойствия, "+app.site_upAndGo+" осуществляет деятельность при поддержке DiPocket UAB, который авторизован и контролируется Банком Литвы как эмитент электронных денег (#75) Upės str. 23, 08128 Vilnius, LT"));
    }

    @Test(priority = 12)
    public void testStatementEmailSnowAttackEN() throws InterruptedException, MessagingException, IOException {
        postStatementEmail(1, app.mobile_site_snowAttack, 32855);

        String emailSender =  EmailVerificationHelper.getEmailSender(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailBody = getEmailBodyText(emailText, 31, 179);
        String emailFooter = getEmailFooterText(emailText, 180);

        assertThat(emailSender, equalTo(expectedSender));
        assertThat(emailBody, equalTo("Dear "+app.emailsVerificationsFirstName+", As requested, please find attached your "+app.site_SnowAttack+" account statement(s). Thank you for using "+app.site_SnowAttack+". With kind regards, Legal Team"));
        assertThat(emailFooter, equalTo(""+app.SITE_REG+" "+app.site_SnowAttack+" is powered by DiPocket UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT"));
    }
}