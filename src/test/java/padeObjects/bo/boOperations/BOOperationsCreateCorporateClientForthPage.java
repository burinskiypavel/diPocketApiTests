package padeObjects.bo.boOperations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BOOperationsCreateCorporateClientForthPage {
    WebDriver driver;

    public BOOperationsCreateCorporateClientForthPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//app-input[@ng-reflect-name='accName'] //input")
    public WebElement accountName;

    @FindBy(xpath = "//app-select-async[@ng-reflect-name='accType']")
    public WebElement accountType;

    @FindBy(xpath = "//p-button[@ng-reflect-label='Next']")
    public WebElement nextBtn;

    public void setAccountName(String text){
        accountName.click();
        accountName.clear();
        accountName.sendKeys(text);
    }

    public void pressNext(){
        nextBtn.click();
    }
}