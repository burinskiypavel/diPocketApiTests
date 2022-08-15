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
        "//app-button[@ng-reflect-label='Ban']", "//app-button[@ng-reflect-label='Postpone']", "//app-button[@ng-reflect-label='Reassign']"}), "Card limits are incorrect");
    }
}