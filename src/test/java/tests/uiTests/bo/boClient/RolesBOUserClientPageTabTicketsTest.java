package tests.uiTests.bo.boClient;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class RolesBOUserClientPageTabTicketsTest extends UITestBase {
    String phone = "380634413376";
    String clientId = "33217";

    @Test
    public void testRolesBOUserClientPageTabTickets() throws InterruptedException {
        app.getUiboHelper().gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        app.getUiboHelper().gotoSearchPage();
        app.getUiboHelper().search("id", clientId, phone);
        app.getUiboClientHelper().goToClientPage(phone);
        app.getUiboClientHelper().goToTicketsTab();
        app.getUiboHelper().waitFor(By.xpath("//thead //th[contains(text(), 'Ticket Type')]"));

        assertTrue(app.getUiboHelper().areElementsPresent(new String[]{
                "//thead //th[contains(text(), 'Ticket id')]", "//thead //th[contains(text(), 'Created')]",
                "//thead //th[contains(text(), 'Ticket Type')]", "//thead //th[contains(text(), 'User')]",
                "//thead //th[contains(text(), 'Ticket State')]", "//thead //th[contains(text(), 'Closed')]",
                "//thead //th[contains(text(), 'Last comment')]"}));


        app.getUiboClientHelper().verifyClientPageFilterWithCollection("id", "25596", 1);
        app.getUiboClientHelper().verifyClientPageFilter("created", "02.02.2022");
        app.getUiboClientHelper().verifyDropDownClientPageFilter("typeName", "FDD check");
        app.getUiboClientHelper().verifyDropDownClientPageFilter("username", "EVGENYA");
        app.getUiboClientHelper().verifyDropDownClientPageFilterWithCollection(By.xpath("//p-columnfilter[@field='stateName']"), "Closed", 2);
        app.getUiboClientHelper().verifyClientPageFilter("closed", "07.02.2022");

        app.getUiboClientHelper().setClientPageFilter("lastMessage", "Ticket reassigned. Reason: test");
        assertTrue(app.getUiboHelper().areElementsPresentAfterSorting(By.xpath("//td[contains(text(), 'Ticket reassigned. Reason: test')]")));
    }
}