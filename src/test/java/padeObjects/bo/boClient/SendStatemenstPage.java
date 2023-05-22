package padeObjects.bo.boClient;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SendStatemenstPage {
    WebDriver driver;

    public SendStatemenstPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "p-button[label='Send']")
    public WebElement sendBtn;

    @FindBy(id = "formly_3_multi-select_statementRequestList_0")
    public WebElement mounthAndYearDropDown;

    @FindBy(css = "div.p-multiselect-header button timesicon svg")
    public WebElement closeStatementDropDownBtn;

    @FindBy(id = "formly_3_checkbox_useClientEmail_1")
    public WebElement sendToClientEmailCheckbox;

    @FindBy(id = "formly_3_input_email_2")
    public WebElement emailInput;

    @FindBy(xpath = "//div[contains(text(), 'Statements were sent successfully')]")
    public WebElement sendStatementsConfirmMessage;
}