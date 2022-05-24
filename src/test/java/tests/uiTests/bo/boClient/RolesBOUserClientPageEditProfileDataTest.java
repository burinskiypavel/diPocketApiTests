package tests.uiTests.bo.boClient;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class RolesBOUserClientPageEditProfileDataTest extends UITestBase {
    SoftAssert softAssert = new SoftAssert();
    String phone = "380634413376";

    @Test
    public void testRolesBOUserClientPageEditProfileData() throws InterruptedException {
        gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        gotoSearchPage();
        search("id", "33217", phone);
        goToClientPage(phone);
        pressEditProfileDataFromClientPage();

        softAssert.assertTrue(isElementPresent(By.cssSelector("app-input[ng-reflect-name='firstName'] input[ng-reflect-model='Nona']")));
        softAssert.assertTrue(isElementPresent(By.cssSelector("app-input[ng-reflect-name='lastName'] input[ng-reflect-model='Qwerty']")));
        softAssert.assertTrue(isElementPresent(By.cssSelector("p-calendar[ng-reflect-model='Wed Oct 06 1976 03:00:00 GMT+0']")));
        softAssert.assertTrue(isElementPresent(By.xpath("//app-select-async[@ng-reflect-name='gender'] //span[contains(text(), 'F')]")));
        softAssert.assertTrue(isElementPresent(By.cssSelector("app-input[ng-reflect-name='email'] input[ng-reflect-model='vikarez20@gmail.com']")));
        softAssert.assertTrue(isElementPresent(By.xpath("//app-select-async[@ng-reflect-name='photoIdTypeId'] //span[contains(text(), 'Passport')]")), "Document type");
        softAssert.assertTrue(isElementPresent(By.cssSelector("app-input[ng-reflect-name='identifyCode']")), "Pesel");
        softAssert.assertTrue(isElementPresent(By.cssSelector("app-input[ng-reflect-name='photoIdNo'] input[ng-reflect-model='CGH164279']")), "Doc serial number");
        softAssert.assertTrue(isElementPresent(By.xpath("//app-select-async[@ng-reflect-name='photoIdCountryId'] //span[contains(text(), 'Aland Islands')]")), "Doc country of issue");
        softAssert.assertTrue(isElementPresent(By.cssSelector("app-input[ng-reflect-name='mailingStreetLine1']")));
        softAssert.assertTrue(isElementPresent(By.cssSelector("app-input[ng-reflect-name='mailingStreetLine2']")));
        softAssert.assertTrue(isElementPresent(By.cssSelector("app-input[ng-reflect-name='mailingCity'] input[ng-reflect-model='City']")));
        softAssert.assertTrue(isElementPresent(By.xpath("//app-select-async[@ng-reflect-name='mailingCountry'] //span[contains(text(), 'Austria')]")), "Country");
        softAssert.assertTrue(isElementPresent(By.cssSelector("app-input[ng-reflect-name='mailingPostcode'] input[ng-reflect-model='11-11']")));
        softAssert.assertTrue(areButtonsPresent(new String[]{"//app-button[@ng-reflect-label='Save']"}));
        softAssert.assertAll();
    }
}