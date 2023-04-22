package padeObjects.bo.boClient;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UnbanClientPage {
    WebDriver driver;

    public UnbanClientPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "input[id*='input_unblockOrUnbanReason']")
    public WebElement unbanReasonInput;

    @FindBy(xpath = "//p-button[@ng-reflect-label='Confirm']")
    public WebElement confirmBtn;

}