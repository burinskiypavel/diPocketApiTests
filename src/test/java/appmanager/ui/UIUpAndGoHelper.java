package appmanager.ui;

import appmanager.UIHelperBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class UIUpAndGoHelper extends UIHelperBase {

    public UIUpAndGoHelper(WebDriver driver) {
        super(driver);
    }


    public void gotoUpAndGoSiteAndDoneBasicAuth(String url, String login, String password) {
        //driver.navigate().to("https://dipocket:LeprechauN@telenor-test.dipocket.org");
        driver.navigate().to("https://"+login+":"+password+"@"+url+"");
        waitForSeveralItems(new String[]{"Register your card", "Login", "Check balance and PIN code"});
    }

    public void gotoLoginPageUpAndGo() {
        driver.findElement(By.cssSelector("a[href='/en/cabinet']")).click();
        waitForSeveralItems(new String[]{"Login", "Phone number"});
    }

    public String getTextFromPopUpUpAndGo() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'OK')]")));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div[id='dpwa-alert'][aria-hidden='false']")));
        return driver.findElement(By.cssSelector("div.uk-modal-content")).getText();
    }
}
