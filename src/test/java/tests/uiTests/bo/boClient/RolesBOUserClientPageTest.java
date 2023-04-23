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
        softAssert.assertFalse(!app.getUiboHelper().isElementPresent(By.xpath("//span[contains(text(), 'Client')]")));
        softAssert.assertFalse(!app.getUiboHelper().isElementPresent(By.xpath("//span[contains(text(), 'Card')]")));
        softAssert.assertTrue(app.getUiboHelper().isDefault2(By.id("p-tabpanel-0-label")));

        softAssert = app.getUiboClientHelper().verifySearchFields();

        app.getUiboHelper().search("id", clientId, phone);

        softAssert.assertFalse(!app.getUiboHelper().isElementPresent(By.cssSelector("td span[ng-reflect-text='"+phone+"']")), "phone");
        softAssert.assertFalse(!app.getUiboHelper().isElementPresent(By.cssSelector("td span[ng-reflect-text='vikarez20@gmail.com']")), "email");

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

        softAssert.assertFalse(!app.getUiboHelper().areElementsPresent(new String[]{
                "//a[@role='tab'] //span[contains(text(), 'Tiles')]", "//a[@role='tab'] //span[contains(text(), 'Messages')]", "//a[@role='tab'] //span[contains(text(), 'Client iban')]",
                "//a[@role='tab'] //span[contains(text(), 'Payee')]", "//a[@role='tab'] //span[contains(text(), 'Selfie')]", "//a[@role='tab'] //span[contains(text(), 'Docs')]",
                "//a[@role='tab'] //span[contains(text(), 'Accounts')]", "//a[@role='tab'] //span[contains(text(), '3rd party cards')]", "//a[@role='tab'] //span[contains(text(), 'Transaction')]",
                "//a[@role='tab'] //span[contains(text(), 'Tickets')]", "//a[@role='tab'] //span[contains(text(), 'Supervisor requests')]"}), "Tabs incorrect");

        softAssert.assertFalse(!app.getUiboHelper().areButtonsPresent(new String[]{"//p-button[@ng-reflect-label='Search']", "//p-button[@ng-reflect-label='Block client']", "//p-button[@ng-reflect-label='Ban client']",
                "//p-button[@ng-reflect-label='Forget client']", "//p-button[@ng-reflect-label='Change credentials']", "//p-button[@ng-reflect-label='Send statements']",
                "//p-button[@ng-reflect-label='Upload docs']", "//p-button[@ng-reflect-label='Upload selfies']", "//p-button[@ng-reflect-label='Transfer back']"}), "Buttons incorrect");
        softAssert.assertAll();
    }
}