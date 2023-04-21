package padeObjects.bo.boUsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteRolePage {
    WebDriver driver;

    public DeleteRolePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "button[type='Submit']")
    public WebElement submitBtn;

    public void clickSubmit(){
        submitBtn.click();
    }
}