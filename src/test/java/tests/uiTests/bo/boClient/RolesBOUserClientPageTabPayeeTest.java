package tests.uiTests.bo.boClient;

import base.UITestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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

        app.getUiboClientHelper().verifyClientPageFilter(By.cssSelector("app-payee p-columnfilter[ng-reflect-field='nickName'] input[type='text']"), "Txcy", "Den", "nickName");
        app.getUiboClientHelper().verifyDropDownClientPageFilter(By.cssSelector("app-payee p-columnfilter[ng-reflect-field='paymentTypeName']"), "Other payments", "PLN in Poland");

        app.getUiboClientHelper().setDropDownClientPageFilter(By.cssSelector("app-payee p-columnfilter[ng-reflect-field='currencyCode']"), "GBP");
        String actualCurrencyCode = app.getUiboHelper().getAttributeText(By.xpath("//app-payee //table/tbody/tr[1]/td[3] //span"));
        assertEquals(actualCurrencyCode, "GBP");
        app.getUiboClientHelper().clearFilter(By.cssSelector("timesicon[ng-reflect-style-class='p-dropdown-clear-icon'] svg"));

        app.getUiboClientHelper().verifyClientPageFilter(By.cssSelector("app-payee p-columnfilter[ng-reflect-field='bankId'] input[type='text']"), "WBKPPLPP", "VHHFRGUF", "bankId");

        app.getUiboClientHelper().setClientPageFilter(By.cssSelector("app-payee p-columnfilter[ng-reflect-field='accountNo'] input[type='text']"), "64109000047341800000085706");
        String actualaccountNo = app.getUiboHelper().getAttributeText(By.xpath("//app-payee //table/tbody/tr[1]/td[5] //span"));
        assertEquals(actualaccountNo, "64109000047341800000085706");
        app.getUiboHelper().deleteTextFromTextarea(By.cssSelector("app-payee p-columnfilter[ng-reflect-field='accountNo'] input[type='text']"));

        app.getUiboClientHelper().verifyClientPageFilter(By.cssSelector("app-payee p-columnfilter[ng-reflect-field='countryName'] input[type='text']"), "Australia", "Poland", "countryName");
        app.getUiboClientHelper().verifyClientPageFilter(By.cssSelector("app-payee p-columnfilter[ng-reflect-field='zip'] input[type='text']"), "JUVUV", "zip", By.cssSelector("td span[ng-reflect-text='" + "JUVUV" + "']"));
        app.getUiboClientHelper().verifyClientPageFilter(By.cssSelector("app-payee p-columnfilter[ng-reflect-field='address1'] input[type='text']"), "Hchc", "address1", By.cssSelector("td span[ng-reflect-text='" + "Hchc" + "']"));

        WebElement element = app.getUiboHelper().findElement(By.cssSelector("app-payee p-columnfilter[ng-reflect-field='companyName'] input[type='text']"));
        app.getUiboHelper().moveToElementAction(element);

        app.getUiboClientHelper().verifyClientPageFilter(By.cssSelector("app-payee p-columnfilter[ng-reflect-field='firstName'] input[type='text']"), "Gfu", "firstName", By.cssSelector("td span[ng-reflect-text='" + "Gfu" + "']"));

        app.getUiboClientHelper().setClientPageFilter(By.cssSelector("app-payee p-columnfilter[ng-reflect-field='lastName'] input[type='text']"), "Hchc");
        String actualLastName = app.getUiboHelper().getAttributeText(By.xpath("//app-payee //table/tbody/tr[1]/td[11] //span"));
        assertEquals(actualLastName, "Hchc");
    }
}