package appmanager.ui.bo;

import appmanager.Login_RegistrationHelper;
import appmanager.UIHelperBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import padeObjects.bo.BOHomePage;
import padeObjects.bo.boTicket.TakeTicketEditDataPage;

import java.io.File;
import java.sql.SQLException;

public class UIBOTicketHelper extends UIHelperBase {

    public UIBOTicketHelper(WebDriver driver) {
        super(driver);
    }

    public void gotoTakeTicket() throws InterruptedException {
        click(By.cssSelector("div[ng-reflect-router-link='take_ticket']"));
        //BOHomePage boHomePage = new BOHomePage(driver);
        //boHomePage.gotoTakeTicket();
        waitFor(By.id("takeTicketContent"));
    }

    public void gotoTakeTicketWithReg() throws InterruptedException, SQLException, ClassNotFoundException {
        //click(By.cssSelector("div[ng-reflect-router-link='take_ticket']"));
        BOHomePage boHomePage = new BOHomePage(driver);
        boHomePage.gotoTakeTicket();
        Thread.sleep(1500);
        //waitFor(By.id("takeTicketContent"));
    }

    public void delayTicketForSeveralMinutes() throws InterruptedException {
        click(By.xpath("//app-button[@ng-reflect-label='Postpone']"));
        click(By.xpath("//button[@ng-reflect-icon='pi pi-calendar']"));
        click(By.cssSelector("div.p-minute-picker span.pi-chevron-up"));
        click(By.cssSelector("div.p-minute-picker span.pi-chevron-up"));
        click(By.cssSelector("div.p-minute-picker span.pi-chevron-up"));
        click(By.cssSelector("div.p-minute-picker span.pi-chevron-up"));
        click(By.cssSelector("div.p-minute-picker span.pi-chevron-up"));
        pressKeys(Keys.ENTER);
        Thread.sleep(1000);

        if(isElementPresent(By.xpath("//div[contains(text(), 'Ticket was successfully delayed')]"))){

        } else {
            clickWithJS(By.xpath("//app-postpone-modal //p-button[@ng-reflect-label='Postpone']"));
            waitFor(By.xpath("//div[contains(text(), 'Ticket was successfully delayed')]"));
        }
    }

    public void setGender(String dropdownItem) throws InterruptedException {
        TakeTicketEditDataPage takeTicketEditDataPage = new TakeTicketEditDataPage(driver);
        takeTicketEditDataPage.clickOnGenderDropDown();
        waitFor(By.cssSelector("p-dropdownitem li[aria-label='" + dropdownItem + "']"));
        try{
            click(By.cssSelector("p-dropdownitem li[aria-label='" + dropdownItem + "']"));

        } catch (org.openqa.selenium.StaleElementReferenceException ex) {

            click(By.cssSelector("p-dropdownitem li[aria-label='" + dropdownItem + "']"));
        }
    }

    public void setDocumentType(String dropdownItem) throws InterruptedException {
        TakeTicketEditDataPage takeTicketEditDataPage = new TakeTicketEditDataPage(driver);
        takeTicketEditDataPage.clickOnDocumentTypeDropDown();
        waitFor(By.cssSelector("p-dropdownitem li[aria-label='" + dropdownItem + "']"));
        try{
            click(By.cssSelector("p-dropdownitem li[aria-label='" + dropdownItem + "']"));

        } catch (org.openqa.selenium.StaleElementReferenceException ex) {

            click(By.cssSelector("p-dropdownitem li[aria-label='" + dropdownItem + "']"));
        }
    }

    public void setDocSerialNumber(String text){
        TakeTicketEditDataPage takeTicketEditDataPage = new TakeTicketEditDataPage(driver);
        takeTicketEditDataPage.setDocSerialNumber(text);
    }

    public void setIDCode(String text){
        TakeTicketEditDataPage takeTicketEditDataPage = new TakeTicketEditDataPage(driver);
        takeTicketEditDataPage.setIDCode(text);
    }

    public void setDocCountryOfIssue(String dropdownItem) throws InterruptedException {
        TakeTicketEditDataPage takeTicketEditDataPage = new TakeTicketEditDataPage(driver);
        takeTicketEditDataPage.clickDocCountryOfIssueDropDown();
        waitFor(By.cssSelector("p-dropdownitem li[aria-label='" + dropdownItem + "']"));
        try{
            click(By.cssSelector("p-dropdownitem li[aria-label='" + dropdownItem + "']"));

        } catch (org.openqa.selenium.StaleElementReferenceException ex) {

            click(By.cssSelector("p-dropdownitem li[aria-label='" + dropdownItem + "']"));
        }
    }

    public void editAndSaveSDDTicket(String gender, String documentType, String docSerialNumber, String pesel, String docCountryOfIssue) throws InterruptedException {
        click(By.xpath("//app-button[@ng-reflect-label='Edit']"));
        if(!gender.equals("")){
            selectFromDropDown(By.xpath("//app-select-async[@ng-reflect-name='gender']"), gender);
        }
        if(!documentType.equals("")){
            selectFromDropDown(By.xpath("//app-select-async[@ng-reflect-name='photoIdTypeId']"), documentType);
        }
        if(!docSerialNumber.equals("")){
            type(By.xpath("//app-input[@ng-reflect-name='photoIdNo'] //input"), docSerialNumber);
        }
        if(!pesel.equals("")){
            type(By.xpath("//app-input[@ng-reflect-name='identifyCode'] //input"), pesel);

        }
        if(!docCountryOfIssue.equals("")){
            selectFromDropDown(By.xpath("//app-select-async[@ng-reflect-name='photoIdCountryId']"), docCountryOfIssue);
        }
        Thread.sleep(1500);
        click(By.xpath("//p-button[@ng-reflect-label='Save']"));
        waitFor(By.xpath("//*[contains(text(), 'Client data updated successfully')]"));
    }

    public void editAndSaveFDDTicket(String gender, String documentType, String docSerialNumber, String pesel, String docCountryOfIssue) throws InterruptedException {
        click(By.xpath("//app-button[@ng-reflect-label='Edit']"));
        waitFor(By.cssSelector("p-dropdown[id*='_select_photoIdTypeId_']"));
        if(!gender.equals("")){
            selectFromDropDown(By.cssSelector("p-dropdown[id*='_select_gender_']"), gender);
        }
        if(!documentType.equals("")){
            selectFromDropDown(By.cssSelector("p-dropdown[id*='_select_photoIdTypeId_']"), documentType);
        }
        if(!docSerialNumber.equals("")){
            type(By.cssSelector("input[id*='_input_photoIdNo_']"), docSerialNumber);
        }
        if(!pesel.equals("")){
            type(By.cssSelector("input[id*='_input_identifyCode_']"), pesel);

        }
        if(!docCountryOfIssue.equals("")){
            selectFromDropDown(By.cssSelector("p-dropdown[id*='_select_photoIdCountryId_']"), docCountryOfIssue);
        }
        Thread.sleep(1500);
        click(By.xpath("//p-button[@ng-reflect-label='Save']"));
        waitFor(By.xpath("//*[contains(text(), 'Client data updated successfully')]"));
    }

    public void approveTicketSuccessfullyUpdateCardholder() {
        click(By.xpath("//app-button[@ng-reflect-label='Approve']"));
        waitFor(By.xpath("//*[contains(text(), 'Ticket was approved successfully')]"));
        waitForInvisibilityOfElement(By.xpath("//*[contains(text(), 'Ticket was approved successfully')]"));
    }

    public void approveTicketSuccessfully() {
        click(By.xpath("//app-button[@ng-reflect-label='Approve']"));
        waitFor(By.xpath("//*[contains(text(), 'Ticket approved successfully')]"));
        waitForInvisibilityOfElement(By.xpath("//*[contains(text(), 'Ticket approved successfully')]"));
    }

    public void approveTicketSuccessfullyDocsChange() {
        click(By.xpath("//app-button[@ng-reflect-label='Approve']"));
        waitFor(By.xpath("//*[contains(text(), 'Docs was approved successfully')]"));
        waitForInvisibilityOfElement(By.xpath("//*[contains(text(), 'Docs was approved successfully')]"));
    }

    public void unsuccessfulApprove(final String message) {
        click(By.xpath("//app-button[@ng-reflect-label='Approve']"));
        waitFor(By.xpath("//*[contains(text(), '" + message + "')]"));
    }

    public void escalateToCBOSuccessfully(String assignTo, String reason) throws InterruptedException {
        click(By.xpath("//app-button[@ng-reflect-label='Escalate to CBO']"));
        selectFromDropDown(By.xpath("//app-select-async[@ng-reflect-name='newUsername']"), assignTo);
        if(!reason.equals("")){
            type(By.xpath("//app-input[@ng-reflect-name='reason'] //input"), reason);

        }
        Thread.sleep(1300);
        click(By.xpath("//app-reassign-modal //p-button[@ng-reflect-label='Reassign']"));
        waitFor(By.xpath("//*[contains(text(), 'Ticket escalated successfully')]"));
    }

    public String initFDDTicketDisplain() throws InterruptedException, SQLException, ClassNotFoundException {
        String id = getText(By.xpath("//*[contains(text(), 'ID:')] //span"));
        editAndSaveSDDTicket("M", "", "", "", "");
        approveTicketSuccessfully();
        gotoSearchPage();
        search("id", id);
        goToClientPage("380685448615");

        click(By.xpath("//p-button[@ng-reflect-label='Upload docs']"));
        selectFromDropDown(By.xpath("//app-select-async[@ng-reflect-name='typeId']"), "PhotoID");
        File file = new File("files/bo/images/self.jpg");
        uploadFile(By.xpath("//input[@type='file']"), file.getAbsolutePath());
        Thread.sleep(1000);
        click(By.xpath("//p-button[@ng-reflect-label='Confirm']"));

        click(By.xpath("//p-button[@ng-reflect-label='Upload docs']"));
        selectFromDropDown(By.xpath("//app-select-async[@ng-reflect-name='typeId']"), "Proof of address");
        uploadFile(By.xpath("//input[@type='file']"), file.getAbsolutePath());
        Thread.sleep(1000);
        click(By.xpath("//p-button[@ng-reflect-label='Confirm']"));

        click(By.xpath("//p-button[@ng-reflect-label='Upload docs']"));
        selectFromDropDown(By.xpath("//app-select-async[@ng-reflect-name='typeId']"), "PhotoID Back");
        uploadFile(By.xpath("//input[@type='file']"), file.getAbsolutePath());
        Thread.sleep(1000);
        click(By.xpath("//p-button[@ng-reflect-label='Confirm']"));
        click(By.xpath("//p-button[@ng-reflect-label='Home']"));
        waitFor(By.cssSelector("div[ng-reflect-router-link='take_ticket']"));
        gotoTakeTicketWithReg();
        return id;
    }

    public String initFDDTicketDisplainWithSecondID() throws InterruptedException, SQLException, ClassNotFoundException {
        String id = getText(By.xpath("//*[contains(text(), 'ID:')] //span"));
        editAndSaveSDDTicket("M", "", "", "", "");
        approveTicketSuccessfully();
        gotoSearchPage();
        search("id", id);
        goToClientPage("380685448615");

        click(By.xpath("//p-button[@ng-reflect-label='Upload docs']"));
        selectFromDropDown(By.xpath("//app-select-async[@ng-reflect-name='typeId']"), "PhotoID");
        File file = new File("files/bo/images/self.jpg");
        uploadFile(By.xpath("//input[@type='file']"), file.getAbsolutePath());
        Thread.sleep(1000);
        click(By.xpath("//p-button[@ng-reflect-label='Confirm']"));

        click(By.xpath("//p-button[@ng-reflect-label='Upload docs']"));
        selectFromDropDown(By.xpath("//app-select-async[@ng-reflect-name='typeId']"), "Proof of address");
        uploadFile(By.xpath("//input[@type='file']"), file.getAbsolutePath());
        Thread.sleep(1000);
        click(By.xpath("//p-button[@ng-reflect-label='Confirm']"));

        click(By.xpath("//p-button[@ng-reflect-label='Upload docs']"));
        selectFromDropDown(By.xpath("//app-select-async[@ng-reflect-name='typeId']"), "PhotoID Back");
        uploadFile(By.xpath("//input[@type='file']"), file.getAbsolutePath());
        Thread.sleep(1000);
        click(By.xpath("//p-button[@ng-reflect-label='Confirm']"));

        click(By.xpath("//p-button[@ng-reflect-label='Upload docs']"));
        selectFromDropDown(By.xpath("//app-select-async[@ng-reflect-name='typeId']"), "Second ID");
        uploadFile(By.xpath("//input[@type='file']"), file.getAbsolutePath());
        Thread.sleep(1000);
        click(By.xpath("//p-button[@ng-reflect-label='Confirm']"));

        click(By.xpath("//p-button[@ng-reflect-label='Home']"));
        waitFor(By.cssSelector("div[ng-reflect-router-link='take_ticket']"));
        gotoTakeTicketWithReg();
        return id;
    }

    public void gotoSearchPage() {
        click(By.cssSelector("div[ng-reflect-router-link='search']"));
        waitFor(By.xpath("//*[contains(text(), 'Card')]"));
    }

    public void search(String by, String value) {
        waitFor(By.cssSelector("app-input-number[ng-reflect-name='" + by + "'] input.p-inputnumber-input"));
        type(By.cssSelector("app-input-number[ng-reflect-name='" + by + "'] input.p-inputnumber-input"), value);
        waitFor(By.cssSelector("td[ng-reflect-text='"+value+"']"));
    }

    public void goToClientPage(String phone) {
        click(By.cssSelector("td[ng-reflect-text='"+phone+"']"));
        waitFor(By.cssSelector("p.user-name"));
    }

    public void skipVideoCall(int countryId, int currencyId, String terms1, String terms2) throws InterruptedException, SQLException, ClassNotFoundException {
        if (isElementPresent(By.xpath("//*[contains(text(), 'Video Call')]"))) {
            delayTicketForSeveralMinutes();
            gotoTakeTicketWithReg();

            if (findElements(By.id("takeTicketContent")).size() == 0) {
                Login_RegistrationHelper login_registrationHelper = new Login_RegistrationHelper();
                login_registrationHelper.dipocketRegistration(countryId, currencyId, terms1, terms2, login_registrationHelper.generateRandomString(8), "715611173985");
                gotoTakeTicket();
                initFDDTicketDisplain();
            }
        }
    }

    public void skipSDDCheckClient() throws InterruptedException, SQLException, ClassNotFoundException {
        if(isElementPresent(By.xpath("//*[contains(text(), 'FDD - check client')]"))) {

        } else {
            for (int i = 0; i < 3; i++) {
                if (isElementPresent(By.xpath("//*[contains(text(), 'SDD - check client')]"))) {
                    delayTicketForSeveralMinutes();
                    gotoTakeTicketWithReg();
                }
            }
        }
    }

    public void skipFDDCheckClient() throws InterruptedException, SQLException, ClassNotFoundException {
        if(isElementPresent(By.xpath("//*[contains(text(), 'SDD - check client')]"))) {

        } else {
            for (int i = 0; i < 3; i++) {
                if (isElementPresent(By.xpath("//*[contains(text(), 'FDD - check client')]"))) {
                    delayTicketForSeveralMinutes();
                    gotoTakeTicketWithReg();
                }
            }
        }
    }

    public void rescanRequestSuccessfully(boolean id, boolean proofOfAddress, boolean backOfId, boolean secondId) throws InterruptedException {
        click(By.xpath("//app-button[@ng-reflect-label='Rescan request']"));
        if(id) {
            click(By.cssSelector("p-checkbox[ng-reflect-input-id='Id'"));
        }
        if(proofOfAddress){
            click(By.cssSelector("p-checkbox[ng-reflect-input-id='Proof of address'"));
        }
        if(backOfId){
            click(By.cssSelector("p-checkbox[ng-reflect-input-id='Back of id'"));
        }
        if(secondId){
            click(By.cssSelector("p-checkbox[ng-reflect-input-id='Proof of change in name'"));
        }
        Thread.sleep(700);
        click(By.xpath("//app-button[@label='Send']"));
        waitFor(By.xpath("//*[contains(text(), 'Docs asked successfully')]"));
    }

    public void uploadDoc(String ticketId, String phone, String doc, String path) throws InterruptedException {
        gotoSearchPage();

        search("id", ticketId);
        goToClientPage(phone);

        click(By.xpath("//p-button[@ng-reflect-label='Upload docs']"));
        selectFromDropDown(By.xpath("//app-select-async[@ng-reflect-name='typeId']"), doc);
        File file = new File(path);
        uploadFile(By.xpath("//input[@type='file']"), file.getAbsolutePath());
        Thread.sleep(1000);
        click(By.xpath("//p-button[@ng-reflect-label='Confirm']"));
    }

    public void gotoClientPageAndUpdateSelfies(String clientId, String phone, String path) throws InterruptedException {
        gotoSearchPage();
        search("id", clientId);
        goToClientPage(phone);

        click(By.xpath("//p-button[@ng-reflect-label='Upload selfies']"));
        File file = new File(path);

        uploadFile(By.cssSelector("app-upload-file-with-preview[ng-reflect-name='base64Selfie1'] input[type='file']"), file.getAbsolutePath());
        uploadFile(By.cssSelector("app-upload-file-with-preview[ng-reflect-name='base64Selfie2'] input[type='file']"), file.getAbsolutePath());
        Thread.sleep(700);
        click(By.xpath("//p-button[@ng-reflect-label='Confirm']"));
        waitFor(By.xpath("//*[contains(text(), 'Selfies were uploaded successfully')]"));
    }

    public void gotoClientPageAndUpdateDocs(String clientId, String phone, String path, String docItem) throws InterruptedException {
        gotoSearchPage();
        search("id", clientId);
        goToClientPage(phone);

        click(By.xpath("//p-button[@ng-reflect-label='Upload docs']"));

        selectFromDropDown(By.xpath("//app-select-async[@ng-reflect-name='typeId']"), docItem);
        File file = new File(path);

        uploadFile(By.cssSelector("input[type='file']"), file.getAbsolutePath());
        Thread.sleep(700);
        click(By.xpath("//p-button[@ng-reflect-label='Confirm']"));
        waitFor(By.xpath("//*[contains(text(), 'Docs were uploaded successfully')]"));
    }

    public void rejectTicketSuccessfully(String reason, final String message) throws InterruptedException {
        click(By.xpath("//app-button[@ng-reflect-label='Reject']"));
        type(By.xpath("//app-input[@ng-reflect-name='reason'] //input"), reason);
        Thread.sleep(700);
        click(By.xpath("//app-reject-modal //p-button[@ng-reflect-label='Reject']"));
        waitFor(By.xpath("//*[contains(text(), '" + message + "')]"));
    }

    public void verifyUserChangedHisMindAboutRejectionOfSelfieDocChangeTicket() {
        click(By.xpath("//app-button[@ng-reflect-label='Reject']"));
        closePopUp(By.cssSelector("span.p-dialog-header-close-icon"));
        waitForInvisibilityOfElement(By.cssSelector("div[role='dialog']"));
    }

    public void verifyUserChangedHisMindAboutRescanRequest() {
        click(By.xpath("//app-button[@ng-reflect-label='Rescan request']"));
        closePopUp(By.cssSelector("div.p-dialog-header-icons"));
        waitForInvisibilityOfElement(By.xpath("//div[@role='dialog']"));
    }

    public void askForSuccessfullySDD(boolean id, boolean proofOfAddress, boolean backOfId, boolean residencePermit) {
        click(By.xpath("//app-button[@ng-reflect-label='Ask for']"));
        if(id){
            clickCheckbox(By.xpath("//p-checkbox[@ng-reflect-input-id='Id']"));
        }
        if(proofOfAddress){
            clickCheckbox(By.xpath("//p-checkbox[@ng-reflect-input-id='Proof of address']"));
        }
        if(backOfId){
            clickCheckbox(By.xpath("//p-checkbox[@ng-reflect-input-id='Back of id']"));
        }
        if(residencePermit){
            clickCheckbox(By.xpath("//p-checkbox[@ng-reflect-input-id='Residence permit']"));
        }

        type(By.id("11"), "test");
        click(By.xpath("//app-button[@label='Send']"));

        waitFor(By.xpath("//*[contains(text(), 'Docs asked successfully')]"));
    }

    public void reassignTicketSuccessfully(String username, String reason) throws InterruptedException {
        click(By.xpath("//app-button[@ng-reflect-label='Reassign']"));
        waitFor(By.xpath("//app-reassign-modal //p-button[@ng-reflect-label='Reassign']"));
        selectFromDropDown(By.xpath("//app-select-async[@ng-reflect-name='newUsername']"), username);
        type(By.cssSelector("app-input[ng-reflect-name='reason'] input"), reason);
        Thread.sleep(700);
        click(By.xpath("//app-reassign-modal //p-button[@ng-reflect-label='Reassign']"));
        waitFor(By.xpath("//*[contains(text(), 'Ticket reassigned successfully')]"));
    }

    public void verifyTheUserChangedHisMindAboutReassignTheTicketToAnotherBOUser() {
        click(By.xpath("//app-button[@ng-reflect-label='Reassign']"));
        waitFor(By.xpath("//app-reassign-modal //p-button[@ng-reflect-label='Reassign']"));
        closePopUp(By.cssSelector("button.p-dialog-header-icon"));
        waitForInvisibilityOfElement(By.cssSelector("div[role='dialog']"));
    }

    public String getActualTicketType() {
        return getText(By.cssSelector("div.mb-3 h3.title"));
    }

    public void verifyTheUserChangedHisMindAboutEscalateToCBO() {
            click(By.xpath("//app-button[@ng-reflect-label='Escalate to CBO']"));
            waitFor(By.xpath("//app-reassign-modal //p-button[@ng-reflect-label='Reassign']"));
            closePopUp(By.cssSelector("div.p-dialog-header-icons"));
            waitForInvisibilityOfElement(By.xpath("//div[@role='dialog']"));
    }

    public void verifyTheUserNeedsToEscalateToCBOTicketTriesToEscalateWithoutChoosingAssignTo() {
        click(By.xpath("//app-button[@ng-reflect-label='Escalate to CBO']"));
        waitFor(By.xpath("//app-reassign-modal //p-button[@ng-reflect-label='Reassign']"));
        click(By.xpath("//app-reassign-modal //p-button[@ng-reflect-label='Reassign']"));
        waitFor(By.xpath("//*[contains(text(), 'Assign to is required ')]"));
    }
}