package padeObjects.bo.boUsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewRolePage {
    WebDriver driver;

    public AddNewRolePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "input[id*=input_roleId]")
    public WebElement roleIDInput;

    @FindBy(css = "input[id*=input_roleName]")
    public WebElement roleNameInput;

    @FindBy(css = "p-button[ng-reflect-label='Confirm']")
    public WebElement confirmBtn;

    public void typeInRoleIDInput(String id){
        roleIDInput.sendKeys(id);
    }

    public void typeInRoleNameInput(String name){
        roleNameInput.sendKeys(name);
    }

    public void clickConfirm(){
        confirmBtn.click();
    }
}