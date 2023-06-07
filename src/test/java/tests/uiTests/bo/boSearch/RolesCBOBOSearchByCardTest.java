package tests.uiTests.bo.boSearch;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class RolesCBOBOSearchByCardTest extends UITestBase {
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void testRolesBOSearchByClientClientID() throws InterruptedException {
        app.getUiboHelper().gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        app.getUiboHelper().gotoSearchPage();
        softAssert.assertFalse(!app.getUiboHelper().isElementPresent(By.xpath("//span[contains(text(), 'Client')]")));
        softAssert.assertFalse(!app.getUiboHelper().isElementPresent(By.xpath("//span[contains(text(), 'Card')]")));
        app.getUiboHelper().gotoCardSearchTab();

        softAssert.assertFalse(!app.getUiboHelper().areElementsPresent(new String[]{
                "//p-tabpanel[@header='Card'] //input[contains(@id, 'input_id')]", "//p-tabpanel[@header='Card'] //input[contains(@id, 'input_publicToken')]",
                "//p-tabpanel[@header='Card'] //input[contains(@id, 'input_dipToken')]", "//p-tabpanel[@header='Card'] //input[contains(@id, 'input_pan')]",
                "//p-tabpanel[@header='Card'] //input[contains(@id, 'input_clientId')]", "//p-tabpanel[@header='Card'] //input[contains(@id, 'input_cardholderName')]",}));

        softAssert.assertAll();
    }

    @Test
    public void testRolesCBOSearchByClientClientID() throws InterruptedException {
        app.getUiboHelper().gotoBOSiteAndLoginWithCBOUserRole(app.CBOuserLogin, app.CBOuserPass);
        app.getUiboHelper().gotoSearchPage();
        softAssert.assertFalse(!app.getUiboHelper().isElementPresent(By.xpath("//span[contains(text(), 'Client')]")));
        softAssert.assertFalse(!app.getUiboHelper().isElementPresent(By.xpath("//span[contains(text(), 'Card')]")));
        app.getUiboHelper().gotoCardSearchTab();

        softAssert.assertFalse(!app.getUiboHelper().areElementsPresent(new String[]{
                "//p-tabpanel[@header='Card'] //input[contains(@id, 'input_id')]", "//p-tabpanel[@header='Card'] //input[contains(@id, 'input_publicToken')]",
                "//p-tabpanel[@header='Card'] //input[contains(@id, 'input_dipToken')]", "//p-tabpanel[@header='Card'] //input[contains(@id, 'input_pan')]",
                "//p-tabpanel[@header='Card'] //input[contains(@id, 'input_clientId')]", "//p-tabpanel[@header='Card'] //input[contains(@id, 'input_cardholderName')]",}));

        softAssert.assertAll();
    }
}