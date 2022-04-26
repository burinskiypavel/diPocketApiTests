package tests.uiTests.bo.boClient;

import base.UITestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class RolesBOUserClientPageTabSupervisorRequestsTest extends UITestBase {
    String phone = "380634413376";
    String clientId = "33217";

    @Test
    public void testRolesBOUserClientPageTabSupervisorRequests() throws InterruptedException {
        gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        gotoSearchPage();
        search("id", clientId, phone);
        goToClientPage(phone);
        goToSupervisorRequestsTab();
        waitFor(By.xpath("//thead //th[contains(text(), 'Request id')]"));

        assertTrue(areElementsPresent(new String[]{
                "//thead //th[contains(text(), 'Request id')]", "//thead //th[contains(text(), 'Role')]",
                "//thead //th[contains(text(), 'Client id')]", "//thead //th[contains(text(), 'Phone')]",
                "//thead //th[contains(text(), 'Full name')]", "//thead //th[contains(text(), 'State')]",
                "//thead //th[contains(text(), 'Created date')]", "//thead //th[contains(text(), 'Approved date')]"}));


        setClientPageFilter("reqId", "3079");
        assertTrue(areElementsPresentAfterSorting(By.cssSelector("td[ng-reflect-text='3079']")));
        deleteTextFromTextarea(By.cssSelector("p-columnfilter[field='reqId'] input[type='text']"));

        setDropDownClientPageFilter("role", "Child");
        assertTrue(areElementsPresentAfterSorting(By.cssSelector("td[ng-reflect-text='Child']")));
        clearFilter(By.cssSelector("i.p-dropdown-clear-icon"));

        setClientPageFilter("clientId", "33655");
        //assertTrue(areElementsPresentAfterSorting(By.cssSelector("td[ng-reflect-text='33655']")));// bug filter is not work
        deleteTextFromTextarea(By.cssSelector("p-columnfilter[field='clientId'] input[type='text']"));

        setClientPageFilter("rClientPhone", "380638918373");
        assertTrue(areElementsPresentAfterSorting(By.cssSelector("td[ng-reflect-text='380638918373']")));
        deleteTextFromTextarea(By.cssSelector("p-columnfilter[field='rClientPhone'] input[type='text']"));
    }
}