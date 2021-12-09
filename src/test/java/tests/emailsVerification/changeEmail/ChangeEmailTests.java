package tests.emailsVerification.changeEmail;

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
                "\"programNickName\": null\n" +
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

    @DataProvider
    public Iterator<Object[]> ChangeEmail(){
        List<Object[]> list = new ArrayList<Object[]>();
        list.add(new Object[] {Site.DIPOCKET.toString(), Language.EN.toString(), Language.EN.getOurId(), 32761, app.emailsVerificationsEmail, app.emailsVerificationsPass, 46, 265, 266, expectedSender, ""+app.site+" - email address verification request", "Dear "+app.emailsVerificationsFirstName+", We received your request to verify the email address associated with your "+app.site+" account. Please click on this link to confirm your request and finalise the change. With kind regards, Customer Service Team", ""+app.SITE_REG+" "+app.site+" UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT"});
        list.add(new Object[] {Site.DIPOCKET.toString(), Language.UK.toString(), Language.UK.getOurId(), 32761, app.emailsVerificationsEmail, app.emailsVerificationsPass, 28, 274, 275, expectedSender, ""+app.site+" - запит на верифікацію електронної адреси", "Вітаємо, "+app.emailsVerificationsFirstName+"! Ми отримали запит на верифікацію Вашої електронної адреси приєднану до вашого облікового запису "+app.site+". Будь ласка, перейдіть за цим посиланням , щоб підтвердити Ваш запит та завершити зміни. З повагою, Відділ підтримки клієнтів", ""+app.SITE_REG+" Для Вашого спокою, "+app.site+" UAB авторизований та контролюється Банком Литви, як емітент електронних грошей (#75) Upės str. 23, 08128 Vilnius, LT"});
        list.add(new Object[] {Site.DIPOCKET.toString(), Language.PL.toString(), Language.PL.getOurId(), 32761, app.emailsVerificationsEmail,  app.emailsVerificationsPass, 0, 210, 211, expectedSender, ""+app.site+" - prośba o weryfikację adresu email", "Witaj, "+app.emailsVerificationsFirstName+"! Otrzymaliśmy prośbę o weryfikację adresu email powiązanego z Twoim kontem "+app.site+". Kliknij w ten link , aby potwierdzić tę prośbę i sfinalizować zmianę. Z wyrazami szacunku, Dział Obsługi Klienta", ""+app.SITE_REG+" "+app.site+" UAB, autoryzowana Instytucja Pieniądza Elektronicznego, podlegająca nadzorowi Banku Litwy (numer licencji 75) | Licencjonowana przez Mastercard do działania na Europejskim Obszarze Gospodarczego Upės g. 23, 08128 Vilnius, LT"});
        list.add(new Object[] {Site.DIPOCKET.toString(), Language.RU.toString(), Language.RU.getOurId(), 32761, app.emailsVerificationsEmail, app.emailsVerificationsPass, 28, 255, 256, expectedSender, ""+app.site+" - запрос на верификацию адреса электронной почты", "Здравствуйте, "+app.emailsVerificationsFirstName+"! Мы получили запрос на верификацию адреса электронной почты, которая указана в Вашей учетной записи. Пожалуйста, перейдите по этой ссылке , чтобы подтвердить изменение. С уважением, Служба поддержки клиентов", ""+app.SITE_REG+" Для вашего спокойствия, "+app.site+" UAB авторизован и контролируется Банком Литвы как эмитент электронных денег (#75) Upės str. 23, 08128 Vilnius, LT"});
        list.add(new Object[] {Site.DISCONTU.toString(), Language.EN.toString(), Language.EN.getOurId(), 32717, app.emailsVerificationsEmail, app.emailsVerificationsPass, 46, 265, 266, expectedSender, ""+app.site_discontu+" - email address verification request", "Dear "+app.emailsVerificationsFirstName+", We received your request to verify the email address associated with your "+app.site_discontu+" account. Please click on this link to confirm your request and finalise the change. With kind regards, Customer Service Team", ""+app.SITE_REG+" "+app.site_discontu+" is powered by DiPocket UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT"});
        list.add(new Object[] {Site.DISCONTU.toString(), Language.PL.toString(), Language.PL.getOurId(), 32717, app.emailsVerificationsEmail, app.emailsVerificationsPass, 0, 210, 211, expectedSender, ""+app.site_discontu+" - prośba o weryfikację adresu email", "Witaj, "+app.emailsVerificationsFirstName+"! Otrzymaliśmy prośbę o weryfikację adresu email powiązanego z Twoim kontem "+app.site_discontu+". Kliknij w ten link , aby potwierdzić tę prośbę i sfinalizować zmianę. Z wyrazami szacunku, Dział Obsługi Klienta", ""+app.SITE_REG+" "+app.site_discontu+" dostarcza DiPocket UAB, autoryzowana Instytucja Pieniądza Elektronicznego, podlegająca nadzorowi Banku Litwy (numer licencji 75) | Licencjonowana przez Mastercard do działania na Europejskim Obszarze Gospodarczego Upės g. 23, 08128 Vilnius, LT"});
        list.add(new Object[] {Site.PLAYIT.toString(), Language.EN.toString(), Language.EN.getOurId(), 32732, app.emailsVerificationsEmail, app.emailsVerificationsPass, 44, 261, 262, expectedPlayITSender, ""+app.site_PlayIT+" - email address verification request", "Dear "+app.emailsVerificationsFirstName+", We received your request to verify the email address associated with your "+app.site_PlayIT+" account. Please click on this link to confirm your request and finalise the change. With kind regards, Customer Service Team", ""+app.SITE_REG+" "+app.site_PlayIT+" is powered by DiPocket UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT"});
        list.add(new Object[] {Site.PLAYIT.toString(), Language.HU.toString(), Language.HU.getOurId(), 32732, app.emailsVerificationsEmail, app.emailsVerificationsPass, 44, 262, 263, expectedPlayITSender, ""+app.site_PlayIT+" – email cím megerősítés kérés", "Kedves "+app.emailsVerificationsFirstName+", Megkaptuk az email cím megerősítés kérését a "+app.site_PlayIT+" számlájával kapcsolatban. Kérjük az alábbi linkre klikkelve erősítse meg a kérését és véglegesítse a változtatást. Üdvözlettel, Ügyfélszolgálati csoport", ""+app.SITE_REG+" Megnyugtatásul tájékoztatjuk, hogy a PlayIT Kártya számládat a DiPocket UAB kezeli, mely vállalatot a Litván Nemzeti Bank elektronikus pénzintézetenként (# 75) engedélyezett és felügyel Upės str. 23, 08128 Vilnius, LT"});
        list.add(new Object[] {Site.SNOW_ATTACK.toString(), Language.EN.toString(), Language.EN.getOurId(), 32855, app.emailsVerificationsEmail, app.emailsVerificationsPass, 49, 271, 272, expectedSender, ""+app.site_SnowAttack+" - email address verification request", "Dear "+app.emailsVerificationsFirstName+", We received your request to verify the email address associated with your "+app.site_SnowAttack+" account. Please click on this link to confirm your request and finalise the change. With kind regards, Customer Service Team", ""+app.SITE_REG+" "+app.site_SnowAttack+" is powered by DiPocket UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT"});
        list.add(new Object[] {Site.SNOW_ATTACK.toString(), Language.HU.toString(), Language.HU.getOurId(), 32855, app.emailsVerificationsEmail, app.emailsVerificationsPass, 49, 272, 273, expectedSender, ""+app.site_SnowAttack+" – email cím megerősítés kérés", "Kedves "+app.emailsVerificationsFirstName+", Megkaptuk az email cím megerősítés kérését a "+app.site_SnowAttack+" számlájával kapcsolatban. Kérjük az alábbi linkre klikkelve erősítse meg a kérését és véglegesítse a változtatást. Üdvözlettel, Ügyfélszolgálati csoport", ""+app.SITE_REG+" "+app.site_SnowAttack+", a DiPocket UAB támogatásával, mely vállalatot a Litván Nemzeti Bank elektronikus pénzintézetenként (# 75) engedélyezett és felügyel | a Mastercard licencével rendelkezik az Európai Gazdasági Térségre vonatkozva Upės str. 23, 08128 Vilnius, LT"});
        list.add(new Object[] {Site.UPANDGO.toString(), Language.EN.toString(), Language.EN.getOurId(), 32727, app.emailsVerificationsEmail, app.emailsVerificationsPass, 47, 267, 268, expectedUpAndGoSender, ""+app.site_upAndGo+" - email address verification request", "Dear "+app.emailsVerificationsFirstName+", We received your request to verify the email address associated with your "+app.site_upAndGo+" account. Please click on this link to confirm your request and finalise the change. With kind regards, Customer Service Team", ""+app.SITE_REG+" "+app.site_upAndGo+" is powered by DiPocket UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT"});
        list.add(new Object[] {Site.UPANDGO.toString(), Language.UK.toString(), Language.UK.getOurId(), 32727, app.emailsVerificationsEmail, app.emailsVerificationsPass, 29, 276, 277, expectedUpAndGoSender, ""+app.site_upAndGo+" - запит на верифікацію електронної адреси", "Вітаємо, "+app.emailsVerificationsFirstName+"! Ми отримали запит на верифікацію Вашої електронної адреси приєднану до вашого облікового запису "+app.site_upAndGo+". Будь ласка, перейдіть за цим посиланням , щоб підтвердити Ваш запит та завершити зміни. З повагою, Відділ підтримки клієнтів", ""+app.SITE_REG+" Для Вашого спокою, "+app.site_upAndGo+" працює при підтримці DiPocket UAB, що авторизований та контролюється Банком Литви, як емітент електронних грошей (#75) Upės str. 23, 08128 Vilnius, LT"});
        list.add(new Object[] {Site.UPANDGO.toString(), Language.PL.toString(), Language.PL.getOurId(), 32727, app.emailsVerificationsEmail, app.emailsVerificationsPass, 0, 211, 212, expectedUpAndGoSender, ""+app.site_upAndGo+" - prośba o weryfikację adresu email", "Witaj, "+app.emailsVerificationsFirstName+"! Otrzymaliśmy prośbę o weryfikację adresu email powiązanego z Twoim kontem "+app.site_upAndGo+". Kliknij w ten link , aby potwierdzić tę prośbę i sfinalizować zmianę. Z wyrazami szacunku, Dział Obsługi Klienta", ""+app.SITE_REG+" "+app.site_upAndGo+" dostarcza DiPocket UAB, autoryzowana Instytucja Pieniądza Elektronicznego, podlegająca nadzorowi Banku Litwy (numer licencji 75) | Licencjonowana przez Mastercard do działania na Europejskim Obszarze Gospodarczego Upės g. 23, 08128 Vilnius, LT"});
        list.add(new Object[] {Site.UPANDGO.toString(), Language.RU.toString(), Language.RU.getOurId(), 32727, app.emailsVerificationsEmail, app.emailsVerificationsPass, 29, 256, 257, expectedUpAndGoSender, ""+app.site_upAndGo+" - запрос на верификацию адреса электронной почты", "Здравствуйте, "+app.emailsVerificationsFirstName+"! Мы получили запрос на верификацию адреса электронной почты, которая указана в Вашей учетной записи. Пожалуйста, перейдите по этой ссылке , чтобы подтвердить изменение. С уважением, Служба поддержки клиентов", ""+app.SITE_REG+" Для вашего спокойствия, "+app.site_upAndGo+" осуществляет деятельность при поддержке DiPocket UAB, который авторизован и контролируется Банком Литвы как эмитент электронных денег (#75) Upės str. 23, 08128 Vilnius, LT"});
        list.add(new Object[] {Site.SODEXO.toString(), "ENPL", 1, 32762, app.emailsVerificationsEmail, app.emailsVerificationsPass, 94, 621, 622, expectedSodexoSender, ""+app.site_Sodexo+" - email address verification request", ""+app.emailsVerificationsFirstName+" Burinsky, Potwierdź adres mailowy powiązany z Twoim Profilem Wirtualnej Karty Sodexo. Kliknij w ten link, aby potwierdzić i zakończyć proces. Pozdrawiamy, Zespół Wirtualnej Karty Sodexo Centrum Obsługi Klienta +48 (22) 535 11 11 | info.svc.pl@sodexo.com Your Virtual Sodexo Card profile - email address verification request "+app.emailsVerificationsFirstName+" Burinsky, Verify the email address associated with your Virtual Sodexo Card Profile. Please click on this link to confirm and finalize the process. With kind regards, Virtual Sodexo Card Team", "Customer Service Center +48 (22) 535 11 11 | info.svc.pl@sodexo.com powered by DiPocket (dipocket.org)"});
        //list.add(new Object[] {Site.TELENOR.toString(), Language.EN.toString(), Language.EN.getOurId(), 32726, app.emailsVerificationsEmail, app.emailsVerificationsPass, 0, 218, 219, expectedTelenorSender, ""+app.site_Telenor+" - email address verification request", "Dear "+app.emailsVerificationsFirstName+", We received your request to verify the email address associated with your "+app.site_Telenor+" account. Please click on this link to confirm your request and finalise the change. With kind regards, Customer Service Team", ""+app.SITE_REG+" "+app.site_Telenor+" is powered by DiPocket UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT"});
        //list.add(new Object[] {Site.TELENOR.toString(), Language.HU.toString(), Language.HU.getOurId(), 32726, app.emailsVerificationsEmail, app.emailsVerificationsPass, 0, 233, 234, expectedTelenorSender, "", "Kedves "+app.emailsVerificationsFirstName+", Megkaptuk a "+app.site_Telenor+" fiókjához tartozó e-mail cím megerősítésére vonatkozó kérését. Kérjük, kattintson erre a hivatkozásra a kérése megerősítéséhez és a módosítás véglegesítéséhez. Üdvözlettel, az Ügyfélszolgálati csapat", ""+app.SITE_REG+" "+app.site_Telenor+", a DiPocket UAB támogatásával, mely vállalatot a Litván Nemzeti Bank elektronikus pénzintézetenként (# 75) engedélyezett és felügyel | a Mastercard licencével rendelkezik az Európai Gazdasági Térségre vonatkozva Upės str. 23, 08128 Vilnius, LT"});
        return list.iterator();
    }

    @Test(dataProvider = "ChangeEmail")
    public void testChangeEmail(String site, String lang, int langId, int id, String email, String pass, int bodyBegin, int bodyEnd, int footerEnd, String expectedEmailSender, String expectedEmailSubject, String expectedEmailBody, String expectedEmailFooter) throws InterruptedException, MessagingException, IOException {
        postSendChangeEmail(langId, site, id);

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

        if(!site.equals("UPANDGO")){
            softAssert.assertEquals(actualFooter, expectedEmailFooter, "Footer is not correct");
        }

        softAssert.assertAll();
    }
}
