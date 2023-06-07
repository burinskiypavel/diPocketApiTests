package tests.uiTests.bo.boSearch;

import base.UITestBase;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class RolesCBOBOSearchByCardTest extends UITestBase {
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void testRolesBOSearchByClientClientID() throws InterruptedException {
        app.getUiboHelper().gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        app.getUiboHelper().gotoSearchPage();
        softAssert = app.getUiboCardHelper().verifyClientAndCardTabsPresent(softAssert);
        app.getUiboHelper().gotoCardSearchTab();
        softAssert = app.getUiboCardHelper().verifyCardSearchInputFields2(softAssert);
        softAssert.assertAll();
    }

    @Test
    public void testRolesCBOSearchByClientClientID() throws InterruptedException {
        app.getUiboHelper().gotoBOSiteAndLoginWithCBOUserRole(app.CBOuserLogin, app.CBOuserPass);
        app.getUiboHelper().gotoSearchPage();
        softAssert = app.getUiboCardHelper().verifyClientAndCardTabsPresent(softAssert);
        app.getUiboHelper().gotoCardSearchTab();
        softAssert = app.getUiboCardHelper().verifyCardSearchInputFields2(softAssert);
        softAssert.assertAll();
    }
}