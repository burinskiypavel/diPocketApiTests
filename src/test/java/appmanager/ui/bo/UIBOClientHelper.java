package appmanager.ui.bo;

import appmanager.UIHelperBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class UIBOClientHelper extends UIHelperBase {

    public UIBOClientHelper(WebDriver driver) {
        super(driver);
    }

    public void goToClientPage(String phone) {
        click(By.cssSelector("td[ng-reflect-text='"+phone+"']"));
        waitFor(By.cssSelector("p.user-name"));
    }

    public void goToClientPageCorpClient(By locator) {
        click(locator);
        waitFor(By.cssSelector("app-corp-client-details-info"));
    }

    public void unblockClient(String reason) {
        click(By.xpath("//app-button[@ng-reflect-label='Unblock client']"));
        type(By.cssSelector("input[id*=input_unblockOrUnbanReason]"), reason);
        click(By.xpath("//p-button[@ng-reflect-label='Confirm']"));
        waitForInvisibilityOfElement(By.xpath("//div[contains(text(), 'Client was unblocked successfully')]"));
        waitFor(By.xpath("//app-button[@ng-reflect-label='Block client']"));
        waitFor(By.xpath("//span[contains(text(), 'Active')]"));
    }

    public void blockClient(String reason) throws InterruptedException {
        click(By.xpath("//app-button[@ng-reflect-label='Block client']"));
        type(By.cssSelector("input[id*=input_blockOrBanReason]"), reason);
        Thread.sleep(1500);
        click(By.xpath("//p-button[@ng-reflect-label='Block']"));
        waitFor(By.xpath("//div[contains(text(), 'Client was blocked successfully')]"));
        waitFor(By.xpath("//span[contains(text(), 'Blocked')]"));
    }

    public void unbanClient(String reason) {
        click(By.xpath("//app-button[@ng-reflect-label='Unban client']"));
        type(By.cssSelector("input[id*='input_unblockOrUnbanReason']"), reason);
        click(By.xpath("//p-button[@ng-reflect-label='Confirm']"));
        waitFor(By.xpath("//div[contains(text(), 'Client was unbaned successfully')]"));
        waitForInvisibilityOfElement(By.xpath("//div[contains(text(), 'Client was unbaned successfully')]"));
        waitFor(By.xpath("//span[contains(text(), 'Active')]"));
    }

    public void banClient(String reason) throws InterruptedException {
        click(By.xpath("//app-button[@ng-reflect-label='Ban client']"));
        type(By.cssSelector("input[id*=blockOrBanReason]"), reason);
        Thread.sleep(1500);
        clickCheckbox(By.cssSelector("p-checkbox[id*='blockClientDevice']"));
        click(By.xpath("//p-button[@ng-reflect-label='Confirm']"));
        waitFor(By.xpath("//div[contains(text(), 'Client was ban successfully')]"));
        waitFor(By.xpath("//span[contains(text(), 'Banned')]"));
    }

    public void banClientWithoutBlockingClientDevice(String reason) throws InterruptedException {
        click(By.xpath("//app-button[@ng-reflect-label='Ban client']"));
        type(By.cssSelector("app-dynamic-form input[type='text']"), reason);
        Thread.sleep(1500);
        click(By.xpath("//app-button[@ng-reflect-label='Ban']"));
        waitFor(By.xpath("//div[contains(text(), 'User was ban successfully')]"));
        waitFor(By.xpath("//span[contains(text(), 'Banned')]"));
    }

    public void changeCredentialsChagePhoneNumber(String newPhone) throws InterruptedException {
        click(By.xpath("//app-button[@ng-reflect-label='Change credentials']"));
        click(By.xpath("//label[contains(text(), 'Change phone number:')]"));
        waitForInvisibilityOfElement(By.cssSelector("input[placeholder='New phone'][disabled]"));
        type(By.cssSelector("input[placeholder='New phone']"), newPhone);
        Thread.sleep(1000);
        click(By.cssSelector("p-button[ng-reflect-label='Change']"));
    }

    public void forgetClient(String reason) throws InterruptedException {
        click(By.xpath("//app-button[@ng-reflect-label='Forget client']"));
        type(By.cssSelector("input[id*='input_reason']"), reason);
        Thread.sleep(700);
        click(By.xpath("//p-button[@ng-reflect-label='Confirm']"));
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
        waitFor(By.cssSelector("p-columnfilter[field='nickName']"));
    }

    public void goToSupervisorRequestsTab() {
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

    public void sendAllStatemenstToDefaultEmail() {
        click(By.xpath("//app-button[@ng-reflect-label='Send statements']"));
        waitFor(By.id("formly_3_multi-select_statementRequestList_0"));
        click(By.id("formly_3_multi-select_statementRequestList_0"));
        click(By.cssSelector("div[role='checkbox']"));
        click(By.cssSelector("span.p-multiselect-close-icon"));
        click(By.cssSelector("p-button[label='Send']"));
        waitFor(By.xpath("//div[contains(text(), 'Statements were sent successfully')]"));
    }

    public void sendAllStatementsToEnteredEmail(String email) {
        click(By.xpath("//app-button[@ng-reflect-label='Send statements']"));
        waitFor(By.id("formly_3_multi-select_statementRequestList_0"));
        click(By.id("formly_3_multi-select_statementRequestList_0"));
        click(By.cssSelector("div[role='checkbox']"));
        click(By.cssSelector("span.p-multiselect-close-icon"));
        click(By.id("formly_3_checkbox_useClientEmail_1"));
        type(By.id("formly_3_input_email_2"), email);
        click(By.cssSelector("p-button[label='Send']"));
        waitFor(By.xpath("//div[contains(text(), 'Statements were sent successfully')]"));
    }

    public void sendStatementForChosenPeriodAndDefaultEmail() {
        click(By.xpath("//app-button[@ng-reflect-label='Send statements']"));
        waitFor(By.id("formly_3_multi-select_statementRequestList_0"));
        click(By.id("formly_3_multi-select_statementRequestList_0"));
        click(By.cssSelector("li[tabindex='0']"));
        click(By.cssSelector("span.p-multiselect-close-icon"));
        click(By.cssSelector("p-button[label='Send']"));
        waitFor(By.xpath("//div[contains(text(), 'Statements were sent successfully')]"));
    }

    public void unblockAccount() throws InterruptedException {
        click(By.xpath("//span[contains(text(), 'Unblock account')]"));
        click(By.cssSelector("app-button[label='Unblock']"));
        waitFor(By.xpath("//div[contains(text(), 'Account was unblocked successfully')]"));
        Thread.sleep(1500);
    }

    public String blockAccount() {
        click(By.xpath("//span[contains(text(), 'Block account')]"));
        String actualPopupText = getTextFromPopUp2(By.cssSelector("app-block-account p"));
        click(By.cssSelector("p-button[label='Block']"));
        waitFor(By.xpath("//div[contains(text(), 'Account was blocked successfully')]"));
        return actualPopupText;
    }

    public void boClientPageBlockAccount() throws InterruptedException {
        click(By.xpath("//span[contains(text(), 'Block account')]"));
        click(By.cssSelector("app-button[label='Block']"));
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

    public void updateLimits(String lowLimit, String highLimit) throws InterruptedException {
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

    public void verifyClientPageFilter(String filter, String text, String mustNotBe) {
        setClientPageFilter(filter, text);
        waitForSeveralItems(new String[]{text});
        assertTrue(areElementsPresentAfterSorting(By.cssSelector("td[ng-reflect-text='"+text+"']")));
        assertFalse(areElementsPresentAfterSorting(By.cssSelector("td[ng-reflect-text='"+mustNotBe+"']")));
        deleteTextFromTextarea(By.cssSelector("p-columnfilter[field='"+filter+"'] input[type='text']"));
    }

    public void verifyClientPageFilter(String filter, String text) {
        setClientPageFilter(filter, text);
        waitForSeveralItems(new String[]{text});
        assertTrue(areElementsPresentAfterSorting(By.cssSelector("td[ng-reflect-text='"+text+"']")));
        deleteTextFromTextarea(By.cssSelector("p-columnfilter[field='"+filter+"'] input[type='text']"));
    }

    public void setClientPageFilter(String filter, String text) {
        type(By.cssSelector("p-columnfilter[field='" + filter + "'] input[type='text']"), text);
        pressKeys(Keys.ENTER);
    }

    public void verifyDropDownClientPageFilter(String filter, String text, String mustNotBe) {
        setDropDownClientPageFilter(filter, text);
        waitForSeveralItems(new String[]{text});
        assertTrue(areElementsPresentAfterSorting(By.cssSelector("td[ng-reflect-text='"+text+"']")));
        assertFalse(areElementsPresentAfterSorting(By.cssSelector("td[ng-reflect-text='"+mustNotBe+"']")));
        clearFilter(By.cssSelector("i.p-dropdown-clear-icon"));
    }

    public void verifyDropDownClientPageFilter(String filter, String text) {
        setDropDownClientPageFilter(filter, text);
        waitForSeveralItems(new String[]{text});
        assertTrue(areElementsPresentAfterSorting(By.cssSelector("td[ng-reflect-text='"+text+"']")));
        clearFilter(By.cssSelector("i.p-dropdown-clear-icon"));
    }

    public void verifyClientPageFilterWithCollection(String filter, String text, int index) {
        WebElement fil = driver.findElements(By.cssSelector("p-columnfilter[field='" + filter + "'] input[type='text']")).get(index);
        fil.sendKeys(text);
        pressKeys(Keys.ENTER);
        waitFor(By.cssSelector("td[ng-reflect-text='"+text+"']"));
        assertTrue(areElementsPresentAfterSorting(By.cssSelector("td[ng-reflect-text='"+text+"']")));
        deleteText(fil);
    }

    public void setDropDownClientPageFilter(String filter, String value) {
        click(By.cssSelector("p-columnfilter[field='" + filter + "']"));
        click(By.cssSelector("li[aria-label='" + value + "']"));
        waitFor(By.cssSelector("i.p-dropdown-clear-icon"));
    }

    public void clearFilter(By locator) {
        click(locator);
    }

    public void rejectSupervisor() throws InterruptedException {
        click(By.xpath("//li //span[contains(text(), 'Reject')]"));
        click(By.cssSelector("button[ng-reflect-label='Reject']"));
        waitFor(By.xpath("//*[contains(text(), 'Supervisor was rejected successfully')]"));
        Thread.sleep(2500);
    }

    public String approveSupervisorAndGetTextFromPopUp() {
        waitFor(By.xpath("//li //span[contains(text(), 'Approve')]"));
        click(By.xpath("//li //span[contains(text(), 'Approve')]"));
        String actualPopupText = getTextFromPopUp2(By.cssSelector("div.p-dialog-content"));
        click(By.cssSelector("button[ng-reflect-label='Approve']"));
        waitFor(By.xpath("//*[contains(text(), 'Supervisor was approved successfully')]"));
        return actualPopupText;
    }

    public void approveSupervisor() throws InterruptedException {
        click(By.xpath("//li //span[contains(text(), 'Approve')]"));
        click(By.cssSelector("button[ng-reflect-label='Approve']"));
        waitFor(By.xpath("//*[contains(text(), 'Supervisor was approved successfully')]"));
        Thread.sleep(2500);
    }

    public String rejectSupervisorAndGetTextFromPopUp() {
        waitFor(By.xpath("//li //span[contains(text(), 'Reject')]"));
        click(By.xpath("//li //span[contains(text(), 'Reject')]"));
        String actualPopupText = getTextFromPopUp2(By.cssSelector("div.p-dialog-content"));
        click(By.cssSelector("button[ng-reflect-label='Reject']"));
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
        click(By.cssSelector("li[aria-label=" + text + "]"));
        waitFor(By.cssSelector("i.p-dropdown-clear-icon"));
    }

    public void setClientPageFilter_messageTab(final String filter, String text) {
        type(By.cssSelector("p-columnfilter[ng-reflect-field='" + filter + "'] input[type='text']"), text);
        pressKeys(Keys.ENTER);
    }
}