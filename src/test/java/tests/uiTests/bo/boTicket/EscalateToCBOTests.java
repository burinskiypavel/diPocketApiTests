package tests.uiTests.bo.boTicket;

import appmanager.Login_RegistrationHelper;
import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.SQLException;

import static org.testng.Assert.assertTrue;

public class EscalateToCBOTests extends UITestBase {
    String actualTicketType = null;

    @Test
    public void testTheUserNeedsToEscalateToCBOTicketWithoutReason() throws InterruptedException, SQLException, ClassNotFoundException {
        app.getUiboHelper().gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        app.getUiboTicketHelper().gotoTakeTicketWithReg();

        if(app.getUiboHelper().findElements(By.id("takeTicketContent")).size() == 0){
            Login_RegistrationHelper login_registrationHelper = new Login_RegistrationHelper();
            login_registrationHelper.dipocketRegistration(616, 985, "TERMS_AND_CONDITIONS_PL", "ELECTRONIC_COMMUNICATION", app.generateRandomString(8));
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
                login_registrationHelper.dipocketRegistration(616, 985, "TERMS_AND_CONDITIONS_PL", "ELECTRONIC_COMMUNICATION", app.generateRandomString(8));
                app.getUiboTicketHelper().gotoTakeTicket();
            }
        }

//        if(app.getUiboHelper().isElementPresent(By.xpath("//*[contains(text(), 'Video Call')]"))){
//            app.getUiboTicketHelper().delayTicketForOneMinute();
//            app.getUiboTicketHelper().gotoTakeTicket();
//        }

//        for(int i = 0; i < 3; i++) {
//            if (app.getUiboHelper().isElementPresent(By.xpath("//*[contains(text(), 'FDD - check client')]"))) {
//                app.getUiboTicketHelper().delayTicketForOneMinute();
//                app.getUiboTicketHelper().gotoTakeTicket();
//            }
//        }

        if(app.getUiboHelper().isElementPresent(By.xpath("//*[contains(text(), 'SDD - check client')]"))){
            app.getUiboTicketHelper().escalateToCBOSuccessfully("AQA", "");


        } else {
            System.out.println("actualTicketType: " + actualTicketType);
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
            login_registrationHelper.dipocketRegistration(616, 985, "TERMS_AND_CONDITIONS_PL", "ELECTRONIC_COMMUNICATION", app.generateRandomString(8));
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
                login_registrationHelper.dipocketRegistration(616, 985, "TERMS_AND_CONDITIONS_PL", "ELECTRONIC_COMMUNICATION", app.generateRandomString(8));
                app.getUiboTicketHelper().gotoTakeTicket();
            }
        }

//        if(app.getUiboHelper().isElementPresent(By.xpath("//*[contains(text(), 'Video Call')]"))){
//            app.getUiboTicketHelper().delayTicketForOneMinute();
//            app.getUiboTicketHelper().gotoTakeTicket();
//        }
//
//        for(int i = 0; i < 3; i++) {
//            if (app.getUiboHelper().isElementPresent(By.xpath("//*[contains(text(), 'FDD - check client')]"))) {
//                app.getUiboTicketHelper().delayTicketForOneMinute();
//                app.getUiboTicketHelper().gotoTakeTicket();
//            }
//        }

        if(app.getUiboHelper().isElementPresent(By.xpath("//*[contains(text(), 'SDD - check client')]"))){
            app.getUiboTicketHelper().verifyTheUserChangedHisMindAboutEscalateToCBO();
        } else {
            System.out.println("actualTicketType: " + actualTicketType);
            Assert.fail("There is no sdd ticket");
        }
    }

    @Test
    public void testTheUserNeedsToEscalateToCBOTicketWithReason() throws InterruptedException, SQLException, ClassNotFoundException {
        app.getUiboHelper().gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        app.getUiboTicketHelper().gotoTakeTicketWithReg();

        if(app.getUiboHelper().findElements(By.id("takeTicketContent")).size() == 0){
            Login_RegistrationHelper login_registrationHelper = new Login_RegistrationHelper();
            login_registrationHelper.dipocketRegistration(616, 985, "TERMS_AND_CONDITIONS_PL", "ELECTRONIC_COMMUNICATION", app.generateRandomString(8));
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
                login_registrationHelper.dipocketRegistration(616, 985, "TERMS_AND_CONDITIONS_PL", "ELECTRONIC_COMMUNICATION", app.generateRandomString(8));
                app.getUiboTicketHelper().gotoTakeTicket();
            }
        }

//        if(app.getUiboHelper().isElementPresent(By.xpath("//*[contains(text(), 'Video Call')]"))){
//            app.getUiboTicketHelper().delayTicketForOneMinute();
//            app.getUiboTicketHelper().gotoTakeTicket();
//        }
//
//        for(int i = 0; i < 3; i++) {
//            if (app.getUiboHelper().isElementPresent(By.xpath("//*[contains(text(), 'FDD - check client')]"))) {
//                app.getUiboTicketHelper().delayTicketForOneMinute();
//                app.getUiboTicketHelper().gotoTakeTicket();
//            }
//        }

        if(app.getUiboHelper().isElementPresent(By.xpath("//*[contains(text(), 'SDD - check client')]"))){
            app.getUiboTicketHelper().escalateToCBOSuccessfully("AQA", "test");


        } else {
            System.out.println("actualTicketType: " + actualTicketType);
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
            login_registrationHelper.dipocketRegistration(616, 985, "TERMS_AND_CONDITIONS_PL", "ELECTRONIC_COMMUNICATION", app.generateRandomString(8));
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
                login_registrationHelper.dipocketRegistration(616, 985, "TERMS_AND_CONDITIONS_PL", "ELECTRONIC_COMMUNICATION", app.generateRandomString(8));
                app.getUiboTicketHelper().gotoTakeTicket();
            }
        }

//        if(app.getUiboHelper().isElementPresent(By.xpath("//*[contains(text(), 'Video Call')]"))){
//            app.getUiboTicketHelper().delayTicketForOneMinute();
//            app.getUiboTicketHelper().gotoTakeTicket();
//        }
//
//        for(int i = 0; i < 3; i++) {
//            if (app.getUiboHelper().isElementPresent(By.xpath("//*[contains(text(), 'FDD - check client')]"))) {
//                app.getUiboTicketHelper().delayTicketForOneMinute();
//                app.getUiboTicketHelper().gotoTakeTicket();
//            }
//        }

        if(app.getUiboHelper().isElementPresent(By.xpath("//*[contains(text(), 'SDD - check client')]"))){
            app.getUiboTicketHelper().verifyTheUserNeedsToEscalateToCBOTicketTriesToEscalateWithoutChoosingAssignTo();
        }
    }
}