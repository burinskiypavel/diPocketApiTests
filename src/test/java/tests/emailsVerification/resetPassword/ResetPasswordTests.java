package tests.emailsVerification.resetPassword;

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

public class ResetPasswordTests extends TestBase {
    String expectedSender = "customer.service@dipocket.org";
    String expectedUpAndGoSender = "wsparcie@upcard.pl";

    public String body(String testEmail){
        return "{\n" +
                "  \"email\": \""+testEmail+"\",\n" +
                "  \"phoneNumber\": \""+app.emailsVerificationsPhoneNumber+"\",\n" +
                "  \"url\": \"google.com\"\n" +
                "}";
    }

    public void postSendResetPasswordEmail(String site) {
        given()
                .spec(app.requestSpecEmailVerification)
                .body(body(app.emailsVerificationsEmail))
                .when()
                .post( "/EmailService/sendEmailForResetClientPassword?site="+site+"")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test(priority = 1)
    public void testResetPasswordDipocketEN() throws InterruptedException, MessagingException, IOException, SQLException, ClassNotFoundException {
        app.getDbHelper().updateClientLanguageFromDB(app.emailsVerificationsEmail, "1", app.mobile_site);
        postSendResetPasswordEmail(app.mobile_site);

        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualSender = senderAndSubject.get(0);
        String actualSubject = senderAndSubject.get(1);

        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualBody = getEmailBodyText(emailText, 28, 217);
        String actualFooter = getEmailFooterText(emailText, 218);

        assertThat(actualSender, equalTo(expectedSender));
        assertThat(actualSubject, equalTo("Your password reset request"));
        assertThat(actualBody, equalTo("We received a request to reset the password associated with your account. Please click on this link to confirm your request and finalise the change. With kind regards, Customer Service Team"));
        assertThat(actualFooter, equalTo(""+app.SITE_REG+" "+app.site+" UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT"));
    }

    @Test(priority = 2)
    public void testResetPasswordDipocketPL() throws InterruptedException, MessagingException, IOException, SQLException, ClassNotFoundException {
        app.getDbHelper().updateClientLanguageFromDB(app.emailsVerificationsEmail, "3", app.mobile_site);
        postSendResetPasswordEmail(app.mobile_site);

        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualSender = senderAndSubject.get(0);
        String actualSubject = senderAndSubject.get(1);

        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualBody = getEmailBodyText(emailText, 0, 156);
        String actualFooter = getEmailFooterText(emailText, 157);

        assertThat(actualSender, equalTo(expectedSender));
        assertThat(actualSubject, equalTo("Żądanie zmiany hasła"));
        assertThat(actualBody, equalTo("Otrzymaliśmy żądanie zmiany hasła do Twojego konta. Kliknij ten link , aby potwierdzić żądanie i ukończyć zmianę. Z wyrazami szacunku, Dział Obsługi Klienta"));
        assertThat(actualFooter, equalTo(""+app.SITE_REG+" "+app.site+" UAB, autoryzowana Instytucja Pieniądza Elektronicznego, podlegająca nadzorowi Banku Litwy (numer licencji 75) | Licencjonowana przez Mastercard do działania na Europejskim Obszarze Gospodarczego Upės g. 23, 08128 Vilnius, LT"));
    }

    @Test(priority = 20, enabled = false)
    public void testResetPasswordDipocketBG() throws InterruptedException, MessagingException, IOException, SQLException, ClassNotFoundException {
        app.getDbHelper().updateClientLanguageFromDB(app.emailsVerificationsEmail, "6", app.mobile_site);
        postSendResetPasswordEmail(app.mobile_site);

        String emailSender =  EmailVerificationHelper.getEmailSender(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailBody = getEmailBodyText(emailText, 0, 156);
        String emailFooter = getEmailFooterText(emailText, 157);

        assertThat(emailSender, equalTo(expectedSender));
        assertThat(emailBody, equalTo("Otrzymaliśmy żądanie zmiany hasła do Twojego konta. Kliknij ten link , aby potwierdzić żądanie i ukończyć zmianę. Z wyrazami szacunku, Dział Obsługi Klienta"));
        assertThat(emailFooter, equalTo(""+app.SITE_REG+" "+app.site+" UAB, autoryzowana Instytucja Pieniądza Elektronicznego, podlegająca nadzorowi Banku Litwy (numer licencji 75) | Licencjonowana przez Mastercard do działania na Europejskim Obszarze Gospodarczego Upės g. 23, 08128 Vilnius, LT"));
    }

    @Test(priority = 3)
    public void tesResetPasswordDiscontuEN() throws InterruptedException, MessagingException, IOException, SQLException, ClassNotFoundException {
        app.getDbHelper().updateClientLanguageFromDB(app.emailsVerificationsEmail, "1", app.mobile_site_discontu);
        postSendResetPasswordEmail(app.mobile_site_discontu);

        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualSender = senderAndSubject.get(0);
        String actualSubject = senderAndSubject.get(1);

        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualBody = getEmailBodyText(emailText, 28, 217);
        String actualFooter = getEmailFooterText(emailText, 218);

        assertThat(actualSender, equalTo(expectedSender));
        assertThat(actualSubject, equalTo("Your password reset request"));
        assertThat(actualBody, equalTo("We received a request to reset the password associated with your account. Please click on this link to confirm your request and finalise the change. With kind regards, Customer Service Team"));
        assertThat(actualFooter, equalTo(""+app.SITE_REG+" "+app.site_discontu+" is powered by DiPocket UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT"));
    }

    @Test(priority = 4)
    public void testResetPasswordDiscontuPL() throws InterruptedException, MessagingException, IOException, SQLException, ClassNotFoundException {
        app.getDbHelper().updateClientLanguageFromDB(app.emailsVerificationsEmail, "3", app.mobile_site_discontu);
        postSendResetPasswordEmail(app.mobile_site_discontu);

        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualSender = senderAndSubject.get(0);
        String actualSubject = senderAndSubject.get(1);

        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualBody = getEmailBodyText(emailText, 0, 156);
        String actualFooter = getEmailFooterText(emailText, 157);

        assertThat(actualSender, equalTo(expectedSender));
        assertThat(actualSubject, equalTo("Żądanie zmiany hasła"));
        assertThat(actualBody, equalTo("Otrzymaliśmy żądanie zmiany hasła do Twojego konta. Kliknij ten link , aby potwierdzić żądanie i ukończyć zmianę. Z wyrazami szacunku, Dział Obsługi Klienta"));
        assertThat(actualFooter, equalTo(""+app.SITE_REG+" "+app.site_discontu+" dostarcza DiPocket UAB, autoryzowana Instytucja Pieniądza Elektronicznego, podlegająca nadzorowi Banku Litwy (numer licencji 75) | Licencjonowana przez Mastercard do działania na Europejskim Obszarze Gospodarczego Upės g. 23, 08128 Vilnius, LT"));
    }

    @Test(priority = 5)
    public void testResetPasswordPlayITEN() throws InterruptedException, MessagingException, IOException, SQLException, ClassNotFoundException {
        app.getDbHelper().updateClientLanguageFromDB(app.emailsVerificationsEmail, "1", app.mobile_site_playIt);
        postSendResetPasswordEmail(app.mobile_site_playIt);

        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualSender = senderAndSubject.get(0);
        String actualSubject = senderAndSubject.get(1);

        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualBody = getEmailBodyText(emailText, 0, 191);
        String actualFooter = getEmailFooterText(emailText, 192);

        assertThat(actualSender, equalTo("PlayIT Card <customer.service@dipocket.org>"));
        assertThat(actualSubject, equalTo("Your password reset request"));
        assertThat(actualBody, equalTo("We received a request to reset the password associated with your account. Please click on this  link  to confirm your request and finalise the change. With kind regards, Customer Service Team"));
        assertThat(actualFooter, equalTo(""+app.SITE_REG+" "+app.site_PlayIT+" is powered by DiPocket UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT"));
    }

    @Test(priority = 14)
    public void testResetPasswordPlayITHU() throws InterruptedException, MessagingException, IOException, SQLException, ClassNotFoundException {
        app.getDbHelper().updateClientLanguageFromDB(app.emailsVerificationsEmail, "5", app.mobile_site_playIt);
        postSendResetPasswordEmail(app.mobile_site_playIt);

        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualSender = senderAndSubject.get(0);
        String actualSubject = senderAndSubject.get(1);

        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualBody = getEmailBodyText(emailText, 0, 185);
        String actualFooter = getEmailFooterText(emailText, 186);

        assertThat(actualSender, equalTo("PlayIT Card <customer.service@dipocket.org>"));
        assertThat(actualSubject, equalTo("Jelszó visszaállítási kérése"));
        assertThat(actualBody, equalTo("Kaptunk egy kérést a számlája jelszavának visszaállítására. Kérjük klikkeljen erre a linkre , hogy megerősítse a kérést és befejezze a változtatást. Üdvözlettel, Ügyfélszolgálati Csapat"));
        assertThat(actualFooter, equalTo(""+app.SITE_REG+" Megnyugtatásul tájékoztatjuk, hogy a PlayIT Kártya számládat a DiPocket UAB kezeli, mely vállalatot a Litván Nemzeti Bank elektronikus pénzintézetenként (# 75) engedélyezett és felügyel Upės str. 23, 08128 Vilnius, LT"));
    }

    @Test(priority = 6)
    public void testResetPasswordUpAndGoEN() throws InterruptedException, MessagingException, IOException, SQLException, ClassNotFoundException {
        app.getDbHelper().updateClientLanguageFromDB(app.emailsVerificationsEmail, "1", app.mobile_site_upAndGo);
        postSendResetPasswordEmail(app.mobile_site_upAndGo);

        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualSender = senderAndSubject.get(0);
        String actualSubject = senderAndSubject.get(1);

        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualBody = getEmailBodyText(emailText, 29, 218);
        String actualFooter = getEmailFooterText(emailText, 219);

        //assertThat(actualSender, equalTo(expectedUpAndGoSender));
        assertThat(actualSubject, equalTo("Your password reset request"));
        assertThat(actualBody, equalTo("We received a request to reset the password associated with your account. Please click on this link to confirm your request and finalise the change. With kind regards, Customer Service Team"));
        assertThat(actualFooter, equalTo(""+app.SITE_REG+" "+app.site_upAndGo+" is powered by DiPocket UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT"));
    }

    @Test(priority = 7)
    public void testResetPasswordUpAndGoPL() throws InterruptedException, MessagingException, IOException, SQLException, ClassNotFoundException {
        app.getDbHelper().updateClientLanguageFromDB(app.emailsVerificationsEmail, "3", app.mobile_site_upAndGo);
        postSendResetPasswordEmail(app.mobile_site_upAndGo);

        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualSender = senderAndSubject.get(0);
        String actualSubject = senderAndSubject.get(1);

        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualBody = getEmailBodyText(emailText, 0, 156);
        String actualFooter = getEmailFooterText(emailText, 157);

        //assertThat(actualSender, equalTo(expectedUpAndGoSender));
        assertThat(actualSubject, equalTo("Żądanie zmiany hasła"));
        assertThat(actualBody, equalTo("Otrzymaliśmy żądanie zmiany hasła do Twojego konta. Kliknij ten link , aby potwierdzić żądanie i ukończyć zmianę. Z wyrazami szacunku, Dział Obsługi Klienta"));
        assertThat(actualFooter, equalTo(""+app.SITE_REG+" "+app.site_upAndGo+" dostarcza DiPocket UAB, autoryzowana Instytucja Pieniądza Elektronicznego, podlegająca nadzorowi Banku Litwy (numer licencji 75) | Licencjonowana przez Mastercard do działania na Europejskim Obszarze Gospodarczego Upės g. 23, 08128 Vilnius, LT"));
    }

    @Test(priority = 8)
    public void testResetPasswordUpAndGoUA() throws InterruptedException, MessagingException, IOException, SQLException, ClassNotFoundException {
        app.getDbHelper().updateClientLanguageFromDB(app.emailsVerificationsEmail, "2", app.mobile_site_upAndGo);
        postSendResetPasswordEmail(app.mobile_site_upAndGo);

        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualSender = senderAndSubject.get(0);
        String actualSubject = senderAndSubject.get(1);

        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualBody = getEmailBodyText(emailText, 2, 158);
        String actualFooter = getEmailFooterText(emailText, 159);

        //assertThat(actualSender, equalTo(expectedUpAndGoSender));
        assertThat(actualSubject, equalTo("Запит на зміну паролю"));
        assertThat(actualBody, equalTo("Ми отримали запит на зміну паролю за Вашим особистим рахунком. Будь-ласка клікніть це посилання, щоб підтвердити зміну. З повагою, Відділ підтримки клієнтів"));
        assertThat(actualFooter, equalTo(""+app.SITE_REG+" Для Вашого спокою, "+app.site_upAndGo+" працює при підтримці DiPocket UAB, що авторизований та контролюється Банком Литви, як емітент електронних грошей (#75) Upės str. 23, 08128 Vilnius, LT"));
    }

    @Test(priority = 9)
    public void testResetPasswordUpAndGoRU() throws InterruptedException, MessagingException, IOException, SQLException, ClassNotFoundException {
        app.getDbHelper().updateClientLanguageFromDB(app.emailsVerificationsEmail, "4", app.mobile_site_upAndGo);
        postSendResetPasswordEmail(app.mobile_site_upAndGo);

        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualSender = senderAndSubject.get(0);
        String actualSubject = senderAndSubject.get(1);

        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualBody = getEmailBodyText(emailText, 2, 149);
        String actualFooter = getEmailFooterText(emailText, 150);

        //assertThat(actualSender, equalTo(expectedUpAndGoSender));
        assertThat(actualSubject, equalTo("Запрос на сброс пароля"));
        assertThat(actualBody, equalTo("Мы получили запрос на сброс пароля Вашего профиля. Пожалуйста, кликните ссылку, чтобы подтвердить изменения. С уважением, Служба поддержки клиентов"));
        assertThat(actualFooter, equalTo(""+app.SITE_REG+" Для вашего спокойствия, "+app.site_upAndGo+" осуществляет деятельность при поддержке DiPocket UAB, который авторизован и контролируется Банком Литвы как эмитент электронных денег (#75) Upės str. 23, 08128 Vilnius, LT"));
    }

    @Test(priority = 10)
    public void testResetPasswordSnowAttackEN() throws InterruptedException, MessagingException, IOException, SQLException, ClassNotFoundException {
        app.getDbHelper().updateClientLanguageFromDB(app.emailsVerificationsEmail, "1", app.mobile_site_snowAttack);
        postSendResetPasswordEmail(app.mobile_site_snowAttack);

        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualSender = senderAndSubject.get(0);
        String actualSubject = senderAndSubject.get(1);

        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualBody = getEmailBodyText(emailText, 0, 191);
        String actualFooter = getEmailFooterText(emailText, 192);

        assertThat(actualSender, equalTo(expectedSender));
        assertThat(actualSubject, equalTo("Your password reset request"));
        assertThat(actualBody, equalTo("We received a request to reset the password associated with your account. Please click on this  link  to confirm your request and finalise the change. With kind regards, Customer Service Team"));
        assertThat(actualFooter, equalTo(""+app.SITE_REG+" "+app.site_SnowAttack+" is powered by DiPocket UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT"));
    }

    @Test(priority = 11)
    public void testResetPasswordSnowAttackHU() throws InterruptedException, MessagingException, IOException, SQLException, ClassNotFoundException {
        app.getDbHelper().updateClientLanguageFromDB(app.emailsVerificationsEmail, "5", app.mobile_site_snowAttack);
        postSendResetPasswordEmail(app.mobile_site_snowAttack);

        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualSender = senderAndSubject.get(0);
        String actualSubject = senderAndSubject.get(1);

        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualBody = getEmailBodyText(emailText, 0, 186);
        String actualFooter = getEmailFooterText(emailText, 187);

        assertThat(actualSender, equalTo(expectedSender));
        assertThat(actualSubject, equalTo("Jelszó visszaállítási kérése"));
        assertThat(actualBody, equalTo("Kaptunk egy kérést a számlája jelszavának visszaállítására. Kérjük klikkeljen erre  a linkre,  hogy megerősítse a kérést és befejezze a változtatást. Üdvözlettel, Ügyfélszolgálati Csapat"));
        assertThat(actualFooter, equalTo(""+app.SITE_REG+" "+app.site_SnowAttack+", a DiPocket UAB támogatásával, mely vállalatot a Litván Nemzeti Bank elektronikus pénzintézetenként (# 75) engedélyezett és felügyel | a Mastercard licencével rendelkezik az Európai Gazdasági Térségre vonatkozva Upės str. 23, 08128 Vilnius, LT"));
    }

    @Test(priority = 12)
    public void testResetPasswordSodexo() throws InterruptedException, MessagingException, IOException, SQLException, ClassNotFoundException {
        //app.getDbHelper().updateClientLanguageFromDB(app.emailsVerificationsEmail, "1", "SODEXO");
        postSendResetPasswordEmail("SODEXO");

        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualSender = senderAndSubject.get(0);
        String actualSubject = senderAndSubject.get(1);

        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualBody = getEmailBodyText(emailText, 63, 701);

        //assertThat(actualSender, equalTo(expectedSender));
        assertThat(actualSubject, equalTo("Your password reset request"));
        assertThat(actualBody, equalTo("Otrzymaliśmy prośbę o zresetowanie hasła powiązanego z Twoim Profilem Wirtualnej Karty Sodexo. Kliknij w ten link lub kliknij w przycisk poniżej, by potwierdzić prośbę i zakończyć proces. Pozdrawiamy, Zespół Wirtualnej Karty Sodexo Centrum Obsługi Klienta +48 (22) 535 11 11 | info.svc.pl@sodexo.com We received a request to reset the password associated with your Virtual Sodexo Card Profile. Please click on this link or click button below, to confirm your request and finalize the change. With kind regards, Virtual Sodexo Card Team Customer Service Center +48 (22) 535 11 11 | info.svc.pl@sodexo.com powered by DiPocket (dipocket.org)"));
    }
}