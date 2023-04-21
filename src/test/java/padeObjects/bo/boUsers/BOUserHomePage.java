package padeObjects.bo.boUsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BOUserHomePage {
    WebDriver driver;

    public BOUserHomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "p-button[ng-reflect-label='Unblock user']")
    public WebElement unblockUserBtn;
    @FindBy(css = "p-button[ng-reflect-label='Block user']")
    public WebElement blockUserBtn;
    @FindBy(css = "p-button[ng-reflect-label='Edit']")
    public WebElement editBtn;
    @FindBy(css = "p-button[ng-reflect-label='Reset password']")
    public WebElement resetPasswordBtn;
    @FindBy(css = "p-button[ng-reflect-label='Add user']")
    public WebElement addUserBtn;

    public void pressUnblockUserBtn(){
        unblockUserBtn.click();
    }
    public void pressBlockUserBtn(){
        blockUserBtn.click();
    }
    public void pressEditBtn(){
        editBtn.click();
    }
    public void pressResetPasswordBtn(){
        resetPasswordBtn.click();
    }
    public void pressAddUserBtn(){
        addUserBtn.click();
    }
}