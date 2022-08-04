package tests.uiTests.bo.boClient;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class RolesBOUserClientPageEditProfileDataTest extends UITestBase {
    SoftAssert softAssert = new SoftAssert();
    String phone = "380685448615";

    @Test
    public void testRolesBOUserClientPageEditProfileData() throws InterruptedException {
        app.getUiboHelper().gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        app.getUiboHelper().gotoSearchPage();
        app.getUiboHelper().search("id", "34067", phone);
        app.getUiboHelper().goToClientPage(phone);
        app.getUiboHelper().pressEditProfileDataFromClientPage();

        softAssert.assertTrue(app.getUiboHelper().isElementPresent(By.cssSelector("input#formly_21_input_firstName_0")), "First name");
        softAssert.assertTrue(app.getUiboHelper().isElementPresent(By.cssSelector("input#formly_21_input_lastName_1")), "Surname");
        softAssert.assertTrue(app.getUiboHelper().isElementPresent(By.cssSelector("p-calendar[id='formly_21_calendar_birthDate_2']")), "Birthdate");
        softAssert.assertTrue(app.getUiboHelper().isElementPresent(By.xpath("//p-dropdown[@id='formly_21_select_gender_3'] //span[contains(text(), 'F')]")), "Gender");
        softAssert.assertTrue(app.getUiboHelper().isElementPresent(By.cssSelector("app-input[ng-reflect-name='email'] input[ng-reflect-model='vikarez20@gmail.com']")), "email");
        softAssert.assertTrue(app.getUiboHelper().isElementPresent(By.xpath("//p-dropdown[@id='formly_21_select_photoIdTypeId_4'] //span[contains(text(), 'Passport')]")), "Document type");
        softAssert.assertTrue(app.getUiboHelper().isElementPresent(By.cssSelector("input[id='formly_21_input_identifyCode_5']")), "ID code, Pesel");
        softAssert.assertTrue(app.getUiboHelper().isElementPresent(By.cssSelector("input[id='formly_21_input_photoIdNo_6']")), "Doc serial number");
        softAssert.assertTrue(app.getUiboHelper().isElementPresent(By.xpath("//p-dropdown[@id='formly_21_select_photoIdCountryId_7'] //span[contains(text(), 'Aland Islands')]")), "Doc country of issue");
        softAssert.assertTrue(app.getUiboHelper().isElementPresent(By.cssSelector("#formly_21_input_mailingStreetLine1_9")), "Mailing street line 1");
        softAssert.assertTrue(app.getUiboHelper().isElementPresent(By.cssSelector("#formly_21_input_mailingStreetLine2_10")), "Mailing street line 2");
        softAssert.assertTrue(app.getUiboHelper().isElementPresent(By.cssSelector("#formly_21_input_mailingCity_11")), "Mailing City");
        softAssert.assertTrue(app.getUiboHelper().isElementPresent(By.cssSelector("#formly_21_select_mailingCountryId_12")), "Country");
        softAssert.assertTrue(app.getUiboHelper().isElementPresent(By.cssSelector("input#formly_21_input_mailingPostcode_13")), "Postcode");
        softAssert.assertTrue(app.getUiboHelper().areButtonsPresent(new String[]{"//p-button[@ng-reflect-label='Save']"}));
        softAssert.assertAll();
    }
}