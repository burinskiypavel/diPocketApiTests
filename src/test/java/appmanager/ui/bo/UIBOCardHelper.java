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
}