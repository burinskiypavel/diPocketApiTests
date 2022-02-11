package tests.uiTests.bo.boClient;

import base.UITestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

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
        assertEquals(actualCurrencyCode, "GBP");

        clearFilter(By.cssSelector("i.p-dropdown-clear-icon"));

        setClientPageFilter("bankId", "WBKPPLPP");
        assertTrue(areElementsPresentAfterSorting(By.cssSelector("td[ng-reflect-text='WBKPPLPP']")));
        assertFalse(areElementsPresentAfterSorting(By.cssSelector("td[ng-reflect-text='VHHFRGUF']")));
        deleteTextFromTextarea(By.cssSelector("p-columnfilter[field='bankId'] input[type='text']"));

        setClientPageFilter("accountNo", "64109000047341800000085706");

        String actualaccountNo = driver.findElements(By.xpath("//table/tbody/tr[1]/td[5]")).get(2).getAttribute("ng-reflect-text");
        assertEquals(actualaccountNo, "64109000047341800000085706");
        deleteTextFromTextarea(By.cssSelector("p-columnfilter[field='accountNo'] input[type='text']"));

        setClientPageFilter("countryName", "Australia");

        assertTrue(areElementsPresentAfterSorting(By.cssSelector("td[ng-reflect-text='Australia']")));
        assertFalse(areElementsPresentAfterSorting(By.cssSelector("td[ng-reflect-text='Poland']")));

        deleteTextFromTextarea(By.cssSelector("p-columnfilter[field='countryName'] input[type='text']"));
        setClientPageFilter("zip", "JUVUV");
        assertTrue(areElementsPresentAfterSorting(By.cssSelector("td[ng-reflect-text='JUVUV']")));

        deleteTextFromTextarea(By.cssSelector("p-columnfilter[field='zip'] input[type='text']"));
        setClientPageFilter("address1", "Hchc");
        assertTrue(areElementsPresentAfterSorting(By.cssSelector("td[ng-reflect-text='Hchc']")));

        deleteTextFromTextarea(By.cssSelector("p-columnfilter[field='address1'] input[type='text']"));

        WebElement element = driver.findElement(By.cssSelector("p-columnfilter[field='companyName'] input[type='text']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();

        setClientPageFilter("firstName", "Gfu");
        assertTrue(areElementsPresentAfterSorting(By.cssSelector("td[ng-reflect-text='Gfu']")));

        deleteTextFromTextarea(By.cssSelector("p-columnfilter[field='firstName'] input[type='text']"));
        setClientPageFilter("lastName", "Hchc");

        String actualLastName = driver.findElement(By.xpath("//table/tbody/tr[1]/td[11]")).getAttribute("ng-reflect-text");
        assertEquals(actualLastName, "Hchc");
    }
}