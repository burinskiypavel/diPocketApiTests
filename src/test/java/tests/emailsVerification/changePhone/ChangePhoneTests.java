package tests.emailsVerification.changePhone;

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

        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualSender = senderAndSubject.get(0);
        String actualSubject = senderAndSubject.get(1);

        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualBody = getEmailBodyText(emailText, 41, 381);
        String actualFooter = getEmailFooterText(emailText, 382);

        assertThat(actualSender, equalTo(expectedSender));
        assertThat(actualSubject, equalTo(""+app.site+" - change of mobile phone number"));
        assertThat(actualBody, equalTo("Dear "+app.emailsVerificationsFirstName+", The mobile phone number associated with your "+app.site+" account was changed to: "+newPhone+". If you didn't change it, please click on this link , to block your account and protect your money. You can then contact us at your earliest convenience so that we can safely reactivate your account. With kind regards, Customer Service Team"));
        assertThat(actualFooter, equalTo(""+app.SITE_REG+" "+app.site+" UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT"));
    }

    @Test(priority = 2)
    public void testChangePhoneDipocketUA() throws InterruptedException, MessagingException, IOException {
        postSendChangePhoneMailRealFlow(2, app.mobile_site, 32761);

        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualSender = senderAndSubject.get(0);
        String actualSubject = senderAndSubject.get(1);

        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualBody = getEmailBodyText(emailText, 28, 359);
        String actualFooter = getEmailFooterText(emailText, 360);

        assertThat(actualSender, equalTo(expectedSender));
        assertThat(actualSubject, equalTo(""+app.site+" - зміна номеру телефона"));
        assertThat(actualBody, equalTo("Вітаємо, "+app.emailsVerificationsFirstName+"! Номер телефону, приєднаний до вашого облікового запису "+app.site+", було змінено на "+newPhone+". Якщо Ви цього не робили, будь ласка, натисніть на це посилання , щоб заблокувати обліковий запис та захистити свої кошти. Після цього Ви можете зв'язатися з нами для відновлення доступу. З повагою, Відділ підтримки клієнтів"));
        assertThat(actualFooter, equalTo(""+app.SITE_REG+" Для Вашого спокою, "+app.site+" UAB авторизований та контролюється Банком Литви, як емітент електронних грошей (#75) Upės str. 23, 08128 Vilnius, LT"));
    }

    @Test(priority = 3)
    public void testChangePhoneDipocketPL() throws InterruptedException, MessagingException, IOException {
        postSendChangePhoneMailRealFlow(3, app.mobile_site, 32761);

        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualSender = senderAndSubject.get(0);
        String actualSubject = senderAndSubject.get(1);

        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualBody = getEmailBodyText(emailText, 0, 337);
        String actualFooter = getEmailFooterText(emailText, 338);

        assertThat(actualSender, equalTo(expectedSender));
        assertThat(actualSubject, equalTo(""+app.site+" - zmiana numeru telefonu"));
        assertThat(actualBody, equalTo("Witaj, "+app.emailsVerificationsFirstName+"! Numer telefonu powiązany z Twoim kontem "+app.site+" został zmieniony na: "+newPhone+". Jeśli nie zmieniałeś numeru telefonu, kliknij w ten link aby zablokować konto i zabezpieczyć Twoje środki. Następnie skontaktuj się z nami w wybranym momencie, aby bezpiecznie odblokować Twoje konto. Z wyrazami szacunku, Dział Obsługi Klienta"));
        assertThat(actualFooter, equalTo(""+app.SITE_REG+" "+app.site+" UAB, autoryzowana Instytucja Pieniądza Elektronicznego, podlegająca nadzorowi Banku Litwy (numer licencji 75) | Licencjonowana przez Mastercard do działania na Europejskim Obszarze Gospodarczego Upės g. 23, 08128 Vilnius, LT"));
    }

    @Test(priority = 4)
    public void testChangePhoneDipocketRU() throws InterruptedException, MessagingException, IOException {
        postSendChangePhoneMailRealFlow(4, app.mobile_site, 32761);

        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualSender = senderAndSubject.get(0);
        String actualSubject = senderAndSubject.get(1);

        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualBody = getEmailBodyText(emailText, 28, 362);
        String actualFooter = getEmailFooterText(emailText, 363);

        assertThat(actualSender, equalTo(expectedSender));
        assertThat(actualSubject, equalTo(""+app.site+" - изменение номера телефона"));
        assertThat(actualBody, equalTo("Здравствуйте, "+app.emailsVerificationsFirstName+"! Номер телефона, указанный для Вашей учетной записи был изменен. Новое значение: "+newPhone+". Если Вы этого не делали, перейдите по этой ссылке , чтобы заблокировать вашу учетную запись и защитить свои средства. После этого Вы можете связаться с нами для возобновления доступа. С уважением, Служба поддержки клиентов"));
        assertThat(actualFooter, equalTo(""+app.SITE_REG+" Для вашего спокойствия, "+app.site+" UAB авторизован и контролируется Банком Литвы как эмитент электронных денег (#75) Upės str. 23, 08128 Vilnius, LT"));
    }

    @Test(priority = 5)
    public void testChangePhoneDiscontuEN() throws InterruptedException, MessagingException, IOException {
        postSendChangePhoneMailRealFlow(1, app.mobile_site_discontu, 32717);

        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualSender = senderAndSubject.get(0);
        String actualSubject = senderAndSubject.get(1);

        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualBody = getEmailBodyText(emailText, 41, 381);
        String actualFooter = getEmailFooterText(emailText, 382);

        assertThat(actualSender, equalTo(expectedSender));
        assertThat(actualSubject, equalTo(""+app.site_discontu+" - change of mobile phone number"));
        assertThat(actualBody, equalTo("Dear "+app.emailsVerificationsFirstName+", The mobile phone number associated with your discontu account was changed to: "+newPhone+". If you didn't change it, please click on this link , to block your account and protect your money. You can then contact us at your earliest convenience so that we can safely reactivate your account. With kind regards, Customer Service Team"));
        assertThat(actualFooter, equalTo(""+app.SITE_REG+" "+app.site_discontu+" is powered by DiPocket UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT"));
    }

    @Test(priority = 6)
    public void testChangePhoneDiscontuPL() throws InterruptedException, MessagingException, IOException {
        postSendChangePhoneMailRealFlow(3, app.mobile_site_discontu, 32717);

        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualSender = senderAndSubject.get(0);
        String actualSubject = senderAndSubject.get(1);

        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualBody = getEmailBodyText(emailText, 0, 337);
        String actualFooter = getEmailFooterText(emailText, 338);

        assertThat(actualSender, equalTo(expectedSender));
        assertThat(actualSubject, equalTo(""+app.site_discontu+" - zmiana numeru telefonu"));
        assertThat(actualBody, equalTo("Witaj, "+app.emailsVerificationsFirstName+"! Numer telefonu powiązany z Twoim kontem discontu został zmieniony na: "+newPhone+". Jeśli nie zmieniałeś numeru telefonu, kliknij w ten link aby zablokować konto i zabezpieczyć Twoje środki. Następnie skontaktuj się z nami w wybranym momencie, aby bezpiecznie odblokować Twoje konto. Z wyrazami szacunku, Dział Obsługi Klienta"));
        assertThat(actualFooter, equalTo(""+app.SITE_REG+" "+app.site_discontu+" dostarcza DiPocket UAB, autoryzowana Instytucja Pieniądza Elektronicznego, podlegająca nadzorowi Banku Litwy (numer licencji 75) | Licencjonowana przez Mastercard do działania na Europejskim Obszarze Gospodarczego Upės g. 23, 08128 Vilnius, LT"));
    }

    @Test(priority = 7)
    public void testChangePhonePlayITEN() throws InterruptedException, MessagingException, IOException {
        postSendChangePhoneMailRealFlow(1, app.mobile_site_playIt, 32732);

        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualSender = senderAndSubject.get(0);
        String actualSubject = senderAndSubject.get(1);

        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualBody = getEmailBodyText(emailText, 39, 378);
        String actualFooter = getEmailFooterText(emailText, 379);

        assertThat(actualSender, equalTo(expectedPlayITSender));
        assertThat(actualSubject, equalTo(""+app.site_PlayIT+" - change of mobile phone number"));
        assertThat(actualBody, equalTo("Dear "+app.emailsVerificationsFirstName+", The mobile phone number associated with your PlayIT account was changed to: "+newPhone+". If you didn't change it, please  click on this link , to block your account and protect your money. You can then contact us at your earliest convenience so that we can safely reactivate your account. With kind regards, Customer Service Team"));
        assertThat(actualFooter, equalTo(""+app.SITE_REG+" "+app.site_PlayIT+" is powered by DiPocket UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT"));
    }

    @Test(priority = 8)
    public void testChangePhonePlayITHU() throws InterruptedException, MessagingException, IOException {
        postSendChangePhoneMailRealFlow(5, app.mobile_site_playIt, 32732);

        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualSender = senderAndSubject.get(0);
        String actualSubject = senderAndSubject.get(1);

        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualBody = getEmailBodyText(emailText, 39, 409);
        String actualFooter = getEmailFooterText(emailText, 410);

        assertThat(actualSender, equalTo(expectedPlayITSender));
        assertThat(actualSubject, equalTo(""+app.site_PlayIT+" – mobilszám változás kérés"));
        assertThat(actualBody, equalTo("Kedves "+app.emailsVerificationsFirstName+", A "+app.site_PlayIT+" számlájához kapcsolt mobilszám megváltozott erre: new phone Ha nem Ön kezdeményezte a változtatást, akkor klikkelje erre a linkre, hogy a számlája letiltásra kerüljön és a pénze védve legyen. Később felveheti velünk a kapcsolatot egy Önnek kényelmes időpontban, hogy biztonságosan újra-aktiváljuk a számláját. Üdvözlettel, Ügyfélszolgálati csoport"));
        assertThat(actualFooter, equalTo(""+app.SITE_REG+" Megnyugtatásul tájékoztatjuk, hogy a "+app.site_PlayIT+" Kártya számládat a DiPocket UAB kezeli, mely vállalatot a Litván Nemzeti Bank elektronikus pénzintézetenként (# 75) engedélyezett és felügyel Upės str. 23, 08128 Vilnius, LT"));
    }

    @Test(priority = 9)
    public void testChangePhoneUpAndGoEN() throws InterruptedException, MessagingException, IOException {
        postSendChangePhoneMailRealFlow(1, app.mobile_site_upAndGo, 32727);

        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualSender = senderAndSubject.get(0);
        String actualSubject = senderAndSubject.get(1);

        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualBody = getEmailBodyText(emailText, 42, 383);
        String actualFooter = getEmailFooterText(emailText, 384);

        SoftAssert softAssert = new SoftAssert();
        //softAssert.assertEquals(actualSender, expectedUpAndGoSender, "Sender is not correct");
        softAssert.assertEquals(actualSubject, ""+app.site_upAndGo+" - change of mobile phone number", "Subject is not correct");
        softAssert.assertEquals(actualBody, "Dear "+app.emailsVerificationsFirstName+", The mobile phone number associated with your up and go account was changed to: "+newPhone+". If you didn't change it, please click on this link , to block your account and protect your money. You can then contact us at your earliest convenience so that we can safely reactivate your account. With kind regards, Customer Service Team", "Body is not correct");
        softAssert.assertEquals(actualFooter, ""+app.SITE_REG+" "+app.site_upAndGo+" is powered by DiPocket UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT", "Footer is not correct");
        softAssert.assertAll();
    }

    @Test(priority = 10)
    public void testChangePhoneUpAndGoUA() throws InterruptedException, MessagingException, IOException {
        postSendChangePhoneMailRealFlow(2, app.mobile_site_upAndGo, 32727);

        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualSender = senderAndSubject.get(0);
        String actualSubject = senderAndSubject.get(1);

        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualBody = getEmailBodyText(emailText, 29, 361);
        String actualFooter = getEmailFooterText(emailText, 362);

        SoftAssert softAssert = new SoftAssert();
        //softAssert.assertEquals(actualSender, expectedUpAndGoSender, "Sender is not correct");
        softAssert.assertEquals(actualSubject, ""+app.site_upAndGo+" - зміна номеру телефона", "Subject is not correct");
        softAssert.assertEquals(actualBody, "Вітаємо, "+app.emailsVerificationsFirstName+"! Номер телефону, приєднаний до вашого облікового запису up and go, було змінено на "+newPhone+". Якщо Ви цього не робили, будь ласка, натисніть на це посилання , щоб заблокувати обліковий запис та захистити свої кошти. Після цього Ви можете зв'язатися з нами для відновлення доступу. З повагою, Відділ підтримки клієнтів", "Body is not correct");
        softAssert.assertEquals(actualFooter, ""+app.SITE_REG+" Для Вашого спокою, "+app.site_upAndGo+" працює при підтримці DiPocket UAB, що авторизований та контролюється Банком Литви, як емітент електронних грошей (#75) Upės str. 23, 08128 Vilnius, LT", "Footer is not correct");
        softAssert.assertAll();
    }

    @Test(priority = 11)
    public void testChangePhoneUpAndGoPL() throws InterruptedException, MessagingException, IOException {
        postSendChangePhoneMailRealFlow(3, app.mobile_site_upAndGo, 32727);

        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualSender = senderAndSubject.get(0);
        String actualSubject = senderAndSubject.get(1);

        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualBody = getEmailBodyText(emailText, 0, 338);
        String actualFooter = getEmailFooterText(emailText, 339);

        SoftAssert softAssert = new SoftAssert();
        //softAssert.assertEquals(actualSender, expectedUpAndGoSender, "Sender is not correct");
        softAssert.assertEquals(actualSubject, ""+app.site_upAndGo+" - zmiana numeru telefonu", "Subject is not correct");
        softAssert.assertEquals(actualBody, "Witaj, "+app.emailsVerificationsFirstName+"! Numer telefonu powiązany z Twoim kontem up and go został zmieniony na: "+newPhone+". Jeśli nie zmieniałeś numeru telefonu, kliknij w ten link aby zablokować konto i zabezpieczyć Twoje środki. Następnie skontaktuj się z nami w wybranym momencie, aby bezpiecznie odblokować Twoje konto. Z wyrazami szacunku, Dział Obsługi Klienta", "Body is not correct");
        softAssert.assertEquals(actualFooter, ""+app.SITE_REG+" "+app.site_upAndGo+" dostarcza DiPocket UAB, autoryzowana Instytucja Pieniądza Elektronicznego, podlegająca nadzorowi Banku Litwy (numer licencji 75) | Licencjonowana przez Mastercard do działania na Europejskim Obszarze Gospodarczego Upės g. 23, 08128 Vilnius, LT", "Footer is not correct");
        softAssert.assertAll();
    }

    @Test(priority = 12)
    public void testChangePhoneUpAndGoRU() throws InterruptedException, MessagingException, IOException {
        postSendChangePhoneMailRealFlow(4, app.mobile_site_upAndGo, 32727);

        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualSender = senderAndSubject.get(0);
        String actualSubject = senderAndSubject.get(1);

        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualBody = getEmailBodyText(emailText, 29, 363);
        String actualFooter = getEmailFooterText(emailText, 364);

        SoftAssert softAssert = new SoftAssert();
        //softAssert.assertEquals(actualSender, expectedUpAndGoSender, "Sender is not correct");
        softAssert.assertEquals(actualSubject, ""+app.site_upAndGo+" - изменение номера телефона", "Subject is not correct");
        softAssert.assertEquals(actualBody, "Здравствуйте, "+app.emailsVerificationsFirstName+"! Номер телефона, указанный для Вашей учетной записи был изменен. Новое значение: "+newPhone+". Если Вы этого не делали, перейдите по этой ссылке , чтобы заблокировать вашу учетную запись и защитить свои средства. После этого Вы можете связаться с нами для возобновления доступа. С уважением, Служба поддержки клиентов", "Body is not correct");
        softAssert.assertEquals(actualFooter, ""+app.SITE_REG+" Для вашего спокойствия, "+app.site_upAndGo+" осуществляет деятельность при поддержке DiPocket UAB, который авторизован и контролируется Банком Литвы как эмитент электронных денег (#75) Upės str. 23, 08128 Vilnius, LT", "Footer is not correct");
        softAssert.assertAll();
    }

    @Test(priority = 13)
    public void testChangePhoneSnowAttackEN() throws InterruptedException, MessagingException, IOException {
        postSendChangePhoneMailRealFlow(1, app.mobile_site_snowAttack, 32855);

        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualSender = senderAndSubject.get(0);
        String actualSubject = senderAndSubject.get(1);

        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualBody = getEmailBodyText(emailText, 44, 388);
        String actualFooter = getEmailFooterText(emailText, 389);

        assertThat(actualSender, equalTo(expectedSender));
        assertThat(actualSubject, equalTo(""+app.site_SnowAttack+" - change of mobile phone number"));
        assertThat(actualBody, equalTo("Dear "+app.emailsVerificationsFirstName+", The mobile phone number associated with your Snow Attack account was changed to: "+newPhone+". If you didn't change it, please  click on this link , to block your account and protect your money. You can then contact us at your earliest convenience so that we can safely reactivate your account. With kind regards, Customer Service Team"));
        assertThat(actualFooter, equalTo(""+app.SITE_REG+" "+app.site_SnowAttack+" is powered by DiPocket UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT"));
    }

    @Test(priority = 14)
    public void testChangePhoneSnowAttackHU() throws InterruptedException, MessagingException, IOException {
        postSendChangePhoneMailRealFlow(5, app.mobile_site_snowAttack, 32855);

        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualSender = senderAndSubject.get(0);
        String actualSubject = senderAndSubject.get(1);

        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualBody = getEmailBodyText(emailText, 44, 419);
        String actualFooter = getEmailFooterText(emailText, 420);

        assertThat(actualSender, equalTo(expectedSender));
        assertThat(actualSubject, equalTo(""+app.site_SnowAttack+" – mobilszám változás kérés"));
        assertThat(actualBody, equalTo("Kedves "+app.emailsVerificationsFirstName+", A "+app.site_SnowAttack+" számlájához kapcsolt mobilszám megváltozott erre: new phone Ha nem Ön kezdeményezte a változtatást, akkor klikkelje erre a linkre, hogy a számlája letiltásra kerüljön és a pénze védve legyen. Később felveheti velünk a kapcsolatot egy Önnek kényelmes időpontban, hogy biztonságosan újra-aktiváljuk a számláját. Üdvözlettel, Ügyfélszolgálati csoport"));
        assertThat(actualFooter, equalTo(""+app.SITE_REG+" "+app.site_SnowAttack+", a DiPocket UAB támogatásával, mely vállalatot a Litván Nemzeti Bank elektronikus pénzintézetenként (# 75) engedélyezett és felügyel | a Mastercard licencével rendelkezik az Európai Gazdasági Térségre vonatkozva Upės str. 23, 08128 Vilnius, LT"));
    }

    @Test(priority = 15)//bug incorrect sender
    public void testChangePhoneSodexo() throws InterruptedException, MessagingException, IOException {
        postSendChangePhoneMailRealFlow(1, app.mobile_site_sodexo, 32762);

        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualSender = senderAndSubject.get(0);
        String actualSubject = senderAndSubject.get(1);

        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualBody = getEmailBodyText(emailText, 95, 854);

        //assertThat(actualSender, equalTo(expectedSender));
        assertThat(actualSubject, equalTo(""+app.site_Sodexo+" - change of mobile phone number"));
        assertThat(actualBody, equalTo(""+app.emailsVerificationsFirstName+" Burinsky, Numer telefonu przypisany do Twojego Profilu Wirtualnej Karty Sodexo został zmieniony na: new phone Jeśli do zmiany doszło bez Twojej wiedzy, Kliknij w ten link lub kliknij w przycisk poniżej by zablokować konto i ochronić zgromadzone na nim środki. Pozdrawiamy, Zespół Wirtualnej Karty Sodexo Centrum Obsługi Klienta +48 (22) 535 11 11 | info.svc.pl@sodexo.com "+app.emailsVerificationsFirstName+" Burinsky, The mobile phone number associated with your Virtual Sodexo Card Profile was changed to: new phone If you didn't change it, please click on this link or click button below, to block your account and protect your money. With kind regards, Virtual Sodexo Card Team Customer Service Center +48 (22) 535 11 11 | info.svc.pl@sodexo.com powered by DiPocket (dipocket.org)"));
    }
}