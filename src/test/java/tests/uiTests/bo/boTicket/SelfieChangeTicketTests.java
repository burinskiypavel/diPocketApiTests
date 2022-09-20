package tests.uiTests.bo.boTicket;

import appmanager.Login_RegistrationHelper;
import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.SQLException;

public class SelfieChangeTicketTests extends UITestBase {
    String clientId = null;
    String clientId2 = "29818";
    String phone2 = "380980316499";

    @Test
    public void testApprovingChangesWhenChangingASelfie() throws InterruptedException, SQLException, ClassNotFoundException {
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

            app.getUiboTicketHelper().gotoClientPageAndUpdateSelfies(clientId, "380685448615", "files/bo/images/self.jpg");
            app.getUiboHelper().gotoHomePageWithBOUser();
            app.getUiboTicketHelper().gotoTakeTicketWithReg();
        }

        if (app.getUiboHelper().isElementPresent(By.xpath("//*[contains(text(), 'Update Selfie')]"))) {
            app.getUiboTicketHelper().approveTicketSuccessfully();
        } else {
            Assert.fail("There are no Update Selfie Ticket");
        }
    }

    @Test(enabled = false)
    public void testRejectionOfSelfieChangeTicket_TheUserChangedHisMindAboutRejectionOfSelfieChangeTicket_withRegistration() throws InterruptedException, SQLException, ClassNotFoundException {
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

            app.getUiboTicketHelper().gotoClientPageAndUpdateSelfies(clientId, "380685448615", "files/bo/images/self.jpg");
            app.getUiboHelper().gotoHomePageWithBOUser();
            app.getUiboTicketHelper().gotoTakeTicketWithReg();
        }

        if (app.getUiboHelper().isElementPresent(By.xpath("//*[contains(text(), 'Update Selfie')]"))) {
            app.getUiboTicketHelper().verifyUserChangedHisMindAboutRejectionOfSelfieDocChangeTicket();
            app.getUiboTicketHelper().rejectTicketSuccessfully("test", "Ticket rejected successfully");
        } else {
            Assert.fail("There are no Update Selfie Ticket");
        }
    }

    @Test
    public void testRejectionOfSelfieChangeTicket_TheUserChangedHisMindAboutRejectionOfSelfieChangeTicket_withAlreadyExistClient() throws InterruptedException, SQLException, ClassNotFoundException {
        app.getUiboHelper().gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);

        app.getUiboTicketHelper().gotoClientPageAndUpdateSelfies(clientId2, phone2, "files/bo/images/self.jpg");
        app.getUiboHelper().gotoHomePageWithBOUser();
        app.getUiboTicketHelper().gotoTakeTicketWithReg();

        app.getUiboTicketHelper().skipVideoCall(616, 985, "TERMS_AND_CONDITIONS_PL", "ELECTRONIC_COMMUNICATION");
        app.getUiboTicketHelper().skipSDDCheckClient();

        if (app.getUiboHelper().isElementPresent(By.xpath("//*[contains(text(), 'Update Selfie')]"))) {
            app.getUiboTicketHelper().verifyUserChangedHisMindAboutRejectionOfSelfieDocChangeTicket();
            app.getUiboTicketHelper().rejectTicketSuccessfully("test", "Ticket rejected successfully");
        } else {
            Assert.fail("There are no Update Selfie Ticket");
        }
    }
}