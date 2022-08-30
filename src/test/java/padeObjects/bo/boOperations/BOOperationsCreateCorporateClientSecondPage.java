package padeObjects.bo.boOperations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BOOperationsCreateCorporateClientSecondPage {
    WebDriver driver;

    public BOOperationsCreateCorporateClientSecondPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//app-select-async[@ng-reflect-name='country']")
    public WebElement countryDropdown;

    @FindBy(xpath = "//app-input[@ng-reflect-name='zip'] //input")
    public WebElement postalCode;

    @FindBy(xpath = "//app-input[@ng-reflect-name='city'] //input")
    public WebElement city;

    @FindBy(xpath = "//app-input[@ng-reflect-name='streetLine1'] //input")
    public WebElement address;

    @FindBy(xpath = "//app-input[@ng-reflect-name='state'] //input")
    public WebElement state;

    @FindBy(xpath = "//app-input[@ng-reflect-name='streetLine2'] //input")
    public WebElement addressLine2;

    @FindBy(xpath = "//app-field-label[@ng-reflect-label='Use this as mailing']")
    public WebElement useThisAsMailingCheckbox;

    @FindBy(xpath = "//p-button[@ng-reflect-label='Next']")
    public WebElement nextBtn;

    public void setPostalCode(String text){
        postalCode.click();
        postalCode.clear();
        postalCode.sendKeys(text);
    }

    public void setCity(String text){
        city.click();
        city.clear();
        city.sendKeys(text);
    }

    public void setAddress(String text){
        address.click();
        address.clear();
        address.sendKeys(text);
    }

    public void setState(String text){
        state.click();
        state.clear();
        state.sendKeys(text);
    }

    public void setAddressLine2(String text){
        addressLine2.click();
        addressLine2.clear();
        addressLine2.sendKeys(text);
    }

    public void pressNext(){
        nextBtn.click();
    }

    public void clickUseThisAsMailingCheckbox(){
        useThisAsMailingCheckbox.click();
    }
}