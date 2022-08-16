package appmanager.ui.bo;

import appmanager.UIHelperBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import padeObjects.bo.BOHomePage;

public class UIBOTicketHelper extends UIHelperBase {

    public UIBOTicketHelper(WebDriver driver) {
        super(driver);
    }

    public void gotoTakeTicket() {
        //click(By.cssSelector("div[ng-reflect-router-link='take_ticket']"));
        BOHomePage boHomePage = new BOHomePage(driver);
        boHomePage.gotoTakeTicket();
        waitFor(By.id("takeTicketContent"));
    }
}