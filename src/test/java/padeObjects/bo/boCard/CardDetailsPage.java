package padeObjects.bo.boCard;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CardDetailsPage {
    WebDriver driver;

    public CardDetailsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//app-button[@ng-reflect-label='Show client info']")
    public WebElement showClientInfoBtn;

    @FindBy(xpath = "//app-button[@label='Operations']")
    public WebElement operationsBtn;

    @FindBy(xpath = "//p-button[@ng-reflect-label='Back to search']")
    public WebElement backToSearchBtn;

    @FindBy(xpath = "//a[@role='tab'] //span[contains(text(), 'Info')]")
    public WebElement infoTab;

    @FindBy(xpath = "//a[@role='tab'] //span[contains(text(), 'Client')]")
    public WebElement clientTab;

    @FindBy(xpath = "//a[@role='tab'] //span[contains(text(), 'Transactions')]")
    public WebElement transactionsTab;

    @FindBy(xpath = "//a[@role='menuitem'] //span[contains(text(), 'Overdraft limit')]")
    public WebElement overdraftLimitMenuitem;

    @FindBy(xpath = "//a[@role='menuitem'] //span[contains(text(), 'Resend PIN')]")
    public WebElement ResendPINMenuitem;

    @FindBy(xpath = "//a[@role='menuitem'] //span[contains(text(), 'Reset ePin')]")
    public WebElement resetEPinMenuitem;

    @FindBy(xpath = "//ul[@role='menu'] //span[contains(text(), 'Unblock account')]")
    public WebElement unblockAccountMenuitem;

    public void clickShowClientInfoButton(){
        showClientInfoBtn.click();
    }
    public void clickOperationsButton(){
        operationsBtn.click();
    }
    public void clickBackToSearchButton(){
        backToSearchBtn.click();
    }
}