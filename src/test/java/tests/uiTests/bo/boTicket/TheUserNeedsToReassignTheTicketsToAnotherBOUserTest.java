package tests.uiTests.bo.boTicket;

import appmanager.Login_RegistrationHelper;
import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.SQLException;

public class TheUserNeedsToReassignTheTicketsToAnotherBOUserTest extends UITestBase {
    String clientId2 = "29818";
    String phone2 = "380980316499";

    @Test
    public void testTheUserNeedsToReassignTheSDDTicketToAnotherBOUser_TheUserChangedHisMindAboutReassignTheSDDTicket() throws InterruptedException, SQLException, ClassNotFoundException {
        app.getUiboHelper().gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        app.getUiboTicketHelper().gotoTakeTicketWithReg();

        if (app.getUiboHelper().findElements(By.id("takeTicketContent")).size() == 0) {
            Login_RegistrationHelper login_registrationHelper = new Login_RegistrationHelper();
            login_registrationHelper.dipocketRegistration(616, 985, "TERMS_AND_CONDITIONS_PL", "ELECTRONIC_COMMUNICATION");
            app.getUiboTicketHelper().gotoTakeTicket();
        }

        app.getUiboTicketHelper().skipVideoCall(616, 985, "TERMS_AND_CONDITIONS_PL", "ELECTRONIC_COMMUNICATION");
        app.getUiboTicketHelper().skipFDDCheckClient();

        if (app.getUiboHelper().isElementPresent(By.xpath("//*[contains(text(), 'SDD - check client')]"))) {
            app.getUiboTicketHelper().verifyTheUserChangedHisMindAboutReassignTheTicketToAnotherBOUser();
            app.getUiboTicketHelper().reassignTicketSuccessfully("BOAUTOTEST", "test");
        }
    }

    @Test
    public void testTheUserNeedsToReassignTheFDDTicketToAnotherBOUser_TheUserChangedHisMindAboutReassignTheFDDTicket() throws InterruptedException, SQLException, ClassNotFoundException {
        app.getUiboHelper().gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        app.getUiboTicketHelper().gotoTakeTicketWithReg();

        if (app.getUiboHelper().findElements(By.id("takeTicketContent")).size() == 0) {
            Login_RegistrationHelper login_registrationHelper = new Login_RegistrationHelper();
            login_registrationHelper.dipocketRegistration(616, 985, "TERMS_AND_CONDITIONS_PL", "ELECTRONIC_COMMUNICATION");
            app.getUiboTicketHelper().gotoTakeTicket();
            app.getUiboTicketHelper().initFDDTicketDisplain();
        }

        app.getUiboTicketHelper().skipVideoCall(616, 985, "TERMS_AND_CONDITIONS_PL", "ELECTRONIC_COMMUNICATION");
        app.getUiboTicketHelper().skipSDDCheckClient();

        if (app.getUiboHelper().isElementPresent(By.xpath("//*[contains(text(), 'FDD - check client')]"))) {
            app.getUiboTicketHelper().verifyTheUserChangedHisMindAboutReassignTheTicketToAnotherBOUser();
            app.getUiboTicketHelper().reassignTicketSuccessfully("BOAUTOTEST", "test");
        }
    }

    @Test
    public void testTheUserNeedsToReassignTheSelfieChangeTicketToAnotherBOUser_TheUserChangedHisMindAboutReassignTheSelfieChangeTicketToAnotherBOUser() throws InterruptedException, SQLException, ClassNotFoundException {
        app.getUiboHelper().gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);

        app.getUiboTicketHelper().gotoClientPageAndUpdateSelfies(clientId2, phone2, "files/bo/images/self.jpg");
        app.getUiboHelper().gotoHomePageWithBOUser();
        app.getUiboTicketHelper().gotoTakeTicketWithReg();

        app.getUiboTicketHelper().skipVideoCall(616, 985, "TERMS_AND_CONDITIONS_PL", "ELECTRONIC_COMMUNICATION");
        app.getUiboTicketHelper().skipSDDCheckClient();

        if (app.getUiboHelper().isElementPresent(By.xpath("//*[contains(text(), 'Update Selfie')]"))) {
            app.getUiboTicketHelper().verifyTheUserChangedHisMindAboutReassignTheTicketToAnotherBOUser();
            app.getUiboTicketHelper().reassignTicketSuccessfully("BOAUTOTEST", "test");
        } else {
            Assert.fail("There are no Update Selfie Ticket");
        }
    }

    @Test
    public void testTheUserNeedsToReassignPhotoIDChangeTicketToAnotherBOUser_TheUserChangedHisMindAboutReassignPhotoIDChangeTicketToAnotherBOUser() throws InterruptedException, SQLException, ClassNotFoundException {
        app.getUiboHelper().gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);

        app.getUiboTicketHelper().gotoClientPageAndUpdateDocs(clientId2, phone2, "files/bo/images/self.jpg", "PhotoID");
        app.getUiboHelper().gotoHomePageWithBOUser();
        app.getUiboTicketHelper().gotoTakeTicketWithReg();

        app.getUiboTicketHelper().skipVideoCall(616, 985, "TERMS_AND_CONDITIONS_PL", "ELECTRONIC_COMMUNICATION");
        app.getUiboTicketHelper().skipSDDCheckClient();

        if (app.getUiboHelper().isElementPresent(By.xpath("//*[contains(text(), 'Update document')]"))) {
            app.getUiboTicketHelper().verifyTheUserChangedHisMindAboutReassignTheTicketToAnotherBOUser();
            app.getUiboTicketHelper().reassignTicketSuccessfully("BOAUTOTEST", "test");
        } else {
            Assert.fail("There are no Update document Ticket");
        }
    }
}