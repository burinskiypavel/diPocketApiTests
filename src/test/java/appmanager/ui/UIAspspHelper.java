package appmanager.ui;

import appmanager.UIHelperBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class UIAspspHelper extends UIHelperBase {
    String uiTransactionCode = null;
    public UIAspspHelper(WebDriver driver) {
        super(driver);
    }
    public String webConfirmaton(String href, String phone, String pass) {
        driver.navigate().to(href);
        waitFor(By.id("phone-number"));
        driver.findElement(By.id("phone-number")).sendKeys(phone);
        driver.findElement(By.id("password")).sendKeys(pass);
        driver.findElement(By.xpath("//button[@data-dip-action='login']")).click();
        waitFor(By.xpath("//*[contains(text(), 'Please go to DiPocket Mobile Application to confirm your authorization attempt')]"));
        uiTransactionCode = driver.findElement(By.id("transaction-code")).getText();
        return uiTransactionCode;
    }

    public void pressConsent(){
        waitFor(By.xpath("//button[contains(text(), 'Consent')]"));
        findElement(By.xpath("//button[contains(text(), 'Consent')]")).click();
        wait.until(ExpectedConditions.titleIs("Google"));
    }

    public void selectAccount(String iban){
        waitFor(By.xpath("//span[contains(text(), '"+iban+"')]"));
        findElement(By.xpath("//span[contains(text(), '"+iban+"')]")).click();
    }
}