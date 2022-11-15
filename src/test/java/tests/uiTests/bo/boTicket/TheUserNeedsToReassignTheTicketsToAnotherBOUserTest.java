package tests.uiTests.bo.boTicket;

import appmanager.HelperBase;
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

public class TheUserNeedsToReassignTheTicketsToAnotherBOUserTest extends UITestBase {
    String clientId2 = app.homePageLoginId;
    String phone2 = "380980316499";
    String actualTicketType = null;

    @DataProvider
    public Iterator<Object[]> docs(){
        List<Object[]> list = new ArrayList<Object[]>();
        list.add(new Object[] {"PhotoID"});
        list.add(new Object[] {"Proof of address"});
        list.add(new Object[] {"PhotoID Back"});
        list.add(new Object[] {"Second ID"});
        return list.iterator();
    }

    @Test
    public void testTheUserNeedsToReassignTheSDDTicketToAnotherBOUser_TheUserChangedHisMindAboutReassignTheSDDTicket() throws InterruptedException, SQLException, ClassNotFoundException {
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
            if(actualTicketType.contains("SDD - check client")){
                break;
            }

            if (!actualTicketType.contains("SDD - check client")) {
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
            login_registrationHelper.dipocketRegistration(616, 985, "TERMS_AND_CONDITIONS_PL", "ELECTRONIC_COMMUNICATION", app.generateRandomString(8), "715611173985", HelperBase.prop.getProperty("mobile.registration.phoneNumber"), HelperBase.prop.getProperty("mobile.registration.email"));
            app.getUiboTicketHelper().gotoTakeTicket();
            app.getUiboTicketHelper().initFDDTicketDisplain();
        }

        actualTicketType = app.getUiboTicketHelper().getActualTicketType();

        for(int i = 0; i < 12; i++) {
            actualTicketType = app.getUiboTicketHelper().getActualTicketType();
            if(actualTicketType.contains("FDD - check client")){
                break;
            }

            if (!actualTicketType.contains("FDD - check client")) {
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
        //app.getUiboTicketHelper().skipSDDCheckClient();

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
                Login_RegistrationHelper login_registrationHelper = new Login_RegistrationHelper();
                login_registrationHelper.dipocketRegistration(616, 985, "TERMS_AND_CONDITIONS_PL", "ELECTRONIC_COMMUNICATION", app.generateRandomString(8), "715611173985", HelperBase.prop.getProperty("mobile.registration.phoneNumber"), HelperBase.prop.getProperty("mobile.registration.email"));
                app.getUiboTicketHelper().gotoTakeTicket();
            }
        }
        //app.getUiboTicketHelper().skipVideoCall(616, 985, "TERMS_AND_CONDITIONS_PL", "ELECTRONIC_COMMUNICATION");
        //app.getUiboTicketHelper().skipSDDCheckClient();

        if (app.getUiboHelper().isElementPresent(By.xpath("//*[contains(text(), 'Update Selfie')]"))) {
            app.getUiboTicketHelper().verifyTheUserChangedHisMindAboutReassignTheTicketToAnotherBOUser();
            app.getUiboTicketHelper().reassignTicketSuccessfully("BOAUTOTEST", "test");
        } else {
            System.out.println("actualTicketType: " + actualTicketType);
            Assert.fail("There are no Update Selfie Ticket");
        }
    }

    @Test(dataProvider = "docs")
    public void testTheUserNeedsToReassignPhotoIDChangeTicketToAnotherBOUser_TheUserChangedHisMindAboutReassignPhotoIDChangeTicketToAnotherBOUser(String doc) throws InterruptedException, SQLException, ClassNotFoundException {
        app.getUiboHelper().gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);

        app.getUiboTicketHelper().gotoClientPageAndUpdateDocs(clientId2, phone2, "files/bo/images/self.jpg", doc);
        app.getUiboHelper().gotoHomePageWithBOUser();
        app.getUiboTicketHelper().gotoTakeTicketWithReg();

        actualTicketType = app.getUiboTicketHelper().getActualTicketType();

        for(int i = 0; i < 12; i++) {
            actualTicketType = app.getUiboTicketHelper().getActualTicketType();
            if(actualTicketType.equals("Update document")){
                break;
            }

            if (!actualTicketType.equals("Update document")) {
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
        //app.getUiboTicketHelper().skipSDDCheckClient();

        if (app.getUiboHelper().isElementPresent(By.xpath("//*[contains(text(), 'Update document')]"))) {
            app.getUiboTicketHelper().verifyTheUserChangedHisMindAboutReassignTheTicketToAnotherBOUser();
            app.getUiboTicketHelper().reassignTicketSuccessfully("BOAUTOTEST", "test");
        } else {
            System.out.println("actualTicketType: " + actualTicketType);
            Assert.fail("There are no Update document Ticket");
        }
    }
}