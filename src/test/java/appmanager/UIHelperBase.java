package appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UIHelperBase {
    protected WebDriver driver;
    public WebDriverWait wait;

    public UIHelperBase(WebDriver driver) {
        this.driver = driver;
    }

    public void type(By locator, String text){
        driver.findElement(locator).click();
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    public void click(By locator){
        driver.findElement(locator).click();
    }

    public void waitFor(By locator){
        wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitForSeveralItems(String mas []){
        wait = new WebDriverWait(driver, 25);
        for(int i = 0; i < mas.length; i++){
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(), '"+mas[i]+"')]")));
        }
    }
}
