package padeObjects.bo.boClient;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BlockClientPage {
    WebDriver driver;

    public BlockClientPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "input[id*=input_blockOrBanReason]")
    public WebElement blockReasonInput;

    @FindBy(xpath = "//p-button[@ng-reflect-label='Block']")
    public WebElement blockBtn;
}
