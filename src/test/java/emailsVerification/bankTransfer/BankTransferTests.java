package emailsVerification.bankTransfer;

import appmanager.EmailVerificationHelper;
import base.TestBase;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static appmanager.EmailIMAPHelper.getEmailBodyText;
import static appmanager.EmailIMAPHelper.getEmailFooterText;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class BankTransferTests extends TestBase {
    String expectedSender = "customer.service@dipocket.org";
    String expectedPlayITSender = "PlayIT Card <customer.service@dipocket.org>";
    String expectedUpAndGoSender = "wsparcie@upcard.pl";

    public String body(int landId, String site, int id){
        return "{\n" +
                "\"id\": " + id + ",\n" +
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

    public void postSendBankTransferEmail(int langId, String site, int id) {
        given()
                .contentType("application/json")
                .body(body(langId,site, id))
                .when()
                .post( app.dipocket3_intranet+"/EmailService/sendBankTransferEmail")
                .then().log().all()
                .statusCode(200);
    }

    @DataProvider
    public Iterator<Object[]> BankTransfer(){
        List<Object[]> list = new ArrayList<Object[]>();
        list.add(new Object[] {app.mobile_site, "EN", 1, 32726, app.emailsVerificationsEmail, app.emailsVerificationsPass, 38, 158, 159, expectedSender, "Dear "+app.emailsVerificationsFirstName+", As requested, please find attached your bank transfer confirmation. With kind regards, Customer Service Team", ""+app.SITE_REG+" "+app.site+" UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT"});
        list.add(new Object[] {app.mobile_site, "UA", 2, 32726, app.emailsVerificationsEmail, app.emailsVerificationsPass, 28, 154, 155, expectedSender, "Вітаємо, "+app.emailsVerificationsFirstName+"! В додатку знаходиться замовлене Вами підтвердження банківського переказу. З повагою, Відділ підтримки клієнтів", ""+app.SITE_REG+" Для Вашого спокою, "+app.site+" UAB авторизований та контролюється Банком Литви, як емітент електронних грошей (#75) Upės str. 23, 08128 Vilnius, LT"});
        list.add(new Object[] {app.mobile_site, "PL", 3, 32726, app.emailsVerificationsEmail,  app.emailsVerificationsPass, 0, 126, 127, expectedSender, "Witaj "+app.emailsVerificationsFirstName+", W załączniku znajduje się zamówione potwierdzenie przelewu bankowego. Z wyrazami szacunku, Zespół Obsługi Klienta", ""+app.SITE_REG+" "+app.site+" UAB, autoryzowana Instytucja Pieniądza Elektronicznego, podlegająca nadzorowi Banku Litwy (numer licencji 75) | Licencjonowana przez Mastercard do działania na Europejskim Obszarze Gospodarczego Upės g. 23, 08128 Vilnius, LT"});
        list.add(new Object[] {app.mobile_site, "PL", 4, 32726, app.emailsVerificationsEmail, app.emailsVerificationsPass, 28, 169, 170, expectedSender, "Здравствуйте, "+app.emailsVerificationsFirstName+"! В приложении находится подтверждение банковского перевода, которое Вы заказывали. С уважением, Служба поддержки клиентов", ""+app.SITE_REG+" Для вашего спокойствия, "+app.site+" UAB авторизован и контролируется Банком Литвы как эмитент электронных денег (#75) Upės str. 23, 08128 Vilnius, LT"});
        list.add(new Object[] {app.mobile_site_discontu, "EN", 1, 32717, app.emailsVerificationsEmail, app.emailsVerificationsPass, 38, 158, 159, expectedSender, "Dear "+app.emailsVerificationsFirstName+", As requested, please find attached your bank transfer confirmation. With kind regards, Customer Service Team", ""+app.SITE_REG+" "+app.site_discontu+" is powered by DiPocket UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT"});
        list.add(new Object[] {app.mobile_site_discontu, "PL", 2, 32717, app.emailsVerificationsEmail, app.emailsVerificationsPass, 0, 126, 127, expectedSender, "Witaj "+app.emailsVerificationsFirstName+", W załączniku znajduje się zamówione potwierdzenie przelewu bankowego. Z wyrazami szacunku, Zespół Obsługi Klienta", ""+app.SITE_REG+" "+app.site_discontu+" dostarcza DiPocket UAB, autoryzowana Instytucja Pieniądza Elektronicznego, podlegająca nadzorowi Banku Litwy (numer licencji 75) | Licencjonowana przez Mastercard do działania na Europejskim Obszarze Gospodarczego Upės g. 23, 08128 Vilnius, LT"});
        list.add(new Object[] {app.mobile_site_playIt, "EN", 1, 32732, app.emailsVerificationsEmail, app.emailsVerificationsPass, 36, 156, 157, expectedPlayITSender, "Dear "+app.emailsVerificationsFirstName+", As requested, please find attached your bank transfer confirmation. With kind regards, Customer Service Team", ""+app.SITE_REG+" "+app.site_PlayIT+" is powered by DiPocket UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT"});
        //list.add(new Object[] {app.mobile_site_playIt, "HU", 5, 32732, app.emailsVerificationsEmail, app.emailsVerificationsPass, 36, 156, 157, expectedPlayITSender, "Dear "+app.emailsVerificationsFirstName+", As requested, please find attached your bank transfer confirmation. With kind regards, Customer Service Team", ""+app.SITE_REG+" "+app.site_PlayIT+" is powered by DiPocket UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT"});//bug incorrect HU footer and body
        list.add(new Object[] {app.mobile_site_snowAttack, "EN", 1, 32855, app.emailsVerificationsEmail, app.emailsVerificationsPass, 41, 161, 162, expectedSender, "Dear "+app.emailsVerificationsFirstName+", As requested, please find attached your bank transfer confirmation. With kind regards, Customer Service Team", ""+app.SITE_REG+" "+app.site_SnowAttack+" is powered by DiPocket UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT"});
        //list.add(new Object[] {app.mobile_site_snowAttack, "HU", 5, 32855, app.emailsVerificationsEmail, app.emailsVerificationsPass, 41, 169, 170, expectedSender, "Kedves "+app.emailsVerificationsFirstName+", Kívánsága szerint, csatolva találja az Ön banki átutalásának megerősítése. Üdvözlettel, az Ügyfélszolgálati csapat", ""+app.SITE_REG+" "+app.site_SnowAttack+" is powered by DiPocket UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT"});//bug incorrect HU footer and body
        list.add(new Object[] {app.mobile_site_upAndGo, "EN", 1, 32727, app.emailsVerificationsEmail, app.emailsVerificationsPass, 39, 159, 160, expectedUpAndGoSender, "Dear "+app.emailsVerificationsFirstName+", As requested, please find attached your bank transfer confirmation. With kind regards, Customer Service Team", ""+app.SITE_REG+" "+app.mobile_site_upAndGo+" is powered by DiPocket UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT"});
        list.add(new Object[] {app.mobile_site_upAndGo, "UA", 2, 32727, app.emailsVerificationsEmail, app.emailsVerificationsPass, 29, 155, 156, expectedUpAndGoSender, "Вітаємо, "+app.emailsVerificationsFirstName+"! В додатку знаходиться замовлене Вами підтвердження банківського переказу. З повагою, Відділ підтримки клієнтів", ""+app.SITE_REG+" Для Вашого спокою, "+app.mobile_site_upAndGo+" працює при підтримці DiPocket UAB, що авторизований та контролюється Банком Литви, як емітент електронних грошей (#75) Upės str. 23, 08128 Vilnius, LT"});
        list.add(new Object[] {app.mobile_site_upAndGo, "PL", 3, 32727, app.emailsVerificationsEmail, app.emailsVerificationsPass, 0, 126, 127, expectedUpAndGoSender, "Witaj "+app.emailsVerificationsFirstName+", W załączniku znajduje się zamówione potwierdzenie przelewu bankowego. Z wyrazami szacunku, Zespół Obsługi Klienta", ""+app.SITE_REG+" "+app.mobile_site_upAndGo+" dostarcza DiPocket UAB, autoryzowana Instytucja Pieniądza Elektronicznego, podlegająca nadzorowi Banku Litwy (numer licencji 75) | Licencjonowana przez Mastercard do działania na Europejskim Obszarze Gospodarczego Upės g. 23, 08128 Vilnius, LT"});
        list.add(new Object[] {app.mobile_site_upAndGo, "RU", 4, 32727, app.emailsVerificationsEmail, app.emailsVerificationsPass, 29, 170, 171, expectedUpAndGoSender, "Здравствуйте, "+app.emailsVerificationsFirstName+"! В приложении находится подтверждение банковского перевода, которое Вы заказывали. С уважением, Служба поддержки клиентов", ""+app.SITE_REG+" Для вашего спокойствия, "+app.mobile_site_upAndGo+" осуществляет деятельность при поддержке DiPocket UAB, который авторизован и контролируется Банком Литвы как эмитент электронных денег (#75) Upės str. 23, 08128 Vilnius, LT"});
        return list.iterator();
    }

    @Test(dataProvider = "BankTransfer")
    public void testBankTransfer(String site, String lang, int langId, int id, String email, String pass, int bodyBegin, int bodyEnd, int footerEnd, String expectedEmailSender, String expectedEmailBody, String expectedEmailFooter) throws InterruptedException, MessagingException, IOException {
        postSendBankTransferEmail(langId, site, id);

        String emailSender =  EmailVerificationHelper.getEmailSender(email, pass);
        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", email, pass);
        String emailBody = getEmailBodyText(emailText, bodyBegin , bodyEnd);
        String emailFooter = getEmailFooterText(emailText, footerEnd);

        assertThat(emailSender, equalTo(expectedEmailSender));
        assertThat(emailBody, equalTo(expectedEmailBody));
        assertThat(emailFooter, equalTo(expectedEmailFooter));
    }
}