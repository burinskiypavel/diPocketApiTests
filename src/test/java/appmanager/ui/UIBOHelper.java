package appmanager.ui;

import appmanager.UIHelperBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import padeObjects.bo.CBOHomePage;

import java.util.List;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class UIBOHelper extends UIHelperBase {
    //public WebDriver driver;
    //public WebDriverWait wait;

    public UIBOHelper(WebDriver driver) {
        super(driver);
    }

    public void gotoBOSiteAndLoginWithBOUserRole(String login, String password) throws InterruptedException {
        driver.navigate().to("https://support.dipocket.dev/NgBOTool/");
        waitForSeveralItems(new String[]{"Login:", "Password:", "Log in"});
        type(By.cssSelector("input[type='text']"), login);
        type(By.cssSelector("input[type='password']"), password);
        Thread.sleep(500);
        click(By.cssSelector("button[type='submit']"));
        enterSecureCode("123456");
        waitForSeveralItems(new String[]{"Search", "Take Ticket", "Logout"});
    }

    public void gotoBOSiteAndLoginWithCBOUserRole(String login, String password) throws InterruptedException {
        driver.navigate().to("https://support.dipocket.dev/NgBOTool/");
        waitForSeveralItems(new String[]{"Login:", "Password:", "Log in"});
        type(By.cssSelector("input[type='text']"), login);
        type(By.cssSelector("input[type='password']"), password);
        Thread.sleep(500);
        click(By.cssSelector("button[type='submit']"));
        enterSecureCode("123456");
        waitForSeveralItems(new String[]{"Tickets", "BO Users", "Search", "Operations", "Reports"});
    }

    public void enterSecureCode(String secureCode) {
        waitFor(By.id("formly_3_input_secureCode_0"));
        type(By.id("formly_3_input_secureCode_0"), secureCode);
        click(By.cssSelector("app-two-factor-auth-modal button[type='submit']"));
    }

    public void gotoBOUsersPage() {
        //click(By.xpath("//p[contains(text(), 'BO Users')]"));
        CBOHomePage cboHomePage = new CBOHomePage(driver);
        cboHomePage.gotoBOUsers();
        waitFor(By.xpath("//span[contains(text(), 'Active users')]"));
    }

    public void gotoSearchPage() {
        click(By.cssSelector("div[ng-reflect-router-link='search']"));
        waitFor(By.xpath("//*[contains(text(), 'Card')]"));
    }

    public void gotoOperations() {
        click(By.cssSelector("div[ng-reflect-router-link='operations']"));
        //waitFor(By.xpath("//*[contains(text(), 'Add merchant')]"));
        waitFor(By.xpath("//a[@role='tab'] //span[contains(text(), 'Fee tariff plan')]"));
    }

    public void gotoRolesTab() {
        click(By.id("p-tabpanel-3-label"));
    }

    public void goToTilesTab() {
        click(By.id("p-tabpanel-2-label"));
    }

    public void goToMessagesTab() {
        click(By.id("p-tabpanel-3-label"));
    }

    public void goToClientIBANTab() {
        click(By.id("p-tabpanel-4-label"));
    }

    public void goToPayeeTab() {
        click(By.id("p-tabpanel-5-label"));
        waitFor(By.cssSelector("p-columnfilter[field='nickName']"));
    }

    public void gotoAllUsersTab() {
        click(By.id("p-tabpanel-1-label"));
    }

    public void gotoCardSearchTab() {
        click(By.id("p-tabpanel-1-label"));
    }

    public void gotoFeeTariffPlanTab() {
        click(By.xpath("//a[@role='tab'] //span[contains(text(), 'Fee tariff plan')]"));
    }

    public void gotoLimitPlanTab() {
        click(By.xpath("//a[@role='tab'] //span[contains(text(), 'Limit plan')]"));
    }

    public void gotoResetSMSCounterTab() {
        click(By.xpath("//a[@role='tab'] //span[contains(text(), 'Reset SMS counter')]"));
    }

    public void gotoBankTransfersTab() {
        click(By.xpath("//a[@role='tab'] //span[contains(text(), 'Bank transfers')]"));
    }

    public void addRole(String roleID, String roleName) throws InterruptedException {
        click(By.cssSelector("p-button[label='+ Add']"));
        waitForSeveralItems(new String[]{"Role ID:", "Role name:", "Add Role"});
        type(By.cssSelector("app-input[ng-reflect-name='roleId'] input[type='text']"), roleID);
        type(By.cssSelector("app-input[ng-reflect-name='roleName'] input[type='text']"), roleName);
        Thread.sleep(500);
        click(By.cssSelector("p-button[ng-reflect-label='Add']"));
    }

    public void selectRoleFromDropDown(final String name) {
        click(By.cssSelector("p-dropdown[placeholder='Role']"));
        waitFor(By.cssSelector("li[aria-label='" + name + "']"));
        click(By.cssSelector("li[aria-label='" + name + "']"));
        waitFor(By.cssSelector("div[role='checkbox']"));
    }

    public void editUserRole(String roleName) throws InterruptedException {
        click(By.cssSelector("p-button[label='Edit']"));
        type(By.cssSelector("div[role='dialog'] input[type='text']"), roleName);
        Thread.sleep(500);
        click(By.cssSelector("div[role='dialog'] p-button[ng-reflect-label='Edit']"));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div[role='dialog'] app-button[ng-reflect-label='Edit']")));
    }

    public void deleteRole() {
        click(By.cssSelector("p-button[label='Delete']"));
        click(By.cssSelector("app-role-delete-modal app-button[label='Delete']"));
        waitFor(By.xpath("//div[contains(text(), 'User role deleted successfully')]"));
    }

    public void selectBOUser(String text) throws InterruptedException {
        click(By.cssSelector("p-tabpanel[header='All users'] td[ng-reflect-text='" + text + "']"));
        Thread.sleep(500);
    }

    public void searchBOUser(String tabPanel, String filter, String text) {
        type(By.cssSelector("p-tabpanel[header='" + tabPanel + "'] p-columnfilter[field='" + filter + "'] input[type='text']"), text);
        pressKeys(Keys.ENTER);
    }

    public void searchAndSelectBOUser(String tabPanel, String filter, String text) throws InterruptedException {
        searchBOUser(tabPanel, filter, text);
        selectBOUser(text);
    }

    public void editUser(String firsname) throws InterruptedException {
        Thread.sleep(700);
        type(By.cssSelector("app-input[ng-reflect-name='firstName'] input[type='text']"), firsname);
        Thread.sleep(1500);
        click(By.cssSelector("p-button[ng-reflect-label='Edit user']"));
        waitFor(By.xpath("//*[contains(text(), 'User updated successfully')]"));
    }

    public void fillBOUserFieldsInPopup(String firstname, String lastname, String phone, String email, String username) {
        type(By.cssSelector("app-input[ng-reflect-name='firstName'] input[type='text']"), firstname);
        type(By.cssSelector("app-input[ng-reflect-name='lastName'] input[type='text']"), lastname);
        type(By.cssSelector("app-input-number[ng-reflect-name='phone'] input.p-inputtext"), phone);
        type(By.cssSelector("app-input[ng-reflect-name='email'] input[type='text']"), email);
        type(By.cssSelector("app-input[ng-reflect-name='username'] input[type='text']"), username);
    }

    public boolean isButtonEnabled2(By locator) {
        boolean enabled = false;
        WebElement element = driver.findElements(locator).get(1);
        boolean disabled = Boolean.parseBoolean(element.getAttribute("ng-reflect-disabled"));
        System.out.println(disabled);

        if(disabled){
            return false;
        } else if (disabled == false){
            enabled  = true;
        }

        return enabled;
    }

    public boolean isButtonEnabled3(By locator) {
        boolean enabled = false;
        WebElement element = driver.findElement(locator);
        boolean disabled = Boolean.parseBoolean(element.getAttribute("ng-reflect-disabled"));
        System.out.println(disabled);

        if(disabled){
            return false;
        } else if (disabled == false){
            enabled  = true;
        }

        return enabled;
    }

    public void unblockUser() {
        click(By.cssSelector("app-button[ng-reflect-label='Unblock user']"));
        click(By.cssSelector("app-button[ng-reflect-label='Unblock']"));
        waitFor(By.xpath("//*[contains(text(), 'User unblocked successfully')]"));
    }

    public void blockUser(String blockReason) throws InterruptedException {
        click(By.cssSelector("div.buttons-wrap app-button[ng-reflect-label='Block user']"));
        waitFor(By.cssSelector("div[role='dialog']"));
        waitFor(By.xpath("//*[contains(text(), 'Are you sure want to block user')]"));
        type(By.cssSelector("div[role='dialog'] input[type='text']"), blockReason);
        Thread.sleep(1000);
        click(By.cssSelector("div[role='dialog'] p-button[ng-reflect-label='Block user']"));
        waitFor(By.xpath("//*[contains(text(), 'User blocked successfully')]"));
        waitForInvisibilityOfElement(By.xpath("//*[contains(text(), 'User blocked successfully')]"));
        waitFor(By.cssSelector("td[ng-reflect-text='Blocked']"));
    }

    public void setClientPageFilter(String filter, String text) {
        type(By.cssSelector("p-columnfilter[field='" + filter + "'] input[type='text']"), text);
        pressKeys(Keys.ENTER);
    }

    public void setDropDownClientPageFilter(String filter, String value) {
        click(By.cssSelector("p-columnfilter[field='" + filter + "']"));
        click(By.cssSelector("li[aria-label='" + value + "']"));
        waitFor(By.cssSelector("i.p-dropdown-clear-icon"));
    }

    public void clearFilter(By locator) {
        click(locator);
    }

    public void moveToElementAndPerformContextClick(String accountName) throws InterruptedException {
        moveToElement(By.cssSelector("td[ng-reflect-text='" + accountName + "']"));
        Thread.sleep(1500);
        performContextClick(By.cssSelector("td[ng-reflect-text='" + accountName + "']"));
        waitForElementToBeClickable(By.xpath("//span[contains(text(), 'Block account')]"));
        //Thread.sleep(1000);
    }

    public void unblockAccount() throws InterruptedException {
        click(By.xpath("//span[contains(text(), 'Unblock account')]"));
        click(By.cssSelector("app-button[label='Unblock']"));
        waitFor(By.xpath("//div[contains(text(), 'Account was unblocked successfully')]"));
        Thread.sleep(1500);
    }

    public void boClientPageBlockAccount() throws InterruptedException {
        click(By.xpath("//span[contains(text(), 'Block account')]"));
        click(By.cssSelector("app-button[label='Block']"));
        waitFor(By.xpath("//div[contains(text(), 'Account was blocked successfully')]"));
        Thread.sleep(1500);
    }

    public String blockAccount() {
        click(By.xpath("//span[contains(text(), 'Block account')]"));
        String actualPopupText = getTextFromPopUp2(By.cssSelector("app-block-account-modal p"));
        click(By.cssSelector("app-button[label='Block']"));
        waitFor(By.xpath("//div[contains(text(), 'Account was blocked successfully')]"));
        return actualPopupText;
    }

    public String unblockAccountAndGetPopupText() {
        click(By.xpath("//span[contains(text(), 'Unblock account')]"));
        String actualPopupText = getTextFromPopUp2(By.cssSelector("app-unblock-account-modal p"));
        click(By.cssSelector("app-button[label='Unblock']"));
        waitFor(By.xpath("//div[contains(text(), 'Account was unblocked successfully')]"));
        return actualPopupText;
    }

    public void goToDocsTab() {
        click(By.id("p-tabpanel-7-label"));
    }

    public void goToAccountsTab() {
        click(By.id("p-tabpanel-8-label"));
    }

    public void goTo3rdPartyCardsTab() {
        click(By.id("p-tabpanel-9-label"));
    }

    public void goToTransactionTab() {
        click(By.id("p-tabpanel-10-label"));
        waitFor(By.xpath("//thead //th[contains(text(), 'TranItemId')]"));
    }

    public void goToTicketsTab() {
        click(By.id("p-tabpanel-11-label"));
    }

    public void goToSupervisorRequestsTab() {
        click(By.id("p-tabpanel-12-label"));
        waitFor(By.xpath("//thead //th[contains(text(), 'Request id')]"));
    }

    public void goToClientPage(String phone) {
        click(By.cssSelector("td[ng-reflect-text='"+phone+"']"));
        waitFor(By.cssSelector("p.user-name"));
    }

    public void search(String by, String value, String phone) {
        waitFor(By.cssSelector("app-input-number[ng-reflect-name='" + by + "'] input.p-inputnumber-input"));
        type(By.cssSelector("app-input-number[ng-reflect-name='" + by + "'] input.p-inputnumber-input"), value);
        waitFor(By.cssSelector("td[ng-reflect-text='"+phone+"']"));
    }

    public void search(String by, String value) {
        waitFor(By.cssSelector("app-input-number[ng-reflect-name='" + by + "'] input.p-inputnumber-input"));
        type(By.cssSelector("app-input-number[ng-reflect-name='" + by + "'] input.p-inputnumber-input"), value);
        waitFor(By.cssSelector("td[ng-reflect-text='"+value+"']"));
    }

    public void updateLimits(String lowLimit, String highLimit) throws InterruptedException {
        type(By.cssSelector("p-inputnumber#formly_3_input-number_lowLimit_0 input"), lowLimit);
        type(By.cssSelector("p-inputnumber#formly_3_input-number_highLimit_1 input"), highLimit);
        Thread.sleep(1000);
        click(By.cssSelector("p-button[ng-reflect-label='Save']"));
        waitFor(By.xpath("//div[contains(text(), 'Account limits was changed successfully')]"));
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

    public void unblockCard() throws InterruptedException {
        click(By.xpath("//li //span[contains(text(), 'Unblock card')]"));
        waitFor(By.cssSelector("app-button[ng-reflect-label='Unblock']"));
        click(By.cssSelector("app-button[ng-reflect-label='Unblock']"));
        waitFor(By.xpath("//div[contains(text(), 'Card was unblocked successfully')]"));
        Thread.sleep(4000);
    }

//    public String getNextElementFromTheTable(String cardId, int element) {
//        String actualState = driver.findElement(By.xpath("//td[text() = '"+cardId+"']/following-sibling::td["+element+"]")).getText();
//        return actualState;
//    }

    public void verifyDropDownClientPageFilter(String filter, String text) {
        setDropDownClientPageFilter(filter, text);
        waitForSeveralItems(new String[]{text});
        assertTrue(areElementsPresentAfterSorting(By.cssSelector("td[ng-reflect-text='"+text+"']")));
        clearFilter(By.cssSelector("i.p-dropdown-clear-icon"));
    }

    public void verifyDropDownClientPageFilter(String filter, String text, String mustNotBe) {
        setDropDownClientPageFilter(filter, text);
        waitForSeveralItems(new String[]{text});
        assertTrue(areElementsPresentAfterSorting(By.cssSelector("td[ng-reflect-text='"+text+"']")));
        assertFalse(areElementsPresentAfterSorting(By.cssSelector("td[ng-reflect-text='"+mustNotBe+"']")));
        clearFilter(By.cssSelector("i.p-dropdown-clear-icon"));
    }

    public void verifyClientPageFilter(String filter, String text) {
        setClientPageFilter(filter, text);
        waitForSeveralItems(new String[]{text});
        assertTrue(areElementsPresentAfterSorting(By.cssSelector("td[ng-reflect-text='"+text+"']")));
        deleteTextFromTextarea(By.cssSelector("p-columnfilter[field='"+filter+"'] input[type='text']"));
    }

    public void verifyClientPageFilter(String filter, String text, String mustNotBe) {
        setClientPageFilter(filter, text);
        waitForSeveralItems(new String[]{text});
        assertTrue(areElementsPresentAfterSorting(By.cssSelector("td[ng-reflect-text='"+text+"']")));
        assertFalse(areElementsPresentAfterSorting(By.cssSelector("td[ng-reflect-text='"+mustNotBe+"']")));
        deleteTextFromTextarea(By.cssSelector("p-columnfilter[field='"+filter+"'] input[type='text']"));
    }

    public void verifyDropDownClientPageFilterWithCollection(By by, String text, int index) {
        WebElement filter = driver.findElements(by).get(index);
        filter.click();
        click(By.xpath("//li[@aria-label='" + text + "']"));
        assertTrue(areElementsPresentAfterSorting(By.cssSelector("td[ng-reflect-text='" + text + "']")));
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

    public void searchByTransactionTab(String date) {
        click(By.cssSelector("p-dropdown[optionlabel='value']"));
        click(By.cssSelector("li[aria-label='" + date + "']"));
        click(By.cssSelector("p-button[label='Search']"));
    }

    public void rejectSupervisor() throws InterruptedException {
        click(By.xpath("//li //span[contains(text(), 'Reject')]"));
        click(By.cssSelector("button[ng-reflect-label='Reject']"));
        waitFor(By.xpath("//*[contains(text(), 'Supervisor was rejected successfully')]"));
        Thread.sleep(2500);
    }

    public void approveSupervisor() throws InterruptedException {
        click(By.xpath("//li //span[contains(text(), 'Approve')]"));
        click(By.cssSelector("button[ng-reflect-label='Approve']"));
        waitFor(By.xpath("//*[contains(text(), 'Supervisor was approved successfully')]"));
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

    public String rejectSupervisorAndGetTextFromPopUp() {
        waitFor(By.xpath("//li //span[contains(text(), 'Reject')]"));
        click(By.xpath("//li //span[contains(text(), 'Reject')]"));
        String actualPopupText = getTextFromPopUp2(By.cssSelector("div.p-dialog-content"));
        click(By.cssSelector("button[ng-reflect-label='Reject']"));
        waitFor(By.xpath("//*[contains(text(), 'Supervisor was rejected successfully')]"));
        return actualPopupText;
    }

//    public boolean isElementActiveFromContextMenu(int index) {
//        return driver.findElements(By.cssSelector("li[data-ik='"+index+"'] a[tabindex='0']")).size() != 0;
//    }

    public void blockClient(String reason) throws InterruptedException {
        click(By.xpath("//app-button[@ng-reflect-label='Block client']"));
        type(By.cssSelector("app-dynamic-form input[type='text']"), reason);
        Thread.sleep(1500);
        click(By.xpath("//p-button[@ng-reflect-label='Block']"));
        waitFor(By.xpath("//div[contains(text(), 'Client was blocked successfully')]"));
        waitFor(By.xpath("//span[contains(text(), 'Blocked')]"));
    }

    public void unblockClient() {
        click(By.xpath("//app-button[@ng-reflect-label='Unblock client']"));
        click(By.xpath("//p-button[@ng-reflect-label='Unblock']"));
        waitForInvisibilityOfElement(By.xpath("//div[contains(text(), 'Client was unblocked successfully')]"));
        waitFor(By.xpath("//app-button[@ng-reflect-label='Block client']"));
        waitFor(By.xpath("//span[contains(text(), 'Active')]"));
    }

    public void banClient(String reason) throws InterruptedException {
        click(By.xpath("//app-button[@ng-reflect-label='Ban client']"));
        type(By.cssSelector("app-dynamic-form input[type='text']"), reason);
        Thread.sleep(1500);
        clickCheckbox(By.cssSelector("app-dynamic-form p-checkbox"));
        click(By.xpath("//p-button[@ng-reflect-label='Ban']"));
        waitFor(By.xpath("//div[contains(text(), 'User was ban successfully')]"));
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

    public void unbanClient(String reason) {
        click(By.xpath("//app-button[@ng-reflect-label='Unban client']"));
        type(By.cssSelector("app-dynamic-form input[type='text']"), reason);
        click(By.xpath("//p-button[@ng-reflect-label='Unban']"));
        waitFor(By.xpath("//div[contains(text(), 'Client was unbaned successfully')]"));
        waitFor(By.xpath("//span[contains(text(), 'Active')]"));
    }

    public void forgetClient(String reason) throws InterruptedException {
        click(By.xpath("//app-button[@ng-reflect-label='Forget client']"));
        type(By.cssSelector("app-dynamic-form input[type='text']"), reason);
        Thread.sleep(1500);
        click(By.xpath("//p-button[@ng-reflect-label='Forget']"));
        waitFor(By.xpath("//div[contains(text(), 'Client was forget successfully')]"));
        waitFor(By.xpath("//span[contains(text(), 'Forgotten')]"));
    }

    public void selectFromSelectAddNewUserPage(String select, String text) {
        click(By.cssSelector("app-select-async[ng-reflect-name='" + select + "']"));
        waitFor(By.xpath("//ul[@role='listbox'] //span[contains(text(), '" + text + "')]"));
        click(By.xpath("//ul[@role='listbox'] //span[contains(text(), '" + text + "')]"));
    }

    public void changeCredentialsChagePhoneNumber(String newPhone) throws InterruptedException {
        click(By.xpath("//app-button[@ng-reflect-label='Change credentials']"));
        click(By.xpath("//label[contains(text(), 'Change phone number:')]"));
        waitForInvisibilityOfElement(By.cssSelector("input[placeholder='New phone'][disabled]"));
        type(By.cssSelector("input[placeholder='New phone']"), newPhone);
        Thread.sleep(1000);
        click(By.cssSelector("p-button[ng-reflect-label='Change']"));
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

    public void pressEditProfileDataFromClientPage() throws InterruptedException {
        click(By.cssSelector("div.edit-button"));
        waitFor(By.cssSelector("p-dropdown[id*='select_gender_']"));
        waitFor(By.xpath("//p-button[@ng-reflect-label='Save']"));
        Thread.sleep(1500);
    }

    public void searchByCardBySeveralFields(String cardId, String publicToken, String dipToken, String pan, String clientId, String cardholderName) {
        type(By.xpath("//app-card-tab //app-input-number[@ng-reflect-name='id'] //input"), cardId);
        type(By.xpath("//app-card-tab //app-input[@ng-reflect-name='publicToken'] //input"), publicToken);
        type(By.xpath("//app-card-tab //app-input[@ng-reflect-name='dipToken'] //input"), dipToken);
        type(By.xpath("//app-card-tab //app-input[@ng-reflect-name='pan'] //input"), pan);
        type(By.xpath("//app-card-tab //app-input-number[@ng-reflect-name='clientId'] //input"), clientId);
        type(By.xpath("//app-card-tab //app-input[@ng-reflect-name='cardholderName'] //input"), cardholderName);
    }

    public void searchByCard(String filter, String value) {
        type(By.xpath("//app-card-tab //app-input-number[@ng-reflect-name='"+filter+"'] //input"), value);
    }

    public void gotoCardDetailsPage(String cardId) {
        waitFor(By.xpath("//td[@ng-reflect-text='" + cardId + "']"));
        click(By.xpath("//td[@ng-reflect-text='" + cardId + "']"));
        waitFor(By.xpath("//a[@role='tab'] //span[contains(text(), 'Transactions')]"));
    }

    public void blockAccountFromSearchByCard() {
        waitForElementToBeClickable(By.xpath("//*[contains(text(), 'Block account')]"));
        click(By.xpath("//a[@role='menuitem'] //span[contains(text(), 'Block account')]"));
        click(By.xpath("//app-button[@label='Block']"));
        waitFor(By.xpath("//*[contains(text(), 'Account was blocked successfully')]"));
        waitForInvisibilityOfElement(By.xpath("//*[contains(text(), 'Account was blocked successfully')]"));
    }

    public void unblockAccountFromSearchByCard() {
        waitForElementToBeClickable(By.xpath("//*[contains(text(), 'Unblock account')]"));
        click(By.xpath("//a[@role='menuitem'] //span[contains(text(), 'Unblock account')]"));
        click(By.xpath("//app-button[@label='Unblock']"));
        waitFor(By.xpath("//*[contains(text(), 'Account was unblocked successfully')]"));
        waitForInvisibilityOfElement(By.xpath("//*[contains(text(), 'Account was unblocked successfully')]"));
    }

    public void unblockCardFromSearchByCard() {
        waitForElementToBeClickable(By.xpath("//*[contains(text(), 'Unblock card')]"));
        click(By.xpath("//a[@role='menuitem'] //span[contains(text(), 'Unblock card')]"));
        click(By.xpath("//app-button[@label='Unblock']"));
        waitFor(By.xpath("//*[contains(text(), 'Card was unblocked successfully')]"));
        waitForInvisibilityOfElement(By.xpath("//*[contains(text(), 'Card was unblocked successfully')]"));
    }

    public void blockCardFromSearchByCard() throws InterruptedException {
        waitForElementToBeClickable(By.xpath("//*[contains(text(), 'Block card')]"));
        click(By.xpath("//a[@role='menuitem'] //span[contains(text(), 'Block card')]"));
        click(By.xpath("//p-radiobutton[@ng-reflect-value='41']"));
        Thread.sleep(1200);
        click(By.xpath("//p-button[@ng-reflect-label='Block']"));
        waitFor(By.xpath("//*[contains(text(), 'Card was blocked successfully')]"));
        waitForInvisibilityOfElement(By.xpath("//*[contains(text(), 'Card was blocked successfully')]"));
    }

//    public void selectFromDropDown(String dropdown, String dropdownItem) {
//        click(By.xpath("//p-dropdown[@ng-reflect-option-label='" + dropdown + "']"));
//        waitFor(By.cssSelector("p-dropdownitem li[aria-label='" + dropdownItem + "']"));
//        click(By.cssSelector("p-dropdownitem li[aria-label='" + dropdownItem + "']"));
//    }
//
//    public void selectFromDropDown(By locator, String dropdownItem) throws InterruptedException {
//        driver.findElement(locator).click();
//        waitFor(By.cssSelector("p-dropdownitem li[aria-label='" + dropdownItem + "']"));
//        try{
//            click(By.cssSelector("p-dropdownitem li[aria-label='" + dropdownItem + "']"));
//
//        } catch (org.openqa.selenium.StaleElementReferenceException ex) {
//
//            click(By.cssSelector("p-dropdownitem li[aria-label='" + dropdownItem + "']"));
//        }
//    }

    public void selectDropDownFilter(String dropdown, String dropdownItem) {
        click(By.xpath("//p-columnfilter[@field='" + dropdown + "']"));
        waitFor(By.cssSelector("p-dropdownitem li[aria-label='" + dropdownItem + "']"));
        click(By.cssSelector("p-dropdownitem li[aria-label='" + dropdownItem + "']"));
    }

//    public void selectDropDownFromMultipleElements(By locator, int index, final String item) throws InterruptedException {
//        List<WebElement> elements = driver.findElements(locator);
//        WebElement element = elements.get(index);
//        element.click();
//        waitForElementToBeClickable(By.xpath("//li[@aria-label='" + item + "']"));
//        Thread.sleep(700);
//        click(By.xpath("//li[@aria-label='" + item + "']"));
//    }

    public void fillAndPressDoneManualFeeChargePopUp(String source, String feeDescription, String feeRule, String feeAmount) throws InterruptedException {
        Thread.sleep(1000);
        waitFor(By.xpath("//p-dropdown[@ng-reflect-option-label='accountName']"));
        selectFromDropDown("accountName", source);
        Thread.sleep(1000);
        type(By.cssSelector("app-input[ng-reflect-name='feeTranNote'] input[type='text']"), feeDescription);
        selectFromDropDown("name", feeRule);
        Thread.sleep(1000);
        type(By.cssSelector("app-input-number[ng-reflect-name='amount'] input"), feeAmount);
        Thread.sleep(1500);
        click(By.xpath("//p-button[@ng-reflect-label='Done']"));
    }

    public void goToCardClientInfoTab() {
        click(By.id("p-tabpanel-3-label"));
    }

    public void goToTransactionsTab() {
        click(By.id("p-tabpanel-4-label"));
    }

    public void pressOperationsSelectValueFromOperation(String item) throws InterruptedException {
        click(By.xpath("//app-button[@label='Operations']"));
        Thread.sleep(700);
        waitForElementToBeClickable(By.xpath("//*[contains(text(), '" + item + "')]"));
        click(By.xpath("//a[@role='menuitem'] //span[contains(text(), '" + item + "')]"));
    }

    public void addRowInTariffPlan(String rule, String feePercent, String currency, String feeCurrency, String minFeeAmount, String maxFeeAmount, String flatFeeAmount) throws InterruptedException {
        fillTheFieldsForAddRowInTariffPlan(rule, feePercent, currency, feeCurrency, minFeeAmount, maxFeeAmount, flatFeeAmount);
        Thread.sleep(1000);
        click(By.xpath("//p-button[@label='Add']"));
        waitFor(By.xpath("//*[contains(text(), 'Tariff plan has been successfully added')]"));
    }

    public void fillTheFieldsForAddRowInTariffPlan(String rule, String feePercent, String currency, String feeCurrency, String minFeeAmount, String maxFeeAmount, String flatFeeAmount) throws InterruptedException {
        click(By.xpath("//p-button[@ng-reflect-label='+ Add row']"));
        waitFor(By.cssSelector("p-dropdown[id*='select_ruleId_0']"));
        selectFromDropDown(By.cssSelector("p-dropdown[id*='select_ruleId_0']"), rule);
        type(By.cssSelector("p-inputnumber[id*='input-number_feePercent_3'] input"), feePercent);
        type(By.cssSelector("p-inputnumber[id*='input-number_minFeeAmount_5'] input"), minFeeAmount);
        type(By.cssSelector("p-inputnumber[id*='input-number_maxFeeAmount_6'] input"), maxFeeAmount);
        type(By.cssSelector("p-inputnumber[id*='input-number_flatFeeAmount_4'] input"), flatFeeAmount);
        selectFromDropDown(By.cssSelector("p-dropdown[id*='select_currencyId_1']"), currency);
        selectFromDropDown(By.cssSelector("p-dropdown[id*='select_feeCurrencyId_2']"), feeCurrency);
    }

    public void deleteRow(int index) {
        List<WebElement> elements = driver.findElements(By.xpath("//button[@ng-reflect-icon='pi pi-trash']"));
        WebElement element = elements.get(index);
        element.click();
        waitFor(By.xpath("//*[contains(text(), 'Row deleted successfully')]"));
    }

    public void deleteRow(By locator, int index) {
        List<WebElement> elements = driver.findElements(locator);
        WebElement element = elements.get(index);
        element.click();
        waitFor(By.xpath("//*[contains(text(), 'Row deleted successfully')]"));
    }

    public void duplicateTarifPlan(String id, String name) throws InterruptedException {
        click(By.xpath("//p-button[@ng-reflect-label='Duplicate tariff plan']"));
        type(By.xpath("//app-input-number[@ng-reflect-name='id'] //input"), id);
        type(By.xpath("//app-input[@ng-reflect-name='name'] //input"), name);
        Thread.sleep(1200);
        click(By.xpath("//p-button[@ng-reflect-label='Duplicate']"));
    }

    public void addTarifPlan(String id, String name) throws InterruptedException {
        click(By.xpath("//p-button[@ng-reflect-label='Add tariff plan']"));
        type(By.xpath("//app-input-number[@ng-reflect-name='id'] //input"), id);
        type(By.xpath("//app-input[@ng-reflect-name='name'] //input"), name);
        Thread.sleep(1500);
        click(By.xpath("//p-button[@ng-reflect-label='Add']"));
    }

    public void deleteTarifPlan(String name) throws InterruptedException {
        click(By.xpath("//p-button[@ng-reflect-label='Delete tariff plan']"));
        waitFor(By.xpath("//app-delete-tariff-plan-modal //*[contains(text(), '"+name+"')]"));
        Thread.sleep(1200);
        click(By.xpath("//p-button[@ng-reflect-label='Delete']"));
    }

    public void pressPencilEditButton(int index) {
        WebElement pencil = driver.findElements(By.xpath("//button[@icon='pi pi-pencil']")).get(index);
        pencil.click();
    }

    public void pressPencilEditButton(By locator) {
        driver.findElement(locator).click();
    }

    public void selectFeeTariffPlanAndSelectRuleFilterInTheTable(String feeTariffPlan, String rule) throws InterruptedException {
        selectFromDropDown("name", feeTariffPlan);
        Thread.sleep(1000);
        selectDropDownFilter("ruleName", rule);
    }

    public void renameTariffPlan(String newName) throws InterruptedException {
        click(By.xpath("//p-button[@ng-reflect-label='Rename tariff plan']"));
        waitFor(By.xpath("//app-input[@ng-reflect-name='name'] //input"));
        type(By.xpath("//app-input[@ng-reflect-name='name'] //input"), newName);
        Thread.sleep(1000);
        click(By.xpath("//p-button[@ng-reflect-label='Rename']"));
        waitFor(By.xpath("//div[contains(text(), 'Tariff plan renamed successfully')]"));
    }

    public void addRowInLimitPlan(String limitAmount, String group, String type) throws InterruptedException {
        click(By.xpath("//app-limit-plan-tab //p-button[@ng-reflect-label='+ Add row']"));
        type(By.xpath("//app-input-number[@ng-reflect-name='limitAmount'] //input"), limitAmount);
        selectFromDropDown(By.xpath("//app-select-async[@ng-reflect-name='tranGroupId']"), group);
        selectFromDropDown(By.xpath("//app-select-async[@ng-reflect-name='typeId']"), type);
        Thread.sleep(1500);
        click(By.xpath("//p-button[@ng-reflect-label='Add']"));
        waitFor(By.xpath("//*[contains(text(), 'Limit plan has been successfully added')]"));
    }

    public void editTariffPlanRow(String rule, String currency, String feePercent, String feeCurrency, String minFeeAmount, String maxFeeAmount, String flatFeeAmount) throws InterruptedException {
        selectFromDropDown(By.xpath("//app-fee-tariff-plan-tab //tbody //td[2] //p-dropdown"), rule);
        selectFromDropDown(By.xpath("//app-fee-tariff-plan-tab //tbody //td[4] //p-dropdown"), currency);
        type(By.xpath("//app-fee-tariff-plan-tab //tbody //td[5] //input"), feePercent);
        selectFromDropDown(By.xpath("//app-fee-tariff-plan-tab //tbody //td[6] //p-dropdown"), feeCurrency);
        type(By.xpath("//app-fee-tariff-plan-tab //tbody //td[7] //input"), minFeeAmount);
        type(By.xpath("//app-fee-tariff-plan-tab //tbody //td[8] //input"), maxFeeAmount);
        type(By.xpath("//app-fee-tariff-plan-tab //tbody //td[9] //input"), flatFeeAmount);
        click(By.xpath("//button[@ng-reflect-icon='pi pi-check']"));
        waitFor(By.xpath("//*[contains(text(), 'Row added successfully')]"));
    }

    public void editLimitPlanRow(String group, String type, String amount) throws InterruptedException {
        selectFromDropDown(By.xpath("//app-limit-plan-tab //tbody //td[2] //p-dropdown"), group);
        selectFromDropDown(By.xpath("//app-limit-plan-tab //tbody //td[3] //p-dropdown"), type);
        typeWithSeveralClear(By.xpath("//app-limit-plan-tab //tbody //td[4] //input"), amount);
        click(By.xpath("//button[@ng-reflect-icon='pi pi-check']"));

        waitFor(By.xpath("//*[contains(text(), 'Row added successfully')]"));
    }

    public void pressXCancelButton(By locator) {
        click(locator);
    }

    public void duplicateLimitPlan(String id, String name) throws InterruptedException {
        click(By.xpath("//app-button[@ng-reflect-label='Duplicate limit plan']"));
        type(By.xpath("//app-input-number[@ng-reflect-name='id'] //input"), id);
        type(By.xpath("//app-input[@ng-reflect-name='name'] //input"), name);
        Thread.sleep(1500);
        click(By.xpath("//p-button[@ng-reflect-label='Duplicate']"));
    }

    public void renameLimitPlan(String name) {
        click(By.xpath("//app-button[@ng-reflect-label='Rename limit plan']"));
        type(By.xpath("//app-input[@ng-reflect-name='name'] //input"), name);
        click(By.xpath("//p-button[@ng-reflect-label='Rename']"));
    }

    public void selectLimitPlan(String limitPlan) throws InterruptedException {
        selectFromDropDown(By.xpath("//div[@class='dropdowns'] //p-dropdown[@optionlabel='name']"), limitPlan);
    }

    public void deleteLimitPlan() throws InterruptedException {
        click(By.xpath("//app-button[@ng-reflect-label='Delete limit plan']"));
        Thread.sleep(1500);
        click(By.xpath("//p-button[@ng-reflect-label='Delete']"));
    }

    public void addLimitPlan(String id, String name) throws InterruptedException {
        click(By.xpath("//app-button[@ng-reflect-label='Add limit plan']"));
        type(By.xpath("//app-input-number[@ng-reflect-name='id'] //input"), id);
        type(By.xpath("//app-input[@ng-reflect-name='name'] //input"), name);
        Thread.sleep(1500);
        click(By.xpath("//p-button[@ng-reflect-label='Add']"));
        waitFor(By.xpath("//*[contains(text(), 'Tariff limit added successfully')]"));
    }

    public void selectsTransfer(By locator) {
        click(locator);
    }

    public void searchForPeriod(String from, String till) throws InterruptedException {
        selectFromDropDown(By.xpath("//app-search-by-period //p-dropdown[@optionlabel='value']"), "For period");
        type(By.xpath("//p-calendar[@placeholder='From'] //input"), from);
        type(By.xpath("//p-calendar[@placeholder='Till'] //input"), till);
        click(By.xpath("//p-button[@label='Search']"));
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
}