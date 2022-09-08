package tests.uiTests.bo.boTicket;

import appmanager.Login_RegistrationHelper;
import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.sql.SQLException;

public class TakeFDDTicketTests extends UITestBase {

    @Test(priority = 1)
    public void testApproveFDDTiketWithDocumentTypePassport() throws InterruptedException, SQLException, ClassNotFoundException {
        app.getUiboHelper().gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        app.getUiboTicketHelper().gotoTakeTicketWithReg();

        if (app.getUiboHelper().findElements(By.id("takeTicketContent")).size() == 0) {
            Login_RegistrationHelper login_registrationHelper = new Login_RegistrationHelper();
            login_registrationHelper.dipocketRegistration(616, 985, "TERMS_AND_CONDITIONS_PL", "ELECTRONIC_COMMUNICATION");
            app.getUiboTicketHelper().gotoTakeTicket();
            app.getUiboTicketHelper().initFDDTicketDisplain();
        }

        if (app.getUiboHelper().isElementPresent(By.xpath("//*[contains(text(), 'Video Call')]"))) {
            app.getUiboTicketHelper().delayTicketForOneMinute();
            app.getUiboTicketHelper().gotoTakeTicket();
        }

        for (int i = 0; i < 3; i++) {
            if (app.getUiboHelper().isElementPresent(By.xpath("//*[contains(text(), 'SDD - check client')]"))) {
                app.getUiboTicketHelper().delayTicketForOneMinute();
                app.getUiboTicketHelper().gotoTakeTicket();
            }
        }

        if (app.getUiboHelper().isElementPresent(By.xpath("//*[contains(text(), 'FDD - check client')]"))) {
            app.getUiboTicketHelper().editAndSaveFDDTicket("", "Passport", "CGH164279", "34999285098", "Poland");
            app.getUiboTicketHelper().approveTicketSuccessfully();
        }
    }

    @Test
    public void testApproveFDDTicketWithoutFillingInRequiredFields() throws InterruptedException, SQLException, ClassNotFoundException {
        app.getUiboHelper().gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        app.getUiboTicketHelper().gotoTakeTicketWithReg();

        if (app.getUiboHelper().findElements(By.id("takeTicketContent")).size() == 0) {
            Login_RegistrationHelper login_registrationHelper = new Login_RegistrationHelper();
            login_registrationHelper.dipocketRegistration(616, 985, "TERMS_AND_CONDITIONS_PL", "ELECTRONIC_COMMUNICATION");
            app.getUiboTicketHelper().gotoTakeTicket();
            app.getUiboTicketHelper().initFDDTicketDisplain();
        }

        if (app.getUiboHelper().isElementPresent(By.xpath("//*[contains(text(), 'Video Call')]"))) {
            app.getUiboTicketHelper().delayTicketForOneMinute();
            app.getUiboTicketHelper().gotoTakeTicket();
        }

        for (int i = 0; i < 3; i++) {
            if (app.getUiboHelper().isElementPresent(By.xpath("//*[contains(text(), 'SDD - check client')]"))) {
                app.getUiboTicketHelper().delayTicketForOneMinute();
                app.getUiboTicketHelper().gotoTakeTicket();
            }
        }

        if (app.getUiboHelper().isElementPresent(By.xpath("//*[contains(text(), 'FDD - check client')]"))) {
            app.getUiboTicketHelper().unsuccessfulApprove("Impossible to approve ticket. Client already have documents. Fields “Document type“, “Doc serial number“, “Doc country of issue“ should be filled");
        }
    }

    @Test
    public void testApproveFDDTicketForNotAResidentOfPoland() throws InterruptedException, SQLException, ClassNotFoundException {
        app.getUiboHelper().gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        app.getUiboTicketHelper().gotoTakeTicketWithReg();

        if (app.getUiboHelper().findElements(By.id("takeTicketContent")).size() == 0) {
            Login_RegistrationHelper login_registrationHelper = new Login_RegistrationHelper();
            login_registrationHelper.dipocketRegistration(826, 826, "TERMS_AND_CONDITIONS_GB", "DATA_PROCESSING");
            app.getUiboTicketHelper().gotoTakeTicket();
            app.getUiboTicketHelper().initFDDTicketDisplain();
        }

        if (app.getUiboHelper().isElementPresent(By.xpath("//*[contains(text(), 'Video Call')]"))) {
            app.getUiboTicketHelper().delayTicketForOneMinute();
            app.getUiboTicketHelper().gotoTakeTicketWithReg();
        }

        for (int i = 0; i < 3; i++) {
            if (app.getUiboHelper().isElementPresent(By.xpath("//*[contains(text(), 'SDD - check client')]"))) {
                app.getUiboTicketHelper().delayTicketForOneMinute();
                app.getUiboTicketHelper().gotoTakeTicketWithReg();
            }
        }

        if (app.getUiboHelper().isElementPresent(By.xpath("//*[contains(text(), 'FDD - check client')]"))) {
            app.getUiboTicketHelper().editAndSaveFDDTicket("", "National identification number", "11111111111", "", "United Kingdom");
            app.getUiboTicketHelper().approveTicketSuccessfully();
        }
    }
}