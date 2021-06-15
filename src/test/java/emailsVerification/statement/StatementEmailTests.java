package emailsVerification.statement;

import appmanager.EmailIMAPHelper3;
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
    String site = "DiPocket";
    String firstName = "Pavel";
    String emailFrom = "statements@dipocket.org";
    String testEmail = "testdipocket@gmail.com";
    String pass = "password1<";
    String SITE_REG = "DiPocket®";

    public String body(int landId, final String site){
        return "{\n" +
                "\"id\": 32717,\n" +
                "\"clientFirstName\": \"" + firstName + "\",\n" +
                "\"clientLastName\": \"Burinsky\",\n" +
                "\"countryId\": 826,\n" +
                "\"langId\": " + landId + ",\n" +
                "\"mainPhone\": \"380685448615\",\n" +
                "\"email\": \"" + testEmail + "\",\n" +
                "\"currencyId\": 978,\n" +
                "\"site\": \"" + site + "\",\n" +
                "\"siteEnum\": \"" + site + "\",\n" +
                "\"programNickName\": \"" + site + "\"\n" +
                "}";
    }

    public void postStatementEmail(int landId, String site) {
        given()
                .header("Content-Type", "application/json")
                .body(body(landId, site))
                .when()
                .post( app.dipocket3_intranet+"/EmailService/sendStatementEmail")
                .then().log().all()
                .statusCode(200);
    }

    @Test(priority = 1)
    public void testStatementEmailDipocketEN() throws InterruptedException, MessagingException, IOException {
        postStatementEmail(1, "DIPOCKET");

        String emailSender =  EmailIMAPHelper3.getEmailSender(testEmail, pass);
        String emailText =  EmailIMAPHelper3.getTextFromEmail("pop.gmail.com", testEmail, pass);
        String emailBody = getEmailBodyText(emailText, 28, 170);
        String emailFooter = getEmailFooterText(emailText, 171);

        assertThat(emailSender, equalTo(emailFrom));
        assertThat(emailBody, equalTo("Dear "+firstName+", As requested, please find attached your "+site+" account statement(s). Thank you for using "+site+". With kind regards, Legal Team"));
        assertThat(emailFooter, equalTo(""+SITE_REG+" "+site+" UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT"));
    }

    @Test(priority = 2)
    public void testStatementEmailDipocketUA() throws InterruptedException, MessagingException, IOException {
        postStatementEmail(2, "DIPOCKET");

        String emailSender =  EmailIMAPHelper3.getEmailSender(testEmail, pass);
        String emailText =  EmailIMAPHelper3.getTextFromEmail("pop.gmail.com", testEmail, pass);
        String emailBody = getEmailBodyText(emailText, 28, 191);
        String emailFooter = getEmailFooterText(emailText, 192);

        assertThat(emailSender, equalTo(emailFrom));
        assertThat(emailBody, equalTo("Вітаємо, "+firstName+"! В додатку знаходиться замовлена Вами банківська виписка по рахунку "+site+". Дякуємо за користування додатком "+site+". З повагою, Юридичний відділ"));
        assertThat(emailFooter, equalTo(""+SITE_REG+" Для Вашого спокою, "+site+" UAB авторизований та контролюється Банком Литви, як емітент електронних грошей (#75) Upės str. 23, 08128 Vilnius, LT"));
    }

    @Test(priority = 3)
    public void testStatementEmailDipocketPL() throws InterruptedException, MessagingException, IOException {
        postStatementEmail(3, "DIPOCKET");

        String emailSender =  EmailIMAPHelper3.getEmailSender(testEmail, pass);
        String emailText =  EmailIMAPHelper3.getTextFromEmail("pop.gmail.com", testEmail, pass);
        String emailBody = getEmailBodyText(emailText, 0, 153);
        String emailFooter = getEmailFooterText(emailText, 154);

        assertThat(emailSender, equalTo(emailFrom));
        assertThat(emailBody, equalTo("Witaj "+firstName+", W załączniku znajduje się zamówiony wyciąg z konta DiPocket. Dziękujemy za korzystanie z serwisu DiPocket. Z wyrazami szacunku, Dział Prawny"));
        assertThat(emailFooter, equalTo(""+SITE_REG+" "+site+" UAB, autoryzowana Instytucja Pieniądza Elektronicznego, podlegająca nadzorowi Banku Litwy (numer licencji 75) | Licencjonowana przez Mastercard do działania na Europejskim Obszarze Gospodarczego Upės g. 23, 08128 Vilnius, LT"));
    }

    @Test(priority = 4)
    public void testStatementEmailDipocketRU() throws InterruptedException, MessagingException, IOException {
        postStatementEmail(4, "DIPOCKET");

        String emailSender =  EmailIMAPHelper3.getEmailSender(testEmail, pass);
        String emailText =  EmailIMAPHelper3.getTextFromEmail("pop.gmail.com", testEmail, pass);
        String emailBody = getEmailBodyText(emailText, 0, 146);
        String emailFooter = getEmailFooterText(emailText, 147);

        assertThat(emailSender, equalTo(emailFrom));
        assertThat(emailBody, equalTo("Здравствуйте, "+firstName+"! К письму прикреплена выписка по счету, которую Вы заказывали. Спасибо за пользование "+site+". С уважением, Юридический отдел"));
        assertThat(emailFooter, equalTo(""+SITE_REG+" Для вашего спокойствия, "+site+" UAB авторизован и контролируется Банком Литвы как эмитент электронных денег (#75) Upės str. 23, 08128 Vilnius, LT"));
    }

    @Test(priority = 5)
    public void testStatementEmailDiscontuEN() throws InterruptedException, MessagingException, IOException {
        postStatementEmail(1, "DISCONTU");

        String emailSender =  EmailIMAPHelper3.getEmailSender(testEmail, pass);
        String emailText =  EmailIMAPHelper3.getTextFromEmail("pop.gmail.com", testEmail, pass);
        String emailBody = getEmailBodyText(emailText, 28, 170);
        String emailFooter = getEmailFooterText(emailText, 171);

        assertThat(emailSender, equalTo(emailFrom));
        assertThat(emailBody, equalTo("Dear "+firstName+", As requested, please find attached your discontu account statement(s). Thank you for using discontu. With kind regards, Legal Team"));
        assertThat(emailFooter, equalTo(""+SITE_REG+" discontu is powered by DiPocket UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT"));
    }

    @Test(priority = 6)
    public void testStatementEmailDiscontuPL() throws InterruptedException, MessagingException, IOException {
        postStatementEmail(3, "DISCONTU");

        String emailSender =  EmailIMAPHelper3.getEmailSender(testEmail, pass);
        String emailText =  EmailIMAPHelper3.getTextFromEmail("pop.gmail.com", testEmail, pass);
        String emailBody = getEmailBodyText(emailText, 0, 153);
        String emailFooter = getEmailFooterText(emailText, 154);

        assertThat(emailSender, equalTo(emailFrom));
        assertThat(emailBody, equalTo("Witaj "+firstName+", W załączniku znajduje się zamówiony wyciąg z konta discontu. Dziękujemy za korzystanie z serwisu discontu. Z wyrazami szacunku, Dział Prawny"));
        assertThat(emailFooter, equalTo(""+SITE_REG+" discontu dostarcza DiPocket UAB, autoryzowana Instytucja Pieniądza Elektronicznego, podlegająca nadzorowi Banku Litwy (numer licencji 75) | Licencjonowana przez Mastercard do działania na Europejskim Obszarze Gospodarczego Upės g. 23, 08128 Vilnius, LT"));
    }

    @Test(priority = 7)
    public void testStatementEmailPlayITEN() throws InterruptedException, MessagingException, IOException {
        postStatementEmail(1, "PLAYIT");

        String emailSender =  EmailIMAPHelper3.getEmailSender(testEmail, pass);
        String emailText =  EmailIMAPHelper3.getTextFromEmail("pop.gmail.com", testEmail, pass);
        String emailBody = getEmailBodyText(emailText, 26, 164);
        String emailFooter = getEmailFooterText(emailText, 165);

        assertThat(emailSender, equalTo("PlayIT Card <statements@dipocket.org>"));
        assertThat(emailBody, equalTo("Dear "+firstName+", As requested, please find attached your PlayIT account statement(s). Thank you for using PlayIT. With kind regards, Legal Team"));
        assertThat(emailFooter, equalTo(""+SITE_REG+" PlayIT is powered by DiPocket UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT"));
    }
}