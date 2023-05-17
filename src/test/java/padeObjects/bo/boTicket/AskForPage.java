package padeObjects.bo.boTicket;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AskForPage {
    WebDriver driver;

    public AskForPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//p-checkbox[@ng-reflect-input-id='Id']")
    public WebElement idCheckbox;

    @FindBy(xpath = "//p-checkbox[@ng-reflect-input-id='Proof of address']")
    public WebElement proofOfAddressCheckbox;

    @FindBy(xpath = "//p-checkbox[@ng-reflect-input-id='Back of id']")
    public WebElement backOfIdCheckbox;

    @FindBy(xpath = "//p-checkbox[@ng-reflect-input-id='Residence permit']")
    public WebElement residencePermitCheckbox;

    @FindBy(xpath = "//app-button[@label='Send']")
    public WebElement sendBtn;
}