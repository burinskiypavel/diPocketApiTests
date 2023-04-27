package appmanager.ui.bo;

import appmanager.UIHelperBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UIBOCardHelper extends UIHelperBase {

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
        click(By.xpath("//app-button[@ng-reflect-label='Show client info']"));
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
        click(By.xpath("//app-button[@label='Operations']"));
        waitForElementToBeClickable(By.xpath("//*[contains(text(), 'Account limits')]"));
    }
}