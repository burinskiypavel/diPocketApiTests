package padeObjects.bo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CBOHomePage {
    WebDriver driver;

    public CBOHomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//p[contains(text(), 'BO Users')]")
    WebElement boUsers;

    @FindBy(css = "div[ng-reflect-router-link='search']")
    WebElement search;

    public void gotoBOUsers(){
        boUsers.click();
    }

    public void gotoSearch(){
        search.click();
    }
}
