package tests.uiTests.bo.boClient;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class RolesBOUserClientPageEditProfileDataTest extends UITestBase {
    SoftAssert softAssert = new SoftAssert();
    String phone = "380633192217";
    String randomNumber = app.generateRandomNumber(3);
    String id = "33539";

    @Test
    public void testRolesBOUserClientPageEditProfileData_VirifyEditProfileFields() throws InterruptedException {
        app.getUiboHelper().gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        app.getUiboHelper().gotoSearchPage();
        app.getUiboHelper().search("id", id, phone);
        app.getUiboHelper().goToClientPage(phone);
        app.getUiboHelper().pressEditProfileDataFromClientPage();

        softAssert.assertTrue(app.getUiboHelper().isElementPresent(By.cssSelector("input[id*='input_firstName']")), "First name");
        softAssert.assertTrue(app.getUiboHelper().isElementPresent(By.cssSelector("input[id*='input_lastName']")), "Surname");
        softAssert.assertTrue(app.getUiboHelper().isElementPresent(By.cssSelector("p-calendar[id*='calendar_birthDate']")), "Birthdate");
        softAssert.assertTrue(app.getUiboHelper().isElementPresent(By.cssSelector("p-dropdown[id*='select_gender']")), "Gender");
        softAssert.assertTrue(app.getUiboHelper().isElementPresent(By.cssSelector("input[id*='_input_email_']")), "email");
        softAssert.assertTrue(app.getUiboHelper().isElementPresent(By.cssSelector("p-dropdown[id*='select_photoIdTypeId']")), "Document type");
        softAssert.assertTrue(app.getUiboHelper().isElementPresent(By.cssSelector("input[id*='input_identifyCode']")), "ID code, Pesel");
        softAssert.assertTrue(app.getUiboHelper().isElementPresent(By.cssSelector("input[id*='input_photoIdNo']")), "Doc serial number");
        softAssert.assertTrue(app.getUiboHelper().isElementPresent(By.cssSelector("p-dropdown[id*='select_photoIdCountryId_']")), "Doc country of issue");
        softAssert.assertTrue(app.getUiboHelper().isElementPresent(By.cssSelector("input[id*='_input_mailingStreetLine1_']")), "Mailing street line 1");
        softAssert.assertTrue(app.getUiboHelper().isElementPresent(By.cssSelector("input[id*='_input_mailingStreetLine2_']")), "Mailing street line 2");
        softAssert.assertTrue(app.getUiboHelper().isElementPresent(By.cssSelector("input[id*='_input_mailingCity_']")), "Mailing City");
        softAssert.assertTrue(app.getUiboHelper().isElementPresent(By.cssSelector("p-dropdown[id*='_select_mailingCountryId_']")), "Country");
        softAssert.assertTrue(app.getUiboHelper().isElementPresent(By.cssSelector("input[id*='_input_mailingPostcode_']")), "Postcode");
        softAssert.assertTrue(app.getUiboHelper().areButtonsPresent(new String[]{"//p-button[@ng-reflect-label='Save']"}));
        softAssert.assertAll();
    }

    @Test
    public void testRolesBOUserClientPageEditProfileData() throws InterruptedException {
        app.getUiboHelper().gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        app.getUiboHelper().gotoSearchPage();
        app.getUiboHelper().search("id", id, phone);
        app.getUiboHelper().goToClientPage(phone);
        app.getUiboHelper().pressEditProfileDataFromClientPage();

        app.getUiboHelper().editProfileData("Pavel" + randomNumber, "Burinsky" + randomNumber, "Main str" + randomNumber, "Main str" + randomNumber, "City" + randomNumber, "30-000" + randomNumber);

        app.getUiboHelper().waitFor(By.xpath("//div[contains(text(), 'Client data updated successfully')]"));
    }
}