package tests.uiTests.bo.boTicket;

import appmanager.Login_RegistrationHelper;
import base.UITestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.sql.SQLException;
import java.util.List;

public class SelfieChangeTest extends UITestBase {

    @Test
    public void testApprovingChangesWhenChangingASelfie() throws InterruptedException, SQLException, ClassNotFoundException {
        String clientId = null;
        app.getUiboHelper().gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        app.getUiboTicketHelper().gotoTakeTicketWithReg();

        if (app.getUiboHelper().findElements(By.id("takeTicketContent")).size() == 0) {
            Login_RegistrationHelper login_registrationHelper = new Login_RegistrationHelper();
            login_registrationHelper.dipocketRegistration(616, 985, "TERMS_AND_CONDITIONS_PL", "ELECTRONIC_COMMUNICATION");
            app.getUiboTicketHelper().gotoTakeTicket();
            clientId = app.getUiboTicketHelper().initFDDTicketDisplain();
        }

        app.getUiboTicketHelper().skipVideoCall(616, 985, "TERMS_AND_CONDITIONS_PL", "ELECTRONIC_COMMUNICATION");
        app.getUiboTicketHelper().skipSDDCheckClient();

        if (app.getUiboHelper().isElementPresent(By.xpath("//*[contains(text(), 'FDD - check client')]"))) {
            app.getUiboTicketHelper().editAndSaveFDDTicket("", "Passport", "11111111111", "123456789", "Poland");
            app.getUiboTicketHelper().approveTicketSuccessfully();


            app.getUiboHelper().gotoSearchPage();
            app.getUiboHelper().search("id", clientId);
            app.getUiboTicketHelper().goToClientPage("380685448615");

            app.getUiboHelper().click(By.xpath("//p-button[@ng-reflect-label='Upload selfies']"));
            File file = new File("files/bo/images/self.jpg");

            List<WebElement> elements = app.getUiboHelper().findElements(By.xpath("//input[@type='file'][1]"));
            app.getUiboHelper().uploadFile(By.cssSelector("app-upload-file-with-preview[ng-reflect-name='base64Selfie1'] input[type='file']"), file.getAbsolutePath());
            app.getUiboHelper().uploadFile(By.cssSelector("app-upload-file-with-preview[ng-reflect-name='base64Selfie2'] input[type='file']"), file.getAbsolutePath());
            Thread.sleep(700);
            app.getUiboHelper().click(By.xpath("//p-button[@ng-reflect-label='Confirm']"));
            app.getUiboHelper().waitFor(By.xpath("//*[contains(text(), 'Selfies were uploaded successfully')]"));

            app.getUiboTicketHelper().click(By.xpath("//p-button[@ng-reflect-label='Home']"));
            app.getUiboTicketHelper().waitFor(By.cssSelector("div[ng-reflect-router-link='take_ticket']"));
            app.getUiboTicketHelper().gotoTakeTicketWithReg();
        }

        if (app.getUiboHelper().isElementPresent(By.xpath("//*[contains(text(), 'Update Selfie')]"))) {
            app.getUiboTicketHelper().approveTicketSuccessfully();
        } else {
            Assert.fail("There are no Update Selfie Ticket");
        }
    }
}