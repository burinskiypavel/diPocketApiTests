package appmanager.ui.bo;

import appmanager.HelperBase;
import appmanager.UIHelperBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UIBOHelper extends UIHelperBase {
    //public WebDriver driver;
    //public WebDriverWait wait;

    public UIBOHelper(WebDriver driver) {
        super(driver);
    }

    public void addRole(String roleID, String roleName) throws InterruptedException {
        click(By.cssSelector("app-button[label='+ Add']"));
        waitForSeveralItems(new String[]{"Role ID:", "Role name:", "Add Role"});
        type(By.cssSelector("app-input[ng-reflect-name='roleId'] input[type='text']"), roleID);
        type(By.cssSelector("app-input[ng-reflect-name='roleName'] input[type='text']"), roleName);
        Thread.sleep(500);
        click(By.cssSelector("app-button[ng-reflect-label='Add']"));
    }
}