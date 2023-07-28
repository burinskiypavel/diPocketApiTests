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
import static org.testng.Assert.assertTrue;

public class TakeFDDTicketTests extends UITestBase {
    String actualTicketType = null;
    String state = null;
    String ddState = null;
    String clientId = null;
    int unitedKingdomCountryId = 826;
    String phone = app.mobile_registration_phoneNumber;

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

        actualTicketType = app.getUiboTicketHelper().takeFDDTicket(616, 985, "TERMS_AND_CONDITIONS_PL", "ELECTRONIC_COMMUNICATION", phone);

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

        actualTicketType = app.getUiboTicketHelper().takeFDDTicket(616, 985, "TERMS_AND_CONDITIONS_PL", "ELECTRONIC_COMMUNICATION", phone);

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

        actualTicketType = app.getUiboTicketHelper().takeFDDTicket(unitedKingdomCountryId, unitedKingdomCountryId, "TERMS_AND_CONDITIONS_GB", "DATA_PROCESSING", phone);

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
            app.getLogin_registrationHelper().dipocketRegistration(616, 985, "TERMS_AND_CONDITIONS_PL", "ELECTRONIC_COMMUNICATION", app.generateRandomString(8), "715611173985", app.mobile_registration_phoneNumber, prop.getProperty("mobile.registration.email"), "dev");
            app.getUiboTicketHelper().gotoTakeTicket();
            app.getUiboTicketHelper().initFDDTicketDisplain(app.mobile_registration_phoneNumber, "M");
        }

        actualTicketType = app.getUiboTicketHelper().getActualTicketType();

        for(int i = 0; i < 12; i++) {
            actualTicketType = app.getUiboTicketHelper().getActualTicketType();
            state = app.getUiboHelper().getText(By.xpath("//p[contains(text(), 'State:')]"));
            if(actualTicketType.equals("FDD - check client's data")){
                break;
            }

            if(actualTicketType.equals("SDD - check client's data") && state.equals("State:  Blocked")){
                app.getUiboTicketHelper().editAndSaveSDDTicket("M", "", "", "", "");
                app.getUiboTicketHelper().approveTicketSuccessfully();
                app.getUiboTicketHelper().gotoTakeTicketWithReg();

                if(app.getUiboHelper().findElements(By.id("takeTicketContent")).size() == 0){
                    app.getLogin_registrationHelper().dipocketRegistration(616, 985, "TERMS_AND_CONDITIONS_PL", "ELECTRONIC_COMMUNICATION", app.generateRandomString(8), "715611173985", app.mobile_registration_phoneNumber, prop.getProperty("mobile.registration.email"), "dev");
                    app.getUiboTicketHelper().gotoTakeTicket();
                    app.getUiboTicketHelper().initFDDTicketDisplain(app.mobile_registration_phoneNumber, "M");
                }
                continue;
            }

            if (!actualTicketType.equals("FDD - check client's data")) {
                app.getUiboTicketHelper().delayTicketForSeveralMinutes();
                app.getUiboTicketHelper().gotoTakeTicketWithReg();
            }

            if(app.getUiboHelper().findElements(By.id("takeTicketContent")).size() == 0){
                app.getLogin_registrationHelper().dipocketRegistration(616, 985, "TERMS_AND_CONDITIONS_PL", "ELECTRONIC_COMMUNICATION", app.generateRandomString(8), "715611173985", app.mobile_registration_phoneNumber, prop.getProperty("mobile.registration.email"), "dev");
                app.getUiboTicketHelper().gotoTakeTicket();
                app.getUiboTicketHelper().initFDDTicketDisplain(app.mobile_registration_phoneNumber, "M");
            }
        }

        if (app.getUiboHelper().isElementPresent(By.xpath("//*[contains(text(), 'FDD - check client')]"))) {
            app.getUiboTicketHelper().editAndSaveFDDTicket("", "Passport", "11111111111", "", "Poland");
            app.getUiboTicketHelper().approveTicketSuccessfully();
        }
    }

    @Test
    public void testRescanRequestDocumentsDuringAndFDDCheck_TheUserChangedHisMindAboutRescanRequestDocuments() throws InterruptedException, SQLException, ClassNotFoundException {
        app.getUiboHelper().gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        app.getUiboTicketHelper().gotoTakeTicketWithReg();

        app.getUiboTicketHelper().takeFDDTicket(616, 985, "TERMS_AND_CONDITIONS_PL", "ELECTRONIC_COMMUNICATION", phone);

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
            app.getLogin_registrationHelper().dipocketRegistration(616, 985, "TERMS_AND_CONDITIONS_PL", "ELECTRONIC_COMMUNICATION", app.generateRandomString(8), "715611173985", app.mobile_registration_phoneNumber, prop.getProperty("mobile.registration.email"), "dev");
            app.getUiboTicketHelper().gotoTakeTicket();
            app.getUiboTicketHelper().initFDDTicketDisplain(app.mobile_registration_phoneNumber, "M");
        }

        app.getUiboTicketHelper().skipVideoCall(616, 985, "TERMS_AND_CONDITIONS_PL", "ELECTRONIC_COMMUNICATION");
        app.getUiboTicketHelper().skipSDDCheckClient();

        if (app.getUiboHelper().isElementPresent(By.xpath("//*[contains(text(), 'FDD - check client')]"))) {
            app.getUiboTicketHelper().verifyUserChangedHisMindAboutRescanRequest();
        }
    }

    @Test(dataProvider = "rescanRequesteAndUploadDocs")
    public void testRescanRequesteAndUploadDocs(String document) throws InterruptedException, SQLException, ClassNotFoundException {
        app.getUiboHelper().gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        app.getUiboTicketHelper().gotoTakeTicketWithReg();

        clientId = app.getUiboTicketHelper().takeFDDTicketForRescanRequesteAndUploadDocs(phone);

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
        app.getUiboTicketHelper().uploadDoc(clientId, phone, document, "files/bo/images/self.jpg");

        app.getUiboHelper().gotoHomePageWithBOUser();
        app.getUiboTicketHelper().gotoTakeTicketWithReg();

        app.getUiboTicketHelper().editAndSaveFDDTicket("", "Passport", "11111111111", "123456789", "Poland");
        app.getUiboTicketHelper().approveTicketSuccessfully();
    }
}