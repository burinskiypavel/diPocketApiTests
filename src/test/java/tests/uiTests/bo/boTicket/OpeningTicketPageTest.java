package tests.uiTests.bo.boTicket;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class OpeningTicketPageTest extends UITestBase {

    @Test
    public void testOpeningTicketPage() throws InterruptedException {
        app.getUiboHelper().gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        app.getUiboHelper().gotoTakeTicket();

        app.getUiboHelper().waitFor(By.xpath("//app-client-details-info"));
        app.getUiboHelper().waitFor(By.id("takeTicketContent"));

        assertTrue(app.getUiboHelper().areButtonsPresent(new String[]{"//app-button[@ng-reflect-label='Approve']", "//app-button[@ng-reflect-label='Edit']",
                "//app-button[@ng-reflect-label='Rescan request']", "//app-button[@ng-reflect-label='Ask for']", "//app-button[@ng-reflect-label='Ask new selfie']",
        "//app-button[@ng-reflect-label='Ban']", "//app-button[@ng-reflect-label='Postpone']", "//app-button[@ng-reflect-label='Reassign']"}), "button bo tickets");
    }

    @Test
    public void  testApproveSDDTicket() throws InterruptedException {
        app.getUiboHelper().gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        app.getUiboHelper().gotoTakeTicket();

        app.getUiboHelper().click(By.xpath("//app-button[@ng-reflect-label='Edit']"));
        app.getUiboHelper().click(By.xpath("//app-select-async[@ng-reflect-name='gender']"));
        app.getUiboHelper().click(By.xpath("//p-dropdownitem[@ng-reflect-label='M']"));
        Thread.sleep(1500);
        app.getUiboHelper().click(By.xpath("//p-button[@ng-reflect-label='Save']"));

        app.getUiboHelper().waitFor(By.xpath("//*[contains(text(), 'Client data updated successfully')]"));

        app.getUiboHelper().click(By.xpath("//app-button[@ng-reflect-label='Approve']"));


        app.getUiboHelper().waitFor(By.xpath("//*[contains(text(), 'Ticket approved successfully')]"));

        app.getUiboHelper().waitFor(By.xpath("//*[contains(text(), 'Take Ticket')]"));

        assertTrue(app.getUiboHelper().areElementsPresent(new String[]{"//*[contains(text(), 'Take Ticket')]", "//*[contains(text(), 'Search')]"}));
    }
}