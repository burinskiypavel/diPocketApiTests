package tests.uiTests.bo.boClient;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class RolesBOUserClientPageTest extends UITestBase {
    SoftAssert softAssert = new SoftAssert();
    String clientId = "33217";
    String phone = "380634413376";

    @Test
    public void testRolesBOUserClientPage() throws InterruptedException {
        app.getUiboHelper().gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        app.getUiboHelper().gotoSearchPage();
        app.getUiboClientHelper().virifyTabsOnSerchPage();
        softAssert.assertTrue(app.getUiboHelper().isDefault2(By.id("p-tabpanel-0-label")));
        softAssert = app.getUiboClientHelper().verifySearchFields();
        app.getUiboHelper().search("id", clientId, phone);
        softAssert = app.getUiboClientHelper().verifyClientSearchResult(phone, "vikarez20@gmail.com");
        app.getUiboClientHelper().goToClientPage(phone);
        softAssert.assertAll();
    }

    @Test
    public void testRolesBOUserVerifyClientInfoOnClientPage() throws InterruptedException {
        app.getUiboHelper().gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        app.getUiboHelper().gotoSearchPage();
        app.getUiboHelper().search("id", clientId, phone);
        app.getUiboClientHelper().goToClientPage(phone);

        String actualUsername = app.getUiboHelper().getText(By.cssSelector("p.user-name"));
        String actualEmail = app.getUiboHelper().getText(By.cssSelector("p.email"));

        String actualState = app.getUiboHelper().getText(By.xpath("//*[contains(text(), 'State:')]"));
        String actualSite = app.getUiboHelper().getText(By.xpath("//*[contains(text(), 'Site:')]"));

        String actualRisk = app.getUiboHelper().getText(By.xpath("//*[contains(text(), 'Risk')]"));
        String actualRegistryAdd = app.getUiboHelper().getText(By.xpath("//*[contains(text(), 'Registry add:')]"));
        String actualMailingAdd = app.getUiboHelper().getText(By.xpath("//*[contains(text(), 'Mailing add:')]"));

        softAssert.assertFalse(!app.getUiboHelper().areElementsPresent(new String[]{
                "//*[contains(text(), '06.10.1976')]", "//*[contains(text(), '380634413376')]", "//*[contains(text(), '33217')]",
                "//*[contains(text(), 'FDD')]", "//*[contains(text(), 'EUR - standart')]", "//*[contains(text(), 'EUR')]",
                "//*[contains(text(), 'Ukrainian')]",}));

        softAssert.assertEquals(actualUsername, "Nona Qwerty");
        softAssert.assertEquals(actualEmail, "vikarez20@gmail.com (verified)");
        softAssert.assertEquals(actualState, "State: Active");
        softAssert.assertEquals(actualSite, "Site: DIPOCKET");
        softAssert.assertEquals(actualRisk, "Risk: 3");
        softAssert.assertEquals(actualRegistryAdd, "Registry add: Address44, City, UA");
        softAssert.assertEquals(actualMailingAdd, "Mailing add: Address, City, AT");
        softAssert.assertAll();
    }

    @Test
    public void testRolesBOUserVerifyButtonsAndTabsOnClientPage() throws InterruptedException {
        app.getUiboHelper().gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        app.getUiboHelper().gotoSearchPage();
        app.getUiboHelper().search("id", clientId, phone);
        app.getUiboClientHelper().goToClientPage(phone);

        softAssert = app.getUiboClientHelper().verifyTabs();
        softAssert = app.getUiboClientHelper().virifyButtons();
        softAssert.assertAll();
    }
}