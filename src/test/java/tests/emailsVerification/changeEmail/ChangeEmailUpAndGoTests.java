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

public class ChangeEmailUpAndGoTests extends TestBase {
    String expectedEmailSender = "wsparcie@upcard.pl";

    public String body(int landId){
        return "{\n" +
                "\"id\": 32727,\n" +
                "\"clientFirstName\": \""+app.emailsVerificationsFirstName+"\",\n" +
                "\"clientLastName\": \""+app.emailsVerificationsLastName+"\",\n" +
                "\"countryId\": "+app.emailsVerificationsCountryId+",\n" +
                "\"langId\": "+landId+",\n" +
                "\"mainPhone\": \""+app.emailsVerificationsPhoneNumber+"\",\n" +
                "\"email\": \""+app.emailsVerificationsEmail+"\",\n" +
                "\"currencyId\": "+app.emailsVerificationsCurrencyId+",\n" +
                "\"site\": \""+app.mobile_site_upAndGo+"\",\n" +
                "\"siteEnum\": \""+app.mobile_site_upAndGo+"\",\n" +
                "\"programNickName\": \""+app.mobile_site_upAndGo+"\"\n" +
                "}";
    }

    public void postSendChangeEmail(int landId) {
        given()
                .spec(app.requestSpecEmailVerification)
                .body(body(landId))
                .when()
                .post( "/EmailService/sendChangeEmail")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test(priority = 1)
    public void testChangeEmailUpAndGoEN() throws InterruptedException, MessagingException, IOException {
        postSendChangeEmail(1);

        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualSender = senderAndSubject.get(0);
        String actualSubject = senderAndSubject.get(1);

        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualBody = getEmailBodyText(emailText, 47, 267);
        String actualFooter = getEmailFooterText(emailText, 268);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualSender, expectedEmailSender, "Sender is not correct");
        softAssert.assertEquals(actualSubject, ""+app.site_upAndGo+" - email address verification request", "Subject is not correct");
        softAssert.assertEquals(actualBody, "Dear "+app.emailsVerificationsFirstName+", We received your request to verify the email address associated with your "+app.site_upAndGo+" account. Please click on this link to confirm your request and finalise the change. With kind regards, Customer Service Team", "Body is not correct");
        softAssert.assertEquals(actualFooter, ""+app.SITE_REG+" "+app.site_upAndGo+" is powered by DiPocket UAB, authorised Electronic Money Institution regulated by the Bank of Lithuania (#75) | Licensed by Masterсard for the European Economic Area Upės str. 23, 08128 Vilnius, LT", "Footer is not correct");
        softAssert.assertAll();
    }

    @Test(priority = 2)
    public void testChangeEmailUpAndGoUA() throws InterruptedException, MessagingException, IOException {
        postSendChangeEmail(2);

        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualSender = senderAndSubject.get(0);
        String actualSubject = senderAndSubject.get(1);

        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualBody = getEmailBodyText(emailText, 29, 276);
        String actualFooter = getEmailFooterText(emailText, 277);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualSender, expectedEmailSender, "Sender is not correct");
        softAssert.assertEquals(actualSubject, ""+app.site_upAndGo+" - запит на верифікацію електронної адреси", "Subject is not correct");
        softAssert.assertEquals(actualBody, "Вітаємо, "+app.emailsVerificationsFirstName+"! Ми отримали запит на верифікацію Вашої електронної адреси приєднану до вашого облікового запису "+app.site_upAndGo+". Будь ласка, перейдіть за цим посиланням , щоб підтвердити Ваш запит та завершити зміни. З повагою, Відділ підтримки клієнтів", "Body is not correct");
        softAssert.assertEquals(actualFooter, ""+app.SITE_REG+" Для Вашого спокою, "+app.site_upAndGo+" працює при підтримці DiPocket UAB, що авторизований та контролюється Банком Литви, як емітент електронних грошей (#75) Upės str. 23, 08128 Vilnius, LT", "Footer is not correct");
        softAssert.assertAll();
    }

    @Test(priority = 3)
    public void testChangeEmailUpAndGoPL() throws InterruptedException, MessagingException, IOException {
        postSendChangeEmail(3);

        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualSender = senderAndSubject.get(0);
        String actualSubject = senderAndSubject.get(1);

        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualBody = getEmailBodyText(emailText, 0, 211);
        String actualFooter = getEmailFooterText(emailText, 212);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualSender, expectedEmailSender, "Sender is not correct");
        softAssert.assertEquals(actualSubject, ""+app.site_upAndGo+" - prośba o weryfikację adresu email", "Subject is not correct");
        softAssert.assertEquals(actualBody, "Witaj, "+app.emailsVerificationsFirstName+"! Otrzymaliśmy prośbę o weryfikację adresu email powiązanego z Twoim kontem "+app.site_upAndGo+". Kliknij w ten link , aby potwierdzić tę prośbę i sfinalizować zmianę. Z wyrazami szacunku, Dział Obsługi Klienta", "Body is not correct");
        softAssert.assertEquals(actualFooter, ""+app.SITE_REG+" "+app.site_upAndGo+" dostarcza DiPocket UAB, autoryzowana Instytucja Pieniądza Elektronicznego, podlegająca nadzorowi Banku Litwy (numer licencji 75) | Licencjonowana przez Mastercard do działania na Europejskim Obszarze Gospodarczego Upės g. 23, 08128 Vilnius, LT", "Footer is not correct");
        softAssert.assertAll();
    }

    @Test(priority = 4)
    public void testChangeEmailUpAndGoRU() throws InterruptedException, MessagingException, IOException {
        postSendChangeEmail(4);

        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualSender = senderAndSubject.get(0);
        String actualSubject = senderAndSubject.get(1);

        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualBody = getEmailBodyText(emailText, 29, 256);
        String actualFooter = getEmailFooterText(emailText, 257);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualSender, expectedEmailSender, "Sender is not correct");
        softAssert.assertEquals(actualSubject, ""+app.site_upAndGo+" - запрос на верификацию адреса электронной почты", "Subject is not correct");
        softAssert.assertEquals(actualBody, "Здравствуйте, "+app.emailsVerificationsFirstName+"! Мы получили запрос на верификацию адреса электронной почты, которая указана в Вашей учетной записи. Пожалуйста, перейдите по этой ссылке , чтобы подтвердить изменение. С уважением, Служба поддержки клиентов", "Body is not correct");
        softAssert.assertEquals(actualFooter, ""+app.SITE_REG+" Для вашего спокойствия, "+app.site_upAndGo+" осуществляет деятельность при поддержке DiPocket UAB, который авторизован и контролируется Банком Литвы как эмитент электронных денег (#75) Upės str. 23, 08128 Vilnius, LT", "Footer is not correct");
        softAssert.assertAll();
    }
}