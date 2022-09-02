package tests.uiTests.bo.boTicket;

import appmanager.Login_RegistrationHelper;
import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.sql.SQLException;

import static org.testng.Assert.assertTrue;

public class TakeTicketTests extends UITestBase {

    @Test(priority = 1)
    public void testOpeningTicketPage() throws InterruptedException {
        app.getUiboHelper().gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        app.getUiboTicketHelper().gotoTakeTicket();

//        if(app.getUiboHelper().findElements(By.id("takeTicketContent")).size() == 0){
//            Login_RegistrationHelper login_registrationHelper = new Login_RegistrationHelper();
//            login_registrationHelper.dipocketReg();
//            app.getUiboTicketHelper().gotoTakeTicket();
//        }

        for(int i = 0; i < 3; i++) {
            if (app.getUiboHelper().isElementPresent(By.xpath("//*[contains(text(), 'FDD - check client')]"))) {
                app.getUiboTicketHelper().delayTicketForOneMinute();
                app.getUiboTicketHelper().gotoTakeTicket();
            }
        }

        if(app.getUiboHelper().isElementPresent(By.xpath("//*[contains(text(), 'Video Call')]"))){
            app.getUiboTicketHelper().delayTicketForOneMinute();
            app.getUiboTicketHelper().gotoTakeTicket();
        }

        if(app.getUiboHelper().isElementPresent(By.xpath("//*[contains(text(), 'SDD - check client')]"))) {
            app.getUiboHelper().waitFor(By.xpath("//app-client-details-info"));
            app.getUiboHelper().waitFor(By.id("takeTicketContent"));

            assertTrue(app.getUiboHelper().areButtonsPresent(new String[]{"//app-button[@ng-reflect-label='Approve']", "//app-button[@ng-reflect-label='Edit']",
                    "//app-button[@ng-reflect-label='Ask for']", "//app-button[@ng-reflect-label='Ask new selfie']",
                    "//app-button[@ng-reflect-label='Ban']", "//app-button[@ng-reflect-label='Postpone']", "//app-button[@ng-reflect-label='Reassign']"}), "button bo tickets");
        }

        if(app.getUiboHelper().isElementPresent(By.xpath("//*[contains(text(), 'FDD - check client')]"))) {
            app.getUiboHelper().waitFor(By.xpath("//app-client-details-info"));
            app.getUiboHelper().waitFor(By.id("takeTicketContent"));

            assertTrue(app.getUiboHelper().areButtonsPresent(new String[]{"//app-button[@ng-reflect-label='Approve']", "//app-button[@ng-reflect-label='Edit']",
                    "//app-button[@ng-reflect-label='Ask for']", "//app-button[@ng-reflect-label='Ask new selfie']",
                    "//app-button[@ng-reflect-label='Ban']", "//app-button[@ng-reflect-label='Postpone']", "//app-button[@ng-reflect-label='Reassign']"}), "button bo tickets");

        }
    }

    @Test(priority = 2)
    public void  testApproveSDDTicket() throws InterruptedException, SQLException, ClassNotFoundException {
        app.getUiboHelper().gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        app.getUiboTicketHelper().gotoTakeTicketWithReg();

        if(app.getUiboHelper().findElements(By.id("takeTicketContent")).size() == 0){
            Login_RegistrationHelper login_registrationHelper = new Login_RegistrationHelper();
            login_registrationHelper.dipocketRegistration();
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
            app.getUiboTicketHelper().editAndSaveSSDTicket("M", "Passport", "12345678", "12345678", "Poland");
            app.getUiboTicketHelper().approveTicketSuccessfully();

            app.getUiboHelper().waitFor(By.xpath("//*[contains(text(), 'Take Ticket')]"));

            assertTrue(app.getUiboHelper().areElementsPresent(new String[]{"//*[contains(text(), 'Take Ticket')]", "//*[contains(text(), 'Search')]"}));
        } else {
            Assert.fail("There is no sdd ticket");
        }


        //not ssd

//        app.getUiboHelper().click(By.xpath("//app-button[@ng-reflect-label='Edit']"));
//        app.getUiboTicketHelper().setGender("M");
//
//
//        app.getUiboTicketHelper().setDocumentType("Passport");
//        app.getUiboTicketHelper().setDocSerialNumber("12345678");
//        app.getUiboTicketHelper().setIDCode("12345678");
//        app.getUiboTicketHelper().setDocCountryOfIssue("Poland");
//
//        Thread.sleep(1500);
//        app.getUiboHelper().click(By.xpath("//p-button[@ng-reflect-label='Save']"));
//
//        app.getUiboHelper().waitFor(By.xpath("//*[contains(text(), 'Client data updated successfully')]"));
//
//        app.getUiboHelper().click(By.xpath("//app-button[@ng-reflect-label='Approve']"));
//
//
//        app.getUiboHelper().waitFor(By.xpath("//*[contains(text(), 'Ticket approved successfully')]"));
//
//        app.getUiboHelper().waitFor(By.xpath("//*[contains(text(), 'Take Ticket')]"));
//
//        assertTrue(app.getUiboHelper().areElementsPresent(new String[]{"//*[contains(text(), 'Take Ticket')]", "//*[contains(text(), 'Search')]"}));
    }

    @Test(priority = 3)
    public void  testApproveSDDTicketWithoutGenderChoice() throws InterruptedException, SQLException, ClassNotFoundException {
        app.getUiboHelper().gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        app.getUiboTicketHelper().gotoTakeTicketWithReg();

        if(app.getUiboHelper().findElements(By.id("takeTicketContent")).size() == 0){
            Login_RegistrationHelper login_registrationHelper = new Login_RegistrationHelper();
            login_registrationHelper.dipocketRegistration();
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


//        if(app.getUiboHelper().areElementsPresent(new String[]{"//td[contains(text(), 'Gender')]"})){
//            WebElement table = app.getUiboHelper().findElement(By.cssSelector("div.data-table tbody"));
//            WebElement row = table.findElement(By.xpath("//tr[3]"));
//            String rows = row.getText();
//
//            WebElement td = row.findElement(By.xpath("//tr[3] //td[2]"));
//
//            String tdd = td.getText();
//            System.out.println(tdd);
//
//            app.getUiboHelper().click(By.xpath("//app-button[@ng-reflect-label='Approve']"));
//
//            app.getUiboHelper().waitFor(By.xpath("//*[contains(text(), 'Ticket approved successfully')]"));
//
//
//            app.getUiboHelper().waitFor(By.xpath("//p[contains(text(), 'Take Ticket')]"));
//            app.getUiboHelper().click(By.xpath("//p[contains(text(), 'Take Ticket')]"));
//
//        }

//        app.getUiboHelper().click(By.xpath("//a[@role='tab'] //span[contains(text(), 'Profile data')]"));
//
//        WebElement table = app.getUiboHelper().findElements(By.cssSelector("div.client-data tbody")).get(0);
//        WebElement row = table.findElement(By.xpath("//tr[3]"));
//        String rows = row.getText();
//
//        WebElement td = row.findElement(By.xpath("//tr[3] //td[1]"));
//
//        String tdd = td.getText();
//        System.out.println(tdd);

        app.getUiboHelper().click(By.xpath("//app-button[@ng-reflect-label='Edit']"));


        //app-select-async[@ng-reflect-name='gender'] //span[contains(text(), 'All')]

        if(app.getUiboHelper().isElementPresent(By.xpath("//app-select-async[@ng-reflect-name='gender'] //span[contains(text(), 'All')]"))){
            app.getUiboHelper().click(By.cssSelector("div.p-dialog-header-icons"));
        }

        app.getUiboTicketHelper().unsuccessfulApprove("Impossible to approve ticket. “Gender” field should be filled");
        app.getUiboTicketHelper().editAndSaveSSDTicket("M", "", "", "", "");
        app.getUiboTicketHelper().approveTicketSuccessfully();

        app.getUiboHelper().waitFor(By.xpath("//*[contains(text(), 'Take Ticket')]"));

        assertTrue(app.getUiboHelper().areElementsPresent(new String[]{"//*[contains(text(), 'Take Ticket')]", "//*[contains(text(), 'Search')]"}));
    }

    @Test
    public void testBOUserNeedsToRequestANewSelfieWhenCheckingSDDTicket() throws InterruptedException, SQLException, ClassNotFoundException {
        app.getUiboHelper().gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        app.getUiboTicketHelper().gotoTakeTicketWithReg();

        if(app.getUiboHelper().findElements(By.id("takeTicketContent")).size() == 0){
            Login_RegistrationHelper login_registrationHelper = new Login_RegistrationHelper();
            login_registrationHelper.dipocketRegistration();
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
            app.getUiboHelper().click(By.xpath("//app-button[@ng-reflect-label='Ask new selfie']"));
            app.getUiboHelper().waitFor(By.xpath("//*[contains(text(), 'Ticket rejected successfully')]"));

        } else {
            Assert.fail("There is no sdd ticket");
        }

        app.getUiboHelper().waitFor(By.xpath("//*[contains(text(), 'Take Ticket')]"));

        assertTrue(app.getUiboHelper().areElementsPresent(new String[]{"//*[contains(text(), 'Take Ticket')]", "//*[contains(text(), 'Search')]"}));
    }

    @Test(enabled = false)
    public void testApproveFDDTiketWithDocumentTypePassport() throws InterruptedException {
        app.getUiboHelper().gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        app.getUiboTicketHelper().gotoTakeTicket();
    }

    @Test
    public void testTheUserNeedsToEscalateToCBOTicketWithReason() throws InterruptedException, SQLException, ClassNotFoundException {
        app.getUiboHelper().gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        app.getUiboTicketHelper().gotoTakeTicketWithReg();

        if(app.getUiboHelper().findElements(By.id("takeTicketContent")).size() == 0){
            Login_RegistrationHelper login_registrationHelper = new Login_RegistrationHelper();
            login_registrationHelper.dipocketRegistration();
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
}