package tests.uiTests.bo.boTicket;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static appmanager.HelperBase.prop;

public class TheUserNeedsToReassignTheTicketsToAnotherBOUserTest extends UITestBase {
    //String clientId2 = app.homePageLoginId;
    String clientId2 = "30457";
    String phone2 = "380980316499";
    String actualTicketType = null;
    String state = null;
    String clientId = null;

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
            app.getLogin_registrationHelper().dipocketRegistration(616, 985, "TERMS_AND_CONDITIONS_PL", "ELECTRONIC_COMMUNICATION", app.generateRandomString(8), "715611173985", prop.getProperty("mobile.registration.phoneNumber"), prop.getProperty("mobile.registration.email"), "dev");
            app.getUiboTicketHelper().gotoTakeTicket();
        }

        for(int i = 0; i < 15; i++) {
            actualTicketType = app.getUiboTicketHelper().getActualTicketType();
            state = app.getUiboTicketHelper().getActualTicketState();
            if(actualTicketType.contains("SDD - check client")){
                break;
            }

            if(actualTicketType.equals("SDD - check client's data") && state.equals("State:  Blocked")){
                app.getUiboTicketHelper().editAndSaveSDDTicket("M", "", "", "", "");
                app.getUiboTicketHelper().approveTicketSuccessfully();
                app.getUiboTicketHelper().gotoTakeTicketWithReg();

                if(app.getUiboHelper().findElements(By.id("takeTicketContent")).size() == 0){
                    app.getLogin_registrationHelper().dipocketRegistration(616, 985, "TERMS_AND_CONDITIONS_PL", "ELECTRONIC_COMMUNICATION", app.generateRandomString(8), "715611173985", prop.getProperty("mobile.registration.phoneNumber"), prop.getProperty("mobile.registration.email"), "dev");
                    app.getUiboTicketHelper().gotoTakeTicket();
                    clientId = app.getUiboTicketHelper().initFDDTicketDisplain(prop.getProperty("mobile.registration.phoneNumber"), "M");
                }
                continue;
            }

            if (!actualTicketType.contains("SDD - check client")) {
                app.getUiboTicketHelper().delayTicketForSeveralMinutes();
                app.getUiboTicketHelper().gotoTakeTicketWithReg();
            }

            if(app.getUiboHelper().findElements(By.id("takeTicketContent")).size() == 0){
                app.getLogin_registrationHelper().dipocketRegistration(616, 985, "TERMS_AND_CONDITIONS_PL", "ELECTRONIC_COMMUNICATION", app.generateRandomString(8), "715611173985", prop.getProperty("mobile.registration.phoneNumber"), prop.getProperty("mobile.registration.email"), "dev");
                app.getUiboTicketHelper().gotoTakeTicket();
            }
        }

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
            app.getLogin_registrationHelper().dipocketRegistration(616, 985, "TERMS_AND_CONDITIONS_PL", "ELECTRONIC_COMMUNICATION", app.generateRandomString(8), "715611173985", prop.getProperty("mobile.registration.phoneNumber"), prop.getProperty("mobile.registration.email"), "dev");
            app.getUiboTicketHelper().gotoTakeTicket();
            app.getUiboTicketHelper().initFDDTicketDisplain(prop.getProperty("mobile.registration.phoneNumber"), "M");
        }

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
                app.getLogin_registrationHelper().dipocketRegistration(616, 985, "TERMS_AND_CONDITIONS_PL", "ELECTRONIC_COMMUNICATION", app.generateRandomString(8), "715611173985", prop.getProperty("mobile.registration.phoneNumber"), prop.getProperty("mobile.registration.email"), "dev");
                app.getUiboTicketHelper().gotoTakeTicket();
            }
        }

        if (app.getUiboHelper().isElementPresent(By.xpath("//*[contains(text(), 'FDD - check client')]"))) {
            app.getUiboTicketHelper().verifyTheUserChangedHisMindAboutReassignTheTicketToAnotherBOUser();
            app.getUiboTicketHelper().reassignTicketSuccessfully("BOAUTOTEST", "test");
        }
    }

    @Test
    public void testTheUserNeedsToReassignTheSelfieChangeTicketToAnotherBOUser_TheUserChangedHisMindAboutReassignTheSelfieChangeTicketToAnotherBOUser() throws InterruptedException, SQLException, ClassNotFoundException {
        app.getUiboHelper().gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);

        app.getUiboTicketHelper().gotoClientPageAndUpdateSelfies(clientId2,"files/bo/images/self.jpg");
        app.getUiboHelper().gotoHomePageWithBOUser();
        app.getUiboTicketHelper().gotoTakeTicketWithReg();

        for(int i = 0; i < 12; i++) {
            actualTicketType = app.getUiboTicketHelper().getActualTicketType();
            state = app.getUiboTicketHelper().getActualTicketState();
            if(actualTicketType.equals("Update Selfie")){
                break;
            }

            if(actualTicketType.equals("SDD - check client's data") && state.equals("State:  Blocked")){
                app.getUiboTicketHelper().editAndSaveSDDTicket("M", "", "", "", "");
                app.getUiboTicketHelper().approveTicketSuccessfully();
                app.getUiboTicketHelper().gotoTakeTicketWithReg();

                if(app.getUiboHelper().findElements(By.id("takeTicketContent")).size() == 0){
                    app.getLogin_registrationHelper().dipocketRegistration(616, 985, "TERMS_AND_CONDITIONS_PL", "ELECTRONIC_COMMUNICATION", app.generateRandomString(8), "715611173985", prop.getProperty("mobile.registration.phoneNumber"), prop.getProperty("mobile.registration.email"), "dev");
                    app.getUiboTicketHelper().gotoTakeTicket();
                    clientId = app.getUiboTicketHelper().initFDDTicketDisplain(prop.getProperty("mobile.registration.phoneNumber"), "M");
                }
                continue;
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

        app.getUiboTicketHelper().gotoClientPageAndUpdateDocs(clientId2,"files/bo/images/self.jpg", doc);
        app.getUiboHelper().gotoHomePageWithBOUser();
        app.getUiboTicketHelper().gotoTakeTicketWithReg();

        for(int i = 0; i < 12; i++) {
            actualTicketType = app.getUiboTicketHelper().getActualTicketType();
            state = app.getUiboTicketHelper().getActualTicketState();
            if(actualTicketType.equals("Update document")){
                break;
            }

            if(actualTicketType.equals("SDD - check client's data") && state.equals("State:  Blocked")){
                app.getUiboTicketHelper().editAndSaveSDDTicket("M", "", "", "", "");
                app.getUiboTicketHelper().approveTicketSuccessfully();
                app.getUiboTicketHelper().gotoTakeTicketWithReg();

                if(app.getUiboHelper().findElements(By.id("takeTicketContent")).size() == 0){
                    app.getLogin_registrationHelper().dipocketRegistration(616, 985, "TERMS_AND_CONDITIONS_PL", "ELECTRONIC_COMMUNICATION", app.generateRandomString(8), "715611173985", prop.getProperty("mobile.registration.phoneNumber"), prop.getProperty("mobile.registration.email"), "dev");
                    app.getUiboTicketHelper().gotoTakeTicket();
                    clientId = app.getUiboTicketHelper().initFDDTicketDisplain(prop.getProperty("mobile.registration.phoneNumber"), "M");
                }
                continue;
            }

            if (!actualTicketType.equals("Update document")) {
                app.getUiboTicketHelper().delayTicketForSeveralMinutes();
                app.getUiboTicketHelper().gotoTakeTicketWithReg();
            }

            if(app.getUiboHelper().findElements(By.id("takeTicketContent")).size() == 0){
                app.getLogin_registrationHelper().dipocketRegistration(616, 985, "TERMS_AND_CONDITIONS_PL", "ELECTRONIC_COMMUNICATION", app.generateRandomString(8), "715611173985", prop.getProperty("mobile.registration.phoneNumber"), prop.getProperty("mobile.registration.email"), "dev");
                app.getUiboTicketHelper().gotoTakeTicket();
            }
        }

        if (app.getUiboHelper().isElementPresent(By.xpath("//*[contains(text(), 'Update document')]"))) {
            app.getUiboTicketHelper().verifyTheUserChangedHisMindAboutReassignTheTicketToAnotherBOUser();
            app.getUiboTicketHelper().reassignTicketSuccessfully("BOAUTOTEST", "test");
        } else {
            System.out.println("actualTicketType: " + actualTicketType);
            Assert.fail("There are no Update document Ticket");
        }
    }
}