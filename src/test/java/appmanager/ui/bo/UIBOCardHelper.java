package appmanager.ui.bo;

import appmanager.UIHelperBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;
import padeObjects.bo.boCard.CardDetailsPage;
import padeObjects.bo.boCard.OverdraftLimitPage;
import padeObjects.bo.search.CardSearchPage;
import padeObjects.bo.search.ClientSearchPage;

public class UIBOCardHelper extends UIHelperBase {
    CardDetailsPage cardDetailsPage = new CardDetailsPage(driver);
    OverdraftLimitPage overdraftLimitPage = new OverdraftLimitPage(driver);
    CardSearchPage cardSearchPage = new CardSearchPage(driver);
    ClientSearchPage clientSearchPage = new ClientSearchPage(driver);

    public UIBOCardHelper(WebDriver driver) {
        super(driver);
    }

    public void resetEpin() {
        //waitForElementToBeClickable(By.xpath("//*[contains(text(), 'Reset ePin')]"));
        waitForElementToBeClickable(cardDetailsPage.resetEPinMenuitem);
        click(cardDetailsPage.resetEPinMenuitem);
        click(By.xpath("//p-button[@ng-reflect-label='Proceed']"));
        waitFor(By.xpath("//*[contains(text(), 'Card ePin has been successfully reset')]"));
    }

    public void pressShowClientInfo() throws InterruptedException {
        waitFor(cardDetailsPage.showClientInfoBtn);
        click(cardDetailsPage.showClientInfoBtn);
        waitForElementToBeClickable(By.xpath("//app-client-details //p"));
        waitFor(By.cssSelector("div.buttons-wrap"));
        Thread.sleep(700);
    }

    public void clickAccountsLimits() {
        waitForElementToBeClickable(By.xpath("//*[contains(text(), 'Account limits')]"));
        click(By.xpath("//a[@role='menuitem'] //span[contains(text(), 'Account limits')]"));
        waitFor(By.xpath("//table //th[contains(text(), 'Name')]"));
    }

    public void clickOperations() {
        waitFor(cardDetailsPage.operationsBtn);
        click(cardDetailsPage.operationsBtn);
        waitForElementToBeClickable(By.xpath("//*[contains(text(), 'Account limits')]"));
    }

    public void clickBackToSearch() {
        waitFor(cardDetailsPage.backToSearchBtn);
        click(cardDetailsPage.backToSearchBtn);
        waitFor(By.id("searchContent"));
    }

    public void blockAccount() {
        waitForElementToBeClickable(By.xpath("//*[contains(text(), 'Block account')]"));
        click(By.xpath("//a[@role='menuitem'] //span[contains(text(), 'Block account')]"));
        click(By.xpath("//p-button[@label='Block']"));
        waitFor(By.xpath("//*[contains(text(), 'Account was blocked successfully')]"));
        waitForInvisibilityOfElement(By.xpath("//*[contains(text(), 'Account was blocked successfully')]"));
    }

    public void unblockAccount() {
        waitForElementToBeClickable(cardDetailsPage.unblockAccountMenuitem);
        click(cardDetailsPage.unblockAccountMenuitem);
        click(By.xpath("//app-button[@label='Unblock']"));
        waitFor(By.xpath("//*[contains(text(), 'Account was unblocked successfully')]"));
        waitForInvisibilityOfElement(By.xpath("//*[contains(text(), 'Account was unblocked successfully')]"));
    }

    public void unblockCard() {
        waitForElementToBeClickable(By.xpath("//*[contains(text(), 'Unblock card')]"));
        click(By.xpath("//a[@role='menuitem'] //span[contains(text(), 'Unblock card')]"));
        click(By.xpath("//app-button[@label='Unblock']"));
        waitFor(By.xpath("//*[contains(text(), 'Card was unblocked successfully')]"));
        waitForInvisibilityOfElement(By.xpath("//*[contains(text(), 'Card was unblocked successfully')]"));
    }

    public void resendPIN() {
        waitFor(cardDetailsPage.ResendPINMenuitem);
        click(cardDetailsPage.ResendPINMenuitem);
        waitFor(By.xpath("//p-button[@ng-reflect-label='Proceed']"));
        click(By.xpath("//p-button[@ng-reflect-label='Proceed']"));
        waitFor(By.xpath("//*[contains(text(), 'PIN was successfully resent')]"));
    }

    public void overdraftLimit(String lowLimit, String highLimit) {
        waitFor(cardDetailsPage.overdraftLimitMenuitem);
        click(cardDetailsPage.overdraftLimitMenuitem);
        waitFor(overdraftLimitPage.lowLimitInput);
        type(overdraftLimitPage.lowLimitInput, lowLimit);
        type(overdraftLimitPage.highLimitInput, highLimit);
        click(overdraftLimitPage.saveBtn);
        waitFor(By.xpath("//*[contains(text(), 'Account limits was changed successfully')]"));
    }

    public void goToTransactionsTab() {
        waitFor(cardDetailsPage.transactionsTab);
        click(cardDetailsPage.transactionsTab);
        waitFor(By.xpath("//p-button[@ng-reflect-label='Search']"));
    }

    public void searchByTime(String dropdownItem) {
        selectFromDropDown("value", dropdownItem);
        click(By.xpath("//p-button[@ng-reflect-label='Search']"));
    }

    public SoftAssert verifyCardSearchInputFields(SoftAssert softAssert) {
        softAssert.assertFalse(!areElementsPresent(new String[]{
                "//p-tabpanel[@header='Card'] //input[contains(@id, 'input_id')]", "//p-tabpanel[@header='Card'] //input[contains(@id, 'input_publicToken')]",
                "//p-tabpanel[@header='Card'] //input[contains(@id, 'input_dipToken')]", "//p-tabpanel[@header='Card'] //input[contains(@id, 'input_pan')]",
                "//p-tabpanel[@header='Card'] //input[contains(@id, 'input_clientId')]", "//p-tabpanel[@header='Card'] //input[contains(@id, 'input_cardholderName')]",}), "CardSearchInputFields");
        return softAssert;
    }

    public SoftAssert verifyCardSearchInputFields2(SoftAssert softAssert) {
        softAssert.assertFalse(!areElementsPresent(new WebElement[]{
                cardSearchPage.idInput, cardSearchPage.publicTokenInput,
                cardSearchPage.dipTokenInput, cardSearchPage.panInput,
                cardSearchPage.clientIdInput, cardSearchPage.cardholderNameInput}), "Card search input fields");
        return softAssert;
    }

    public SoftAssert verifyClientAndCardTabsPresent(SoftAssert softAssert) {
        softAssert.assertFalse(!isTabPresent(clientSearchPage.clientTab), "Client");
        softAssert.assertFalse(!isTabPresent(clientSearchPage.cardTab), "Card");
        return softAssert;
    }

    public void searchByCardBySeveralFields(String cardId, String publicToken, String dipToken, String pan, String clientId, String cardholderName) {
        type(cardSearchPage.idInput, cardId);
        type(cardSearchPage.publicTokenInput, publicToken);
        type(cardSearchPage.dipTokenInput, dipToken);
        type(cardSearchPage.panInput, pan);
        type(cardSearchPage.clientIdInput, clientId);
        type(cardSearchPage.cardholderNameInput, cardholderName);
        waitFor(By.xpath("//td //span[@ng-reflect-text='"+cardId+"']"));

    }

    public SoftAssert verifySearchInformationPresentInSearchResults(SoftAssert softAssert, String cardId, String publicToken, String dipToken, String clientId, String cardholderName) {
        softAssert.assertTrue(areElementsPresent(new String[]{"//td //span[@ng-reflect-text='"+cardId+"']", "//td //span[@ng-reflect-text='"+publicToken+"']",
                "//td //span[@ng-reflect-text='"+dipToken+"']", "//td //span[@ng-reflect-text='"+clientId+"']",
                "//td //span[@ng-reflect-text='"+cardholderName+"']"}), "Incorrect data in the table results");
        return softAssert;
    }
}