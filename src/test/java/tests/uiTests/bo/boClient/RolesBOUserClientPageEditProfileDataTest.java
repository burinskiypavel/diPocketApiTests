package tests.uiTests.bo.boClient;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class RolesBOUserClientPageEditProfileDataTest extends UITestBase {
    SoftAssert softAssert = new SoftAssert();
    String phone = "380633192217";

    @Test
    public void testRolesBOUserClientPageEditProfileData() throws InterruptedException {
        app.getUiboHelper().gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        app.getUiboHelper().gotoSearchPage();
        app.getUiboHelper().search("id", "33539", phone);
        app.getUiboHelper().goToClientPage(phone);
        app.getUiboHelper().pressEditProfileDataFromClientPage();

        softAssert.assertTrue(app.getUiboHelper().isElementPresent(By.cssSelector("input[id*='input_firstName_0']")), "First name");
        softAssert.assertTrue(app.getUiboHelper().isElementPresent(By.cssSelector("input[id*='input_lastName_1']")), "Surname");
        softAssert.assertTrue(app.getUiboHelper().isElementPresent(By.cssSelector("p-calendar[id*='calendar_birthDate_2']")), "Birthdate");
        softAssert.assertTrue(app.getUiboHelper().isElementPresent(By.cssSelector("p-dropdown[id*='select_gender_3']")), "Gender");
        softAssert.assertTrue(app.getUiboHelper().isElementPresent(By.cssSelector("app-input[ng-reflect-name='email']")), "email");
        softAssert.assertTrue(app.getUiboHelper().isElementPresent(By.cssSelector("p-dropdown[id*='select_photoIdTypeId_4']")), "Document type");
        softAssert.assertTrue(app.getUiboHelper().isElementPresent(By.cssSelector("input[id*='input_identifyCode_5']")), "ID code, Pesel");
        softAssert.assertTrue(app.getUiboHelper().isElementPresent(By.cssSelector("input[id*='input_photoIdNo_6']")), "Doc serial number");
        softAssert.assertTrue(app.getUiboHelper().isElementPresent(By.cssSelector("p-dropdown[id*='select_photoIdCountryId_7']")), "Doc country of issue");
        softAssert.assertTrue(app.getUiboHelper().isElementPresent(By.cssSelector("input[id*='_input_mailingStreetLine1_']")), "Mailing street line 1");
        softAssert.assertTrue(app.getUiboHelper().isElementPresent(By.cssSelector("input[id*='_input_mailingStreetLine2_']")), "Mailing street line 2");
        softAssert.assertTrue(app.getUiboHelper().isElementPresent(By.cssSelector("input[id*='_input_mailingCity_']")), "Mailing City");
        softAssert.assertTrue(app.getUiboHelper().isElementPresent(By.cssSelector("p-dropdown[id*='_select_mailingCountryId_']")), "Country");
        softAssert.assertTrue(app.getUiboHelper().isElementPresent(By.cssSelector("input[id*='_input_mailingPostcode_']")), "Postcode");
        softAssert.assertTrue(app.getUiboHelper().areButtonsPresent(new String[]{"//p-button[@ng-reflect-label='Save']"}));
        softAssert.assertAll();
    }
}