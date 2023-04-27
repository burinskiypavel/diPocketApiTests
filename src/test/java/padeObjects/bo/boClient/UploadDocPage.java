package padeObjects.bo.boClient;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UploadDocPage {
    WebDriver driver;

    public UploadDocPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//p-dropdown[contains(@id, 'typeId')]")
    public WebElement typeIdDropDown;

    @FindBy(xpath = "//p-button[@ng-reflect-label='Confirm']")
    public WebElement confirmBtn;

}