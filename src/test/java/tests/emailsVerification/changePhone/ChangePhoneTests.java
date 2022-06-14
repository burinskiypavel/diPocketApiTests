package tests.emailsVerification.changePhone;

import appmanager.EmailVerificationHelper;
import appmanager.Language;
import base.TestBase;
import com.cs.dipocketback.base.data.Site;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static appmanager.EmailIMAPHelper.getEmailBodyText;
import static appmanager.EmailIMAPHelper.getEmailFooterText;
import static io.restassured.RestAssured.given;

public class ChangePhoneTests extends TestBase {
    String expectedSender = "customer.service@dipocket.org";
    String expectedUpAndGoSender = "wsparcie@upcard.pl";
    String expectedPlayITSender = "PlayIT Card <customer.service@dipocket.org>";
    String expectedSodexoSender = "kontakt.wirtualna@sodexo.com";
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
                "\"programNickName\": null\n" +
                "}";
    }

    public void sendChangePhoneMail(int landId, String site, int id) {
        given()
                .spec(app.requestSpecEmailVerification)
                .body(body(landId, site, id))
                .when()
                .post( "/EmailService/sendChangePhoneMail")
                .then()
                .log().all()
                .statusCode(200);
    }

    @DataProvider
    public Iterator<Object[]> ChangePhone(){
        List<Object[]> list = new ArrayList<Object[]>();
        list.add(new Object[] {Site.DIPOCKET.toString(), Language.EN.toString(), Language.EN.getOurId(), 32761, app.emailsVerificationsEmail, app.emailsVerificationsPass, 41, 381, 382, expectedSender, ""+app.site+" - change of mobile phone number", "Dear "+app.emailsVerificationsFirstName+", The mobile phone number associated with your "+app.site+" account was changed to: "+newPhone+". If you didn't change it, please click on this link , to block your account and protect your money. You can then contact us at your earliest convenience so that we can safely reactivate your account. With kind regards, Customer Service Team", ""+app.SITE_REG+" "+app.site+" UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT"});
        list.add(new Object[] {Site.DIPOCKET.toString(), Language.UK.toString(), Language.UK.getOurId(), 32761, app.emailsVerificationsEmail, app.emailsVerificationsPass, 28, 359, 360, expectedSender, ""+app.site+" - зміна номеру телефона", "Вітаємо, "+app.emailsVerificationsFirstName+"! Номер телефону, приєднаний до вашого облікового запису "+app.site+", було змінено на "+newPhone+". Якщо Ви цього не робили, будь ласка, натисніть на це посилання , щоб заблокувати обліковий запис та захистити свої кошти. Після цього Ви можете зв'язатися з нами для відновлення доступу. З повагою, Відділ підтримки клієнтів", ""+app.SITE_REG+" Для Вашого спокою, "+app.site+" UAB авторизований та контролюється Банком Литви, як емітент електронних грошей (#75) Upės str. 23, 08128 Vilnius, LT"});
        list.add(new Object[] {Site.DIPOCKET.toString(), Language.PL.toString(), Language.PL.getOurId(), 32761, app.emailsVerificationsEmail,  app.emailsVerificationsPass, 0, 337, 338, expectedSender, ""+app.site+" - zmiana numeru telefonu", "Witaj, "+app.emailsVerificationsFirstName+"! Numer telefonu powiązany z Twoim kontem "+app.site+" został zmieniony na: "+newPhone+". Jeśli nie zmieniałeś numeru telefonu, kliknij w ten link aby zablokować konto i zabezpieczyć Twoje środki. Następnie skontaktuj się z nami w wybranym momencie, aby bezpiecznie odblokować Twoje konto. Z wyrazami szacunku, Dział Obsługi Klienta", ""+app.SITE_REG+" "+app.site+" UAB, autoryzowana Instytucja Pieniądza Elektronicznego, podlegająca nadzorowi Banku Litwy (numer licencji 75) | Licencjonowana przez Mastercard do działania na Europejskim Obszarze Gospodarczego Upės g. 23, 08128 Vilnius, LT"});
        list.add(new Object[] {Site.DIPOCKET.toString(), Language.RU.toString(), Language.RU.getOurId(), 32761, app.emailsVerificationsEmail, app.emailsVerificationsPass, 28, 362, 363, expectedSender, ""+app.site+" - изменение номера телефона", "Здравствуйте, "+app.emailsVerificationsFirstName+"! Номер телефона, указанный для Вашей учетной записи был изменен. Новое значение: "+newPhone+". Если Вы этого не делали, перейдите по этой ссылке , чтобы заблокировать вашу учетную запись и защитить свои средства. После этого Вы можете связаться с нами для возобновления доступа. С уважением, Служба поддержки клиентов", ""+app.SITE_REG+" Для вашего спокойствия, "+app.site+" UAB авторизован и контролируется Банком Литвы как эмитент электронных денег (#75) Upės str. 23, 08128 Vilnius, LT"});
        //list.add(new Object[] {Site.DISCONTU.toString(), Language.EN.toString(), Language.EN.getOurId(), 32717, app.emailsVerificationsEmail, app.emailsVerificationsPass, 41, 381, 382, expectedSender, ""+app.site_discontu+" - change of mobile phone number", "Dear "+app.emailsVerificationsFirstName+", The mobile phone number associated with your discontu account was changed to: "+newPhone+". If you didn't change it, please click on this link , to block your account and protect your money. You can then contact us at your earliest convenience so that we can safely reactivate your account. With kind regards, Customer Service Team", ""+app.SITE_REG+" "+app.site_discontu+" is powered by DiPocket UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT"});
        //list.add(new Object[] {Site.DISCONTU.toString(), Language.PL.toString(), Language.PL.getOurId(), 32717, app.emailsVerificationsEmail, app.emailsVerificationsPass, 0, 337, 338, expectedSender, ""+app.site_discontu+" - zmiana numeru telefonu", "Witaj, "+app.emailsVerificationsFirstName+"! Numer telefonu powiązany z Twoim kontem discontu został zmieniony na: "+newPhone+". Jeśli nie zmieniałeś numeru telefonu, kliknij w ten link aby zablokować konto i zabezpieczyć Twoje środki. Następnie skontaktuj się z nami w wybranym momencie, aby bezpiecznie odblokować Twoje konto. Z wyrazami szacunku, Dział Obsługi Klienta", ""+app.SITE_REG+" "+app.site_discontu+" dostarcza DiPocket UAB, autoryzowana Instytucja Pieniądza Elektronicznego, podlegająca nadzorowi Banku Litwy (numer licencji 75) | Licencjonowana przez Mastercard do działania na Europejskim Obszarze Gospodarczego Upės g. 23, 08128 Vilnius, LT"});
        list.add(new Object[] {Site.PLAYIT.toString(), Language.EN.toString(), Language.EN.getOurId(), 32732, app.emailsVerificationsEmail, app.emailsVerificationsPass, 39, 378, 379, expectedPlayITSender, ""+app.site_PlayIT+" - change of mobile phone number", "Dear "+app.emailsVerificationsFirstName+", The mobile phone number associated with your PlayIT account was changed to: "+newPhone+". If you didn't change it, please  click on this link , to block your account and protect your money. You can then contact us at your earliest convenience so that we can safely reactivate your account. With kind regards, Customer Service Team", ""+app.SITE_REG+" "+app.site_PlayIT+" is powered by DiPocket UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT"});
        list.add(new Object[] {Site.PLAYIT.toString(), Language.HU.toString(), Language.HU.getOurId(), 32732, app.emailsVerificationsEmail, app.emailsVerificationsPass, 39, 409, 410, expectedPlayITSender, ""+app.site_PlayIT+" – mobilszám változás kérés", "Kedves "+app.emailsVerificationsFirstName+", A "+app.site_PlayIT+" számlájához kapcsolt mobilszám megváltozott erre: new phone Ha nem Ön kezdeményezte a változtatást, akkor klikkelje erre a linkre, hogy a számlája letiltásra kerüljön és a pénze védve legyen. Később felveheti velünk a kapcsolatot egy Önnek kényelmes időpontban, hogy biztonságosan újra-aktiváljuk a számláját. Üdvözlettel, Ügyfélszolgálati csoport", ""+app.SITE_REG+" Megnyugtatásul tájékoztatjuk, hogy a "+app.site_PlayIT+" Kártya számládat a DiPocket UAB kezeli, mely vállalatot a Litván Nemzeti Bank elektronikus pénzintézetenként (# 75) engedélyezett és felügyel Upės str. 23, 08128 Vilnius, LT"});
        list.add(new Object[] {Site.SNOW_ATTACK.toString(), Language.EN.toString(), Language.EN.getOurId(), 32855, app.emailsVerificationsEmail, app.emailsVerificationsPass, 44, 388, 389, expectedSender, ""+app.site_SnowAttack+" - change of mobile phone number", "Dear "+app.emailsVerificationsFirstName+", The mobile phone number associated with your Snow Attack account was changed to: "+newPhone+". If you didn't change it, please  click on this link , to block your account and protect your money. You can then contact us at your earliest convenience so that we can safely reactivate your account. With kind regards, Customer Service Team", ""+app.SITE_REG+" "+app.site_SnowAttack+" is powered by DiPocket UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT"});
        list.add(new Object[] {Site.SNOW_ATTACK.toString(), Language.HU.toString(), Language.HU.getOurId(), 32855, app.emailsVerificationsEmail, app.emailsVerificationsPass, 44, 419, 420, expectedSender, ""+app.site_SnowAttack+" – mobilszám változás kérés", "Kedves "+app.emailsVerificationsFirstName+", A "+app.site_SnowAttack+" számlájához kapcsolt mobilszám megváltozott erre: new phone Ha nem Ön kezdeményezte a változtatást, akkor klikkelje erre a linkre, hogy a számlája letiltásra kerüljön és a pénze védve legyen. Később felveheti velünk a kapcsolatot egy Önnek kényelmes időpontban, hogy biztonságosan újra-aktiváljuk a számláját. Üdvözlettel, Ügyfélszolgálati csoport", ""+app.SITE_REG+" "+app.site_SnowAttack+", a DiPocket UAB támogatásával, mely vállalatot a Litván Nemzeti Bank elektronikus pénzintézetenként (# 75) engedélyezett és felügyel | a Mastercard licencével rendelkezik az Európai Gazdasági Térségre vonatkozva Upės str. 23, 08128 Vilnius, LT"});
        list.add(new Object[] {Site.UPANDGO.toString(), Language.EN.toString(), Language.EN.getOurId(), 32727, app.emailsVerificationsEmail, app.emailsVerificationsPass, 42, 383, 384, expectedUpAndGoSender, ""+app.site_upAndGo+" - change of mobile phone number", "Dear "+app.emailsVerificationsFirstName+", The mobile phone number associated with your up and go account was changed to: "+newPhone+". If you didn't change it, please click on this link , to block your account and protect your money. You can then contact us at your earliest convenience so that we can safely reactivate your account. With kind regards, Customer Service Team", ""+app.SITE_REG+" "+app.site_upAndGo+" is powered by DiPocket UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT"});
        list.add(new Object[] {Site.UPANDGO.toString(), Language.UK.toString(), Language.UK.getOurId(), 32727, app.emailsVerificationsEmail, app.emailsVerificationsPass, 29, 361, 362, expectedUpAndGoSender, ""+app.site_upAndGo+" - зміна номеру телефона", "Вітаємо, "+app.emailsVerificationsFirstName+"! Номер телефону, приєднаний до вашого облікового запису up and go, було змінено на "+newPhone+". Якщо Ви цього не робили, будь ласка, натисніть на це посилання , щоб заблокувати обліковий запис та захистити свої кошти. Після цього Ви можете зв'язатися з нами для відновлення доступу. З повагою, Відділ підтримки клієнтів", ""+app.SITE_REG+" Для Вашого спокою, "+app.site_upAndGo+" працює при підтримці DiPocket UAB, що авторизований та контролюється Банком Литви, як емітент електронних грошей (#75) Upės str. 23, 08128 Vilnius, LT"});
        list.add(new Object[] {Site.UPANDGO.toString(), Language.PL.toString(), Language.PL.getOurId(), 32727, app.emailsVerificationsEmail, app.emailsVerificationsPass, 0, 338, 339, expectedUpAndGoSender, ""+app.site_upAndGo+" - zmiana numeru telefonu", "Witaj, "+app.emailsVerificationsFirstName+"! Numer telefonu powiązany z Twoim kontem up and go został zmieniony na: "+newPhone+". Jeśli nie zmieniałeś numeru telefonu, kliknij w ten link aby zablokować konto i zabezpieczyć Twoje środki. Następnie skontaktuj się z nami w wybranym momencie, aby bezpiecznie odblokować Twoje konto. Z wyrazami szacunku, Dział Obsługi Klienta", ""+app.SITE_REG+" "+app.site_upAndGo+" dostarcza DiPocket UAB, autoryzowana Instytucja Pieniądza Elektronicznego, podlegająca nadzorowi Banku Litwy (numer licencji 75) | Licencjonowana przez Mastercard do działania na Europejskim Obszarze Gospodarczego Upės g. 23, 08128 Vilnius, LT"});
        list.add(new Object[] {Site.UPANDGO.toString(), Language.RU.toString(), Language.RU.getOurId(), 32727, app.emailsVerificationsEmail, app.emailsVerificationsPass, 29, 363, 364, expectedUpAndGoSender, ""+app.site_upAndGo+" - изменение номера телефона", "Здравствуйте, "+app.emailsVerificationsFirstName+"! Номер телефона, указанный для Вашей учетной записи был изменен. Новое значение: "+newPhone+". Если Вы этого не делали, перейдите по этой ссылке , чтобы заблокировать вашу учетную запись и защитить свои средства. После этого Вы можете связаться с нами для возобновления доступа. С уважением, Служба поддержки клиентов", ""+app.SITE_REG+" Для вашего спокойствия, "+app.site_upAndGo+" осуществляет деятельность при поддержке DiPocket UAB, который авторизован и контролируется Банком Литвы как эмитент электронных денег (#75) Upės str. 23, 08128 Vilnius, LT"});
        list.add(new Object[] {Site.SODEXO.toString(), "ENPL", 1, 32762, app.emailsVerificationsEmail, app.emailsVerificationsPass, 95, 751, 752, expectedSodexoSender, ""+app.site_Sodexo+" - change of mobile phone number", ""+app.emailsVerificationsFirstName+" Burinsky, Numer telefonu przypisany do Twojego Profilu Wirtualnej Karty Sodexo został zmieniony na: new phone Jeśli do zmiany doszło bez Twojej wiedzy, Kliknij w ten link lub kliknij w przycisk poniżej by zablokować konto i ochronić zgromadzone na nim środki. Pozdrawiamy, Zespół Wirtualnej Karty Sodexo Centrum Obsługi Klienta +48 (22) 535 11 11 | info.svc.pl@sodexo.com "+app.emailsVerificationsFirstName+" Burinsky, The mobile phone number associated with your Virtual Sodexo Card Profile was changed to: new phone If you didn't change it, please click on this link or click button below, to block your account and protect your money. With kind regards, Virtual Sodexo Card Team", "Customer Service Center +48 (22) 535 11 11 | info.svc.pl@sodexo.com powered by DiPocket (dipocket.org)"});
        return list.iterator();
    }

    @Test(dataProvider = "ChangePhone")
    public void testChangePhone(String site, String lang, int langId, int id, String email, String pass, int bodyBegin, int bodyEnd, int footerEnd, String expectedEmailSender, String expectedEmailSubject, String expectedEmailBody, String expectedEmailFooter) throws InterruptedException, MessagingException, IOException {
        sendChangePhoneMail(langId, site, id);

        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(email, pass);
        String actualSender = senderAndSubject.get(0);
        String actualSubject = senderAndSubject.get(1);

        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", email, pass);
        String actualBody = getEmailBodyText(emailText, bodyBegin, bodyEnd);
        String actualFooter = getEmailFooterText(emailText, footerEnd);

        SoftAssert softAssert = new SoftAssert();
        if(!site.equals("UPANDGO") && !site.equals("SODEXO")){
            softAssert.assertEquals(actualSender, expectedEmailSender, "Sender is not correct");
        }
        softAssert.assertEquals(actualSubject, expectedEmailSubject, "Subject is not correct");
        softAssert.assertEquals(actualBody, expectedEmailBody, "Body is not correct");
        softAssert.assertEquals(actualFooter, expectedEmailFooter, "Footer is not correct");
        softAssert.assertAll();
    }
}