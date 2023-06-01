package appmanager.ui.bo;

import appmanager.HelperBase;
import appmanager.Login_RegistrationHelper;
import appmanager.UIHelperBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import padeObjects.bo.BOHomePage;
import padeObjects.bo.boClient.ClientPage;
import padeObjects.bo.boClient.UploadDocPage;
import padeObjects.bo.boClient.UploadSelfiesPage;
import padeObjects.bo.boTicket.*;
import padeObjects.bo.search.ClientSearchPage;

import java.io.File;
import java.sql.SQLException;

import static appmanager.HelperBase.prop;

public class UIBOTicketHelper extends UIHelperBase {
    String actualTicketType = null;
    String state = null;
    String clientId = null;
    String ddState = null;
    TakeTicketEditDataPage takeTicketEditDataPage = new TakeTicketEditDataPage(driver);
    TakeTicketPage takeTicketPage = new TakeTicketPage(driver);
    ClientSearchPage clientSearchPage = new ClientSearchPage(driver);
    BOHomePage boHomePage = new BOHomePage(driver);
    ClientPage clientPage = new ClientPage(driver);
    UploadDocPage uploadDocPage = new UploadDocPage(driver);
    RejectTicketPage rejectTicketPage = new RejectTicketPage(driver);
    PostponePage postponePage = new PostponePage(driver);
    ReassignPage reassignPage = new ReassignPage(driver);
    UploadSelfiesPage uploadSelfiesPage = new UploadSelfiesPage(driver);
    RescanRequestPage rescanRequestPage = new RescanRequestPage(driver);
    AskForPage askForPage = new AskForPage(driver);
    Login_RegistrationHelper login_registrationHelper = new Login_RegistrationHelper();

    public UIBOTicketHelper(WebDriver driver) {
        super(driver);
    }

    public void gotoTakeTicket() throws InterruptedException {
        //click(By.cssSelector("div[ng-reflect-router-link='take_ticket']"));
        //boHomePage.gotoTakeTicket();
        click(boHomePage.take_ticket);
        waitFor(By.cssSelector("app-take-ticket"));
    }

    public void gotoTakeTicketWithReg() throws InterruptedException {
        waitFor(By.cssSelector("div[ng-reflect-router-link='take_ticket']"));
        boHomePage.gotoTakeTicket();
        Thread.sleep(500);
        int count = 0;
        while(areElementsPresent(new String[]{"//*[contains(text(), 'Take Ticket')]"}) && count < 4){
            click(By.cssSelector("div[ng-reflect-router-link='take_ticket']"));
            Thread.sleep(3500);
            count++;
        }
        Thread.sleep(2000);
        //waitFor(By.id("takeTicketContent"));
    }

    public void delayTicketForSeveralMinutes() throws InterruptedException {
        waitFor(takeTicketPage.postponeBtn);
        click(takeTicketPage.postponeBtn);
        waitFor(postponePage.calendarBtn);
        click(postponePage.calendarBtn);
//        waitFor(postponePage.chevronUpMinuteBtn);
//        click(postponePage.chevronUpMinuteBtn);
//        click(postponePage.chevronUpMinuteBtn);
//        click(postponePage.chevronUpMinuteBtn);
//        click(postponePage.chevronUpMinuteBtn);
//        click(postponePage.chevronUpMinuteBtn);
//        click(postponePage.chevronUpMinuteBtn);
        waitFor(postponePage.chevronUpMounthBtn);
        click(postponePage.chevronUpMounthBtn);
        click(By.xpath("//td //*[contains(text(), '22')]"));
        Thread.sleep(1500);
        click(postponePage.postponeBtn);
        //click(postponePage.chevronUpHourBtn);
        //Thread.sleep(1000);
        //pressKeys(Keys.ENTER);
        //Thread.sleep(1000);

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
        waitFor(takeTicketPage.editBtn);
        click(takeTicketPage.editBtn);
        waitFor(takeTicketEditDataPage.saveBtn);
        if(!gender.equals("")){
            selectFromDropDown(takeTicketEditDataPage.genderDropDown, gender);
        }
        if(!documentType.equals("")){
            selectFromDropDown(takeTicketEditDataPage.documentTypeDropDown, documentType);
        }
        if(!docSerialNumber.equals("")){
            type(takeTicketEditDataPage.docSerialNumber, docSerialNumber);
        }
        if(!pesel.equals("")){
            type(takeTicketEditDataPage.pesel, pesel);
        }
        if(!docCountryOfIssue.equals("")){
            selectFromDropDown(takeTicketEditDataPage.docCountryOfIssueDropDown, docCountryOfIssue);
        }
        Thread.sleep(1500);
        click(takeTicketEditDataPage.saveBtn);
        waitFor(By.xpath("//*[contains(text(), 'Client data updated successfully')]"));
    }

    public void editAndSaveFDDTicket(String gender, String documentType, String docSerialNumber, String pesel, String docCountryOfIssue) throws InterruptedException {
        waitFor(takeTicketPage.editBtn);
        click(takeTicketPage.editBtn);
        waitFor(By.cssSelector("p-dropdown[id*='_select_photoIdTypeId_']"));
        if(!gender.equals("")){
            selectFromDropDown(takeTicketEditDataPage.genderDropDown, gender);
        }
        if(!documentType.equals("")){
            selectFromDropDown(takeTicketEditDataPage.documentTypeDropDown, documentType);
        }
        if(!docSerialNumber.equals("")){
            type(takeTicketEditDataPage.docSerialNumber, docSerialNumber);
        }
        if(!pesel.equals("")){
            type(takeTicketEditDataPage.pesel, pesel);
        }
        if(!docCountryOfIssue.equals("")){
            selectFromDropDown(takeTicketEditDataPage.docCountryOfIssueDropDown, docCountryOfIssue);
        }
        Thread.sleep(1500);
        click(takeTicketEditDataPage.saveBtn);
        waitFor(By.xpath("//*[contains(text(), 'Client data updated successfully')]"));
    }

    public void approveTicketSuccessfullyUpdateCardholder() {
        click(takeTicketPage.approveBtn);
        waitFor(By.xpath("//*[contains(text(), 'Ticket was approved successfully')]"));
    }

    public void approveTicketSuccessfully() {
        click(takeTicketPage.approveBtn);
        waitFor(By.xpath("//*[contains(text(), 'Ticket approved successfully')]"));
        //waitForInvisibilityOfElement(By.xpath("//*[contains(text(), 'Ticket approved successfully')]"));
    }

    public void approveTicketSuccessfullyDocsChange() {
        click(takeTicketPage.approveBtn);
        waitFor(By.xpath("//*[contains(text(), 'Docs was approved successfully')]"));
        //waitForInvisibilityOfElement(By.xpath("//*[contains(text(), 'Docs was approved successfully')]"));
    }

    public void unsuccessfulApprove(final String message) {
        waitFor(By.xpath("//app-button[@ng-reflect-label='Approve']"));
        click(takeTicketPage.approveBtn);
        waitFor(By.xpath("//*[contains(text(), '" + message + "')]"));
    }

    public void escalateToCBOSuccessfully(String assignTo, String reason) throws InterruptedException {
        click(takeTicketPage.escalateToCBOBtn);
        selectFromDropDown(By.xpath("//app-select-async[@ng-reflect-name='newUsername']"), assignTo);
        if(!reason.equals("")){
            type(By.xpath("//app-input[@ng-reflect-name='reason'] //input"), reason);

        }
        Thread.sleep(1300);
        click(By.xpath("//app-reassign-modal //p-button[@ng-reflect-label='Reassign']"));
        waitFor(By.xpath("//*[contains(text(), 'Ticket escalated successfully')]"));
    }

    public String initFDDTicketDisplain(String phone, String gender) throws InterruptedException, SQLException, ClassNotFoundException {
        waitFor(takeTicketPage.idField);
        String id = getActualTicketId();
        editAndSaveSDDTicket(gender, "", "", "", "");
        approveTicketSuccessfully();
        gotoSearchPage();
        search("id", id);
        goToClientPage(phone);
        uploadDoc("PhotoID", "files/bo/images/self.jpg");
        uploadDoc("Proof of address", "files/bo/images/self.jpg");
        uploadDoc("PhotoID Back", "files/bo/images/self.jpg");
        click(By.xpath("//p-button[@ng-reflect-label='Home']"));
        waitFor(By.cssSelector("div[ng-reflect-router-link='take_ticket']"));
        gotoTakeTicketWithReg();
        return id;
    }

    public void uploadDoc(String typeId, String pathToFile) throws InterruptedException {
        waitForElementToBeClickable(clientPage.uploadDocsBtn);
        click(clientPage.uploadDocsBtn);
        selectFromDropDown(uploadDocPage.typeIdDropDown, typeId);
        File file = new File(pathToFile);
        uploadFile(By.xpath("//input[@type='file']"), file.getAbsolutePath());
        Thread.sleep(1000);
        click(uploadDocPage.confirmBtn);
        waitFor(By.xpath("//*[contains(text(), 'Docs were uploaded successfully')]"));
        //waitForInvisibilityOfElement(By.xpath("//*[contains(text(), 'Docs were uploaded successfully')]"));
    }

    public String initFDDTicketDisplainWithSecondID(String phone, String gender) throws InterruptedException, SQLException, ClassNotFoundException {
        waitFor(takeTicketPage.idField);
        String id = getActualTicketId();
        editAndSaveSDDTicket(gender, "", "", "", "");
        approveTicketSuccessfully();
        gotoSearchPage();
        search("id", id);
        goToClientPage(phone);

        uploadDoc("PhotoID", "files/bo/images/self.jpg");
        uploadDoc("Proof of address", "files/bo/images/self.jpg");
        uploadDoc("PhotoID Back", "files/bo/images/self.jpg");
        uploadDoc("Second ID", "files/bo/images/self.jpg");

        click(By.xpath("//p-button[@ng-reflect-label='Home']"));
        waitFor(By.cssSelector("div[ng-reflect-router-link='take_ticket']"));
        gotoTakeTicketWithReg();
        return id;
    }

    public void gotoSearchPage() {
        waitFor(By.cssSelector("div[ng-reflect-router-link='search']"));
        click(By.cssSelector("div[ng-reflect-router-link='search']"));
        waitFor(By.xpath("//*[contains(text(), 'Card')]"));
    }

    public void search(String by, String value) {
        waitFor(By.cssSelector("input[id*='_input_"+by+"_']"));
        type(By.cssSelector("input[id*='_input_"+by+"_']"), value);
        waitFor(By.cssSelector("td span[ng-reflect-text='"+value+"']"));
    }

    public void goToClientPage(String item) {
        waitFor(By.cssSelector("td span[ng-reflect-text='"+item+"']"));
        click(By.cssSelector("td span[ng-reflect-text='"+item+"']"));
        waitFor(By.cssSelector("p.user-name"));
    }

    public void skipVideoCall(int countryId, int currencyId, String terms1, String terms2) throws InterruptedException, SQLException, ClassNotFoundException {
        if (isElementPresent(By.xpath("//*[contains(text(), 'Video Call')]"))) {
            delayTicketForSeveralMinutes();
            gotoTakeTicketWithReg();

            if (findElements(By.id("takeTicketContent")).size() == 0) {
                Login_RegistrationHelper login_registrationHelper = new Login_RegistrationHelper();
                login_registrationHelper.dipocketRegistration(countryId, currencyId, terms1, terms2, login_registrationHelper.generateRandomString(8), "715611173985", HelperBase.prop.getProperty("mobile.registration.phoneNumber"), HelperBase.prop.getProperty("mobile.registration.email"), "dev");
                gotoTakeTicket();
                initFDDTicketDisplain("380685448615", "M");
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
        waitFor(takeTicketPage.rescanRequestBtn);
        click(takeTicketPage.rescanRequestBtn);
        waitFor(rescanRequestPage.idCheckbox);
        waitFor(rescanRequestPage.sendBtn);
        if(id) {
            click(rescanRequestPage.idCheckbox);
        }
        if(proofOfAddress){
            click(rescanRequestPage.proofOfAddressCheckbox);
        }
        if(backOfId){
            click(rescanRequestPage.backOfIdCheckbox);
        }
        if(secondId){
            click(rescanRequestPage.proofOfChangeInNameCheckbox);
        }
        Thread.sleep(700);
        click(rescanRequestPage.sendBtn);
        waitFor(By.xpath("//*[contains(text(), 'Docs asked successfully')]"));
    }

    public void uploadDoc(String ticketId, String phone, String doc, String path) throws InterruptedException {
        gotoSearchPage();
        search("id", ticketId);
        goToClientPage(phone);
        uploadDoc(doc, path);
    }

    public void gotoClientPageAndUpdateSelfies(String clientId, String path) throws InterruptedException {
        gotoSearchPage();
        search("id", clientId);
        goToClientPage(clientId);

        waitFor(clientPage.uploadSelfiesBtn);
        click(clientPage.uploadSelfiesBtn);
        File file = new File(path);

        uploadFile(uploadSelfiesPage.selfie1, file.getAbsolutePath());
        uploadFile(uploadSelfiesPage.selfie2, file.getAbsolutePath());
        Thread.sleep(1300);
        click(uploadSelfiesPage.confirmBtn);
        waitFor(By.xpath("//*[contains(text(), 'Selfies were uploaded successfully')]"));
    }

    public void gotoClientPageAndUpdateDocs(String clientId, String path, String docItem) throws InterruptedException {
        gotoSearchPage();
        search("id", clientId);
        goToClientPage(clientId);

        uploadDoc(docItem, path);
        //click(By.xpath("//p-button[@ng-reflect-label='Upload docs']"));
        //selectFromDropDown(By.xpath("//app-select-async[@ng-reflect-name='typeId']"), docItem);
        //File file = new File(path);
        //uploadFile(By.cssSelector("input[type='file']"), file.getAbsolutePath());
        //Thread.sleep(700);
        //click(By.xpath("//p-button[@ng-reflect-label='Confirm']"));
        //waitFor(By.xpath("//*[contains(text(), 'Docs were uploaded successfully')]"));
    }

    public void rejectTicketSuccessfully(String reason, String message) throws InterruptedException {
        click(takeTicketPage.rejectBtn);
        type(rejectTicketPage.reasonInput, reason);
        Thread.sleep(700);
        click(rejectTicketPage.rejectBtn);
        waitFor(By.xpath("//*[contains(text(), '" + message + "')]"));
    }

    public void verifyUserChangedHisMindAboutRejectionOfSelfieDocChangeTicket() {
        click(takeTicketPage.rejectBtn);
        closePopUp(By.cssSelector("timesicon[ng-reflect-style-class='p-dialog-header-close-icon']"));
        waitForInvisibilityOfElement(By.cssSelector("div[role='dialog']"));
    }

    public void verifyUserChangedHisMindAboutRescanRequest() {
        click(takeTicketPage.rescanRequestBtn);
        closePopUp(By.cssSelector("div.p-dialog-header-icons"));
        waitForInvisibilityOfElement(By.xpath("//div[@role='dialog']"));
    }

    public void askForSuccessfullySDD(boolean id, boolean proofOfAddress, boolean backOfId, boolean residencePermit) {
        waitFor(takeTicketPage.askForBtn);
        click(takeTicketPage.askForBtn);
        waitFor(askForPage.idCheckbox);
        if(id){
            clickCheckbox(askForPage.idCheckbox);
        }
        if(proofOfAddress){
            clickCheckbox(askForPage.proofOfAddressCheckbox);
        }
        if(backOfId){
            clickCheckbox(askForPage.backOfIdCheckbox);
        }
        if(residencePermit){
            clickCheckbox(askForPage.residencePermitCheckbox);
        }

        type(By.id("11"), "test");
        click(askForPage.sendBtn);
        waitFor(By.xpath("//*[contains(text(), 'Docs asked successfully')]"));
    }

    public void reassignTicketSuccessfully(String username, String reason) throws InterruptedException {
        waitFor(takeTicketPage.reassignBtn);
        click(takeTicketPage.reassignBtn);
        waitFor(reassignPage.reassignBtn);
        selectFromDropDown(reassignPage.usernameDropDown, username);
        type(reassignPage.reassignrReasonInput, reason);
        Thread.sleep(700);
        click(reassignPage.reassignBtn);
        waitFor(By.xpath("//*[contains(text(), 'Ticket reassigned successfully')]"));
    }

    public void verifyTheUserChangedHisMindAboutReassignTheTicketToAnotherBOUser() {
        waitFor(takeTicketPage.reassignBtn);
        click(takeTicketPage.reassignBtn);
        waitFor(reassignPage.reassignBtn);
        closePopUp(By.cssSelector("button.p-dialog-header-icon"));
        waitForInvisibilityOfElement(By.cssSelector("div[role='dialog']"));
    }

    public String getActualTicketType() {
        return getText(By.cssSelector("div.mb-3 h3.title"));
    }

    public String getActualTicketState() {
        return getText(takeTicketPage.stateField);
    }

    public String getActualTicketDDState() {
        return getText(takeTicketPage.ddField);
    }

    public String getActualTicketId(){
        return getText(takeTicketPage.idField);
    }

    public void verifyTheUserChangedHisMindAboutEscalateToCBO() {
        click(takeTicketPage.escalateToCBOBtn);
        waitFor(By.xpath("//app-reassign-modal //p-button[@ng-reflect-label='Reassign']"));
        closePopUp(By.cssSelector("div.p-dialog-header-icons"));
        waitForInvisibilityOfElement(By.xpath("//div[@role='dialog']"));
    }

    public void verifyTheUserNeedsToEscalateToCBOTicketTriesToEscalateWithoutChoosingAssignTo() {
        click(takeTicketPage.escalateToCBOBtn);
        waitFor(By.xpath("//app-reassign-modal //p-button[@ng-reflect-label='Reassign']"));
        click(By.xpath("//app-reassign-modal //p-button[@ng-reflect-label='Reassign']"));
        waitFor(By.xpath("//*[contains(text(), 'Assign to is required ')]"));
    }

    public String takeFDDTicket(int countryId, int currencyId, String terms1, String terms2) throws InterruptedException, SQLException, ClassNotFoundException {
        if (findElements(By.id("takeTicketContent")).size() == 0) {
            login_registrationHelper.dipocketRegistration(countryId, currencyId, terms1, terms2, generateRandomString(8), "715611173985", prop.getProperty("mobile.registration.phoneNumber"), prop.getProperty("mobile.registration.email"), "dev");
            gotoTakeTicket();
            initFDDTicketDisplain(prop.getProperty("mobile.registration.phoneNumber"), "M");
        }

        for(int i = 0; i < 15; i++) {
            actualTicketType = getActualTicketType();
            state = getActualTicketState();
            ddState = getActualTicketDDState();
            if(actualTicketType.equals("FDD - check client's data")){
                break;
            }

            if(ddState.equals("DD:  SFDD")){
                reasignSFDDTickets(countryId, currencyId, terms1, terms2);
                continue;
            }

            if(actualTicketType.equals("SDD - check client's data") && state.equals("State:  Blocked")){
                approveBlockedSDDTickets2(countryId, currencyId, terms1, terms2);
                continue;
            }

            if (!actualTicketType.equals("FDD - check client's data")) {
                delayTicketForSeveralMinutes();
                gotoTakeTicketWithReg();
            }

            if(findElements(By.id("takeTicketContent")).size() == 0){
                login_registrationHelper.dipocketRegistration(countryId, currencyId, terms1, terms2, generateRandomString(8), "715611173985", prop.getProperty("mobile.registration.phoneNumber"), prop.getProperty("mobile.registration.email"), "dev");
                gotoTakeTicket();
                initFDDTicketDisplain(prop.getProperty("mobile.registration.phoneNumber"), "M");
            }
        }
        return actualTicketType;
    }

    public String takeFDDTicketForRescanRequesteAndUploadDocs() throws InterruptedException, SQLException, ClassNotFoundException {
        if (findElements(By.id("takeTicketContent")).size() == 0) {
            login_registrationHelper.dipocketRegistration(616, 985, "TERMS_AND_CONDITIONS_PL", "ELECTRONIC_COMMUNICATION", generateRandomString(8), "715611173985", prop.getProperty("mobile.registration.phoneNumber"), prop.getProperty("mobile.registration.email"), "dev");
            gotoTakeTicket();
            clientId = initFDDTicketDisplainWithSecondID(prop.getProperty("mobile.registration.phoneNumber"), "M");
        }

        for(int i = 0; i < 12; i++) {
            actualTicketType = getActualTicketType();
            state = getActualTicketState();
            if(actualTicketType.equals("FDD - check client's data")){
                break;
            }

            if(ddState.equals("DD:  SFDD")){
                reasignSFDDTickets(616, 985, "TERMS_AND_CONDITIONS_PL", "ELECTRONIC_COMMUNICATION");
                continue;
            }

            if(actualTicketType.equals("SDD - check client's data") && state.equals("State:  Blocked")){
                approveBlockedSDDTickets();
                continue;
            }

            if (!actualTicketType.equals("FDD - check client's data")) {
                delayTicketForSeveralMinutes();
                gotoTakeTicketWithReg();
            }

            if(findElements(By.id("takeTicketContent")).size() == 0){
                login_registrationHelper.dipocketRegistration(616, 985, "TERMS_AND_CONDITIONS_PL", "ELECTRONIC_COMMUNICATION", generateRandomString(8), "715611173985", prop.getProperty("mobile.registration.phoneNumber"), prop.getProperty("mobile.registration.email"), "dev");
                gotoTakeTicket();
                clientId = initFDDTicketDisplain(prop.getProperty("mobile.registration.phoneNumber"), "M");
            }
        }
        return clientId;
    }

    public void approveBlockedSDDTickets() throws InterruptedException, SQLException, ClassNotFoundException {
        if(actualTicketType.equals("SDD - check client's data") && state.equals("State:  Blocked")){
            editAndSaveSDDTicket("M", "Passport", "11111111111", "123456789", "Poland");
            approveTicketSuccessfully();
            gotoTakeTicketWithReg();

            if(findElements(By.id("takeTicketContent")).size() == 0){
                login_registrationHelper.dipocketRegistration(616, 985, "TERMS_AND_CONDITIONS_PL", "ELECTRONIC_COMMUNICATION", generateRandomString(8), "715611173985", prop.getProperty("mobile.registration.phoneNumber"), prop.getProperty("mobile.registration.email"), "dev");
                gotoTakeTicket();
                clientId = initFDDTicketDisplain(prop.getProperty("mobile.registration.phoneNumber"), "M");
            }
        }
    }

    public void approveBlockedSDDTickets2(int countryId, int currencyId, String terms1, String terms2) throws InterruptedException, SQLException, ClassNotFoundException {
        if(actualTicketType.equals("SDD - check client's data") && state.equals("State:  Blocked")){
            editAndSaveSDDTicket("M", "Passport", "11111111111", "123456789", String.valueOf(countryId));
            approveTicketSuccessfully();
            gotoTakeTicketWithReg();

            if(findElements(By.id("takeTicketContent")).size() == 0){
                login_registrationHelper.dipocketRegistration(countryId, currencyId, terms1, terms2, generateRandomString(8), "715611173985", prop.getProperty("mobile.registration.phoneNumber"), prop.getProperty("mobile.registration.email"), "dev");
                gotoTakeTicket();
                initFDDTicketDisplain(prop.getProperty("mobile.registration.phoneNumber"), "M");
            }
        }
    }

    public void reasignSFDDTickets(int countryId, int currencyId, String terms1, String terms2) throws InterruptedException, SQLException, ClassNotFoundException {
        if(ddState.equals("DD:  SFDD")){
            reassignTicketSuccessfully("AUTO", "test");
            gotoTakeTicketWithReg();

            if(findElements(By.id("takeTicketContent")).size() == 0){
                login_registrationHelper.dipocketRegistration(countryId, currencyId, terms1, terms2, generateRandomString(8), "715611173985", prop.getProperty("mobile.registration.phoneNumber"), prop.getProperty("mobile.registration.email"), "dev");
                gotoTakeTicket();
                initFDDTicketDisplain(prop.getProperty("mobile.registration.phoneNumber"), "M");
            }
        }
    }
}