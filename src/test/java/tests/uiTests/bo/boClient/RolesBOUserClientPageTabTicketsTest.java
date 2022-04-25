package tests.uiTests.bo.boClient;

import base.UITestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
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


        WebElement id = driver.findElements(By.cssSelector("p-columnfilter[field='id'] input[type='text']")).get(1);
        id.sendKeys("25596");
        pressKeys(Keys.ENTER);

        assertTrue(areElementsPresentAfterSorting(By.cssSelector("td[ng-reflect-text='25596']")));

        id.sendKeys(Keys.CONTROL + "a");
        id.sendKeys(Keys.DELETE);


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
    }
}