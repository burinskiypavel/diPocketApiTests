package padeObjects.bo.boOperations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RenameLimitPlanPage {
    WebDriver driver;

    public RenameLimitPlanPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//app-input[@ng-reflect-name='name'] //input")
    public WebElement nameInput;

    @FindBy(xpath = "//p-button[@ng-reflect-label='Rename']")
    public WebElement renameBtn;

    @FindBy(xpath = "//*[contains(text(), 'Tariff limit renamed successfully')]")
    public WebElement successMessage;
}