package padeObjects.bo.boOperations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddRowInLimitPlanPage {
    WebDriver driver;

    public AddRowInLimitPlanPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//app-input-number[@ng-reflect-name='limitAmount'] //input")
    public WebElement limitAmountInput;

    @FindBy(xpath = "//app-select-async[@ng-reflect-name='tranGroupId']")
    public WebElement groupDropDown;

    @FindBy(xpath = "//app-select-async[@ng-reflect-name='typeId']")
    public WebElement typeDropDown;

    @FindBy(xpath = "//p-button[@ng-reflect-label='Add']")
    public WebElement addBtn;

    @FindBy(xpath = "//*[contains(text(), 'Limit plan has been successfully added')]")
    public WebElement successMessage;
}