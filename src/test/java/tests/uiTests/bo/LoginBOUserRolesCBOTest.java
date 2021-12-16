package tests.uiTests.bo;

import base.UITestBase;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;

public class LoginBOUserRolesCBOTest extends UITestBase {

    @Test
    public void testLoginBOUserRolesCBO() throws InterruptedException {
        gotoBOSiteAndLoginWithCBOUserRole("Viktoria", "kWmaB0s");

        assertFalse(!areElementsPresent(new String[]{"//p[contains(text(), 'Tickets')]",
                "//p[contains(text(), 'BO Users')]", "//p[contains(text(), 'Search')]",
                "//p[contains(text(), 'Operations')]", "//p[contains(text(), 'Reports')]"}));
    }
}
