package padeObjects.bo.boTicket;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TakeTicketPage {
    WebDriver driver;

    public TakeTicketPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//app-button[@ng-reflect-label='Edit']")
    public WebElement editBtn;
    @FindBy(xpath = "//app-button[@ng-reflect-label='Approve']")
    public WebElement approveBtn;

    @FindBy(xpath = "//app-button[@ng-reflect-label='Reject']")
    public WebElement rejectBtn;

    @FindBy(xpath = "//app-button[@ng-reflect-label='Escalate to CBO']")
    public WebElement escalateToCBOBtn;

    @FindBy(xpath = "//app-button[@ng-reflect-label='Reassign']")
    public WebElement reassignBtn;

    @FindBy(xpath = "//app-button[@ng-reflect-label='Postpone']")
    public WebElement postponeBtn;

    @FindBy(xpath = "//app-button[@ng-reflect-label='Rescan request']")
    public WebElement rescanRequestBtn;


    public void clickOnApproveButton(){
        approveBtn.click();
    }

    public void clickOnEditButton(){
        editBtn.click();
    }

    public void clickOnEscalateToCBOButton(){
        escalateToCBOBtn.click();
    }

    public void clickOnReassignButton(){
        reassignBtn.click();
    }

    public void clickOnPostponeButton(){
        postponeBtn.click();
    }
}