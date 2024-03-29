package tests.uiTests.bo.boClient;

import appmanager.EmailVerificationHelper;
import appmanager.Language;
import base.UITestBase;
import com.cs.dipocketback.base.data.Site;
import org.testng.annotations.Test;

import javax.mail.MessagingException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import static appmanager.EmailIMAPHelper.getEmailBodyText;
import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

public class RolesBOUserClientPageSendStatementsButtonTests extends UITestBase {
    String phone = "380980316499";
    String clientId = app.homePageLoginId;
    String email = "testdipocket3@gmail.com";
    String pass = "pasword12!";
    String appPass = "whotpsgrehudbtqv";

    @Test
    public void testRolesBOUserClientPageSendStatementsButtonAllStatementsAndDefaultEmail() throws InterruptedException, IOException, MessagingException, SQLException, ClassNotFoundException {
        app.getDbHelper().updateClientLanguageFromDB(email, String.valueOf(Language.UK.getOurId()), Site.DIPOCKET.toString());
        app.getUiboHelper().gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        app.getUiboHelper().gotoSearchPage();
        app.getUiboHelper().search("id", clientId, phone);
        app.getUiboClientHelper().goToClientPage(phone);
        app.getUiboClientHelper().sendAllStatemenstToDefaultEmail();

        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(email, pass, appPass);
        String actualSubject = senderAndSubject.get(1);
        List<String> actualAttachedFileNames = EmailVerificationHelper.getFileNameFromEmail("pop.gmail.com", email, pass, appPass);
        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", email, pass, appPass);
        String actualBody = getEmailBodyText(emailText, 28, 191);

        assertEquals(actualSubject, "Виписка по рахунку "+app.site+"");
        assertEquals(actualBody, "Вітаємо, "+app.emailsVerificationsFirstName+"! В додатку знаходиться замовлена Вами банківська виписка по рахунку "+app.site+". Дякуємо за користування додатком "+app.site+". З повагою, Юридичний відділ");
        assertTrue(actualAttachedFileNames.size()>3);
    }

    @Test
    public void testRolesBOUserClientPageSendStatementsButtonStatementAllStatementsAndEnteredEmail() throws InterruptedException, IOException, MessagingException {
        app.getUiboHelper().gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        app.getUiboHelper().gotoSearchPage();
        app.getUiboHelper().search("id", clientId, phone);
        app.getUiboClientHelper().goToClientPage(phone);
        app.getUiboClientHelper().sendAllStatementsToEnteredEmail(app.emailsVerificationsEmail);

        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualSubject = senderAndSubject.get(1);
        List<String> actualAttachedFileNames = EmailVerificationHelper.getFileNameFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", app.emailsVerificationsEmail, app.emailsVerificationsPass);
        String actualBody = getEmailBodyText(emailText, 28, 191);

        assertEquals(actualSubject, "Виписка по рахунку "+app.site+"");
        assertEquals(actualBody, "Вітаємо, "+app.emailsVerificationsFirstName+"! В додатку знаходиться замовлена Вами банківська виписка по рахунку "+app.site+". Дякуємо за користування додатком "+app.site+". З повагою, Юридичний відділ");
        assertTrue(actualAttachedFileNames.size()>3);
    }

    @Test
    public void testRolesBOUserClientPageSendStatementsButtonStatementForChosenPeriodAndDefaultEmail() throws InterruptedException, IOException, MessagingException {
        app.getUiboHelper().gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        app.getUiboHelper().gotoSearchPage();
        app.getUiboHelper().search("id", clientId, phone);
        app.getUiboClientHelper().goToClientPage(phone);
        app.getUiboClientHelper().sendStatementForChosenPeriodAndDefaultEmail();

        List<String> senderAndSubject = EmailVerificationHelper.getEmailSenderAndSubject(email, pass, appPass);
        String actualSubject = senderAndSubject.get(1);
        List<String> actualAttachedFileNames = EmailVerificationHelper.getFileNameFromEmail("pop.gmail.com", email, pass, appPass);
        String emailText =  EmailVerificationHelper.getTextFromEmail("pop.gmail.com", email, pass, appPass);
        String actualBody = getEmailBodyText(emailText, 28, 191);

        assertEquals(actualSubject, "Виписка по рахунку "+app.site+"");
        assertEquals(actualBody, "Вітаємо, "+app.emailsVerificationsFirstName+"! В додатку знаходиться замовлена Вами банківська виписка по рахунку "+app.site+". Дякуємо за користування додатком "+app.site+". З повагою, Юридичний відділ");
        assertTrue(actualAttachedFileNames.size() == 1);
    }
}