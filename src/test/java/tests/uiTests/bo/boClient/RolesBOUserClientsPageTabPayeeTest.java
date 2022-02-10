package tests.uiTests.bo.boClient;

import base.UITestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

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

        type(By.cssSelector("p-columnfilter[field='nickName'] input[type='text']"), "Txcy");
        pressKeys(Keys.ENTER);
        Assert.assertTrue(areElementsPresentAfterSorting(By.cssSelector("td[ng-reflect-text='Txcy']")));
    }
}
