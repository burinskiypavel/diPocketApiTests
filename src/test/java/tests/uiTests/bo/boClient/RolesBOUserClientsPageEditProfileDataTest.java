package tests.uiTests.bo.boClient;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RolesBOUserClientsPageEditProfileDataTest extends UITestBase {

    @Test()
    public void testRolesBOUserClientsPageEditProfileData() throws InterruptedException {
        gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        gotoSearchPage();
        type(By.cssSelector("app-input-number[ng-reflect-name='id'] input.p-inputnumber-input"), "33217");
        waitFor(By.cssSelector("td[ng-reflect-text='380634413376']"));
        click(By.cssSelector("td[ng-reflect-text='380634413376']"));
        waitFor(By.cssSelector("p.user-name"));
        click(By.cssSelector("div.edit-button"));

        Assert.assertTrue(isElementPresent(By.cssSelector("app-input[ng-reflect-name='firstName'] input[ng-reflect-model='Nona']")));
        Assert.assertTrue(isElementPresent(By.cssSelector("app-input[ng-reflect-name='lastName'] input[ng-reflect-model='Qwerty']")));
        Assert.assertTrue(isElementPresent(By.cssSelector("p-calendar[ng-reflect-model='Wed Oct 06 1976 03:00:00 GMT+0']")));
        Assert.assertTrue(isElementPresent(By.xpath("//app-select-async[@ng-reflect-name='gender'] //span[contains(text(), 'F')]")));
        Assert.assertTrue(isElementPresent(By.cssSelector("app-input[ng-reflect-name='email'] input[ng-reflect-model='vikarez20@gmail.com']")));
        Assert.assertTrue(isElementPresent(By.xpath("//app-select-async[@ng-reflect-label='Document type'] //span[contains(text(), 'Passport')]")));
        Assert.assertTrue(isElementPresent(By.cssSelector("app-input[ng-reflect-label='Pesel']")));
        Assert.assertTrue(isElementPresent(By.cssSelector("app-input[ng-reflect-label='Doc serial number'] input[ng-reflect-model='CGH164279']")));


        Assert.assertTrue(isElementPresent(By.xpath("//app-select-async[@ng-reflect-label='Doc country of issue'] //span[contains(text(), 'Aland Islands')]")));

    }
}