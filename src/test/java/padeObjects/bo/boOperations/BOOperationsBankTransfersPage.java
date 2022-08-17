package padeObjects.bo.boOperations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BOOperationsBankTransfersPage {
    WebDriver driver;

    public BOOperationsBankTransfersPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//p-button[@label='Check operation']")
    WebElement checkOperationBtn;

    public void pressCheckOperation(){
        checkOperationBtn.click();
    }
}