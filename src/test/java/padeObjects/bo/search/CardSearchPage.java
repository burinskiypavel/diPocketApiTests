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
}