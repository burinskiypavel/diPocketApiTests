package appmanager.ui.bo;

import appmanager.UIHelperBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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

    public void delayTicketForOneMinute() {
        click(By.xpath("//app-button[@ng-reflect-label='Postpone']"));
        click(By.xpath("//button[@ng-reflect-icon='pi pi-calendar']"));
        click(By.cssSelector("div.p-minute-picker span.pi-chevron-up"));
        pressKeys(Keys.ENTER);
        waitFor(By.xpath("//div[contains(text(), 'Ticket was successfully delayed')]"));
    }
}