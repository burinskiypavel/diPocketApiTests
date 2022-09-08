package tests.uiTests.bo.boTicket;

import appmanager.Login_RegistrationHelper;
import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.SQLException;

import static org.testng.Assert.assertTrue;

public class EscalateToCBOTests extends UITestBase {
    @Test
    public void testTheUserNeedsToEscalateToCBOTicketWithoutReason() throws InterruptedException, SQLException, ClassNotFoundException {
        app.getUiboHelper().gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        app.getUiboTicketHelper().gotoTakeTicketWithReg();

        if(app.getUiboHelper().findElements(By.id("takeTicketContent")).size() == 0){
            Login_RegistrationHelper login_registrationHelper = new Login_RegistrationHelper();
            login_registrationHelper.dipocketRegistration(616, 985, "TERMS_AND_CONDITIONS_PL", "ELECTRONIC_COMMUNICATION");
            app.getUiboTicketHelper().gotoTakeTicket();
        }

        if(app.getUiboHelper().isElementPresent(By.xpath("//*[contains(text(), 'Video Call')]"))){
            app.getUiboTicketHelper().delayTicketForOneMinute();
            app.getUiboTicketHelper().gotoTakeTicket();
        }

        for(int i = 0; i < 3; i++) {
            if (app.getUiboHelper().isElementPresent(By.xpath("//*[contains(text(), 'FDD - check client')]"))) {
                app.getUiboTicketHelper().delayTicketForOneMinute();
                app.getUiboTicketHelper().gotoTakeTicket();
            }
        }

        if(app.getUiboHelper().isElementPresent(By.xpath("//*[contains(text(), 'SDD - check client')]"))){
            app.getUiboTicketHelper().escalateToCBOSuccessfully("AQA", "");


        } else {
            Assert.fail("There is no sdd ticket");
        }

        app.getUiboHelper().waitFor(By.xpath("//*[contains(text(), 'Take Ticket')]"));

        assertTrue(app.getUiboHelper().areElementsPresent(new String[]{"//*[contains(text(), 'Take Ticket')]", "//*[contains(text(), 'Search')]"}));
    }

    @Test
    public void testTheUserChangedHisMindAboutEscalateToCBOTicketWithoutReason() throws InterruptedException, SQLException, ClassNotFoundException {
        app.getUiboHelper().gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        app.getUiboTicketHelper().gotoTakeTicketWithReg();

        if(app.getUiboHelper().findElements(By.id("takeTicketContent")).size() == 0){
            Login_RegistrationHelper login_registrationHelper = new Login_RegistrationHelper();
            login_registrationHelper.dipocketRegistration(616, 985, "TERMS_AND_CONDITIONS_PL", "ELECTRONIC_COMMUNICATION");
            app.getUiboTicketHelper().gotoTakeTicket();
        }

        if(app.getUiboHelper().isElementPresent(By.xpath("//*[contains(text(), 'Video Call')]"))){
            app.getUiboTicketHelper().delayTicketForOneMinute();
            app.getUiboTicketHelper().gotoTakeTicket();
        }

        for(int i = 0; i < 3; i++) {
            if (app.getUiboHelper().isElementPresent(By.xpath("//*[contains(text(), 'FDD - check client')]"))) {
                app.getUiboTicketHelper().delayTicketForOneMinute();
                app.getUiboTicketHelper().gotoTakeTicket();
            }
        }

        if(app.getUiboHelper().isElementPresent(By.xpath("//*[contains(text(), 'SDD - check client')]"))){
            app.getUiboHelper().click(By.xpath("//app-button[@ng-reflect-label='Escalate to CBO']"));
            app.getUiboHelper().closePopUp(By.cssSelector("div.p-dialog-header-icons"));
            app.getUiboHelper().waitForInvisibilityOfElement(By.xpath("//div[@role='dialog']"));
        } else {
            Assert.fail("There is no sdd ticket");
        }
    }


    @Test
    public void testTheUserNeedsToEscalateToCBOTicketWithReason() throws InterruptedException, SQLException, ClassNotFoundException {
        app.getUiboHelper().gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        app.getUiboTicketHelper().gotoTakeTicketWithReg();

        if(app.getUiboHelper().findElements(By.id("takeTicketContent")).size() == 0){
            Login_RegistrationHelper login_registrationHelper = new Login_RegistrationHelper();
            login_registrationHelper.dipocketRegistration(616, 985, "TERMS_AND_CONDITIONS_PL", "ELECTRONIC_COMMUNICATION");
            app.getUiboTicketHelper().gotoTakeTicket();
        }

        if(app.getUiboHelper().isElementPresent(By.xpath("//*[contains(text(), 'Video Call')]"))){
            app.getUiboTicketHelper().delayTicketForOneMinute();
            app.getUiboTicketHelper().gotoTakeTicket();
        }

        for(int i = 0; i < 3; i++) {
            if (app.getUiboHelper().isElementPresent(By.xpath("//*[contains(text(), 'FDD - check client')]"))) {
                app.getUiboTicketHelper().delayTicketForOneMinute();
                app.getUiboTicketHelper().gotoTakeTicket();
            }
        }

        if(app.getUiboHelper().isElementPresent(By.xpath("//*[contains(text(), 'SDD - check client')]"))){
            app.getUiboTicketHelper().escalateToCBOSuccessfully("AQA", "test");


        } else {
            Assert.fail("There is no sdd ticket");
        }

        app.getUiboHelper().waitFor(By.xpath("//*[contains(text(), 'Take Ticket')]"));

        assertTrue(app.getUiboHelper().areElementsPresent(new String[]{"//*[contains(text(), 'Take Ticket')]", "//*[contains(text(), 'Search')]"}));
    }

    @Test
    public void testTheUserNeedsToEscalateToCBOTicketTriesToEscalateWithoutChoosingAssignTo() throws InterruptedException, SQLException, ClassNotFoundException {
        app.getUiboHelper().gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        app.getUiboTicketHelper().gotoTakeTicketWithReg();

        if(app.getUiboHelper().findElements(By.id("takeTicketContent")).size() == 0){
            Login_RegistrationHelper login_registrationHelper = new Login_RegistrationHelper();
            login_registrationHelper.dipocketRegistration(616, 985, "TERMS_AND_CONDITIONS_PL", "ELECTRONIC_COMMUNICATION");
            app.getUiboTicketHelper().gotoTakeTicket();
        }

        if(app.getUiboHelper().isElementPresent(By.xpath("//*[contains(text(), 'Video Call')]"))){
            app.getUiboTicketHelper().delayTicketForOneMinute();
            app.getUiboTicketHelper().gotoTakeTicket();
        }

        for(int i = 0; i < 3; i++) {
            if (app.getUiboHelper().isElementPresent(By.xpath("//*[contains(text(), 'FDD - check client')]"))) {
                app.getUiboTicketHelper().delayTicketForOneMinute();
                app.getUiboTicketHelper().gotoTakeTicket();
            }
        }

        if(app.getUiboHelper().isElementPresent(By.xpath("//*[contains(text(), 'SDD - check client')]"))){
            app.getUiboHelper().click(By.xpath("//app-button[@ng-reflect-label='Escalate to CBO']"));
            Thread.sleep(1300);
            app.getUiboHelper().click(By.xpath("//app-reassign-modal //p-button[@ng-reflect-label='Reassign']"));
            app.getUiboHelper().waitFor(By.xpath("//*[contains(text(), 'Assign to is required ')]"));
        }
    }
}
