package tests.uiTests.bo.boUser;

import base.UITestBase;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;

public class LoginBOUserRolesCBOTest extends UITestBase {

    @Test
    public void testLoginBOUserRolesCBO() throws InterruptedException {
        app.getUiboHelper().gotoBOSiteAndLoginWithCBOUserRole(app.CBOuserLogin, app.CBOuserPass);

        assertFalse(!app.getUiboHelper().areElementsPresent(new String[]{"//p[contains(text(), 'Tickets')]",
                "//p[contains(text(), 'BO Users')]", "//p[contains(text(), 'Search')]",
                "//p[contains(text(), 'Operations')]", "//p[contains(text(), 'Reports')]"}));
    }
}