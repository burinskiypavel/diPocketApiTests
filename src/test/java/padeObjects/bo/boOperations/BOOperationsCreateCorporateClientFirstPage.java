package padeObjects.bo.boOperations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BOOperationsCreateCorporateClientFirstPage {
    WebDriver driver;

    public BOOperationsCreateCorporateClientFirstPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//app-select-async[@ng-reflect-name='clientType']")
    public WebElement clientTypeDropdown;

    @FindBy(xpath = "//app-input[@ng-reflect-name='companyName'] //input")
    public WebElement companyName;

    @FindBy(xpath = "//app-input[@ng-reflect-name='identifyCode'] //input")
    public WebElement identificationCode;

    @FindBy(xpath = "//app-select-async[@ng-reflect-name='clientSite']")
    public WebElement clientSiteDropDown;

    @FindBy(xpath = "//app-select-async[@ng-reflect-name='lang']")
    public WebElement languageDropDown;

    @FindBy(xpath = "//app-select-async[@ng-reflect-name='currency']")
    public WebElement currencyDropdown;

    @FindBy(xpath = "//app-select-async[@ng-reflect-name='ddStatus']")
    public WebElement dueDiligenceStatusDropdown;

    @FindBy(xpath = "//app-select-async[@ng-reflect-name='feeTariffPlan']")
    public WebElement feeTariffPlanDropdown;

    @FindBy(xpath = "//app-select-async[@ng-reflect-name='defCardProgram']")
    public WebElement cardProgramByDefaultDropdown;

    @FindBy(xpath = "//app-select-async[@ng-reflect-name='operLimitPlan']")
    public WebElement operLimitPlanDropdown;

    @FindBy(xpath = "//app-select-async[@ng-reflect-name='limitPlan']")
    public WebElement transactionsLimitPlanDropdown;

    @FindBy(xpath = "//app-select-async[@ng-reflect-name='contractCountryId']")
    public WebElement countryOfContractDropdown;

    @FindBy(xpath = "//p-button[@ng-reflect-label='Next']")
    public WebElement nextBtn;

    public void pressClientType(){
        clientTypeDropdown.click();
    }

    public void setCompanyName(String text){
        companyName.click();
        companyName.clear();
        companyName.sendKeys(text);
    }

    public void setIdentificationCode(String text){
        identificationCode.click();
        identificationCode.clear();
        identificationCode.sendKeys(text);
    }

    public void pressNext(){
        nextBtn.click();
    }
}