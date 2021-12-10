package tests.emailsVerification.resetPassword;

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

public class ResetPasswordTests extends TestBase {
    String expectedSender = "customer.service@dipocket.org";
    String expectedUpAndGoSender = "wsparcie@upcard.pl";
    String expectedPlayITSender = "PlayIT Card <customer.service@dipocket.org>";

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

    @DataProvider
    public Iterator<Object[]> ResetPassword() {
        List<Object[]> list = new ArrayList<Object[]>();
        list.add(new Object[] {Site.DIPOCKET.toString(), Language.EN.toString(), Language.EN.getOurId(),  app.emailsVerificationsEmail, app.emailsVerificationsPass, 28, 217, 218, expectedSender, "Your password reset request", "We received a request to reset the password associated with your account. Please click on this link to confirm your request and finalise the change. With kind regards, Customer Service Team", ""+app.SITE_REG+" "+app.site+" UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT"});
        list.add(new Object[] {Site.DIPOCKET.toString(), Language.PL.toString(), Language.PL.getOurId(), app.emailsVerificationsEmail,  app.emailsVerificationsPass, 0, 156, 157, expectedSender, "Żądanie zmiany hasła", "Otrzymaliśmy żądanie zmiany hasła do Twojego konta. Kliknij ten link , aby potwierdzić żądanie i ukończyć zmianę. Z wyrazami szacunku, Dział Obsługi Klienta", ""+app.SITE_REG+" "+app.site+" UAB, autoryzowana Instytucja Pieniądza Elektronicznego, podlegająca nadzorowi Banku Litwy (numer licencji 75) | Licencjonowana przez Mastercard do działania na Europejskim Obszarze Gospodarczego Upės g. 23, 08128 Vilnius, LT"});
        list.add(new Object[] {Site.DISCONTU.toString(), Language.EN.toString(), Language.EN.getOurId(), app.emailsVerificationsEmail, app.emailsVerificationsPass, 28, 217, 218, expectedSender, "Your password reset request", "We received a request to reset the password associated with your account. Please click on this link to confirm your request and finalise the change. With kind regards, Customer Service Team", ""+app.SITE_REG+" "+app.site_discontu+" is powered by DiPocket UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT"});
        list.add(new Object[] {Site.DISCONTU.toString(), Language.PL.toString(), Language.PL.getOurId(), app.emailsVerificationsEmail, app.emailsVerificationsPass, 0, 156, 157, expectedSender, "Żądanie zmiany hasła", "Otrzymaliśmy żądanie zmiany hasła do Twojego konta. Kliknij ten link , aby potwierdzić żądanie i ukończyć zmianę. Z wyrazami szacunku, Dział Obsługi Klienta", ""+app.SITE_REG+" "+app.site_discontu+" dostarcza DiPocket UAB, autoryzowana Instytucja Pieniądza Elektronicznego, podlegająca nadzorowi Banku Litwy (numer licencji 75) | Licencjonowana przez Mastercard do działania na Europejskim Obszarze Gospodarczego Upės g. 23, 08128 Vilnius, LT"});
        list.add(new Object[] {Site.PLAYIT.toString(), Language.EN.toString(), Language.EN.getOurId(), app.emailsVerificationsEmail, app.emailsVerificationsPass, 0, 191, 192, expectedPlayITSender, "Your password reset request", "We received a request to reset the password associated with your account. Please click on this  link  to confirm your request and finalise the change. With kind regards, Customer Service Team", ""+app.SITE_REG+" "+app.site_PlayIT+" is powered by DiPocket UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT"});
        list.add(new Object[] {Site.PLAYIT.toString(), Language.HU.toString(), Language.HU.getOurId(), app.emailsVerificationsEmail, app.emailsVerificationsPass, 0, 185, 186, expectedPlayITSender, "Jelszó visszaállítási kérése", "Kaptunk egy kérést a számlája jelszavának visszaállítására. Kérjük klikkeljen erre a linkre , hogy megerősítse a kérést és befejezze a változtatást. Üdvözlettel, Ügyfélszolgálati Csapat", ""+app.SITE_REG+" Megnyugtatásul tájékoztatjuk, hogy a PlayIT Kártya számládat a DiPocket UAB kezeli, mely vállalatot a Litván Nemzeti Bank elektronikus pénzintézetenként (# 75) engedélyezett és felügyel Upės str. 23, 08128 Vilnius, LT"});
        list.add(new Object[] {Site.SNOW_ATTACK.toString(), Language.EN.toString(), Language.EN.getOurId(), app.emailsVerificationsEmail, app.emailsVerificationsPass, 0, 191, 192, expectedSender, "Your password reset request", "We received a request to reset the password associated with your account. Please click on this  link  to confirm your request and finalise the change. With kind regards, Customer Service Team", ""+app.SITE_REG+" "+app.site_SnowAttack+" is powered by DiPocket UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT"});
        list.add(new Object[] {Site.SNOW_ATTACK.toString(), Language.HU.toString(), Language.HU.getOurId(), app.emailsVerificationsEmail, app.emailsVerificationsPass, 0, 186, 187, expectedSender, "Jelszó visszaállítási kérése", "Kaptunk egy kérést a számlája jelszavának visszaállítására. Kérjük klikkeljen erre  a linkre,  hogy megerősítse a kérést és befejezze a változtatást. Üdvözlettel, Ügyfélszolgálati Csapat", ""+app.SITE_REG+" "+app.site_SnowAttack+", a DiPocket UAB támogatásával, mely vállalatot a Litván Nemzeti Bank elektronikus pénzintézetenként (# 75) engedélyezett és felügyel | a Mastercard licencével rendelkezik az Európai Gazdasági Térségre vonatkozva Upės str. 23, 08128 Vilnius, LT"});
        list.add(new Object[] {Site.UPANDGO.toString(), Language.EN.toString(), Language.EN.getOurId(), app.emailsVerificationsEmail, app.emailsVerificationsPass, 29, 218, 219, expectedUpAndGoSender, "Your password reset request", "We received a request to reset the password associated with your account. Please click on this link to confirm your request and finalise the change. With kind regards, Customer Service Team", ""+app.SITE_REG+" "+app.site_upAndGo+" is powered by DiPocket UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT"});
        list.add(new Object[] {Site.UPANDGO.toString(), Language.UK.toString(), Language.UK.getOurId(), app.emailsVerificationsEmail, app.emailsVerificationsPass, 2, 158, 159, expectedUpAndGoSender, "Запит на зміну паролю", "Ми отримали запит на зміну паролю за Вашим особистим рахунком. Будь-ласка клікніть це посилання, щоб підтвердити зміну. З повагою, Відділ підтримки клієнтів", ""+app.SITE_REG+" Для Вашого спокою, "+app.site_upAndGo+" працює при підтримці DiPocket UAB, що авторизований та контролюється Банком Литви, як емітент електронних грошей (#75) Upės str. 23, 08128 Vilnius, LT"});
        list.add(new Object[] {Site.UPANDGO.toString(), Language.PL.toString(), Language.PL.getOurId(), app.emailsVerificationsEmail, app.emailsVerificationsPass, 0, 156, 157, expectedUpAndGoSender, "Żądanie zmiany hasła", "Otrzymaliśmy żądanie zmiany hasła do Twojego konta. Kliknij ten link , aby potwierdzić żądanie i ukończyć zmianę. Z wyrazami szacunku, Dział Obsługi Klienta", ""+app.SITE_REG+" "+app.site_upAndGo+" dostarcza DiPocket UAB, autoryzowana Instytucja Pieniądza Elektronicznego, podlegająca nadzorowi Banku Litwy (numer licencji 75) | Licencjonowana przez Mastercard do działania na Europejskim Obszarze Gospodarczego Upės g. 23, 08128 Vilnius, LT"});
        list.add(new Object[] {Site.UPANDGO.toString(), Language.RU.toString(), Language.RU.getOurId(), app.emailsVerificationsEmail, app.emailsVerificationsPass, 2, 149, 150, expectedUpAndGoSender, "Запрос на сброс пароля", "Мы получили запрос на сброс пароля Вашего профиля. Пожалуйста, кликните ссылку, чтобы подтвердить изменения. С уважением, Служба поддержки клиентов", ""+app.SITE_REG+" Для вашего спокойствия, "+app.site_upAndGo+" осуществляет деятельность при поддержке DiPocket UAB, который авторизован и контролируется Банком Литвы как эмитент электронных денег (#75) Upės str. 23, 08128 Vilnius, LT"});
        //list.add(new Object[] {Site.SODEXO.toString(), "ENPL", "1", app.emailsVerificationsEmail, app.emailsVerificationsPass, 63, 701, 702, expectedSender, "Your password reset request", "Otrzymaliśmy prośbę o zresetowanie hasła powiązanego z Twoim Profilem Wirtualnej Karty Sodexo. Kliknij w ten link lub kliknij w przycisk poniżej, by potwierdzić prośbę i zakończyć proces. Pozdrawiamy, Zespół Wirtualnej Karty Sodexo Centrum Obsługi Klienta +48 (22) 535 11 11 | info.svc.pl@sodexo.com We received a request to reset the password associated with your Virtual Sodexo Card Profile. Please click on this link or click button below, to confirm your request and finalize the change. With kind regards, Virtual Sodexo Card Team Customer Service Center +48 (22) 535 11 11 | info.svc.pl@sodexo.com powered by DiPocket (dipocket.org)", "Customer Service Center +48 (22) 535 11 11 | info.svc.pl@sodexo.com powered by DiPocket (dipocket.org)"});
        return list.iterator();
    }

    @Test(dataProvider = "ResetPassword")
    public void testResetPassword(String site, String lang, int langId, String email, String pass, int bodyBegin, int bodyEnd, int footerEnd, String expectedEmailSender, String expectedEmailSubject, String expectedEmailBody, String expectedEmailFooter) throws InterruptedException, MessagingException, IOException, SQLException, ClassNotFoundException {
        app.getDbHelper().updateClientLanguageFromDB(email, String.valueOf(langId), site);
        postSendResetPasswordEmail(site);

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