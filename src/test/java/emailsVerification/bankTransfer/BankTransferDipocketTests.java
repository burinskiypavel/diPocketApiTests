package emailsVerification.bankTransfer;

import appmanager.EmailIMAPHelper3;
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

public class BankTransferDipocketTests extends TestBase {
    String site = "DiPocket";
    String expectedEmailSender = "customer.service@dipocket.org";

    public String body(int landId){
        return "{\n" +
                "\"id\": 32726,\n" +
                "\"clientFirstName\": \""+app.emailsVerificationsFirstName+"\",\n" +
                "\"clientLastName\": \""+app.emailsVerificationsLastName+"\",\n" +
                "\"countryId\": "+app.emailsVerificationsCountryId+",\n" +
                "\"langId\": "+landId+",\n" +
                "\"mainPhone\": \""+app.emailsVerificationsPhoneNumber+"\",\n" +
                "\"email\": \""+app.emailsVerificationsEmail+"\",\n" +
                "\"currencyId\": "+app.emailsVerificationsCurrencyId+",\n" +
                "\"site\": \""+app.mobile_site+"\",\n" +
                "\"siteEnum\": \""+app.mobile_site+"\",\n" +
                "\"programNickName\": \""+app.mobile_site+"\"\n" +
                "}";
    }

    public void postSendBankTransferEmail(int langId) {
        given()
                .header("Content-Type", "application/json")
                .body(body(langId))
                .when()
                .post( app.dipocket3_intranet+"/EmailService/sendBankTransferEmail")
                .then().log().all()
                .statusCode(200);
    }

    @DataProvider
    public Iterator<Object[]> BankTransfer(){
        List<Object[]> list = new ArrayList<Object[]>();
        list.add(new Object[] {"EN", 1, app.emailsVerificationsEmail, app.emailsVerificationsPass, 38, 158, 159, "Dear "+app.emailsVerificationsFirstName+", As requested, please find attached your bank transfer confirmation. With kind regards, Customer Service Team", ""+app.SITE_REG+" "+site+" UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT"});
        list.add(new Object[] {"UA", 2, app.emailsVerificationsEmail, app.emailsVerificationsPass, 28, 154, 155, "Вітаємо, "+app.emailsVerificationsFirstName+"! В додатку знаходиться замовлене Вами підтвердження банківського переказу. З повагою, Відділ підтримки клієнтів", ""+app.SITE_REG+" Для Вашого спокою, "+site+" UAB авторизований та контролюється Банком Литви, як емітент електронних грошей (#75) Upės str. 23, 08128 Vilnius, LT"});
        list.add(new Object[] {"PL", 3, app.emailsVerificationsEmail,  app.emailsVerificationsPass, 0, 126, 127, "Witaj "+app.emailsVerificationsFirstName+", W załączniku znajduje się zamówione potwierdzenie przelewu bankowego. Z wyrazami szacunku, Zespół Obsługi Klienta", ""+app.SITE_REG+" "+site+" UAB, autoryzowana Instytucja Pieniądza Elektronicznego, podlegająca nadzorowi Banku Litwy (numer licencji 75) | Licencjonowana przez Mastercard do działania na Europejskim Obszarze Gospodarczego Upės g. 23, 08128 Vilnius, LT"});
        list.add(new Object[] {"PL", 4, app.emailsVerificationsEmail, app.emailsVerificationsPass, 28, 169, 170, "Здравствуйте, "+app.emailsVerificationsFirstName+"! В приложении находится подтверждение банковского перевода, которое Вы заказывали. С уважением, Служба поддержки клиентов", ""+app.SITE_REG+" Для вашего спокойствия, "+site+" UAB авторизован и контролируется Банком Литвы как эмитент электронных денег (#75) Upės str. 23, 08128 Vilnius, LT"});
        return list.iterator();
    }

    @Test(dataProvider = "BankTransfer")
    public void testBankTransferDipocket(String lang, int langId, String email, String pass, int bodyBegin, int bodyEnd, int footerEnd, String expectedEmailBody, String expectedEmailFooter) throws InterruptedException, MessagingException, IOException {
        postSendBankTransferEmail(langId);

        String emailSender =  EmailIMAPHelper3.getEmailSender(email, pass);
        String emailText =  EmailIMAPHelper3.getTextFromEmail("pop.gmail.com", email, pass);
        String emailBody = getEmailBodyText(emailText, bodyBegin , bodyEnd);
        String emailFooter = getEmailFooterText(emailText, footerEnd);

        assertThat(emailSender, equalTo(expectedEmailSender));
        assertThat(emailBody, equalTo(expectedEmailBody));
        assertThat(emailFooter, equalTo(expectedEmailFooter));
    }
}