package tests.uiTests.bo.boClient;

import base.UITestBase;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class RolesBOUserClientPageTabTilesTest extends UITestBase {
    String phone = "380634413376";
    String clientId = "33217";

    @Test()
    public void testRolesBOUserClientPageTabTiles() throws InterruptedException {
        gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        gotoSearchPage();
        search("id", clientId, phone);
        goToClientPage(phone);
        goToTilesTab();

        assertTrue(areElementsPresent(new String[]{"//table //th[contains(text(), 'Types')]", "//table //th[contains(text(), 'Messages')]"}));
    }
}