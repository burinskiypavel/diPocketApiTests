package padeObjects.bo.boClient;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BanClientPage {
    WebDriver driver;

    public BanClientPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "input[id*=blockOrBanReason]")
    public WebElement banReasonInput;

    @FindBy(xpath = "//p-button[@ng-reflect-label='Confirm']")
    public WebElement confirmBtn;

    @FindBy(css = "p-checkbox[id*='blockClientDevice']")
    public WebElement blockClientDeviceCheckbox;
}
