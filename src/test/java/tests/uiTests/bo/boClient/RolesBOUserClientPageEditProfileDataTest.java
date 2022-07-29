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
        app.getUiboHelper().gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        app.getUiboHelper().gotoSearchPage();
        app.getUiboHelper().search("id", "33217", phone);
        app.getUiboHelper().goToClientPage(phone);
        app.getUiboHelper().pressEditProfileDataFromClientPage();

        softAssert.assertTrue(app.getUiboHelper().isElementPresent(By.cssSelector("app-input[ng-reflect-name='firstName'] input[ng-reflect-model='Nona']")));
        softAssert.assertTrue(app.getUiboHelper().isElementPresent(By.cssSelector("app-input[ng-reflect-name='lastName'] input[ng-reflect-model='Qwerty']")));
        softAssert.assertTrue(app.getUiboHelper().isElementPresent(By.cssSelector("p-calendar[ng-reflect-model='Wed Oct 06 1976 03:00:00 GMT+0']")));
        softAssert.assertTrue(app.getUiboHelper().isElementPresent(By.xpath("//app-select-async[@ng-reflect-name='gender'] //span[contains(text(), 'F')]")));
        softAssert.assertTrue(app.getUiboHelper().isElementPresent(By.cssSelector("app-input[ng-reflect-name='email'] input[ng-reflect-model='vikarez20@gmail.com']")));
        softAssert.assertTrue(app.getUiboHelper().isElementPresent(By.xpath("//app-select-async[@ng-reflect-name='photoIdTypeId'] //span[contains(text(), 'Passport')]")), "Document type");
        softAssert.assertTrue(app.getUiboHelper().isElementPresent(By.cssSelector("app-input[ng-reflect-name='identifyCode']")), "Pesel");
        softAssert.assertTrue(app.getUiboHelper().isElementPresent(By.cssSelector("app-input[ng-reflect-name='photoIdNo'] input[ng-reflect-model='CGH164279']")), "Doc serial number");
        softAssert.assertTrue(app.getUiboHelper().isElementPresent(By.xpath("//app-select-async[@ng-reflect-name='photoIdCountryId'] //span[contains(text(), 'Aland Islands')]")), "Doc country of issue");
        softAssert.assertTrue(app.getUiboHelper().isElementPresent(By.cssSelector("app-input[ng-reflect-name='mailingStreetLine1']")));
        softAssert.assertTrue(app.getUiboHelper().isElementPresent(By.cssSelector("app-input[ng-reflect-name='mailingStreetLine2']")));
        softAssert.assertTrue(app.getUiboHelper().isElementPresent(By.cssSelector("app-input[ng-reflect-name='mailingCity'] input[ng-reflect-model='City']")));
        softAssert.assertTrue(app.getUiboHelper().isElementPresent(By.xpath("//app-select-async[@ng-reflect-name='mailingCountry'] //span[contains(text(), 'Austria')]")), "Country");
        softAssert.assertTrue(app.getUiboHelper().isElementPresent(By.cssSelector("app-input[ng-reflect-name='mailingPostcode'] input[ng-reflect-model='11-11']")));
        softAssert.assertTrue(app.getUiboHelper().areButtonsPresent(new String[]{"//p-button[@ng-reflect-label='Save']"}));
        softAssert.assertAll();
    }
}