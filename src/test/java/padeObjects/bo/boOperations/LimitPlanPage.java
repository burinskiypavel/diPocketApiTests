package padeObjects.bo.boOperations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LimitPlanPage {
    WebDriver driver;

    public LimitPlanPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//app-limit-plan-tab //button[@icon='pi pi-pencil']")
    public WebElement pencilEditButton;

    @FindBy(xpath = "//app-limit-plan-tab //p-button[@ng-reflect-label='+ Add row']")
    public WebElement addRowButton;

    @FindBy(xpath = "//button[@ng-reflect-icon='pi pi-trash']")
    public WebElement deleteRowBtn;

    @FindBy(xpath = "//p-button[@ng-reflect-label='Delete limit plan']")
    public WebElement deleteLimitPlanBtn;

    @FindBy(xpath = "//p-button[@ng-reflect-label='Add limit plan']")
    public WebElement addLimitPlanBtn;

    @FindBy(xpath = "//p-button[@ng-reflect-label='Rename limit plan']")
    public WebElement renameLimitPlanBtn;

    @FindBy(xpath = "//p-button[@ng-reflect-label='Duplicate limit plan']")
    public WebElement duplicateLimitPlanBtn;

    @FindBy(xpath = "//div[@class='dropdowns'] //p-dropdown[@optionlabel='name']")
    public WebElement selectLimitPlanDropDown;

    @FindBy(xpath = "//app-limit-plan-tab //button[@icon='pi pi-times']")
    public WebElement xCancelButtonForLimitPlan;
}