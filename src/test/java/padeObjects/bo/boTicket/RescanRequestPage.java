package padeObjects.bo.boTicket;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RescanRequestPage {
    WebDriver driver;

    public RescanRequestPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "p-checkbox[ng-reflect-input-id='Id'")
    public WebElement idCheckbox;

    @FindBy(css = "p-checkbox[ng-reflect-input-id='Proof of address'")
    public WebElement proofOfAddressCheckbox;

    @FindBy(css = "p-checkbox[ng-reflect-input-id='Back of id'")
    public WebElement backOfIdCheckbox;

    @FindBy(css = "p-checkbox[ng-reflect-input-id='Proof of change in name'")
    public WebElement proofOfChangeInNameCheckbox;

    @FindBy(xpath = "//app-button[@label='Send']")
    public WebElement sendBtn;
}