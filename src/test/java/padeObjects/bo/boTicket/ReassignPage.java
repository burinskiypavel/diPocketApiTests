package padeObjects.bo.boTicket;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReassignPage {
    WebDriver driver;

    public ReassignPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//app-reassign-modal //p-button[@ng-reflect-label='Reassign']")
    public WebElement reassignBtn;

    @FindBy(css = "app-input[ng-reflect-name='reason'] input")
    public WebElement reassignrReasonInput;

    @FindBy(xpath = "//app-select-async[@ng-reflect-name='newUsername']")
    public WebElement usernameDropDown;
}
