package tests.uiTests.bo.boClient;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class RolesBOUserClientPageTab3rdPartyCardsTest extends UITestBase {
    String phone = "380634413376";
    String clientId = "33217";

    @Test
    public void testRolesBOUserClientPageTab3rdPartyCards() throws InterruptedException {
        gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        gotoSearchPage();
        search("id", clientId, phone);
        goToClientPage(phone);
        goTo3rdPartyCardsTab();
        waitFor(By.xpath("//thead //th[contains(text(), 'Card name')]"));

        assertTrue(areElementsPresent(new String[]{
                "//thead //th[contains(text(), 'Card name')]", "//thead //th[contains(text(), 'State')]",
                "//thead //th[contains(text(), 'CCY')]", "//thead //th[contains(text(), 'Cardholder name')]",
                "//thead //th[contains(text(), 'Registration date')]", "//thead //th[contains(text(), 'Card number')]",
                "//thead //th[contains(text(), 'Card type')]", "//thead //th[contains(text(), '3DS Check')]",
                "//thead //th[contains(text(), 'AVS Check')]"}));
    }
}