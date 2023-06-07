package padeObjects.bo.search;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CardSearchPage {
    WebDriver driver;

    public CardSearchPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//p-tabpanel[@header='Card'] //input[contains(@id, 'input_id')]")
    public WebElement idInput;
    @FindBy(xpath = "//p-tabpanel[@header='Card'] //input[contains(@id, 'input_publicToken')]")
    public WebElement publicTokenInput;
    @FindBy(xpath = "//p-tabpanel[@header='Card'] //input[contains(@id, 'input_dipToken')]")
    public WebElement dipTokenInput;
    @FindBy(xpath = "//p-tabpanel[@header='Card'] //input[contains(@id, 'input_pan')]")
    public WebElement panInput;
    @FindBy(xpath = "//p-tabpanel[@header='Card'] //input[contains(@id, 'input_clientId')]")
    public WebElement clientIdInput;
    @FindBy(xpath = "//p-tabpanel[@header='Card'] //input[contains(@id, 'input_cardholderName')]")
    public WebElement cardholderNameInput;

    @FindBy(css = "p-columnfilter[ng-reflect-field='id'] input")
    public WebElement cardIdFilter;
    @FindBy(css = "p-columnfilter[ng-reflect-field='publicToken'] input")
    public WebElement publicTokenFilter;
    @FindBy(css = "p-columnfilter[ng-reflect-field='dipToken'] input")
    public WebElement dipTokenFilter;
    @FindBy(css = "p-columnfilter[ng-reflect-field='maskedPan'] input")
    public WebElement maskedPanFilter;
    @FindBy(css = "p-columnfilter[ng-reflect-field='clientId'] input")
    public WebElement clientIdFilter;
    @FindBy(css = "p-columnfilter[ng-reflect-field='client'] input")
    public WebElement clientFilter;
    @FindBy(css = "p-columnfilter[ng-reflect-field='cardholderName'] input")
    public WebElement cardholderNameFilter;
    @FindBy(css = "p-columnfilter[ng-reflect-field='site'] input")
    public WebElement siteDropDownFilter;
}