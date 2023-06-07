package padeObjects.bo.search;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClientSearchPage {

    WebDriver driver;

    public ClientSearchPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@role='tab'] //span[contains(text(), 'Client')]")
    public WebElement clientTab;

    @FindBy(xpath = "//a[@role='tab'] //span[contains(text(), 'Card')]")
    public WebElement cardTab;

    @FindBy(css = "input[id*=input_id]")
    public WebElement idInput;

    @FindBy(css = "input[id*=input_firstName]")
    public WebElement firstNameInput;

    @FindBy(css = "input[id*=input_lastName]")
    public WebElement lastNameInput;

    @FindBy(css = "input[id*=input_emai]")
    public WebElement emailInput;

    @FindBy(css = "input[id*=input_mainPhone]")
    public WebElement mainPhoneInput;

    @FindBy(css = "input[id*=input_mailingAddress]")
    public WebElement mailingAddressInput;

    @FindBy(css = "input[id*=input_companyName]")
    public WebElement companyNameInput;

    @FindBy(css = "p-calendar[id*=calendar_birthDate]")
    public WebElement birthDatenput;
}