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
        waitFor(By.cssSelector("td[ng-reflect-text='25596']"));
        assertTrue(areElementsPresentAfterSorting(By.cssSelector("td[ng-reflect-text='25596']")));
        deleteText(id);

        verifyClientPageFilter("created", "02.02.2022");
        verifyDropDownClientPageFilter("typeName", "FDD check");
        verifyDropDownClientPageFilter("username", "EVGENYA");
        verifyDropDownClientPageFilterWithCollection(By.xpath("//p-columnfilter[@field='stateName']"), "Closed", 2);
        verifyClientPageFilter("closed", "07.02.2022");

        setClientPageFilter("lastMessage", "Ticket reassigned. Reason: test");
        assertTrue(areElementsPresentAfterSorting(By.xpath("//td[contains(text(), 'Ticket reassigned. Reason: test')]")));
    }
}