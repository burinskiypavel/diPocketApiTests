package tests.uiTests.bo.boClient;

import base.UITestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class RolesBOUserClientPageTabPayeeTest extends UITestBase {
    String phone = "380634413376";
    String clientId = "33217";

    @Test
    public void testRolesBOUserClientPageTabPayee() throws InterruptedException {
        gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        gotoSearchPage();
        search("id", clientId, phone);
        goToClientPage(phone);
        goToPayeeTab();

        verifyClientPageFilter("nickName", "Txcy", "Den");
        verifyDropDownClientPageFilter("paymentTypeName", "PLN in Poland", "Other payments");

        setDropDownClientPageFilter("currencyCode", "GBP");
        String actualCurrencyCode = driver.findElements(By.xpath("//table/tbody/tr[1]/td[3]")).get(2).getAttribute("ng-reflect-text");
        assertEquals(actualCurrencyCode, "GBP");
        clearFilter(By.cssSelector("i.p-dropdown-clear-icon"));

        verifyClientPageFilter("bankId", "WBKPPLPP", "VHHFRGUF");

        setClientPageFilter("accountNo", "64109000047341800000085706");
        String actualaccountNo = driver.findElements(By.xpath("//table/tbody/tr[1]/td[5]")).get(2).getAttribute("ng-reflect-text");
        assertEquals(actualaccountNo, "64109000047341800000085706");
        deleteTextFromTextarea(By.cssSelector("p-columnfilter[field='accountNo'] input[type='text']"));

        verifyClientPageFilter("countryName", "Australia", "Poland");
        verifyClientPageFilter("zip", "JUVUV");
        verifyClientPageFilter("address1", "Hchc");

        WebElement element = driver.findElement(By.cssSelector("p-columnfilter[field='companyName'] input[type='text']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();

        verifyClientPageFilter("firstName", "Gfu");

        setClientPageFilter("lastName", "Hchc");
        String actualLastName = driver.findElement(By.xpath("//table/tbody/tr[1]/td[11]")).getAttribute("ng-reflect-text");
        assertEquals(actualLastName, "Hchc");
    }
}