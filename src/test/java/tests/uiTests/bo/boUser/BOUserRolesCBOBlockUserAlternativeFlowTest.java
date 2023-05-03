package tests.uiTests.bo.boUser;

import base.UITestBase;
import org.testng.annotations.Test;

public class BOUserRolesCBOBlockUserAlternativeFlowTest extends UITestBase {

    @Test
    public void testBOUserRolesCBOBlockUserAlternativeFlow() throws InterruptedException {
        app.getUiboHelper().gotoBOSiteAndLoginWithCBOUserRole(app.CBOuserLogin, app.CBOuserPass);
        app.getUiboHelper().gotoBOUsersPage();
        app.getUiboUserHelper().gotoAllUsersTab();
        app.getUiboUserHelper().searchAndSelectBOUser("All users", "username", "PAVELB");
        app.getUiboUserHelper().pressBlockUser();
        app.getUiboUserHelper().closePopUpAndVirifyPopUpClosing();
    }
}