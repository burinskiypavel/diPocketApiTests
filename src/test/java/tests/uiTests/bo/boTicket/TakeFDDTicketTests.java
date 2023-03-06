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

import static org.testng.Assert.assertTrue;

public class TakeFDDTicketTests extends UITestBase {
    String actualTicketType = null;
    String state = null;

    @DataProvider
    public Iterator<Object[]> rescanRequesteAndUploadDocs(){
        List<Object[]> list = new ArrayList<Object[]>();
        list.add(new Object[] {"PhotoID"});
        list.add(new Object[] {"Proof of address"});
        list.add(new Object[] {"PhotoID Back"});
        list.add(new Object[] {"Second ID"});
        return list.iterator();
    }

    @Test(priority = 1)
    public void testApproveFDDTiketWithDocumentTypePassport() throws InterruptedException, SQLException, ClassNotFoundException {
        app.getUiboHelper().gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        app.getUiboTicketHelper().gotoTakeTicketWithReg();

        if (app.getUiboHelper().findElements(By.id("takeTicketContent")).size() == 0) {
            Login_RegistrationHelper login_registrationHelper = new Login_RegistrationHelper();
            login_registrationHelper.dipocketRegistration(616, 985, "TERMS_AND_CONDITIONS_PL", "ELECTRONIC_COMMUNICATION", app.generateRandomString(8), "715611173985", HelperBase.prop.getProperty("mobile.registration.phoneNumber"), HelperBase.prop.getProperty("mobile.registration.email"), "dev");
            app.getUiboTicketHelper().gotoTakeTicket();
            app.getUiboTicketHelper().initFDDTicketDisplain();
        }

        actualTicketType = app.getUiboTicketHelper().getActualTicketType();

        for(int i = 0; i < 12; i++) {
            actualTicketType = app.getUiboTicketHelper().getActualTicketType();
            state = app.getUiboHelper().getText(By.xpath("//p[contains(text(), 'State:')]"));
            if(actualTicketType.equals("FDD - check client's data")){
                break;
            }

            if(actualTicketType.equals("SDD - check client's data") && state.equals("State: Blocked")){
                app.getUiboTicketHelper().editAndSaveSDDTicket("M", "", "", "", "");
                app.getUiboTicketHelper().approveTicketSuccessfully();
                app.getUiboTicketHelper().gotoTakeTicketWithReg();

                if(app.getUiboHelper().findElements(By.id("takeTicketContent")).size() == 0){
                    Login_RegistrationHelper login_registrationHelper = new Login_RegistrationHelper();
                    login_registrationHelper.dipocketRegistration(616, 985, "TERMS_AND_CONDITIONS_PL", "ELECTRONIC_COMMUNICATION", app.generateRandomString(8), "715611173985", HelperBase.prop.getProperty("mobile.registration.phoneNumber"), HelperBase.prop.getProperty("mobile.registration.email"), "dev");
                    app.getUiboTicketHelper().gotoTakeTicket();
                    app.getUiboTicketHelper().initFDDTicketDisplain();
                }
                continue;
            }

            if (!actualTicketType.equals("FDD - check client's data")) {
                app.getUiboTicketHelper().delayTicketForSeveralMinutes();
                app.getUiboTicketHelper().gotoTakeTicketWithReg();
            }

            if(app.getUiboHelper().findElements(By.id("takeTicketContent")).size() == 0){
                Login_RegistrationHelper login_registrationHelper = new Login_RegistrationHelper();
                login_registrationHelper.dipocketRegistration(616, 985, "TERMS_AND_CONDITIONS_PL", "ELECTRONIC_COMMUNICATION", app.generateRandomString(8), "715611173985", HelperBase.prop.getProperty("mobile.registration.phoneNumber"), HelperBase.prop.getProperty("mobile.registration.email"), "dev");
                app.getUiboTicketHelper().gotoTakeTicket();
                app.getUiboTicketHelper().initFDDTicketDisplain();
            }
        }
        //app.getUiboTicketHelper().skipVideoCall(616, 985, "TERMS_AND_CONDITIONS_PL", "ELECTRONIC_COMMUNICATION");
        //app.getUiboTicketHelper().skipSDDCheckClient();

        if (app.getUiboHelper().isElementPresent(By.xpath("//*[contains(text(), 'FDD - check client')]"))) {
            app.getUiboTicketHelper().editAndSaveFDDTicket("", "Passport", "CGH164279", "34999285098", "Poland");
            app.getUiboTicketHelper().approveTicketSuccessfully();
        }else {
            System.out.println("actualTicketType: " + actualTicketType);
            Assert.fail("There is no fdd ticket");
        }
    }

    @Test
    public void testApproveFDDTicketWithoutFillingInRequiredFields() throws InterruptedException, SQLException, ClassNotFoundException {
        app.getUiboHelper().gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        app.getUiboTicketHelper().gotoTakeTicketWithReg();

        if (app.getUiboHelper().findElements(By.id("takeTicketContent")).size() == 0) {
            Login_RegistrationHelper login_registrationHelper = new Login_RegistrationHelper();
            login_registrationHelper.dipocketRegistration(616, 985, "TERMS_AND_CONDITIONS_PL", "ELECTRONIC_COMMUNICATION", app.generateRandomString(8), "715611173985", HelperBase.prop.getProperty("mobile.registration.phoneNumber"), HelperBase.prop.getProperty("mobile.registration.email"), "dev");
            app.getUiboTicketHelper().gotoTakeTicket();
            app.getUiboTicketHelper().initFDDTicketDisplain();
        }

        actualTicketType = app.getUiboTicketHelper().getActualTicketType();

        for(int i = 0; i < 12; i++) {
            actualTicketType = app.getUiboTicketHelper().getActualTicketType();
            state = app.getUiboHelper().getText(By.xpath("//p[contains(text(), 'State:')]"));
            if(actualTicketType.equals("FDD - check client's data")){
                break;
            }

            if(actualTicketType.equals("SDD - check client's data") && state.equals("State: Blocked")){
                app.getUiboTicketHelper().editAndSaveSDDTicket("M", "", "", "", "");
                app.getUiboTicketHelper().approveTicketSuccessfully();
                app.getUiboTicketHelper().gotoTakeTicketWithReg();

                if(app.getUiboHelper().findElements(By.id("takeTicketContent")).size() == 0){
                    Login_RegistrationHelper login_registrationHelper = new Login_RegistrationHelper();
                    login_registrationHelper.dipocketRegistration(616, 985, "TERMS_AND_CONDITIONS_PL", "ELECTRONIC_COMMUNICATION", app.generateRandomString(8), "715611173985", HelperBase.prop.getProperty("mobile.registration.phoneNumber"), HelperBase.prop.getProperty("mobile.registration.email"), "dev");
                    app.getUiboTicketHelper().gotoTakeTicket();
                    app.getUiboTicketHelper().initFDDTicketDisplain();
                }
                continue;
            }

            if (!actualTicketType.equals("FDD - check client's data")) {
                app.getUiboTicketHelper().delayTicketForSeveralMinutes();
                app.getUiboTicketHelper().gotoTakeTicketWithReg();
            }

            if(app.getUiboHelper().findElements(By.id("takeTicketContent")).size() == 0){
                Login_RegistrationHelper login_registrationHelper = new Login_RegistrationHelper();
                login_registrationHelper.dipocketRegistration(616, 985, "TERMS_AND_CONDITIONS_PL", "ELECTRONIC_COMMUNICATION", app.generateRandomString(8), "715611173985", HelperBase.prop.getProperty("mobile.registration.phoneNumber"), HelperBase.prop.getProperty("mobile.registration.email"), "dev");
                app.getUiboTicketHelper().gotoTakeTicket();
                app.getUiboTicketHelper().initFDDTicketDisplain();
            }
        }
        //app.getUiboTicketHelper().skipVideoCall(616, 985, "TERMS_AND_CONDITIONS_PL", "ELECTRONIC_COMMUNICATION");
        //app.getUiboTicketHelper().skipSDDCheckClient();

        if (app.getUiboHelper().isElementPresent(By.xpath("//*[contains(text(), 'FDD - check client')]"))) {
            app.getUiboTicketHelper().unsuccessfulApprove("Impossible to approve ticket. Client already have documents. Fields “Document type“, “Doc serial number“, “Doc country of issue“ should be filled");
        }else {
            System.out.println("actualTicketType: " + actualTicketType);
            Assert.fail("There is no fdd ticket");
        }
    }

    @Test
    public void testApproveFDDTicketForNotAResidentOfPoland() throws InterruptedException, SQLException, ClassNotFoundException {
        app.getUiboHelper().gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        app.getUiboTicketHelper().gotoTakeTicketWithReg();

        if (app.getUiboHelper().findElements(By.id("takeTicketContent")).size() == 0) {
            Login_RegistrationHelper login_registrationHelper = new Login_RegistrationHelper();
            login_registrationHelper.dipocketRegistration(826, 826, "TERMS_AND_CONDITIONS_GB", "DATA_PROCESSING", app.generateRandomString(8), "715611173985", HelperBase.prop.getProperty("mobile.registration.phoneNumber"), HelperBase.prop.getProperty("mobile.registration.email"), "dev");
            app.getUiboTicketHelper().gotoTakeTicket();
            app.getUiboTicketHelper().initFDDTicketDisplain();
        }

        actualTicketType = app.getUiboTicketHelper().getActualTicketType();

        for(int i = 0; i < 12; i++) {
            actualTicketType = app.getUiboTicketHelper().getActualTicketType();
            state = app.getUiboHelper().getText(By.xpath("//p[contains(text(), 'State:')]"));
            if(actualTicketType.equals("FDD - check client's data")){
                break;
            }

            if(actualTicketType.equals("SDD - check client's data") && state.equals("State: Blocked")){
                app.getUiboTicketHelper().editAndSaveSDDTicket("M", "", "", "", "");
                app.getUiboTicketHelper().approveTicketSuccessfully();
                app.getUiboTicketHelper().gotoTakeTicketWithReg();

                if(app.getUiboHelper().findElements(By.id("takeTicketContent")).size() == 0){
                    Login_RegistrationHelper login_registrationHelper = new Login_RegistrationHelper();
                    login_registrationHelper.dipocketRegistration(616, 985, "TERMS_AND_CONDITIONS_PL", "ELECTRONIC_COMMUNICATION", app.generateRandomString(8), "715611173985", HelperBase.prop.getProperty("mobile.registration.phoneNumber"), HelperBase.prop.getProperty("mobile.registration.email"), "dev");
                    app.getUiboTicketHelper().gotoTakeTicket();
                    app.getUiboTicketHelper().initFDDTicketDisplain();
                }
                continue;
            }

            if (!actualTicketType.equals("FDD - check client's data")) {
                app.getUiboTicketHelper().delayTicketForSeveralMinutes();
                app.getUiboTicketHelper().gotoTakeTicketWithReg();
            }

            if(app.getUiboHelper().findElements(By.id("takeTicketContent")).size() == 0){
                Login_RegistrationHelper login_registrationHelper = new Login_RegistrationHelper();
                login_registrationHelper.dipocketRegistration(616, 985, "TERMS_AND_CONDITIONS_PL", "ELECTRONIC_COMMUNICATION", app.generateRandomString(8), "715611173985", HelperBase.prop.getProperty("mobile.registration.phoneNumber"), HelperBase.prop.getProperty("mobile.registration.email"), "dev");
                app.getUiboTicketHelper().gotoTakeTicket();
                app.getUiboTicketHelper().initFDDTicketDisplain();
            }
        }
        //app.getUiboTicketHelper().skipVideoCall(826, 826, "TERMS_AND_CONDITIONS_GB", "DATA_PROCESSING");
        //app.getUiboTicketHelper().skipSDDCheckClient();

        if (app.getUiboHelper().isElementPresent(By.xpath("//*[contains(text(), 'FDD - check client')]"))) {
            app.getUiboTicketHelper().editAndSaveFDDTicket("", "National identification number", "11111111111", "", "United Kingdom");
            app.getUiboTicketHelper().approveTicketSuccessfully();
        }else {
            System.out.println("actualTicketType: " + actualTicketType);
            Assert.fail("There is no fdd ticket");
        }
    }

    @Test(enabled = false)//bug DEV-3437
    public void testApproveFDDTicketWithoutFillingInThePESELFieldForResidentsOfPoland() throws InterruptedException, SQLException, ClassNotFoundException {
        app.getUiboHelper().gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        app.getUiboTicketHelper().gotoTakeTicketWithReg();

        if (app.getUiboHelper().findElements(By.id("takeTicketContent")).size() == 0) {
            Login_RegistrationHelper login_registrationHelper = new Login_RegistrationHelper();
            login_registrationHelper.dipocketRegistration(616, 985, "TERMS_AND_CONDITIONS_PL", "ELECTRONIC_COMMUNICATION", app.generateRandomString(8), "715611173985", HelperBase.prop.getProperty("mobile.registration.phoneNumber"), HelperBase.prop.getProperty("mobile.registration.email"), "dev");
            app.getUiboTicketHelper().gotoTakeTicket();
            app.getUiboTicketHelper().initFDDTicketDisplain();
        }

        actualTicketType = app.getUiboTicketHelper().getActualTicketType();

        for(int i = 0; i < 12; i++) {
            actualTicketType = app.getUiboTicketHelper().getActualTicketType();
            state = app.getUiboHelper().getText(By.xpath("//p[contains(text(), 'State:')]"));
            if(actualTicketType.equals("FDD - check client's data")){
                break;
            }

            if(actualTicketType.equals("SDD - check client's data") && state.equals("State: Blocked")){
                app.getUiboTicketHelper().editAndSaveSDDTicket("M", "", "", "", "");
                app.getUiboTicketHelper().approveTicketSuccessfully();
                app.getUiboTicketHelper().gotoTakeTicketWithReg();

                if(app.getUiboHelper().findElements(By.id("takeTicketContent")).size() == 0){
                    Login_RegistrationHelper login_registrationHelper = new Login_RegistrationHelper();
                    login_registrationHelper.dipocketRegistration(616, 985, "TERMS_AND_CONDITIONS_PL", "ELECTRONIC_COMMUNICATION", app.generateRandomString(8), "715611173985", HelperBase.prop.getProperty("mobile.registration.phoneNumber"), HelperBase.prop.getProperty("mobile.registration.email"), "dev");
                    app.getUiboTicketHelper().gotoTakeTicket();
                    app.getUiboTicketHelper().initFDDTicketDisplain();
                }
                continue;
            }

            if (!actualTicketType.equals("FDD - check client's data")) {
                app.getUiboTicketHelper().delayTicketForSeveralMinutes();
                app.getUiboTicketHelper().gotoTakeTicketWithReg();
            }

            if(app.getUiboHelper().findElements(By.id("takeTicketContent")).size() == 0){
                Login_RegistrationHelper login_registrationHelper = new Login_RegistrationHelper();
                login_registrationHelper.dipocketRegistration(616, 985, "TERMS_AND_CONDITIONS_PL", "ELECTRONIC_COMMUNICATION", app.generateRandomString(8), "715611173985", HelperBase.prop.getProperty("mobile.registration.phoneNumber"), HelperBase.prop.getProperty("mobile.registration.email"), "dev");
                app.getUiboTicketHelper().gotoTakeTicket();
                app.getUiboTicketHelper().initFDDTicketDisplain();
            }
        }
        //app.getUiboTicketHelper().skipVideoCall(616, 985, "TERMS_AND_CONDITIONS_PL", "ELECTRONIC_COMMUNICATION");
        //app.getUiboTicketHelper().skipSDDCheckClient();

        if (app.getUiboHelper().isElementPresent(By.xpath("//*[contains(text(), 'FDD - check client')]"))) {
            app.getUiboTicketHelper().editAndSaveFDDTicket("", "Passport", "11111111111", "", "Poland");
            app.getUiboTicketHelper().approveTicketSuccessfully();
        }
    }

    @Test
    public void testRescanRequestDocumentsDuringAnFDDCheck_TheUserChangedHisMindAboutRescanRequestDocuments() throws InterruptedException, SQLException, ClassNotFoundException {
        app.getUiboHelper().gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        app.getUiboTicketHelper().gotoTakeTicketWithReg();

        if (app.getUiboHelper().findElements(By.id("takeTicketContent")).size() == 0) {
            Login_RegistrationHelper login_registrationHelper = new Login_RegistrationHelper();
            login_registrationHelper.dipocketRegistration(616, 985, "TERMS_AND_CONDITIONS_PL", "ELECTRONIC_COMMUNICATION", app.generateRandomString(8), "715611173985", HelperBase.prop.getProperty("mobile.registration.phoneNumber"), HelperBase.prop.getProperty("mobile.registration.email"), "dev");
            app.getUiboTicketHelper().gotoTakeTicket();
            app.getUiboTicketHelper().initFDDTicketDisplain();
        }

        actualTicketType = app.getUiboTicketHelper().getActualTicketType();

        for(int i = 0; i < 12; i++) {
            actualTicketType = app.getUiboTicketHelper().getActualTicketType();
            state = app.getUiboHelper().getText(By.xpath("//p[contains(text(), 'State:')]"));
            if(actualTicketType.equals("FDD - check client's data")){
                break;
            }

            if(actualTicketType.equals("SDD - check client's data") && state.equals("State: Blocked")){
                app.getUiboTicketHelper().editAndSaveSDDTicket("M", "", "", "", "");
                app.getUiboTicketHelper().approveTicketSuccessfully();
                app.getUiboTicketHelper().gotoTakeTicketWithReg();

                if(app.getUiboHelper().findElements(By.id("takeTicketContent")).size() == 0){
                    Login_RegistrationHelper login_registrationHelper = new Login_RegistrationHelper();
                    login_registrationHelper.dipocketRegistration(616, 985, "TERMS_AND_CONDITIONS_PL", "ELECTRONIC_COMMUNICATION", app.generateRandomString(8), "715611173985", HelperBase.prop.getProperty("mobile.registration.phoneNumber"), HelperBase.prop.getProperty("mobile.registration.email"), "dev");
                    app.getUiboTicketHelper().gotoTakeTicket();
                    app.getUiboTicketHelper().initFDDTicketDisplain();
                }
                continue;
            }

            if (!actualTicketType.equals("FDD - check client's data")) {
                app.getUiboTicketHelper().delayTicketForSeveralMinutes();
                app.getUiboTicketHelper().gotoTakeTicketWithReg();
            }

            if(app.getUiboHelper().findElements(By.id("takeTicketContent")).size() == 0){
                Login_RegistrationHelper login_registrationHelper = new Login_RegistrationHelper();
                login_registrationHelper.dipocketRegistration(616, 985, "TERMS_AND_CONDITIONS_PL", "ELECTRONIC_COMMUNICATION", app.generateRandomString(8), "715611173985", HelperBase.prop.getProperty("mobile.registration.phoneNumber"), HelperBase.prop.getProperty("mobile.registration.email"), "dev");
                app.getUiboTicketHelper().gotoTakeTicket();
                app.getUiboTicketHelper().initFDDTicketDisplain();
            }
        }
        //app.getUiboTicketHelper().skipVideoCall(616, 985, "TERMS_AND_CONDITIONS_PL", "ELECTRONIC_COMMUNICATION");
        //app.getUiboTicketHelper().skipSDDCheckClient();

        if (app.getUiboHelper().isElementPresent(By.xpath("//*[contains(text(), 'FDD - check client')]"))) {
            app.getUiboTicketHelper().verifyUserChangedHisMindAboutRescanRequest();
            app.getUiboTicketHelper().rescanRequestSuccessfully(true, true, true, false);
        }

        app.getUiboHelper().waitFor(By.xpath("//*[contains(text(), 'Take Ticket')]"));
        assertTrue(app.getUiboHelper().areElementsPresent(new String[]{"//*[contains(text(), 'Take Ticket')]", "//*[contains(text(), 'Search')]"}));
    }

    @Test(enabled = false)
    public void testTheUserChangedHisMindAboutRescanRequestDocuments() throws InterruptedException, SQLException, ClassNotFoundException {
        app.getUiboHelper().gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        app.getUiboTicketHelper().gotoTakeTicketWithReg();

        if (app.getUiboHelper().findElements(By.id("takeTicketContent")).size() == 0) {
            Login_RegistrationHelper login_registrationHelper = new Login_RegistrationHelper();
            login_registrationHelper.dipocketRegistration(616, 985, "TERMS_AND_CONDITIONS_PL", "ELECTRONIC_COMMUNICATION", app.generateRandomString(8), "715611173985", HelperBase.prop.getProperty("mobile.registration.phoneNumber"), HelperBase.prop.getProperty("mobile.registration.email"), "dev");
            app.getUiboTicketHelper().gotoTakeTicket();
            app.getUiboTicketHelper().initFDDTicketDisplain();
        }

        app.getUiboTicketHelper().skipVideoCall(616, 985, "TERMS_AND_CONDITIONS_PL", "ELECTRONIC_COMMUNICATION");
        app.getUiboTicketHelper().skipSDDCheckClient();

        if (app.getUiboHelper().isElementPresent(By.xpath("//*[contains(text(), 'FDD - check client')]"))) {
            app.getUiboTicketHelper().verifyUserChangedHisMindAboutRescanRequest();
        }
    }

    @Test(dataProvider = "rescanRequesteAndUploadDocs")
    public void testRescanRequesteAndUploadDocs(String document) throws InterruptedException, SQLException, ClassNotFoundException {
        String clientId = null;
        app.getUiboHelper().gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        app.getUiboTicketHelper().gotoTakeTicketWithReg();

        if (app.getUiboHelper().findElements(By.id("takeTicketContent")).size() == 0) {
            Login_RegistrationHelper login_registrationHelper = new Login_RegistrationHelper();
            login_registrationHelper.dipocketRegistration(616, 985, "TERMS_AND_CONDITIONS_PL", "ELECTRONIC_COMMUNICATION", app.generateRandomString(8), "715611173985", HelperBase.prop.getProperty("mobile.registration.phoneNumber"), HelperBase.prop.getProperty("mobile.registration.email"), "dev");
            app.getUiboTicketHelper().gotoTakeTicket();
            clientId = app.getUiboTicketHelper().initFDDTicketDisplainWithSecondID();
        }

        actualTicketType = app.getUiboTicketHelper().getActualTicketType();

        for(int i = 0; i < 12; i++) {
            actualTicketType = app.getUiboTicketHelper().getActualTicketType();
            state = app.getUiboHelper().getText(By.xpath("//p[contains(text(), 'State:')]"));
            if(actualTicketType.equals("FDD - check client's data")){
                break;
            }

            if(actualTicketType.equals("SDD - check client's data") && state.equals("State: Blocked")){
                app.getUiboTicketHelper().editAndSaveSDDTicket("M", "", "", "", "");
                app.getUiboTicketHelper().approveTicketSuccessfully();
                app.getUiboTicketHelper().gotoTakeTicketWithReg();

                if(app.getUiboHelper().findElements(By.id("takeTicketContent")).size() == 0){
                    Login_RegistrationHelper login_registrationHelper = new Login_RegistrationHelper();
                    login_registrationHelper.dipocketRegistration(616, 985, "TERMS_AND_CONDITIONS_PL", "ELECTRONIC_COMMUNICATION", app.generateRandomString(8), "715611173985", HelperBase.prop.getProperty("mobile.registration.phoneNumber"), HelperBase.prop.getProperty("mobile.registration.email"), "dev");
                    app.getUiboTicketHelper().gotoTakeTicket();
                    clientId = app.getUiboTicketHelper().initFDDTicketDisplain();
                }
                continue;
            }

            if (!actualTicketType.equals("FDD - check client's data")) {
                app.getUiboTicketHelper().delayTicketForSeveralMinutes();
                app.getUiboTicketHelper().gotoTakeTicketWithReg();
            }

            if(app.getUiboHelper().findElements(By.id("takeTicketContent")).size() == 0){
                Login_RegistrationHelper login_registrationHelper = new Login_RegistrationHelper();
                login_registrationHelper.dipocketRegistration(616, 985, "TERMS_AND_CONDITIONS_PL", "ELECTRONIC_COMMUNICATION", app.generateRandomString(8), "715611173985", HelperBase.prop.getProperty("mobile.registration.phoneNumber"), HelperBase.prop.getProperty("mobile.registration.email"), "dev");
                app.getUiboTicketHelper().gotoTakeTicket();
                clientId = app.getUiboTicketHelper().initFDDTicketDisplain();
            }
        }
        //app.getUiboTicketHelper().skipVideoCall(616, 985, "TERMS_AND_CONDITIONS_PL", "ELECTRONIC_COMMUNICATION");
        //app.getUiboTicketHelper().skipSDDCheckClient();

        if (app.getUiboHelper().isElementPresent(By.xpath("//*[contains(text(), 'FDD - check client')]"))) {

            if(document.equals("PhotoID")) {
                app.getUiboTicketHelper().rescanRequestSuccessfully(true, false, false, false);
            }
            if(document.equals("Proof of address")) {
                app.getUiboTicketHelper().rescanRequestSuccessfully(false, true, false, false);
            }
            if(document.equals("PhotoID Back")) {
                app.getUiboTicketHelper().rescanRequestSuccessfully(false, false, true, false);
            }
            if(document.equals("Second ID")) {
                app.getUiboTicketHelper().rescanRequestSuccessfully(false, false, false, true);
            }
        }

        app.getUiboHelper().waitFor(By.xpath("//*[contains(text(), 'Take Ticket')]"));
        app.getUiboTicketHelper().uploadDoc(clientId, "380685448615", document, "files/bo/images/self.jpg");

        app.getUiboTicketHelper().click(By.xpath("//p-button[@ng-reflect-label='Home']"));
        app.getUiboTicketHelper().waitFor(By.cssSelector("div[ng-reflect-router-link='take_ticket']"));
        app.getUiboTicketHelper().gotoTakeTicketWithReg();

        app.getUiboTicketHelper().editAndSaveFDDTicket("", "Passport", "11111111111", "123456789", "Poland");
        app.getUiboTicketHelper().approveTicketSuccessfully();
    }
}