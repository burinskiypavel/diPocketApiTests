package padeObjects.bo.boTicket;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RejectTicketPage {
    WebDriver driver;

    public RejectTicketPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//app-input[@ng-reflect-name='reason'] //input")
    public WebElement reasonInput;

    @FindBy(xpath = "//app-reject-modal //p-button[@ng-reflect-label='Reject']")
    public WebElement rejectBtn;
}