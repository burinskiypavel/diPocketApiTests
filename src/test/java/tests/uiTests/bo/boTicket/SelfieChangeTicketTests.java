package tests.uiTests.bo.boTicket;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.SQLException;

import static appmanager.HelperBase.prop;

public class SelfieChangeTicketTests extends UITestBase {
    String clientId = null;
    //String clientId2 = app.homePageLoginId;
    String clientId2 = "30457";
    String phone2 = "380980316499";
    String actualTicketType = null;

    @Test(enabled = false)
    public void testApprovingChangesWhenChangingASelfie_withRegistration() throws InterruptedException, SQLException, ClassNotFoundException {
        app.getUiboHelper().gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        app.getUiboTicketHelper().gotoTakeTicketWithReg();

        if (app.getUiboHelper().findElements(By.id("takeTicketContent")).size() == 0) {
            app.getLogin_registrationHelper().dipocketRegistration(616, 985, "TERMS_AND_CONDITIONS_PL", "ELECTRONIC_COMMUNICATION", app.generateRandomString(8), "715611173985", prop.getProperty("mobile.registration.phoneNumber"), prop.getProperty("mobile.registration.email"), "dev");
            app.getUiboTicketHelper().gotoTakeTicket();
            clientId = app.getUiboTicketHelper().initFDDTicketDisplain(prop.getProperty("mobile.registration.phoneNumber"), "M");
        }

        app.getUiboTicketHelper().skipVideoCall(616, 985, "TERMS_AND_CONDITIONS_PL", "ELECTRONIC_COMMUNICATION");
        app.getUiboTicketHelper().skipSDDCheckClient();

        if (app.getUiboHelper().isElementPresent(By.xpath("//*[contains(text(), 'FDD - check client')]"))) {
            app.getUiboTicketHelper().editAndSaveFDDTicket("", "Passport", "11111111111", "123456789", "Poland");
            app.getUiboTicketHelper().approveTicketSuccessfully();

            app.getUiboTicketHelper().gotoClientPageAndUpdateSelfies(clientId,"files/bo/images/self.jpg");
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
            app.getLogin_registrationHelper().dipocketRegistration(616, 985, "TERMS_AND_CONDITIONS_PL", "ELECTRONIC_COMMUNICATION", app.generateRandomString(8), "715611173985", prop.getProperty("mobile.registration.phoneNumber"), prop.getProperty("mobile.registration.email"), "dev");
            app.getUiboTicketHelper().gotoTakeTicket();
            clientId = app.getUiboTicketHelper().initFDDTicketDisplain("380685448615", "M");
        }

        app.getUiboTicketHelper().skipVideoCall(616, 985, "TERMS_AND_CONDITIONS_PL", "ELECTRONIC_COMMUNICATION");
        app.getUiboTicketHelper().skipSDDCheckClient();

        if (app.getUiboHelper().isElementPresent(By.xpath("//*[contains(text(), 'FDD - check client')]"))) {
            app.getUiboTicketHelper().editAndSaveFDDTicket("", "Passport", "11111111111", "123456789", "Poland");
            app.getUiboTicketHelper().approveTicketSuccessfully();

            app.getUiboTicketHelper().gotoClientPageAndUpdateSelfies(clientId, "files/bo/images/self.jpg");
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
    public void testApprovingOfSelfieChangeTicket_withAlreadyExistClient() throws InterruptedException, SQLException, ClassNotFoundException {
        app.getUiboHelper().gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);

        app.getUiboTicketHelper().gotoClientPageAndUpdateSelfies(clientId2,"files/bo/images/self.jpg");
        app.getUiboHelper().gotoHomePageWithBOUser();
        app.getUiboTicketHelper().gotoTakeTicketWithReg();

        actualTicketType = app.getUiboTicketHelper().getActualTicketType();

        for(int i = 0; i < 12; i++) {
            actualTicketType = app.getUiboTicketHelper().getActualTicketType();
            if(actualTicketType.equals("Update Selfie")){
                break;
            }

            if (!actualTicketType.equals("Update Selfie")) {
                app.getUiboTicketHelper().delayTicketForSeveralMinutes();
                app.getUiboTicketHelper().gotoTakeTicketWithReg();
            }

            if(app.getUiboHelper().findElements(By.id("takeTicketContent")).size() == 0){
                app.getLogin_registrationHelper().dipocketRegistration(616, 985, "TERMS_AND_CONDITIONS_PL", "ELECTRONIC_COMMUNICATION", app.generateRandomString(8), "715611173985", prop.getProperty("mobile.registration.phoneNumber"), prop.getProperty("mobile.registration.email"), "dev");
                app.getUiboTicketHelper().gotoTakeTicket();
            }
        }

        if (app.getUiboHelper().isElementPresent(By.xpath("//*[contains(text(), 'Update Selfie')]"))) {
            app.getUiboTicketHelper().approveTicketSuccessfully();
        } else {
            System.out.println("actualTicketType: " + actualTicketType);
            Assert.fail("There are no Update Selfie Ticket");
        }
    }

    @Test
    public void testRejectionOfSelfieChangeTicket_TheUserChangedHisMindAboutRejectionOfSelfieChangeTicket_withAlreadyExistClient() throws InterruptedException, SQLException, ClassNotFoundException {
        app.getUiboHelper().gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);

        app.getUiboTicketHelper().gotoClientPageAndUpdateSelfies(clientId2,"files/bo/images/self.jpg");
        app.getUiboHelper().gotoHomePageWithBOUser();
        app.getUiboTicketHelper().gotoTakeTicketWithReg();

        actualTicketType = app.getUiboTicketHelper().getActualTicketType();

        for(int i = 0; i < 12; i++) {
            actualTicketType = app.getUiboTicketHelper().getActualTicketType();
            if(actualTicketType.equals("Update Selfie")){
                break;
            }

            if (!actualTicketType.equals("Update Selfie")) {
                app.getUiboTicketHelper().delayTicketForSeveralMinutes();
                app.getUiboTicketHelper().gotoTakeTicketWithReg();
            }

            if(app.getUiboHelper().findElements(By.id("takeTicketContent")).size() == 0){
                app.getLogin_registrationHelper().dipocketRegistration(616, 985, "TERMS_AND_CONDITIONS_PL", "ELECTRONIC_COMMUNICATION", app.generateRandomString(8), "715611173985", prop.getProperty("mobile.registration.phoneNumber"), prop.getProperty("mobile.registration.email"), "dev");
                app.getUiboTicketHelper().gotoTakeTicket();
            }
        }

        if (app.getUiboHelper().isElementPresent(By.xpath("//*[contains(text(), 'Update Selfie')]"))) {
            app.getUiboTicketHelper().verifyUserChangedHisMindAboutRejectionOfSelfieDocChangeTicket();
            app.getUiboTicketHelper().rejectTicketSuccessfully("test", "Ticket rejected successfully");
        } else {
            System.out.println("actualTicketType: " + actualTicketType);
            Assert.fail("There are no Update Selfie Ticket");
        }
    }
}