package tests.uiTests.bo.boTicket;

import appmanager.Login_RegistrationHelper;
import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UpdateDocumentTicketTests extends UITestBase {
    String clientId = null;
    String clientId2 = "29818";
    String phone2 = "380980316499";

    @DataProvider
    public Iterator<Object[]> docs(){
        List<Object[]> list = new ArrayList<Object[]>();
        list.add(new Object[] {"PhotoID"});
        list.add(new Object[] {"Proof of address"});
        list.add(new Object[] {"PhotoID Back"});
        list.add(new Object[] {"Second ID"});
        return list.iterator();
    }

    @Test(dataProvider = "docs")
    public void testApprovingChangesOfDocs(String document) throws InterruptedException, SQLException, ClassNotFoundException {
        String clientId = null;
        app.getUiboHelper().gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        app.getUiboTicketHelper().gotoTakeTicketWithReg();

        if (app.getUiboHelper().findElements(By.id("takeTicketContent")).size() == 0) {
            Login_RegistrationHelper login_registrationHelper = new Login_RegistrationHelper();
            login_registrationHelper.dipocketRegistration(616, 985, "TERMS_AND_CONDITIONS_PL", "ELECTRONIC_COMMUNICATION");
            app.getUiboTicketHelper().gotoTakeTicket();
            clientId = app.getUiboTicketHelper().initFDDTicketDisplainWithSecondID();
        }

        app.getUiboTicketHelper().skipVideoCall(616, 985, "TERMS_AND_CONDITIONS_PL", "ELECTRONIC_COMMUNICATION");
        app.getUiboTicketHelper().skipSDDCheckClient();

        if (app.getUiboHelper().isElementPresent(By.xpath("//*[contains(text(), 'FDD - check client')]"))) {
            app.getUiboTicketHelper().editAndSaveFDDTicket("", "Passport", "11111111111", "123456789", "Poland");
            app.getUiboTicketHelper().approveTicketSuccessfully();
        }

        app.getUiboHelper().waitFor(By.xpath("//*[contains(text(), 'Take Ticket')]"));
        app.getUiboTicketHelper().uploadDoc(clientId, "380685448615", document, "files/bo/images/self.jpg");

        app.getUiboTicketHelper().click(By.xpath("//p-button[@ng-reflect-label='Home']"));
        app.getUiboTicketHelper().waitFor(By.cssSelector("div[ng-reflect-router-link='take_ticket']"));
        app.getUiboTicketHelper().gotoTakeTicketWithReg();

        if (app.getUiboHelper().isElementPresent(By.xpath("//*[contains(text(), 'Update document')]"))) {
            app.getUiboTicketHelper().approveTicketSuccessfullyDocsChange();
        } else {
            Assert.fail("There are no Update Document Ticket");
        }

    }

    @Test(enabled = false, dataProvider = "docs")
    public void testRejectionOfPhotoIDChangeTicket_TheUserChangedHisMindAboutRejectionOfPhotoIDChangeTicket_withRegistration(String doc) throws InterruptedException, SQLException, ClassNotFoundException {
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

            app.getUiboTicketHelper().gotoClientPageAndUpdateDocs(clientId, "380685448615", "files/bo/images/self.jpg", doc);
            app.getUiboHelper().gotoHomePageWithBOUser();
            app.getUiboTicketHelper().gotoTakeTicketWithReg();
        }

        if (app.getUiboHelper().isElementPresent(By.xpath("//*[contains(text(), 'Update document')]"))) {
            app.getUiboTicketHelper().verifyUserChangedHisMindAboutRejectionOfSelfieDocChangeTicket();
            app.getUiboTicketHelper().rejectTicketSuccessfully("test", "Docs was rejected successfully");
        } else {
            Assert.fail("There are no Update Document Ticket");
        }
    }

    @Test(dataProvider = "docs")
    public void testRejectionOfPhotoIDChangeTicket_TheUserChangedHisMindAboutRejectionOfPhotoIDChangeTicket_withCreatedUser(String doc) throws InterruptedException, SQLException, ClassNotFoundException {
        app.getUiboHelper().gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);

        app.getUiboTicketHelper().gotoClientPageAndUpdateDocs(clientId2, phone2, "files/bo/images/self.jpg", doc);
        app.getUiboHelper().gotoHomePageWithBOUser();
        app.getUiboTicketHelper().gotoTakeTicketWithReg();

        app.getUiboTicketHelper().skipVideoCall(616, 985, "TERMS_AND_CONDITIONS_PL", "ELECTRONIC_COMMUNICATION");
        app.getUiboTicketHelper().skipSDDCheckClient();

        if (app.getUiboHelper().isElementPresent(By.xpath("//*[contains(text(), 'Update document')]"))) {
            app.getUiboTicketHelper().verifyUserChangedHisMindAboutRejectionOfSelfieDocChangeTicket();
            app.getUiboTicketHelper().rejectTicketSuccessfully("test", "Docs was rejected successfully");
        } else {
            Assert.fail("There are no Update Document Ticket");
        }
    }
}