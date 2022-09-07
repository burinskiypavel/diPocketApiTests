package tests.uiTests.bo.boClient;

import base.UITestBase;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class RolesBOUserClientPageTabTilesTest extends UITestBase {
    String phone = "380634413376";
    String clientId = "33217";

    @Test()
    public void testRolesBOUserClientPageTabTiles() throws InterruptedException {
        app.getUiboHelper().gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        app.getUiboHelper().gotoSearchPage();
        app.getUiboHelper().search("id", clientId, phone);
        app.getUiboClientHelper().goToClientPage(phone);
        app.getUiboClientHelper().goToTilesTab();

        assertTrue(app.getUiboHelper().areElementsPresent(new String[]{"//table //th[contains(text(), 'Types')]", "//table //th[contains(text(), 'Messages')]"}));
    }
}