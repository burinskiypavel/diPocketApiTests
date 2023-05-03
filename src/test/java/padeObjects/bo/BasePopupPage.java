package padeObjects.bo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePopupPage {

    WebDriver driver;

    public BasePopupPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "svg.p-dialog-header-close-icon")
    public WebElement closePopupBtn;
}