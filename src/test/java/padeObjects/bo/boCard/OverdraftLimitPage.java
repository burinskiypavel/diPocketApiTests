package padeObjects.bo.boCard;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OverdraftLimitPage {
    WebDriver driver;

    public OverdraftLimitPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//p-inputnumber[contains(@id, 'input-number_lowLimit')] //input")
    public WebElement lowLimitInput;

    @FindBy(xpath = "//p-inputnumber[contains(@id, 'input-number_highLimit')] //input")
    public WebElement highLimitInput;

    @FindBy(xpath = "//p-button[@ng-reflect-label='Save']")
    public WebElement saveBtn;
}