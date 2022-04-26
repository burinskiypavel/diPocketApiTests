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
        assertTrue(areElementsPresentAfterSorting(By.cssSelector("td[ng-reflect-text='33655']")));
        deleteTextFromTextarea(By.cssSelector("p-columnfilter[field='clientId'] input[type='text']"));





        WebElement id = driver.findElements(By.cssSelector("p-columnfilter[field='id'] input[type='text']")).get(1);
        id.sendKeys("25596");
        pressKeys(Keys.ENTER);
        waitFor(By.cssSelector("td[ng-reflect-text='25596']"));
        assertTrue(areElementsPresentAfterSorting(By.cssSelector("td[ng-reflect-text='25596']")));
        deleteText(id);

        setClientPageFilter("created", "02.02.2022");
        //assertTrue(areElementsPresentAfterSorting(By.cssSelector("td[ng-reflect-text='02.02.2022']")));
        deleteTextFromTextarea(By.cssSelector("p-columnfilter[field='created'] input[type='text']"));

        setDropDownClientPageFilter("typeName", "FDD check");
        assertTrue(areElementsPresentAfterSorting(By.cssSelector("td[ng-reflect-text='FDD check']")));
        clearFilter(By.cssSelector("i.p-dropdown-clear-icon"));

        setDropDownClientPageFilter("username", "EVGENYA");
        assertTrue(areElementsPresentAfterSorting(By.cssSelector("td[ng-reflect-text='EVGENYA']")));
        clearFilter(By.cssSelector("i.p-dropdown-clear-icon"));

        WebElement stateName = driver.findElements(By.cssSelector("p-columnfilter[field='stateName']")).get(2);
        stateName.click();
        driver.findElement(By.cssSelector("li[aria-label='Closed']")).click();
        assertTrue(areElementsPresentAfterSorting(By.cssSelector("td[ng-reflect-text='Closed']")));
        clearFilter(By.cssSelector("i.p-dropdown-clear-icon"));

        setClientPageFilter("closed", "07.02.2022");
        //assertTrue(areElementsPresentAfterSorting(By.cssSelector("td[ng-reflect-text='07.02.2022']")));
        deleteTextFromTextarea(By.cssSelector("p-columnfilter[field='closed'] input[type='text']"));

        setClientPageFilter("lastMessage", "Ticket reassigned. Reason: test");
        assertTrue(areElementsPresentAfterSorting(By.xpath("//td[contains(text(), 'Ticket reassigned. Reason: test')]")));
    }
}