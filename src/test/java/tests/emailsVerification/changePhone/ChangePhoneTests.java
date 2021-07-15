package tests.emailsVerification.changePhone;

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

public class ChangePhoneTests extends TestBase {
    String expectedSender = "customer.service@dipocket.org";
    String expectedUpAndGoSender = "wsparcie@upcard.pl";
    String expectedPlayITSender = "PlayIT Card <customer.service@dipocket.org>";
    String newPhone = "new phone";

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

    public void postSendChangePhoneMailRealFlow(int landId, String site, int id) {
        given()
                .spec(app.requestSpecEmailVerification)
                .body(body(landId, site, id))
                .when()
                .post( "/EmailService/sendChangePhoneMail")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test(priority = 1)
    public void testChangePhoneDipocketEN() throws InterruptedException, MessagingException, IOException {
        postSendChangePhoneMailRealFlow(1, app.mobile_site, 32761);

        String emailSender =  EmailVerificationHelper.getEmailSender(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailBody = getEmailBodyText(emailText, 41, 381);
        String emailFooter = getEmailFooterText(emailText, 382);

        assertThat(emailSender, equalTo(expectedSender));
        assertThat(emailBody, equalTo("Dear "+app.emailsVerificationsFirstName+", The mobile phone number associated with your "+app.site+" account was changed to: "+newPhone+". If you didn't change it, please click on this link , to block your account and protect your money. You can then contact us at your earliest convenience so that we can safely reactivate your account. With kind regards, Customer Service Team"));
        assertThat(emailFooter, equalTo(""+app.SITE_REG+" "+app.site+" UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT"));
    }

    @Test(priority = 2)
    public void testChangePhoneDipocketUA() throws InterruptedException, MessagingException, IOException {
        postSendChangePhoneMailRealFlow(2, app.mobile_site, 32761);

        String emailSender =  EmailVerificationHelper.getEmailSender(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailBody = getEmailBodyText(emailText, 28, 359);
        String emailFooter = getEmailFooterText(emailText, 360);

        assertThat(emailSender, equalTo(expectedSender));
        assertThat(emailBody, equalTo("Вітаємо, "+app.emailsVerificationsFirstName+"! Номер телефону, приєднаний до вашого облікового запису "+app.site+", було змінено на "+newPhone+". Якщо Ви цього не робили, будь ласка, натисніть на це посилання , щоб заблокувати обліковий запис та захистити свої кошти. Після цього Ви можете зв'язатися з нами для відновлення доступу. З повагою, Відділ підтримки клієнтів"));
        assertThat(emailFooter, equalTo(""+app.SITE_REG+" Для Вашого спокою, "+app.site+" UAB авторизований та контролюється Банком Литви, як емітент електронних грошей (#75) Upės str. 23, 08128 Vilnius, LT"));
    }

    @Test(priority = 3)
    public void testChangePhoneDipocketPL() throws InterruptedException, MessagingException, IOException {
        postSendChangePhoneMailRealFlow(3, app.mobile_site, 32761);

        String emailSender =  EmailVerificationHelper.getEmailSender(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailBody = getEmailBodyText(emailText, 0, 337);
        String emailFooter = getEmailFooterText(emailText, 338);

        assertThat(emailSender, equalTo(expectedSender));
        assertThat(emailBody, equalTo("Witaj, "+app.emailsVerificationsFirstName+"! Numer telefonu powiązany z Twoim kontem "+app.site+" został zmieniony na: "+newPhone+". Jeśli nie zmieniałeś numeru telefonu, kliknij w ten link aby zablokować konto i zabezpieczyć Twoje środki. Następnie skontaktuj się z nami w wybranym momencie, aby bezpiecznie odblokować Twoje konto. Z wyrazami szacunku, Dział Obsługi Klienta"));
        assertThat(emailFooter, equalTo(""+app.SITE_REG+" "+app.site+" UAB, autoryzowana Instytucja Pieniądza Elektronicznego, podlegająca nadzorowi Banku Litwy (numer licencji 75) | Licencjonowana przez Mastercard do działania na Europejskim Obszarze Gospodarczego Upės g. 23, 08128 Vilnius, LT"));
    }

    @Test(priority = 4)
    public void testChangePhoneDipocketRU() throws InterruptedException, MessagingException, IOException {
        postSendChangePhoneMailRealFlow(4, app.mobile_site, 32761);

        String emailSender =  EmailVerificationHelper.getEmailSender(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailBody = getEmailBodyText(emailText, 28, 362);
        String emailFooter = getEmailFooterText(emailText, 363);

        assertThat(emailSender, equalTo(expectedSender));
        assertThat(emailBody, equalTo("Здравствуйте, "+app.emailsVerificationsFirstName+"! Номер телефона, указанный для Вашей учетной записи был изменен. Новое значение: "+newPhone+". Если Вы этого не делали, перейдите по этой ссылке , чтобы заблокировать вашу учетную запись и защитить свои средства. После этого Вы можете связаться с нами для возобновления доступа. С уважением, Служба поддержки клиентов"));
        assertThat(emailFooter, equalTo(""+app.SITE_REG+" Для вашего спокойствия, "+app.site+" UAB авторизован и контролируется Банком Литвы как эмитент электронных денег (#75) Upės str. 23, 08128 Vilnius, LT"));
    }

    @Test(priority = 5)
    public void testChangePhoneDiscontuEN() throws InterruptedException, MessagingException, IOException {
        postSendChangePhoneMailRealFlow(1, app.mobile_site_discontu, 32717);

        String emailSender =  EmailVerificationHelper.getEmailSender(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailBody = getEmailBodyText(emailText, 41, 381);
        String emailFooter = getEmailFooterText(emailText, 382);

        assertThat(emailSender, equalTo(expectedSender));
        assertThat(emailBody, equalTo("Dear "+app.emailsVerificationsFirstName+", The mobile phone number associated with your discontu account was changed to: "+newPhone+". If you didn't change it, please click on this link , to block your account and protect your money. You can then contact us at your earliest convenience so that we can safely reactivate your account. With kind regards, Customer Service Team"));
        assertThat(emailFooter, equalTo(""+app.SITE_REG+" "+app.site_discontu+" is powered by DiPocket UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT"));
    }

    @Test(priority = 6)
    public void testChangePhoneDiscontuPL() throws InterruptedException, MessagingException, IOException {
        postSendChangePhoneMailRealFlow(3, app.mobile_site_discontu, 32717);

        String emailSender =  EmailVerificationHelper.getEmailSender(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailBody = getEmailBodyText(emailText, 0, 337);
        String emailFooter = getEmailFooterText(emailText, 338);

        assertThat(emailSender, equalTo(expectedSender));
        assertThat(emailBody, equalTo("Witaj, "+app.emailsVerificationsFirstName+"! Numer telefonu powiązany z Twoim kontem discontu został zmieniony na: "+newPhone+". Jeśli nie zmieniałeś numeru telefonu, kliknij w ten link aby zablokować konto i zabezpieczyć Twoje środki. Następnie skontaktuj się z nami w wybranym momencie, aby bezpiecznie odblokować Twoje konto. Z wyrazami szacunku, Dział Obsługi Klienta"));
        assertThat(emailFooter, equalTo(""+app.SITE_REG+" "+app.site_discontu+" dostarcza DiPocket UAB, autoryzowana Instytucja Pieniądza Elektronicznego, podlegająca nadzorowi Banku Litwy (numer licencji 75) | Licencjonowana przez Mastercard do działania na Europejskim Obszarze Gospodarczego Upės g. 23, 08128 Vilnius, LT"));
    }

    @Test(priority = 7)
    public void testChangePhonePlayITEN() throws InterruptedException, MessagingException, IOException {
        postSendChangePhoneMailRealFlow(1, app.mobile_site_playIt, 32732);

        String emailSender =  EmailVerificationHelper.getEmailSender(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailBody = getEmailBodyText(emailText, 39, 378);
        String emailFooter = getEmailFooterText(emailText, 379);

        assertThat(emailSender, equalTo(expectedPlayITSender));
        assertThat(emailBody, equalTo("Dear "+app.emailsVerificationsFirstName+", The mobile phone number associated with your PlayIT account was changed to: "+newPhone+". If you didn't change it, please  click on this link , to block your account and protect your money. You can then contact us at your earliest convenience so that we can safely reactivate your account. With kind regards, Customer Service Team"));
        assertThat(emailFooter, equalTo(""+app.SITE_REG+" "+app.site_PlayIT+" is powered by DiPocket UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT"));
    }

    @Test(priority = 8)
    public void testChangePhonePlayITHU() throws InterruptedException, MessagingException, IOException {
        postSendChangePhoneMailRealFlow(5, app.mobile_site_playIt, 32732);

        String emailSender =  EmailVerificationHelper.getEmailSender(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailBody = getEmailBodyText(emailText, 39, 409);
        String emailFooter = getEmailFooterText(emailText, 410);

        assertThat(emailSender, equalTo(expectedPlayITSender));
        assertThat(emailBody, equalTo("Kedves "+app.emailsVerificationsFirstName+", A PlayIT számlájához kapcsolt mobilszám megváltozott erre: new phone Ha nem Ön kezdeményezte a változtatást, akkor klikkelje erre a linkre, hogy a számlája letiltásra kerüljön és a pénze védve legyen. Később felveheti velünk a kapcsolatot egy Önnek kényelmes időpontban, hogy biztonságosan újra-aktiváljuk a számláját. Üdvözlettel, Ügyfélszolgálati csoport"));
        assertThat(emailFooter, equalTo(""+app.SITE_REG+" Megnyugtatásul tájékoztatjuk, hogy a PlayIT Kártya számládat a DiPocket UAB kezeli, mely vállalatot a Litván Nemzeti Bank elektronikus pénzintézetenként (# 75) engedélyezett és felügyel Upės str. 23, 08128 Vilnius, LT"));
    }

    @Test(priority = 9, enabled = false)
    public void testChangePhoneUpAndGoEN() throws InterruptedException, MessagingException, IOException {
        postSendChangePhoneMailRealFlow(1, app.mobile_site_upAndGo, 32727);

        String emailSender =  EmailVerificationHelper.getEmailSender(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailBody = getEmailBodyText(emailText, 42, 383);
        String emailFooter = getEmailFooterText(emailText, 384);

        assertThat(emailSender, equalTo(expectedUpAndGoSender));
        assertThat(emailBody, equalTo("Dear "+app.emailsVerificationsFirstName+", The mobile phone number associated with your up and go account was changed to: "+newPhone+". If you didn't change it, please click on this link , to block your account and protect your money. You can then contact us at your earliest convenience so that we can safely reactivate your account. With kind regards, Customer Service Team"));
        assertThat(emailFooter, equalTo(""+app.SITE_REG+" "+app.site_upAndGo+" is powered by DiPocket UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT"));
    }

    @Test(priority = 10, enabled = false)
    public void testChangePhoneUpAndGoUA() throws InterruptedException, MessagingException, IOException {
        postSendChangePhoneMailRealFlow(2, app.mobile_site_upAndGo, 32727);

        String emailSender =  EmailVerificationHelper.getEmailSender(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailBody = getEmailBodyText(emailText, 29, 361);
        String emailFooter = getEmailFooterText(emailText, 362);

        assertThat(emailSender, equalTo(expectedUpAndGoSender));
        assertThat(emailBody, equalTo("Вітаємо, "+app.emailsVerificationsFirstName+"! Номер телефону, приєднаний до вашого облікового запису up and go, було змінено на "+newPhone+". Якщо Ви цього не робили, будь ласка, натисніть на це посилання , щоб заблокувати обліковий запис та захистити свої кошти. Після цього Ви можете зв'язатися з нами для відновлення доступу. З повагою, Відділ підтримки клієнтів"));
        assertThat(emailFooter, equalTo(""+app.SITE_REG+" Для Вашого спокою, "+app.site_upAndGo+" працює при підтримці DiPocket UAB, що авторизований та контролюється Банком Литви, як емітент електронних грошей (#75) Upės str. 23, 08128 Vilnius, LT"));
    }

    @Test(priority = 11, enabled = false)
    public void testChangePhoneUpAndGoPL() throws InterruptedException, MessagingException, IOException {
        postSendChangePhoneMailRealFlow(3, app.mobile_site_upAndGo, 32727);

        String emailSender =  EmailVerificationHelper.getEmailSender(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailBody = getEmailBodyText(emailText, 0, 338);
        String emailFooter = getEmailFooterText(emailText, 339);

        assertThat(emailSender, equalTo(expectedUpAndGoSender));
        assertThat(emailBody, equalTo("Witaj, "+app.emailsVerificationsFirstName+"! Numer telefonu powiązany z Twoim kontem up and go został zmieniony na: "+newPhone+". Jeśli nie zmieniałeś numeru telefonu, kliknij w ten link aby zablokować konto i zabezpieczyć Twoje środki. Następnie skontaktuj się z nami w wybranym momencie, aby bezpiecznie odblokować Twoje konto. Z wyrazami szacunku, Dział Obsługi Klienta"));
        assertThat(emailFooter, equalTo(""+app.SITE_REG+" "+app.site_upAndGo+" dostarcza DiPocket UAB, autoryzowana Instytucja Pieniądza Elektronicznego, podlegająca nadzorowi Banku Litwy (numer licencji 75) | Licencjonowana przez Mastercard do działania na Europejskim Obszarze Gospodarczego Upės g. 23, 08128 Vilnius, LT"));
    }

    @Test(priority = 12, enabled = false)
    public void testChangePhoneUpAndGoRU() throws InterruptedException, MessagingException, IOException {
        postSendChangePhoneMailRealFlow(4, app.mobile_site_upAndGo, 32727);

        String emailSender =  EmailVerificationHelper.getEmailSender(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailBody = getEmailBodyText(emailText, 29, 363);
        String emailFooter = getEmailFooterText(emailText, 364);

        assertThat(emailSender, equalTo(expectedUpAndGoSender));
        assertThat(emailBody, equalTo("Здравствуйте, "+app.emailsVerificationsFirstName+"! Номер телефона, указанный для Вашей учетной записи был изменен. Новое значение: "+newPhone+". Если Вы этого не делали, перейдите по этой ссылке , чтобы заблокировать вашу учетную запись и защитить свои средства. После этого Вы можете связаться с нами для возобновления доступа. С уважением, Служба поддержки клиентов"));
        assertThat(emailFooter, equalTo(""+app.SITE_REG+" Для вашего спокойствия, "+app.site_upAndGo+" осуществляет деятельность при поддержке DiPocket UAB, который авторизован и контролируется Банком Литвы как эмитент электронных денег (#75) Upės str. 23, 08128 Vilnius, LT"));
    }

    @Test(priority = 13)
    public void testChangePhoneSnowAttackEN() throws InterruptedException, MessagingException, IOException {
        postSendChangePhoneMailRealFlow(1, app.mobile_site_snowAttack, 32855);

        String emailSender =  EmailVerificationHelper.getEmailSender(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailBody = getEmailBodyText(emailText, 44, 388);
        String emailFooter = getEmailFooterText(emailText, 389);

        assertThat(emailSender, equalTo(expectedSender));
        assertThat(emailBody, equalTo("Dear "+app.emailsVerificationsFirstName+", The mobile phone number associated with your Snow Attack account was changed to: "+newPhone+". If you didn't change it, please  click on this link , to block your account and protect your money. You can then contact us at your earliest convenience so that we can safely reactivate your account. With kind regards, Customer Service Team"));
        assertThat(emailFooter, equalTo(""+app.SITE_REG+" "+app.site_SnowAttack+" is powered by DiPocket UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT"));
    }

    @Test(priority = 14)
    public void testChangePhoneSnowAttackHU() throws InterruptedException, MessagingException, IOException {
        postSendChangePhoneMailRealFlow(5, app.mobile_site_snowAttack, 32855);

        String emailSender =  EmailVerificationHelper.getEmailSender(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailBody = getEmailBodyText(emailText, 44, 419);
        String emailFooter = getEmailFooterText(emailText, 420);

        assertThat(emailSender, equalTo(expectedSender));
        assertThat(emailBody, equalTo("Kedves "+app.emailsVerificationsFirstName+", A Snow Attack számlájához kapcsolt mobilszám megváltozott erre: new phone Ha nem Ön kezdeményezte a változtatást, akkor klikkelje erre a linkre, hogy a számlája letiltásra kerüljön és a pénze védve legyen. Később felveheti velünk a kapcsolatot egy Önnek kényelmes időpontban, hogy biztonságosan újra-aktiváljuk a számláját. Üdvözlettel, Ügyfélszolgálati csoport"));
        assertThat(emailFooter, equalTo(""+app.SITE_REG+" Snow Attack, a DiPocket UAB támogatásával, mely vállalatot a Litván Nemzeti Bank elektronikus pénzintézetenként (# 75) engedélyezett és felügyel | a Mastercard licencével rendelkezik az Európai Gazdasági Térségre vonatkozva Upės str. 23, 08128 Vilnius, LT"));
    }

    @Test(priority = 15)//bug, incorrect sender Change Phone Sodexo has ${LAST NAME} and ${NEW_PHONE_NUMBER} in the body
    public void testChangePhoneSodexo() throws InterruptedException, MessagingException, IOException {
        postSendChangePhoneMailRealFlow(1, "SODEXO", 32762);

        String emailSender =  EmailVerificationHelper.getEmailSender(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailBody = getEmailBodyText(emailText, 44, 419);
        String emailFooter = getEmailFooterText(emailText, 420);

        //assertThat(emailSender, equalTo(expectedSender));
        assertThat(emailBody, equalTo("Kedves "+app.emailsVerificationsFirstName+", A Snow Attack számlájához kapcsolt mobilszám megváltozott erre: new phone Ha nem Ön kezdeményezte a változtatást, akkor klikkelje erre a linkre, hogy a számlája letiltásra kerüljön és a pénze védve legyen. Később felveheti velünk a kapcsolatot egy Önnek kényelmes időpontban, hogy biztonságosan újra-aktiváljuk a számláját. Üdvözlettel, Ügyfélszolgálati csoport"));
        assertThat(emailFooter, equalTo(""+app.SITE_REG+" Snow Attack, a DiPocket UAB támogatásával, mely vállalatot a Litván Nemzeti Bank elektronikus pénzintézetenként (# 75) engedélyezett és felügyel | a Mastercard licencével rendelkezik az Európai Gazdasági Térségre vonatkozva Upės str. 23, 08128 Vilnius, LT"));
    }
}