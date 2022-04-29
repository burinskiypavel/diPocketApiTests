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
        gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        gotoSearchPage();
        search("id", clientId, phone);
        goToClientPage(phone);
        goToTicketsTab();
        waitFor(By.xpath("//thead //th[contains(text(), 'Ticket Type')]"));

        assertTrue(areElementsPresent(new String[]{
                "//thead //th[contains(text(), 'Ticket id')]", "//thead //th[contains(text(), 'Created')]",
                "//thead //th[contains(text(), 'Ticket Type')]", "//thead //th[contains(text(), 'User')]",
                "//thead //th[contains(text(), 'Ticket State')]", "//thead //th[contains(text(), 'Closed')]",
                "//thead //th[contains(text(), 'Last comment')]"}));


        verifyClientPageFilterWithCollection("id", "25596", 1);
        verifyClientPageFilter("created", "02.02.2022");
        verifyDropDownClientPageFilter("typeName", "FDD check");
        verifyDropDownClientPageFilter("username", "EVGENYA");
        verifyDropDownClientPageFilterWithCollection(By.xpath("//p-columnfilter[@field='stateName']"), "Closed", 2);
        verifyClientPageFilter("closed", "07.02.2022");

        setClientPageFilter("lastMessage", "Ticket reassigned. Reason: test");
        assertTrue(areElementsPresentAfterSorting(By.xpath("//td[contains(text(), 'Ticket reassigned. Reason: test')]")));
    }
}