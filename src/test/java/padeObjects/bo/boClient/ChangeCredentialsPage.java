package padeObjects.bo.boClient;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChangeCredentialsPage {
    WebDriver driver;

    public ChangeCredentialsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "p-checkbox[id*='checkbox_changePIN']")
    public WebElement changePasswordCheckbox;

    @FindBy(css = "p-checkbox[id*='checkbox_changeSecretAnswer']")
    public WebElement changeSecretAnswerCheckbox;

    @FindBy(css = "p-checkbox[id*='checkbox_changeMainPhone']")
    public WebElement changeMainPhoneCheckbox;

    @FindBy(xpath = "//p-button[@ng-reflect-label='Confirm']")
    public WebElement confirmBtn;
}