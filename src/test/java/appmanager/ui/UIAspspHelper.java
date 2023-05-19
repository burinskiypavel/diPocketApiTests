package appmanager.ui;

import appmanager.DBHelper;
import appmanager.UIHelperBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.sql.SQLException;

public class UIAspspHelper extends UIHelperBase {
    String sms = null;
    String uiTransactionCode = null;
    DBHelper dbHelper = new  DBHelper();

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

    public void everypayWebConfirmaton(String href, String phone, String pass, String clientId) throws SQLException, ClassNotFoundException {
        driver.navigate().to(href);
        waitFor(By.id("phone_number"));
        driver.findElement(By.id("phone_number")).sendKeys(phone);
        driver.findElement(By.id("key")).sendKeys(pass);
        driver.findElement(By.xpath("//button[@id='dpwa-login']")).click();
        waitFor(By.id("verification_code"));
        sms = dbHelper.getCodeFromVERIFYCODEFromTestDB(clientId);
        driver.findElement(By.id("verification_code")).sendKeys(sms);
        click(By.xpath("//button[@data-dip-action='check-code']"));
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