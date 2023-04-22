package padeObjects.bo.boClient;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClientPage {
    WebDriver driver;

    public ClientPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//p-button[@ng-reflect-label='Ban client']")
    public WebElement banClientBtn;

    @FindBy(xpath = "//p-button[@ng-reflect-label='Unban client']")
    public WebElement unbanClientBtn;

    @FindBy(xpath = "//p-button[@ng-reflect-label='Unblock client']")
    public WebElement unblockClientBtn;

    @FindBy(xpath = "//p-button[@ng-reflect-label='Block client']")
    public WebElement blockClientBtn;

    @FindBy(xpath = "//p-button[@ng-reflect-label='Change credentials']")
    public WebElement changeCredentialsBtn;

    @FindBy(xpath = "//p-button[@ng-reflect-label='Forget client']")
    public WebElement forgetClientBtn;

}