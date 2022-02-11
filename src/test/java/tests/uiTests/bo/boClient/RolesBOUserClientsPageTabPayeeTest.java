package tests.uiTests.bo.boClient;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class RolesBOUserClientsPageTabPayeeTest extends UITestBase {

    @Test
    public void testRolesBOUserClientsPageTabPayee() throws InterruptedException {
        gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        gotoSearchPage();
        type(By.cssSelector("app-input-number[ng-reflect-name='id'] input.p-inputnumber-input"), "33217");
        waitFor(By.cssSelector("td[ng-reflect-text='380634413376']"));
        click(By.cssSelector("td[ng-reflect-text='380634413376']"));
        waitFor(By.cssSelector("p.user-name"));
        click(By.id("p-tabpanel-5-label"));

        setClientPageFilter("nickName", "Txcy");
        assertTrue(areElementsPresentAfterSorting(By.cssSelector("td[ng-reflect-text='Txcy']")));
        assertFalse(areElementsPresentAfterSorting(By.cssSelector("td[ng-reflect-text='Den']")));

        deleteTextFromTextarea(By.cssSelector("p-columnfilter[field='nickName'] input[type='text']"));

        setDropDownClientPageFilter("paymentTypeName", "PLN in Poland");
        assertTrue(areElementsPresentAfterSorting(By.cssSelector("td[ng-reflect-text='PLN in Poland']")));
        assertFalse(areElementsPresentAfterSorting(By.cssSelector("td[ng-reflect-text='Other payments']")));

        clearFilter(By.cssSelector("i.p-dropdown-clear-icon"));

        setDropDownClientPageFilter("currencyCode", "GBP");

        String actualCurrencyCode = driver.findElements(By.xpath("//table/tbody/tr[1]/td[3]")).get(2).getAttribute("ng-reflect-text");
        Assert.assertEquals(actualCurrencyCode, "GBP");
     }
}
