package appmanager.ui.bo;

import appmanager.UIHelperBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;
import padeObjects.bo.BasePopupPage;
import padeObjects.bo.boClient.*;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class UIBOClientHelper extends UIHelperBase {
    ClientPage clientPage = new ClientPage(driver);
    UnblockClientPage unblockClientPage = new UnblockClientPage(driver);
    BlockClientPage blockClientPage = new BlockClientPage(driver);
    BanClientPage banClientPage = new BanClientPage(driver);
    UnbanClientPage unbanClientPage = new UnbanClientPage(driver);
    ChangeCredentialsPage changeCredentialsPage = new ChangeCredentialsPage(driver);
    ForgetClientPage forgetClientPage = new ForgetClientPage(driver);
    ApproveSupervisorPage approveSupervisorPage = new ApproveSupervisorPage(driver);
    RejectSupervisorPage rejectSupervisorPage = new RejectSupervisorPage(driver);
    BasePopupPage basePopupPage = new BasePopupPage(driver);
    SendStatemenstPage sendStatemenstPage = new SendStatemenstPage(driver);
    SoftAssert softAssert = new SoftAssert();

    public UIBOClientHelper(WebDriver driver) {
        super(driver);
    }

    public void goToClientPage(String phone) {
        click(By.cssSelector("td span[ng-reflect-text='"+phone+"']"));
        waitFor(By.cssSelector("p.user-name"));
    }

    public void goToClientPageCorpClient(By locator) {
        click(locator);
        waitFor(By.cssSelector("app-corp-client-info"));
    }

    public void unblockClient(String reason) throws InterruptedException {
        //click(By.xpath("//p-button[@ng-reflect-label='Unblock client']"));
        click(clientPage.unblockClientBtn);
        //type(By.cssSelector("input[id*=input_unblockOrUnbanReason]"), reason);
        type(unblockClientPage.unblockReasonInput, reason);
        //click(By.xpath("//p-button[@ng-reflect-label='Confirm']"));
        click(unblockClientPage.confirmBtn);
        Thread.sleep(2000);
        waitFor(By.xpath("//*[contains(text(), 'Client was unblocked successfully')]"));
        waitForInvisibilityOfElement(By.xpath("//*[contains(text(), 'Client was unblocked successfully')]"));
        waitFor(By.xpath("//p-button[@ng-reflect-label='Block client']"));
        waitFor(By.xpath("//span[contains(text(), 'Active')]"));
    }

    public void blockClient(String reason) throws InterruptedException {
        //waitFor(By.xpath("//p-button[@ng-reflect-label='Block client']"));
        waitFor(clientPage.blockClientBtn);
        //click(By.xpath("//p-button[@ng-reflect-label='Block client']"));
        click(clientPage.blockClientBtn);
        //type(By.cssSelector("input[id*=input_blockOrBanReason]"), reason);
        type(blockClientPage.blockReasonInput, reason);
        Thread.sleep(1500);
        //click(By.xpath("//p-button[@ng-reflect-label='Block']"));
        click(blockClientPage.blockBtn);
        Thread.sleep(2000);
        //waitFor(By.xpath("//p-toast //div[contains(text(), 'Client was blocked successfully')]"));
        waitFor(By.xpath("//*[contains(text(), 'Client was blocked successfully')]"));
        waitFor(By.xpath("//span[contains(text(), 'Blocked')]"));
    }

    public void unbanClient(String reason) {
        //click(By.xpath("//p-button[@ng-reflect-label='Unban client']"));
        click(clientPage.unbanClientBtn);
        //type(By.cssSelector("input[id*='input_unblockOrUnbanReason']"), reason);
        type(unbanClientPage.unbanReasonInput, reason);
        //click(By.xpath("//p-button[@ng-reflect-label='Confirm']"));
        click(unbanClientPage.confirmBtn);
        waitFor(By.xpath("//div[contains(text(), 'Client was unbaned successfully')]"));
        waitForInvisibilityOfElement(By.xpath("//div[contains(text(), 'Client was unbaned successfully')]"));
        waitFor(By.xpath("//app-client-info //span[contains(text(), 'Active')]"));
    }

    public void banClient(String reason) throws InterruptedException {
        //click(By.xpath("//p-button[@ng-reflect-label='Ban client']"));
        click(clientPage.banClientBtn);
        //type(By.cssSelector("input[id*=blockOrBanReason]"), reason);
        type(banClientPage.banReasonInput, reason);
        Thread.sleep(1500);
        //clickCheckbox(By.cssSelector("p-checkbox[id*='blockClientDevice']"));
        click(banClientPage.blockClientDeviceCheckbox);
        //click(By.xpath("//p-button[@ng-reflect-label='Confirm']"));
        click(banClientPage.confirmBtn);
        waitFor(By.xpath("//div[contains(text(), 'Client was ban successfully')]"));
        waitFor(By.xpath("//span[contains(text(), 'Banned')]"));
    }

    public void banClientWithoutBlockingClientDevice(String reason) throws InterruptedException {
        //click(By.xpath("//p-button[@ng-reflect-label='Ban client']"));
        click(clientPage.banClientBtn);
        type(banClientPage.banReasonInput, reason);
        Thread.sleep(1500);
        click(banClientPage.confirmBtn);
        waitFor(By.xpath("//div[contains(text(), 'Client was ban successfully')]"));
        waitFor(By.xpath("//span[contains(text(), 'Banned')]"));
    }

    public void changeCredentialsChangePassword() {
        //click(By.xpath("//p-button[@ng-reflect-label='Change credentials']"));
        click(clientPage.changeCredentialsBtn);
        //click(By.xpath("//label[contains(text(), 'Change password:')]"));
        click(changeCredentialsPage.changePasswordCheckbox);
        //click(By.cssSelector("p-button[ng-reflect-label='Confirm']"));
        click(changeCredentialsPage.confirmBtn);
        waitFor(By.xpath("//div[contains(text(), 'Credentials was changed successfully')]"));
    }

    public void changeCredetialsChangeSecretAnswer() {
        //click(By.xpath("//p-button[@ng-reflect-label='Change credentials']"));
        click(clientPage.changeCredentialsBtn);
        //click(By.xpath("//label[contains(text(), 'Change secret answer:')]"));
        click(changeCredentialsPage.changeSecretAnswerCheckbox);
        //click(By.cssSelector("p-button[ng-reflect-label='Confirm']"));
        click(changeCredentialsPage.confirmBtn);
        waitFor(By.xpath("//div[contains(text(), 'Credentials was changed successfully')]"));
    }

    public void changeCredentialsChagePhoneNumber(String newPhone) throws InterruptedException {
        //click(By.xpath("//p-button[@ng-reflect-label='Change credentials']"));
        click(clientPage.changeCredentialsBtn);
        //click(By.xpath("//label[contains(text(), 'Change phone number:')]"));
        click(changeCredentialsPage.changePhoneNumberCheckbox);
        waitForInvisibilityOfElement(By.cssSelector("input[placeholder='New phone'][disabled]"));
        //type(By.cssSelector("p-inputnumber[id*='input-number_mainPhone'] input"), newPhone);
        type(changeCredentialsPage.newPhoneInput, newPhone);
        Thread.sleep(1500);
        //click(By.cssSelector("p-button[ng-reflect-label='Confirm']"));
        click(changeCredentialsPage.confirmBtn);
        waitFor(By.xpath("//div[contains(text(), 'Credentials was changed successfully')]"));
    }

    public void forgetClient(String reason) throws InterruptedException {
        //click(By.xpath("//p-button[@ng-reflect-label='Forget client']"));
        click(clientPage.forgetClientBtn);
        //type(By.cssSelector("input[id*='input_reason']"), reason);
        type(forgetClientPage.reasonInput, reason);
        Thread.sleep(700);
        //click(By.xpath("//p-button[@ng-reflect-label='Confirm']"));
        click(forgetClientPage.confirmBtn);
        waitFor(By.xpath("//div[contains(text(), 'Client was forget successfully')]"));
        waitFor(By.xpath("//span[contains(text(), 'Forgotten')]"));
    }

    public void goToClientIBANTab() {
        click(By.id("p-tabpanel-4-label"));
    }

    public void goToMessagesTab() {
        click(By.xpath("//span[contains(text(), 'Messages')]"));
    }

    public void goTo3rdPartyCardsTab() {
        click(By.xpath("//span[contains(text(), '3rd party cards')]"));
    }

    public void goToAccountsTab() {
        click(By.xpath("//span[contains(text(), 'Accounts')]"));
    }

    public void goToPayeeTab() {
        click(By.xpath("//span[contains(text(), 'Payee')]"));
        waitFor(By.cssSelector("p-columnfilter[ng-reflect-field='nickName']"));
    }

    public void goToSupervisorRequestsTab() {
        waitForElementToBeClickable(By.id("p-tabpanel-12-label"));
        click(By.id("p-tabpanel-12-label"));
        waitFor(By.xpath("//thead //th[contains(text(), 'Request id')]"));
    }

    public void goToTicketsTab() {
        click(By.xpath("//span[contains(text(), 'Tickets')]"));
    }

    public void goToTilesTab() {
        click(By.id("p-tabpanel-2-label"));
    }

    public void goToDocsTab() {
        click(By.id("p-tabpanel-7-label"));
    }

    public void goToTransactionTab() {
        click(By.xpath("//span[contains(text(), 'Transaction')]"));
        waitFor(By.xpath("//thead //th[contains(text(), 'TranItemId')]"));
    }

    public void pressEditProfileDataFromClientPage() throws InterruptedException {
        click(By.cssSelector("div.edit-button"));
        waitFor(By.cssSelector("p-dropdown[id*='select_gender_']"));
        waitFor(By.xpath("//p-button[@ng-reflect-label='Save']"));
        Thread.sleep(1500);
    }

    public void editProfileData(String firstName, String lastName, String mailingStreetLine1, String mailingStreetLine2, String city, String mailingPostcode) {
        type(By.cssSelector("input[id*='input_firstName']"), firstName);
        type(By.cssSelector("input[id*='input_lastName']"), lastName);
        type(By.cssSelector("input[id*='_input_mailingStreetLine1_']"), mailingStreetLine1);
        type(By.cssSelector("input[id*='_input_mailingStreetLine2_']"), mailingStreetLine2);
        type(By.cssSelector("input[id*='_input_mailingCity_']"), city);
        type(By.cssSelector("input[id*='_input_mailingPostcode_']"), mailingPostcode);
        click(By.xpath("//p-button[@ng-reflect-label='Save']"));
    }

    public void sendAllStatemenstToDefaultEmail() throws InterruptedException {
        //waitFor(By.xpath("//*[contains(text(), 'Handler dispatch failed; nested exception is java.lang.OutOfMemoryError: Java heap space')]"));
        Thread.sleep(4000);
        waitForElementToBeClickable(clientPage.sendStatementsBtn, 50);
        waitForElementToBeClickable(clientPage.sendStatementsBtn);
        click(clientPage.sendStatementsBtn);
        waitFor(sendStatemenstPage.mounthAndYearDropDown);
        click(sendStatemenstPage.mounthAndYearDropDown);
        selectAll();
        click(sendStatemenstPage.closeStatementDropDownBtn);
        click(sendStatemenstPage.sendBtn);
        waitFor(sendStatemenstPage.sendStatementsConfirmMessage);
    }

    public void sendAllStatementsToEnteredEmail(String email) throws InterruptedException {
        Thread.sleep(4000);
        waitForElementToBeClickable(clientPage.sendStatementsBtn, 50);
        waitForElementToBeClickable(clientPage.sendStatementsBtn, 50);
        click(clientPage.sendStatementsBtn);
        waitFor(sendStatemenstPage.mounthAndYearDropDown);
        click(sendStatemenstPage.mounthAndYearDropDown);
        selectAll();
        click(sendStatemenstPage.closeStatementDropDownBtn);
        click(sendStatemenstPage.sendToClientEmailCheckbox);
        type(sendStatemenstPage.emailInput, email);
        click(sendStatemenstPage.sendBtn);
        waitFor(sendStatemenstPage.sendStatementsConfirmMessage);
    }

    public void sendStatementForChosenPeriodAndDefaultEmail() throws InterruptedException {
        Thread.sleep(4000);
        waitForElementToBeClickable(clientPage.sendStatementsBtn, 50);
        waitForElementToBeClickable(clientPage.sendStatementsBtn, 50);
        click(clientPage.sendStatementsBtn);
        waitFor(sendStatemenstPage.mounthAndYearDropDown);
        click(sendStatemenstPage.mounthAndYearDropDown);
        selectFirstElement();
        click(sendStatemenstPage.closeStatementDropDownBtn);
        click(sendStatemenstPage.sendBtn);
        waitFor(sendStatemenstPage.sendStatementsConfirmMessage);
    }

    public void selectFirstElement() {
        click(By.cssSelector("li[tabindex='0']"));
    }

    public void selectAll() {
        click(By.cssSelector("div[role='checkbox']"));
    }

    public void unblockAccount() throws InterruptedException {
        waitFor(By.xpath("//span[contains(text(), 'Unblock account')]"));
        click(By.xpath("//span[contains(text(), 'Unblock account')]"));
        waitFor(By.cssSelector("app-button[label='Unblock']"));
        click(By.cssSelector("app-button[label='Unblock']"));
        waitFor(By.xpath("//div[contains(text(), 'Account was unblocked successfully')]"));
        Thread.sleep(1500);
    }

    public String blockAccountGetPopupText() {
        waitFor(By.xpath("//span[contains(text(), 'Block account')]"));
        click(By.xpath("//span[contains(text(), 'Block account')]"));
        waitFor(By.cssSelector("p-button[label='Block']"));
        String actualPopupText = getTextFromPopUp2(By.cssSelector("app-block-account p"));
        click(By.cssSelector("p-button[label='Block']"));
        waitFor(By.xpath("//div[contains(text(), 'Account was blocked successfully')]"));
        return actualPopupText;
    }

    public void blockAccount() throws InterruptedException {
        waitFor(By.xpath("//span[contains(text(), 'Block account')]"));
        click(By.xpath("//span[contains(text(), 'Block account')]"));
        waitFor(By.cssSelector("p-button[label='Block']"));
        click(By.cssSelector("p-button[label='Block']"));
        waitFor(By.xpath("//div[contains(text(), 'Account was blocked successfully')]"));
        Thread.sleep(1500);
    }

    public String unblockAccountAndGetPopupText() {
        click(By.xpath("//span[contains(text(), 'Unblock account')]"));
        String actualPopupText = getTextFromPopUp2(By.cssSelector("app-unblock-account-modal p"));
        click(By.cssSelector("app-button[label='Unblock']"));
        waitFor(By.xpath("//div[contains(text(), 'Account was unblocked successfully')]"));
        return actualPopupText;
    }

    public void overdraftLimitUpdateAccountLimits(String lowLimit, String highLimit) throws InterruptedException {
        click(By.xpath("//span[contains(text(), 'Overdraft limit')]"));
        type(By.cssSelector("p-inputnumber#formly_3_input-number_lowLimit_0 input"), lowLimit);
        type(By.cssSelector("p-inputnumber#formly_3_input-number_highLimit_1 input"), highLimit);
        Thread.sleep(1000);
        click(By.cssSelector("p-button[ng-reflect-label='Save']"));
        waitFor(By.xpath("//div[contains(text(), 'Account limits was changed successfully')]"));
    }

    public void unblockCard() throws InterruptedException {
        click(By.xpath("//li //span[contains(text(), 'Unblock card')]"));
        waitFor(By.cssSelector("app-button[ng-reflect-label='Unblock']"));
        click(By.cssSelector("app-button[ng-reflect-label='Unblock']"));
        waitFor(By.xpath("//div[contains(text(), 'Card was unblocked successfully')]"));
        Thread.sleep(4000);
    }

    public void blockCard() throws InterruptedException {
        click(By.xpath("//li //span[contains(text(), 'Block card')]"));
        waitFor(By.xpath("//label[contains(text(), '41 Lost card (can be unblocked)')]"));
        assertTrue(areElementsPresent(new String[]{"//label[contains(text(), '41 Lost card (can be unblocked)')]", "//label[contains(text(), '43 Stolen card')]",
                "//label[contains(text(), '62 Restricted card')]", "//label[contains(text(), '83 Card destroyed')]"}));

        click(By.xpath("//label[contains(text(), '41 Lost card (can be unblocked)')]"));
        Thread.sleep(1200);
        click(By.cssSelector("p-button[ng-reflect-label='Block']"));
        waitFor(By.xpath("//div[contains(text(), 'Card was blocked successfully')]"));
        waitForInvisibilityOfElement(By.xpath("//div[contains(text(), 'Card was blocked successfully')]"));
    }

    public void verifyClientPageFilter(By locator, String text, String mustNotBe, String filter) {
        setClientPageFilter(locator, text);
        waitForSeveralItems(new String[]{text});
        assertTrue(areElementsPresentAfterSorting(By.cssSelector("td span[ng-reflect-text='"+text+"']")));
        assertFalse(areElementsPresentAfterSorting(By.cssSelector("td span[ng-reflect-text='"+mustNotBe+"']")));
        deleteTextFromTextarea(locator);
    }

    public void verifyClientPageFilter(By locator, String text, String filter, By tableResultLocator) {
        setClientPageFilter(locator, text);
        waitForSeveralItems(new String[]{text});
        assertTrue(areElementsPresentAfterSorting(tableResultLocator));
        deleteTextFromTextarea(locator);
    }

    public void setClientPageFilter(By locator, String text) {
        type(locator, text);
        pressKeys(Keys.ENTER);
    }

    public void verifyDropDownClientPageFilter(By locator, String text, String mustNotBe) {
        setDropDownClientPageFilter(locator, text);
        waitForSeveralItems(new String[]{text});
        assertTrue(areElementsPresentAfterSorting(By.cssSelector("td span[ng-reflect-text='"+text+"']")));
        assertFalse(areElementsPresentAfterSorting(By.cssSelector("td span[ng-reflect-text='"+mustNotBe+"']")));
        //clearFilter(By.cssSelector("timesicon[ng-reflect-style-class='p-dropdown-clear-icon'] svg"));
        clearFilter(clientPage.clearDropDownFilterBtn);
    }

    public void verifyDropDownClientPageFilter(By locator, String text) {
        setDropDownClientPageFilter(locator, text);
        waitForSeveralItems(new String[]{text});
        assertTrue(areElementsPresentAfterSorting(By.cssSelector("td span[ng-reflect-text='"+text+"']")));
        //clearFilter(By.cssSelector("i.p-dropdown-clear-icon"));
        clearFilter(clientPage.clearDropDownFilterBtn);
    }

    public void verifyClientPageFilterWithCollection(String filter, String text, int index) {
        WebElement fil = driver.findElements(By.cssSelector("p-columnfilter[field='" + filter + "'] input[type='text']")).get(index);
        fil.sendKeys(text);
        pressKeys(Keys.ENTER);
        waitFor(By.cssSelector("td[ng-reflect-text='"+text+"']"));
        assertTrue(areElementsPresentAfterSorting(By.cssSelector("td[ng-reflect-text='"+text+"']")));
        deleteText(fil);
    }

    public void setDropDownClientPageFilter(By locator, String value) {
        click(locator);
        click(By.cssSelector("p-dropdownitem[ng-reflect-label='" + value + "']"));
        waitFor(By.cssSelector("timesicon[ng-reflect-style-class='p-dropdown-clear-icon']"));
    }

    public void clearFilter(By locator) {
        click(locator);
    }

    public void clearFilterDropDownFilter() {
        clientPage.clearDropDownFilterBtn.click();
    }

    public void clearFilter(WebElement element) {
        element.click();
    }

    public void rejectSupervisor() throws InterruptedException {
        click(By.xpath("//li //span[contains(text(), 'Reject')]"));
        waitFor(rejectSupervisorPage.confirmBtn);
        click(rejectSupervisorPage.confirmBtn);
        waitFor(By.xpath("//*[contains(text(), 'Supervisor was rejected successfully')]"));
        Thread.sleep(2500);
    }

    public String approveSupervisorAndGetTextFromPopUp() {
        waitFor(By.xpath("//li //span[contains(text(), 'Approve')]"));
        click(By.xpath("//li //span[contains(text(), 'Approve')]"));
        String actualPopupText = getTextFromPopUp2(By.cssSelector("div.p-dialog-content p"));
        waitFor(approveSupervisorPage.confirmBtn);
        click(approveSupervisorPage.confirmBtn);
        waitFor(By.xpath("//*[contains(text(), 'Supervisor was approved successfully')]"));
        return actualPopupText;
    }

    public void approveSupervisor() throws InterruptedException {
        click(By.xpath("//li //span[contains(text(), 'Approve')]"));
        waitFor(approveSupervisorPage.confirmBtn);
        click(approveSupervisorPage.confirmBtn);
        waitFor(By.xpath("//*[contains(text(), 'Supervisor was approved successfully')]"));
        Thread.sleep(2500);
    }

    public String rejectSupervisorAndGetTextFromPopUp() {
        waitFor(By.xpath("//li //span[contains(text(), 'Reject')]"));
        click(By.xpath("//li //span[contains(text(), 'Reject')]"));
        String actualPopupText = getTextFromPopUp2(By.cssSelector("div.p-dialog-content p"));
        waitFor(rejectSupervisorPage.confirmBtn);
        click(rejectSupervisorPage.confirmBtn);
        waitFor(By.xpath("//*[contains(text(), 'Supervisor was rejected successfully')]"));
        return actualPopupText;
    }

    public void searchByTransactionTab(String date) {
        click(By.cssSelector("p-dropdown[optionlabel='value']"));
        click(By.cssSelector("li[aria-label='" + date + "']"));
        click(By.cssSelector("p-button[label='Search']"));
    }

    public void verifyDropDownClientPageFilterWithCollection(By by, String text, int index) {
        WebElement filter = driver.findElements(by).get(index);
        filter.click();
        click(By.xpath("//li[@aria-label='" + text + "']"));
        assertTrue(areElementsPresentAfterSorting(By.cssSelector("td[ng-reflect-text='" + text + "']")));
        clearFilter(By.cssSelector("i.p-dropdown-clear-icon"));
    }

    public void setDropDownClientPageFilter_messageTab(final String text) {
        click(By.xpath("//p-dropdown"));
        waitFor(By.cssSelector("li[aria-label=" + text + "]"));
        click(By.cssSelector("li[aria-label=" + text + "]"));
        waitFor(By.cssSelector("timesicon[ng-reflect-style-class='p-dropdown-clear-icon'] svg"));
    }

    public void setClientPageFilter_messageTab(final String filter, String text) {
        type(By.cssSelector("div[id='p-tabpanel-2'] p-columnfilter[ng-reflect-field='" + filter + "'] input[type='text']"), text);
        pressKeys(Keys.ENTER);
    }

    public SoftAssert verifySearchFields() {
        softAssert.assertFalse(!areElementsPresent(new String[]{
                "//p-tabpanel[@header='Client'] //input[contains(@id, 'input_id')]", "//p-tabpanel[@header='Client'] //input[contains(@id, 'input_email')]", "//p-tabpanel[@header='Client'] //input[contains(@id, 'input_mainPhone')]",
                "//p-tabpanel[@header='Client'] //input[contains(@id, 'input_firstName')]", "//p-tabpanel[@header='Client'] //input[contains(@id, 'input_lastName')]", "//p-calendar //input[@type='text']",
                "//p-tabpanel[@header='Client'] //input[contains(@id, 'input_mailingAddress')]", "//p-tabpanel[@header='Client'] //input[contains(@id, 'input_companyName')]"}), "Search Fields failed");
        return softAssert;
    }

    public SoftAssert virifyTabsOnSerchPage() {
        softAssert.assertFalse(!isElementPresent(By.xpath("//span[contains(text(), 'Client')]")), "Client tab");
        softAssert.assertFalse(!isElementPresent(By.xpath("//span[contains(text(), 'Card')]")), "Card tab");
        return softAssert;
    }

    public SoftAssert verifyClientSearchResult(String phone, String email) {
        softAssert.assertFalse(!isElementPresent(By.cssSelector("td span[ng-reflect-text='"+ phone +"']")), "phone");
        softAssert.assertFalse(!isElementPresent(By.cssSelector("td span[ng-reflect-text='" + email + "']")), "email");
        return softAssert;
    }

    public SoftAssert virifyButtons() {
        softAssert.assertFalse(!areButtonsPresent(new String[]{"//p-button[@ng-reflect-label='Search']", "//p-button[@ng-reflect-label='Block client']", "//p-button[@ng-reflect-label='Ban client']",
                "//p-button[@ng-reflect-label='Forget client']", "//p-button[@ng-reflect-label='Change credentials']", "//p-button[@ng-reflect-label='Send statements']",
                "//p-button[@ng-reflect-label='Upload docs']", "//p-button[@ng-reflect-label='Upload selfies']", "//p-button[@ng-reflect-label='Transfer back']"}), "Buttons incorrect");
        return softAssert;
    }

    public SoftAssert verifyTabs() {
        softAssert.assertFalse(!areElementsPresent(new String[]{
                "//a[@role='tab'] //span[contains(text(), 'Tiles')]", "//a[@role='tab'] //span[contains(text(), 'Messages')]", "//a[@role='tab'] //span[contains(text(), 'Client iban')]",
                "//a[@role='tab'] //span[contains(text(), 'Payee')]", "//a[@role='tab'] //span[contains(text(), 'Selfie')]", "//a[@role='tab'] //span[contains(text(), 'Docs')]",
                "//a[@role='tab'] //span[contains(text(), 'Accounts')]", "//a[@role='tab'] //span[contains(text(), '3rd party cards')]", "//a[@role='tab'] //span[contains(text(), 'Transaction')]",
                "//a[@role='tab'] //span[contains(text(), 'Tickets')]", "//a[@role='tab'] //span[contains(text(), 'Supervisor requests')]"}), "Tabs incorrect");
        return softAssert;
    }

    public void selectAccountFromAccountTableAndPerformContextClick(String accountName) {
        performContextClick(By.cssSelector("td span[ng-reflect-text='"+accountName+"']"));
    }

    public void selectAccountNameFromTable(String accountName){
        click(By.cssSelector("td span[ng-reflect-text='"+accountName+"']"));
    }

    public void selectCardFromCardTablePerformContextClick(String card) {
        performContextClick(By.cssSelector("td span[ng-reflect-text='"+card+"']"));
    }

    public void selectAccountNameFromAccountTableAndWaitCardPresentInCardTable(String accountName, String card) {
        selectAccountNameFromTable(accountName);
        waitFor(By.cssSelector("td span[ng-reflect-text='"+card+"']"));
    }

    public void clickCardLimits() {
        click(By.xpath("//li //span[contains(text(), 'Card limits')]"));
        waitFor(By.xpath("//span[contains(text(), 'Card id:')]"));
    }

    public String resetContactlessCounter() {
        waitFor(By.xpath("//li //span[contains(text(), 'Reset contactless counter')]"));
        click(By.xpath("//li //span[contains(text(), 'Reset contactless counter')]"));
        String actualPopupText = getTextFromPopUp2(By.cssSelector("app-reset-contactless-counter p"));
        click(By.cssSelector("p-button[label='Confirm']"));
        waitFor(By.xpath("//div[contains(text(), 'Contactless counter was successfully reset')]"));
        return actualPopupText;
    }

    public String getStateFromCardTable(By locator){
        String actualState = driver.findElement(locator).getText();
        return actualState;
    }
}