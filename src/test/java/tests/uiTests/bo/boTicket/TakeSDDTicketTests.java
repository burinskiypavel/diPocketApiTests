package tests.uiTests.bo.boTicket;

import appmanager.HelperBase;
import appmanager.Login_RegistrationHelper;
import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.sql.SQLException;

import static org.testng.Assert.assertTrue;

public class TakeSDDTicketTests extends UITestBase {
    String actualTicketType = null;

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
                app.getUiboTicketHelper().delayTicketForSeveralMinutes();
                app.getUiboTicketHelper().gotoTakeTicket();
            }
        }

        if(app.getUiboHelper().isElementPresent(By.xpath("//*[contains(text(), 'Video Call')]"))){
            app.getUiboTicketHelper().delayTicketForSeveralMinutes();
            app.getUiboTicketHelper().gotoTakeTicket();
        }

        if(app.getUiboHelper().isElementPresent(By.xpath("//*[contains(text(), 'Update cardholder')]"))){
            app.getUiboTicketHelper().approveTicketSuccessfullyUpdateCardholder();
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
            login_registrationHelper.dipocketRegistration(616, 985, "TERMS_AND_CONDITIONS_PL", "ELECTRONIC_COMMUNICATION", app.generateRandomString(8), "715611173985", HelperBase.prop.getProperty("mobile.registration.phoneNumber"), HelperBase.prop.getProperty("mobile.registration.email"));
            app.getUiboTicketHelper().gotoTakeTicket();
        }

        actualTicketType = app.getUiboTicketHelper().getActualTicketType();

        for(int i = 0; i < 12; i++) {
            actualTicketType = app.getUiboTicketHelper().getActualTicketType();
            if(actualTicketType.equals("SDD - check client's data")){
                break;
            }

            if (!actualTicketType.equals("SDD - check client's data")) {
                app.getUiboTicketHelper().delayTicketForSeveralMinutes();
                app.getUiboTicketHelper().gotoTakeTicketWithReg();
            }

            if(app.getUiboHelper().findElements(By.id("takeTicketContent")).size() == 0){
                Login_RegistrationHelper login_registrationHelper = new Login_RegistrationHelper();
                login_registrationHelper.dipocketRegistration(616, 985, "TERMS_AND_CONDITIONS_PL", "ELECTRONIC_COMMUNICATION", app.generateRandomString(8), "715611173985", HelperBase.prop.getProperty("mobile.registration.phoneNumber"), HelperBase.prop.getProperty("mobile.registration.email"));
                app.getUiboTicketHelper().gotoTakeTicket();
            }
        }

//        if(app.getUiboHelper().isElementPresent(By.xpath("//*[contains(text(), 'Video Call')]"))){
//            app.getUiboTicketHelper().delayTicketForSeveralMinutes();
//            app.getUiboTicketHelper().gotoTakeTicket();
//        }
//
//        if(app.getUiboHelper().isElementPresent(By.xpath("//*[contains(text(), 'Update cardholder')]"))){
//            app.getUiboTicketHelper().approveTicketSuccessfullyUpdateCardholder();
//        }
//
//        for(int i = 0; i < 3; i++) {
//            if (app.getUiboHelper().isElementPresent(By.xpath("//*[contains(text(), 'FDD - check client')]"))) {
//                app.getUiboTicketHelper().delayTicketForSeveralMinutes();
//                app.getUiboTicketHelper().gotoTakeTicket();
//            }
//        }

        if(app.getUiboHelper().isElementPresent(By.xpath("//*[contains(text(), 'SDD - check client')]"))){
            app.getUiboTicketHelper().editAndSaveSDDTicket("M", "Passport", "12345678", "12345678", "Poland");
            app.getUiboTicketHelper().approveTicketSuccessfully();

            app.getUiboHelper().waitFor(By.xpath("//*[contains(text(), 'Take Ticket')]"));

            assertTrue(app.getUiboHelper().areElementsPresent(new String[]{"//*[contains(text(), 'Take Ticket')]", "//*[contains(text(), 'Search')]"}));
        } else {
            System.out.println("actualTicketType: " + actualTicketType);
            Assert.fail("There is no sdd ticket");
        }
    }

    @Test(priority = 3)
    public void  testApproveSDDTicketWithoutGenderChoice() throws InterruptedException, SQLException, ClassNotFoundException {
        app.getUiboHelper().gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        app.getUiboTicketHelper().gotoTakeTicketWithReg();

        if(app.getUiboHelper().findElements(By.id("takeTicketContent")).size() == 0){
            Login_RegistrationHelper login_registrationHelper = new Login_RegistrationHelper();
            login_registrationHelper.dipocketRegistration(616, 985, "TERMS_AND_CONDITIONS_PL", "ELECTRONIC_COMMUNICATION", app.generateRandomString(8), "715611173985", HelperBase.prop.getProperty("mobile.registration.phoneNumber"), HelperBase.prop.getProperty("mobile.registration.email"));
            app.getUiboTicketHelper().gotoTakeTicket();
        }

        actualTicketType = app.getUiboTicketHelper().getActualTicketType();

        for(int i = 0; i < 12; i++) {
            actualTicketType = app.getUiboTicketHelper().getActualTicketType();
            if(actualTicketType.equals("SDD - check client's data")){
                break;
            }

            if (!actualTicketType.equals("SDD - check client's data")) {
                app.getUiboTicketHelper().delayTicketForSeveralMinutes();
                app.getUiboTicketHelper().gotoTakeTicketWithReg();
            }

            if(app.getUiboHelper().findElements(By.id("takeTicketContent")).size() == 0){
                Login_RegistrationHelper login_registrationHelper = new Login_RegistrationHelper();
                login_registrationHelper.dipocketRegistration(616, 985, "TERMS_AND_CONDITIONS_PL", "ELECTRONIC_COMMUNICATION", app.generateRandomString(8), "715611173985", HelperBase.prop.getProperty("mobile.registration.phoneNumber"), HelperBase.prop.getProperty("mobile.registration.email"));
                app.getUiboTicketHelper().gotoTakeTicket();
            }
        }

//        if(app.getUiboHelper().isElementPresent(By.xpath("//*[contains(text(), 'Video Call')]"))){
//            app.getUiboTicketHelper().delayTicketForSeveralMinutes();
//            app.getUiboTicketHelper().gotoTakeTicket();
//        }
//
//        if(app.getUiboHelper().isElementPresent(By.xpath("//*[contains(text(), 'Update cardholder')]"))){
//            app.getUiboTicketHelper().approveTicketSuccessfullyUpdateCardholder();
//        }
//
//        for(int i = 0; i < 3; i++) {
//            if (app.getUiboHelper().isElementPresent(By.xpath("//*[contains(text(), 'FDD - check client')]"))) {
//                app.getUiboTicketHelper().delayTicketForSeveralMinutes();
//                app.getUiboTicketHelper().gotoTakeTicket();
//            }
//        }

        app.getUiboHelper().click(By.xpath("//app-button[@ng-reflect-label='Edit']"));

        if(app.getUiboHelper().isElementPresent(By.xpath("//app-select-async[@ng-reflect-name='gender'] //span[contains(text(), 'All')]"))){
            app.getUiboHelper().click(By.cssSelector("div.p-dialog-header-icons"));
        }

        app.getUiboTicketHelper().unsuccessfulApprove("Impossible to approve ticket. “Gender” field should be filled");
        app.getUiboTicketHelper().editAndSaveSDDTicket("M", "", "", "", "");
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
            login_registrationHelper.dipocketRegistration(616, 985, "TERMS_AND_CONDITIONS_PL", "ELECTRONIC_COMMUNICATION", app.generateRandomString(8), "715611173985", HelperBase.prop.getProperty("mobile.registration.phoneNumber"), HelperBase.prop.getProperty("mobile.registration.email"));
            app.getUiboTicketHelper().gotoTakeTicket();
        }

        actualTicketType = app.getUiboTicketHelper().getActualTicketType();

        for(int i = 0; i < 12; i++) {
            actualTicketType = app.getUiboTicketHelper().getActualTicketType();
            if(actualTicketType.equals("SDD - check client's data")){
                break;
            }

            if (!actualTicketType.equals("SDD - check client's data")) {
                app.getUiboTicketHelper().delayTicketForSeveralMinutes();
                app.getUiboTicketHelper().gotoTakeTicketWithReg();
            }

            if(app.getUiboHelper().findElements(By.id("takeTicketContent")).size() == 0){
                Login_RegistrationHelper login_registrationHelper = new Login_RegistrationHelper();
                login_registrationHelper.dipocketRegistration(616, 985, "TERMS_AND_CONDITIONS_PL", "ELECTRONIC_COMMUNICATION", app.generateRandomString(8), "715611173985", HelperBase.prop.getProperty("mobile.registration.phoneNumber"), HelperBase.prop.getProperty("mobile.registration.email"));
                app.getUiboTicketHelper().gotoTakeTicket();
            }
        }

//        if(app.getUiboHelper().isElementPresent(By.xpath("//*[contains(text(), 'Video Call')]"))){
//            app.getUiboTicketHelper().delayTicketForSeveralMinutes();
//            app.getUiboTicketHelper().gotoTakeTicket();
//        }
//
//        if(app.getUiboHelper().isElementPresent(By.xpath("//*[contains(text(), 'Update cardholder')]"))){
//            app.getUiboTicketHelper().approveTicketSuccessfullyUpdateCardholder();
//        }
//
//        for(int i = 0; i < 3; i++) {
//            if (app.getUiboHelper().isElementPresent(By.xpath("//*[contains(text(), 'FDD - check client')]"))) {
//                app.getUiboTicketHelper().delayTicketForSeveralMinutes();
//                app.getUiboTicketHelper().gotoTakeTicket();
//            }
//        }

        if(app.getUiboHelper().isElementPresent(By.xpath("//*[contains(text(), 'SDD - check client')]"))){
            app.getUiboHelper().click(By.xpath("//app-button[@ng-reflect-label='Ask new selfie']"));
            app.getUiboHelper().waitFor(By.xpath("//*[contains(text(), 'Ticket rejected successfully')]"));

        } else {
            System.out.println("actualTicketType: " + actualTicketType);
            Assert.fail("There is no sdd ticket");
        }

        app.getUiboHelper().waitFor(By.xpath("//*[contains(text(), 'Take Ticket')]"));

        assertTrue(app.getUiboHelper().areElementsPresent(new String[]{"//*[contains(text(), 'Take Ticket')]", "//*[contains(text(), 'Search')]"}));
    }

    @Test
    public void testRequestToScanDocumentsAskFor() throws InterruptedException, SQLException, ClassNotFoundException {
        app.getUiboHelper().gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        app.getUiboTicketHelper().gotoTakeTicketWithReg();

        if (app.getUiboHelper().findElements(By.id("takeTicketContent")).size() == 0) {
            Login_RegistrationHelper login_registrationHelper = new Login_RegistrationHelper();
            login_registrationHelper.dipocketRegistration(616, 985, "TERMS_AND_CONDITIONS_PL", "ELECTRONIC_COMMUNICATION", app.generateRandomString(8), "715611173985", HelperBase.prop.getProperty("mobile.registration.phoneNumber"), HelperBase.prop.getProperty("mobile.registration.email"));
            app.getUiboTicketHelper().gotoTakeTicket();
        }

        actualTicketType = app.getUiboTicketHelper().getActualTicketType();

        for(int i = 0; i < 12; i++) {
            actualTicketType = app.getUiboTicketHelper().getActualTicketType();
            if(actualTicketType.equals("SDD - check client's data")){
                break;
            }

            if (!actualTicketType.equals("SDD - check client's data")) {
                app.getUiboTicketHelper().delayTicketForSeveralMinutes();
                app.getUiboTicketHelper().gotoTakeTicketWithReg();
            }

            if(app.getUiboHelper().findElements(By.id("takeTicketContent")).size() == 0){
                Login_RegistrationHelper login_registrationHelper = new Login_RegistrationHelper();
                login_registrationHelper.dipocketRegistration(616, 985, "TERMS_AND_CONDITIONS_PL", "ELECTRONIC_COMMUNICATION", app.generateRandomString(8), "715611173985", HelperBase.prop.getProperty("mobile.registration.phoneNumber"), HelperBase.prop.getProperty("mobile.registration.email"));
                app.getUiboTicketHelper().gotoTakeTicket();
            }
        }
        //app.getUiboTicketHelper().skipVideoCall(616, 985, "TERMS_AND_CONDITIONS_PL", "ELECTRONIC_COMMUNICATION");
        //app.getUiboTicketHelper().skipFDDCheckClient();

        if (app.getUiboHelper().isElementPresent(By.xpath("//*[contains(text(), 'SDD - check client')]"))) {
            app.getUiboTicketHelper().askForSuccessfullySDD(false, false, false, true);
        }
    }
}