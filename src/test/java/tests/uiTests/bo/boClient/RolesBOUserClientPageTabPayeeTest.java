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
        app.getUiboHelper().gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        app.getUiboHelper().gotoSearchPage();
        app.getUiboHelper().search("id", clientId, phone);
        app.getUiboClientHelper().goToClientPage(phone);
        app.getUiboClientHelper().goToPayeeTab();

        app.getUiboClientHelper().verifyClientPageFilter("nickName", "Txcy", "Den");
        app.getUiboClientHelper().verifyDropDownClientPageFilter("paymentTypeName", "PLN in Poland", "Other payments");

        app.getUiboClientHelper().setDropDownClientPageFilter("currencyCode", "GBP");
        String actualCurrencyCode = app.getUiboHelper().getAttributeFromMultiple(By.xpath("//table/tbody/tr[1]/td[3]"), 2);
        assertEquals(actualCurrencyCode, "GBP");
        app.getUiboClientHelper().clearFilter(By.cssSelector("i.p-dropdown-clear-icon"));

        app.getUiboClientHelper().verifyClientPageFilter("bankId", "WBKPPLPP", "VHHFRGUF");

        app.getUiboClientHelper().setClientPageFilter("accountNo", "64109000047341800000085706");
        String actualaccountNo = app.getUiboHelper().getAttributeFromMultiple(By.xpath("//table/tbody/tr[1]/td[5]"), 2);
        assertEquals(actualaccountNo, "64109000047341800000085706");
        app.getUiboHelper().deleteTextFromTextarea(By.cssSelector("p-columnfilter[field='accountNo'] input[type='text']"));

        app.getUiboClientHelper().verifyClientPageFilter("countryName", "Australia", "Poland");
        app.getUiboClientHelper().verifyClientPageFilter("zip", "JUVUV");
        app.getUiboClientHelper().verifyClientPageFilter("address1", "Hchc");

        WebElement element = app.getUiboHelper().findElement(By.cssSelector("p-columnfilter[field='companyName'] input[type='text']"));
        app.getUiboHelper().moveToElementAction(element);

        app.getUiboClientHelper().verifyClientPageFilter("firstName", "Gfu");

        app.getUiboClientHelper().setClientPageFilter("lastName", "Hchc");
        String actualLastName = app.getUiboHelper().findElement(By.xpath("//table/tbody/tr[1]/td[11]")).getAttribute("ng-reflect-text");
        assertEquals(actualLastName, "Hchc");
    }
}