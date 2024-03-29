package padeObjects.bo.boTicket;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PostponePage {
    WebDriver driver;

    public PostponePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[@type='button'] //calendaricon")
    public WebElement calendarBtn;

    @FindBy(xpath = "//div[@role='dialog'] //p-button[@ng-reflect-label='Postpone']")
    public WebElement postponeBtn;

    @FindBy(css = "div.p-minute-picker chevronupicon")
    public WebElement chevronUpMinuteBtn;

    @FindBy(css = "div.p-hour-picker chevronupicon")
    public WebElement chevronUpHourBtn;

    @FindBy(css = "div.p-datepicker-header chevronrighticon")
    public WebElement chevronUpMounthBtn;
}