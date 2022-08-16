package padeObjects.bo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BOHomePage {
    WebDriver driver;

    public BOHomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "div[ng-reflect-router-link='take_ticket']")
    WebElement take_ticket;

    public void gotoTakeTicket(){
        take_ticket.click();
    }
}