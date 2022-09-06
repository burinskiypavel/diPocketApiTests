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
            login_registrationHelper.dipocketRegistration();
            app.getUiboTicketHelper().gotoTakeTicket();

            String id = app.getUiboHelper().getText(By.xpath("//*[contains(text(), 'ID:')] //span"));
            app.getUiboTicketHelper().editAndSaveSDDTicket("M", "", "", "", "");
            app.getUiboTicketHelper().approveTicketSuccessfully();
            app.getUiboHelper().gotoSearchPage();
            app.getUiboHelper().search("id", id);
            app.getUiboHelper().goToClientPage("380685448615");

            app.getUiboHelper().click(By.xpath("//p-button[@ng-reflect-label='Upload docs']"));
            app.getUiboHelper().selectFromDropDown(By.xpath("//app-select-async[@ng-reflect-name='typeId']"), "PhotoID");
            app.getUiboHelper().uploadFile(By.xpath("//input[@type='file']"), "C:/Work/Files/self.jpg");
            Thread.sleep(1000);
            app.getUiboHelper().click(By.xpath("//p-button[@ng-reflect-label='Confirm']"));

            app.getUiboHelper().click(By.xpath("//p-button[@ng-reflect-label='Upload docs']"));
            app.getUiboHelper().selectFromDropDown(By.xpath("//app-select-async[@ng-reflect-name='typeId']"), "Proof of address");
            app.getUiboHelper().uploadFile(By.xpath("//input[@type='file']"), "C:/Work/Files/self.jpg");
            Thread.sleep(1000);
            app.getUiboHelper().click(By.xpath("//p-button[@ng-reflect-label='Confirm']"));

            app.getUiboHelper().click(By.xpath("//p-button[@ng-reflect-label='Upload docs']"));
            app.getUiboHelper().selectFromDropDown(By.xpath("//app-select-async[@ng-reflect-name='typeId']"), "PhotoID Back");
            app.getUiboHelper().uploadFile(By.xpath("//input[@type='file']"), "C:/Work/Files/self.jpg");
            Thread.sleep(1000);
            app.getUiboHelper().click(By.xpath("//p-button[@ng-reflect-label='Confirm']"));
            app.getUiboHelper().click(By.xpath("//p-button[@ng-reflect-label='Home']"));
            app.getUiboHelper().waitFor(By.cssSelector("div[ng-reflect-router-link='take_ticket']"));
            app.getUiboTicketHelper().gotoTakeTicketWithReg();

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
}