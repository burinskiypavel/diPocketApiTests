package padeObjects.bo.boTicket;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TakeTicketEditDataPage {
    WebDriver driver;

    public TakeTicketEditDataPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "p-dropdown[id*='_select_gender_']")
    public WebElement genderDropDown;

    @FindBy(css = "p-dropdown[id*='photoIdTypeId']")
    public WebElement documentTypeDropDown;

    @FindBy(css = "input[id*='_input_photoIdNo_']")
     public WebElement docSerialNumber;

    @FindBy(css = "input[id*='_input_identifyCode_']")
    public WebElement pesel;

    @FindBy(css = "input[id*='identifyCode']")
    WebElement iDCode;

    @FindBy(css = "p-dropdown[id*='_select_photoIdCountryId_']")
    public WebElement docCountryOfIssueDropDown;

    public void clickOnGenderDropDown(){
        genderDropDown.click();
    }

    public void clickOnDocumentTypeDropDown(){
        documentTypeDropDown.click();
    }

    public void setDocSerialNumber(String text){
        docSerialNumber.click();
        docSerialNumber.clear();
        docSerialNumber.sendKeys(text);
    }

    public void setIDCode(String text){
        iDCode.click();
        iDCode.clear();
        iDCode.sendKeys(text);
    }

    public void clickDocCountryOfIssueDropDown(){
        docCountryOfIssueDropDown.click();
    }
}