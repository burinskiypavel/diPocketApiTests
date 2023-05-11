package padeObjects.bo.boClient;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UploadSelfiesPage {
    WebDriver driver;

    public UploadSelfiesPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "p-fileupload[id*='upload-image_base64Selfie1'] input[type='file']")
    public WebElement selfie1;

    @FindBy(css = "p-fileupload[id*='upload-image_base64Selfie2'] input[type='file']")
    public WebElement selfie2;

    @FindBy(xpath = "//p-button[@ng-reflect-label='Confirm']")
    public WebElement confirmBtn;
}
