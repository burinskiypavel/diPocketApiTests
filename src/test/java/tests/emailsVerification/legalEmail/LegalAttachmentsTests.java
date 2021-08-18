package tests.emailsVerification.legalEmail;

import appmanager.EmailVerificationHelper;
import base.TestBase;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import javax.mail.MessagingException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import static appmanager.EmailIMAPHelper.getEmailBodyText;
import static appmanager.EmailIMAPHelper.getEmailFooterText;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.testng.Assert.assertEquals;

public class LegalAttachmentsTests extends TestBase {
    String cliSessionId = null;
    String email = "testdipocket2@gmail.com";
    String pass = "pasword12!";

    @Test(priority = 1)
    public void test_ClientServices_v1_homePage_AutintificateMobileApp() throws SQLException, ClassNotFoundException {
        app.getDbHelper().deleteClientDeviceFromDB("380633192217-AutoTest-Login");
        given()
                .spec(app.requestSpecDipocketHomePage)
                .auth().preemptive().basic("380633192217", "pasword1")
                .contentType("application/json; charset=UTF-8")
                .body("{\n" +
                        "  \"devToken\" : \"eGy9q-lDQBGKz-bgdz1U6q:APA91bF8bT00_Cj-KVTiTSLlB-LBL8itr4LKxJVSxKJGZs3eyvHMbLZ4mZWYyo_r290PQFuKhx7mQOgAFeisGhBByoHXzQ0ANETYA-nTnDGM29zXKxcaIh47qJ7dyFQymXolPLYtmeM8\",\n" +
                        "  \"devType\" : \"android\",\n" +
                        "  \"deviceUUID\" : \"380633192217-AutoTest-Login\",\n" +
                        "  \"appVersion\" : \"2.2.7\"\n" +
                        "}")
                .when()
                .post( "homePage/authenticateMobileApp")
                .then().log().all()
                .statusCode(400)
                //.body("errDesc", equalTo("Введите код (#1) из SMS, что б подтвердить вход на этом устройстве"))
                .body("errCode", equalTo("DIP-00591"));
    }

    @Test(priority = 2)
    public void test_ClientServices_v1_homePage_AutintificateMobileApp_() throws SQLException, ClassNotFoundException {
        String loginSMSCode = app.getDbHelper().getLoginSMSFromDB("380633192217", "380633192217-AutoTest-Login", "DIPOCKET");
        Response res =  given()
                .spec(app.requestSpecDipocketHomePage)
                .auth().preemptive().basic("380633192217", "pasword1")
                .contentType("application/json; charset=UTF-8")
                .body("{\n" +
                        "  \"devToken\" : \"eGy9q-lDQBGKz-bgdz1U6q:APA91bF8bT00_Cj-KVTiTSLlB-LBL8itr4LKxJVSxKJGZs3eyvHMbLZ4mZWYyo_r290PQFuKhx7mQOgAFeisGhBByoHXzQ0ANETYA-nTnDGM29zXKxcaIh47qJ7dyFQymXolPLYtmeM8\",\n" +
                        "  \"devType\" : \"android\",\n" +
                        "  \"deviceUUID\" : \"380633192217-AutoTest-Login\",\n" +
                        "  \"appVersion\" : \"2.2.7\",\n" +
                        "  \"otp\" : \""+loginSMSCode+"\"\n" +
                        "}")
                .when()
                .post( "homePage/authenticateMobileApp");
        cliSessionId = res.getHeader("cliSessionId");
        System.out.println(res.getHeaders());
        System.out.println("cliSessionId " + cliSessionId);
        int StatusCode = res.getStatusCode();
        assertEquals(StatusCode, 200);
    }

    @Test(priority = 3)
    public void test_clientProfile_getLegalDocumentList(){
        given()
                .spec(app.requestSpecDipocketHomePage)
                .auth().preemptive().basic("380633192217", "pasword1")
                .header("clisessionid", ""+cliSessionId+"")
                .when()
                .get("clientProfile/getLegalDocumentList")
                .then().log().all()
                .statusCode(200)
                .body("documentList.type", hasItems("Tariff Table", "Limits Table", "General Terms and Conditions",
                        "Supervised Accounts T&Cs", "Privacy Policy", "Complaints Policy", "E-wallet terms of usage",
                        "DiPocket Card Transaction Dispute Declaration"),
                        "documentList.nameForClient", hasItems("Тарифы", "Лимиты", "Общие условия", "Условия использования счетов под опекой",
                                "Политика конфиденциальности", "Политика жалоб", "Условия пользования электронным кошельком",
                        "Бланк для споров по операциям с карточками DiPocket"),
                        "documentList.selected", hasItems(false, false, false, false, false, false, false, false));
    }

    @Test(priority = 4)
    public void test_clientProfile_sendLegalInfo2_DipocketRU() throws InterruptedException, MessagingException, IOException, SQLException, ClassNotFoundException {
        app.getDbHelper().updateClientLanguageFromDB(email, "4", app.mobile_site);
        given()
                .spec(app.requestSpecDipocketHomePage)
                .auth().preemptive().basic("380633192217", "pasword1")
                .header("clisessionid", ""+cliSessionId+"")
                .contentType("application/json")
                .body("{\n" +
                        "  \"documentList\": [\n" +
                        "    {\n" +
                        "      \"nameForClient\": \"Тарифы\",\n" +
                        "      \"nameForEmail\": \"testdipocket2@gmail.com\",\n" + //pas: pasword12!
                        "      \"selected\": true,\n" +
                        "      \"type\": \"Tariff Table\"\n" +
                        "    }\n" +
                        "  ]\n" +
                        "}")
                .when()
                .post("clientProfile/sendLegalInfo2")
                .then().log().all()
                .statusCode(200);

        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(email, pass);
        String actualSender = senderAndSubject.get(0);
        String actualSubject = senderAndSubject.get(1);
        List<String>actualAttachedFileNames = EmailVerificationHelper.getFileNameFromEmail("pop.gmail.com", email, pass);
        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", email, pass);
        String actualBody = getEmailBodyText(emailText, 28, 181);
        String actualFooter = getEmailFooterText(emailText, 182);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualAttachedFileNames, Arrays.asList( "Тарифы.pdf"), "File name is not correct");
        softAssert.assertEquals(actualSender, "legal.team@dipocket.org", "Sender is not correct");
        softAssert.assertEquals(actualSubject, "Документы "+app.site+"", "Subject is not correct");
        softAssert.assertEquals(actualBody,"Здравствуйте, "+app.emailsVerificationsFirstName+"! В приложении находятся юридические документы, которые Вы заказывали. Спасибо за пользование "+app.site+". С уважением, Юридический отдел", "Body is not correct");
        softAssert.assertEquals(actualFooter, ""+app.SITE_REG+" Для вашего спокойствия, "+app.site+" UAB авторизован и контролируется Банком Литвы как эмитент электронных денег (#75) Upės str. 23, 08128 Vilnius, LT", "Footer is not correct");
        softAssert.assertAll();
    }
}