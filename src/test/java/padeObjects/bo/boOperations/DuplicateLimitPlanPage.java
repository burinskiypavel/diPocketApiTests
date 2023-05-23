package padeObjects.bo.boOperations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DuplicateLimitPlanPage {
    WebDriver driver;

    public DuplicateLimitPlanPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//app-input-number[@ng-reflect-name='id'] //input")
    public WebElement idInput;

    @FindBy(xpath = "//app-input[@ng-reflect-name='name'] //input")
    public WebElement nameInput;

    @FindBy(xpath = "//p-button[@ng-reflect-label='Duplicate']")
    public WebElement duplicateBtn;

    @FindBy(xpath = "//*[contains(text(), 'Tariff limit duplicated successfully')]")
    public WebElement successMessage;
}