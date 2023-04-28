package appmanager.ui.bo;

import appmanager.UIHelperBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import padeObjects.bo.boCard.CardDetailsPage;
import padeObjects.bo.boCard.OverdraftLimitPage;

public class UIBOCardHelper extends UIHelperBase {
    CardDetailsPage cardDetailsPage = new CardDetailsPage(driver);
    OverdraftLimitPage overdraftLimitPage = new OverdraftLimitPage(driver);

    public UIBOCardHelper(WebDriver driver) {
        super(driver);
    }

    public void resetEpin() {
        waitForElementToBeClickable(By.xpath("//*[contains(text(), 'Reset ePin')]"));
        click(By.xpath("//a[@role='menuitem'] //span[contains(text(), 'Reset ePin')]"));
        click(By.xpath("//p-button[@ng-reflect-label='Proceed']"));
        waitFor(By.xpath("//*[contains(text(), 'Card ePin has been successfully reset')]"));
    }

    public void pressShowClientInfo() throws InterruptedException {
        //click(By.xpath("//app-button[@ng-reflect-label='Show client info']"));
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
        //click(By.xpath("//app-button[@label='Operations']"));
        click(cardDetailsPage.operationsBtn);
        waitForElementToBeClickable(By.xpath("//*[contains(text(), 'Account limits')]"));
    }

    public void clickBackToSearch() {
        click(By.xpath("//app-button[@ng-reflect-label='Back to search']"));
        waitFor(By.id("searchContent"));
    }

    public void unblockAccountFromSearchByCard() {
        waitForElementToBeClickable(By.xpath("//span[contains(text(), 'Unblock account')"));
        click(By.xpath("//a[@role='menuitem'] //span[contains(text(), 'Unblock account')"));
        click(By.xpath("//app-button[@label='Unblock']"));
        waitFor(By.xpath("//*[contains(text(), 'Account was unblocked successfully')]"));
        waitForInvisibilityOfElement(By.xpath("//*[contains(text(), 'Account was unblocked successfully')]"));
    }

    public void resendPIN() {
        //waitForElementToBeClickable(By.xpath("//*[contains(text(), 'Resend PIN')]"));
        waitFor(cardDetailsPage.ResendPINMenuitem);
        //click(By.xpath("//a[@role='menuitem'] //span[contains(text(), 'Resend PIN')]"));
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
}