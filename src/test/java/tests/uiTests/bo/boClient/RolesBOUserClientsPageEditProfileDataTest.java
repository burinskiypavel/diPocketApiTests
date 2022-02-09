package tests.uiTests.bo.boClient;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class RolesBOUserClientsPageEditProfileDataTest extends UITestBase {
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void testRolesBOUserClientsPageEditProfileData() throws InterruptedException {
        gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        gotoSearchPage();
        type(By.cssSelector("app-input-number[ng-reflect-name='id'] input.p-inputnumber-input"), "33217");
        waitFor(By.cssSelector("td[ng-reflect-text='380634413376']"));
        click(By.cssSelector("td[ng-reflect-text='380634413376']"));
        waitFor(By.cssSelector("p.user-name"));
        click(By.cssSelector("div.edit-button"));
        waitFor(By.xpath("//app-select-async[@ng-reflect-name='gender']"));
        waitFor(By.xpath("//app-button[@ng-reflect-label='Save']"));
        Thread.sleep(500);

        softAssert.assertTrue(isElementPresent(By.cssSelector("app-input[ng-reflect-name='firstName'] input[ng-reflect-model='Nona']")));
        softAssert.assertTrue(isElementPresent(By.cssSelector("app-input[ng-reflect-name='lastName'] input[ng-reflect-model='Qwerty']")));
        softAssert.assertTrue(isElementPresent(By.cssSelector("p-calendar[ng-reflect-model='Wed Oct 06 1976 03:00:00 GMT+0']")));
        softAssert.assertTrue(isElementPresent(By.xpath("//app-select-async[@ng-reflect-name='gender'] //span[contains(text(), 'F')]")));
        softAssert.assertTrue(isElementPresent(By.cssSelector("app-input[ng-reflect-name='email'] input[ng-reflect-model='vikarez20@gmail.com']")));
        softAssert.assertTrue(isElementPresent(By.xpath("//app-select-async[@ng-reflect-label='Document type'] //span[contains(text(), 'Passport')]")));
        softAssert.assertTrue(isElementPresent(By.cssSelector("app-input[ng-reflect-label='Pesel']")));
        softAssert.assertTrue(isElementPresent(By.cssSelector("app-input[ng-reflect-label='Doc serial number'] input[ng-reflect-model='CGH164279']")));
        softAssert.assertTrue(isElementPresent(By.xpath("//app-select-async[@ng-reflect-label='Doc country of issue'] //span[contains(text(), 'Aland Islands')]")));
        softAssert.assertTrue(isElementPresent(By.cssSelector("app-input[ng-reflect-name='mailingStreetLine1']")));
        softAssert.assertTrue(isElementPresent(By.cssSelector("app-input[ng-reflect-name='mailingStreetLine2']")));
        softAssert.assertTrue(isElementPresent(By.cssSelector("app-input[ng-reflect-name='mailingCity'] input[ng-reflect-model='City']")));
        softAssert.assertTrue(isElementPresent(By.xpath("//app-select-async[@ng-reflect-label='Country'] //span[contains(text(), 'Poland')]")));
        softAssert.assertTrue(isElementPresent(By.cssSelector("app-input[ng-reflect-name='mailingPostcode'] input[ng-reflect-model='11-11']")));
        softAssert.assertTrue(areButtonsPresent(new String[]{"//app-button[@ng-reflect-label='Save']"}));
        softAssert.assertAll();
    }
}