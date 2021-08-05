package tests.emailsVerification.changeEmail;

import appmanager.EmailVerificationHelper;
import base.TestBase;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

import static appmanager.EmailIMAPHelper.getEmailBodyText;
import static appmanager.EmailIMAPHelper.getEmailFooterText;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ChangeEmailTests extends TestBase {
    String expectedSender = "customer.service@dipocket.org";
    String expectedPlayITSender = "PlayIT Card <customer.service@dipocket.org>";
    String expectedSodexoSender = "kontakt.wirtualna@sodexo.com";
    String expectedTelenorSender = "telenorwallet@dipocket.org";
    String expectedUpAndGoSender = "wsparcie@upcard.pl";

    public String body(int landId, String site, int id){
        return "{\n" +
                "\"id\": "+id+",\n" +
                "\"clientFirstName\": \""+app.emailsVerificationsFirstName+"\",\n" +
                "\"clientLastName\": \""+app.emailsVerificationsLastName+"\",\n" +
                "\"countryId\": "+app.emailsVerificationsCountryId+",\n" +
                "\"langId\": "+landId+",\n" +
                "\"mainPhone\": \""+app.emailsVerificationsPhoneNumber+"\",\n" +
                "\"email\": \""+app.emailsVerificationsEmail+"\",\n" +
                "\"currencyId\": "+app.emailsVerificationsCurrencyId+",\n" +
                "\"site\": \""+site+"\",\n" +
                "\"siteEnum\": \""+site+"\",\n" +
                "\"programNickName\": \""+site+"\"\n" +
                "}";
    }

    public void postSendChangeEmail(int landId, String site, int id) {
        given()
                .spec(app.requestSpecEmailVerification)
                .body(body(landId, site, id))
                .when()
                .post( "/EmailService/sendChangeEmail")
                .then()
                .log().all()
                .statusCode(200);
    }
    @Test(priority = 1)
    public void testChangeEmailDipocketEN() throws InterruptedException, MessagingException, IOException {
        postSendChangeEmail(1, app.mobile_site, 32761);

        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualSender = senderAndSubject.get(0);
        String actualSubject = senderAndSubject.get(1);

        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualBody = getEmailBodyText(emailText, 46, 265);
        String actualFooter = getEmailFooterText(emailText, 266);

        assertThat(actualSender, equalTo(expectedSender));
        assertThat(actualSubject, equalTo(""+app.site+" - email address verification request"));
        assertThat(actualBody, equalTo("Dear "+app.emailsVerificationsFirstName+", We received your request to verify the email address associated with your "+app.site+" account. Please click on this link to confirm your request and finalise the change. With kind regards, Customer Service Team"));
        assertThat(actualFooter, equalTo(""+app.SITE_REG+" "+app.site+" UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT"));
    }

    @Test(priority = 2)
    public void testChangeEmailDipocketUA() throws InterruptedException, MessagingException, IOException {
        postSendChangeEmail(2, app.mobile_site, 32761);

        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualSender = senderAndSubject.get(0);
        String actualSubject = senderAndSubject.get(1);

        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualBody = getEmailBodyText(emailText, 28, 274);
        String actualFooter = getEmailFooterText(emailText, 275);

        assertThat(actualSender, equalTo(expectedSender));
        assertThat(actualSubject, equalTo(""+app.site+" - запит на верифікацію електронної адреси"));
        assertThat(actualBody, equalTo("Вітаємо, "+app.emailsVerificationsFirstName+"! Ми отримали запит на верифікацію Вашої електронної адреси приєднану до вашого облікового запису "+app.site+". Будь ласка, перейдіть за цим посиланням , щоб підтвердити Ваш запит та завершити зміни. З повагою, Відділ підтримки клієнтів"));
        assertThat(actualFooter, equalTo(""+app.SITE_REG+" Для Вашого спокою, "+app.site+" UAB авторизований та контролюється Банком Литви, як емітент електронних грошей (#75) Upės str. 23, 08128 Vilnius, LT"));
    }

    @Test(priority = 3)
    public void testChangeEmailDipocketPL() throws InterruptedException, MessagingException, IOException {
        postSendChangeEmail(3, app.mobile_site, 32761);

        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualSender = senderAndSubject.get(0);
        String actualSubject = senderAndSubject.get(1);

        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualBody = getEmailBodyText(emailText, 0, 210);
        String actualFooter = getEmailFooterText(emailText, 211);

        assertThat(actualSender, equalTo(expectedSender));
        assertThat(actualSubject, equalTo(""+app.site+" - prośba o weryfikację adresu email"));
        assertThat(actualBody, equalTo("Witaj, "+app.emailsVerificationsFirstName+"! Otrzymaliśmy prośbę o weryfikację adresu email powiązanego z Twoim kontem "+app.site+". Kliknij w ten link , aby potwierdzić tę prośbę i sfinalizować zmianę. Z wyrazami szacunku, Dział Obsługi Klienta"));
        assertThat(actualFooter, equalTo(""+app.SITE_REG+" "+app.site+" UAB, autoryzowana Instytucja Pieniądza Elektronicznego, podlegająca nadzorowi Banku Litwy (numer licencji 75) | Licencjonowana przez Mastercard do działania na Europejskim Obszarze Gospodarczego Upės g. 23, 08128 Vilnius, LT"));
    }

    @Test(priority = 4)
    public void testChangeEmailDipocketRU() throws InterruptedException, MessagingException, IOException {
        postSendChangeEmail(4, app.mobile_site, 32761);

        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualSender = senderAndSubject.get(0);
        String actualSubject = senderAndSubject.get(1);

        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualBody = getEmailBodyText(emailText, 28, 255);
        String actualFooter = getEmailFooterText(emailText, 256);

        assertThat(actualSender, equalTo(expectedSender));
        assertThat(actualSubject, equalTo(""+app.site+" - запрос на верификацию адреса электронной почты"));
        assertThat(actualBody, equalTo("Здравствуйте, "+app.emailsVerificationsFirstName+"! Мы получили запрос на верификацию адреса электронной почты, которая указана в Вашей учетной записи. Пожалуйста, перейдите по этой ссылке , чтобы подтвердить изменение. С уважением, Служба поддержки клиентов"));
        assertThat(actualFooter, equalTo(""+app.SITE_REG+" Для вашего спокойствия, "+app.site+" UAB авторизован и контролируется Банком Литвы как эмитент электронных денег (#75) Upės str. 23, 08128 Vilnius, LT"));
    }

    @Test(priority = 5)
    public void testChangeEmailDiscontuEN() throws InterruptedException, MessagingException, IOException {
        postSendChangeEmail(1, app.mobile_site_discontu, 32717);

        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualSender = senderAndSubject.get(0);
        String actualSubject = senderAndSubject.get(1);

        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualBody = getEmailBodyText(emailText, 46, 265);
        String actualFooter = getEmailFooterText(emailText, 266);

        assertThat(actualSender, equalTo(expectedSender));
        assertThat(actualSubject, equalTo(""+app.site_discontu+" - email address verification request"));
        assertThat(actualBody, equalTo("Dear "+app.emailsVerificationsFirstName+", We received your request to verify the email address associated with your "+app.site_discontu+" account. Please click on this link to confirm your request and finalise the change. With kind regards, Customer Service Team"));
        assertThat(actualFooter, equalTo(""+app.SITE_REG+" "+app.site_discontu+" is powered by DiPocket UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT"));
    }

    @Test(priority = 6)
    public void testChangeEmailDiscontuPL() throws InterruptedException, MessagingException, IOException {
        postSendChangeEmail(2, app.mobile_site_discontu, 32717);

        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualSender = senderAndSubject.get(0);
        String actualSubject = senderAndSubject.get(1);

        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualBody = getEmailBodyText(emailText, 0, 210);
        String actualFooter = getEmailFooterText(emailText, 211);

        assertThat(actualSender, equalTo(expectedSender));
        assertThat(actualSubject, equalTo(""+app.site_discontu+" - prośba o weryfikację adresu email"));
        assertThat(actualBody, equalTo("Witaj, "+app.emailsVerificationsFirstName+"! Otrzymaliśmy prośbę o weryfikację adresu email powiązanego z Twoim kontem "+app.site_discontu+". Kliknij w ten link , aby potwierdzić tę prośbę i sfinalizować zmianę. Z wyrazami szacunku, Dział Obsługi Klienta"));
        assertThat(actualFooter, equalTo(""+app.SITE_REG+" "+app.site_discontu+" dostarcza DiPocket UAB, autoryzowana Instytucja Pieniądza Elektronicznego, podlegająca nadzorowi Banku Litwy (numer licencji 75) | Licencjonowana przez Mastercard do działania na Europejskim Obszarze Gospodarczego Upės g. 23, 08128 Vilnius, LT"));
    }

    @Test(priority = 7)
    public void testChangeEmailPlayITEN() throws InterruptedException, MessagingException, IOException {
        postSendChangeEmail(1, app.mobile_site_playIt, 32732);

        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualSender = senderAndSubject.get(0);
        String actualSubject = senderAndSubject.get(1);

        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualBody = getEmailBodyText(emailText, 44, 261);
        String actualFooter = getEmailFooterText(emailText, 262);

        assertThat(actualSender, equalTo(expectedPlayITSender));
        assertThat(actualSubject, equalTo(""+app.site_PlayIT+" - email address verification request"));
        assertThat(actualBody, equalTo("Dear "+app.emailsVerificationsFirstName+", We received your request to verify the email address associated with your "+app.site_PlayIT+" account. Please click on this link to confirm your request and finalise the change. With kind regards, Customer Service Team"));
        assertThat(actualFooter, equalTo(""+app.SITE_REG+" "+app.site_PlayIT+" is powered by DiPocket UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT"));
    }

    @Test(priority = 8, enabled = false)//bug Change Email(Play IT, Snow Attack) HU email has incorrect body and subject
    public void testChangeEmailPlayITHU() throws InterruptedException, MessagingException, IOException {
        postSendChangeEmail(5, app.mobile_site_playIt, 32732);

        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualSender = senderAndSubject.get(0);
        String actualSubject = senderAndSubject.get(1);

        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualBody = getEmailBodyText(emailText, 44, 276);
        String actualFooter = getEmailFooterText(emailText, 277);

        assertThat(actualSender, equalTo(expectedPlayITSender));
        assertThat(actualSubject, equalTo(""+app.site_PlayIT+" - email cím megerősítés kérés"));
        assertThat(actualBody, equalTo("Kedves "+app.emailsVerificationsFirstName+", Megkaptuk a "+app.site_PlayIT+" fiókjához tartozó e-mail cím megerősítésére vonatkozó kérését. Kérjük, kattintson erre a hivatkozásra a kérése megerősítéséhez és a módosítás véglegesítéséhez. Üdvözlettel, az Ügyfélszolgálati csapat"));
        assertThat(actualFooter, equalTo(""+app.SITE_REG+" Megnyugtatásul tájékoztatjuk, hogy a PlayIT Kártya számládat a DiPocket UAB kezeli, mely vállalatot a Litván Nemzeti Bank elektronikus pénzintézetenként (# 75) engedélyezett és felügyel Upės str. 23, 08128 Vilnius, LT"));
    }

    @Test(priority = 9)
    public void testChangeEmailSnowAttackEN() throws InterruptedException, MessagingException, IOException {
        postSendChangeEmail(1, app.mobile_site_snowAttack, 32855);

        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualSender = senderAndSubject.get(0);
        String actualSubject = senderAndSubject.get(1);

        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualBody = getEmailBodyText(emailText, 49, 271);
        String actualFooter = getEmailFooterText(emailText, 272);

        assertThat(actualSender, equalTo(expectedSender));
        assertThat(actualSubject, equalTo(""+app.site_SnowAttack+" - email address verification request"));
        assertThat(actualBody, equalTo("Dear "+app.emailsVerificationsFirstName+", We received your request to verify the email address associated with your "+app.site_SnowAttack+" account. Please click on this link to confirm your request and finalise the change. With kind regards, Customer Service Team"));
        assertThat(actualFooter, equalTo(""+app.SITE_REG+" "+app.site_SnowAttack+" is powered by DiPocket UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT"));
    }

    @Test(priority = 10, enabled = false) //bug  Change Email(Play IT, Snow Attack) HU email has incorrect body and subject
    public void testChangeEmailSnowAttackHU() throws InterruptedException, MessagingException, IOException {
        postSendChangeEmail(5, app.mobile_site_snowAttack, 32855);

        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualSender = senderAndSubject.get(0);
        String actualSubject = senderAndSubject.get(1);

        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualBody = getEmailBodyText(emailText, 49, 286);
        String actualFooter = getEmailFooterText(emailText, 287);

        assertThat(actualSender, equalTo(expectedSender));
        assertThat(actualSubject, equalTo(""+app.site_SnowAttack+" - email cím megerősítés kérés"));
        assertThat(actualBody, equalTo("Kedves "+app.emailsVerificationsFirstName+", Megkaptuk a "+app.site_SnowAttack+" fiókjához tartozó e-mail cím megerősítésére vonatkozó kérését. Kérjük, kattintson erre a hivatkozásra a kérése megerősítéséhez és a módosítás véglegesítéséhez. Üdvözlettel, az Ügyfélszolgálati csapat"));
        assertThat(actualFooter, equalTo(""+app.SITE_REG+" "+app.site_SnowAttack+", a DiPocket UAB támogatásával, mely vállalatot a Litván Nemzeti Bank elektronikus pénzintézetenként (# 75) engedélyezett és felügyel | a Mastercard licencével rendelkezik az Európai Gazdasági Térségre vonatkozva Upės str. 23, 08128 Vilnius, LT"));
    }

    @Test(priority = 11)//bug incorrect email sender
    public void testChangeEmailSodexoPLEN() throws InterruptedException, MessagingException, IOException {
        postSendChangeEmail(1, app.mobile_site_sodexo, 32762);

        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualSender = senderAndSubject.get(0);
        String actualSubject = senderAndSubject.get(1);

        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualBody = getEmailBodyText(emailText, 94, 724);

        //assertThat(actualSender, equalTo(expectedSodexoSender));
        assertThat(actualSubject, equalTo(""+app.site_Sodexo+" - email address verification request"));
        assertThat(actualBody, equalTo(""+app.emailsVerificationsFirstName+" Burinsky, Potwierdź adres mailowy powiązany z Twoim Profilem Wirtualnej Karty Sodexo. Kliknij w ten link, aby potwierdzić i zakończyć proces. Pozdrawiamy, Zespół Wirtualnej Karty Sodexo Centrum Obsługi Klienta +48 (22) 535 11 11 | info.svc.pl@sodexo.com Your Virtual Sodexo Card profile - email address verification request "+app.emailsVerificationsFirstName+" Burinsky, Verify the email address associated with your Virtual Sodexo Card Profile. Please click on this link to confirm and finalize the process. With kind regards, Virtual Sodexo Card Team Customer Service Center +48 (22) 535 11 11 | info.svc.pl@sodexo.com powered by DiPocket (dipocket.org)"));
    }

    @Test(priority = 12)
    public void testChangeEmailTelenorEN() throws InterruptedException, MessagingException, IOException {
        postSendChangeEmail(1, app.telenorSite, 32726);

        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualSender = senderAndSubject.get(0);
        String actualSubject = senderAndSubject.get(1);

        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualBody = getEmailBodyText(emailText, 0, 218);
        String actualFooter = getEmailFooterText(emailText, 219);

        assertThat(actualSender, equalTo(expectedTelenorSender));
        assertThat(actualSubject, equalTo(""+app.site_Telenor+" - email address verification request"));
        assertThat(actualBody, equalTo("Dear "+app.emailsVerificationsFirstName+", We received your request to verify the email address associated with your "+app.site_Telenor+" account. Please click on this link to confirm your request and finalise the change. With kind regards, Customer Service Team"));
        assertThat(actualFooter, equalTo(""+app.SITE_REG+" "+app.site_Telenor+" is powered by DiPocket UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT"));
    }

    @Test(priority = 13) //bug There are no subject documentations for these emails
    public void testChangeEmailTelenorHU() throws InterruptedException, MessagingException, IOException {
        postSendChangeEmail(5, app.telenorSite, 32726);

        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualSender = senderAndSubject.get(0);
        String actualSubject = senderAndSubject.get(1);

        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualBody = getEmailBodyText(emailText, 0, 233);
        String actualFooter = getEmailFooterText(emailText, 234);

        assertThat(actualSender, equalTo(expectedTelenorSender));
        //assertThat(actualSubject, equalTo(""+site+" - email address verification request"));
        assertThat(actualBody, equalTo("Kedves "+app.emailsVerificationsFirstName+", Megkaptuk a "+app.site_Telenor+" fiókjához tartozó e-mail cím megerősítésére vonatkozó kérését. Kérjük, kattintson erre a hivatkozásra a kérése megerősítéséhez és a módosítás véglegesítéséhez. Üdvözlettel, az Ügyfélszolgálati csapat"));
        assertThat(actualFooter, equalTo(""+app.SITE_REG+" "+app.site_Telenor+", a DiPocket UAB támogatásával, mely vállalatot a Litván Nemzeti Bank elektronikus pénzintézetenként (# 75) engedélyezett és felügyel | a Mastercard licencével rendelkezik az Európai Gazdasági Térségre vonatkozva Upės str. 23, 08128 Vilnius, LT"));
    }

    @Test(priority = 14)
    public void testChangeEmailUpAndGoEN() throws InterruptedException, MessagingException, IOException {
        postSendChangeEmail(1, app.mobile_site_upAndGo, 32727);

        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualSender = senderAndSubject.get(0);
        String actualSubject = senderAndSubject.get(1);

        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualBody = getEmailBodyText(emailText, 47, 267);
        String actualFooter = getEmailFooterText(emailText, 268);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualSender, expectedUpAndGoSender, "Sender is not correct");
        softAssert.assertEquals(actualSubject, ""+app.site_upAndGo+" - email address verification request", "Subject is not correct");
        softAssert.assertEquals(actualBody, "Dear "+app.emailsVerificationsFirstName+", We received your request to verify the email address associated with your "+app.site_upAndGo+" account. Please click on this link to confirm your request and finalise the change. With kind regards, Customer Service Team", "Body is not correct");
        softAssert.assertEquals(actualFooter, ""+app.SITE_REG+" "+app.site_upAndGo+" is powered by DiPocket UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT", "Footer is not correct");
        softAssert.assertAll();
    }

    @Test(priority = 15)
    public void testChangeEmailUpAndGoUA() throws InterruptedException, MessagingException, IOException {
        postSendChangeEmail(2, app.mobile_site_upAndGo, 32727);

        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualSender = senderAndSubject.get(0);
        String actualSubject = senderAndSubject.get(1);

        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualBody = getEmailBodyText(emailText, 29, 276);
        String actualFooter = getEmailFooterText(emailText, 277);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualSender, expectedUpAndGoSender, "Sender is not correct");
        softAssert.assertEquals(actualSubject, ""+app.site_upAndGo+" - запит на верифікацію електронної адреси", "Subject is not correct");
        softAssert.assertEquals(actualBody, "Вітаємо, "+app.emailsVerificationsFirstName+"! Ми отримали запит на верифікацію Вашої електронної адреси приєднану до вашого облікового запису "+app.site_upAndGo+". Будь ласка, перейдіть за цим посиланням , щоб підтвердити Ваш запит та завершити зміни. З повагою, Відділ підтримки клієнтів", "Body is not correct");
        softAssert.assertEquals(actualFooter, ""+app.SITE_REG+" Для Вашого спокою, "+app.site_upAndGo+" працює при підтримці DiPocket UAB, що авторизований та контролюється Банком Литви, як емітент електронних грошей (#75) Upės str. 23, 08128 Vilnius, LT", "Footer is not correct");
        softAssert.assertAll();
    }

    @Test(priority = 16)
    public void testChangeEmailUpAndGoPL() throws InterruptedException, MessagingException, IOException {
        postSendChangeEmail(3, app.mobile_site_upAndGo, 32727);

        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualSender = senderAndSubject.get(0);
        String actualSubject = senderAndSubject.get(1);

        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualBody = getEmailBodyText(emailText, 0, 211);
        String actualFooter = getEmailFooterText(emailText, 212);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualSender, expectedUpAndGoSender, "Sender is not correct");
        softAssert.assertEquals(actualSubject, ""+app.site_upAndGo+" - prośba o weryfikację adresu email", "Subject is not correct");
        softAssert.assertEquals(actualBody, "Witaj, "+app.emailsVerificationsFirstName+"! Otrzymaliśmy prośbę o weryfikację adresu email powiązanego z Twoim kontem "+app.site_upAndGo+". Kliknij w ten link , aby potwierdzić tę prośbę i sfinalizować zmianę. Z wyrazami szacunku, Dział Obsługi Klienta", "Body is not correct");
        softAssert.assertEquals(actualFooter, ""+app.SITE_REG+" "+app.site_upAndGo+" dostarcza DiPocket UAB, autoryzowana Instytucja Pieniądza Elektronicznego, podlegająca nadzorowi Banku Litwy (numer licencji 75) | Licencjonowana przez Mastercard do działania na Europejskim Obszarze Gospodarczego Upės g. 23, 08128 Vilnius, LT", "Footer is not correct");
        softAssert.assertAll();
    }

    @Test(priority = 17)
    public void testChangeEmailUpAndGoRU() throws InterruptedException, MessagingException, IOException {
        postSendChangeEmail(4, app.mobile_site_upAndGo, 32727);

        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualSender = senderAndSubject.get(0);
        String actualSubject = senderAndSubject.get(1);

        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualBody = getEmailBodyText(emailText, 29, 256);
        String actualFooter = getEmailFooterText(emailText, 257);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualSender, expectedUpAndGoSender, "Sender is not correct");
        softAssert.assertEquals(actualSubject, ""+app.site_upAndGo+" - запрос на верификацию адреса электронной почты", "Subject is not correct");
        softAssert.assertEquals(actualBody, "Здравствуйте, "+app.emailsVerificationsFirstName+"! Мы получили запрос на верификацию адреса электронной почты, которая указана в Вашей учетной записи. Пожалуйста, перейдите по этой ссылке , чтобы подтвердить изменение. С уважением, Служба поддержки клиентов", "Body is not correct");
        softAssert.assertEquals(actualFooter, ""+app.SITE_REG+" Для вашего спокойствия, "+app.site_upAndGo+" осуществляет деятельность при поддержке DiPocket UAB, который авторизован и контролируется Банком Литвы как эмитент электронных денег (#75) Upės str. 23, 08128 Vilnius, LT", "Footer is not correct");
        softAssert.assertAll();
    }
}
