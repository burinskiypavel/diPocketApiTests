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

        //setClientPageFilter();

        WebElement element = driver.findElements(By.cssSelector("p-columnfilter[field='id'] input[type='text']")).get(1);
        element.sendKeys("25596");
        pressKeys(Keys.ENTER);

        assertTrue(areElementsPresentAfterSorting(By.cssSelector("td[ng-reflect-text='25596']")));

        WebElement element2 = driver.findElements(By.cssSelector("p-columnfilter[field='id'] input[type='text']")).get(1);
        element2.sendKeys(Keys.CONTROL + "a");
        element2.sendKeys(Keys.DELETE);

        //deleteTextFromTextarea(By.cssSelector("p-columnfilter[field='id'] input[type='text']"));

        setClientPageFilter("created", "02.02.2022");
        //assertTrue(areElementsPresentAfterSorting(By.cssSelector("td[ng-reflect-text='02.02.2022']")));
        deleteTextFromTextarea(By.cssSelector("p-columnfilter[field='created'] input[type='text']"));
    }
}